package com.myshop.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\myshop\\features", 
				glue = "com\\myshop\\step", 
				monochrome = true, 
			//	dryRun = true,
				tags = {"@bookHotel"}
)
public class Runner {

}
