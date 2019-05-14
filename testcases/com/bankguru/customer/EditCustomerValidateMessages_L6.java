package com.bankguru.customer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class EditCustomerValidateMessages_L6 extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editcustomerPage;
	String loginPageUrl, homePageUrl, userIdInfo, passwordInfo, email;
	String validEmailID, validDateOfBirth, validName, validAdress, validCity, validState, validPin, validPhoneNumber,
			validPassword, customerID, expectedGender;
	String[] numericValues, specialCharacters, characterPINs, lessThan6DigitsList, characterPhoneNumbers,
			specialPhoneNumbers, incorrectEmailIDList;
	String blankSpace;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);

		email = "khainammvc" + randomNumber() + "@gmail.com";
		validName = "Tran Phuoc Hai";
		expectedGender = "male";
		validDateOfBirth = "1988-07-31";
		validAdress = "100 Ho Guom";
		validCity = "Ha Noi";
		validState = "Hoan Kiem";
		validPin = "600000";
		validPhoneNumber = "0987654321";
		validEmailID = "khain" + randomNumber() + "@gmail.com";
		validPassword = "idonknow12345678";

		blankSpace = " ";
		numericValues = new String[] { "1234", "name123" };
		specialCharacters = new String[] { "haitp!@#", "!@#" };
		characterPINs = new String[] { "123PIN", "HAI321" };
		lessThan6DigitsList = new String[] { "1", "12", "321", "3214", "32147" };
		characterPhoneNumbers = new String[] { "haitp", "12 1234" };
		specialPhoneNumbers = new String[] { "097@!13546", "!#123654", "0987654#@!" };
		incorrectEmailIDList = new String[] { "guru99@gmail", "guru99", "guru99@", "guru99@gmail.", "guru99gmail.com" };

		loginPage = PageFactoryManager.getLoginPage(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inPutToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		userIdInfo = registerPage.getUserIDInfor();
		passwordInfo = registerPage.getPasswordInfor();
		loginPage = registerPage.openLoginPage(loginPageUrl);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inPutToUserIDTextbox(userIdInfo);
		loginPage.inPutToPasswordTextbox(passwordInfo);
		homePage = loginPage.clickToLoginButton();
		homePageUrl = homePage.getHomePageUrl();
		homePage.isWelcomeMessageDisplayed();
		homePage.isUserIDDisplayed(userIdInfo);
		newCustomerPage = homePage.clickToNewCustomerButton();

		newCustomerPage.inputValidDataToCustomerNameTextbox(validName);
		newCustomerPage.selectMaleGenderRadioButton();
		newCustomerPage.removeDateOfBirthAttribute();
		newCustomerPage.inputValidDataToDateOfBirthTextbox(validDateOfBirth);
		newCustomerPage.inputValidDataToAdressTextArea(validAdress);
		newCustomerPage.inputValidDataToCityTextbox(validCity);
		newCustomerPage.inputValidDataToStateTextbox(validState);
		newCustomerPage.inputValidDataToPinTextbox(validPin);
		newCustomerPage.inputValidDataToMobileNumberTextbox(validPhoneNumber);
		newCustomerPage.inputValidDataToEmailTextbox(validEmailID);
		newCustomerPage.inputValidDataToPasswordTextbox(validPassword);
		newCustomerPage.clickToSubmitButton();
		newCustomerPage.isCustomerRegisteredSuccessfullyDisplayed();
		customerID = newCustomerPage.getCustomerID();

		Assert.assertEquals(newCustomerPage.getTextCustomerNameInfo(), validName);
		Assert.assertEquals(newCustomerPage.getTextGenderInfo(), expectedGender);
		Assert.assertEquals(newCustomerPage.getDateOfBirthInfo(), validDateOfBirth);
		Assert.assertEquals(newCustomerPage.getTextAdressInfo(), validAdress);
		Assert.assertEquals(newCustomerPage.getTextCityInfo(), validCity);
		Assert.assertEquals(newCustomerPage.getTextStateInfo(), validState);
		Assert.assertEquals(newCustomerPage.getTextPinInfo(), validPin);
		Assert.assertEquals(newCustomerPage.getTextMobileNumberInfo(), validPhoneNumber);
		Assert.assertEquals(newCustomerPage.getTextEmailInfo(), validEmailID);

		editcustomerPage = newCustomerPage.clickToEditCustomerLink();

	}

	@Test
	void TC_01_CustomerIDCanNotBeEmpty() {
		editcustomerPage.clearCustomerIDTextbox();
		editcustomerPage.clickToCustomerIDTexbox();
		editcustomerPage.pressTABKeyToCustomerIDTextbox();
		Assert.assertTrue(editcustomerPage.isCustomerIDIsRequiredMessageDisplayed());

	}

	@Test
	public void TC_02_CustomerIDCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearCustomerIDTextbox();
		editcustomerPage.inputBlankSpaceToCustomerIDTextbox(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfCustomerIDCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void TC_03_CustomerIDCharacterOrIncludeSpaceAreNotAllow() {
		for (String characterPhoneNumber : characterPhoneNumbers) {
			editcustomerPage.clearCustomerIDTextbox();
			editcustomerPage.inputChractersValueToCustomerIDTextbox(characterPhoneNumber);
			Assert.assertTrue(editcustomerPage.isCustomerIDCharacterAreNotAllowMessageDisplayed());
		}

	}

	@Test
	public void TC_04_CustomerIDCanNotHaveSpecialCharacters() {
		for (String specialPhoneNumber : specialPhoneNumbers) {
			editcustomerPage.clearCustomerIDTextbox();
			editcustomerPage.inputSpecialCharactersToCustomerIDTextbox(specialPhoneNumber);
			Assert.assertTrue(editcustomerPage.isSpecialCharactersOfCustomerIDAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void TC_05_AddressCanNotBeEmpty() {
		editcustomerPage.clearCustomerIDTextbox();
		editcustomerPage.inputValidCustomerIDToCustomerIDTextbox(customerID);
		editcustomerPage.clickToCustomerIDSubmitButton();
		editcustomerPage.clearAdressTextArea();
		editcustomerPage.clickToAddressTextarea();
		editcustomerPage.pressTABKeyToAddressTextArea();
		Assert.assertTrue(editcustomerPage.isAddressFieldMustNotBeBlankMessageDisplayed());

	}

	@Test
	public void TC_06_AdressCanNotHaveSpecialCharacters() {
		for (String specialCharactersAddress : specialCharacters) {
			editcustomerPage.clearAdressTextArea();
			editcustomerPage.inputSpecialCharactersToAdressTextArea(specialCharactersAddress);
			Assert.assertTrue(editcustomerPage.isSpecialCharactersOfAddressAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void TC_07_AddressCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearAdressTextArea();
		editcustomerPage.inputBlankSpaceToAdressTextArea(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfAddressCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void TC_08_CityCanNotBeEmpty() {
		editcustomerPage.clearCityTextbox();
		editcustomerPage.clickToCityTextbox();
		editcustomerPage.pressTABKeyToCityTextbox();
		Assert.assertTrue(editcustomerPage.isCityMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void TC_09_CityCanNotBeNumberic() {
		for (String numericCity : numericValues) {
			editcustomerPage.clearCityTextbox();
			editcustomerPage.inputNumericValueToCityTextbox(numericCity);
			Assert.assertTrue(editcustomerPage.isNumbersAreNotAllowedMessageOfCityDisplayed());
		}
	}

	@Test
	public void TC_10_CityCanNotHaveSpecialCharacters() {
		for (String specialCharactersCity : specialCharacters) {
			editcustomerPage.clearCityTextbox();
			editcustomerPage.inputSpecialCharactersToCityTextbox(specialCharactersCity);
			Assert.assertTrue(editcustomerPage.isSpecialCharactersOfCityAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void TC_11_CityCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearCityTextbox();
		editcustomerPage.inputBlankSpaceToCityTextbox(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfCityCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void TC_12_StateCanNotBeEmpty() {
		editcustomerPage.clearStateTextbox();
		editcustomerPage.clickToStateTextbox();
		editcustomerPage.pressTABKeyToStateTextbox();
		Assert.assertTrue(editcustomerPage.isStateMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void TC_13_StateCanNotBeNumberic() {
		for (String numericState : numericValues) {
			editcustomerPage.clearStateTextbox();
			editcustomerPage.inputNumericValueToStateTextbox(numericState);
			Assert.assertTrue(editcustomerPage.isNumbersAreNotAllowedMessageOfStateDisplayed());
		}
	}

	@Test
	public void TC_14_StateCanNotHaveSpecialCharacters() {
		for (String specialCharactersState : specialCharacters) {
			editcustomerPage.clearStateTextbox();
			editcustomerPage.inputSpecialCharactersToStateTextbox(specialCharactersState);
			Assert.assertTrue(editcustomerPage.isSpecialCharactersOfStateAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void TC_15_StateCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearStateTextbox();
		editcustomerPage.inputBlankSpaceToStateTextbox(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfStateCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void TC_16_PinCanNotBeEmpty() {
		editcustomerPage.clearPinTextbox();
		editcustomerPage.clickToPinTextbox();
		editcustomerPage.pressTABKeyToPinTextbox();
		Assert.assertTrue(editcustomerPage.isPinMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void TC_17_PinMustBeNumeric() {
		for (String characterPIN : characterPINs) {
			editcustomerPage.clearPinTextbox();
			editcustomerPage.inputChractersValueToPinTextbox(characterPIN);
			Assert.assertTrue(editcustomerPage.isPinCharacterAreNotAllowMessageDisplayed());
		}
	}

	@Test
	public void TC_18_PinMustHave6Degits() {
		for (String lessThan6Digits : lessThan6DigitsList) {
			editcustomerPage.clearPinTextbox();
			editcustomerPage.inputLessThan6DigitsToPinTextbox(lessThan6Digits);
			Assert.assertTrue(editcustomerPage.isPinMustHave6DegitsMessageDisplayed());
		}
	}

	@Test
	public void TC_19_PinCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearPinTextbox();
		editcustomerPage.inputBlankSpaceToPinTextbox(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfPinCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void TC_20_TelephoneCanNotBeEmpty() {
		editcustomerPage.clearPhoneTextbox();
		editcustomerPage.clickToMobileNumberTextbox();
		editcustomerPage.pressTABKeyToMobileTextbox();
		Assert.assertTrue(editcustomerPage.isPhoneMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void TC_21_TelephoneCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearPhoneTextbox();
		editcustomerPage.inputBlankSpaceToMobileNumberTextbox(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfPhoneCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void TC_22_TelephoneCharacterOrIncludeSpaceAreNotAllow() {
		for (String characterPhoneNumber : characterPhoneNumbers) {
			editcustomerPage.clearPhoneTextbox();
			editcustomerPage.inputChractersValueToMobileNumberTextbox(characterPhoneNumber);
			Assert.assertTrue(editcustomerPage.isPhoneCharacterAreNotAllowMessageDisplayed());
		}

	}

	@Test
	public void TC_23_TelephoneCanNotHaveSpecialCharacters() {
		for (String specialPhoneNumber : specialPhoneNumbers) {
			editcustomerPage.clearPhoneTextbox();
			editcustomerPage.inputSpecialCharactersToMobileNumberTextbox(specialPhoneNumber);
			Assert.assertTrue(editcustomerPage.isSpecialCharactersOfPhoneAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void TC_24_EmailCanNotBeEmpty() {
		editcustomerPage.clearEmailTextbox();
		editcustomerPage.clickToEmailTextbox();
		editcustomerPage.pressTABKeyToEmailTextbox();
		Assert.assertTrue(editcustomerPage.isEmailMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void TC_25_EmailMustBeInCorrectFormat() {
		for (String incorrectEmailID : incorrectEmailIDList) {
			editcustomerPage.clearEmailTextbox();
			editcustomerPage.inputIncorrectEmailIDToEmailTextbox(incorrectEmailID);
			Assert.assertTrue(editcustomerPage.isEmailIDIsNotValidMessageDisplayed());
		}
	}

	@Test
	public void TC_26_EmailCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearEmailTextbox();
		editcustomerPage.inputBlankSpaceToEmailTextbox(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfEmailCanNotHaveSpaceMessageDisplayed());

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
