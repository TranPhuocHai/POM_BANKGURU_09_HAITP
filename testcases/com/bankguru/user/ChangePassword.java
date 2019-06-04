package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
		loginPage.inPutToUserIDTextbox(Common_01_RegisterToSystem.USER_ID_INFOR);
		loginPage.inPutToPasswordTextbox(Common_01_RegisterToSystem.PASSWORD_INFOR);
		
		log.info("Precondition: Step 04 - Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Precondition: Step 05 - Verify Welcome message of Home page displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed());
		
		log.info("Precondition: Step 06 - Verify User ID infor displayed");
		verifyTrue(homePage.isUserIDDisplayed(Common_01_RegisterToSystem.USER_ID_INFOR));

		log.info("Precondition: Step 07 - Click To 'Change Password' link");
		homePage.openMultiplePage(driver, "Change Password");
		changePasswordPage = PageFactoryManager.getChangePasswordPage(driver);

	}

	@Test
	public void CP_01_OldPasswordMustNotBeBank() {
		
		log.info("OldPasswordMustNotBeBank: Step 01 - Clear 'Old Password' textbox");
		changePasswordPage.clearOldPasswordTextbox();
		
		log.info("OldPasswordMustNotBeBank: Step 02 - Click to 'Old Password' textbox");
		changePasswordPage.clickToOldPasswordTextbox();
		
		log.info("OldPasswordMustNotBeBank: Step 03 - Press TAB key");
		changePasswordPage.pressTabKeyToOldPasswordTextbox();
		
		log.info("OldPasswordMustNotBeBank: Step 04 - Verify 'Old Password must not be blank' message displayed");
		Assert.assertTrue(changePasswordPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Old Password"));

	}

	@Test
	public void CP_02_NewPasswordMustNotBeBank() {
		
		log.info("NewPasswordMustNotBeBank: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearNewPasswordTextbox();
		
		log.info("NewPasswordMustNotBeBank: Step 02 - Click to 'New Password' textbox");
		changePasswordPage.clickToNewPasswordTextbox();
		
		log.info("NewPasswordMustNotBeBank: Step 03 - Press TAB key");
		changePasswordPage.pressTabKeyToNewPasswordTextbox();
		
		log.info("NewPasswordMustNotBeBank: Step 04 - Verify 'New Password must not be blank' message displayed");
		Assert.assertTrue(changePasswordPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "New Password"));

	}

	@Test
	public void CP_03_NewPasswordMustHaveAtLeastOneNumericValue() {
		
		log.info("NewPasswordMustHaveAtLeastOneNumericValue: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearNewPasswordTextbox();
		
		log.info("NewPasswordMustHaveAtLeastOneNumericValue: Step 02 - Input to 'New Password' textbox");
		changePasswordPage.inputValueToNewPasswordTextbox(withoutNumberNewPassword);
		
		log.info("NewPasswordMustHaveAtLeastOneNumericValue: Step 03 - Verify 'Enter at-least one numeric value' message displayed");
		Assert.assertTrue(changePasswordPage.isEnterAtLeastOneNumericValueMessageDisplayed());
		
	}
	
	@Test
	public void CP_04_NewPasswordMustHaveAtLeastOneSpecialCharacter() {
		
		log.info("NewPasswordMustHaveAtLeastOneSpecialCharacter: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearNewPasswordTextbox();
		
		log.info("NewPasswordMustHaveAtLeastOneSpecialCharacter: Step 02 - Input to 'New Password' textbox");
		changePasswordPage.inputValueToNewPasswordTextbox(withoutSpecialCharacterNewPassword);
		
		log.info("NewPasswordMustHaveAtLeastOneSpecialCharacter: Step 03 - Verify 'Enter at-least one special character' message displayed");
		Assert.assertTrue(changePasswordPage.isEnterAtLeastOneSpecialCharacterMessageDisplayed());
		
	}
	
	@Test
	public void CP_05_NewPasswordMustNotIncludeStringPassword() {
		for (String passwordStringNewPassword: passwordStringNewPasswords) {
			
			log.info("NewPasswordMustNotIncludeStringPassword: Step 01 - Clear 'New Password' textbox");
			changePasswordPage.clearNewPasswordTextbox();
			
			log.info("NewPasswordMustNotIncludeStringPassword: Step 02 - Input to 'New Password' textbox");
			changePasswordPage.inputValueToNewPasswordTextbox(passwordStringNewPassword);
			
			log.info("NewPasswordMustNotIncludeStringPassword: Step 03 - Verify 'Choose a difficult Password' message displayed");
			Assert.assertTrue(changePasswordPage.isChooseDifficultPasswordMessageDisplayed());
		}

	}
	
	@Test
	public void CP_06_ConfirmPasswordAndNewPasswordMustBeMatched() {
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearNewPasswordTextbox();
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 02 - Input 'New Password' textbox");
		changePasswordPage.inputValueToNewPasswordTextbox(validNewPassword);
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 03 - Clear 'Confirm Password' textbox");
		changePasswordPage.clearConfirmPasswordTextbox();
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 04 - Input 'Confirm Password' textbox");
		changePasswordPage.inputValueToConfirmPasswordTextbox(confirmedPassword);
		
		log.info("ConfirmPasswordAndNewPasswordMustBeMatched: Step 05 - Verify 'Passwords do not Match' message displayed");
		Assert.assertTrue(changePasswordPage.isPasswordsDoNotMatchedMessageDisplayed());
	}

	
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
