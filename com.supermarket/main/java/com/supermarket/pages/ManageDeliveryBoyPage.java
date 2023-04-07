package com.supermarket.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class ManageDeliveryBoyPage {

	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	WaitUtility wuObj;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;

	@FindBy(xpath = "//input[@id='name']")
	WebElement name;

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;

	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	WebElement address;

	@FindBy(xpath = "//input[@placeholder='Enter the Username']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	//@FindBy(xpath = "//button[@type='submit']")
	//@FindBy(xpath = "//button[@class='btn btn-danger']")
	@FindBy(xpath = "//input[@id='password']//following::div//button")
	WebElement saveBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;

	@FindBy(xpath = "//input[@id='un']")
	WebElement nameInSearchWindow;

	@FindBy(xpath = "//input[@id='ut']")
	WebElement emailInSearchWindow;

	@FindBy(xpath = "//input[@id='ph']")
	WebElement phoneNoInSearchWindow;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchBtnInSearchWindow;

	@FindBy(xpath = "/table[@class='table table-bordered table-hover table-sm']//tbody//td//span[@id='res']")
	List<WebElement> searchResultNotFound;

	@FindBy(xpath = "//a[@class='btn btn-default btn-fix' and text()='Reset']")
	WebElement resetBtnInSearchWindow;

	@FindBy(xpath = "//div[@class='card-header']//h4[text()='List Delivery Boy']")
	WebElement listDeliveryBoyHeading;

	//@FindBy(xpath = "//button[@name='update']")
	//@FindBy(xpath = "//button[@class='btn btn-danger']")
	@FindBy(xpath = "//input[@id='password']//following::div//button")
	WebElement updateBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	WebElement table;

	@FindBy(xpath = "//div[@class='card-header']//h4[text()='List Delivery Boy']")
	WebElement titleOfTable;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	WebElement nameInSearchResult;
	
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

	public void enterName(String nameToEnter) throws IOException {
		wuObj.waitUntilTheElementIsClickable(name);
		guObj.clearCommand(name);
		guObj.sendKeysForElement(name, nameToEnter, driver);
	}

	public void enterEmail(String emailToEnter) {
		wuObj.waitUntilTheElementIsClickable(email);
		guObj.clearCommand(email);
		guObj.sendKeysForElement(email, emailToEnter, driver);

	}

	public void enterPhoneNo(String phoneToEnter) {
		wuObj.waitUntilTheElementIsClickable(phone);
		guObj.clearCommand(phone);
		guObj.sendKeysForElement(phone, phoneToEnter, driver);
	}

	public void address(String addressToEnter) {
		wuObj.waitUntilTheElementIsClickable(address);
		guObj.clearCommand(address);
		guObj.sendKeysForElement(address, addressToEnter, driver);
	}

	public void enterUsername(String userNameToEnter) throws AWTException {
		wuObj.waitUntilTheElementIsClickable(userName);
		guObj.clearCommand(userName);
		guObj.sendKeysForElement(userName, userNameToEnter, driver);

	}

	public void enterPassword(String passwordToEnter) throws InterruptedException, AWTException {
		guObj.scrollTillBottom(driver);
		wuObj.waitUntilTheElementIsClickable(password);
		guObj.clickCommand(password);
		guObj.clearCommand(password);
		guObj.sendKeysForElement(password, passwordToEnter, driver);

	}

	public void clickSaveBtn() throws AWTException, InterruptedException {
		wuObj.waitUntilTheElementIsClickable(saveBtn);
		guObj.clickTheElement(saveBtn,driver);
	}

	public boolean isSuccessMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		String successMsgDisplayed = successMsg.getText();
		if (successMsgDisplayed.contains(Constants.expectedAddDeliveryBoySuccessMsg)) {
			return true;
		}
		return false;

	}

	public void clickSearchBtn() {
		wuObj.waitUntilTheElementIsClickable(searchBtn);
		guObj.clickTheElement(searchBtn, driver);

	}

	public void enterNameInSearchWindow(String nameToEnter) {
		wuObj.waitUntilTheElementIsClickable(nameInSearchWindow);
		guObj.clearCommand(nameInSearchWindow);
		guObj.sendKeysForElement(nameInSearchWindow, nameToEnter, driver);

	}

	public void enterEmailInSearchWindow(String emailToEnter) {
		wuObj.waitUntilTheElementIsClickable(emailInSearchWindow);
		guObj.clearCommand(emailInSearchWindow);
		guObj.sendKeysForElement(emailInSearchWindow, emailToEnter, driver);
	}

	public void enterPhoneNoInSearchWindow(String phoneNoToEnter) {
		wuObj.waitUntilTheElementIsClickable(phoneNoInSearchWindow);
		guObj.clearCommand(phoneNoInSearchWindow);
		guObj.sendKeysForElement(phoneNoInSearchWindow, phoneNoToEnter, driver);
	}

	public void clickSearchBtnInSearchWindow() throws AWTException, InterruptedException {
		wuObj.waitUntilTheElementIsClickable(phoneNoInSearchWindow);
		guObj.clickCommand(phoneNoInSearchWindow);
		wuObj.waitUntilTheElementIsClickable(searchBtnInSearchWindow);
		guObj.clickCommand(searchBtnInSearchWindow);
	}

	public void clickResetBtnInSearchWindow() throws AWTException, InterruptedException {
		wuObj.waitUntilTheElementIsClickable(resetBtnInSearchWindow);
		guObj.clickCommand(resetBtnInSearchWindow);
	}

	public String getTitleOfTable() {
		wuObj.waitUntilTheElementIsVisible(titleOfTable);
		String title = titleOfTable.getText();
		return title;
	}

	public String getNameInSearchResult() throws InterruptedException {
		wuObj.waitUntilTheElementIsVisible(nameInSearchResult);
		String name = nameInSearchResult.getText();
		return name;
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
			throw new Exception("This Delivery Boy does not exist in the table, so cannot Edit Details...");
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
		guObj.clickTheElement(updateBtn, driver);
	
	}

	public boolean isUpdateSuccessMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		String successMsgDisplayed = successMsg.getText();
		if (successMsgDisplayed.contains(Constants.expectedUpdateDeliveryBoySuccessMsg)) {
			return true;
		}
		return false;
	}

	public boolean isDeleteSuccessMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		String successMsgDisplayed = successMsg.getText();
		if (successMsgDisplayed.contains(Constants.expectedDeleteDeliveryBoySuccessMsg)) {
			return true;
		}
		return false;
	}

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		wuObj = new WaitUtility(driver);
		PageFactory.initElements(driver, this);

	}

}
