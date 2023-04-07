package com.supermarket.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationsPage;
import com.supermarket.utilities.ExcelUtility;

public class PushNotificationsTest extends BaseClass {

	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	LoginPage lpObj;
	HomePage hpObj;
	PushNotificationsPage pnObj;
	String sheetName = "PushNotifications";

	@Test(priority = 1, enabled = true, description = "This test case will verify the functionality- send push notification")
	public void validateSendPushNotification() throws InterruptedException, IOException {
		lpObj = new LoginPage(driver);
		hpObj = new HomePage(driver);
		pnObj = new PushNotificationsPage(driver);

		lpObj.login(ExcelUtility.readStringData("Login", 1, 0), ExcelUtility.readStringData("Login", 1, 1));
		hpObj.navigateToPushNotificationsPage();
		pnObj.enterTitle(ExcelUtility.readStringData(sheetName, 1, 2));
		pnObj.entertDescription(ExcelUtility.readStringData(sheetName, 2, 2));
		pnObj.clickSendBtn();

		Assert.assertTrue(pnObj.isAlertMsgDisplayed(), "Send Push notification functionality failed!");

	}

	@Test(priority = 2, enabled = true, description = "This test case will verify the functionality- reset the entered push notification details")
	public void validateResetEnteredDetailsOfPushNotification() throws InterruptedException, IOException {
		pnObj = new PushNotificationsPage(driver);
		pnObj.enterTitle(ExcelUtility.readStringData(sheetName, 3, 2));
		pnObj.entertDescription(ExcelUtility.readStringData(sheetName, 4, 2));
		pnObj.clickResetBtn();

		Assert.assertTrue(pnObj.isResetSuccessful(), "Reset entered mobile slider details functionality failed!");

	}

	@Test(priority = 3, enabled = true, description = "This test case will verify the functionality- navigation to home page from push notification page")
	public void validateNavigationToHomePageFromMobileSliderPage() throws InterruptedException, IOException {
		hpObj = new HomePage(driver);
		pnObj = new PushNotificationsPage(driver);
		pnObj.enterTitle(ExcelUtility.readStringData(sheetName, 5, 2));
		pnObj.entertDescription(ExcelUtility.readStringData(sheetName, 6, 2));
		pnObj.clickHomeLink();

		String actualTextInHomePage = pnObj.isHomePageDisplayed(hpObj);
		Assert.assertEquals(actualTextInHomePage, Constants.expectedTextInHomePage,
				"Navigation to home page from mobile slider page failed!");

	}

}
