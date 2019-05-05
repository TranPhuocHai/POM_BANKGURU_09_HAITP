package com.bankguru.customer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
	String [] numericValues, specialCharacters, characterPINs, lessThan6DigitsList, characterPhoneNumbers, specialPhoneNumbers, incorrectEmailIDList; 
	String blankSpace;

	@BeforeClass
	public void beforeClass() {
//		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
		email = "haitpauto" + randomNumber() + "@gmail.com";
		blankSpace =" ";
		numericValues = new String [] {"1234" , "name123"};
		specialCharacters = new String [] {"haitp!@#","!@#"};
		characterPINs = new String [] {"123PIN","HAI321"};
		lessThan6DigitsList = new String [] {"1","12","321","3214","32147" };
		characterPhoneNumbers = new String [] {"haitp","12 1234"};
		specialPhoneNumbers = new String [] {"097@!13546","!#123654", "0987654#@!"};
		incorrectEmailIDList = new String [] {"guru99@gmail","guru99", "guru99@", "guru99@gmail.","guru99gmail.com"};

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
		newCustomerPage.pressTABKeyToCustomerNameTextBox();
		Assert.assertTrue(newCustomerPage.isCustomerNameMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void TC_02_NameCanNotBeNumberic() {
		for(String numericName: numericValues) {
			newCustomerPage.clearNameTextbox();
			newCustomerPage.inputNumericValueToCustomerNameTextbox(numericName);
			Assert.assertTrue(newCustomerPage.isNumbersAreNotAllowedMessageOfNameDisplayed());
		}
	}

	@Test
	public void TC_03_NameCanNotHaveSpecialCharacters() {
		for (String specialCharactersName: specialCharacters) {
			newCustomerPage.clearNameTextbox();
			newCustomerPage.inputSpecialCharactersToCustomerNameTextbox(specialCharactersName);
			Assert.assertTrue(newCustomerPage.isSpecialCharactersOfNameAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void TC_04_NameCanNotHaveFirstCharacterAsBlankSpace() {
		newCustomerPage.clearNameTextbox();
		newCustomerPage.inputBlankSpaceToCustomerNameTextbox(blankSpace);
		Assert.assertTrue(newCustomerPage.isFirstCharacterOfNameCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void TC_05_AddressCanNotBeEmpty() {
		newCustomerPage.clearAddresTextarea();
		newCustomerPage.clickToAddressTextarea();
		newCustomerPage.pressTABKeyToAddressTextArea();
		Assert.assertTrue(newCustomerPage.isAddressFieldMustNotBeBlankMessageDisplayed());
		
	}
	
	@Test
	public void TC_06_AdressCanNotHaveSpecialCharacters() {
		for (String specialCharactersAddress: specialCharacters) {
			newCustomerPage.clearAddresTextarea();
			newCustomerPage.inputSpecialCharactersToAdressTextArea(specialCharactersAddress);
			Assert.assertTrue(newCustomerPage.isSpecialCharactersOfAddressAreNotAllowedMessageDisplayed());
		}
	}
	
	@Test
	public void TC_07_AddressCanNotHaveFirstCharacterAsBlankSpace() {
		newCustomerPage.clearAddresTextarea();
		newCustomerPage.inputBlankSpaceToAdressTextArea(blankSpace);
		Assert.assertTrue(newCustomerPage.isFirstCharacterOfAddressCanNotHaveSpaceMessageDisplayed());

	}
	
	@Test
	public void TC_08_CityCanNotBeEmpty() {
		newCustomerPage.clearCityTextbox();
		newCustomerPage.clickToCityTextbox();
		newCustomerPage.pressTABKeyToCityTextbox();
		Assert.assertTrue(newCustomerPage.isCityMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void TC_08_CityCanNotBeNumberic() {
		for(String numericCity: numericValues) {
			newCustomerPage.clearCityTextbox();
			newCustomerPage.inputNumericValueToCityTextbox(numericCity);
			Assert.assertTrue(newCustomerPage.isNumbersAreNotAllowedMessageOfCityDisplayed());
		}
	}

	@Test
	public void TC_10_CityCanNotHaveSpecialCharacters() {
		for (String specialCharactersCity: specialCharacters) {
			newCustomerPage.clearCityTextbox();
			newCustomerPage.inputSpecialCharactersToCityTextbox(specialCharactersCity);
			Assert.assertTrue(newCustomerPage.isSpecialCharactersOfCityAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void TC_11_CityCanNotHaveFirstCharacterAsBlankSpace() {
		newCustomerPage.clearCityTextbox();
		newCustomerPage.inputBlankSpaceToCityTextbox(blankSpace);
		Assert.assertTrue(newCustomerPage.isFirstCharacterOfCityCanNotHaveSpaceMessageDisplayed());

	}
	
	@Test
	public void TC_12_StateCanNotBeEmpty() {
		newCustomerPage.clearStateTextbox();
		newCustomerPage.clickToStateTextbox();
		newCustomerPage.pressTABKeyToStateTextbox();
		Assert.assertTrue(newCustomerPage.isStateMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void TC_13_StateCanNotBeNumberic() {
		for(String numericState: numericValues) {
			newCustomerPage.clearStateTextbox();
			newCustomerPage.inputNumericValueToStateTextbox(numericState);
			Assert.assertTrue(newCustomerPage.isNumbersAreNotAllowedMessageOfStateDisplayed());
		}
	}

	@Test
	public void TC_14_StateCanNotHaveSpecialCharacters() {
		for (String specialCharactersState: specialCharacters) {
			newCustomerPage.clearStateTextbox();
			newCustomerPage.inputSpecialCharactersToStateTextbox(specialCharactersState);
			Assert.assertTrue(newCustomerPage.isSpecialCharactersOfStateAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void TC_15_StateCanNotHaveFirstCharacterAsBlankSpace() {
		newCustomerPage.clearStateTextbox();
		newCustomerPage.inputBlankSpaceToStateTextbox(blankSpace);
		Assert.assertTrue(newCustomerPage.isFirstCharacterOfStateCanNotHaveSpaceMessageDisplayed());

	}
	
	@Test
	public void TC_16_PinCanNotBeEmpty() {
		newCustomerPage.clearPinTextbox();
		newCustomerPage.clickToPinTextbox();
		newCustomerPage.pressTABKeyToPinTextbox();
		Assert.assertTrue(newCustomerPage.isPinMustNotBeBlankMessageDisplayed());
	}
	
	@Test
	public void TC_17_PinMustBeNumeric() {
		for (String characterPIN:characterPINs) {
			newCustomerPage.clearPinTextbox();
			newCustomerPage.inputChractersValueToPinTextbox(characterPIN);
			Assert.assertTrue(newCustomerPage.isPinCharacterAreNotAllowMessageDisplayed());
		}
	}
	
	@Test
	public void TC_18_PinMustHave6Degits() {
		for (String lessThan6Digits:lessThan6DigitsList) {
			newCustomerPage.clearPinTextbox();
			newCustomerPage.inputLessThan6DigitsToPinTextbox(lessThan6Digits);
			Assert.assertTrue(newCustomerPage.isPinMustHave6DegitsMessageDisplayed());
		}
	}
	
	@Test
	public void TC_19_PinCanNotHaveFirstCharacterAsBlankSpace() {
		newCustomerPage.clearPinTextbox();
		newCustomerPage.inputBlankSpaceToPinTextbox(blankSpace);
		Assert.assertTrue(newCustomerPage.isFirstCharacterOfPinCanNotHaveSpaceMessageDisplayed());

	}
	
	@Test
	public void TC_20_TelephoneCanNotBeEmpty() {
		newCustomerPage.clearPhoneTextbox();
		newCustomerPage.clickToMobileNumberTextbox();
		newCustomerPage.pressTABKeyToMobileTextbox();
		Assert.assertTrue(newCustomerPage.isPhoneMustNotBeBlankMessageDisplayed());
	}
	
	@Test
	public void TC_21_TelephoneCanNotHaveFirstCharacterAsBlankSpace() {
		newCustomerPage.clearPhoneTextbox();
		newCustomerPage.inputBlankSpaceToMobileNumberTextbox(blankSpace);
		Assert.assertTrue(newCustomerPage.isFirstCharacterOfPhoneCanNotHaveSpaceMessageDisplayed());

	}
	
	@Test
	public void TC_22_TelephoneCharacterOrIncludeSpaceAreNotAllow() {
		for (String characterPhoneNumber:characterPhoneNumbers) {
			newCustomerPage.clearPhoneTextbox();
			newCustomerPage.inputChractersValueToMobileNumberTextbox(characterPhoneNumber);
			Assert.assertTrue(newCustomerPage.isPhoneCharacterAreNotAllowMessageDisplayed());
		}
		
	}
	
	@Test
	public void TC_23_TelephoneCanNotHaveSpecialCharacters() {
		for (String specialPhoneNumber: specialPhoneNumbers) {
			newCustomerPage.clearPhoneTextbox();
			newCustomerPage.inputSpecialCharactersToMobileNumberTextbox(specialPhoneNumber);
			Assert.assertTrue(newCustomerPage.isSpecialCharactersOfPhoneAreNotAllowedMessageDisplayed());
		}
	}
	
	@Test
	public void TC_24_EmailCanNotBeEmpty() {
		newCustomerPage.clearEmailTextbox();
		newCustomerPage.clickToEmailTextbox();
		newCustomerPage.pressTABKeyToEmailTextbox();
		Assert.assertTrue(newCustomerPage.isEmailMustNotBeBlankMessageDisplayed());
	}
	
	@Test
	public void TC_25_EmailMustBeInCorrectFormat() {
		for (String incorrectEmailID: incorrectEmailIDList) {
			newCustomerPage.clearEmailTextbox();
			newCustomerPage.inputIncorrectEmailIDToEmailTextbox(incorrectEmailID);
			Assert.assertTrue(newCustomerPage.isEmailIDIsNotValidMessageDisplayed());
		}
	}
	
	@Test
	public void TC_26_EmailCanNotHaveFirstCharacterAsBlankSpace() {
		newCustomerPage.clearEmailTextbox();
		newCustomerPage.inputBlankSpaceToEmailTextbox(blankSpace);
		Assert.assertTrue(newCustomerPage.isFirstCharacterOfEmailCanNotHaveSpaceMessageDisplayed());

	}
	
	@Test
	public void TC_27_PasswordCanNotBeEmpty() {
		newCustomerPage.clearPasswordTextbox();
		newCustomerPage.clickToPasswordTextbox();
		newCustomerPage.pressTABKeyToPasswordTextbox();
		Assert.assertTrue(newCustomerPage.isPasswordMustNotBeBlankMessageDisplayed());
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
