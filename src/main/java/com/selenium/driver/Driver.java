package com.selenium.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import com.selenium.enums.ConfigProperties;
import com.selenium.exceptions.BrowserInvocationException;
import com.selenium.factories.DriverFactory;
import com.selenium.utils.PropertyFileUtils;



public final class Driver {

	private Driver() {

		
	}

	

	public static void initDriver(String browser) {

		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationException("Failed to invoke the browser. please check the capabilities");
			}
			DriverManager.getDriver().get(PropertyFileUtils.get(ConfigProperties.URL));

		}
	}

	public static void quitDriver() {

		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.remove();

		}
	}

}
