package com.bankguru.customisedstatement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.EditAccount;
import com.bankguru.user.Common_01_RegisterToSystem;

import bankguruPageFactoryManager.PageFactoryManager;
import bankguruPageObjects.CustomisedStatementPageObject;
import bankguruPageObjects.HomePageObject;
import bankguruPageObjects.LoginPageObject;
import commons.AbstractTest;

public class CustomisedStatement extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private CustomisedStatementPageObject customisedStatementPage;
	private String blankSpace = " ";
	private String numberOfTransaction = "1";

	private String currentAmount = "50000";
	private String[] characterValues = new String[] { "haitp", "12 1234" };
	private String[] specialValues = new String[] { "097@!13546", "!#123654", "0987654#@!" };
	

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

		log.info("Precondition: Step 07 - Click to 'Customised Statement' link");
		homePage.openMultiplePage(driver, "Customised Statement");
		customisedStatementPage = PageFactoryManager.getCustomisedStatementPage(driver);
		
		log.info("Precondition: Step 08 - Verify 'Customized Statement Form' displayed");
		verifyTrue(customisedStatementPage.isDynamicPageTitleDisplayed(driver, "Customized Statement Form"));
	}
	
	@Test
	public void CS_01_AccountNumberCanNotBeEmpty() {
		
		log.info("AccountNumberCanNotBeEmpty: Step 01 - Clear 'Account Number' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");

		log.info("AccountNumberCanNotBeEmpty: Step 02 - Click to 'Account Number' textbox");
		customisedStatementPage.clickToDynamicTextboxOrTextArea(driver, "accountno");

		log.info("AccountNumberCanNotBeEmpty: Step 03 - Click to 'Minimum Transaction Value' textbox");
		customisedStatementPage.clickToDynamicTextboxOrTextArea(driver, "amountlowerlimit");

		log.info("AccountNumberCanNotBeEmpty: Step 04 - Verify 'Account Number must not be blank' message displayed");
		verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Account No"), "Account Number must not be blank");
	}

	@Test
	public void CS_02_AccountNumberCharacterAreNotAllowed() {
		for (String characterValue : characterValues) {
			
			log.info("AccountNumberCharacterAreNotAllowed: Step 01 - Clear 'Account Number' textbox");
			customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");

			log.info("AccountNumberCharacterAreNotAllowed: Step 02 - Input to 'Account Number' textbox");
			customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", characterValue);
			

			log.info("AccountNumberCanNotBeEmpty: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Account No"), "Characters are not allowed");
		}
	}

	@Test
	public void CS_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 01 - Clear 'Account Number' textbox");
			customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 02 - Input to 'Account Number' textbox");
			customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", specialValue);
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Account No"), "Special characters are not allowed");
		}
	}

	@Test
	public void CS_04_AccountNumberFirstCharacterMustNotBeBlank() {
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 01 - Clear 'Account Number' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 02 - Input to 'Account Number' textbox");
		customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", blankSpace);
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Account No"), "Characters are not allowed");

	}
	
	@Test
	public void CS_05_MinimumTransactionValueCharacterAreNotAllowed() {
		for (String characterMinimumTransactionValue : characterValues) {
			
			log.info("MinimumTransactionValueCharacterAreNotAllowed: Step 01 - Clear 'Minimum Transaction Value' textbox");
			customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "amountlowerlimit");
			
			log.info("MinimumTransactionValueCharacterAreNotAllowed: Step 02 - Input to 'Minimum Transaction Value' textbox");
			customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "amountlowerlimit", characterMinimumTransactionValue);
			
			log.info("MinimumTransactionValueCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Minimum Transaction Value"), "Characters are not allowed");
		}
	}
	
	@Test
	public void CS_06_MinimumTransactionValueCanNotHaveSpecialCharacters() {
		for (String specialMinimumTransactionValue : specialValues) {
			
			log.info("MinimumTransactionValueCanNotHaveSpecialCharacters: Step 01 - Clear 'Minimum Transaction Value' textbox");
			customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "amountlowerlimit");
			
			log.info("MinimumTransactionValueCanNotHaveSpecialCharacters: Step 02 - Input to 'Minimum Transaction Value' textbox");
			customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "amountlowerlimit", specialMinimumTransactionValue);
			
			
			log.info("MinimumTransactionValueCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Minimum Transaction Value"), "Special characters are not allowed");
		}
	}
	
	@Test
	public void CS_07_MinimumTransactionValueFirstCharacterMustNotBeBlank() {
		
		log.info("MinimumTransactionValueFirstCharacterMustNotBeBlank: Step 01 - Clear 'Minimum Transaction Value' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "amountlowerlimit");
		
		log.info("MinimumTransactionValueFirstCharacterMustNotBeBlank: Step 02 - Input to 'Minimum Transaction Value' textbox");
		customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "amountlowerlimit", blankSpace);
		
		log.info("MinimumTransactionValueFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Minimum Transaction Value"), "Characters are not allowed");
		
	}
	
	@Test
	public void CS_08_NumberOfTransactionCharacterAreNotAllowed() {
		for (String CharacterNumberOfTransaction : characterValues) {
			
			log.info("NumberOfTransactionCharacterAreNotAllowed: Step 01 - Clear 'Number of Transaction' textbox");
			customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "numtransaction");
			
			log.info("NumberOfTransactionCharacterAreNotAllowed: Step 02 - Input to 'Number of Transaction' textbox");
			customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "numtransaction", CharacterNumberOfTransaction);
			
			log.info("NumberOfTransactionCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Number of Transaction"), "Characters are not allowed");
		}
	}

	@Test
	public void CS_09_NumberOfTransactionCanNotHaveSpecialCharacters() {
		for (String specialNumberOfTransaction : specialValues) {
			
			log.info("NumberOfTransactionCanNotHaveSpecialCharacters: Step 01 - Clear 'Number of Transaction' textbox");
			customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "numtransaction");
			
			log.info("NumberOfTransactionCanNotHaveSpecialCharacters: Step 02 - Input to 'Number of Transaction' textbox");
			customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "numtransaction", specialNumberOfTransaction);
			
			log.info("NumberOfTransactionCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Number of Transaction"), "Special characters are not allowed");
		}
	}

	@Test
	public void CS_10_NumberOfTransactionFirstCharacterMustNotBeBlank() {
		
		log.info("NumberOfTransactionFirstCharacterMustNotBeBlank: Step 01 - Clear 'Number of Transaction' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "numtransaction");
		
		log.info("NumberOfTransactionFirstCharacterMustNotBeBlank: Step 02 - Input to 'Number of Transaction' textbox");
		customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "numtransaction", blankSpace);
		
		log.info("NumberOfTransactionFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Number of Transaction"), "Characters are not allowed");

	}
	
	@Test
	public void CS_11_InputValidInforAndVerifyCustomisedStatementDisplayed() {
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 01 - Clear 'Account Number' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 02 - Input to 'Account Number' textbox");
		customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", EditAccount.ACCOUNT_ID);
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 03 - Clear 'Minimum Transaction Value' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "amountlowerlimit");
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 04 - Input to 'Minimum Transaction Value' textbox");
		customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "amountlowerlimit", currentAmount);
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 05 - Clear 'Number of Transaction' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "numtransaction");
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 06 - Input to 'Number of Transaction' textbox");
		customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "numtransaction", numberOfTransaction);
		
		log.info("InputValidInforAndVerifyCustomisedStatementDisplayed: Step 07 - Click to Submit button");
		customisedStatementPage.clickToDynamicButton(driver, "AccSubmit");	
		
		log.info("NumberOfTransactionFirstCharacterMustNotBeBlank: Step 08 - Verify Transaction Details message displayed");
		verifyTrue(customisedStatementPage.isTransactionDetailsFormDisplayed(EditAccount.ACCOUNT_ID));
	}

	

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
