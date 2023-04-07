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
import com.supermarket.pages.ManageDeliveryBoyPage;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.WaitUtility;

public class ManageDeliveryBoyTest extends BaseClass {

	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	LoginPage lpObj;
	HomePage hpObj;
	ManageDeliveryBoyPage mdObj;
	String sheetName = "ManageDeliveryBoy";
	WaitUtility wuObj;
	Faker faker=new Faker();
	String deliveryBoyName=faker.name().username();
	

	@Test(priority = 1, enabled = true,groups= {"sanity"}, description = "This test case will verify the functionality - Add New Delivery Boy ")
	public void validateAddNewDeliveryBoyFunctionality() throws AWTException, IOException, InterruptedException {

		wuObj = new WaitUtility(driver);
		lpObj = new LoginPage(driver);
		hpObj = new HomePage(driver);
		mdObj = new ManageDeliveryBoyPage(driver);
		lpObj.login(ExcelUtility.readStringData("Login", 1, 0), ExcelUtility.readStringData("Login", 1, 1));
		hpObj.navigateToManageDeliveryBoyPage();
		mdObj.clickNewBtn();
		mdObj.enterName(deliveryBoyName); 
		mdObj.enterEmail(ExcelUtility.readStringData(sheetName, 2, 2));
		mdObj.enterPhoneNo(ExcelUtility.readIntegerData(sheetName, 3, 2));
		mdObj.address(ExcelUtility.readStringData(sheetName, 4, 2));
		mdObj.enterUsername(deliveryBoyName);
		mdObj.enterPassword(ExcelUtility.readStringData(sheetName, 6, 2));
		mdObj.clickSaveBtn();
		boolean actualAddDeliveryBoySuccessMsg = mdObj.isSuccessMsgDisplayed();

		Assert.assertTrue(actualAddDeliveryBoySuccessMsg, "Add New Delivery Boy functionality failed!");

	}

	@Test(priority = 2, enabled = true,groups= {"sanity"}, description = "This test case will verify the Search functionality of Manage Delivery Boy")
	public void validateSearchDeliveryBoyDetails() throws InterruptedException, AWTException, IOException {

		mdObj = new ManageDeliveryBoyPage(driver);
		mdObj.clickSearchBtn();
		mdObj.enterNameInSearchWindow(ExcelUtility.readStringData(sheetName, 7, 2));
		mdObj.enterEmailInSearchWindow(ExcelUtility.readStringData(sheetName, 8, 2));
		mdObj.enterPhoneNoInSearchWindow(ExcelUtility.readIntegerData(sheetName, 9, 2));
		mdObj.clickSearchBtnInSearchWindow();

		String searchResult = mdObj.getNameInSearchResult();
		
		if (searchResult.equals(".........RESULT NOT FOUND.......")) {
			Assert.assertEquals(searchResult, Constants.searchDeliveryBoyUnsuccessfulMsg,
					"Search Delivery Boy Details failed!");
		}

		else {
			Assert.assertEquals(searchResult, ExcelUtility.readStringData(sheetName, 7, 2),
					"Search Delivery Boy Details failed!");

		}

	}

	@Test(priority = 3, enabled = true,groups= {"sanity"}, description = "This test case will verify Reset functionality of Search Delivery Boy")
	public void validateResetEnteredDeliveryBoyDetails() throws AWTException, InterruptedException, IOException {

		mdObj = new ManageDeliveryBoyPage(driver);
		mdObj.clickSearchBtn();
		mdObj.enterNameInSearchWindow(ExcelUtility.readStringData(sheetName, 10, 2));
		mdObj.enterEmailInSearchWindow(ExcelUtility.readStringData(sheetName, 11, 2));
		mdObj.enterPhoneNoInSearchWindow(ExcelUtility.readIntegerData(sheetName, 12, 2));
		mdObj.clickResetBtnInSearchWindow();

		String actualDeliveryBoyTableHeading = mdObj.getTitleOfTable();
		Assert.assertEquals(actualDeliveryBoyTableHeading, Constants.expectedDeliveryBoyTableHeading,
				"Reset functionality of Search Delivery Boy failed!");

	}
	
	
	@Test(priority = 4, enabled = true, description = "This test case will verify the functionality - Update Delivery Boy Details")
	public void validateUpdateDeliveryBoyDetails() throws Exception {
		
		try {
			mdObj = new ManageDeliveryBoyPage(driver);
			mdObj.clickEditBtnOfUser(deliveryBoyName);
			mdObj.enterName(deliveryBoyName);
			mdObj.enterEmail(ExcelUtility.readStringData(sheetName, 14, 2));
			mdObj.enterPhoneNo(ExcelUtility.readIntegerData(sheetName, 15, 2));
			mdObj.address(ExcelUtility.readStringData(sheetName, 16, 2));
			mdObj.enterUsername(ExcelUtility.readStringData(sheetName, 17, 2));
			mdObj.enterPassword(ExcelUtility.readStringData(sheetName, 18, 2));		
			mdObj.clickUpdateBtn();

			boolean actualAddDeliveryBoySuccessMsg = mdObj.isUpdateSuccessMsgDisplayed();
			Assert.assertTrue(actualAddDeliveryBoySuccessMsg, "Update Delivery Boy Details functionality failed!");
		
		
		}
		
		catch(Exception e) {
			throw e;
		}
	}
	
	
	@Test(priority = 5, enabled = true, description = "This test case will verify the functionality - Delete Delivery Boy")
	public void validateDeleteDeliveryBoyDetails() throws Exception {

		try {
			mdObj = new ManageDeliveryBoyPage(driver);
			mdObj.clickDeleteBtnOfUser(deliveryBoyName);
			mdObj.clickOkFromAlert();
			
			boolean actualDeleteAdminUserSuccessMsg = mdObj.isDeleteSuccessMsgDisplayed();
			Assert.assertTrue(actualDeleteAdminUserSuccessMsg, "Delete Delivery Boy functionality failed!");
		
		}
		
		catch(Exception e) {
			throw e;
		}
		
	}

}
