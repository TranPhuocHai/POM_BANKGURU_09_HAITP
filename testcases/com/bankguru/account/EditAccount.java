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
import pageObjects.EditAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class EditAccount extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private EditAccountPageObject editAccountPage;

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
		accountID = newAccountPage.getTextDynamicInfo(driver, "Account ID");

		newAccountPage.openMultiplePage(driver, "Edit Account");
		editAccountPage = PageFactoryManager.getEditAccountPage(driver);
	}

	@Test
	public void EA_01_AccountNumberCanNotBeEmpty() {
		editAccountPage.clearAccountNumberTextbox();
		editAccountPage.clickToAccountNumberTexbox();
		editAccountPage.pressTABKeyToAccountNumberTextbox();
		Assert.assertTrue(editAccountPage.isAccountNumberMustNotBeBlankDisplayed());
	}

	@Test
	public void EA_02_AccountNumberCharacterOrIncludeSpaceAreNotAllow() {
		for (String characterAccountNo : characterAccountNos) {
			editAccountPage.clearAccountNumberTextbox();
			editAccountPage.inputValueToAccountNumberTextbox(characterAccountNo);
			Assert.assertTrue(editAccountPage.isAccountNumberCharacterAreNotAllowMessageDisplayed());
		}
	}

	@Test
	public void EA_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialAccountNo : specialAccountNos) {
			editAccountPage.clearAccountNumberTextbox();
			editAccountPage.inputValueToAccountNumberTextbox(specialAccountNo);
			Assert.assertTrue(editAccountPage.isSpecialCharactersOfAccountNumberAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void EA_04_AccountNumberFirstCharacterMustNotBeBlank() {
		editAccountPage.clearAccountNumberTextbox();
		editAccountPage.inputValueToAccountNumberTextbox(blankSpace);
		Assert.assertTrue(editAccountPage.isAccountNumberCharacterAreNotAllowMessageDisplayed());

	}
	
	@Test
	public void EA_05_ValidAccountNumber() {
		editAccountPage.clearAccountNumberTextbox();
		editAccountPage.inputValueToAccountNumberTextbox(accountID);
		editAccountPage.clickAccountNumberSubmitButton();
		Assert.assertTrue(editAccountPage.isEditCustomerFormDispayed());
	}
	
	@Test
	public void EA_06_EditAccountSuccess() {
		editAccountPage.selectSavingsInAccountType();
		editAccountPage.clickEditAccountSubmitButton();
		Assert.assertTrue(editAccountPage.isAccountDetailsUpdatedSuccessfullyDispayed());
		Assert.assertEquals(editAccountPage.getTextDynamicInfo(driver, "Account Type"), "Savings");
		
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