package com.bankguru.validateMessage;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commonFunction.Common_01_RegisterToSystem;
import com.bankguru.testdata.CommonTestData;
import com.bankguru.testdata.ValidateMessage;

import PageObjects.FundTransferPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import commons.AbstractTest;
import commons.PageFactoryManager;
import reportConfig.ExtentTestManager;

public class FundTransfer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private FundTransferPageObject fundTransferPage;

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

		log.info("Precondition: Step 07 - Click To 'Fund Transfer' link");
		homePage.openMultiplePage(driver, "Fund Transfer");
		fundTransferPage = PageFactoryManager.getFundTransferPage(driver);
	}
	
	@Test
	public void FundTransfer_01_PayersAccountMustNotBeBlank(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		log.info("FundTransfer_01: Step 01 - Clear 'Payers Account' textbox");
		fundTransferPage.clearDynamicTextboxOrTextArea(driver, "payersaccount");
		
		log.info("FundTransfer_01: Step 02 - Click to 'Payers Account' textbox");
		fundTransferPage.clickToDynamicTextboxOrTextArea(driver, "payersaccount");
		
		log.info("FundTransfer_01: Step 03 - Press TAB key");
		fundTransferPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "payersaccount");
		
		log.info("FundTransfer_01: Step 04 - Verify 'Payers Account Number must not be blank' message displayed");
		verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Payers account no"), ValidateMessage.PAYERS_ACCOUNT_NUMBER_MUST_NOT_BE_BLANK);
	}
	
	@Test
	public void FundTransfer_02_PayersAccountMustBeNumeric(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String characterValue : CommonTestData.CHARACTER_VALUE) {
			
			log.info("FundTransfer_02: Step 01 - Clear 'Payers Account' textbox");
			fundTransferPage.clearDynamicTextboxOrTextArea(driver, "payersaccount");
			
			log.info("FundTransfer_02: Step 02 - Input to 'Payers Account' textbox");
			fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payersaccount", characterValue);
			
			log.info("FundTransfer_02: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Payers account no"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}
	}
	
	@Test
	public void FundTransfer_03_PayersAccountCanNotHaveSpecialCharacters(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String specialValue : CommonTestData.SPECIAL_VALUE) {
			
			log.info("FundTransfer_03: Step 01 - Clear 'Payers Account' textbox");
			fundTransferPage.clearDynamicTextboxOrTextArea(driver, "payersaccount");
			
			log.info("FundTransfer_03: Step 02 - Input to 'Payers Account' textbox");
			fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payersaccount", specialValue);
			
			log.info("FundTransfer_03: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Payers account no"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void FundTransfer_04_PayeesAccountMustNotBeBlank(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		log.info("FundTransfer_04: Step 01 - Clear 'Payees Account' textbox");
		fundTransferPage.clearDynamicTextboxOrTextArea(driver, "payeeaccount");
		
		log.info("FundTransfer_04: Step 02 - Click to 'Payees Account' textbox");
		fundTransferPage.clickToDynamicTextboxOrTextArea(driver, "payeeaccount");;
		
		log.info("FundTransfer_04: Step 03 - Press TAB key");
		fundTransferPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "payeeaccount");
		
		log.info("FundTransfer_04: Step 04 - Verify 'Payees Account Number must not be blank' message displayed");
		verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Payees account no"), ValidateMessage.PAYEES_ACCOUNT_NUMBER_MUST_NOT_BE_BLANK);
	}
	
	@Test
	public void FundTransfer_05_PayeesAccountMustBeNumeric(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String characterValue : CommonTestData.CHARACTER_VALUE) {
			
			log.info("FundTransfer_05: Step 01 - Clear 'Payees Account' textbox");
			fundTransferPage.clearDynamicTextboxOrTextArea(driver, "payeeaccount");
			
			log.info("FundTransfer_05: Step 02 - Input to 'Payees Account' textbox");
			fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payeeaccount", characterValue);			
			
			log.info("FundTransfer_05: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Payees account no"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}
	}
	
	@Test
	public void FundTransfer_06_PayeesAccountCanNotHaveSpecialCharacters(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String specialValue : CommonTestData.SPECIAL_VALUE) {
			
			log.info("FundTransfer_06: Step 01 - Clear 'Payees Account' textbox");
			fundTransferPage.clearDynamicTextboxOrTextArea(driver, "payeeaccount");
			
			log.info("FundTransfer_06: Step 02 - Input to 'Payees Account' textbox");
			fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payeeaccount", specialValue);	
			
			log.info("FundTransfer_06: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Payees account no"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}
	
	@Test
	public void FundTransfer_07_AmountMustNotBeBlank(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		log.info("FundTransfer_07: Step 01 - Clear 'Amount' textbox");
		fundTransferPage.clearDynamicTextboxOrTextArea(driver, "ammount");
		
		log.info("FundTransfer_07: Step 02 - Click to 'Amount' textbox");
		fundTransferPage.clickToDynamicTextboxOrTextArea(driver, "ammount");
		
		log.info("FundTransfer_07: Step 03 - Press TAB key");
		fundTransferPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "ammount");
		
		log.info("FundTransfer_07: Step 04 - Verify 'Amount field must not be blank' message displayed");
		verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Amount"), ValidateMessage.AMOUNT_FIELD_MUST_NOT_BE_BLANK);
	}

	@Test
	public void FundTransfer_08_AmountMustBeNumeric(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String characterValue : CommonTestData.CHARACTER_VALUE) {
			
			log.info("FundTransfer_08: Step 01 - Clear 'Amount' textbox");
			fundTransferPage.clearDynamicTextboxOrTextArea(driver, "ammount");
			
			log.info("FundTransfer_08: Step 02 - Input to 'Amount' textbox");
			fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "ammount", characterValue);	
			
			log.info("FundTransfer_08: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Amount"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}
	}
	
	@Test
	public void FundTransfer_09_AmountCanNotHaveSpecialCharacters(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String specialValue : CommonTestData.SPECIAL_VALUE) {
			
			log.info("FundTransfer_09: Step 01 - Clear 'Amount' textbox");
			fundTransferPage.clearDynamicTextboxOrTextArea(driver, "ammount");
			
			log.info("FundTransfer_09: Step 02 - Input to 'Amount' textbox");
			fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "ammount", specialValue);	
			
			log.info("FundTransfer_09: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Amount"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}
	
	@Test
	public void FundTransfer_10_DescriptionMustNotBeBlank(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		log.info("FundTransfer_10: Step 01 - Clear 'Description' textbox");
		fundTransferPage.clearDynamicTextboxOrTextArea(driver, "desc");
		
		log.info("FundTransfer_10: Step 02 - Click to 'Description' textbox");
		fundTransferPage.clickToDynamicTextboxOrTextArea(driver, "desc");
		
		log.info("FundTransfer_10: Step 03 - Press TAB key");
		fundTransferPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "desc");
		
		log.info("FundTransfer_10: Step 04 - Verify 'Description can not be blank' message displayed");
		verifyEquals(fundTransferPage.getTextDynamicValidateMessage(driver, "Description"), ValidateMessage.DESCRIPTION_CAN_NOT_BE_BLANK);
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
