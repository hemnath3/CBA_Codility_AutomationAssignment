package com.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.selenium.constants.FrameworkConstants;
import com.selenium.enums.ConfigProperties;
import com.selenium.exceptions.PropertyFileException;

public final class PropertyFileUtils {

	private PropertyFileUtils() {

	}

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {

		try (FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath())) {

			property.load(file);

			property.entrySet().forEach(
					entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));

		}

		catch (IOException e) {

			e.printStackTrace();
			System.exit(0);

		}

	}

	public static String get(ConfigProperties key) {

		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {

			throw new PropertyFileException("Property name " + key + " is not found in the config.properties");
		}

		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
