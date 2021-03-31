package com.cucumber.org.Amazon;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver Browser_Lunch(String Browsername) {

		if (Browsername.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (Browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (Browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\driver\\IEdriverserver.exe");
			driver = new InternetExplorerDriver();

		} else {
			System.out.println("invalid browser");
		}
		// driver.manage().window().maximize();
		return driver;

	}

//	get URL
	public static void URL(String url) {
		driver.get(url);
	}

	public static void NavigetTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigeteback1() {
		driver.navigate().back();
	}

	public static void forward() {
		driver.navigate().forward();
	}

	public static void navigaterefresh() {
		driver.navigate().refresh();
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void simplealert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public static void confirmalert(String option) {
		Alert a = driver.switchTo().alert();
		if (option.equalsIgnoreCase("ok")) {
			a.accept();
		} else if (option.equalsIgnoreCase("dismiss")) {
			a.dismiss();
		} else {
			System.out.println("invalid");
		}
	}

	public static void promptalert(String value, String option) {
		Alert pr = driver.switchTo().alert();

		pr.sendKeys(value);
		if (option.equalsIgnoreCase("ok")) {
			pr.accept();
		} else if (option.equalsIgnoreCase("dismiss")) {
			pr.dismiss();
		} else {
			System.out.println("invalid");
		}
	}

	public static void Actions(WebElement Element) {
		org.openqa.selenium.interactions.Actions ac = new org.openqa.selenium.interactions.Actions(driver);
		ac.contextClick(Element).build().perform();
	}

	public static void draganddrop(WebElement Element, WebElement Element1) {
		org.openqa.selenium.interactions.Actions ad = new org.openqa.selenium.interactions.Actions(driver);
		ad.dragAndDrop(Element, Element1).build().perform();
	}

	public static void doubleclick(WebElement Elements) {
		org.openqa.selenium.interactions.Actions dc = new org.openqa.selenium.interactions.Actions(driver);
		dc.doubleClick(Elements).build().perform();
	}

	public static void robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void selection(WebElement elements, String option, String value) {
		Select sc = new Select(elements);
		if (option.equalsIgnoreCase("byindex")) {
			int parseInt = Integer.parseInt(value);
			sc.selectByIndex(parseInt);
		} else if (option.equalsIgnoreCase("byvalue")) {
			sc.selectByValue(value);
		} else if (option.equalsIgnoreCase("byvisibletext")) {
			sc.selectByVisibleText(value);
			
		}else if (option.equalsIgnoreCase("byindex")) {
			int parseInt1 = Integer.parseInt(value);
			sc.deselectByIndex(parseInt1);
		}else if (option.equalsIgnoreCase("byvalue")) {
			sc.deselectByValue(value);
		}else if (option.equalsIgnoreCase("byvisibletext")) {
			sc.deselectByVisibleText(value);
		}else {
			System.out.println("Invalid");
		}
		
	}

	public static void frame(String option, String value, String index, String element) {
		if (option.equalsIgnoreCase("byindex")) {
			int index1 = Integer.parseInt(value);
			driver.switchTo().frame(index1);
		} else if (option.equalsIgnoreCase("byelement")) {
			driver.switchTo().frame(element);
		} else if (option.equalsIgnoreCase("bystring")) {
			driver.switchTo().frame(value);
		} else {
			System.out.println("invalid frame");
		}
	}

	public static void parentframe() {
		driver.switchTo().parentFrame();
	}
	public static  void content() {
		driver.switchTo().defaultContent();
	}
	//sendkey
	public static void sendkeys(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// click
	public static void click(WebElement element) {
		element.click();
		
	}
	//clear
	public static void clear(WebElement element) {
		element.clear();
	}
//	wait
	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	//explict wait
	public static void explictwait(long timeout, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//quit
	public static void quit() {
		driver.quit();
		
	}
	//get tittle
	public static void title() {
		driver.getTitle();
	}
	//current url
	public static void getcurrenturl() {
		driver.getCurrentUrl();
	}
	//text
	public static void text(WebElement element) {
		element.getText();
	}
	//attribute
	public static void attribute(WebElement element, String value) {
		element.getAttribute(value);
	}
	
	public static void dropdown(WebElement Element,String option) {
		Select s = new Select(Element);
		if (option.equalsIgnoreCase("get option")) {
			s.getOptions();
		}else if (option.equalsIgnoreCase("get first selected option")) {
			s.getFirstSelectedOption();
		}else if (option.equalsIgnoreCase("get all selected option")) {
			s.getAllSelectedOptions();
			
		}
	}
	//is multiple
	public static void ismultiple(WebElement element) {
		Select s = new Select(element);
		s.isMultiple();
	}
	//is selected
	public static void isselected(WebElement element) {
		element.isSelected();
	}
	//is enbale
	public static void isenable(WebElement element) {
		element.isEnabled();
		
	}
	//is displayed
	public static void isdisplayed(WebElement element) {
		element.isDisplayed();
	}
		
		public static void scrollupanddown(WebElement element) {
			JavascriptExecutor ref = (JavascriptExecutor) driver;
			ref.executeScript("arguments[0].scrollIntoView(true)", element);
		//	js.executeScript("window.scrollby(0,3000)")
				
		}	
		

		
		
//ScreenShot BaseClass
		public static void screenshot(String filepath) throws Throwable {

			
				try {
					TakesScreenshot ts = (TakesScreenshot) driver;
					File srcFile = ts.getScreenshotAs(OutputType.FILE);
					File dstFile = new File(filepath);
					FileUtils.copyFile(srcFile, dstFile);
				} catch (WebDriverException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
}
	
	
	

