package com.selenium.constants;

import com.selenium.enums.ConfigProperties;
import com.selenium.utils.PropertyFileUtils;

//Class is made final so that other classes cannot extent this class. 

//Has a private constructor so that other classes cannot create an object. Use the getter method to access the constant variable

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String BASEPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = BASEPATH + "/executables/chromedriver.exe";
	private static final String FIREFOXDRIVERPATH = BASEPATH + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = BASEPATH + "/config/config.properties";
	private static final String EXCELPATH=BASEPATH+"/testData/Sample.xlsx";	
	private static final String RUNMANAGERSHEET="RUNMANAGER";
	private static final String ITERATIONSHEET="DATA";
	private static final int EXPLICITWAIT=10;
	private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/Results";
	private static String extentReportFilePath="";

	public static String getExtentreportFilepath() {
		
		if(extentReportFilePath.isEmpty()) {
			
			extentReportFilePath=createReportPath();
		}
		
		return extentReportFilePath;
	}
	
	private static String createReportPath() {
		
		if(PropertyFileUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			
			return EXTENTREPORTFOLDERPATH+"/"+System.currentTimeMillis()+"index.html";
		}
		
		else{
			
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}



	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}
	

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	
	public static String getFirefoxdriverpath() {
		return FIREFOXDRIVERPATH;
	}

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getIterationsheet() {
		return ITERATIONSHEET;
	}

}
