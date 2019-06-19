package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.payment.PaymentTestData;
import com.bankguru.common.TestData;
import com.bankguru.customer.Common_02_CreateNewCustomer;
import com.bankguru.user.Common_01_RegisterToSystem;
import com.bankguru.validate.ValidateMessage;

import bankguruPageFactoryManager.PageFactoryManager;
import bankguruPageObjects.EditAccountPageObject;
import bankguruPageObjects.HomePageObject;
import bankguruPageObjects.LoginPageObject;
import bankguruPageObjects.NewAccountPageObject;
import commons.AbstractTest;

public class EditAccount extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewAccountPageObject newAccountPage;
	private EditAccountPageObject editAccountPage;
	public static String ACCOUNT_ID;
	
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
		
		log.info("Precondition: Step 08 - Verify Title 'Add new account form' displayed");
		newAccountPage.isDynamicPageTitleDisplayed(driver, "Add new account form");

		log.info("Precondition: Step 09 - Input to 'Customer id' textbox ");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", Common_02_CreateNewCustomer.CUSTOMER_ID);

		log.info("Precondition: Step 10 - select 'Current' in 'Account type' dropdown");
		newAccountPage.selectItemInDynamicDropdown(driver, "selaccount", "Current");

		log.info("Precondition: Step 11 - Input to 'Initial deposit' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", TestData.AMOUNT);

		log.info("Precondition: Step 11 - Click to Submit button");
		newAccountPage.clickToDynamicButton(driver, "button2");

		log.info("Precondition: Step 12 - Veirfy 'Account generated successfully' message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, PaymentTestData.ACCOUNT_GENERATED_SUCCESSFULLY_MESSAGE));

		log.info("Precondition: Step 13 - Veirfy current amount is correct");
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Current Amount"), TestData.AMOUNT);

		log.info("Precondition: Step 14 - Get Account ID infor");
		ACCOUNT_ID = newAccountPage.getTextDynamicTableInfo(driver, "Account ID");

		log.info("Precondition: Step 15 - Click to 'Edit Account' link");
		newAccountPage.openMultiplePage(driver, "Edit Account");
		editAccountPage = PageFactoryManager.getEditAccountPage(driver);
		
		log.info("Precondition: Step 16 - Veify 'Edit Account Form' title displayed");
		verifyTrue(editAccountPage.isDynamicPageTitleDisplayed(driver, PaymentTestData.EDIT_ACCOUNT_TITLE));
	}

	@Test
	public void EditAccount_01_AccountNumberCanNotBeEmpty() {

		log.info("EditAccount_01: Step 01 - Clear 'Account Number' textbox");
		editAccountPage.clearDynamicTextboxOrTextArea(driver, "accountno");

		log.info("EditAccount_01: Step 02 - Click to 'Account Number' textbox");
		editAccountPage.clickToDynamicTextboxOrTextArea(driver, "accountno");

		log.info("EditAccount_01: Step 03 - Press TAB key");
		editAccountPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "accountno");

		log.info("EditAccount_01: Step 04 - Verify 'Account Number must not be blank' message displayed");
		verifyEquals(editAccountPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.ACCOUNT_NUMBER_MUST_NOT_BE_BLANK);
	}

	@Test
	public void EditAccount_02_AccountNumberCharacterAreNotAllowed() {
		for (String characterAccountNo : TestData.CHARACTER_VALUE) {

			log.info("EditAccount_02: Step 01 - Clear 'Account Number' textbox");
			editAccountPage.clearDynamicTextboxOrTextArea(driver, "accountno");

			log.info("EditAccount_02: Step 02 - Input to 'Account Number' textbox");
			editAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", characterAccountNo);
			

			log.info("EditAccount_02: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(editAccountPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EditAccount_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialAccountNo : TestData.SPECIAL_VALUE) {

			log.info("EditAccount_03: Step 01 - Clear 'Account Number' textbox");
			editAccountPage.clearDynamicTextboxOrTextArea(driver, "accountno");
			
			log.info("EditAccount_03: Step 02 - Input to 'Account Number' textbox");
			editAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", specialAccountNo);
			
			log.info("EditAccount_03: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(editAccountPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EditAccount_04_AccountNumberFirstCharacterMustNotBeBlank() {

		log.info("EditAccount_04: Step 01 - Clear 'Account Number' textbox");
		editAccountPage.clearDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("EditAccount_04: Step 02 - Input to 'Account Number' textbox");
		editAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", TestData.BLANK_SPACE);
		
		log.info("EditAccount_04: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyEquals(editAccountPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);

	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
