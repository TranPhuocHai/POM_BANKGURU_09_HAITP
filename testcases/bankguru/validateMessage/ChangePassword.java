package bankguru.validateMessage;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageFactoryManager.PageFactoryManager;
import PageObjects.ChangePasswordPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import bankguru.commonFunction.Common_01_RegisterToSystem;
import bankguru.testdata.CommonTestData;
import bankguru.testdata.ValidateMessage;
import commons.AbstractTest;
import reportConfig.ExtentTestManager;

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
		verifyTrue(changePasswordPage.isDynamicPageTitleOrMessageDisplayed(driver, CommonTestData.CHANGE_PASSWORD_TITLE));

	}

	@Test
	public void ChangePassword_01_OldPasswordMustNotBeBank(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		log.info("ChangePassword_01: Step 01 - Clear 'Old Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "oldpassword");
		
		log.info("ChangePassword_01: Step 02 - Click to 'Old Password' textbox");
		changePasswordPage.clickToDynamicTextboxOrTextArea(driver, "oldpassword");
		
		log.info("ChangePassword_01: Step 03 - Press TAB key");
		changePasswordPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "oldpassword");
		
		log.info("ChangePassword_01: Step 04 - Verify 'Old Password must not be blank' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "Old Password"), ValidateMessage.OLD_PASSWORD_MUST_NOT_BE_BLANK);

	}

	@Test
	public void ChangePassword_02_NewPasswordMustNotBeBank(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		log.info("ChangePassword_02: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("ChangePassword_02: Step 02 - Click to 'New Password' textbox");
		changePasswordPage.clickToDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("ChangePassword_02: Step 03 - Press TAB key");
		changePasswordPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("ChangePassword_02: Step 04 - Verify 'New Password must not be blank' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "New Password"), ValidateMessage.NEW_PASSWORD_MUST_NOT_BE_BLANK);

	}

	@Test
	public void ChangePassword_03_NewPasswordMustHaveAtLeastOneNumericValue(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		log.info("ChangePassword_03: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("ChangePassword_03: Step 02 - Input to 'New Password' textbox");
		changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "newpassword", CommonTestData.WITHOUT_NUMBER_NEW_PASSWORD);
		
		log.info("ChangePassword_03: Step 03 - Verify 'Enter at-least one numeric value' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "New Password"), ValidateMessage.ENTER_AT_LEAST_ONE_NUMERIC_VALUE);
		
	}
	
	@Test
	public void ChangePassword_04_NewPasswordMustHaveAtLeastOneSpecialCharacter(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		log.info("ChangePassword_04: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("ChangePassword_04: Step 02 - Input to 'New Password' textbox");
		changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "newpassword", CommonTestData.WITHOUT_SPECIAL_CHARACTER_NEW_PASSWORD);
		
		log.info("ChangePassword_04: Step 03 - Verify 'Enter at-least one special character' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "New Password"), ValidateMessage.ENTER_AT_LEAST_ONE_SPECIAL_VALUE);
		
	}
	
	@Test
	public void ChangePassword_05_NewPasswordMustNotIncludeStringPassword(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String passwordStringNewPassword: CommonTestData.PASSWORD_STRING_NEW_PASSWORDS) {
			log.info("ChangePassword_05: Step 01 - Clear 'New Password' textbox");
			changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
			
			log.info("ChangePassword_05: Step 02 - Input to 'New Password' textbox");
			changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "newpassword", passwordStringNewPassword);
			
			log.info("ChangePassword_05: Step 03 - Verify 'Choose a difficult Password' message displayed");
			verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "New Password"), ValidateMessage.CHOOSE_A_DIFFICULT_PASSWORD);
		}

	}
	
	@Test
	public void ChangePassword_06_ConfirmPasswordAndNewPasswordMustBeMatched(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		log.info("ChangePassword_06: Step 01 - Clear 'New Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "newpassword");
		
		log.info("ChangePassword_06: Step 02 - Input 'New Password' textbox");
		changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "newpassword", CommonTestData.VALID_NEW_PASSWORD);
		
		log.info("ChangePassword_06: Step 03 - Clear 'Confirm Password' textbox");
		changePasswordPage.clearDynamicTextboxOrTextArea(driver, "confirmpassword");
		
		log.info("ChangePassword_06: Step 04 - Input 'Confirm Password' textbox");
		changePasswordPage.inputToDynamicTextboxOrTextArea(driver, "confirmpassword", CommonTestData.CONFIRMED_PASSWORD);
		
		log.info("ChangePassword_06: Step 05 - Make sure 'New password' and 'Confirm password' are different");
		verifyFalse(CommonTestData.VALID_NEW_PASSWORD.equals(CommonTestData.CONFIRMED_PASSWORD));
		
		log.info("ChangePassword_06: Step 06 - Verify 'Passwords do not Match' message displayed");
		verifyEquals(changePasswordPage.getTextDynamicValidateMessage(driver, "Confirm Password"), ValidateMessage.PASSWORDS_DO_NOT_MATCH);
		
	}

	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
