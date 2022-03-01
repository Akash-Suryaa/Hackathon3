package com.myshop.step;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BillingDetailsPo extends InitilizeBrowser {

	static String fname_value = "billing_first_name";
	static String lname_value = "billing_last_name";
	static String company_value = "billing_company";

	static String email_value = "billing_email";
	static String phone_value = "billing_phone";

	static String country_value = "s2id_billing_country";
	static String all_country_value = "//ul[@id=\"select2-results-1\"]/li/div";

	static String address_value1 = "billing_address_1";
	static String address_value2 = "billing_address_2";

	static String city_value = "billing_city";

	static String state_value = "select2-chosen-2";
	static String all_state_value = "//ul[@id=\"select2-results-2\"]/li/div";

	static String pincode_value = "billing_postcode";
	
	static String paymentMode_value = "//div[@id=\"payment\"]/ul/li/input";
	static String palceorder_value = "//input[@id=\"place_order\"]";
	
	
	
	

	public static void fill_billing_Details() throws InterruptedException {

		WebElement fname_txt = driver.findElement(By.id(fname_value));
		fname_txt.clear();
		fname_txt.sendKeys("Akash");

		WebElement lname_txt = driver.findElement(By.id(lname_value));
		lname_txt.clear();
		lname_txt.sendKeys("surywanshi");

		WebElement company_txt = driver.findElement(By.id(company_value));
		company_txt.clear();
		company_txt.sendKeys("XYZ");

		WebElement email_txt = driver.findElement(By.id(email_value));
		email_txt.clear();
		email_txt.sendKeys("akash@gmail.com");

		WebElement phone_txt = driver.findElement(By.id(phone_value));
		phone_txt.clear();
		phone_txt.sendKeys("9090909090");

		WebElement country_txt = driver.findElement(By.id(country_value));
		country_txt.click();
		Thread.sleep(2000);
		// List--
		List<WebElement> allcounty = driver.findElements(By.xpath(all_country_value));
		System.out.println(allcounty.size());

		for (WebElement e : allcounty) {
			String country = e.getText();
			System.out.println(country);
			if (country.equals("India")) {
				e.click();
				break;
			}
		}

		WebElement address_txt1 = driver.findElement(By.id(address_value1));
		address_txt1.clear();
		address_txt1.sendKeys("Pune");

		WebElement address_txt2 = driver.findElement(By.id(address_value2));
		address_txt2.clear();
		address_txt2.sendKeys("Pune ");

		WebElement city_txt = driver.findElement(By.id(city_value));
		city_txt.clear();
		city_txt.sendKeys("Pune ");

		WebElement state_txt = driver.findElement(By.id(state_value));
		state_txt.click();
		// list

		List<WebElement> allstate = driver.findElements(By.xpath(all_state_value));
		//System.out.println(allstate.size());

		for (WebElement e : allstate) {
			String state = e.getText();
			System.out.println(state);
			if (state.equals("Maharashtra")) {
				e.click();
				break;
			}
		}

		WebElement pincode_txt = driver.findElement(By.id(pincode_value));
		pincode_txt.clear();
		pincode_txt.sendKeys("Pune ");
		
	
		
		

	}
	
	public static  void select_payment()
	{
		List<WebElement> allPaymetnmode=driver.findElements(By.xpath(paymentMode_value));
		System.out.println(allPaymetnmode.size());
		for(WebElement e : allPaymetnmode)
		{
			String value =e.getAttribute("value");
			System.out.println("payment value :"+value);
			if(value.equals("cod"))
			{
				e.click();
				break;
			}
		}
		
	}
	
	
	public  static void placedOrder()throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement placedoderelem =driver.findElement(By.xpath(palceorder_value));
		placedoderelem.click();
	}

}
