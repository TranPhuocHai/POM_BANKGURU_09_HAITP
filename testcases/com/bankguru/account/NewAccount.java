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

public class NewAccount extends AbstractTest {
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
		loginPage.inputToDynamicTextboxOrTextArea(driver, "uid", Common_01_RegisterToSystem.USER_ID_INFOR);
		loginPage.inputToDynamicTextboxOrTextArea(driver, "password", Common_01_RegisterToSystem.PASSWORD_INFOR);

		log.info("Precondition: Step 04 - Click to Login button to move to HomePage Url");
		loginPage.clickToDynamicButton(driver, "btnLogin");
		homePage = PageFactoryManager.getHomePage(driver);

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
		newAccountPage.clearDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotBeEmpty: Step 02 - Click to 'Customer ID' textbox");
		newAccountPage.clickToDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotBeEmpty: Step 03 - Press TAB key");
		newAccountPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotBeEmpty: Step 04 - Verify 'Customer ID is required' message displayed");
		verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Customer id"), "Customer ID is required");

	}

	@Test
	public void NC_02_CustomerIDCanNotHaveFirstBlankSpace() {

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 01 - Clear 'Customer ID' textbox");
		newAccountPage.clearDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 02 - Input to 'Customer ID' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", blankSpace);

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Customer id"), "First character can not have space");

	}

	@Test
	public void NC_03_CustomerIDCharacterAreNotAllowed() {
		for (String charactervalue : characterValues) {

			log.info("CustomerIDCharacterAreNotAllowed: Step 01 - Customer ID Number textbox");
			newAccountPage.clearDynamicTextboxOrTextArea(driver, "cusid");

			log.info("CustomerIDCharacterAreNotAllowed: Step 02 - Input to 'Customer ID' textbox");
			newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", charactervalue);

			log.info("CustomerIDCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Customer id"), "Characters are not allowed");
		}

	}

	@Test
	public void NC_04_CustomerIDCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 01 - Customer ID Number textbox");
			newAccountPage.clearDynamicTextboxOrTextArea(driver, "cusid");

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 02 - Input to 'Customer ID' textbox");
			newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", specialValue);

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Customer id"), "Special characters are not allowed");
		}
	}

	@Test
	public void NC_05_InitialDepositCanNotBeEmpty() {

		log.info("InitialDepositCanNotBeEmpty: Step 01 - Clear 'Initial deposit' textbox");
		newAccountPage.clearDynamicTextboxOrTextArea(driver, "inideposit");

		log.info("InitialDepositCanNotBeEmpty: Step 02 - Click to 'Initial deposit' textbox");
		newAccountPage.clickToDynamicTextboxOrTextArea(driver, "inideposit");

		log.info("InitialDepositCanNotBeEmpty: Step 03 - Press TAB key");
		newAccountPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "inideposit");

		log.info("InitialDepositCanNotBeEmpty: Step 04 - Verify 'Initial Deposit must not be blank' message displayed");
		verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Initial deposit"), "Initial Deposit must not be blank");

	}

	@Test
	public void NC_06_InitialDepositCanNotHaveFirstBlankSpace() {

		log.info("InitialDepositCanNotHaveFirstBlankSpace: Step 01 - Clear 'Initial deposit' textbox");
		newAccountPage.clearDynamicTextboxOrTextArea(driver, "inideposit");

		log.info("InitialDepositCanNotHaveFirstBlankSpace: Step 02 - Input to 'Initial deposit' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", blankSpace);

		log.info("InitialDepositCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Initial deposit"), "First character can not have space");

	}

	@Test
	public void NC_07_InitialDepositCharacterAreNotAllowed() {
		for (String characterValue : characterValues) {

			log.info("InitialDepositCharacterAreNotAllowed: Step 01 - Clear 'Initial deposit' textbox");
			newAccountPage.clearDynamicTextboxOrTextArea(driver, "inideposit");

			log.info("InitialDepositCharacterAreNotAllowed: Step 02 - Input to 'Initial deposit' textbox");
			newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", characterValue);

			log.info("InitialDepositCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Initial deposit"), "Characters are not allowed");
		}

	}

	@Test
	public void NC_08_InitialDepositCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {

			log.info("InitialDepositCanNotHaveSpecialCharacters: Step 01 - Clear 'Initial deposit' textbox");
			newAccountPage.clearDynamicTextboxOrTextArea(driver, "inideposit");

			log.info("InitialDepositCanNotHaveSpecialCharacters: Step 02 - Input to 'Initial deposit' textbox");
			newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", specialValue);

			log.info("InitialDepositCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Initial deposit"), "Special characters are not allowed");
		}
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
