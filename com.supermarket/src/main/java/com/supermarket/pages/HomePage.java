package com.supermarket.pages;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class HomePage {

	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	WaitUtility wuObj;

	@FindBy(xpath = "//p[text()='Mobile Slider']/preceding::a[@href='http://groceryapp.uniqassosiates.com/admin/list-mobileslider']")
	WebElement moreInfoMobileSlider;

	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage Expense']")
	WebElement moreInfoManageExpense;

	@FindBy(xpath = "//p[text()='Manage Orders']/following::a[1]")
	WebElement moreInfoManageOrders;

	@FindBy(xpath = "//p[text()='Push Notifications']//parent::a")
	WebElement pushNotificationsLink;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeLinkInHomePageBreadcrum;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]/following::li")
	WebElement dashboardTextInHomePageBreadcrum;
	
	@FindBy(xpath = "//a[@class='nav-link']//p[text()='Manage Expense']")
	WebElement manageExpense;
	
	@FindBy(xpath = "//a[@class='nav-link']//p//i[@class='fas fa-angle-left right']")
	WebElement collapsedArrow;
	

	@FindBy(xpath = "//a[@class='small-box-footer' and @href='http://groceryapp.uniqassosiates.com/admin/list-deliveryboy']")
	WebElement moreInfoManageDeliveryBoy;

	@FindBy(xpath = "//a[@class='small-box-footer' and @href='http://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement moreInfoAdminUsers;

	public void navigateToPushNotificationsPage() throws InterruptedException {
		wuObj.waitUntilTheElementIsClickable(pushNotificationsLink);
		guObj.clickCommand(pushNotificationsLink);
	}

	public void navigateToMobileSliderPage() {
		wuObj.waitUntilTheElementIsClickable(moreInfoMobileSlider);
		moreInfoMobileSlider.click();
	}

	public void navigateToManageDeliveryBoyPage() throws InterruptedException {
		wuObj.waitUntilTheElementIsClickable(moreInfoManageDeliveryBoy);
		guObj.clickCommand(moreInfoManageDeliveryBoy);
	}


	public void navigateToAdminUsersPage() throws InterruptedException {
		wuObj.waitUntilTheElementIsClickable(moreInfoAdminUsers);
		guObj.clickCommand(moreInfoAdminUsers);
	}


	public void navigateToManageExpensePage() throws InterruptedException, AWTException {
		wuObj.waitUntilTheElementIsVisible(collapsedArrow);
		guObj.clickCommand(collapsedArrow);
		wuObj.waitUntilTheElementIsVisible(manageExpense);
		guObj.clickCommand(manageExpense);

}
	
	public void navigateToManageOrdersPage() throws InterruptedException, AWTException {
		wuObj.waitUntilTheElementIsClickable(moreInfoManageOrders);
		guObj.clickCommand(moreInfoManageOrders);
		guObj.pressTab(driver);
		guObj.pressEnter(driver);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String isDashboardTextDisplayedInHomePageBreadcrum() {
		wuObj.waitUntilTheElementIsVisible(dashboardTextInHomePageBreadcrum);
		String dashboardText = dashboardTextInHomePageBreadcrum.getText();
		return dashboardText;

	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wuObj = new WaitUtility(driver);
		PageFactory.initElements(driver, this);

	}

}
