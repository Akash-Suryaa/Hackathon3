package com.myshop.step;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class PopulationStep extends InitilizeBrowser {

	static String totalCount;
	static String totalTodaysCount;
	static String totalTodaysDeath;
	static String totalTodaysGrowth;
	static String totalYearCount;
	static String totalYearDeath;
	static String totalYearGrowth;

	@Given("^user open the browser and open url worldometer$")
	public void user_open_the_browser_and_open_url_worldometer() {
		driver = initBrowser();
		driver.get("https://www.worldometers.info/world-population/");
	}

	@When("^user get the count of world population$")
	public void user_get_the_count_of_world_population() throws Throwable {

		String c = PopultaionUtil.exceptionUtil("//div[@class='maincounter-number']/span/span[2]");
		String c1 = PopultaionUtil.exceptionUtil("//div[@class='maincounter-number']/span/span[4]");
		String c2 = PopultaionUtil.exceptionUtil("//div[@class='maincounter-number']/span/span[6]");
		String c3 = PopultaionUtil.exceptionUtil("//div[@class='maincounter-number']/span/span[8]");

		totalCount = c + c1 + c2 + c3;
		System.out.println("total world population is " + totalCount);

	}

	@When("^user get the todays count of birth,Deaths and population growth$")
	public void user_get_the_todays_count_of_birth_Deaths_and_population_growth() throws InterruptedException {
		String c = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[1]/span[2]");
		String c1 = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[1]/span[4]");
		totalTodaysCount = c + c1;
		System.out.println("total todays population is " + totalTodaysCount);

		String c2 = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[2]/span[2]");
		String c3 = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[2]/span[4]");
		totalTodaysDeath = c2 + c3;
		System.out.println("total todays death is " + totalTodaysDeath);

		String c4 = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[3]/span[2]");
		String c5 = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[3]/span[4]");
		totalTodaysGrowth = c4 + c5;
		System.out.println("total todays growth is " + totalTodaysGrowth);

	}

	@When("^user get the this years count of birth,Deaths and population$")
	public void user_get_the_this_years_count_of_birth_Deaths_and_population() throws InterruptedException {
		String c = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[4]/span[2]");
		String c1 = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[4]/span[4]");
		String c2 = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[4]/span[6]");
		totalYearCount = c + c1 + c2;
		System.out.println("Year population is " + totalYearCount);

		String c4 = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[5]/span[2]");
		String c5 = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[5]/span[4]");
		totalYearDeath = c4 + c5;
		System.out.println("total death in year " + totalYearDeath);

		String c6 = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[6]/span[2]");
		String c7 = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[6]/span[4]");
		String c8 = PopultaionUtil.exceptionUtil("(//div[@class='sec-counter']/span)[6]/span[6]");
		totalYearGrowth = c6 + c7 +c8;
		System.out.println("total growth in year " + totalYearGrowth);

	}
}
