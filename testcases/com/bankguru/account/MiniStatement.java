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
import pageObjects.MiniStatementPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class MiniStatement extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private MiniStatementPageObject miniStatementPage;

	private String loginPageUrl, userIdInfo, passwordInfo, customerID, accountID;

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
		userIdInfo = registerPage.getUserIDInfor();
		passwordInfo = registerPage.getPasswordInfor();
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

		Assert.assertEquals(newCustomerPage.getTextCustomerNameInfo(), validName);
		Assert.assertEquals(newCustomerPage.getTextGenderInfo(), expectedGender);
		Assert.assertEquals(newCustomerPage.getDateOfBirthInfo(), validDateOfBirth);
		Assert.assertEquals(newCustomerPage.getTextAdressInfo(), validAdress);
		Assert.assertEquals(newCustomerPage.getTextCityInfo(), validCity);
		Assert.assertEquals(newCustomerPage.getTextStateInfo(), validState);
		Assert.assertEquals(newCustomerPage.getTextPinInfo(), validPin);
		Assert.assertEquals(newCustomerPage.getTextMobileNumberInfo(), validPhoneNumber);
		Assert.assertEquals(newCustomerPage.getTextEmailInfo(), validEmailID);

		newCustomerPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);

		newAccountPage.inputValueToCustomerIDTextbox(customerID);
		newAccountPage.selectCurrentInAccountType();
		newAccountPage.inputValueToInitialDepositTextbox(String.valueOf(currentAmount));
		newAccountPage.clickToSubmitButton();
		Assert.assertTrue(newAccountPage.isAccountGeneratedSuccessfullyMessageDisplayed());
		Assert.assertEquals(newAccountPage.getTextCurrentAmount(), String.valueOf(currentAmount));
		accountID = newAccountPage.getAccountID();

		newAccountPage.openMultiplePage(driver, "Mini Statement");
		miniStatementPage = PageFactoryManager.getMiniStatementPage(driver);
		Assert.assertTrue(miniStatementPage.isMiniStatementFormDisplayed());
	}

	@Test
	public void MS_01_AccountNumberCanNotBeEmpty() {
		miniStatementPage.clearAccountNumberTextbox();
		miniStatementPage.clickToAccountNumberTexbox();
		miniStatementPage.pressTABKeyToAccountNumberTextbox();
		Assert.assertTrue(miniStatementPage.isAccountNumberMustNotBeBlankDisplayed());
	}

	@Test
	public void MS_02_AccountNumberCharacterOrIncludeSpaceAreNotAllow() {
		for (String characterAccountNo : characterAccountNos) {
			miniStatementPage.clearAccountNumberTextbox();
			miniStatementPage.inputValueToAccountNumberTextbox(characterAccountNo);
			Assert.assertTrue(miniStatementPage.isAccountNumberCharacterAreNotAllowMessageDisplayed());
		}
	}

	@Test
	public void MS_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialAccountNo : specialAccountNos) {
			miniStatementPage.clearAccountNumberTextbox();
			miniStatementPage.inputValueToAccountNumberTextbox(specialAccountNo);
			Assert.assertTrue(miniStatementPage.isSpecialCharactersOfAccountNumberAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void MS_04_AccountNumberFirstCharacterMustNotBeBlank() {
		miniStatementPage.clearAccountNumberTextbox();
		miniStatementPage.inputValueToAccountNumberTextbox(blankSpace);
		Assert.assertTrue(miniStatementPage.isAccountNumberCharacterAreNotAllowMessageDisplayed());

	}
	
	@Test
	public void MS_05_ValidAccountNumber() {
		miniStatementPage.clearAccountNumberTextbox();
		miniStatementPage.inputValueToAccountNumberTextbox(accountID);
		miniStatementPage.clickAccountNumberSubmitButton();
		Assert.assertTrue(miniStatementPage.isLastFiveTransactionDetailsDispayed(accountID));
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
