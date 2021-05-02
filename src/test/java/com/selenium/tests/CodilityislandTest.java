package com.selenium.tests;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.testng.annotations.Test;

import com.selenium.annotations.FrameworkAnnotation;
import com.selenium.enums.CategoryType;
import com.selenium.pages.CodilityIslandHomePage;

public final class CodilityislandTest extends BaseTest {

	private CodilityislandTest() {

	}

	@FrameworkAnnotation(author = { "Hemnath" }, category = { CategoryType.SANITY })
	@Test()
	public void searchIslandTest(Map<String, String> data) {

		CodilityIslandHomePage searchTest = new CodilityIslandHomePage();
		Boolean text = searchTest.enterSearchKeyWord(data.get("keyword")).clickSearchBtn()
				.getExpText(data.get("expisland"));
		assertTrue(text);

	}

	@FrameworkAnnotation(author = { "Hemnath" }, category = { CategoryType.SANITY })
	@Test()
	public void emptyKeywordSearch(Map<String, String> data) {

		CodilityIslandHomePage searchTest = new CodilityIslandHomePage();
		Boolean text = searchTest.clickSearchBtn().getExpText(data.get("errormsg"));
		assertTrue(text);

	}

	@FrameworkAnnotation(author = { "Hemnath" }, category = { CategoryType.SANITY })
	@Test()
	public void searchPortTest(Map<String, String> data) {

		CodilityIslandHomePage searchTest = new CodilityIslandHomePage();
		Boolean text = searchTest.enterSearchKeyWord(data.get("keyword")).clickSearchBtn()
				.getExpText(data.get("expisland"));
		assertTrue(text);

	}

}
