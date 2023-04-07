package com.supermarket.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {

	public void uploadFile(WebElement element, String path) {
		element.sendKeys(path);
	}

	public void fileUpload(WebElement element, String filePath) throws AWTException {

		StringSelection ssObj = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ssObj, null);
		element.click();

		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
