package com.mycomany.workset.guru.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.TestException;
import org.testng.annotations.Test;

public class Login {
	public WebDriver driver =null;

	@Test(expectedExceptions = {TestException.class})
	public void doLoginTest(){
		
		System.setProperty("webdriver.chrome.driver",
				"driver/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr94108");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("dapYham");;
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage",
				"Login failure");
		Reporter.log("Test finished");
	}
	
}
