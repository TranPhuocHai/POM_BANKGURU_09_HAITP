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
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class EditCustomer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editcustomerPage;
	private String loginPageUrl, userIdInfo, passwordInfo, customerID;
	
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
	private String[] numericValues = new String[] { "1234", "name123" };
	private String[] specialCharacters = new String[] { "haitp!@#", "!@#" };
	private String[] characterPINs = new String[] { "123PIN", "HAI321" };
	private String[] lessThan6DigitsList = new String[] { "1", "12", "321", "3214", "32147" };
	private String[] characterPhoneNumbers = new String[] { "haitp", "12 1234" };
	private String[] specialPhoneNumbers = new String[] { "097@!13546", "!#123654", "0987654#@!" };
	private String[] incorrectEmailIDList = new String[] { "guru99@gmail", "guru99", "guru99@", "guru99@gmail.", "guru99gmail.com" };

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
		customerID = newCustomerPage.getCustomerID();

		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Customer Name"), validName);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Gender"), expectedGender);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Birthdate"), validDateOfBirth);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Address"), validAdress);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "City"), validCity);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "State"), validState);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Pin"), validPin);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Mobile No."), validPhoneNumber);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Email"), validEmailID);

		newCustomerPage.openMultiplePage(driver, "Edit Customer");
		editcustomerPage = PageFactoryManager.getEditCustomerPage(driver);
	}

	@Test
	public void EC_01_CustomerIDCanNotBeEmpty() {
		editcustomerPage.clearCustomerIDTextbox();
		editcustomerPage.clickToCustomerIDTexbox();
		editcustomerPage.pressTABKeyToCustomerIDTextbox();
		Assert.assertTrue(editcustomerPage.isCustomerIDIsRequiredMessageDisplayed());

	}

	@Test
	public void EC_02_CustomerIDCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearCustomerIDTextbox();
		editcustomerPage.inputValueToCustomerIDTextbox(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfCustomerIDCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void EC_03_CustomerIDCharacterOrIncludeSpaceAreNotAllow() {
		for (String characterPhoneNumber : characterPhoneNumbers) {
			editcustomerPage.clearCustomerIDTextbox();
			editcustomerPage.inputValueToCustomerIDTextbox(characterPhoneNumber);
			Assert.assertTrue(editcustomerPage.isCustomerIDCharacterAreNotAllowMessageDisplayed());
		}

	}

	@Test
	public void EC_04_CustomerIDCanNotHaveSpecialCharacters() {
		for (String specialPhoneNumber : specialPhoneNumbers) {
			editcustomerPage.clearCustomerIDTextbox();
			editcustomerPage.inputValueToCustomerIDTextbox(specialPhoneNumber);
			Assert.assertTrue(editcustomerPage.isSpecialCharactersOfCustomerIDAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void EC_05_AddressCanNotBeEmpty() {
		editcustomerPage.clearCustomerIDTextbox();
		editcustomerPage.inputValueToCustomerIDTextbox(customerID);
		editcustomerPage.clickToCustomerIDSubmitButton();
		editcustomerPage.clearAdressTextArea();
		editcustomerPage.clickToAddressTextarea();
		editcustomerPage.pressTABKeyToAddressTextArea();
		Assert.assertTrue(editcustomerPage.isAddressFieldMustNotBeBlankMessageDisplayed());

	}

	@Test
	public void EC_06_AdressCanNotHaveSpecialCharacters() {
		for (String specialCharactersAddress : specialCharacters) {
			editcustomerPage.clearAdressTextArea();
			editcustomerPage.inputValueToAdressTextArea(specialCharactersAddress);
			Assert.assertTrue(editcustomerPage.isSpecialCharactersOfAddressAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void EC_07_AddressCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearAdressTextArea();
		editcustomerPage.inputValueToAdressTextArea(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfAddressCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void EC_08_CityCanNotBeEmpty() {
		editcustomerPage.clearCityTextbox();
		editcustomerPage.clickToCityTextbox();
		editcustomerPage.pressTABKeyToCityTextbox();
		Assert.assertTrue(editcustomerPage.isCityMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void EC_09_CityCanNotBeNumberic() {
		for (String numericCity : numericValues) {
			editcustomerPage.clearCityTextbox();
			editcustomerPage.inputValueToCityTextbox(numericCity);
			Assert.assertTrue(editcustomerPage.isNumbersAreNotAllowedMessageOfCityDisplayed());
		}
	}

	@Test
	public void EC_10_CityCanNotHaveSpecialCharacters() {
		for (String specialCharactersCity : specialCharacters) {
			editcustomerPage.clearCityTextbox();
			editcustomerPage.inputValueToCityTextbox(specialCharactersCity);
			Assert.assertTrue(editcustomerPage.isSpecialCharactersOfCityAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void EC_11_CityCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearCityTextbox();
		editcustomerPage.inputValueToCityTextbox(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfCityCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void EC_12_StateCanNotBeEmpty() {
		editcustomerPage.clearStateTextbox();
		editcustomerPage.clickToStateTextbox();
		editcustomerPage.pressTABKeyToStateTextbox();
		Assert.assertTrue(editcustomerPage.isStateMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void EC_13_StateCanNotBeNumberic() {
		for (String numericState : numericValues) {
			editcustomerPage.clearStateTextbox();
			editcustomerPage.inputValueToStateTextbox(numericState);
			Assert.assertTrue(editcustomerPage.isNumbersAreNotAllowedMessageOfStateDisplayed());
		}
	}

	@Test
	public void EC_14_StateCanNotHaveSpecialCharacters() {
		for (String specialCharactersState : specialCharacters) {
			editcustomerPage.clearStateTextbox();
			editcustomerPage.inputValueToStateTextbox(specialCharactersState);
			Assert.assertTrue(editcustomerPage.isSpecialCharactersOfStateAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void EC_15_StateCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearStateTextbox();
		editcustomerPage.inputValueToStateTextbox(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfStateCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void EC_16_PinCanNotBeEmpty() {
		editcustomerPage.clearPinTextbox();
		editcustomerPage.clickToPinTextbox();
		editcustomerPage.pressTABKeyToPinTextbox();
		Assert.assertTrue(editcustomerPage.isPinMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void EC_17_PinMustBeNumeric() {
		for (String characterPIN : characterPINs) {
			editcustomerPage.clearPinTextbox();
			editcustomerPage.inputValueToPinTextbox(characterPIN);
			Assert.assertTrue(editcustomerPage.isPinCharacterAreNotAllowMessageDisplayed());
		}
	}

	@Test
	public void EC_18_PinMustHave6Degits() {
		for (String lessThan6Digits : lessThan6DigitsList) {
			editcustomerPage.clearPinTextbox();
			editcustomerPage.inputValueToPinTextbox(lessThan6Digits);
			Assert.assertTrue(editcustomerPage.isPinMustHave6DegitsMessageDisplayed());
		}
	}

	@Test
	public void EC_19_PinCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearPinTextbox();
		editcustomerPage.inputValueToPinTextbox(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfPinCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void EC_20_TelephoneCanNotBeEmpty() {
		editcustomerPage.clearPhoneTextbox();
		editcustomerPage.clickToMobileNumberTextbox();
		editcustomerPage.pressTABKeyToMobileTextbox();
		Assert.assertTrue(editcustomerPage.isPhoneMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void EC_21_TelephoneCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearPhoneTextbox();
		editcustomerPage.inputValueToMobileNumberTextbox(blankSpace);
		Assert.assertTrue(editcustomerPage.isFirstCharacterOfPhoneCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void EC_22_TelephoneCharacterOrIncludeSpaceAreNotAllow() {
		for (String characterPhoneNumber : characterPhoneNumbers) {
			editcustomerPage.clearPhoneTextbox();
			editcustomerPage.inputValueToMobileNumberTextbox(characterPhoneNumber);
			Assert.assertTrue(editcustomerPage.isPhoneCharacterAreNotAllowMessageDisplayed());
		}

	}

	@Test
	public void EC_23_TelephoneCanNotHaveSpecialCharacters() {
		for (String specialPhoneNumber : specialPhoneNumbers) {
			editcustomerPage.clearPhoneTextbox();
			editcustomerPage.inputValueToMobileNumberTextbox(specialPhoneNumber);
			Assert.assertTrue(editcustomerPage.isSpecialCharactersOfPhoneAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void EC_24_EmailCanNotBeEmpty() {
		editcustomerPage.clearEmailTextbox();
		editcustomerPage.clickToEmailTextbox();
		editcustomerPage.pressTABKeyToEmailTextbox();
		Assert.assertTrue(editcustomerPage.isEmailMustNotBeBlankMessageDisplayed());
	}

	@Test
	public void EC_25_EmailMustBeInCorrectFormat() {
		for (String incorrectEmailID : incorrectEmailIDList) {
			editcustomerPage.clearEmailTextbox();
			editcustomerPage.inputValueToEmailTextbox(incorrectEmailID);
			Assert.assertTrue(editcustomerPage.isEmailIDIsNotValidMessageDisplayed());
		}
	}

	@Test
	public void EC_26_EmailCanNotHaveFirstCharacterAsBlankSpace() {
		editcustomerPage.clearEmailTextbox();
		editcustomerPage.inputValueToEmailTextbox(blankSpace);
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
