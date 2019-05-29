package com.bankguru.customisedstatement;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.CustomisedStatementPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class CustomisedStatement extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private CustomisedStatementPageObject customisedStatementPage;

	private String loginPageUrl, userIdInfo, passwordInfo, customerID, accountID;

	private String email = "tphaikhainamv" + randomNumber() + "@gmail.com";
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
	private String numberOfTransaction = "1";

	private String currentAmount = "50000";
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
		newAccountPage.inputValueToInitialDepositTextbox(currentAmount);
		newAccountPage.clickToSubmitButton();
		Assert.assertTrue(newAccountPage.isAccountGeneratedSuccessfullyMessageDisplayed());
		Assert.assertEquals(newAccountPage.getTextDynamicInfo(driver, "Current Amount"), String.valueOf(currentAmount));
		accountID = newAccountPage.getTextDynamicInfo(driver, "Account ID");

		newAccountPage.openMultiplePage(driver, "Customised Statement");
		customisedStatementPage = PageFactoryManager.getCustomisedStatementPage(driver);
		Assert.assertTrue(customisedStatementPage.isCustomisedStatementFormDisplayed());
	}
	
	@Test
	public void CS_01_AccountNumberCanNotBeEmpty() {
		customisedStatementPage.clearAccountNumberTextbox();
		customisedStatementPage.clickToAccountNumberTexbox();
		customisedStatementPage.pressTABKeyToAccountNumberTextbox();
		Assert.assertTrue(customisedStatementPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Account Number"));
	}

	@Test
	public void CS_02_AccountNumberCharacterOrIncludeSpaceAreNotAllow() {
		for (String characterAccountNo : characterValues) {
			customisedStatementPage.clearAccountNumberTextbox();
			customisedStatementPage.inputValueToAccountNumberTextbox(characterAccountNo);
			Assert.assertTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Account No"));
		}
	}

	@Test
	public void CS_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialAccountNo : specialValues) {
			customisedStatementPage.clearAccountNumberTextbox();
			customisedStatementPage.inputValueToAccountNumberTextbox(specialAccountNo);
			Assert.assertTrue(customisedStatementPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Account No"));
		}
	}

	@Test
	public void CS_04_AccountNumberFirstCharacterMustNotBeBlank() {
		customisedStatementPage.clearAccountNumberTextbox();
		customisedStatementPage.inputValueToAccountNumberTextbox(blankSpace);
		Assert.assertTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Account No"));

	}
	
	@Test
	public void CS_05_MinimumTransactionValueCharacterOrIncludeSpaceAreNotAllow() {
		for (String CharacterMinimumTransactionValue : characterValues) {
			customisedStatementPage.clearMinimumTransactionValueTextbox();
			customisedStatementPage.inputValueToMinimumTransactionValueTextbox(CharacterMinimumTransactionValue);
			Assert.assertTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Minimum Transaction Value"));
		}
	}
	
	
	@Test
	public void CS_06_MinimumTransactionValueCanNotHaveSpecialCharacters() {
		for (String specialMinimumTransactionValue : specialValues) {
			customisedStatementPage.clearMinimumTransactionValueTextbox();
			customisedStatementPage.inputValueToMinimumTransactionValueTextbox(specialMinimumTransactionValue);
			Assert.assertTrue(customisedStatementPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Minimum Transaction Value"));
		}
	}
	
	@Test
	public void CS_07_MinimumTransactionValueFirstCharacterMustNotBeBlank() {
		customisedStatementPage.clearMinimumTransactionValueTextbox();
		customisedStatementPage.inputValueToMinimumTransactionValueTextbox(blankSpace);
		Assert.assertTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Minimum Transaction Value"));
		
	}
	
	@Test
	public void CS_08_NumberOfTransactionCharacterOrIncludeSpaceAreNotAllow() {
		for (String CharacterNumberOfTransaction : characterValues) {
			customisedStatementPage.clearNumberOfTransactionTextbox();
			customisedStatementPage.inputValueToNumberOfTransactionTextbox(CharacterNumberOfTransaction);
			Assert.assertTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Number of Transaction"));
		}
	}
	

	@Test
	public void CS_09_NumberOfTransactionCanNotHaveSpecialCharacters() {
		for (String specialNumberOfTransaction : specialValues) {
			customisedStatementPage.clearNumberOfTransactionTextbox();
			customisedStatementPage.inputValueToNumberOfTransactionTextbox(specialNumberOfTransaction);
			Assert.assertTrue(customisedStatementPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Number of Transaction"));
		}
	}

	@Test
	public void CS_10_NumberOfTransactionFirstCharacterMustNotBeBlank() {
		customisedStatementPage.clearNumberOfTransactionTextbox();
		customisedStatementPage.inputValueToNumberOfTransactionTextbox(blankSpace);
		Assert.assertTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Number of Transaction"));

	}
	
	@Test
	public void CS_11_InputValidInforAndVerifyCustomisedStatementDisplayed() {
		customisedStatementPage.clearAccountNumberTextbox();
		customisedStatementPage.inputValueToAccountNumberTextbox(accountID);
		customisedStatementPage.clearMinimumTransactionValueTextbox();
		customisedStatementPage.inputValueToMinimumTransactionValueTextbox(currentAmount);
		customisedStatementPage.clearNumberOfTransactionTextbox();
		customisedStatementPage.inputValueToNumberOfTransactionTextbox(numberOfTransaction);
		customisedStatementPage.clickSubmitButton();		
		Assert.assertTrue(customisedStatementPage.isTransactionDetailsFormDisplayed(accountID));
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
