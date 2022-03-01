package com.myshop.step;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ExcelRead {
	public static void main(String[] args) throws IOException {
		
		File file = new File("F:\\ExcelRead\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int lastrow = sheet.getLastRowNum();
		int lastcell = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= lastrow; i++) 
		{
			System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
			System.out.println(sheet.getRow(i).getCell(1).getStringCellValue());
			System.out.println(sheet.getRow(i).getCell(2).getStringCellValue());
			System.out.println(sheet.getRow(i).getCell(3).getNumericCellValue());
			System.out.println(sheet.getRow(i).getCell(4).getNumericCellValue());
			System.out.println(sheet.getRow(i).getCell(5).getNumericCellValue());
			System.out.println(sheet.getRow(i).getCell(6).getNumericCellValue());
			System.out.println(sheet.getRow(i).getCell(7).getNumericCellValue());
			
		}
	}

}
