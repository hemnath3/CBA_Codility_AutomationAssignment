package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.driver.DriverManager;
import com.selenium.enums.WaitStrategy;

public final class CodilityIslandHomePage extends BasePage {

	

	private final By searchquerybox = By.id("search-input");
	private final By searchbtn = By.xpath("//button[text()='Search']");
	

	public CodilityIslandHomePage enterSearchKeyWord(String keyword) {

		sendKeys(searchquerybox, keyword,WaitStrategy.PRESENCE,"searchbox");
		return this;

	}

	

	public CodilityIslandHomePage clickSearchBtn() {

		click(searchbtn,WaitStrategy.CLICKABLE,"Search button");
		return new CodilityIslandHomePage();
	}

	public boolean getExpText(String exptext) {

		return DriverManager.getDriver().getPageSource().contains(exptext);
	}


}
