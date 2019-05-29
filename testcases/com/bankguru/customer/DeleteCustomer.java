package com.bankguru.customer;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class DeleteCustomer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private DeleteCustomerPageObject deleteCustomerPage;
	private String loginPageUrl, userIdInfo, passwordInfo;
	
	private String email = "khainammvc" + randomNumber() + "@gmail.com";
	private String blankSpace = " ";
	
	private String[] characterValues = new String[] { "haitp", "12 1234" };
	private String[] specialValues = new String[] { "097@!13546", "!#123654", "0987654#@!" };

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);


		loginPage = PageFactoryManager.getLoginPage(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inPutToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		userIdInfo = registerPage.getTextDynamicInfo(driver, "User ID :");
		passwordInfo = registerPage.getTextDynamicInfo(driver, "Password :");
		loginPage = registerPage.openLoginPage(loginPageUrl);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inPutToUserIDTextbox(userIdInfo);
		loginPage.inPutToPasswordTextbox(passwordInfo);
		homePage = loginPage.clickToLoginButton();
		homePage.isWelcomeMessageDisplayed();
		homePage.isUserIDDisplayed(userIdInfo);

		homePage.openMultiplePage(driver, "Delete Customer");
		deleteCustomerPage = PageFactoryManager.getDeleteCustomerPage(driver);
	}

	@Test
	public void DC_01_CustomerIDCanNotBeEmpty() {
		deleteCustomerPage.clearCustomerIDTextbox();
		deleteCustomerPage.clickToCustomerIDTexbox();
		deleteCustomerPage.pressTABKeyToCustomerIDTextbox();
		Assert.assertTrue(deleteCustomerPage.isCustomerIDIsRequiredMessageDisplayed());

	}
	
	@Test
	public void DC_02_CustomerIDCanNotHaveFirstCharacterAsBlankSpace() {
		deleteCustomerPage.clearCustomerIDTextbox();
		deleteCustomerPage.inputValueToCustomerIDTextbox(blankSpace);
		Assert.assertTrue(deleteCustomerPage.isFirstCharacterOfCustomerIDCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void DC_03_CustomerIDCharacterOrIncludeSpaceAreNotAllow() {
		for (String charactervalue : characterValues) {
			deleteCustomerPage.clearCustomerIDTextbox();
			deleteCustomerPage.inputValueToCustomerIDTextbox(charactervalue);
			Assert.assertTrue(deleteCustomerPage.isCustomerIDCharacterAreNotAllowMessageDisplayed());
		}

	}

	@Test
	public void DC_04_CustomerIDCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			deleteCustomerPage.clearCustomerIDTextbox();
			deleteCustomerPage.inputValueToCustomerIDTextbox(specialValue);
			Assert.assertTrue(deleteCustomerPage.isSpecialCharactersOfCustomerIDAreNotAllowedMessageDisplayed());
		}
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
