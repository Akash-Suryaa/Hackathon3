package com.myshop.step;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingUtil {
	
	public  static void select_Value(WebElement elem ,String value)
	{
		Select s = new Select(elem);
		List<WebElement> allelem = s.getOptions();
		
		for (WebElement e : allelem) {
			if (e.getText().contains(value)) {
				s.selectByValue(value);
				break;
			}

		}
		
	}

	
	public  static void select_Value_HotelBook(WebElement elem ,String value)
	{
		Select s = new Select(elem);
		List<WebElement> allelem = s.getOptions();
		
		for (WebElement e : allelem) {
			if (e.getText().contains(value)) 
			{
				s.selectByVisibleText(value);
				break;
			}

		}
		
	}

}
