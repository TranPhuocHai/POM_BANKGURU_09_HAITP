package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.ChangePasswordPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class ChangePassword extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private ChangePasswordPageObject changePasswordPage;

	private String withoutNumberNewPassword = "bab#nnam@sau";
	private String withoutSpecialCharacterNewPassword = "bab1nnam4sau";
	private String[] passwordStringNewPasswords = new String[] {"b@b#n1Password","b@b#n1password"};
	
	private String validNewPassword = "bs@#12jks";
	private String confirmedPassword = "ba@#12jks";

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
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "Old Password"), "Old Password must not be blank");

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
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "New Password"), "New Password must not be blank");

	}

	@Test
	public void CP_03_NewPasswordMustHaveAtLeastOneNumericValue() {
		
		log.info("NewPasswordMustHaveAtLeastOneNumericValue: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("NewPasswordMustHaveAtLeastOneNumericValue: Step 02 - Input to 'New Password' textbox");
		changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "newpassword", withoutNumberNewPassword);
		
		log.info("NewPasswordMustHaveAtLeastOneNumericValue: Step 03 - Verify 'Enter at-least one numeric value' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "New Password"), "Enter at-least one numeric value");
		
	}
	
	@Test
	public void CP_04_NewPasswordMustHaveAtLeastOneSpecialCharacter() {
		
		log.info("NewPasswordMustHaveAtLeastOneSpecialCharacter: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("NewPasswordMustHaveAtLeastOneSpecialCharacter: Step 02 - Input to 'New Password' textbox");
		changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "newpassword", withoutSpecialCharacterNewPassword);
		
		log.info("NewPasswordMustHaveAtLeastOneSpecialCharacter: Step 03 - Verify 'Enter at-least one special character' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "New Password"), "Enter at-least one special character");
		
	}
	
	@Test
	public void CP_05_NewPasswordMustNotIncludeStringPassword() {
		for (String passwordStringNewPassword: passwordStringNewPasswords) {
			
			log.info("NewPasswordMustNotIncludeStringPassword: Step 01 - Clear 'New Password' textbox");
			changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
			
			log.info("NewPasswordMustNotIncludeStringPassword: Step 02 - Input to 'New Password' textbox");
			changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "newpassword", passwordStringNewPassword);
			
			log.info("NewPasswordMustNotIncludeStringPassword: Step 03 - Verify 'Choose a difficult Password' message displayed");
			verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "New Password"), "Choose a difficult Password");
		}

	}
	
	@Test
	public void CP_06_ConfirmPasswordAndNewPasswordMustBeMatched() {
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 02 - Input 'New Password' textbox");
		changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "newpassword", validNewPassword);
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 03 - Clear 'Confirm Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "confirmpassword");
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 04 - Input 'Confirm Password' textbox");
		changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "confirmpassword", confirmedPassword);
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 05 - Make sure 'New password' and 'Confirm password' are different");
		verifyFalse(validNewPassword.equals(confirmedPassword));
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 06 - Verify 'Passwords do not Match' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "Confirm Password"), "Passwords do not Match");
		
	}

	
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
