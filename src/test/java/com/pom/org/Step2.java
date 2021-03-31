package com.pom.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Step2 {
	
	public static WebDriver driver;
	
	@FindBy(xpath = "(//div[@id='addToCart_feature_div'])[2]")
	private WebElement add;

	public Step2(WebDriver adriver) {
		this.driver=adriver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdd() {
		return add;
	}
	
	

}
