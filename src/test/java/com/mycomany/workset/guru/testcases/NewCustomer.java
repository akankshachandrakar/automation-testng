package com.mycomany.workset.guru.testcases;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mycomany.workset.guru.basetest.Base;
import com.relevantcodes.extentreports.LogStatus;

public class NewCustomer extends Base{

	@Test
	public void createCustomer() throws UnsupportedEncodingException{
		test =rep.startTest("start creating new user");
		openBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
		driver.manage().window().maximize();
		navigate("Host");
		doLogin("username","password1");
		click("newcustomer_link");
		textSend("customer_xpath","salman khan");
		/**
		 * select the radio
		 */
		
		textSend("dob_xpath","27/12/1965");
		textSend("address_xpath","Bandra");
		textSend("city_xpath","Mumbai");
		textSend("Pin_xpath","400050");
		textSend("mobile_xpath","748948959");
		textSend("Email_xpath","ashi.3005@gmail.com");
		textSend("emailpassword_xpath","ashi3005");
		test.log(LogStatus.PASS, "Testcase passed.");
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
	
	
}
