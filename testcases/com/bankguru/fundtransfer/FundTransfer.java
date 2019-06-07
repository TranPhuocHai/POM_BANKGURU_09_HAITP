package com.bankguru.fundtransfer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.user.Common_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class FundTransfer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private FundTransferPageObject fundTransferPage;

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

		log.info("Precondition: Step 07 - Click To 'Fund Transfer' link");
		homePage.openMultiplePage(driver, "Fund Transfer");
		fundTransferPage = PageFactoryManager.getFundTransferPage(driver);
	}
	
	@Test
	public void FT_01_PayersAccountMustNotBeBlank() {
		
		log.info("PayersAccountMustNotBeBlank: Step 01 - Clear 'Payers Account' textbox");
		fundTransferPage.clearDynamicTextboxOrTextArea(driver, "payersaccount");
		
		log.info("PayersAccountMustNotBeBlank: Step 02 - Click to 'Payers Account' textbox");
		fundTransferPage.clickToDynamicTextboxOrTextArea(driver, "payersaccount");
		
		log.info("PayersAccountMustNotBeBlank: Step 03 - Press TAB key");
		fundTransferPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "payersaccount");
		
		log.info("PayersAccountMustNotBeBlank: Step 04 - Verify 'Payers Account Number must not be blank' message displayed");
		verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Payers account no"), "Payers Account Number must not be blank");
	}
	
	@Test
	public void FT_02_PayersAccountMustBeNumeric() {
		for (String characterValue : characterValues) {
			
			log.info("PayersAccountMustNotBeBlank: Step 01 - Clear 'Payers Account' textbox");
			fundTransferPage.clearDynamicTextboxOrTextArea(driver, "payersaccount");
			
			log.info("PayersAccountMustNotBeBlank: Step 02 - Input to 'Payers Account' textbox");
			fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payersaccount", characterValue);
			
			log.info("PayersAccountMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Payers account no"), "Characters are not allowed");
		}
	}
	
	@Test
	public void FT_03_PayersAccountCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			
			log.info("PayersAccountCanNotHaveSpecialCharacters: Step 01 - Clear 'Payers Account' textbox");
			fundTransferPage.clearDynamicTextboxOrTextArea(driver, "payersaccount");
			
			log.info("PayersAccountCanNotHaveSpecialCharacters: Step 02 - Input to 'Payers Account' textbox");
			fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payersaccount", specialValue);
			
			log.info("PayersAccountMustNotBeBlank: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Payers account no"), "Special characters are not allowed");
		}
	}

	@Test
	public void FT_04_PayeesAccountMustNotBeBlank() {
		
		log.info("PayeesAccountMustNotBeBlank: Step 01 - Clear 'Payees Account' textbox");
		fundTransferPage.clearDynamicTextboxOrTextArea(driver, "payeeaccount");
		
		log.info("PayeesAccountMustNotBeBlank: Step 02 - Click to 'Payees Account' textbox");
		fundTransferPage.clickToDynamicTextboxOrTextArea(driver, "payeeaccount");;
		
		log.info("PayeesAccountMustNotBeBlank: Step 03 - Press TAB key");
		fundTransferPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "payeeaccount");
		
		log.info("PayeesAccountMustNotBeBlank: Step 04 - Verify 'Payees Account Number must not be blank' message displayed");
		verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Payees account no"), "Payees Account Number must not be blank");
	}
	
	@Test
	public void FT_05_PayeesAccountMustBeNumeric() {
		for (String characterValue : characterValues) {
			
			log.info("PayeesAccountMustNotBeBlank: Step 01 - Clear 'Payees Account' textbox");
			fundTransferPage.clearDynamicTextboxOrTextArea(driver, "payeeaccount");
			
			log.info("PayeesAccountMustNotBeBlank: Step 02 - Input to 'Payees Account' textbox");
			fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payeeaccount", characterValue);			
			
			log.info("PayeesAccountMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Payees account no"), "Characters are not allowed");
		}
	}
	
	@Test
	public void FT_06_PayeesAccountCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			
			log.info("PayeesAccountCanNotHaveSpecialCharacters: Step 01 - Clear 'Payees Account' textbox");
			fundTransferPage.clearDynamicTextboxOrTextArea(driver, "payeeaccount");
			
			log.info("PayeesAccountCanNotHaveSpecialCharacters: Step 02 - Input to 'Payees Account' textbox");
			fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payeeaccount", specialValue);	
			
			log.info("PayeesAccountCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Payees account no"), "Special characters are not allowed");
		}
	}
	
	@Test
	public void FT_07_AmountMustNotBeBlank() {
		
		log.info("AmountMustNotBeBlank: Step 01 - Clear 'Amount' textbox");
		fundTransferPage.clearDynamicTextboxOrTextArea(driver, "ammount");
		
		log.info("AmountMustNotBeBlank: Step 02 - Click to 'Amount' textbox");
		fundTransferPage.clickToDynamicTextboxOrTextArea(driver, "ammount");
		
		log.info("AmountMustNotBeBlank: Step 03 - Press TAB key");
		fundTransferPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "ammount");
		
		log.info("AmountMustNotBeBlank: Step 04 - Verify 'Amount field must not be blank' message displayed");
		verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Amount"), "Amount field must not be blank");
	}

	@Test
	public void FT_08_AmountMustBeNumeric() {
		for (String characterValue : characterValues) {
			
			log.info("AmountMustBeNumeric: Step 01 - Clear 'Amount' textbox");
			fundTransferPage.clearDynamicTextboxOrTextArea(driver, "ammount");
			
			log.info("AmountMustBeNumeric: Step 02 - Input to 'Amount' textbox");
			fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "ammount", characterValue);	
			
			log.info("AmountMustBeNumeric: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Amount"), "Characters are not allowed");
		}
	}
	
	@Test
	public void FT_09_AmountCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			
			log.info("AmountCanNotHaveSpecialCharacters: Step 01 - Clear 'Amount' textbox");
			fundTransferPage.clearDynamicTextboxOrTextArea(driver, "ammount");
			
			log.info("AmountCanNotHaveSpecialCharacters: Step 02 - Input to 'Amount' textbox");
			fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "ammount", specialValue);	
			
			log.info("AmountCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Amount"), "Special characters are not allowed");
		}
	}
	
	@Test
	public void FT_10_DescriptionMustNotBeBlank() {
		
		log.info("DescriptionMustNotBeBlank: Step 01 - Clear 'Description' textbox");
		fundTransferPage.clearDynamicTextboxOrTextArea(driver, "desc");
		
		log.info("DescriptionMustNotBeBlank: Step 02 - Click to 'Description' textbox");
		fundTransferPage.clickToDynamicTextboxOrTextArea(driver, "desc");
		
		log.info("DescriptionMustNotBeBlank: Step 03 - Press TAB key");
		fundTransferPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "desc");
		
		log.info("DescriptionMustNotBeBlank: Step 04 - Verify 'Description can not be blank' message displayed");
		verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Description"), "Description can not be blank");
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
