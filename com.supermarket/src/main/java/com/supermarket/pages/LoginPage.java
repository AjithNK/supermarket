package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	WaitUtility wuObj;

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signin;

	@FindBy(xpath = "//li[text()='Dashboard']")
	WebElement dashboard;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errormessge;

	@FindBy(xpath = "//p[@class='login-box-msg']")
	WebElement signInText;

	public void login(String username1, String password1) {
		guObj.sendKeysCommand(username, username1);
		guObj.sendKeysCommand(password, password1);
		wuObj.waitUntilTheElementIsClickable(signin);
		guObj.clickCommand(signin);
	}

	public String gerErrorMessage() {
		wuObj.waitUntilTheElementIsVisible(errormessge);
		String errorMessage = errormessge.getText();
		return errorMessage;
	}

	public void clearData() {
		guObj.clearCommand(username);
		guObj.clearCommand(password);

	}

	public boolean isDisplayedDashboard() {
		wuObj.waitUntilTheElementIsVisible(dashboard);
		boolean returnDashValue = dashboard.isDisplayed();
		return returnDashValue;
	}

	public String getSignInText() {
		wuObj.waitUntilTheElementIsVisible(signInText);
		return signInText.getText();

	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wuObj = new WaitUtility(driver);
		PageFactory.initElements(driver, this);

	}
}
