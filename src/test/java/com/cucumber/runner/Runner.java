package com.cucumber.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.cucumber.org.Amazon.BaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\cucumber\\feature", glue = "com\\cucumber\\setdefinition", monochrome = true, dryRun = false, strict = true)

public class Runner {
	public static WebDriver driver;

	@org.junit.BeforeClass
	public static void setUp() {
		driver = BaseClass.Browser_Lunch("chrome");
	}

//	@AfterClass
//	public static void tearDown() {

	//	driver.quit();

	}


