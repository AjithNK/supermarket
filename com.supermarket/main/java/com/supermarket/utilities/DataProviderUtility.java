package com.supermarket.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	@DataProvider(name = "loginData")
	public Object[][] getData() throws IOException {
		
		return new Object[][] { 
			
				new Object[] { ExcelUtility.readStringData("Login", 2, 0), ExcelUtility.readStringData("Login", 2, 1) }, 
				new Object[] { ExcelUtility.readStringData("Login",3, 0), ExcelUtility.readStringData("Login", 3, 1) }};
		}
}



