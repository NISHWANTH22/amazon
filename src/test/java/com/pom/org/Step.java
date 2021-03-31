package com.pom.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Step {

	public static WebDriver driver;
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement product;
	
	@FindBy(xpath = "//input[contains(@id,'nav-search')]")
	private WebElement click;

	
	
	
	public Step(WebDriver pdriver) {
		this.driver=pdriver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getClick() {
		return click;
	}
}
