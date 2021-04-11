package com.company.ecomjavaproject.helper;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.company.ecomjavaproject.utilities.ObjectReader;

public class CommonFunc {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(CommonFunc.class);
	private List<WebElement> myList;
	private WaitHelper waitHelper;

	public CommonFunc(WebDriver driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}

	/**
	 * This is generic method for common locators and wrapping into a List
	 * @param String, List<WebElement>, WebElement element
	 * @author Arvind.Kumar
	 */
	public void genericLocatorList(String elementToBeClick, List<WebElement> myList, WebElement element) {
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		this.myList = myList;
		for (int i = 0; i < this.myList.size(); i++) {
			if (this.myList.get(i).getText().contains(elementToBeClick)) {
				this.myList.get(i).click();
				break;
			}
		}
	}
	
	/**
	 * This is a custom click method where it waits elements before clicking
	 * @param WebElement element1, WebElement element2
	 * author Arvind.Kumar
	 */
	public void myClick(WebElement element) 
	{
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.click();	
	}
	
	/**
	 * This is a custom sendKeys method where it waits elements before sending String variable 
	 * @param WebElement element1, WebElement element2
	 * author Arvind.Kumar
	 */
	public void mySendKeys(WebElement element,String var) 
	{
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.sendKeys(var);
		log.info("Setting String Value as..... "+var);
	}
	
	/**
	 * This is a custom clear method
	 * @param WebElement element1, WebElement element2
	 * author Arvind.Kumar
	 */
	public void do_clear(WebElement element) 
	{
		waitHelper.waitForElement(element, ObjectReader.reader.getExplicitWait());
		element.clear();
		log.info("Setting String Value as..... ");
	}
	/*public void clickAddPopOverContent(String popOverContents) {
		waitHelper.waitForElement(files, ObjectReader.reader.getExplicitWait());
		List<WebElement> popover_list = addPopOverContents;
		for (int i = 0; i < popover_list.size(); i++) {
			if (popover_list.get(i).getText().contains(popOverContents)) {
				popover_list.get(i).click();
				break;
			}
		}
	}*/

}
