package com.supermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.FileUploadUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class MobileSliderPage {

	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	FileUploadUtility fuObj = new FileUploadUtility();
	WaitUtility wuObj;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;

	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement selectCategory;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;

	@FindBy(xpath = "//button[@name='create']")
	WebElement saveBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;

	@FindBy(xpath = "//button[@class='btn btn-danger']/following::a[1]")
	WebElement cancelBtn;

	@FindBy(xpath = "//div[@class='card-header']/h4")
	WebElement titleOfTable;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	WebElement table;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]")
	WebElement firstRow;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]")
	WebElement firstRowDynamicXpath;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[2]")
	WebElement secondColumn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[2]//a")
	WebElement status;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[2]//a//span[text()='Active']")
	WebElement activeStatus;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[2]//a//span[text()='Inactive']")
	WebElement inactiveStatus;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]//a//span[text()='Active']")
	List<WebElement> allActiveStatus;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]//a//span[text()='Inactive']")
	List<WebElement> allInactiveStatus;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[3]//a//i[@class='fas fa-edit']")
	WebElement editBtn;

	@FindBy(xpath = "//button[@name='update']")
	WebElement updateBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[3]//a//i[@class='fas fa-trash-alt']")
	WebElement deleteBtn;

	@FindBy(xpath = "//a[@aria-label='Last']")
	WebElement footerLastBtn;

	@FindBy(xpath = "//a[@aria-label='First']")
	WebElement footerFirstBtn;

	public void clickNewBtn() {
		wuObj.waitUntilTheElementIsClickable(newBtn);
		guObj.clickCommand(newBtn);
	}

	public void selectCategory(String category) {
		guObj.selectByVisibleText(selectCategory, category);

	}

	public void uploadFile(String fileName) {
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\uploadFiles\\" + fileName;
		fuObj.uploadFile(chooseFile, path);
	}

	public void saveItem() {
		wuObj.waitUntilTheElementIsClickable(saveBtn);
		guObj.clickCommand(saveBtn);
	}

	public String successMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		String successMsgDisplayed = successMsg.getText();
		return successMsgDisplayed;

	}

	public boolean isUpdateMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		String actualMsg = successMsg.getText();
		if (actualMsg.contains(Constants.updateMobileSliderExpectedMsg)) {
			return true;
		}

		return false;
	}

	public boolean isDeleteMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		String actualMsg = successMsg.getText();
		if (actualMsg.contains(Constants.deleteMobileSliderExpectedMsg)) {
			return true;
		}

		return false;
	}

	public void cancelCreation() {
		wuObj.waitUntilTheElementIsClickable(cancelBtn);
		guObj.clickCommand(cancelBtn);
	}

	public String getTitleOfTable() {
		wuObj.waitUntilTheElementIsVisible(titleOfTable);
		String title = titleOfTable.getText();
		return title;

	}

	public void changeToActiveStatus() throws Exception {

		boolean flag = false;
		if (!allInactiveStatus.isEmpty()) {
			for (int i = 0; i < allInactiveStatus.size(); i++) {
				String value = allInactiveStatus.get(i).getText();
				if (value.equals("Inactive")) {
					guObj.scrollToTheElement(inactiveStatus, driver);
					wuObj.waitUntilTheElementIsClickable(inactiveStatus);
					wuObj.waitUntilTheElementIsClickable(activeStatus);
					wuObj.waitUntilTheElementIsClickable(activeStatus);
					wuObj.waitUntilTheElementIsClickable(activeStatus);
					guObj.clickCommand(inactiveStatus);
					flag = true;
					break;
				}
			}
		}
		if (flag == false) {
			throw new Exception(
					"This table does not contain a mobile slider with status as Inactive, so cannot change its status to Active...");
		}

	}

	public void changeToInActiveStatus() throws Exception {

		boolean flag = false;
		if (!allActiveStatus.isEmpty()) {
			for (int i = 0; i < allActiveStatus.size(); i++) {
				String value = allActiveStatus.get(i).getText();
				if (value.equals("Active")) {
					guObj.scrollToTheElement(activeStatus, driver);
					wuObj.waitUntilTheElementIsClickable(activeStatus);
					wuObj.waitUntilTheElementIsClickable(activeStatus);
					wuObj.waitUntilTheElementIsClickable(activeStatus);
					wuObj.waitUntilTheElementIsClickable(activeStatus);
					guObj.clickCommand(activeStatus);
					flag = true;
					break;
				}
			}
		}
		if (flag == false) {
			throw new Exception(
					"This table does not contain a mobile slider with status as Active, so cannot change its status to Inactive...");
		}

	}

	public String checkActiveStatus() {
		wuObj.waitUntilTheElementIsVisible(activeStatus);
		String isActive = activeStatus.getText();
		return isActive;

	}

	public String checkInactiveStatus() {
		wuObj.waitUntilTheElementIsVisible(inactiveStatus);
		String isInactive = inactiveStatus.getText();
		return isInactive;

	}

	public void editItem() {
		wuObj.waitUntilTheElementIsClickable(editBtn);
		guObj.clickCommand(editBtn);
	}

	public void updateItem() {
		wuObj.waitUntilTheElementIsClickable(updateBtn);
		guObj.clickCommand(updateBtn);
	}

	public void deleteItem() {
		wuObj.waitUntilTheElementIsClickable(deleteBtn);
		guObj.clickCommand(deleteBtn);
	}

	public void clickOk() {
		wuObj.waitUntilTheAlertIsPresent();
		guObj.acceptAlert(driver);
	}

	public void scroll() {
		guObj.scrollTillBottom(driver);
	}

	public MobileSliderPage(WebDriver driver) {
		this.driver = driver;
		wuObj = new WaitUtility(driver);
		PageFactory.initElements(driver, this);

	}

}
