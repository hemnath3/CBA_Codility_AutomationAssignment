package com.selenium.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selenium.constants.FrameworkConstants;
import com.selenium.enums.CategoryType;

public final class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports extent;

	public static void initReports() {

		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportFilepath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Test Automation Report");
			spark.config().setReportName("Selenium Codility Island Test");

		}
	}

	public static void createTest(String testcasename) {

		ExtentManager.setExtentTest(extent.createTest(testcasename));
	}

	public static void flushReports()  {
		if (Objects.nonNull(extent)) {
			extent.flush();

		}
		
		ExtentManager.remove();
		
		try {
			
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportFilepath()).toURI());
		} 
		
		catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	public static void addAuthors(String[] authors) {

		for (String temp : authors) {

			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}

	public static void addCategories(CategoryType[] categories) {

		for (CategoryType temp : categories) {

			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
}
