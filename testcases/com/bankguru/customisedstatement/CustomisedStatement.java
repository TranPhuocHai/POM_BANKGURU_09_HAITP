package com.bankguru.customisedstatement;

import java.util.Random;

import org.openqa.selenium.WebDriver;
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

		log.info("Precondition: Step 01 - open Login Page");
		loginPage = PageFactoryManager.getLoginPage(driver);
		
		log.info("Precondition: Step 02 - Verify Login Form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());
		
		log.info("Precondition: Step 03 - Get Login Page url");
		loginPageUrl = loginPage.getLoginPageUrl();
		
		log.info("Precondition: Step 04 - Click to 'here' link");
		registerPage = loginPage.clickToHereLink();
		
		log.info("Precondition: Step 05 - Verify Register Page displayed");
		verifyTrue(registerPage.isRegisterPageDisplayed());
		
		log.info("Precondition: Step 06 - Input to 'Email ID' textbox");
		registerPage.inPutToEmailIDTextbox(email);
		
		log.info("Precondition: Step 07 - Click to Submit button");
		registerPage.clickToSubmitButton();
		
		log.info("Precondition: Step 08 - Get UserID and Password Infor");
		userIdInfo = registerPage.getTextDynamicInfo(driver, "User ID :");
		passwordInfo = registerPage.getTextDynamicInfo(driver, "Password :");
		
		log.info("Precondition: Step 09 - Open Login Page");
		loginPage = registerPage.openLoginPage(loginPageUrl);
		
		log.info("Precondition: Step 10 - Verify Login Form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());
		
		log.info("Precondition: Step 11 - Input to userID and Password textboxes");
		loginPage.inPutToUserIDTextbox(userIdInfo);
		loginPage.inPutToPasswordTextbox(passwordInfo);
		
		log.info("Precondition: Step 11 - Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Precondition: Step 12 - Verify Welcome message of Home page displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed());
		
		log.info("Precondition: Step 13 - Verify User ID infor displayed");
		verifyTrue(homePage.isUserIDDisplayed(userIdInfo));
		
		log.info("Precondition: Step 14 - Click to 'New Customer' link");
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

		log.info("Precondition: Step 15 - Input to Customer Name textbox");
		newCustomerPage.inputValueToCustomerNameTextbox(validName);
		
		log.info("Precondition: Step 16 - Select Male gender");
		newCustomerPage.selectMaleGenderRadioButton();
		
		log.info("Precondition: Step 17 - Remove Date Of Birth attribute");
		newCustomerPage.removeDateOfBirthAttribute();
		
		log.info("Precondition: Step 18 - Input to Date Of Birth textbox");
		newCustomerPage.inputValueToDateOfBirthTextbox(validDateOfBirth);
		
		log.info("Precondition: Step 19 - Input to 'Address' text area");
		newCustomerPage.inputValueToAdressTextArea(validAdress);
		
		log.info("Precondition: Step 20 - Input to 'City' textbox");
		newCustomerPage.inputValueToCityTextbox(validCity);
		
		log.info("Precondition: Step 21 - Input to 'State' textbox");
		newCustomerPage.inputValueToStateTextbox(validState);
		
		log.info("Precondition: Step 22 - Input to 'PIN' textbox");
		newCustomerPage.inputValueToPinTextbox(validPin);
		
		log.info("Precondition: Step 23 - Input to 'Mobile Number' textbox");
		newCustomerPage.inputValueToMobileNumberTextbox(validPhoneNumber);
		
		log.info("Precondition: Step 24 - Input to 'Email' textbox");
		newCustomerPage.inputValueToEmailTextbox(validEmailID);
		
		log.info("Precondition: Step 25 - Input to 'Password' textbox");
		newCustomerPage.inputValueToPasswordTextbox(validPassword);
		
		log.info("Precondition: Step 26 - Click to Submit button");
		newCustomerPage.clickToSubmitButton();
		
		log.info("Precondition: Step 27 - Verify 'Customer Registered Successfully!!!' message displayed");
		verifyTrue(newCustomerPage.isCustomerRegisteredSuccessfullyDisplayed());
		
		log.info("Precondition: Step 28 - Get Customer ID");
		customerID = newCustomerPage.getTextDynamicInfo(driver, "Customer ID");

		log.info("Precondition: Step 29 - Verify all infor of new customer are correct");
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Customer Name"), validName);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Gender"), expectedGender);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Birthdate"), validDateOfBirth);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Address"), validAdress);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "City"), validCity);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "State"), validState);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Pin"), validPin);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Mobile No."), validPhoneNumber);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Email"), validEmailID);

		log.info("Precondition: Step 30 - Click To 'New Account' link");
		newCustomerPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);
		
		log.info("Precondition: Step 31 - Click To 'New Account' link");
		newAccountPage.inputValueToCustomerIDTextbox(customerID);
		
		log.info("Precondition: Step 32 - select 'Current' in 'Account type' dropdown");
		newAccountPage.selectCurrentInAccountType();
		
		log.info("Precondition: Step 33 - Input to Initial deposit textbox");
		newAccountPage.inputValueToInitialDepositTextbox(String.valueOf(currentAmount));
		
		log.info("Precondition: Step 34 - Click to Submit button");
		newAccountPage.clickToSubmitButton();
		
		log.info("Precondition: Step 35 - Veirfy 'Account generated successfully' message displayed");
		verifyTrue(newAccountPage.isAccountGeneratedSuccessfullyMessageDisplayed());
		
		log.info("Precondition: Step 36 - Veirfy current amount is correct");
		verifyEquals(newAccountPage.getTextDynamicInfo(driver, "Current Amount"), String.valueOf(currentAmount));
		
		log.info("Precondition: Step 37 - Get Account ID infor");
		accountID = newAccountPage.getTextDynamicInfo(driver, "Account ID");
		
		log.info("Precondition: Step 38 - Click to 'Customised Statement' link");
		newAccountPage.openMultiplePage(driver, "Customised Statement");
		customisedStatementPage = PageFactoryManager.getCustomisedStatementPage(driver);
		
		log.info("Precondition: Step 29 - Verify 'Customized Statement Form' displayed");
		verifyTrue(customisedStatementPage.isCustomisedStatementFormDisplayed());
	}
	
	@Test
	public void CS_01_AccountNumberCanNotBeEmpty() {
		
		log.info("AccountNumberCanNotBeEmpty: Step 01 - Clear 'Account Number' textbox");
		customisedStatementPage.clearAccountNumberTextbox();
		
		log.info("AccountNumberCanNotBeEmpty: Step 02 - Click to 'Account Number' textbox");
		customisedStatementPage.clickToAccountNumberTexbox();
		
		log.info("AccountNumberCanNotBeEmpty: Step 03 - Press TAB key");
		customisedStatementPage.pressTABKeyToAccountNumberTextbox();
		
		log.info("AccountNumberCanNotBeEmpty: Step 04 - Verify 'Account Number must not be blank' message displayed");
		verifyTrue(customisedStatementPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Account Number"));
	}

	@Test
	public void CS_02_AccountNumberCharacterAreNotAllowed() {
		for (String characterValue : characterValues) {
			
			log.info("AccountNumberCharacterAreNotAllowed: Step 01 - Clear 'Account Number' textbox");
			customisedStatementPage.clearAccountNumberTextbox();
			
			log.info("AccountNumberCharacterAreNotAllowed: Step 02 - Input to 'Account Number' textbox");
			customisedStatementPage.inputValueToAccountNumberTextbox(characterValue);
			
			log.info("AccountNumberCanNotBeEmpty: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Account No"));
		}
	}

	@Test
	public void CS_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 01 - Clear 'Account Number' textbox");
			customisedStatementPage.clearAccountNumberTextbox();
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 02 - Input to 'Account Number' textbox");
			customisedStatementPage.inputValueToAccountNumberTextbox(specialValue);
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(customisedStatementPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Account No"));
		}
	}

	@Test
	public void CS_04_AccountNumberFirstCharacterMustNotBeBlank() {
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 01 - Clear 'Account Number' textbox");
		customisedStatementPage.clearAccountNumberTextbox();
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 02 - Input to 'Account Number' textbox");
		customisedStatementPage.inputValueToAccountNumberTextbox(blankSpace);
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Account No"));

	}
	
	@Test
	public void CS_05_MinimumTransactionValueCharacterAreNotAllowed() {
		for (String CharacterMinimumTransactionValue : characterValues) {
			
			log.info("MinimumTransactionValueCharacterAreNotAllowed: Step 01 - Clear 'Minimum Transaction Value' textbox");
			customisedStatementPage.clearMinimumTransactionValueTextbox();
			
			log.info("MinimumTransactionValueCharacterAreNotAllowed: Step 02 - Input to 'Minimum Transaction Value' textbox");
			customisedStatementPage.inputValueToMinimumTransactionValueTextbox(CharacterMinimumTransactionValue);
			
			log.info("MinimumTransactionValueCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Minimum Transaction Value"));
		}
	}
	
	@Test
	public void CS_06_MinimumTransactionValueCanNotHaveSpecialCharacters() {
		for (String specialMinimumTransactionValue : specialValues) {
			
			log.info("MinimumTransactionValueCanNotHaveSpecialCharacters: Step 01 - Clear 'Minimum Transaction Value' textbox");
			customisedStatementPage.clearMinimumTransactionValueTextbox();
			
			log.info("MinimumTransactionValueCanNotHaveSpecialCharacters: Step 02 - Input to 'Minimum Transaction Value' textbox");
			customisedStatementPage.inputValueToMinimumTransactionValueTextbox(specialMinimumTransactionValue);
			
			log.info("MinimumTransactionValueCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(customisedStatementPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Minimum Transaction Value"));
		}
	}
	
	@Test
	public void CS_07_MinimumTransactionValueFirstCharacterMustNotBeBlank() {
		
		log.info("MinimumTransactionValueFirstCharacterMustNotBeBlank: Step 01 - Clear 'Minimum Transaction Value' textbox");
		customisedStatementPage.clearMinimumTransactionValueTextbox();
		
		log.info("MinimumTransactionValueFirstCharacterMustNotBeBlank: Step 02 - Input to 'Minimum Transaction Value' textbox");
		customisedStatementPage.inputValueToMinimumTransactionValueTextbox(blankSpace);
		
		log.info("MinimumTransactionValueFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Minimum Transaction Value"));
		
	}
	
	@Test
	public void CS_08_NumberOfTransactionCharacterAreNotAllowed() {
		for (String CharacterNumberOfTransaction : characterValues) {
			
			log.info("NumberOfTransactionCharacterAreNotAllowed: Step 01 - Clear 'Number of Transaction' textbox");
			customisedStatementPage.clearNumberOfTransactionTextbox();
			
			log.info("NumberOfTransactionCharacterAreNotAllowed: Step 02 - Input to 'Number of Transaction' textbox");
			customisedStatementPage.inputValueToNumberOfTransactionTextbox(CharacterNumberOfTransaction);
			
			log.info("NumberOfTransactionCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Number of Transaction"));
		}
	}

	@Test
	public void CS_09_NumberOfTransactionCanNotHaveSpecialCharacters() {
		for (String specialNumberOfTransaction : specialValues) {
			
			log.info("NumberOfTransactionCanNotHaveSpecialCharacters: Step 01 - Clear 'Number of Transaction' textbox");
			customisedStatementPage.clearNumberOfTransactionTextbox();
			
			log.info("NumberOfTransactionCanNotHaveSpecialCharacters: Step 02 - Input to 'Number of Transaction' textbox");
			customisedStatementPage.inputValueToNumberOfTransactionTextbox(specialNumberOfTransaction);
			
			log.info("NumberOfTransactionCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(customisedStatementPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Number of Transaction"));
		}
	}

	@Test
	public void CS_10_NumberOfTransactionFirstCharacterMustNotBeBlank() {
		
		log.info("NumberOfTransactionFirstCharacterMustNotBeBlank: Step 01 - Clear 'Number of Transaction' textbox");
		customisedStatementPage.clearNumberOfTransactionTextbox();
		
		log.info("NumberOfTransactionFirstCharacterMustNotBeBlank: Step 02 - Input to 'Number of Transaction' textbox");
		customisedStatementPage.inputValueToNumberOfTransactionTextbox(blankSpace);
		
		log.info("NumberOfTransactionFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Number of Transaction"));

	}
	
	@Test
	public void CS_11_InputValidInforAndVerifyCustomisedStatementDisplayed() {
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 01 - Clear 'Account Number' textbox");
		customisedStatementPage.clearAccountNumberTextbox();
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 02 - Input to 'Account Number' textbox");
		customisedStatementPage.inputValueToAccountNumberTextbox(accountID);
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 03 - Clear 'Minimum Transaction Value' textbox");
		customisedStatementPage.clearMinimumTransactionValueTextbox();
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 04 - Input to 'Minimum Transaction Value' textbox");
		customisedStatementPage.inputValueToMinimumTransactionValueTextbox(currentAmount);
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 05 - Clear 'Number of Transaction' textbox");
		customisedStatementPage.clearNumberOfTransactionTextbox();
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 06 - Input to 'Number of Transaction' textbox");
		customisedStatementPage.inputValueToNumberOfTransactionTextbox(numberOfTransaction);
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 07 - Click to Submit button");
		customisedStatementPage.clickSubmitButton();		
		
		log.info("NumberOfTransactionFirstCharacterMustNotBeBlank: Step 03 - Verify Transaction Details message displayed");
		verifyTrue(customisedStatementPage.isTransactionDetailsFormDisplayed(accountID));
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
