package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.user.Common_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;

public class NewAccount extends AbstractTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewAccountPageObject newAccountPage;
	
	private String blankSpace = " ";
	private String[] characterValues = new String[] { "haitp", "12 1234" };
	private String[] specialValues = new String[] { "097@!13546", "!#123654", "0987654#@!" };

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);

		log.info("Precondition: Step 01 - Open Login Page");
		loginPage = PageFactoryManager.getLoginPage(driver);
		
		log.info("Precondition: Step 02 - Verify Login Form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());
		
		log.info("Precondition: Step 03 - Input to userID and 'Password' textboxes");
		loginPage.inPutToUserIDTextbox(Common_01_RegisterToSystem.USER_ID_INFOR);
		loginPage.inPutToPasswordTextbox(Common_01_RegisterToSystem.PASSWORD_INFOR);
		
		log.info("Precondition: Step 04 - Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Precondition: Step 05 - Verify Welcome message of Home page displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed());
		
		log.info("Precondition: Step 06 - Verify User ID infor displayed");
		verifyTrue(homePage.isUserIDDisplayed(Common_01_RegisterToSystem.USER_ID_INFOR));

		log.info("Precondition: Step 07 - Click To 'New Account' link");
		homePage.openMultiplePage(driver, "New Account");
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


	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
