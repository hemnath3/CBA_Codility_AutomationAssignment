package com.selenium.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	private DriverManager() {
		
		
	}
	
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	
	public static WebDriver getDriver() {		
		return driver.get();
	}
	
	public static void setDriver(WebDriver driverparm) {
		
		driver.set(driverparm);
	}
	
	public static void remove() {
		
		driver.remove();
	}

}
