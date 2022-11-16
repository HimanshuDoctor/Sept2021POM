package com.qa.opencart.pages;

import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	
	//1. declare private driver	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//2.page constructor
	public LoginPage(WebDriver driver) {
		this.driver =  driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3. By locators 
	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn  = By.xpath("//button[@class='btn btn-primary']");
	private By RegisterLink = By.linkText("Register");
	private By ForgotPwdLink = By.linkText("Forgotten Password");
	
	//4. Page Actions:
	
	public String getLoginPagetitle() {
//		return driver.getTitle();
		return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean getLoginPageUrl() {
//		return driver.getCurrentUrl();
		return eleUtil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT); 
	}
	
	public boolean isForgotPwdLinkExist() {
//		return driver.findElement(ForgotPwdLink).isDisplayed();
		return eleUtil.doIsDisplayed(ForgotPwdLink);
	}
	
	public boolean isRegisterLinkExist() {
//		return driver.findElement(RegisterLink).isDisplayed();
		return eleUtil.doIsDisplayed(RegisterLink);
	}
	
//	public void doLogin(String un, String pwd)
	// lesson_3 (32:58)
	public AccountsPage doLogin(String un, String pwd){
		System.out.println("login with :" + un + " : " + pwd);
//		driver.findElement(emailid).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
		
		eleUtil.doSendKeys(emailid, un);
		eleUtil.doSendKeys(password,pwd);
		eleUtil.doClick(loginBtn);	
		// Lesson_3(32:00) page channing concept.
		return new AccountsPage(driver); 
	}	
	

}
