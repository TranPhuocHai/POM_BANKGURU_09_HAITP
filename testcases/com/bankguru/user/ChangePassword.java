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

	private String email = "tpkcdnam" + randomNumber() + "@gmail.com";
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

		loginPage = PageFactoryManager.getLoginPage(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inPutToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		userIdInfo = registerPage.getTextDynamicInfo(driver, "User ID :");
		passwordInfo = registerPage.getTextDynamicInfo(driver, "Password :");
		loginPage = registerPage.openLoginPage(loginPageUrl);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inPutToUserIDTextbox(userIdInfo);
		loginPage.inPutToPasswordTextbox(passwordInfo);
		homePage = loginPage.clickToLoginButton();
		homePage.isWelcomeMessageDisplayed();
		homePage.isUserIDDisplayed(userIdInfo);

		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

		newCustomerPage.inputValueToCustomerNameTextbox(validName);
		newCustomerPage.selectMaleGenderRadioButton();
		newCustomerPage.removeDateOfBirthAttribute();
		newCustomerPage.inputValueToDateOfBirthTextbox(validDateOfBirth);
		newCustomerPage.inputValueToAdressTextArea(validAdress);
		newCustomerPage.inputValueToCityTextbox(validCity);
		newCustomerPage.inputValueToStateTextbox(validState);
		newCustomerPage.inputValueToPinTextbox(validPin);
		newCustomerPage.inputValueToMobileNumberTextbox(validPhoneNumber);
		newCustomerPage.inputValueToEmailTextbox(validEmailID);
		newCustomerPage.inputValueToPasswordTextbox(validPassword);
		newCustomerPage.clickToSubmitButton();
		newCustomerPage.isCustomerRegisteredSuccessfullyDisplayed();
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Customer Name"), validName);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Gender"), expectedGender);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Birthdate"), validDateOfBirth);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Address"), validAdress);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "City"), validCity);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "State"), validState);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Pin"), validPin);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Mobile No."), validPhoneNumber);
		Assert.assertEquals(newCustomerPage.getTextDynamicInfo(driver, "Email"), validEmailID);

		newCustomerPage.openMultiplePage(driver, "Change Password");
		changePasswordPage = PageFactoryManager.getChangePasswordPage(driver);

	}

	@Test
	public void CP_01_OldPasswordMustNotBeBank() {
		changePasswordPage.clearOldPasswordTextbox();
		changePasswordPage.clickToOldPasswordTextbox();
		changePasswordPage.pressTabKeyToOldPasswordTextbox();
		Assert.assertTrue(changePasswordPage.isOldPasswordMustNotBeBlankMessageDisplayed());

	}

	@Test
	public void CP_02_NewPasswordMustNotBeBank() {
		changePasswordPage.clearNewPasswordTextbox();
		changePasswordPage.clickToNewPasswordTextbox();
		changePasswordPage.pressTabKeyToNewPasswordTextbox();
		Assert.assertTrue(changePasswordPage.isNewPasswordMustNotBeBlankMessageDisplayed());

	}

	@Test
	public void CP_03_NewPasswordMustHaveAtLeastOneNumericValue() {
		changePasswordPage.clearNewPasswordTextbox();
		changePasswordPage.inputValueToNewPasswordTextbox(withoutNumberNewPassword);
		Assert.assertTrue(changePasswordPage.isEnterAtLeastOneNumericValueMessageDisplayed());
		
	}
	
	@Test
	public void CP_04_NewPasswordMustHaveAtLeastOneSpecialCharacter() {
		changePasswordPage.clearNewPasswordTextbox();
		changePasswordPage.inputValueToNewPasswordTextbox(withoutSpecialCharacterNewPassword);
		Assert.assertTrue(changePasswordPage.isEnterAtLeastOneSpecialCharacterMessageDisplayed());
		
	}
	
	@Test
	public void CP_05_NewPasswordMustNotIncludeStringPassword() {
		for (String passwordStringNewPassword: passwordStringNewPasswords) {
			changePasswordPage.clearNewPasswordTextbox();
			changePasswordPage.inputValueToNewPasswordTextbox(passwordStringNewPassword);
			Assert.assertTrue(changePasswordPage.isChooseDifficultPasswordMessageDisplayed());
		}

	}
	
	@Test
	public void CP_06_ConfirmPasswordAndNewPasswordMustBeMatched() {
		changePasswordPage.clearNewPasswordTextbox();
		changePasswordPage.inputValueToNewPasswordTextbox(validNewPassword);
		changePasswordPage.clearConfirmPasswordTextbox();
		changePasswordPage.inputValueToConfirmPasswordTextbox(confirmedPassword);
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
