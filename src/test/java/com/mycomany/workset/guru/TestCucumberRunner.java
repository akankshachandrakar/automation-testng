package com.mycomany.workset.guru;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {
		"src/test/java/com/mycomany/workset/guru/feature"}, glue = {
				"com/mycomany/workset/guru/steps"}, plugin = {"pretty",
						"html:target/cucumber-html-report"})
public class TestCucumberRunner extends AbstractTestNGCucumberTests {

}
