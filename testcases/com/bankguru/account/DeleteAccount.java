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
import pageObjects.DeleteAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class DeleteAccount extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DeleteAccountPageObject deleteAccountPage;

	private String loginPageUrl, userIdInfo, passwordInfo, customerID;

	private String email = "tpkcdnam" + randomNumber() + "@gmail.com";
	private String validName = "Jame Hugo";
	private String expectedGender = "male";
	private String validDateOfBirth = "1988-07-31";
	private String validAdress = "100 Ho Guom";
	private String validCity = "Ha Noi";
	private String validState = "Hoan Kiem";
	private String validPin = "600000";
	private String validPhoneNumber = "0987654321";
	private String validEmailID = "jame" + randomNumber() + "@gmail.com";
	private String validPassword = "nopdontknow12";
	private String blankSpace = " ";

	private int currentAmount = 50000;
	private String[] characterAccountNos = new String[] { "haitp", "12 1234" };
	private String[] specialAccountNos = new String[] { "097@!13546", "!#123654", "0987654#@!" };

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

		newCustomerPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);

		newAccountPage.inputValueToCustomerIDTextbox(customerID);
		newAccountPage.selectCurrentInAccountType();
		newAccountPage.inputValueToInitialDepositTextbox(String.valueOf(currentAmount));
		newAccountPage.clickToSubmitButton();
		Assert.assertTrue(newAccountPage.isAccountGeneratedSuccessfullyMessageDisplayed());
		Assert.assertEquals(newAccountPage.getTextDynamicInfo(driver, "Current Amount"), String.valueOf(currentAmount));

		newAccountPage.openMultiplePage(driver, "Delete Account");
		deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);
		Assert.assertTrue(deleteAccountPage.isDeleteAccountFormDisplayed());
	}

	@Test
	public void DA_01_AccountNumberCanNotBeEmpty() {
		deleteAccountPage.clearAccountNumberTextbox();
		deleteAccountPage.clickToAccountNumberTexbox();
		deleteAccountPage.pressTABKeyToAccountNumberTextbox();
		Assert.assertTrue(deleteAccountPage.isAccountNumberMustNotBeBlankDisplayed());
	}

	@Test
	public void DA_02_AccountNumberCharacterOrIncludeSpaceAreNotAllow() {
		for (String characterAccountNo : characterAccountNos) {
			deleteAccountPage.clearAccountNumberTextbox();
			deleteAccountPage.inputValueToAccountNumberTextbox(characterAccountNo);
			Assert.assertTrue(deleteAccountPage.isAccountNumberCharacterAreNotAllowMessageDisplayed());
		}
	}

	@Test
	public void DA_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialAccountNo : specialAccountNos) {
			deleteAccountPage.clearAccountNumberTextbox();
			deleteAccountPage.inputValueToAccountNumberTextbox(specialAccountNo);
			Assert.assertTrue(deleteAccountPage.isSpecialCharactersOfAccountNumberAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void DA_04_AccountNumberFirstCharacterMustNotBeBlank() {
		deleteAccountPage.clearAccountNumberTextbox();
		deleteAccountPage.inputValueToAccountNumberTextbox(blankSpace);
		Assert.assertTrue(deleteAccountPage.isAccountNumberCharacterAreNotAllowMessageDisplayed());

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
