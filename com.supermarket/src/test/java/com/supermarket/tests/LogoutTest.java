package com.supermarket.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.LogoutPage;
import com.supermarket.utilities.ExcelUtility;

public class LogoutTest extends BaseClass {

	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	LoginPage lpObj;
	LogoutPage lopObj;

	@Test(priority = 1, enabled = true, description = "This test case will verify the Logout functionality")
	public void validateLogoutFunctionality() throws IOException, InterruptedException {

		lpObj = new LoginPage(driver);
		lpObj.login(ExcelUtility.readStringData("Login", 1, 0), ExcelUtility.readStringData("Login", 1, 1));
		lopObj = new LogoutPage(driver);
		lopObj.clickLogoutLink();

		String actualSignInText = lpObj.getSignInText();
		Assert.assertEquals(actualSignInText, Constants.expectedSignInText, "Logout functionality failed!");
	}
}
