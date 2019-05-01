package com.bankguru.account;

import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_level_03_PageObject {
	WebDriver driver;
	String userIdInfo, passwordInfo, loginPageUrl, email;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();		  
	  driver.get("http://demo.guru99.com/v4");
	  email = "haitpauto" + randomNumber() + "@gmail.com";
  }
	
  @Test
  public void TC_01_RegisterToSystem() {
	 loginPage = new LoginPageObject(driver);
	 Assert.assertTrue(loginPage.isLoginFormDisplayed());
	 loginPageUrl = loginPage.getLoginPageUrl();
	 loginPage.clickToHereLink();
	 registerPage = new RegisterPageObject(driver);
	 Assert.assertTrue(registerPage.isRegisterPageDisplayed());
	 registerPage.inPutToEmailIDTextbox(email);
	 registerPage.clickToSubmitButton();
	 userIdInfo = registerPage.getUserIDInfor();
	 passwordInfo = registerPage.getPasswordInfor();
	 
  }
  
  @Test
  public void TC_02_LoginToSystem() {
	 registerPage.openLoginPage(loginPageUrl);
	 loginPage = new LoginPageObject(driver);
	 Assert.assertTrue(loginPage.isLoginFormDisplayed());
	 loginPage.inPutToUserIDTextbox(userIdInfo);
	 loginPage.inPutToPasswordTextbox(passwordInfo);
	 loginPage.clickToLoginButton();
	 homePage = new HomePageObject(driver);
	 homePage.isWelcomeMessageDisplayed();
	 homePage.isUserIDDisplayed(userIdInfo);
	 
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int randomNumber() {
	  Random random = new Random();
	  return random.nextInt(999999);
  }

}
