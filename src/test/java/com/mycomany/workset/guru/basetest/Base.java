package com.mycomany.workset.guru.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mycomany.workset.guru.util.Base64Util;
import com.mycomany.workset.guru.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base {
	protected WebDriver driver;
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;
	public Properties prop;
	protected Alert alert;
	public void openBrowser(String btype) {
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream fil = new FileInputStream(
						System.getProperty("user.dir")
								+ "\\src\\test\\resources\\confiq.properties");
				prop.load(fil);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (btype.equalsIgnoreCase("Mozila")) {
			System.setProperty("webdriver.gecko.driver",
					"driver/firefox/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (btype.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"driver/chrome/chromedriver.exe");
			driver = new ChromeDriver();
		}

	}
	public WebElement getElement(String locator) {
		WebElement element = null;
		try {
			if (locator.endsWith("_xpath")) {
				element = driver
						.findElement(By.xpath(prop.getProperty(locator)));
			} else if (locator.endsWith("id")) {
				element = driver.findElement(By.id(prop.getProperty(locator)));
			} else if (locator.endsWith("link")){
				element = driver.findElement(By.linkText(prop.getProperty(locator)));
			}
			else {
				Assert.fail("locator not found");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return element;

	}

	public void click(String locator) {
		getElement(locator).click();
	}
	public void navigate(String host) {
		driver.get(prop.getProperty(host));
	}
	public void type(String locator, String keys) {
		 getElement(locator).sendKeys(prop.getProperty(keys));
		//getElement(locator).sendKeys(keys);
	}
	public void doLogin(String username, String password1)
			throws UnsupportedEncodingException {
		type("userid_xpath", username);
		 String decoded = Base64Util.decode(prop.getProperty(password1));
		getElement("password_xpath").sendKeys(decoded);
		//type("password_xpath", decoded);
		click("sumbit_xpath");

	}
	public void textSend(String locator, String keys) {
		 
		getElement(locator).sendKeys(keys);
	}
	@BeforeMethod
	public void init() {
		if (prop == null) {
			prop = new Properties();

			try {
				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir")
								+ "//src//test//resources//confiq.properties");
				prop.load(fs);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public boolean islAlertPresnt() {
		boolean isPresent = false;
		try {
			Alert alert = driver.switchTo().alert();
			if (null != alert) {
				isPresent = true;
			}
		} catch (NoAlertPresentException ex) {
			// logging
		}
		return isPresent;
	}
	public void takeScreenShot(){
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//"
					+ "screenshots//"+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catcsh block
			e.printStackTrace();
		}
		//put screenshot file in reports
		test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		
	}
}
