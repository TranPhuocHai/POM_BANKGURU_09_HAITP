package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class NewAccount extends AbstractTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	
	private String loginPageUrl, userIdInfo, passwordInfo;	
	private String email = "khainammvc" + randomNumber() + "@gmail.com";
	private String validName = "Tran Phuoc Hai";
	private String expectedGender = "male";
	private String validDateOfBirth = "1988-07-31";
	private String validAdress = "100 Ho Guom";
	private String validCity = "Ha Noi";
	private String validState = "Hoan Kiem";
	private String validPin = "600000";
	private String validPhoneNumber = "0987654321";
	private String validEmailID = "khain" + randomNumber() + "@gmail.com";
	private String validPassword = "idonknow12345678";
	
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
		
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

		newCustomerPage.inputValueToCustomerNameTextbox(validName);
		newCustomerPage.selectMaleGenderRadioButton();
		newCustomerPage.removeDateOfBirthAttribute();
		newCustomerPage.inputValueToDateOfBirthTextbox(validDateOfBirth);
		newCustomerPage.inputValueToAdressTextArea(validAdress);
		newCustomerPage.inputValueToCityTextbox(validCity);
		newCustomerPage.inputValueToStateTextbox(validState);
		newCustomerPage.inputValueToPinTextbox(validPin);
		newCustomerPage.inputValueToMobileNumberTextbox(validPhoneNumber);
		newCustomerPage.inputValueToEmailTextbox(validEmailID);
		newCustomerPage.inputValueToPasswordTextbox(validPassword);
		newCustomerPage.clickToSubmitButton();
		newCustomerPage.isCustomerRegisteredSuccessfullyDisplayed();

		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Customer Name"), validName);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Gender"), expectedGender);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Birthdate"), validDateOfBirth);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Address"), validAdress);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "City"), validCity);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "State"), validState);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Pin"), validPin);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Mobile No."), validPhoneNumber);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Email"), validEmailID);

		newCustomerPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);
	}
	
	@Test
	public void NC_01_CustomerIDCanNotBeEmpty() {
		newAccountPage.clearCustomerIDTextbox();
		newAccountPage.clickToCustomerIDTexbox();
		newAccountPage.pressTABKeyToCustomerIDTextbox();
		Assert.assertTrue(newAccountPage.isCustomerIDIsRequiredMessageDisplayed());
		
	}
	
	@Test
	public void NC_02_CustomerIDCanNotHaveFirstCharacterAsBlankSpace() {
		newAccountPage.clearCustomerIDTextbox();
		newAccountPage.inputValueToCustomerIDTextbox(blankSpace);
		Assert.assertTrue(newAccountPage.isFirstCharacterOfCustomerIDCanNotHaveSpaceMessageDisplayed());
		
	}
	
	@Test
	public void NC_03_CustomerIDCharacterOrIncludeSpaceAreNotAllow() {
		for (String characterValue : characterValues) {
			newAccountPage.clearCustomerIDTextbox();
			newAccountPage.inputValueToCustomerIDTextbox(characterValue);
			Assert.assertTrue(newAccountPage.isCustomerIDCharacterAreNotAllowMessageDisplayed());
		}
		
	}
	
	@Test
	public void NC_04_CustomerIDCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			newAccountPage.clearCustomerIDTextbox();
			newAccountPage.inputValueToCustomerIDTextbox(specialValue);
			Assert.assertTrue(newAccountPage.isSpecialCharactersOfCustomerIDAreNotAllowedMessageDisplayed());
		}
	}
	
	@Test
	public void NC_05_InitialDepositCanNotBeEmpty() {
		newAccountPage.clearInitialDepositTextbox();
		newAccountPage.clickToInitialDepositTexbox();
		newAccountPage.pressTABKeyToInitialDepositTextbox();
		Assert.assertTrue(newAccountPage.isInitialDepositMustNotBeBlankMessageDisplayed());

	}

	@Test
	public void NC_06_InitialDepositCanNotHaveFirstCharacterAsBlankSpace() {
		newAccountPage.clearInitialDepositTextbox();
		newAccountPage.inputValueToInitialDepositTextbox(blankSpace);
		Assert.assertTrue(newAccountPage.isFirstCharacterOfInitialDepositCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void NC_07_InitialDepositCharacterOrIncludeSpaceAreNotAllow() {
		for (String characterValue : characterValues) {
			newAccountPage.clearInitialDepositTextbox();
			newAccountPage.inputValueToInitialDepositTextbox(characterValue);
			Assert.assertTrue(newAccountPage.isInitialDepositCharacterAreNotAllowMessageDisplayed());
		}

	}

	@Test
	public void NC_08_InitialDepositCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			newAccountPage.clearInitialDepositTextbox();
			newAccountPage.inputValueToInitialDepositTextbox(specialValue);
			Assert.assertTrue(newAccountPage.isSpecialCharactersOfInitialDepositAreNotAllowedMessageDisplayed());
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
