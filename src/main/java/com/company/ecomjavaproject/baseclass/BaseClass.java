package com.company.ecomjavaproject.baseclass;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.company.ecomjavaproject.helper.LoggerHelper;
import com.company.ecomjavaproject.utilities.ObjectReader;
import com.company.ecomjavaproject.utilities.PropertyReader;

/**
 * 
 * @author Arvind.Kumar
 *
 */

public class BaseClass {
     
	public static WebDriver driver;
	private Logger log = LoggerHelper.getLogger(BaseClass.class);
	
	@BeforeClass
	public void setup()
	{
		if(ObjectReader.reader.getBrowserType().equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",ObjectReader.reader.getChromePath());
			driver=new ChromeDriver();
		}
		else if(ObjectReader.reader.getBrowserType().equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",ObjectReader.reader.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		else if(ObjectReader.reader.getBrowserType().equals("ie")) 
		{
			System.setProperty("webdriver.ie.driver",ObjectReader.reader.getIEPath());
			driver=new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.get(ObjectReader.reader.getURL());
	
	}
	

	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethod(Method method){
		log.info("*******************"+method.getName()+"Started********************");
	}
	
	@AfterMethod
	public void afterMethod(Method method){
		log.info("*******************"+method.getName()+"Ended********************");
	}
	
	@BeforeTest
	public void beforeTest() {
		ObjectReader.reader = new PropertyReader();
	}
	
}