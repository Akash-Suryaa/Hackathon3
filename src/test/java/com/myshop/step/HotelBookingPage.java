package com.myshop.step;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HotelBookingPage  extends InitilizeBrowser{
	
	public static void bookHotel()
	{
		WebElement fname_txt =driver.findElement(By.id(webInItelements.firstName));
		fname_txt.clear();
		fname_txt.sendKeys("Akash");
		
		WebElement lname_txt =driver.findElement(By.id(webInItelements.lastName));
		lname_txt.clear();
		lname_txt.sendKeys("suryawanshi");
		
		
		WebElement billingAddress_txt =driver.findElement(By.id(webInItelements.billingAddres));
		billingAddress_txt.clear();
		billingAddress_txt.sendKeys("pune");
		
		WebElement creditCardNo_txt =driver.findElement(By.id(webInItelements.creditCard_no));
		creditCardNo_txt.clear();
		creditCardNo_txt.sendKeys("1234567891234567");
		
		WebElement creditCardtype_txt =driver.findElement(By.id(webInItelements.creditCardType));
		creditCardtype_txt.click();
		HotelBookingUtil.select_Value_HotelBook(creditCardtype_txt, "VISA");

		
		
		WebElement expiryMonth_elem =driver.findElement(By.id(webInItelements.expiryMonth));
		expiryMonth_elem.click();
		HotelBookingUtil.select_Value_HotelBook(expiryMonth_elem, "January");

		
		
		WebElement expiryYear_elem =driver.findElement(By.id(webInItelements.expiryYear));
		expiryYear_elem.click();
		HotelBookingUtil.select_Value_HotelBook(expiryYear_elem, "2022");
		
		
		WebElement CVV_elem =driver.findElement(By.id(webInItelements.CVV));
		CVV_elem.sendKeys("100");
		
		WebElement booknow_elem =driver.findElement(By.id(webInItelements.book));
		booknow_elem.click();
		
		
	}
	
	
	public  static void verify_OrderId() throws IOException
	{
		WebElement orderId_elem =driver.findElement(By.id(webInItelements.orderId));
		String id = orderId_elem.getAttribute("value");
		System.out.println("Id : "+id);
		excelWriteUtil(id);
	}
	
	public static void excelWriteUtil(String value) throws IOException
	{

		File file = new File("F:\\ExcelRead\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet3");
		int lastrow = sheet.getLastRowNum();
		System.out.println(lastrow);
		
		sheet.getRow(lastrow).createCell(8).setCellValue(value);
		FileOutputStream fs = new FileOutputStream(file);
		wb.write(fs);
		
		
	}
	

}
