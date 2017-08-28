package com.mycomany.workset.guru.testcases;

import java.io.UnsupportedEncodingException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mycomany.workset.guru.basetest.Base;
import com.relevantcodes.extentreports.LogStatus;

public class LoginUser extends Base {
	// To check postive scenario
	@Test
	public void LoginTest() throws UnsupportedEncodingException {
		test =rep.startTest("start test Login user");
		openBrowser("chrome");
		navigate("Host");
		doLogin("username", "password1");
		test.log(LogStatus.INFO, "Login pass.");
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage",
				"Login failure");
		test.log(LogStatus.PASS, "Login passed.");
		Reporter.log("i am here");
		takeScreenShot();

	}
	/**
	 * In
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void NegativeTest1() throws Exception {
		openBrowser("chrome");
		navigate("Host");
		doLogin("username", "password2");
		new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		// check if alert exist
		String errMsg = alert.getText();
		Assert.assertTrue(errMsg.equalsIgnoreCase("user or password is not valid"));
		takeScreenShot();
	}
	@AfterMethod
	public void quit() {
		rep.endTest(test);
		rep.flush();
		if (driver != null) {
			driver.quit();
		}
	}
	@DataProvider
	public Object[][] getdata()
	{
		return null;
	}
	
	
}

