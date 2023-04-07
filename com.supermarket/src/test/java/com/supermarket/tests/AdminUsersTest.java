package com.supermarket.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.WaitUtility;

public class AdminUsersTest extends BaseClass {

	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	LoginPage lpObj;
	HomePage hpObj;
	AdminUsersPage auObj;
	String sheetName = "AdminUsers";
	WaitUtility wuObj;
	Faker faker = new Faker();
	String userName=faker.name().username();

	
	@Test(priority = 1, enabled = true,groups= {"sanity"}, description = "This test case will verify the functionality - Add New Admin User")
	public void validateAddNewAdminUserFunctionality() throws InterruptedException, AWTException, IOException {
		wuObj =  new WaitUtility(driver);
		lpObj = new LoginPage(driver);
		hpObj =  new HomePage(driver); 	
		lpObj.login(ExcelUtility.readStringData("Login", 1, 0), ExcelUtility.readStringData("Login", 1, 1));
		auObj = new AdminUsersPage(driver);
		hpObj.navigateToAdminUsersPage();
		auObj.clickNewBtn();
		auObj.enterUserName(userName);
		auObj.enterPassword(ExcelUtility.readStringData(sheetName, 2, 2));
		auObj.selectUserType(ExcelUtility.readStringData(sheetName, 3, 2));
		auObj.clickSaveBtn();
		boolean actualAddAdminUserSuccessMsg = auObj.isSuccessMsgDisplayed();

		Assert.assertTrue(actualAddAdminUserSuccessMsg, "Add New Admin User functionality failed!");

	}

	@Test(priority = 2, enabled = true,groups= {"sanity"}, description = "This test case will verify the functionality - Search Admin User Details")
	public void validateSearchAdminUserDetails() throws InterruptedException, AWTException, IOException {

		auObj = new AdminUsersPage(driver);
		auObj.clickSearchBtn();
		auObj.enterUserNameInSearchWindow(ExcelUtility.readStringData(sheetName, 4, 2));
		auObj.selectUserTypeInSearchWindow(ExcelUtility.readStringData(sheetName, 5, 2));
		auObj.clickSearchBtnInSearchWindow();

		String searchResult = auObj.getuserNameInSearchResult();

		if (searchResult.equals(".........RESULT NOT FOUND.......")) {
			Assert.assertEquals(searchResult, Constants.searchAdminUserUnsuccessfulMsg,
					"Search Admin User Details failed!");
		}

		else {
			Assert.assertEquals(searchResult, ExcelUtility.readStringData(sheetName, 4, 2),
					"Search Admin User Details failed!");

		}

	}

	@Test(priority = 3, enabled = true,groups= {"sanity"}, description = "This test case will verify the functionality - Reset Admin User Search Details")
	public void validateResetSearchAdminDetails() throws InterruptedException, AWTException, IOException {
		auObj = new AdminUsersPage(driver);
		auObj.clickSearchBtn();
		auObj.enterUserNameInSearchWindow(ExcelUtility.readStringData(sheetName, 6, 2));
		auObj.selectUserTypeInSearchWindow(ExcelUtility.readStringData(sheetName, 7, 2));
		auObj.clickSearchBtnInSearchWindow();
		auObj.clickResetBtn();
		String actualAdminUsersTableHeading = auObj.getTitleOfTable();

		Assert.assertEquals(actualAdminUsersTableHeading, Constants.expectedAdminUsersTableHeading,
				"Reset functionality of Search Admin User failed!");

	}
	
	

	@Test(priority = 4, enabled = true, description = "This test case will verify the functionality - Update Admin User Details")
	public void validateUpdateAdminUserDetails() throws Exception {
		try {
			
			auObj = new AdminUsersPage(driver);
			auObj.clickEditBtnOfUser(userName);
			auObj.enterUserName(userName);
			auObj.enterPassword(ExcelUtility.readStringData(sheetName, 2, 2));
			auObj.selectUserType(ExcelUtility.readStringData(sheetName, 3, 2));
			auObj.clickUpdateBtn();
		
			boolean actualUpdateAdminUserSuccessMsg = auObj.isUpdateSuccessMsgDisplayed();
			Assert.assertTrue(actualUpdateAdminUserSuccessMsg, "Update Admin User Details functionality failed!");
		}

		catch(Exception e) {
			throw e;
			
		}
	}
	
	
	@Test(priority = 5, enabled = true, description = "This test case will verify the functionality - Delete Admin User")
	public void validateDeleteAdminUserDetails() throws Exception {

		try {
			auObj = new AdminUsersPage(driver);
			auObj.clickDeleteBtnOfUser(userName);
			auObj.clickOkFromAlert();
		
			boolean actualDeleteAdminUserSuccessMsg = auObj.isDeleteSuccessMsgDisplayed();
			Assert.assertTrue(actualDeleteAdminUserSuccessMsg, "Delete Admin User functionality failed!");
		}
		
		catch(Exception e) {
			throw e;
			
		}

	}

}
