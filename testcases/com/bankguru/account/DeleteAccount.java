package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.user.Common_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.DeleteAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class DeleteAccount extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	NewCustomerPageObject newCustomerPage;
	NewAccountPageObject newAccountPage;
	DeleteAccountPageObject deleteAccountPage;
	
	String blankSpace = " ";
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
		
		log.info("Precondition: Step 07 - Click to 'Delete Account' link");
		homePage.openMultiplePage(driver, "Delete Account");
		deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);
		verifyTrue(deleteAccountPage.isDeleteAccountFormDisplayed());
	}

	@Test
	public void EA_01_AccountNumberCanNotBeEmpty() {
		
		log.info("AccountNumberCanNotBeEmpty: Step 01 - Clear 'Account Number' textbox");
		deleteAccountPage.clearAccountNumberTextbox();
		
		log.info("AccountNumberCanNotBeEmpty: Step 02 - Click to 'Account Number' textbox");
		deleteAccountPage.clickToAccountNumberTexbox();
		
		log.info("AccountNumberCanNotBeEmpty: Step 03 - Press TAB key");
		deleteAccountPage.pressTABKeyToAccountNumberTextbox();
		
		log.info("AccountNumberCanNotBeEmpty: Step 04 - Verify 'Account Number must not be blank' message displayed");
		verifyTrue(deleteAccountPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Account Number"));
	}

	@Test
	public void EA_02_AccountNumberCharacterAreNotAllowed() {
		for (String characterAccountNo : characterAccountNos) {
			
			log.info("AccountNumberCharacterAreNotAllowed: Step 01 - Clear 'Account Number' textbox");
			deleteAccountPage.clearAccountNumberTextbox();
			
			log.info("AccountNumberCharacterAreNotAllowed: Step 02 - Input to 'Account Number' textbox");
			deleteAccountPage.inputValueToAccountNumberTextbox(characterAccountNo);
			
			log.info("AccountNumberCanNotBeEmpty: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(deleteAccountPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Account No"));
		}
	}

	@Test
	public void EA_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialAccountNo : specialAccountNos) {
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 01 - Clear 'Account Number' textbox");
			deleteAccountPage.clearAccountNumberTextbox();
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 02 - Input to 'Account Number' textbox");
			deleteAccountPage.inputValueToAccountNumberTextbox(specialAccountNo);
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(deleteAccountPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Account No"));
		}
	}

	@Test
	public void EA_04_AccountNumberFirstCharacterMustNotBeBlank() {
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 01 - Clear 'Account Number' textbox");
		deleteAccountPage.clearAccountNumberTextbox();
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 02 - Input to 'Account Number' textbox");
		deleteAccountPage.inputValueToAccountNumberTextbox(blankSpace);
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyTrue(deleteAccountPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Account No"));

	}
	

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
