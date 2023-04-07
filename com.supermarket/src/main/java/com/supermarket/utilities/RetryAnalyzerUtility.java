package com.supermarket.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerUtility implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 3;

	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;

		}
		return false;
	}

}


//@Test(retryAnalyzer = RetryAnalyzerUtility.class)  -- specifying retry analyzer value in @Test annotation
//By adding retry analyzer during run time by implementing the listener interface
