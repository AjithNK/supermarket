package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class LogoutPage {

	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	WaitUtility wuObj;

	@FindBy(xpath = "//p[contains(text(),'Settings')]/parent::a")
	WebElement settingsLink;

	@FindBy(xpath = "//p[contains(text(),'Logout')]/parent::a")
	WebElement logOutLink;

	public void clickLogoutLink() throws InterruptedException {
		guObj.scrollToTheElement(settingsLink, driver);
		wuObj.waitUntilTheElementIsClickable(settingsLink);
		guObj.clickCommand(settingsLink);
		wuObj.waitUntilTheElementIsClickable(logOutLink);
		guObj.clickCommand(logOutLink);

	}

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		wuObj = new WaitUtility(driver);
		PageFactory.initElements(driver, this);

	}

}
