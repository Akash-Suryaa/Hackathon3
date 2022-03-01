package com.myshop.step;

import java.util.List;

import org.openqa.selenium.WebElement;

public class AllElements {
	
	static String shopBtn = "//a[text()=\"Shop\"]";
	static String homeBtn = "//a[text()=\"Home\"]";
	static String totalarrivals ="//ul[@class=\"products\"]/li/a/h3";  //"//ul[@class=\"products\"]/li/a/img";  //"//ul[@class=\"products\"]/li";
	static List<WebElement> list_of_arrivals;
	static String stock_contains = "//p[contains(@class,\"stock\")]";
	static String add_to_basket = "//button[text()=\"Add to basket\"]";
	static String basket_view = "//a[text()=\"View Basket\"]";
	static String proceed_to_chk = "//div[@class=\"wc-proceed-to-checkout\"]/a";
	static String book_price = "//p[@class=\"price\"]/span";
	
	static String subtotal_ckh = "//table[@class=\"shop_table shop_table_responsive\"]/tbody/tr/td/span";
	static String total_ckh = "//table[@class=\"shop_table shop_table_responsive\"]/tbody/tr/td/strong/span";

	
	static String book_price_value = "";
	static String conform_page = "//h2[text()=\"Order Details\"]";
	
	
	
	
	
	
	

}
