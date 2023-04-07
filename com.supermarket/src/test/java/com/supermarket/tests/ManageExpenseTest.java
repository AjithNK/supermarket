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
import com.supermarket.pages.ManageExpensePage;
import com.supermarket.utilities.ExcelUtility;

public class ManageExpenseTest extends BaseClass {

	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	LoginPage lpObj;
	HomePage hpObj;
	ManageExpensePage meObj;
	String sheetName = "ManageExpense";

	@Test(priority = 1, enabled = true, description = "This test case will verify Add New Expenses functionality")
	public void validateAddNewExpenseFunctionality() throws InterruptedException, IOException, AWTException {

		lpObj = new LoginPage(driver);
		hpObj = new HomePage(driver);
		meObj = new ManageExpensePage(driver);
		lpObj.login(ExcelUtility.readStringData("Login", 1, 0), ExcelUtility.readStringData("Login", 1, 1));
		hpObj.navigateToManageExpensePage();
		meObj.clickNewBtn();
		meObj.selectUser(ExcelUtility.readStringData(sheetName, 1, 2));
		meObj.enterDate(ExcelUtility.readIntegerData(sheetName, 2, 2));
		meObj.selectCategory(ExcelUtility.readStringData(sheetName, 3, 2));
		meObj.selectOrderId(ExcelUtility.readIntegerData(sheetName, 4, 2));
		meObj.selectPurchaseId(ExcelUtility.readIntegerData(sheetName, 5, 2));
		meObj.selectExpenseType(ExcelUtility.readStringData(sheetName, 6, 2));
		meObj.enterAmount(ExcelUtility.readIntegerData(sheetName, 7, 2));
		meObj.enterRemarks(ExcelUtility.readStringData(sheetName, 8, 2));
		meObj.uploadFile(ExcelUtility.readStringData(sheetName, 9, 2));
		meObj.saveDetails();

		String actualExpenseCreationMsg = meObj.successMsgDisplayed();
		Assert.assertEquals(actualExpenseCreationMsg, Constants.expectedExpenseCreationMsg,
				"Add New Expense functionality failed!");
		meObj.clickCloseBtn();
	}

	@Test(priority = 2, enabled = true, description = "This test case will verify Cancellation functionality of Add New Expenses")
	public void validateCancellationOfNewExpenseCreation() throws InterruptedException, IOException, AWTException {

		meObj.selectUser(ExcelUtility.readStringData(sheetName, 1, 2));
		meObj.enterDate(ExcelUtility.readIntegerData(sheetName, 2, 2));
		meObj.selectCategory(ExcelUtility.readStringData(sheetName, 3, 2));
		meObj.selectOrderId(ExcelUtility.readIntegerData(sheetName, 4, 2));
		meObj.selectPurchaseId(ExcelUtility.readIntegerData(sheetName, 5, 2));
		meObj.selectExpenseType(ExcelUtility.readStringData(sheetName, 6, 2));
		meObj.enterAmount(ExcelUtility.readIntegerData(sheetName, 7, 2));
		meObj.enterRemarks(ExcelUtility.readStringData(sheetName, 8, 2));
		meObj.cancelCreation();

		String actualExpenseTableHeading = meObj.listExpenseHeadingDisplayed();
		Assert.assertEquals(actualExpenseTableHeading, Constants.expectedExpenseTableHeading,
				"Cancellation functionality for Add New Expense failed!");
	}

	@Test(priority = 3, enabled = true, description = "This test case will verify Navigation from First page to Last page from footer")
	public void validateFooterNavigationFromFirstPageToLastPage() throws InterruptedException {

		boolean isLinkFirstDisplayedInFirstPage = meObj.checkPresenceOfLinkFirst();
		Assert.assertFalse(isLinkFirstDisplayedInFirstPage,
				"Navigation functionality from First page to Last page failed!");
		meObj.navigateToLastPage();
		boolean isLinkFirstDisplayedInLastPage = meObj.checkPresenceOfLinkFirst();
		Assert.assertTrue(isLinkFirstDisplayedInLastPage,
				"Navigation functionality from First page to Last page failed!");

	}
}
