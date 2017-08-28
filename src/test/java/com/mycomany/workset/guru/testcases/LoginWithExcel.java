 package com.mycomany.workset.guru.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mycomany.workset.guru.basetest.Base;
import com.mycomany.workset.guru.util.Dataprovider;

public class LoginWithExcel extends Base {

	@Test(dataProvider = "getdata")
	public void TestT(Hashtable<String, String> Data)
			throws UnsupportedEncodingException {
		openBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
		driver.manage().window().maximize();
		navigate("Host");
		doLogin(Data.get("username"), Data.get("password"));
		
		try {
			Alert alert = driver.switchTo().alert();
			String errMsg = alert.getText();
			Assert.assertTrue(
					errMsg.equalsIgnoreCase("user or password is not valid"));
		} catch (NoAlertPresentException e) {
			Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage",
					"Login failure");
		}
	}

	@DataProvider
	public Object[][] getdata()  {

		init();
		FileInputStream dataFile1 = null;
		String Test1 = "login";
		try {
			dataFile1 = new FileInputStream(prop.getProperty("xls_path"));
			return Dataprovider.getTestData(dataFile1, Test1);
			// prop.load(dataFile1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new TestException("exception", e);
		}

		
	}
	@AfterMethod
	public void quit() {
		rep.endTest(test);
		rep.flush();
		if (driver != null) {
			driver.quit();
		}
	}
}