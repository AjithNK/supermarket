package com.supermarket.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralUtilities {
	WebDriver driver;

	public WebDriver browserLaunch(String url, String browser) {
		if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			System.out.println("Please check the browser you launched.");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		return driver;
	}

	public void clickCommand(WebElement element) {
		element.click();

	}

	public void clearCommand(WebElement element) {
		element.clear();
	}

	public void sendKeysCommand(WebElement element, String text) {
		element.sendKeys(text);

	}

	public void moveToElementCommand(WebElement element, WebDriver driver) {
		Actions acobj = new Actions(driver);
		acobj.moveToElement(element).build().perform();
	}

	public void takeScreenshot(WebDriver driver, String testcaseName) throws IOException {

		Date d = new Date();
		String date = d.toString().replace(":", "_").replace(" ", "_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sourcefile, new File("./Screenshot/" + testcaseName + "_" + date + ".jpg"));

	}

	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void promptAlert(WebDriver driver, String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();

	}

	public void scrollTillBottom(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollToTheElement(WebElement element, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public void clickTheElement(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.click(element).build().perform();

	}

	public void sendKeysForElement(WebElement element, String text, WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(element, text).perform();

	}

	public void pressEnter(WebDriver driver) throws AWTException {
		Robot robot = new Robot();
		robot.delay(200);
		robot.keyPress(KeyEvent.VK_ENTER);

	}

	public void pressTab(WebDriver driver) throws AWTException {
		Robot robot = new Robot();
		robot.delay(200);
		robot.keyPress(KeyEvent.VK_TAB);

	}
	
	public void pressEnter2(WebDriver driver) throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.delay(200);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.wait(8000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void clickUsingRobot(WebDriver driver) throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.delay(3000);
		robot.mousePress(0);
		
		robot.wait(8000);
		robot.mouseRelease(0);
	}
	
	
	public void moveToElem(WebElement element,WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element);

	}
	
	
}
