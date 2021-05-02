package com.selenium.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.selenium.driver.Driver;

public class BaseTest {

	protected BaseTest() {

	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) {

		Map<String, String> browserinfo = (Map<String, String>) data[0];
		Driver.initDriver(browserinfo.get("Browser"));

	}

	@AfterMethod
	protected void tearDown() {

		Driver.quitDriver();

	}
}
