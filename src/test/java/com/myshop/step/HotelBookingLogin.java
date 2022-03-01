package com.myshop.step;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HotelBookingLogin extends InitilizeBrowser {

	@Given("^user navigate to Search Hotel page$")
	public void user_navigate_to_Search_Hotel_page() {
		driver = initBrowser();
		driver.get("http://adactinhotelapp.com/SearchHotel.php");
		driver.findElement(By.id("username")).sendKeys("swaradasuratekar");
		driver.findElement(By.id("password")).sendKeys("Swarada123");
		driver.findElement(By.id("login")).click();
	}

	@When("^fill mandetory information$")
	public void fill_mandetory_information() throws IOException, InterruptedException {

		String locationstrvalue;
		String hotelstrvalue;
		String roomstrvalue;
		String room_nostrvalue;
		String check_instrvalue;
		String check_outstrvalue;
		String adultstrvalue;
		String childstrvalue;

		File file = new File("F:\\ExcelRead\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet3");
		int lastrow = sheet.getLastRowNum();

		WebElement loc_elem = driver.findElement(By.id("location"));
		WebElement hotels_elem = driver.findElement(By.id("hotels"));
		WebElement rooms_elem = driver.findElement(By.id("room_type"));
		WebElement room_num_elem = driver.findElement(By.id("room_nos"));
		WebElement checkin_elem = driver.findElement(By.id("datepick_in"));
		WebElement checkout_elem = driver.findElement(By.id("datepick_out"));
		WebElement adult_num_elem = driver.findElement(By.id("adult_room"));
		WebElement child_num_elem = driver.findElement(By.id("child_room"));


		for (int i = 1; i <= lastrow; i++) // For excel
		{

			loc_elem.click();
			locationstrvalue = sheet.getRow(i).getCell(0).getStringCellValue();
			HotelBookingUtil.select_Value(loc_elem, locationstrvalue);

			hotels_elem.click();
			hotelstrvalue = sheet.getRow(i).getCell(1).getStringCellValue();

			HotelBookingUtil.select_Value(hotels_elem, hotelstrvalue);

			rooms_elem.click();
			roomstrvalue = sheet.getRow(i).getCell(2).getStringCellValue();

			HotelBookingUtil.select_Value(rooms_elem, roomstrvalue);

			room_num_elem.click();
			room_nostrvalue = String.valueOf(sheet.getRow(i).getCell(3).getNumericCellValue());

			HotelBookingUtil.select_Value(room_num_elem, room_nostrvalue);


			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			check_instrvalue = formatter.format(sheet.getRow(i).getCell(4).getDateCellValue());
			checkin_elem.clear();
			checkin_elem.sendKeys(check_instrvalue);

			check_outstrvalue = formatter.format(sheet.getRow(i).getCell(5).getDateCellValue());
			checkout_elem.clear();
			checkout_elem.sendKeys(check_outstrvalue);

			adult_num_elem.click();
			adultstrvalue = String.valueOf((int) sheet.getRow(i).getCell(6).getNumericCellValue());
			HotelBookingUtil.select_Value(adult_num_elem, adultstrvalue);

			child_num_elem.click();

			childstrvalue = String.valueOf((int) sheet.getRow(i).getCell(7).getNumericCellValue());
			HotelBookingUtil.select_Value(child_num_elem, childstrvalue);
		}
	}

	@Then("^click on search option$")
	public void click_on_search_option() throws InterruptedException {

		driver.findElement(By.id("Submit")).click();

	}

	@Then("^Select Hotel$")
	public void select_Hotel() {
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();

	}

	@Then("^Book Hotel$")
	public void book_Hotel() {

		HotelBookingPage.bookHotel();
	}

	@Then("^Verify Order ID$")
	public void verify_Order_ID() throws IOException {
		
		HotelBookingPage.verify_OrderId();
		
	}

}
