package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class PushNotificationsPage {

	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	WaitUtility wuObj;
	HomePage hpObj;

	@FindBy(xpath = "//input[@id='title']")
	WebElement title;

	@FindBy(xpath = "//input[@id='description']")
	WebElement description;

	@FindBy(xpath = "//button[@name='create']")
	WebElement sendBtn;

	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement resetBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeLink;

	public void enterTitle(String pushNotificationTitle) {
		wuObj.waitUntilTheElementIsClickable(title);
		guObj.clearCommand(title);
		guObj.sendKeysCommand(title, pushNotificationTitle);

	}

	public void entertDescription(String pushNotificationDescription) {
		wuObj.waitUntilTheElementIsClickable(description);
		guObj.clearCommand(description);
		guObj.sendKeysCommand(description, pushNotificationDescription);

	}

	public void clickSendBtn() {
		wuObj.waitUntilTheElementIsClickable(sendBtn);
		guObj.clickCommand(sendBtn);
	}

	public void clickResetBtn() {
		wuObj.waitUntilTheElementIsClickable(resetBtn);
		guObj.clickCommand(resetBtn);
	}

	public void clickHomeLink() {
		wuObj.waitUntilTheElementIsClickable(homeLink);
		guObj.clickCommand(homeLink);
	}

	public String isHomePageDisplayed(HomePage hpObj) {
		String dashBoardText = hpObj.isDashboardTextDisplayedInHomePageBreadcrum();
		return dashBoardText;

	}

	public boolean isResetSuccessful() {
		wuObj.waitUntilTheElementIsVisible(title);
		boolean isTitleEmpty = title.getText().isEmpty();
		wuObj.waitUntilTheElementIsVisible(description);
		boolean isDescriptionEmpty = description.getText().isEmpty();

		if (isTitleEmpty && isDescriptionEmpty) {

			return true;
		}

		else
			return false;

	}

	public boolean isAlertMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(alertMsg);
		String actualMsg = alertMsg.getText();
		if (actualMsg.contains(Constants.expectedSuccessMsgPushNotification)) {
			return true;
		}

		return false;
	}

	public PushNotificationsPage(WebDriver driver) {

		this.driver = driver;
		wuObj = new WaitUtility(driver);
		PageFactory.initElements(driver, this);

	}

}
