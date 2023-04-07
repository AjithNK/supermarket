package com.supermarket.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.MobileSliderPage;
import com.supermarket.utilities.DataProviderUtility;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.RetryAnalyzerUtility;

public class LoginTest extends BaseClass {

	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	LoginPage lpobj;
	MobileSliderPage msObj;

	@Test(priority = 2, enabled = true, description = "This test case will verify the Login functionality", retryAnalyzer = RetryAnalyzerUtility.class)
	public void validateLoginFunctionalityWithValidCredentials() throws IOException {

		lpobj = new LoginPage(driver);
		lpobj.clearData();
		lpobj.login(ExcelUtility.readStringData("Login", 1, 0), (ExcelUtility.readStringData("Login", 1, 1)));

		Assert.assertTrue(lpobj.isDisplayedDashboard(), "Login functionality failed!");
	}

	@Test(priority = 1, enabled = true, dataProvider = "loginData", dataProviderClass = DataProviderUtility.class)
	public void validateLoginFunctionalityWithInValidCredentials(String username, String password) throws IOException {

		lpobj = new LoginPage(driver);
		lpobj.clearData();
		lpobj.login(username, password);

		Assert.assertEquals(lpobj.gerErrorMessage(), Constants.expectedResult,"Login functionality failed!");
	}

}
