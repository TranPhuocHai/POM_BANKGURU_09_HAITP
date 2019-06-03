package com.bankguru.user;

import java.util.Random;

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
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class ChangePassword extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private ChangePasswordPageObject changePasswordPage;

	private String loginPageUrl, userIdInfo, passwordInfo;

	private String email = "muntibonemdh" + randomNumber() + "@gmail.com";
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

	private String withoutNumberNewPassword = "bab#nnam@sau";
	private String withoutSpecialCharacterNewPassword = "bab1nnam4sau";
	private String[] passwordStringNewPasswords = new String[] {"b@b#n1Password","b@b#n1password"};
	
	private String validNewPassword = "bs@#12jks";
	private String confirmedPassword = "ba@#12jks";

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
		
		log.info("Precondition: Step 06 - Input to Email ID textbox");
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
		
		log.info("Precondition: Step 11 - Input to userID and Password textboxes");
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
		
		log.info("Precondition: Step 18 - Input to 'Date Of Birth' textbox");
		newCustomerPage.inputValueToDateOfBirthTextbox(validDateOfBirth);
		
		log.info("Precondition: Step 19 - Input to 'Adress' text area");
		newCustomerPage.inputValueToAdressTextArea(validAdress);
		
		log.info("Precondition: Step 20 - Input to 'City' textbox");
		newCustomerPage.inputValueToCityTextbox(validCity);
		
		log.info("Precondition: Step 21 - Input to 'State' textbox");
		newCustomerPage.inputValueToStateTextbox(validState);
		
		log.info("Precondition: Step 22 - Input to 'Pin' textbox");
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

		log.info("Precondition: Step 29 - Click To 'Change Password' link");
		newCustomerPage.openMultiplePage(driver, "Change Password");
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

	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
