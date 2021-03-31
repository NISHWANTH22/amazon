package com.pom.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Step1 {
	
	public static WebDriver driver;
	
	@FindBy(partialLinkText = "New Apple iPhone 12 (128GB) - Blue")
	private WebElement mobile;
	

	public Step1(WebDriver mdriver) {
		this.driver=mdriver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getMobile() {
		return mobile;
	}
	

}
