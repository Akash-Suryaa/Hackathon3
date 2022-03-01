package com.myshop.step;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitilizeBrowser {

	public static WebDriver driver = null;

	public static WebDriver initBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.get("http://practice.automationtesting.in/");
		return driver;
	}

	/*
	 * public static WebDriver initBrowserworldoMeter() {
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 * driver.manage().window().maximize();
	 * driver.get("http://practice.automationtesting.in/"); return driver; }
	 */

}
