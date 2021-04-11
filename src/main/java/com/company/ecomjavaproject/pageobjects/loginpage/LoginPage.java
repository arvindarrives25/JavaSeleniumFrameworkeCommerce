package com.company.ecomjavaproject.pageobjects.loginpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.company.ecomjavaproject.helper.CommonFunc;
import com.company.ecomjavaproject.helper.LoggerHelper;
import com.company.ecomjavaproject.helper.VerifyHelper;
import com.company.ecomjavaproject.helper.WaitHelper;
import com.company.ecomjavaproject.utilities.ObjectReader;

/** 
 * This Class has all the locators on Login Page 
 * and methods for all actions
 * @author Arvind.Kumar
 */

public class LoginPage {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	private CommonFunc commonFunc;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonFunc = new CommonFunc(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(signIn, ObjectReader.reader.getExplicitWait());
	}
    //Locator for User Name
	@FindBy(xpath = "//*[@id='Email']")
	WebElement userName;
    
	//Locator for Password
	@FindBy(xpath = "//*[@id='Password']")
	WebElement password;
	
	//Locator for SignIn Link
	@FindBy(xpath="//*[text()='Log in']")
	WebElement signIn;
	
	//Locator for Logout Link
	@FindBy(xpath="//*[text()='Logout']")
    WebElement logOutLink;
	
	//Setting user Name 
	public void setUserName(String userName) 
	{
		commonFunc.do_clear(this.userName);
		commonFunc.mySendKeys(this.userName, userName);
	}
	
	//Setting Password 
	public void setPassword(String password) 
	{
		commonFunc.do_clear(this.password);
		commonFunc.mySendKeys(this.password, password);
	}
	
	//Clicking on Sign In Button
	public void clickLogin() 
	{
        commonFunc.myClick(signIn);
	}
	
	//Login to the Application
	public void loginToApp(String userName,String password) 
	{
		setUserName(userName);
		setPassword(password);
		clickLogin();
	}
	
	
	//Verifying if Library Folder is visible
	public boolean verifySuccessLogin() 
	{
		return new VerifyHelper(driver).isDisplayed(logOutLink);	
	}

}