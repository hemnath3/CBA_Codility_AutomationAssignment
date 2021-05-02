package com.selenium.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.selenium.constants.FrameworkConstants;
import com.selenium.exceptions.FrameworkException;
import com.selenium.exceptions.InvalidPathForExcelException;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String, String>> getTestDetails(String sheetname) {

		
		List<Map<String, String>> list = null;

		try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath());) {

			
			Workbook wb = WorkbookFactory.create(fs);
			Sheet sh = wb.getSheet(sheetname);

			int rowCount = sh.getLastRowNum();
			int colCount = sh.getRow(0).getLastCellNum();

			Map<String, String> data = null;
			list = new ArrayList<>();

			for (int i = 1; i <= rowCount; i++) {

				data = new HashMap<>();

				for (int j = 0; j < colCount; j++) {

					String key = sh.getRow(0).getCell(j).getStringCellValue();
					String value = sh.getRow(i).getCell(j).getStringCellValue();
					data.put(key, value);

				}
				list.add(data);
			}

		}

		catch (FileNotFoundException e) {

			throw new InvalidPathForExcelException("The excel file "+FrameworkConstants.getExcelpath()+" you're trying to read is not found. Check the file name");
		}

		catch (IOException e) {

			throw new FrameworkException("IO exception happened while trying to read the excel file");
		}

		

		return list;

	}

}
