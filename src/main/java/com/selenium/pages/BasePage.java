package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.driver.DriverManager;
import com.selenium.enums.WaitStrategy;
import com.selenium.factories.ExplicitWaitFactory;
import com.selenium.reports.ExtentLogger;

public class BasePage {

	protected void click(By by, WaitStrategy waitstrategy,String elementname) {

		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.click();
		try {
			Thread.sleep(1000);
			ExtentLogger.pass(elementname+" is clicked",true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	protected void sendKeys(By by, String value, WaitStrategy waitstrategy,String elementname) {

		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		try {
			ExtentLogger.pass(value+" is entered in "+elementname,true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	protected String getPagetitle() {

		return DriverManager.getDriver().getTitle();
	}

}
