package com.bankguru.customisedstatement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.customer.Common_02_CreateNewCustomer;
import com.bankguru.user.Common_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.CustomisedStatementPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.RegisterPageObject;

public class CustomisedStatement extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	NewAccountPageObject newAccountPage;
	CustomisedStatementPageObject customisedStatementPage;
	public static String ACCOUNT_ID;
	String blankSpace = " ";
	String numberOfTransaction = "1";

	String currentAmount = "50000";
	String[] characterValues = new String[] { "haitp", "12 1234" };
	String[] specialValues = new String[] { "097@!13546", "!#123654", "0987654#@!" };
	

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
		
		log.info("Precondition: Step 15 - Click to 'Customised Statement' link");
		newAccountPage.openMultiplePage(driver, "Customised Statement");
		customisedStatementPage = PageFactoryManager.getCustomisedStatementPage(driver);
		
		log.info("Precondition: Step 16 - Verify 'Customized Statement Form' displayed");
		verifyTrue(customisedStatementPage.isCustomisedStatementFormDisplayed());
	}
	
	@Test
	public void CS_01_AccountNumberCanNotBeEmpty() {
		
		log.info("AccountNumberCanNotBeEmpty: Step 01 - Clear 'Account Number' textbox");
		customisedStatementPage.clearAccountNumberTextbox();
		
		log.info("AccountNumberCanNotBeEmpty: Step 02 - Click to 'Account Number' textbox");
		customisedStatementPage.clickToAccountNumberTexbox();
		
		log.info("AccountNumberCanNotBeEmpty: Step 03 - Press TAB key");
		customisedStatementPage.pressTABKeyToAccountNumberTextbox();
		
		log.info("AccountNumberCanNotBeEmpty: Step 04 - Verify 'Account Number must not be blank' message displayed");
		verifyTrue(customisedStatementPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Account Number"));
	}

	@Test
	public void CS_02_AccountNumberCharacterAreNotAllowed() {
		for (String characterValue : characterValues) {
			
			log.info("AccountNumberCharacterAreNotAllowed: Step 01 - Clear 'Account Number' textbox");
			customisedStatementPage.clearAccountNumberTextbox();
			
			log.info("AccountNumberCharacterAreNotAllowed: Step 02 - Input to 'Account Number' textbox");
			customisedStatementPage.inputValueToAccountNumberTextbox(characterValue);
			
			log.info("AccountNumberCanNotBeEmpty: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Account No"));
		}
	}

	@Test
	public void CS_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 01 - Clear 'Account Number' textbox");
			customisedStatementPage.clearAccountNumberTextbox();
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 02 - Input to 'Account Number' textbox");
			customisedStatementPage.inputValueToAccountNumberTextbox(specialValue);
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(customisedStatementPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Account No"));
		}
	}

	@Test
	public void CS_04_AccountNumberFirstCharacterMustNotBeBlank() {
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 01 - Clear 'Account Number' textbox");
		customisedStatementPage.clearAccountNumberTextbox();
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 02 - Input to 'Account Number' textbox");
		customisedStatementPage.inputValueToAccountNumberTextbox(blankSpace);
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Account No"));

	}
	
	@Test
	public void CS_05_MinimumTransactionValueCharacterAreNotAllowed() {
		for (String CharacterMinimumTransactionValue : characterValues) {
			
			log.info("MinimumTransactionValueCharacterAreNotAllowed: Step 01 - Clear 'Minimum Transaction Value' textbox");
			customisedStatementPage.clearMinimumTransactionValueTextbox();
			
			log.info("MinimumTransactionValueCharacterAreNotAllowed: Step 02 - Input to 'Minimum Transaction Value' textbox");
			customisedStatementPage.inputValueToMinimumTransactionValueTextbox(CharacterMinimumTransactionValue);
			
			log.info("MinimumTransactionValueCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Minimum Transaction Value"));
		}
	}
	
	@Test
	public void CS_06_MinimumTransactionValueCanNotHaveSpecialCharacters() {
		for (String specialMinimumTransactionValue : specialValues) {
			
			log.info("MinimumTransactionValueCanNotHaveSpecialCharacters: Step 01 - Clear 'Minimum Transaction Value' textbox");
			customisedStatementPage.clearMinimumTransactionValueTextbox();
			
			log.info("MinimumTransactionValueCanNotHaveSpecialCharacters: Step 02 - Input to 'Minimum Transaction Value' textbox");
			customisedStatementPage.inputValueToMinimumTransactionValueTextbox(specialMinimumTransactionValue);
			
			log.info("MinimumTransactionValueCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(customisedStatementPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Minimum Transaction Value"));
		}
	}
	
	@Test
	public void CS_07_MinimumTransactionValueFirstCharacterMustNotBeBlank() {
		
		log.info("MinimumTransactionValueFirstCharacterMustNotBeBlank: Step 01 - Clear 'Minimum Transaction Value' textbox");
		customisedStatementPage.clearMinimumTransactionValueTextbox();
		
		log.info("MinimumTransactionValueFirstCharacterMustNotBeBlank: Step 02 - Input to 'Minimum Transaction Value' textbox");
		customisedStatementPage.inputValueToMinimumTransactionValueTextbox(blankSpace);
		
		log.info("MinimumTransactionValueFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Minimum Transaction Value"));
		
	}
	
	@Test
	public void CS_08_NumberOfTransactionCharacterAreNotAllowed() {
		for (String CharacterNumberOfTransaction : characterValues) {
			
			log.info("NumberOfTransactionCharacterAreNotAllowed: Step 01 - Clear 'Number of Transaction' textbox");
			customisedStatementPage.clearNumberOfTransactionTextbox();
			
			log.info("NumberOfTransactionCharacterAreNotAllowed: Step 02 - Input to 'Number of Transaction' textbox");
			customisedStatementPage.inputValueToNumberOfTransactionTextbox(CharacterNumberOfTransaction);
			
			log.info("NumberOfTransactionCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Number of Transaction"));
		}
	}

	@Test
	public void CS_09_NumberOfTransactionCanNotHaveSpecialCharacters() {
		for (String specialNumberOfTransaction : specialValues) {
			
			log.info("NumberOfTransactionCanNotHaveSpecialCharacters: Step 01 - Clear 'Number of Transaction' textbox");
			customisedStatementPage.clearNumberOfTransactionTextbox();
			
			log.info("NumberOfTransactionCanNotHaveSpecialCharacters: Step 02 - Input to 'Number of Transaction' textbox");
			customisedStatementPage.inputValueToNumberOfTransactionTextbox(specialNumberOfTransaction);
			
			log.info("NumberOfTransactionCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(customisedStatementPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Number of Transaction"));
		}
	}

	@Test
	public void CS_10_NumberOfTransactionFirstCharacterMustNotBeBlank() {
		
		log.info("NumberOfTransactionFirstCharacterMustNotBeBlank: Step 01 - Clear 'Number of Transaction' textbox");
		customisedStatementPage.clearNumberOfTransactionTextbox();
		
		log.info("NumberOfTransactionFirstCharacterMustNotBeBlank: Step 02 - Input to 'Number of Transaction' textbox");
		customisedStatementPage.inputValueToNumberOfTransactionTextbox(blankSpace);
		
		log.info("NumberOfTransactionFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyTrue(customisedStatementPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Number of Transaction"));

	}
	
	@Test
	public void CS_11_InputValidInforAndVerifyCustomisedStatementDisplayed() {
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 01 - Clear 'Account Number' textbox");
		customisedStatementPage.clearAccountNumberTextbox();
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 02 - Input to 'Account Number' textbox");
		customisedStatementPage.inputValueToAccountNumberTextbox(ACCOUNT_ID);
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 03 - Clear 'Minimum Transaction Value' textbox");
		customisedStatementPage.clearMinimumTransactionValueTextbox();
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 04 - Input to 'Minimum Transaction Value' textbox");
		customisedStatementPage.inputValueToMinimumTransactionValueTextbox(currentAmount);
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 05 - Clear 'Number of Transaction' textbox");
		customisedStatementPage.clearNumberOfTransactionTextbox();
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 06 - Input to 'Number of Transaction' textbox");
		customisedStatementPage.inputValueToNumberOfTransactionTextbox(numberOfTransaction);
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 07 - Click to Submit button");
		customisedStatementPage.clickSubmitButton();		
		
		log.info("NumberOfTransactionFirstCharacterMustNotBeBlank: Step 03 - Verify Transaction Details message displayed");
		verifyTrue(customisedStatementPage.isTransactionDetailsFormDisplayed(ACCOUNT_ID));
	}

	

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
