package com.supermarket.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream fileInputStream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public static String readStringData(String sheetName, int row, int column) throws IOException {
		fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\excelFile\\testData.xlsx");
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		Row r = sheet.getRow(row);
		Cell c = r.getCell(column);
		return c.getStringCellValue();

	}

	public static String readIntegerData(String sheetName, int row, int column) throws IOException {
		fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\excelFile\\testData.xlsx");
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		Row r = sheet.getRow(row);
		Cell c = r.getCell(column);
		int a = (int) c.getNumericCellValue();
		return String.valueOf(a); // converting integer value to string

	}

}
