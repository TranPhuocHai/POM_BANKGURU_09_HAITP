package com.bankguru.account;

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
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class NewAccount extends AbstractTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	
	private String loginPageUrl, userIdInfo, passwordInfo;	
	private String email = "khnammivc" + randomNumber() + "@gmail.com";
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

		log.info("Precondition: Step 28 - Verify all infor of new customer are correct");
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Customer Name"), validName);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Gender"), expectedGender);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Birthdate"), validDateOfBirth);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Address"), validAdress);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "City"), validCity);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "State"), validState);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Pin"), validPin);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Mobile No."), validPhoneNumber);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Email"), validEmailID);

		log.info("Precondition: Step 29 - Click To 'New Account' link");
		newCustomerPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);
	}
	
	@Test
	public void NC_01_CustomerIDCanNotBeEmpty() {

		log.info("CustomerIDCanNotBeEmpty: Step 01 - Clear 'Customer ID' textbox");
		newAccountPage.clearCustomerIDTextbox();

		log.info("CustomerIDCanNotBeEmpty: Step 02 - Click to 'Customer ID' textbox");
		newAccountPage.clickToCustomerIDTexbox();

		log.info("CustomerIDCanNotBeEmpty: Step 03 - Press TAB key");
		newAccountPage.pressTABKeyToCustomerIDTextbox();

		log.info("CustomerIDCanNotBeEmpty: Step 04 - Verify 'Customer ID is required' message displayed");
		verifyTrue(newAccountPage.isCustomerIDIsRequiredMessageDisplayed());

	}
	
	@Test
	public void NC_02_CustomerIDCanNotHaveFirstBlankSpace() {

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 01 - Clear 'Customer ID' textbox");
		newAccountPage.clearCustomerIDTextbox();

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 02 - Input to 'Customer ID' textbox");
		newAccountPage.inputValueToCustomerIDTextbox(blankSpace);

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(newAccountPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "Customer id"));

	}
	
	@Test
	public void NC_03_CustomerIDCharacterAreNotAllowed() {
		for (String charactervalue : characterValues) {

			log.info("CustomerIDCharacterAreNotAllowed: Step 01 - Customer ID Number textbox");
			newAccountPage.clearCustomerIDTextbox();

			log.info("CustomerIDCharacterAreNotAllowed: Step 02 - Input to 'Customer ID' textbox");
			newAccountPage.inputValueToCustomerIDTextbox(charactervalue);

			log.info("CustomerIDCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(newAccountPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Customer id"));
		}

	}
	
	@Test
	public void NC_04_CustomerIDCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 01 - Customer ID Number textbox");
			newAccountPage.clearCustomerIDTextbox();

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 02 - Input to 'Customer ID' textbox");
			newAccountPage.inputValueToCustomerIDTextbox(specialValue);

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(newAccountPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Customer id"));
		}
	}
	
	@Test
	public void NC_05_InitialDepositCanNotBeEmpty() {
		
		log.info("InitialDepositCanNotBeEmpty: Step 01 - Clear 'Initial deposit' textbox");
		newAccountPage.clearInitialDepositTextbox();
		
		log.info("InitialDepositCanNotBeEmpty: Step 02 - Click to 'Initial deposit' textbox");
		newAccountPage.clickToInitialDepositTexbox();
		
		log.info("InitialDepositCanNotBeEmpty: Step 03 - Press TAB key");
		newAccountPage.pressTABKeyToInitialDepositTextbox();
		
		log.info("InitialDepositCanNotBeEmpty: Step 04 - Verify 'Initial Deposit must not be blank' message displayed");
		verifyTrue(newAccountPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Initial Deposit"));

	}

	@Test
	public void NC_06_InitialDepositCanNotHaveFirstBlankSpace() {
		
		log.info("InitialDepositCanNotHaveFirstBlankSpace: Step 01 - Clear 'Initial deposit' textbox");
		newAccountPage.clearInitialDepositTextbox();
		
		log.info("InitialDepositCanNotHaveFirstBlankSpace: Step 02 - Input to 'Initial deposit' textbox");
		newAccountPage.inputValueToInitialDepositTextbox(blankSpace);
		
		log.info("InitialDepositCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(newAccountPage.isFirstCharacterOfInitialDepositCanNotHaveSpaceMessageDisplayed());

	}

	@Test
	public void NC_07_InitialDepositCharacterAreNotAllowed() {
		for (String characterValue : characterValues) {
			
			log.info("InitialDepositCharacterAreNotAllowed: Step 01 - Clear 'Initial deposit' textbox");
			newAccountPage.clearInitialDepositTextbox();
			
			log.info("InitialDepositCharacterAreNotAllowed: Step 02 - Input to 'Initial deposit' textbox");
			newAccountPage.inputValueToInitialDepositTextbox(characterValue);
			
			log.info("InitialDepositCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(newAccountPage.isInitialDepositCharacterAreNotAllowMessageDisplayed());
		}

	}

	@Test
	public void NC_08_InitialDepositCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			
			log.info("InitialDepositCanNotHaveSpecialCharacters: Step 01 - Clear 'Initial deposit' textbox");
			newAccountPage.clearInitialDepositTextbox();
			
			log.info("InitialDepositCanNotHaveSpecialCharacters: Step 02 - Input to 'Initial deposit' textbox");
			newAccountPage.inputValueToInitialDepositTextbox(specialValue);
			
			log.info("InitialDepositCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(newAccountPage.isSpecialCharactersOfInitialDepositAreNotAllowedMessageDisplayed());
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
