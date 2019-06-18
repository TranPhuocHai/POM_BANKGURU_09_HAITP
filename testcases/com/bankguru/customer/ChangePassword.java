package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.user.Common_01_RegisterToSystem;
import com.bankguru.validate.ValidateMessageTestData;

import bankguruPageFactoryManager.PageFactoryManager;
import bankguruPageObjects.ChangePasswordPageObject;
import bankguruPageObjects.HomePageObject;
import bankguruPageObjects.LoginPageObject;
import commons.AbstractTest;

public class ChangePassword extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private ChangePasswordPageObject changePasswordPage;


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

		log.info("Precondition: Step 07 - Click To 'Change Password' link");
		homePage.openMultiplePage(driver, "Change Password");
		changePasswordPage = PageFactoryManager.getChangePasswordPage(driver);
		
		log.info("Precondition: Step 08 - Verify 'Change Password' message displayed");
		verifyTrue(changePasswordPage.isDynamicPageTitleDisplayed(driver, "Change Password"));

	}

	@Test
	public void CP_01_OldPasswordMustNotBeBank() {
		
		log.info("OldPasswordMustNotBeBank: Step 01 - Clear 'Old Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "oldpassword");
		
		log.info("OldPasswordMustNotBeBank: Step 02 - Click to 'Old Password' textbox");
		changePasswordPage.clickToDynamicTextboxOrTextArea(driver, "oldpassword");
		
		log.info("OldPasswordMustNotBeBank: Step 03 - Press TAB key");
		changePasswordPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "oldpassword");
		
		log.info("OldPasswordMustNotBeBank: Step 04 - Verify 'Old Password must not be blank' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "Old Password"), ValidateMessageTestData.OLD_PASSWORD_MUST_NOT_BE_BLANK);

	}

	@Test
	public void CP_02_NewPasswordMustNotBeBank() {
		
		log.info("NewPasswordMustNotBeBank: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("NewPasswordMustNotBeBank: Step 02 - Click to 'New Password' textbox");
		changePasswordPage.clickToDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("NewPasswordMustNotBeBank: Step 03 - Press TAB key");
		changePasswordPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("NewPasswordMustNotBeBank: Step 04 - Verify 'New Password must not be blank' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "New Password"), ValidateMessageTestData.NEW_PASSWORD_MUST_NOT_BE_BLANK);

	}

	@Test
	public void CP_03_NewPasswordMustHaveAtLeastOneNumericValue() {
		
		log.info("NewPasswordMustHaveAtLeastOneNumericValue: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("NewPasswordMustHaveAtLeastOneNumericValue: Step 02 - Input to 'New Password' textbox");
		changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "newpassword", CustomerTestData.WITHOUT_NUMBER_NEW_PASSWORD);
		
		log.info("NewPasswordMustHaveAtLeastOneNumericValue: Step 03 - Verify 'Enter at-least one numeric value' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "New Password"), ValidateMessageTestData.ENTER_AT_LEAST_ONE_NUMERIC_VALUE);
		
	}
	
	@Test
	public void CP_04_NewPasswordMustHaveAtLeastOneSpecialCharacter() {
		
		log.info("NewPasswordMustHaveAtLeastOneSpecialCharacter: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("NewPasswordMustHaveAtLeastOneSpecialCharacter: Step 02 - Input to 'New Password' textbox");
		changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "newpassword", CustomerTestData.WITHOUT_SPECIAL_CHARACTER_NEW_PASSWORD);
		
		log.info("NewPasswordMustHaveAtLeastOneSpecialCharacter: Step 03 - Verify 'Enter at-least one special character' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "New Password"), ValidateMessageTestData.ENTER_AT_LEAST_ONE_SPECIAL_VALUE);
		
	}
	
	@Test
	public void CP_05_NewPasswordMustNotIncludeStringPassword() {
		for (String passwordStringNewPassword: CustomerTestData.PASSWORD_STRING_NEW_PASSWORDS) {
			
			log.info("NewPasswordMustNotIncludeStringPassword: Step 01 - Clear 'New Password' textbox");
			changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
			
			log.info("NewPasswordMustNotIncludeStringPassword: Step 02 - Input to 'New Password' textbox");
			changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "newpassword", passwordStringNewPassword);
			
			log.info("NewPasswordMustNotIncludeStringPassword: Step 03 - Verify 'Choose a difficult Password' message displayed");
			verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "New Password"), ValidateMessageTestData.CHOOSE_A_DIFFICULT_PASSWORD);
		}

	}
	
	@Test
	public void CP_06_ConfirmPasswordAndNewPasswordMustBeMatched() {
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 02 - Input 'New Password' textbox");
		changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "newpassword", CustomerTestData.VALID_NEW_PASSWORD);
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 03 - Clear 'Confirm Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "confirmpassword");
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 04 - Input 'Confirm Password' textbox");
		changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "confirmpassword", CustomerTestData.CONFIRMED_PASSWORD);
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 05 - Make sure 'New password' and 'Confirm password' are different");
		verifyFalse(CustomerTestData.VALID_NEW_PASSWORD.equals(CustomerTestData.CONFIRMED_PASSWORD));
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 06 - Verify 'Passwords do not Match' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "Confirm Password"), ValidateMessageTestData.PASSWORDS_DO_NOT_MATCH);
		
	}

	
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
