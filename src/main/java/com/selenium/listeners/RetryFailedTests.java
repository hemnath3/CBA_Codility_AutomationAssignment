package com.selenium.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.selenium.enums.ConfigProperties;
import com.selenium.utils.PropertyFileUtils;

public class RetryFailedTests implements IRetryAnalyzer{
	
	private int counter=0;
	private int retry=1;

	@Override
	public boolean retry(ITestResult result) {
		
		
	
			if(PropertyFileUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
					{
			if(counter<retry) {
				
				counter++;
				return true;
			}
					}
		
		
		return false;
	}
	
	

}
