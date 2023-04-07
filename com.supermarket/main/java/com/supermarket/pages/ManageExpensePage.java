package com.supermarket.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.FileUploadUtility;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class ManageExpensePage {

	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	FileUploadUtility fuObj = new FileUploadUtility();
	WaitUtility wuObj;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;

	@FindBy(xpath = "//select[@id='user_id']")
	WebElement user;

	@FindBy(xpath = "//input[@id='ex_date']")
	WebElement date;

	@FindBy(xpath = "//select[@id='ex_cat']")
	WebElement category;

	@FindBy(xpath = "//select[@id='order_id']")
	WebElement orderId;

	@FindBy(xpath = "//select[@id='purchase_id']")
	WebElement purchaseId;

	@FindBy(xpath = "//select[@id='ex_type']")
	WebElement expenseType;

	@FindBy(xpath = "//input[@id='amount']")
	WebElement amount;

	@FindBy(xpath = "//textarea[@id='content']")
	WebElement remarks;

	@FindBy(xpath = "//input[@name='userfile']")
	WebElement chooseFile;

	@FindBy(xpath = "//button[@name='create']")
	WebElement saveBtn;

	@FindBy(xpath = "//button[@name='create']//following::a[1]")
	WebElement cancelBtn;

	@FindBy(xpath = "//a[@aria-label='Last']")
	WebElement lastBtn;

	@FindBy(xpath = "//a[@aria-label='First']")
	List<WebElement> firstBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//button")
	WebElement closeBtn;
	
	@FindBy(xpath = "//div[@class='card-header']//h4[text()='List Expense']")
	WebElement listExpenseHeading;

	public void clickNewBtn() {
		wuObj.waitUntilTheElementIsClickable(newBtn);
		guObj.clickCommand(newBtn);
	}

	public void selectUser(String userNameToEnter) {
		guObj.selectByVisibleText(user, userNameToEnter);
	}

	public void enterDate(String dateToEnter) {
		guObj.sendKeysCommand(date, dateToEnter);
		date.sendKeys(Keys.ENTER);
	}

	public void selectCategory(String categoryToEnter) {
		guObj.selectByVisibleText(category, categoryToEnter);
	}

	public void selectOrderId(String orderIdToEnter) {
		guObj.selectByVisibleText(orderId, orderIdToEnter);
	}

	public void selectPurchaseId(String purchaseIdToEnter) {
		guObj.selectByVisibleText(purchaseId, purchaseIdToEnter);
	}

	public void selectExpenseType(String expenseTypeToEnter) {
		guObj.selectByVisibleText(expenseType, expenseTypeToEnter);
	}

	public void enterAmount(String amountToEnter) {
		wuObj.waitUntilTheElementIsClickable(amount);
		guObj.sendKeysCommand(amount, amountToEnter);
	}

	public void enterRemarks(String remarksToEnter) throws AWTException{
		wuObj.waitUntilTheElementIsClickable(remarks);
		guObj.sendKeysCommand(remarks, remarksToEnter);
		guObj.pressTab(driver);
	}

	public void uploadFile(String fileName) throws AWTException {
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\uploadFiles\\" + fileName;
		fuObj.uploadFile(chooseFile, path);
	}
	
	public void saveDetails() throws InterruptedException {
		guObj.scrollTillBottom(driver);
		wuObj.waitUntilTheElementIsClickable(saveBtn);
		guObj.clickCommand(saveBtn);
	}

	public String successMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		String successMsgDisplayed = successMsg.getText();
		return successMsgDisplayed;
	}
	
	public void clickCloseBtn(){
		wuObj.waitUntilTheElementIsClickable(closeBtn);
		guObj.clickCommand(closeBtn);
	}

	public void cancelCreation() throws InterruptedException {
		guObj.scrollTillBottom(driver);
		wuObj.waitUntilTheElementIsClickable(cancelBtn);
		guObj.clickCommand(cancelBtn);
	}

	public String listExpenseHeadingDisplayed() {
		wuObj.waitUntilTheElementIsVisible(listExpenseHeading);
		String listExpenseHeadingText = listExpenseHeading.getText();
		return listExpenseHeadingText;
	}

	public void navigateToLastPage() throws InterruptedException {
		guObj.scrollTillBottom(driver);
		wuObj.waitUntilTheElementIsClickable(lastBtn);
		guObj.clickCommand(lastBtn);
	}

	public boolean checkPresenceOfLinkFirst() throws InterruptedException {
		guObj.scrollTillBottom(driver);
		if (!firstBtn.isEmpty()) {
			return true;
		}
		return false;
	}

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		wuObj = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
	}

}
