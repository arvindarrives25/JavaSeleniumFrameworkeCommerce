package com.company.ecomjavaproject.testcases.loginpagetest;

import org.testng.annotations.Test;

import com.company.ecomjavaproject.baseclass.BaseClass;
import com.company.ecomjavaproject.helper.AssertHelper;
import com.company.ecomjavaproject.pageobjects.loginpage.LoginPage;
import com.company.ecomjavaproject.utilities.ObjectReader;

public class LoginPageTest extends BaseClass {

	@Test(description = "Login test with guest1 and guest1 as UserName & Password respectively")
	public void loginTest() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());

		boolean status = lp.verifySuccessLogin();
		AssertHelper.updateTestStatus(status);
	}

}
