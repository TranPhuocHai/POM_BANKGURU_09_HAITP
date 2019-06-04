package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.customer.Common_02_CreateNewCustomer;
import com.bankguru.user.Common_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.EditAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;

public class EditAccount extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewAccountPageObject newAccountPage;
	EditAccountPageObject editAccountPage;
	public static String ACCOUNT_ID;
	String blankSpace = " ";
	int currentAmount = 50000;
	String[] characterAccountNos = new String[] { "haitp", "12 1234" };
	String[] specialAccountNos = new String[] { "097@!13546", "!#123654", "0987654#@!" };

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

		log.info("Precondition: Step 07 - Click To 'New Account' link");
		homePage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);

		log.info("Precondition: Step 08 - Click To 'New Account' link");
		newAccountPage.inputValueToCustomerIDTextbox(Common_02_CreateNewCustomer.CUSTOMER_ID);

		log.info("Precondition: Step 09 - select 'Current' in 'Account type' dropdown");
		newAccountPage.selectCurrentInAccountType();

		log.info("Precondition: Step 10 - Input to Initial deposit textbox");
		newAccountPage.inputValueToInitialDepositTextbox(String.valueOf(currentAmount));

		log.info("Precondition: Step 11 - Click to Submit button");
		newAccountPage.clickToSubmitButton();

		log.info("Precondition: Step 12 - Veirfy 'Account generated successfully' message displayed");
		verifyTrue(newAccountPage.isAccountGeneratedSuccessfullyMessageDisplayed());

		log.info("Precondition: Step 13 - Veirfy current amount is correct");
		verifyEquals(newAccountPage.getTextDynamicInfo(driver, "Current Amount"), String.valueOf(currentAmount));

		log.info("Precondition: Step 14 - Get Account ID infor");
		ACCOUNT_ID = newAccountPage.getTextDynamicInfo(driver, "Account ID");

		log.info("Precondition: Step 15 - Click to 'Edit Account' link");
		newAccountPage.openMultiplePage(driver, "Edit Account");
		editAccountPage = PageFactoryManager.getEditAccountPage(driver);
	}

	@Test
	public void EA_01_AccountNumberCanNotBeEmpty() {

		log.info("AccountNumberCanNotBeEmpty: Step 01 - Clear 'Account Number' textbox");
		editAccountPage.clearAccountNumberTextbox();

		log.info("AccountNumberCanNotBeEmpty: Step 02 - Click to 'Account Number' textbox");
		editAccountPage.clickToAccountNumberTexbox();

		log.info("AccountNumberCanNotBeEmpty: Step 03 - Press TAB key");
		editAccountPage.pressTABKeyToAccountNumberTextbox();

		log.info("AccountNumberCanNotBeEmpty: Step 04 - Verify 'Account Number must not be blank' message displayed");
		verifyTrue(editAccountPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Account Number"));
	}

	@Test
	public void EA_02_AccountNumberCharacterAreNotAllowed() {
		for (String characterAccountNo : characterAccountNos) {

			log.info("AccountNumberCharacterAreNotAllowed: Step 01 - Clear 'Account Number' textbox");
			editAccountPage.clearAccountNumberTextbox();

			log.info("AccountNumberCharacterAreNotAllowed: Step 02 - Input to 'Account Number' textbox");
			editAccountPage.inputValueToAccountNumberTextbox(characterAccountNo);

			log.info("AccountNumberCanNotBeEmpty: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(editAccountPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Account No"));
		}
	}

	@Test
	public void EA_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialAccountNo : specialAccountNos) {

			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 01 - Clear 'Account Number' textbox");
			editAccountPage.clearAccountNumberTextbox();

			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 02 - Input to 'Account Number' textbox");
			editAccountPage.inputValueToAccountNumberTextbox(specialAccountNo);

			log.info(
					"AccountNumberCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(editAccountPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Account No"));
		}
	}

	@Test
	public void EA_04_AccountNumberFirstCharacterMustNotBeBlank() {

		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 01 - Clear 'Account Number' textbox");
		editAccountPage.clearAccountNumberTextbox();

		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 02 - Input to 'Account Number' textbox");
		editAccountPage.inputValueToAccountNumberTextbox(blankSpace);

		log.info(
				"AccountNumberFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyTrue(editAccountPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Account No"));

	}

	@Test
	public void EA_05_ValidAccountNumber() {

		log.info("ValidAccountNumber: Step 01 - Clear 'Account Number' textbox");
		editAccountPage.clearAccountNumberTextbox();

		log.info("ValidAccountNumber: Step 02 - Input to 'Account Number' textbox");
		editAccountPage.inputValueToAccountNumberTextbox(ACCOUNT_ID);

		log.info("ValidAccountNumber: Step 03 - Click to submit button");
		editAccountPage.clickAccountNumberSubmitButton();

		log.info("ValidAccountNumber: Step 04 - Verify Edit Customer form displayed");
		verifyTrue(editAccountPage.isEditCustomerFormDispayed());
	}

	@Test
	public void EA_06_EditAccountSuccess() {

		log.info("EditAccountSuccess: Step 01 - Select 'Saving' in 'Account type' dropdown");
		editAccountPage.selectSavingsInAccountTypeDropdown();

		log.info("EditAccountSuccess: Step 02 - Click to Submit button");
		editAccountPage.clickEditAccountSubmitButton();

		log.info("EditAccountSuccess: Step 03 - Verify 'Account details updated successfully' message displayed");
		verifyTrue(editAccountPage.isAccountDetailsUpdatedSuccessfullyDispayed());

		log.info("EditAccountSuccess: Step 04 - Verify Account type is 'Savings'");
		verifyEquals(editAccountPage.getTextDynamicInfo(driver, "Account Type"), "Savings");

	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
