package com.supermarket.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class AdminUsersPage {

	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	WaitUtility wuObj;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetBtn;

	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateBtn;

	@FindBy(xpath = "//div[@class='card-header']//h4[text()='Admin Users']")
	WebElement adminUsersHeadingText;

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userType;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;

	@FindBy(xpath = "//input[@id='un']")
	WebElement userNameInSearchWindow;

	@FindBy(xpath = "//select[@id='ut']")
	WebElement userTypeInSearchWindow;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchBtnInSearchWindow;

	@FindBy(xpath = "//div[@class='card-header']//h4[text()='Admin Users']")
	WebElement titleOfTable;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	WebElement userNameInSearchResult;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
	List<WebElement> allRows;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> allUserNames;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//button")
	WebElement closeBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//following-sibling::a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//following-sibling::a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteBtn;

	public void clickNewBtn() {
		wuObj.waitUntilTheElementIsClickable(newBtn);
		guObj.clickTheElement(newBtn, driver);
	}

	public void enterUserName(String usernameToEnter) {
		wuObj.waitUntilTheElementIsClickable(username);
		guObj.clearCommand(username);
		guObj.sendKeysForElement(username, usernameToEnter, driver);
	}

	public void enterPassword(String passwordToEnter) {
		wuObj.waitUntilTheElementIsClickable(password);
		guObj.clearCommand(password);
		guObj.sendKeysForElement(password, passwordToEnter, driver);
	}

	public void selectUserType(String userTypeToEnter) {
		guObj.selectByVisibleText(userType, userTypeToEnter);

	}

	public void clickSaveBtn() throws AWTException, InterruptedException {
		wuObj.waitUntilTheElementIsClickable(saveBtn);
		guObj.clickCommand(saveBtn);
	}

	public void clickSearchBtn() throws AWTException, InterruptedException {
		wuObj.waitUntilTheElementIsClickable(searchBtn);
		guObj.clickCommand(searchBtn);

	}

	public boolean isSuccessMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		String successMsgDisplayed = successMsg.getText();
		if (successMsgDisplayed.contains(Constants.expectedAddNewAdminUserSuccessMsg)) {
			return true;
		}
		return false;
	}

	public void enterUserNameInSearchWindow(String userNameToEnter) {
		wuObj.waitUntilTheElementIsClickable(userNameInSearchWindow);
		guObj.clearCommand(userNameInSearchWindow);
		guObj.sendKeysForElement(userNameInSearchWindow, userNameToEnter, driver);
	}

	public void selectUserTypeInSearchWindow(String userTypeToEnter) {
		guObj.selectByVisibleText(userTypeInSearchWindow, userTypeToEnter);
	}

	public void clickSearchBtnInSearchWindow() throws InterruptedException {
		wuObj.waitUntilTheElementIsClickable(searchBtnInSearchWindow);
		guObj.clickTheElement(searchBtnInSearchWindow, driver);
	}

	public void clickResetBtn() throws AWTException, InterruptedException {
		wuObj.waitUntilTheElementIsClickable(resetBtn);
		guObj.clickCommand(resetBtn);

	}

	public String getTitleOfTable() {
		wuObj.waitUntilTheElementIsVisible(titleOfTable);
		String title = titleOfTable.getText();
		return title;
	}

	public String getuserNameInSearchResult() {
		wuObj.waitUntilTheElementIsVisible(userNameInSearchResult);
		String userName = userNameInSearchResult.getText();
		return userName;
	}

	public void clickCloseBtn() {
		wuObj.waitUntilTheElementIsClickable(closeBtn);
		guObj.clickCommand(closeBtn);
	}

	public void clickEditBtnOfUser(String userName) throws Exception {

		boolean flag = false;
		for (int i = 0; i < allUserNames.size(); i++) {
			String value = allUserNames.get(i).getText();

			if (value.contains(userName)) {
				guObj.scrollToTheElement(editBtn, driver);
				wuObj.waitUntilTheElementIsClickable(editBtn);
				guObj.clickCommand(editBtn);
				flag = true;
				break;
			}
		}

		if (flag == false) {
			throw new Exception("This Admin user does not exist in the table, so cannot Edit Details...");
		}

	}

	public void clickDeleteBtnOfUser(String userName) throws Exception {

		boolean flag = false;
		for (int i = 0; i < allUserNames.size(); i++) {
			String value = allUserNames.get(i).getText();

			if (value.contains(userName)) {
				guObj.scrollToTheElement(deleteBtn, driver);
				wuObj.waitUntilTheElementIsClickable(deleteBtn);
				guObj.clickCommand(deleteBtn);
				flag = true;
				break;
			}
		}

		if (flag == false) {
			throw new Exception("This Admin user does not exist in the table, so cannot Delete User...");
		}
	}

	public void clickOkFromAlert() throws AWTException, InterruptedException {
		wuObj.waitUntilTheAlertIsPresent();
		driver.switchTo().alert().accept();
	}

	public void clickUpdateBtn() throws AWTException, InterruptedException {
		wuObj.waitUntilTheElementIsClickable(updateBtn);
		guObj.clickCommand(updateBtn);

	}

	public boolean isUpdateSuccessMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		String successMsgDisplayed = successMsg.getText();
		if (successMsgDisplayed.contains(Constants.expectedUpdateAdminUserSuccessMsg)) {
			return true;
		}
		return false;
	}

	public boolean isDeleteSuccessMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		String successMsgDisplayed = successMsg.getText();
		if (successMsgDisplayed.contains(Constants.expectedDeleteAdminUserSuccessMsg)) {
			return true;
		}
		return false;
	}

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		wuObj = new WaitUtility(driver);
		PageFactory.initElements(driver, this);

	}

}
