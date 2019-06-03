package com.bankguru.ministatement;

import java.util.Random;

import org.openqa.selenium.WebDriver;
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

	private String email = "babonliemth" + randomNumber() + "@gmail.com";
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
		
		log.info("Precondition: Step 11 - Input to 'userID' and 'Password' textboxes");
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

		log.info("Precondition: Step 15 - Input to 'Customer Name' textbox");
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
		
		log.info("Precondition: Step 38 - Click to 'Mini Statement' link");
		newAccountPage.openMultiplePage(driver, "Mini Statement");
		miniStatementPage = PageFactoryManager.getMiniStatementPage(driver);
		
		log.info("Precondition: Step 39 - Veify Mini Statement form displayed");
		verifyTrue(miniStatementPage.isMiniStatementFormDisplayed());
	}

	@Test
	public void MS_01_AccountNumberCanNotBeEmpty() {
		
		log.info("AccountNumberCanNotBeEmpty: Step 01 - Clear 'Account Number' textbox");
		miniStatementPage.clearAccountNumberTextbox();
		
		log.info("AccountNumberCanNotBeEmpty: Step 02 - Click to 'Account Number' textbox");
		miniStatementPage.clickToAccountNumberTexbox();
		
		log.info("AccountNumberCanNotBeEmpty: Step 03 - Press TAB key");
		miniStatementPage.pressTABKeyToAccountNumberTextbox();
		
		log.info("AccountNumberCanNotBeEmpty: Step 04 - Verify 'Account Number must not be blank' message displayed");
		verifyTrue(miniStatementPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Account Number"));
	}

	@Test
	public void MS_02_AccountNumberCharacterAreNotAllowed() {
		for (String characterAccountNo : characterAccountNos) {
			
			log.info("AccountNumberCharacterAreNotAllowed: Step 01 - Clear 'Account Number' textbox");
			miniStatementPage.clearAccountNumberTextbox();
			
			log.info("AccountNumberCharacterAreNotAllowed: Step 02 - Input to 'Account Number' textbox");
			miniStatementPage.inputValueToAccountNumberTextbox(characterAccountNo);
			
			log.info("AccountNumberCanNotBeEmpty: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(miniStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Account No"));
		}
	}

	@Test
	public void MS_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialAccountNo : specialAccountNos) {
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 01 - Clear 'Account Number' textbox");
			miniStatementPage.clearAccountNumberTextbox();
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 02 - Input to 'Account Number' textbox");
			miniStatementPage.inputValueToAccountNumberTextbox(specialAccountNo);
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(miniStatementPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Account No"));
		}
	}

	@Test
	public void MS_04_AccountNumberFirstCharacterMustNotBeBlank() {
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 01 - Clear 'Account Number' textbox");
		miniStatementPage.clearAccountNumberTextbox();
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 02 - Input to 'Account Number' textbox");
		miniStatementPage.inputValueToAccountNumberTextbox(blankSpace);
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyTrue(miniStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Account No"));

	}
	
	@Test
	public void MS_05_ValidAccountNumber() {
		
		log.info("ValidAccountNumber: Step 01 - Clear 'Account Number' textbox");
		miniStatementPage.clearAccountNumberTextbox();
		
		log.info("ValidAccountNumber: Step 02 - Input to 'Account Number' textbox");
		miniStatementPage.inputValueToAccountNumberTextbox(accountID);
		
		log.info("ValidAccountNumber: Step 03 - Click to submit button");
		miniStatementPage.clickAccountNumberSubmitButton();
		
		log.info("ValidAccountNumber: Step 04 - Verify Last Five Transaction Details message displayed");
		verifyTrue(miniStatementPage.isLastFiveTransactionDetailsDispayed(accountID));
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
