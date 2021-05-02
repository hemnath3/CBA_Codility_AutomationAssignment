package com.selenium.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.selenium.constants.FrameworkConstants;

public final class DataProviderUtils {

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {

		String testname = m.getName();

		if (list.isEmpty()) {

			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationsheet());

		}

		List<Map<String, String>> datalist = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).get("TestCaseName").equalsIgnoreCase(testname)
					&& list.get(i).get("Execute").equalsIgnoreCase("Yes")) {

				datalist.add(list.get(i));

			}

		}

		
		return datalist.toArray();
	}

}
