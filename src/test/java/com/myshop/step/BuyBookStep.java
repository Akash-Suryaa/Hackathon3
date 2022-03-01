package com.myshop.step;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuyBookStep extends InitilizeBrowser {

	@Given("^user open the browser and open url$")
	public void user_open_the_browser_and_open_url() {
		driver = initBrowser();
	}

	@When("^user click on shop menu$")
	public void user_click_on_shop_menu() {
		WebElement shop_btn = driver.findElement(By.xpath(AllElements.shopBtn));
		shop_btn.click();
	}

	@When("^click on Home menu button$")
	public void click_on_Home_menu_button() {
		WebElement home_btn = driver.findElement(By.xpath(AllElements.homeBtn));
		home_btn.click();
	}

	@Then("^verify three arrivals are displayed$")
	public void verify_three_arrivals_are_displayed() {

		AllElements.list_of_arrivals = driver.findElements(By.xpath(AllElements.totalarrivals));
		int count = AllElements.list_of_arrivals.size();
		System.out.println(" list_of_arrivals : " + count);
		assertEquals(3, count);
	}

	@Then("^User select any one image in arrival$")
	public void user_select_any_one_image_in_arrival() throws InterruptedException {
		int cnt = 0;

		for (WebElement e : AllElements.list_of_arrivals) {
			cnt++;
			if (cnt == 3) {
				System.out.println("Click - 3rd book");
				e.click();
			}

		}

		/*System.out.println("" + AllElements.list_of_arrivals.size());
		int total = AllElements.list_of_arrivals.size();

		int cntno = 0;
		for (int i = 0; i < total; i++) {
			if (cntno == 0) {
				driver.findElement(By.xpath("(//ul[@class=\"products\"]/li)[1]")).click();
				Thread.sleep(2000);
				driver.navigate().back();
				cnt++;
			}

			if (cntno == 1) {
				driver.findElement(By.xpath("(//ul[@class=\"products\"]/li)[2]")).click();
				Thread.sleep(2000);
				driver.navigate().back();
				cnt++;
			}
			if (cntno == 2) {
				driver.findElement(By.xpath("(//ul[@class=\"products\"]/li)[3]")).click();
				Thread.sleep(2000);
				driver.navigate().back();
				cnt++;
			}

		}*/

		/*
		 * for (WebElement e : AllElements.list_of_arrivals) { Thread.sleep(5000);
		 * System.out.println(e.getText()); e.click(); Thread.sleep(2000); WebElement
		 * book_stock = driver.findElement(By.xpath(AllElements.stock_contains));
		 * System.out.println(book_stock.getText());
		 * 
		 * if (book_stock.getText().contains("Out of stock")) {
		 * driver.navigate().back(); Thread.sleep(2000); driver.navigate().refresh(); }
		 * else { Thread.sleep(2000); System.out.println(book_stock.getText());
		 * driver.findElement(By.xpath(AllElements.add_to_basket)).click(); break; }
		 * 
		 * }
		 */

	}

	@Then("^User add book into the basket$")
	public void user_add_book_into_the_basket() {

		WebElement book_price_elem = driver.findElement(By.xpath(AllElements.book_price));
		AllElements.book_price_value = book_price_elem.getText();
		WebElement add_basket_btn = driver.findElement(By.xpath(AllElements.add_to_basket));
		add_basket_btn.click();
		System.out.println("Add Book Into the Basket");

	}

	@Then("^user should able to view that added book$")
	public void user_should_able_to_view_that_added_book() {
		WebElement view_basket_btn = driver.findElement(By.xpath(AllElements.basket_view));
		view_basket_btn.click();
		System.out.println("Add Book Into the Basket");
	}

	@Then("^user verify total and subtotal values$")
	public void user_verify_total_and_subtotal_values() {

		List<WebElement> allTotal = driver.findElements(By.xpath(AllElements.subtotal_ckh));
		System.out.println("allTotal count : " + allTotal.size());
		int cnt = 0;

		float subtotalvalue = 0;
		float taxvalue = 0;
		for (WebElement e : allTotal) {
			if (cnt == 0) {
				String v = e.getText();
				String[] array = v.split("₹");
				System.out.println("array : " + array[1]);
				subtotalvalue = Float.parseFloat(array[1]);
				System.out.println("subtotalvalue form text :" + subtotalvalue);

				if (AllElements.book_price_value.equals(e.getText())) {
					assertTrue("Subtotal is Right ", true);
				}
			} else if (cnt == 1) {
				System.out.println("tax : " + e.getText());
				String v = e.getText();
				String[] array = v.split("₹");
				System.out.println("array : " + array[1]);
				taxvalue = Float.parseFloat(array[1]);
				System.out.println("taxvalue from text is : " + taxvalue);
			}
			cnt++;
		}

		WebElement total_cnt = driver.findElement(By.xpath(AllElements.total_ckh));
		String totalcnt_txt = total_cnt.getText();

		String[] array = totalcnt_txt.split("₹");
		System.out.println("array : " + array[1]);
		float t1 = Float.parseFloat(array[1]);
		System.out.println("Total text :" + t1);

		float t = subtotalvalue + taxvalue;
		System.out.println("totalcnt_txt :" + t1);
		System.out.println("Total is :" + t);
		Assert.assertEquals(t, t1);

		// assertEquals(totalcnt_txt, t);

	}

	@Then("^click on checkout button$")
	public void click_on_checkout_button() {

		WebElement check_out_btn = driver.findElement(By.xpath(AllElements.proceed_to_chk));
		check_out_btn.click();
		System.out.println("click on proceed to check_out_btn");

	}

	@Then("^User naviaget to payment gateway page$")
	public void user_naviaget_to_payment_gateway_page() throws InterruptedException {
		System.out.println("Billing Page");
		BillingDetailsPo.fill_billing_Details();

	}

	@Then("^user select the payment option$")
	public void user_select_the_payment_option() {
		BillingDetailsPo.select_payment();

	}

	@Then("^user placed the order$")
	public void user_placed_the_order() throws InterruptedException {
		BillingDetailsPo.placedOrder();
	}

	@Then("^user should navigate to order confirmation page$")
	public void user_should_navigate_to_order_confirmation_page() {

		WebElement conformtxt = driver.findElement(By.xpath(AllElements.conform_page));

		String value = conformtxt.getText();
		if (value.contains("Order Details")) {
			System.out.println("order Conform ");
		}
	}

	@Then("^close Browser$")
	public void close_Browser() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();

	}

}
