package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class ManageOrdersPage {

	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	WaitUtility wuObj;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[text()='296']//following::td[6]//a[1]")
	WebElement viewBtn;

	@FindBy(xpath = "//a[@class='btn btn-default' and text()=' Back']")
	WebElement backBtn;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement orderDetailsHeading;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[text()='296']//following::td[5]/child::span[1]")
	WebElement statusText;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[text()='296']//following::td[5]//a[@class='btn btn-success btn-sm']")
	WebElement changeStatusBtn;

	@FindBy(xpath = "//div[@class='modal-content']//form//div[@class='modal-body']//select[@id='status' and @onchange='show_cancel(296)']")
	WebElement selectUpdate;

	@FindBy(xpath = "//div[@class='modal-content']//form//div[@class='modal-header']//h4[contains(text(),'Update Status')] //b[contains(text(),'296')]//following::button[@fdprocessedid='pgbh']")
	WebElement closeBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[text()='290']//following::td[5]//a[@class='btn btn-primary btn-sm']")
	WebElement changeDeliveryDateBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[4]/td[text()='290']//following::a")
	WebElement assignDeliveryBoyBtn;

	@FindBy(xpath = "//select[@id='delivery_boy_id']/following::input[@value='323']")
	WebElement selectDeliveryBoy;

	@FindBy(xpath = "//button[@class='btn btn-info' and @fdprocessedid='2j0clu']")
	WebElement updateBtn;

	//@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr//td//following::td[6]//a[2]")
	@FindBy(xpath = "/html/body/div[1]/div[1]/section/div[4]/div[3]/table/tbody/tr[1]/td[7]/a[2]")
	WebElement deleteBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;

	public void clickViewBtn() {
		wuObj.waitUntilTheElementIsClickable(viewBtn);
		wuObj.waitUntilTheElementIsClickable(viewBtn);
		wuObj.waitUntilTheElementIsClickable(viewBtn);
		guObj.clickCommand(viewBtn);
	}

	public void clickBackBtn() {
		wuObj.waitUntilTheElementIsClickable(backBtn);
		wuObj.waitUntilTheElementIsClickable(backBtn);
		wuObj.waitUntilTheElementIsClickable(backBtn);
		guObj.clickCommand(backBtn);
	}

	public String getOrderDetailsHeading() {
		wuObj.waitUntilTheElementIsVisible(orderDetailsHeading);
		wuObj.waitUntilTheElementIsVisible(orderDetailsHeading);
		wuObj.waitUntilTheElementIsVisible(orderDetailsHeading);
		return orderDetailsHeading.getText();
	}

	public String getStatusTextBefore() {
		wuObj.waitUntilTheElementIsVisible(statusText);
		String status = statusText.getText();
		return status;
	}

	public void clickChangeStatusBtn() {
		wuObj.waitUntilTheElementIsClickable(changeStatusBtn);
		wuObj.waitUntilTheElementIsClickable(changeStatusBtn);
		wuObj.waitUntilTheElementIsClickable(changeStatusBtn);
		guObj.clickCommand(changeStatusBtn);
	}

	public void selectUpdateStausDropdown() {
		guObj.selectByVisibleText(selectUpdate, "Delivered");
	}

	public void clickCloseBtn() {
		wuObj.waitUntilTheElementIsClickableFluentWait(closeBtn);
		wuObj.waitUntilTheElementIsClickableFluentWait(closeBtn);
		wuObj.waitUntilTheElementIsClickableFluentWait(closeBtn);
		guObj.clickCommand(closeBtn);
	}

	public String getStatusTextAfter() {
		wuObj.waitUntilTheElementIsVisible(statusText);
		wuObj.waitUntilTheElementIsVisible(statusText);
		wuObj.waitUntilTheElementIsVisible(statusText);
		String status = statusText.getText();
		return status;
	}

	public void clickAssignDeliveryBoyBtn() {
		guObj.scrollToTheElement(assignDeliveryBoyBtn, driver);
		wuObj.waitUntilTheElementIsClickable(assignDeliveryBoyBtn);
		guObj.clickCommand(assignDeliveryBoyBtn);
	}

	public void selectDeliveryBoyDropdown() {
		guObj.selectByVisibleText(selectDeliveryBoy, "sumesh");
	}

	public void clickUpdateBtn() {
		wuObj.waitUntilTheElementIsClickable(updateBtn);
		guObj.clickCommand(updateBtn);
	}

	public void clickDeleteBtn() {
		wuObj.waitUntilTheElementIsClickableFluentWait(changeStatusBtn);
		guObj.clickCommand(deleteBtn);

	}

	public void acceptAlertForDeleting() {
		wuObj.waitUntilTheAlertIsPresent();
		guObj.acceptAlert(driver);

	}

	public String successMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		return successMsg.getText();
	}

	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		wuObj = new WaitUtility(driver);
		PageFactory.initElements(driver, this);

	}

}
