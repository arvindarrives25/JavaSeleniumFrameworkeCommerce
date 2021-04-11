package com.company.ecomjavaproject.utilities;

public interface ConfigReader {
	
	public String getBrowserType();
	public String getChromePath();
	public String getFirefoxPath();
	public String getIEPath();
	public String getUserName();
	public String getPassword();
	public String getURL();
	public int getImplicitWait();
	public int getExplicitWait();
	public int getPageLoadWait();

}
