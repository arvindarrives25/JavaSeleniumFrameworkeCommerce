package com.company.ecomjavaproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Arvind.Kumar
 *
 */

public class PropertyReader implements ConfigReader {
	
	public Properties prop;
	public PropertyReader()
	{
		File src = new File("./configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	@Override
	public String getBrowserType() {
		return prop.getProperty("browserType");
	}

	@Override
	public String getChromePath() {
		return prop.getProperty("chromePath");
	}

	@Override
	public String getFirefoxPath() {
		return prop.getProperty("firefoxPath");
	}

	@Override
	public String getIEPath() {
		return prop.getProperty("iePath");
	}

	@Override
	public String getUserName() {
		return prop.getProperty("userName");
	}

	@Override
	public String getPassword() {
		return prop.getProperty("password");
	}

	@Override
	public String getURL() {
		return prop.getProperty("baseURL");
	}

	@Override
	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("implicitWait"));
	}

	@Override
	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("explicitWait"));
	}

	@Override
	public int getPageLoadWait() {
		return Integer.parseInt(prop.getProperty("pageLoadWaitTime"));
	}

}