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
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class DeleteCustomer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private DeleteCustomerPageObject deleteCustomerPage;
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
	
	private String[] characterPhoneNumbers = new String[] { "haitp", "12 1234" };
	private String[] specialPhoneNumbers = new String[] { "097@!13546", "!#123654", "0987654#@!" };

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
		userIdInfo = registerPage.getUserIDInfor();
		passwordInfo = registerPage.getPasswordInfor();
		loginPage = registerPage.openLoginPage(loginPageUrl);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inPutToUserIDTextbox(userIdInfo);
		loginPage.inPutToPasswordTextbox(passwordInfo);
		homePage = loginPage.clickToLoginButton();
		homePage.isWelcomeMessageDisplayed();
		homePage.isUserIDDisplayed(userIdInfo);
		newCustomerPage = homePage.openNewCutomerPage(driver);

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

		deleteCustomerPage = newCustomerPage.openDeleteCutomerPage(driver);
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
		deleteCustomerPage.inputBlankSpaceToCustomerIDTextbox(blankSpace);
		Assert.assertTrue(deleteCustomerPage.isFirstCharacterOfCustomerIDCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void DC_03_CustomerIDCharacterOrIncludeSpaceAreNotAllow() {
		for (String characterPhoneNumber : characterPhoneNumbers) {
			deleteCustomerPage.clearCustomerIDTextbox();
			deleteCustomerPage.inputChractersValueToCustomerIDTextbox(characterPhoneNumber);
			Assert.assertTrue(deleteCustomerPage.isCustomerIDCharacterAreNotAllowMessageDisplayed());
		}

	}

	@Test
	public void DC_04_CustomerIDCanNotHaveSpecialCharacters() {
		for (String specialPhoneNumber : specialPhoneNumbers) {
			deleteCustomerPage.clearCustomerIDTextbox();
			deleteCustomerPage.inputSpecialCharactersToCustomerIDTextbox(specialPhoneNumber);
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
