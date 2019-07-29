package com.bankguru.validateMessage;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commonFunction.Common_01_RegisterToSystem;
import com.bankguru.testdata.CommonTestData;
import com.bankguru.testdata.ValidateMessage;

import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.NewAccountPageObject;
import commons.AbstractTest;
import commons.PageFactoryManager;
import reportConfig.ExtentTestManager;

public class NewAccount extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewAccountPageObject newAccountPage;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);

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
	public void NC_01_CustomerIDCanNotBeEmpty(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("CustomerIDCanNotBeEmpty: Step 01 - Clear 'Customer ID' textbox");
		newAccountPage.clearDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotBeEmpty: Step 02 - Click to 'Customer ID' textbox");
		newAccountPage.clickToDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotBeEmpty: Step 03 - Press TAB key");
		newAccountPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotBeEmpty: Step 04 - Verify 'Customer ID is required' message displayed");
		verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Customer id"), ValidateMessage.CUSTOMER_ID_IS_REQUIRED);

	}

	@Test
	public void NC_02_CustomerIDCanNotHaveFirstBlankSpace(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 01 - Clear 'Customer ID' textbox");
		newAccountPage.clearDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 02 - Input to 'Customer ID' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", CommonTestData.BLANK_SPACE);

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Customer id"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void NC_03_CustomerIDCharacterAreNotAllowed(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String charactervalue : CommonTestData.CHARACTER_VALUE) {

			log.info("CustomerIDCharacterAreNotAllowed: Step 01 - Customer ID Number textbox");
			newAccountPage.clearDynamicTextboxOrTextArea(driver, "cusid");

			log.info("CustomerIDCharacterAreNotAllowed: Step 02 - Input to 'Customer ID' textbox");
			newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", charactervalue);

			log.info("CustomerIDCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Customer id"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}

	}

	@Test
	public void NC_04_CustomerIDCanNotHaveSpecialCharacters(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String specialValue : CommonTestData.SPECIAL_VALUE) {

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 01 - Customer ID Number textbox");
			newAccountPage.clearDynamicTextboxOrTextArea(driver, "cusid");

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 02 - Input to 'Customer ID' textbox");
			newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", specialValue);

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Customer id"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void NC_05_InitialDepositCanNotBeEmpty(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("InitialDepositCanNotBeEmpty: Step 01 - Clear 'Initial deposit' textbox");
		newAccountPage.clearDynamicTextboxOrTextArea(driver, "inideposit");

		log.info("InitialDepositCanNotBeEmpty: Step 02 - Click to 'Initial deposit' textbox");
		newAccountPage.clickToDynamicTextboxOrTextArea(driver, "inideposit");

		log.info("InitialDepositCanNotBeEmpty: Step 03 - Press TAB key");
		newAccountPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "inideposit");

		log.info("InitialDepositCanNotBeEmpty: Step 04 - Verify 'Initial Deposit must not be blank' message displayed");
		verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Initial deposit"), ValidateMessage.INITIAL_DEPOSIT_MUST_NOT_BE_BLANK);

	}

	@Test
	public void NC_06_InitialDepositCanNotHaveFirstBlankSpace(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("InitialDepositCanNotHaveFirstBlankSpace: Step 01 - Clear 'Initial deposit' textbox");
		newAccountPage.clearDynamicTextboxOrTextArea(driver, "inideposit");

		log.info("InitialDepositCanNotHaveFirstBlankSpace: Step 02 - Input to 'Initial deposit' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", CommonTestData.BLANK_SPACE);

		log.info("InitialDepositCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Initial deposit"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void NC_07_InitialDepositCharacterAreNotAllowed(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String characterValue : CommonTestData.CHARACTER_VALUE) {

			log.info("InitialDepositCharacterAreNotAllowed: Step 01 - Clear 'Initial deposit' textbox");
			newAccountPage.clearDynamicTextboxOrTextArea(driver, "inideposit");

			log.info("InitialDepositCharacterAreNotAllowed: Step 02 - Input to 'Initial deposit' textbox");
			newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", characterValue);

			log.info("InitialDepositCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Initial deposit"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}

	}

	@Test
	public void NC_08_InitialDepositCanNotHaveSpecialCharacters(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String specialValue : CommonTestData.SPECIAL_VALUE) {

			log.info("InitialDepositCanNotHaveSpecialCharacters: Step 01 - Clear 'Initial deposit' textbox");
			newAccountPage.clearDynamicTextboxOrTextArea(driver, "inideposit");

			log.info("InitialDepositCanNotHaveSpecialCharacters: Step 02 - Input to 'Initial deposit' textbox");
			newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", specialValue);

			log.info("InitialDepositCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(newAccountPage.getTextDynamicValidateMessage(driver, "Initial deposit"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
