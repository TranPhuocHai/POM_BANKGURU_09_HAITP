package com.bankguru.customer;

import java.util.Random;
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
import pageObjects.RegisterPageObject;

public class NewCustomerValidateMessages_level_03 {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	NewCustomerPageObject newCustomerPage;
	String loginPageUrl, newCustomerPageUrl, userIdInfo, passwordInfo, email;
	String [] numericValues, specialCharacters; 
	String blankSpace;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
		email = "haitpauto" + randomNumber() + "@gmail.com";
		blankSpace =" ";
		numericValues = new String [] {"1234" , "name123"};
		specialCharacters = new String [] {"haitp!@#","!@#"};
		
		
		

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
		registerPage.openLoginPage(loginPageUrl);
		loginPage = new LoginPageObject(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inPutToUserIDTextbox(userIdInfo);
		loginPage.inPutToPasswordTextbox(passwordInfo);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		homePage.isWelcomeMessageDisplayed();
		homePage.isUserIDDisplayed(userIdInfo);
		homePage.clickToNewCustomerButton();
		newCustomerPage = new NewCustomerPageObject(driver);
		newCustomerPageUrl = newCustomerPage.getNewCustomerPageUrl();
	}

	@Test
	public void TC_01_NameCanNotBeEmpty() {
		newCustomerPage.clickToCustomerNameTextbox();
		newCustomerPage.clickToDateOfBirthTexbox();
		Assert.assertTrue(newCustomerPage.isCustomerNameMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void TC_02_NameCanNotBeNumberic() {
		for(String numericName: numericValues) {
			newCustomerPage.openNewCustomerPageUrl(newCustomerPageUrl);
			newCustomerPage.inputNumericValueToCustomerNameTextbox(numericName);
			Assert.assertTrue(newCustomerPage.isNumbersAreNotAllowedMessageOfNameDisplayed());
		}
	}

	@Test
	public void TC_03_NameCanNotHaveSpecialCharacters() {
		for (String specialCharactersName: specialCharacters) {
			newCustomerPage.openNewCustomerPageUrl(newCustomerPageUrl);
			newCustomerPage.inputSpecialCharactersToCustomerNameTextbox(specialCharactersName);
			Assert.assertTrue(newCustomerPage.isSpecialCharactersOfNameAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void TC_04_NameCanNotHaveFirstCharacterAsBlankSpace() {
		newCustomerPage.openNewCustomerPageUrl(newCustomerPageUrl);
		newCustomerPage.inputBlankSpaceToCustomerNameTextbox(blankSpace);
		Assert.assertTrue(newCustomerPage.isFirstCharacterOfNameCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void TC_05_AddressCanNotBeEmpty() {
		newCustomerPage.openNewCustomerPageUrl(newCustomerPageUrl);
		newCustomerPage.clickToAddressTextarea();
		newCustomerPage.clickToDateOfBirthTexbox();
		Assert.assertTrue(newCustomerPage.isAddressFieldMustNotBeBlankMessageDisplayed());
		
	}
	
	@Test
	public void TC_06_AdressCanNotHaveSpecialCharacters() {
		for (String specialCharactersAddress: specialCharacters) {
			newCustomerPage.openNewCustomerPageUrl(newCustomerPageUrl);
			newCustomerPage.inputSpecialCharactersToAdressTextbox(specialCharactersAddress);
			Assert.assertTrue(newCustomerPage.isSpecialCharactersOfAddressAreNotAllowedMessageDisplayed());
		}
	}
	
	@Test
	public void TC_07_AddressCanNotHaveFirstCharacterAsBlankSpace() {
		newCustomerPage.openNewCustomerPageUrl(newCustomerPageUrl);
		newCustomerPage.inputBlankSpaceToAdressTextArea(blankSpace);
		Assert.assertTrue(newCustomerPage.isFirstCharacterOfAddressCanNotHaveSpaceMessageDisplayed());

	}
	
	@Test
	public void TC_08_CityCanNotBeEmpty() {
		newCustomerPage.clickToCityTextbox();
		newCustomerPage.clickToDateOfBirthTexbox();
		Assert.assertTrue(newCustomerPage.isCityMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void TC_08_CityCanNotBeNumberic() {
		for(String numericCity: numericValues) {
			newCustomerPage.openNewCustomerPageUrl(newCustomerPageUrl);
			newCustomerPage.inputNumericValueToCityTextbox(numericCity);
			Assert.assertTrue(newCustomerPage.isNumbersAreNotAllowedMessageOfCityDisplayed());
		}
	}

	@Test
	public void TC_10_CityCanNotHaveSpecialCharacters() {
		for (String specialCharactersCity: specialCharacters) {
			newCustomerPage.openNewCustomerPageUrl(newCustomerPageUrl);
			newCustomerPage.inputSpecialCharactersToCityTextbox(specialCharactersCity);
			Assert.assertTrue(newCustomerPage.isSpecialCharactersOfCityAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void TC_11_CityCanNotHaveFirstCharacterAsBlankSpace() {
		newCustomerPage.openNewCustomerPageUrl(newCustomerPageUrl);
		newCustomerPage.inputBlankSpaceToCityTextbox(blankSpace);
		Assert.assertTrue(newCustomerPage.isFirstCharacterOfCityCanNotHaveSpaceMessageDisplayed());

	}
	
	@Test
	public void TC_12_StateCanNotBeEmpty() {
		newCustomerPage.clickToStateTextbox();
		newCustomerPage.clickToDateOfBirthTexbox();
		Assert.assertTrue(newCustomerPage.isStateMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void TC_13_StateCanNotBeNumberic() {
		for(String numericState: numericValues) {
			newCustomerPage.openNewCustomerPageUrl(newCustomerPageUrl);
			newCustomerPage.inputNumericValueToStateTextbox(numericState);
			Assert.assertTrue(newCustomerPage.isNumbersAreNotAllowedMessageOfStateDisplayed());
		}
	}

	@Test
	public void TC_14_StateCanNotHaveSpecialCharacters() {
		for (String specialCharactersState: specialCharacters) {
			newCustomerPage.openNewCustomerPageUrl(newCustomerPageUrl);
			newCustomerPage.inputSpecialCharactersToStateTextbox(specialCharactersState);
			Assert.assertTrue(newCustomerPage.isSpecialCharactersOfStateAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void TC_15_StateCanNotHaveFirstCharacterAsBlankSpace() {
		newCustomerPage.openNewCustomerPageUrl(newCustomerPageUrl);
		newCustomerPage.inputBlankSpaceToStateTextbox(blankSpace);
		Assert.assertTrue(newCustomerPage.isFirstCharacterOfStateCanNotHaveSpaceMessageDisplayed());

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
