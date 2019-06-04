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
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	FundTransferPageObject fundTransferPage;

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

		log.info("Precondition: Step 07 - Click To 'Fund Transfer' link");
		homePage.openMultiplePage(driver, "Fund Transfer");
		fundTransferPage = PageFactoryManager.getFundTransferPage(driver);
	}
	
	@Test
	public void FT_01_PayersAccountMustNotBeBlank() {
		
		log.info("PayersAccountMustNotBeBlank: Step 01 - Clear 'Payers Account' textbox");
		fundTransferPage.clearPayersAccountTextbox();
		
		log.info("PayersAccountMustNotBeBlank: Step 02 - Click to 'Payers Account' textbox");
		fundTransferPage.clickToPayersAccountTextbox();
		
		log.info("PayersAccountMustNotBeBlank: Step 03 - Press TAB key");
		fundTransferPage.pressTABKeyToPayersAccountTextbox();
		
		log.info("PayersAccountMustNotBeBlank: Step 04 - Verify 'Payers Account Number must not be blank' message displayed");
		verifyTrue(fundTransferPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Payers Account Number"));
	}
	
	@Test
	public void FT_02_PayersAccountMustBeNumeric() {
		for (String characterValue : characterValues) {
			
			log.info("PayersAccountMustNotBeBlank: Step 01 - Clear 'Payers Account' textbox");
			fundTransferPage.clearPayersAccountTextbox();
			
			log.info("PayersAccountMustNotBeBlank: Step 02 - Input to 'Payers Account' textbox");
			fundTransferPage.inPutValueToPayersAccountNumber(characterValue);
			
			log.info("PayersAccountMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(fundTransferPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Payers account no"));
		}
	}
	
	@Test
	public void FT_03_PayersAccountCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			
			log.info("PayersAccountCanNotHaveSpecialCharacters: Step 01 - Clear 'Payers Account' textbox");
			fundTransferPage.clearPayersAccountTextbox();
			
			log.info("PayersAccountCanNotHaveSpecialCharacters: Step 02 - Input to 'Payers Account' textbox");
			fundTransferPage.inPutValueToPayersAccountNumber(specialValue);
			
			log.info("PayersAccountMustNotBeBlank: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(fundTransferPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Payers account no"));
		}
	}

	@Test
	public void FT_04_PayeesAccountMustNotBeBlank() {
		
		log.info("PayeesAccountMustNotBeBlank: Step 01 - Clear 'Payees Account' textbox");
		fundTransferPage.clearPayeesAccountTextbox();
		
		log.info("PayeesAccountMustNotBeBlank: Step 02 - Click to 'Payees Account' textbox");
		fundTransferPage.clickToPayeesAccountTextbox();
		
		log.info("PayeesAccountMustNotBeBlank: Step 03 - Press TAB key");
		fundTransferPage.pressTABKeyToPayeesAccountTextbox();
		
		log.info("PayeesAccountMustNotBeBlank: Step 04 - Verify 'Payees Account Number must not be blank' message displayed");
		verifyTrue(fundTransferPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Payees Account Number"));
	}
	
	@Test
	public void FT_05_PayeesAccountMustBeNumeric() {
		for (String characterValue : characterValues) {
			
			log.info("PayeesAccountMustNotBeBlank: Step 01 - Clear 'Payees Account' textbox");
			fundTransferPage.clearPayeesAccountTextbox();
			
			log.info("PayeesAccountMustNotBeBlank: Step 02 - Input to 'Payees Account' textbox");
			fundTransferPage.inPutValueToPayeesAccountNumber(characterValue);
			
			log.info("PayeesAccountMustNotBeBlank: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(fundTransferPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Payees account no"));
		}
	}
	
	@Test
	public void FT_06_PayeesAccountCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			
			log.info("PayeesAccountCanNotHaveSpecialCharacters: Step 01 - Clear 'Payees Account' textbox");
			fundTransferPage.clearPayeesAccountTextbox();
			
			log.info("PayeesAccountCanNotHaveSpecialCharacters: Step 02 - Input to 'Payees Account' textbox");
			fundTransferPage.inPutValueToPayeesAccountNumber(specialValue);
			
			log.info("PayeesAccountCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(fundTransferPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Payees account no"));
		}
	}
	
	@Test
	public void FT_07_AmountMustNotBeBlank() {
		
		log.info("AmountMustNotBeBlank: Step 01 - Clear 'Amount' textbox");
		fundTransferPage.clearAmountTextbox();
		
		log.info("AmountMustNotBeBlank: Step 02 - Click to 'Amount' textbox");
		fundTransferPage.clickToAmountTextbox();
		
		log.info("AmountMustNotBeBlank: Step 03 - Press TAB key");
		fundTransferPage.pressTABKeyToAmountTextbox();
		
		log.info("AmountMustNotBeBlank: Step 04 - Verify 'Amount field must not be blank' message displayed");
		verifyTrue(fundTransferPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Amount field"));
	}

	@Test
	public void FT_08_AmountMustBeNumeric() {
		for (String characterValue : characterValues) {
			
			log.info("AmountMustBeNumeric: Step 01 - Clear 'Amount' textbox");
			fundTransferPage.clearAmountTextbox();
			
			log.info("AmountMustBeNumeric: Step 02 - Input to 'Amount' textbox");
			fundTransferPage.inputAmountToAmountTextbox(characterValue);
			
			log.info("AmountMustBeNumeric: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(fundTransferPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Amount"));
		}
	}
	
	@Test
	public void FT_09_AmountCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {
			
			log.info("AmountCanNotHaveSpecialCharacters: Step 01 - Clear 'Amount' textbox");
			fundTransferPage.clearAmountTextbox();
			
			log.info("AmountCanNotHaveSpecialCharacters: Step 02 - Input to 'Amount' textbox");
			fundTransferPage.inputAmountToAmountTextbox(specialValue);
			
			log.info("AmountCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(fundTransferPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Amount"));
		}
	}
	
	@Test
	public void FT_10_DescriptionMustNotBeBlank() {
		
		log.info("DescriptionMustNotBeBlank: Step 01 - Clear 'Description' textbox");
		fundTransferPage.clearDescriptionTextbox();
		
		log.info("DescriptionMustNotBeBlank: Step 02 - Click to 'Description' textbox");
		fundTransferPage.clickToDescriptionTextbox();
		
		log.info("DescriptionMustNotBeBlank: Step 03 - Press TAB key");
		fundTransferPage.pressTABKeyToDescriptionTextbox();
		
		log.info("DescriptionMustNotBeBlank: Step 04 - Verify 'Description can not be blank' message displayed");
		verifyTrue(fundTransferPage.isDescriptionCanNotBeBlankMessageDisplayed());
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
