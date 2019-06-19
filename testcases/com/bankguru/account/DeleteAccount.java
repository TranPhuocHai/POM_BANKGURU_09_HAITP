package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.customer.TestData;
import com.bankguru.payment.PaymentTestData;
import com.bankguru.user.Common_01_RegisterToSystem;
import com.bankguru.validate.ValidateMessage;

import bankguruPageFactoryManager.PageFactoryManager;
import bankguruPageObjects.DeleteAccountPageObject;
import bankguruPageObjects.HomePageObject;
import bankguruPageObjects.LoginPageObject;
import commons.AbstractTest;

public class DeleteAccount extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private DeleteAccountPageObject deleteAccountPage;

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
		
		log.info("Precondition: Step 07 - Click to 'Delete Account' link");
		homePage.openMultiplePage(driver, "Delete Account");
		deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);
		verifyTrue(deleteAccountPage.isDynamicPageTitleDisplayed(driver, PaymentTestData.DELETE_ACCOUNT_TITLE));
	}

	@Test
	public void DeleteAccount_01_AccountNumberCanNotBeEmpty() {
		
		log.info("DeleteAccount_01: Step 01 - Clear 'Account Number' textbox");
		deleteAccountPage.clearDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("DeleteAccount_01: Step 02 - Click to 'Account Number' textbox");
		deleteAccountPage.clickToDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("DeleteAccount_01: Step 03 - Press TAB key");
		deleteAccountPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("DeleteAccount_01: Step 04 - Verify 'Account Number must not be blank' message displayed");
		verifyEquals(deleteAccountPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.ACCOUNT_NUMBER_MUST_NOT_BE_BLANK);
	}

	@Test
	public void DeleteAccount_02_AccountNumberCharacterAreNotAllowed() {
		for (String characterAccountNo : TestData.CHARACTER_VALUE) {
			
			log.info("DeleteAccount_02: Step 01 - Clear 'Account Number' textbox");
			deleteAccountPage.clearDynamicTextboxOrTextArea(driver, "accountno");
			
			log.info("DeleteAccount_02: Step 02 - Input to 'Account Number' textbox");
			deleteAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", characterAccountNo);
			
			log.info("DeleteAccount_02: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(deleteAccountPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void DeleteAccount_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialAccountNo : TestData.SPECIAL_VALUE) {
			
			log.info("DeleteAccount_03: Step 01 - Clear 'Account Number' textbox");
			deleteAccountPage.clearDynamicTextboxOrTextArea(driver, "accountno");
			
			log.info("DeleteAccount_03: Step 02 - Input to 'Account Number' textbox");
			deleteAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", specialAccountNo);
			
			log.info("DeleteAccount_03: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(deleteAccountPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void DeleteAccount_04_AccountNumberFirstCharacterMustNotBeBlank() {
		
		log.info("DeleteAccount_04: Step 01 - Clear 'Account Number' textbox");
		deleteAccountPage.clearDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("DeleteAccount_04: Step 02 - Input to 'Account Number' textbox");
		deleteAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", TestData.BLANK_SPACE);
		
		log.info("DeleteAccount_04: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyEquals(deleteAccountPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);

	}
	

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
