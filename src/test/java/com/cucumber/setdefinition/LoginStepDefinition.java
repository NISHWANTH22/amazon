package com.cucumber.setdefinition;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;

import com.cucumber.org.Amazon.BaseClass;
import com.pom.org.Step;
import com.pom.org.Step1;
import com.pom.org.Step2;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStepDefinition extends BaseClass {

	public static WebDriver driver = com.cucumber.runner.Runner.driver;
	
	@Given("^User Launch The Application$")
	public void user_Launch_The_Application() throws Throwable {
		
		URL("https://www.amazon.in/");
		implicitlyWait();
	}

	
	Step s = new Step(driver);
	
	@Given("^Enter the user mobile$")
	public void enter_the_user_mobile() throws Throwable {
		sendkeys(s.getProduct(), "iphone12");
	}

	@Then("^Click the search button$")
	public void click_the_search_button() throws Throwable {
		click(s.getClick());
	}
	Step1 s1 = new Step1(driver);
	@Given("^Click the user moblie$")
	public void click_the_user_moblie() throws Throwable {
		click(s1.getMobile());
		
	}
	
	Step2 s2 = new Step2(driver);
	@Given("^User enter the cart$")
	public void user_enter_the_cart() throws Throwable {	
		
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			
			System.out.println(string);
			String title = driver.switchTo().window(string).getTitle();
			System.out.println(title);
			
			}
		click(s2.getAdd());
		}
		
	}
	


	


