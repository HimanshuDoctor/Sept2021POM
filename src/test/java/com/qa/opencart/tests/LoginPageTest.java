package com.qa.opencart.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPagetitle();
		System.out.println("page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);		
	}
	
	@Test(priority = 2)
	public void loginPageUrlTest() {
//		String actUrl = loginPage.getLoginPageUrl();
//		System.out.println("page url: " + actUrl);
//		Assert.assertTrue(actUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));		
		Assert.assertTrue(loginPage.getLoginPageUrl());	
	}
	
	@Test(priority = 3)
	public void ForgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());		
	}
	
	@Test(priority = 4)
	public void registrLinkTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());		
	}
	
	@Test(priority = 5)
	public void loginTest(){
		loginPage.doLogin(prop.getProperty("username").trim() , prop.getProperty("password").trim());
//		accountsPage = loginPage.doLogin(prop.getProperty("username").trim() , prop.getProperty("password").trim());
//		Assert.assertEquals(accountsPage.getAccountPageTitle(), Constants.ACCOUNTS_PAGE_TITTLE);
	}	

}
