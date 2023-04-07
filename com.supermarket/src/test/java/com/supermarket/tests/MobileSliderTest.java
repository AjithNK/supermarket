package com.supermarket.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.MobileSliderPage;
import com.supermarket.utilities.ExcelUtility;

public class MobileSliderTest extends BaseClass {

	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	LoginPage lpObj;
	HomePage hmObj;
	MobileSliderPage msObj;
	String sheetName = "MobileSlider";

	@Test(priority = 1, enabled = true, description = "This test case will verify creation of new mobile slider")
	public void validateAddNewMobileSliderFunctionality() throws IOException {
		lpObj = new LoginPage(driver);
		hmObj = new HomePage(driver);
		msObj = new MobileSliderPage(driver);
		lpObj.login(ExcelUtility.readStringData("Login", 1, 0), ExcelUtility.readStringData("Login", 1, 1));
		hmObj.navigateToMobileSliderPage();
		msObj.clickNewBtn();
		msObj.selectCategory(ExcelUtility.readStringData(sheetName, 1, 2));
		msObj.uploadFile(ExcelUtility.readStringData(sheetName, 2, 2));
		msObj.saveItem();
		String actualMsg = msObj.successMsgDisplayed();

		Assert.assertEquals(actualMsg, Constants.mobileSliderCreatedExpectedMsg,
				"Creation of new mobile slider failed!");

	}

	@Test(priority = 2, enabled = true, description = "This test case will verify cancel functionality of mobile slider creation")
	public void validateCancelNewMobileSliderCreation() throws IOException {

		msObj = new MobileSliderPage(driver);
		msObj.selectCategory(ExcelUtility.readStringData(sheetName, 1, 2));
		msObj.uploadFile(ExcelUtility.readStringData(sheetName, 2, 2));
		msObj.cancelCreation();
		String actualTitleOfTable = msObj.getTitleOfTable();

		Assert.assertEquals(actualTitleOfTable, Constants.expectedTitleOfTable,
				"Cancel functionality of mobile slider creation failed!");
	}

	@Test(priority = 3, enabled = true, description = "This test case will change status of mobile slider from Inactive to Active")
	public void validateChangeMobileSliderStatusToActive() throws Exception {
		msObj = new MobileSliderPage(driver);
		msObj.changeToActiveStatus();
		String actualStatus = msObj.checkActiveStatus();
		Assert.assertEquals(actualStatus, Constants.expectedActiveStatus, "Change mobile slider status from Inactive to Active failed!");
	}

	@Test(priority = 4, enabled = true, description = "This test case will change status of mobile slider from Active to Inactive")
	public void validateChangeMobileSliderStatusToInActive() throws Exception {

		msObj = new MobileSliderPage(driver);
		msObj.changeToInActiveStatus();
		String actualStatus = msObj.checkInactiveStatus();
		Assert.assertEquals(actualStatus, Constants.expectedInactiveStatus, "Change mobile slider status from Active to Inactive failed!");
	}

	@Test(priority = 5, enabled = true, description = "This test case will verify editing of created mobile slider")
	public void validateEditMobileSliderItem() throws IOException {

		msObj = new MobileSliderPage(driver);
		msObj.editItem();
		msObj.selectCategory(ExcelUtility.readStringData(sheetName, 3, 2));
		msObj.uploadFile(ExcelUtility.readStringData(sheetName, 4, 2));
		msObj.updateItem();
		boolean actualMsg = msObj.isUpdateMsgDisplayed();

		Assert.assertTrue(actualMsg, "Editing of existing mobile slider failed!");

	}

	@Test(priority = 6, enabled = true, description = "This test case will verify cancel functionality of mobile slider editing")
	public void validateCancelEditingOfMobileSliderItem() throws IOException {

		msObj = new MobileSliderPage(driver);
		msObj.editItem();
		msObj.selectCategory(ExcelUtility.readStringData(sheetName, 3, 2));
		msObj.uploadFile(ExcelUtility.readStringData(sheetName, 4, 2));
		msObj.cancelCreation();
		String actualTitle = msObj.getTitleOfTable();

		Assert.assertEquals(actualTitle, Constants.expectedTitleOfTable,
				"Cancel functionality of Edit mobile slider failed!");

	}

	@Test(priority = 7, enabled = true, description = "This test case will verify deletion of created mobile slider")
	public void validateDeletingOfMobileSliderItem() throws IOException {

		msObj = new MobileSliderPage(driver);
		msObj.deleteItem();
		msObj.clickOk();

		Assert.assertTrue(msObj.isDeleteMsgDisplayed(), "Delete Mobile slider failed!");
	}

}
