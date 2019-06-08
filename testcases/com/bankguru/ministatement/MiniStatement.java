package com.bankguru.ministatement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.EditAccount;
import com.bankguru.user.Common_01_RegisterToSystem;

import bankguruPageFactoryManager.PageFactoryManager;
import bankguruPageObjects.HomePageObject;
import bankguruPageObjects.LoginPageObject;
import bankguruPageObjects.MiniStatementPageObject;
import commons.AbstractTest;

public class MiniStatement extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private MiniStatementPageObject miniStatementPage;

	
	private String blankSpace = " ";
	private String[] characterAccountNos = new String[] { "haitp", "12 1234" };
	private String[] specialAccountNos = new String[] { "097@!13546", "!#123654", "0987654#@!" };

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
		
		log.info("Precondition: Step 07 - Click to 'Mini Statement' link");
		homePage.openMultiplePage(driver, "Mini Statement");
		miniStatementPage = PageFactoryManager.getMiniStatementPage(driver);
		
		log.info("Precondition: Step 08 - Veify 'Mini Statement Form' title displayed");
		verifyTrue(miniStatementPage.isDynamicPageTitleDisplayed(driver, "Mini Statement Form"));
	}

	@Test
	public void MS_01_AccountNumberCanNotBeEmpty() {

		log.info("AccountNumberCanNotBeEmpty: Step 01 - Clear 'Account Number' textbox");
		miniStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");

		log.info("AccountNumberCanNotBeEmpty: Step 02 - Click to 'Account Number' textbox");
		miniStatementPage.clickToDynamicTextboxOrTextArea(driver, "accountno");

		log.info("AccountNumberCanNotBeEmpty: Step 03 - Press TAB key");
		miniStatementPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "accountno");

		log.info("AccountNumberCanNotBeEmpty: Step 04 - Verify 'Account Number must not be blank' message displayed");
		verifyEquals(miniStatementPage.getTextDynamicValidateMessage(driver, "Account No"), "Account Number must not be blank");
	}

	@Test
	public void MS_02_AccountNumberCharacterAreNotAllowed() {
		for (String characterAccountNo : characterAccountNos) {

			log.info("AccountNumberCharacterAreNotAllowed: Step 01 - Clear 'Account Number' textbox");
			miniStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");

			log.info("AccountNumberCharacterAreNotAllowed: Step 02 - Input to 'Account Number' textbox");
			miniStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", characterAccountNo);
			

			log.info("AccountNumberCanNotBeEmpty: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(miniStatementPage.getTextDynamicValidateMessage(driver, "Account No"), "Characters are not allowed");
		}
	}

	@Test
	public void MS_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialAccountNo : specialAccountNos) {

			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 01 - Clear 'Account Number' textbox");
			miniStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 02 - Input to 'Account Number' textbox");
			miniStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", specialAccountNo);
			
			log.info("AccountNumberCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(miniStatementPage.getTextDynamicValidateMessage(driver, "Account No"), "Special characters are not allowed");
		}
	}

	@Test
	public void MS_04_AccountNumberFirstCharacterMustNotBeBlank() {

		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 01 - Clear 'Account Number' textbox");
		miniStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 02 - Input to 'Account Number' textbox");
		miniStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", blankSpace);
		
		log.info("AccountNumberFirstCharacterMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyEquals(miniStatementPage.getTextDynamicValidateMessage(driver, "Account No"), "Characters are not allowed");

	}
	
	@Test
	public void MS_05_ValidAccountNumber() {
		
		log.info("ValidAccountNumber: Step 01 - Clear 'Account Number' textbox");
		miniStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("ValidAccountNumber: Step 02 - Input to 'Account Number' textbox");
		miniStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", EditAccount.ACCOUNT_ID);
		
		log.info("ValidAccountNumber: Step 03 - Click to submit button");
		miniStatementPage.clickToDynamicButton(driver, "AccSubmit");
		
		log.info("ValidAccountNumber: Step 04 - Verify Last Five Transaction Details message displayed");
		verifyTrue(miniStatementPage.isLastFiveTransactionDetailsDispayed(EditAccount.ACCOUNT_ID));
	}
	

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
