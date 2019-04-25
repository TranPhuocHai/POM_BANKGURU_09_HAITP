package com.bankguru.account;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_level_02_ApplyAbstractPage {
	WebDriver driver;
	String userIdInfo, passwordInfo, LoginPageUrl, email;
	AbstractPage abstractPage;
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  abstractPage = new AbstractPage();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();		  
	  abstractPage.openAnyUrl(driver, "http://demo.guru99.com/v4");
	  email = "haitpauto" + randomNumber() + "@gmail.com";
  }
  
	
  @Test
  public void TC_01_RegisterToSystem() {
	 Assert.assertTrue(abstractPage.isControlDisplayed(driver, "//form[@name='frmLogin']"));
	 LoginPageUrl = abstractPage.getCurrentPageUrl(driver);
	 abstractPage.clickToElement(driver, "//a[text()='here']");
	 Assert.assertTrue(abstractPage.isControlDisplayed(driver, "//input[@name='emailid']"));
	 abstractPage.sendKeyToElement(driver, "//input[@name='emailid']", email);
	 abstractPage.clickToElement(driver, "//input[@name='btnLogin']");	 
	 userIdInfo = abstractPage.getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
	 passwordInfo = abstractPage.getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
	 
  }
  
  @Test
  public void TC_02_LoginToSystem() {
	 abstractPage.openAnyUrl(driver, LoginPageUrl);	 
	 Assert.assertTrue(abstractPage.isControlDisplayed(driver, "//form[@name='frmLogin']"));	 
	 abstractPage.sendKeyToElement(driver, "//input[@name='uid']", userIdInfo);
	 abstractPage.sendKeyToElement(driver, "//input[@name='password']", passwordInfo);	 
	 abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
	 Assert.assertTrue(abstractPage.isControlDisplayed(driver, "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
	 Assert.assertTrue(abstractPage.isControlDisplayed(driver, "//td[text()='Manger Id : " + userIdInfo + "']"));
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
