package com.supermarket.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageOrdersPage;
import com.supermarket.utilities.ExcelUtility;

public class ManageOrdersTest extends BaseClass {

	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	LoginPage lpObj;
	HomePage hpObj;
	ManageOrdersPage moObj;

	@Test(priority = 1, enabled = true, description = "This test case will verify the View Order functionality")
	public void validateViewOrderFunctionality() throws InterruptedException, IOException, AWTException {

		lpObj = new LoginPage(driver);
		hpObj = new HomePage(driver);
		moObj = new ManageOrdersPage(driver);
		lpObj.login(ExcelUtility.readStringData("Login", 1, 0), ExcelUtility.readStringData("Login", 1, 1));
		hpObj.navigateToManageOrdersPage();
		moObj.clickViewBtn();
		String ordeDetailsHeading = moObj.getOrderDetailsHeading();

		Assert.assertEquals(ordeDetailsHeading, Constants.expectedHeading, "View Order functionality failed!");
		moObj.clickBackBtn();

	}


	@Test(priority = 2, enabled = true, description = "This test case will verify the Delete Order functionality")
	public void validateDeleteOrderFunctionality() throws InterruptedException {

		moObj.clickDeleteBtn();
		moObj.acceptAlertForDeleting();
		String actualDeletionSuccessMsg = moObj.successMsgDisplayed();

		Assert.assertEquals(actualDeletionSuccessMsg, Constants.expectedDeletionSuccessMsg,
				"Delete Order functionality failed!");

	}
	
	@Test(priority = 3, enabled = true, description = "This test case will verify the Cancellation functionality of Change Order status")
	public void validateChangeOrderStatusCancellation() throws InterruptedException {

		String statusBeforeClickingChangeStatus = moObj.getStatusTextBefore();
		moObj.clickChangeStatusBtn();
		moObj.selectUpdateStausDropdown();
		moObj.clickCloseBtn();
		String statusAfterClickingCloseBtn = moObj.getStatusTextAfter();

		Assert.assertEquals(statusBeforeClickingChangeStatus, statusAfterClickingCloseBtn,
				"Cancellation functionality of Change Order status failed!");

	}


}
