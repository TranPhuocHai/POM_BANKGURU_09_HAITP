package com.bankguru.validate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bankguru.NewCustomerPageUI;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;

public class Validate_NewCustomer_01_Name {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
		
	}

	@Test
	public void TC_01_NameCanNotBeEmpty() {
		loginPage = new LoginPageObject(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inPutToUserIDTextbox(NewCustomerPageUI.USER_ID_INFO);
		loginPage.inPutToPasswordTextbox(NewCustomerPageUI.PASSWORD_INFO);
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		homePage.isWelcomeMessageDisplayed();
		homePage.isUserIDDisplayed(NewCustomerPageUI.USER_ID_INFO);
		homePage.clickToNewCustomerButton();
		
		newCustomerPage = new NewCustomerPageObject(driver);
		newCustomerPage.getNewCustomerPageUrl();
		newCustomerPage.clickToCustomerNameTextbox();
		newCustomerPage.clickToDateOfBirthTexbox();
		Assert.assertTrue(newCustomerPage.isCustomerNameMustNotBeBlankMessageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
