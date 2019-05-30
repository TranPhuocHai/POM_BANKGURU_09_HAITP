package com.bankguru.fundtransfer;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class FundTransfer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private FundTransferPageObject fundTransferPage;

	private String loginPageUrl, userIdInfo, passwordInfo;
	private String email = "khnammivc" + randomNumber() + "@gmail.com";
	private String validName = "Tran Phuoc Hai";
	private String expectedGender = "male";
	private String validDateOfBirth = "1988-07-31";
	private String validAdress = "100 Ho Guom";
	private String validCity = "Ha Noi";
	private String validState = "Hoan Kiem";
	private String validPin = "600000";
	private String validPhoneNumber = "0987654321";
	private String validEmailID = "khain" + randomNumber() + "@gmail.com";
	private String validPassword = "idonknow12345678";

	private String blankSpace = " ";
	private String[] characterValues = new String[] { "haitp", "12 1234" };
	private String[] specialValues = new String[] { "097@!13546", "!#123654", "0987654#@!" };

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

		newCustomerPage.openMultiplePage(driver, "Fund Transfer");
		fundTransferPage = PageFactoryManager.getFundTransferPage(driver);
	}
	
	@Test
	public void FT_01_PayersAccountMustNotBeBlank() {
		fundTransferPage.clearPayersAccountTextbox();
		fundTransferPage.clickToPayersAccountTextbox();
		fundTransferPage.pressTABKeyToPayersAccountTextbox();
		Assert.assertTrue(fundTransferPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Payers Account Number"));
	}
	
	@Test
	public void FT_02_PayersAccountMustBeNumeric() {
		for (String characterValue : characterValues) {
			fundTransferPage.clearPayersAccountTextbox();
			fundTransferPage.inPutValueToPayersAccountNumber(characterValue);
			Assert.assertTrue(fundTransferPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Payers account no"));
		}
	}
	
	@Test
	public void FT_03_PayersAccountCanNotHaveSpecialCharacter() {
		for (String specialValue : specialValues) {
			fundTransferPage.clearPayersAccountTextbox();
			fundTransferPage.inPutValueToPayersAccountNumber(specialValue);
			Assert.assertTrue(fundTransferPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Payers account no"));
		}
	}

	@Test
	public void FT_04_PayeesAccountMustNotBeBlank() {
		fundTransferPage.clearPayeesAccountTextbox();
		fundTransferPage.clickToPayeesAccountTextbox();
		fundTransferPage.pressTABKeyToPayeesAccountTextbox();
		Assert.assertTrue(fundTransferPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Payees Account Number"));
	}
	
	@Test
	public void FT_05_PayeesAccountMustBeNumeric() {
		for (String characterValue : characterValues) {
			fundTransferPage.clearPayeesAccountTextbox();
			fundTransferPage.inPutValueToPayeesAccountNumber(characterValue);
			Assert.assertTrue(fundTransferPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Payees account no"));
		}
	}
	
	@Test
	public void FT_06_PayeesAccountCanNotHaveSpecialCharacter() {
		for (String specialValue : specialValues) {
			fundTransferPage.clearPayeesAccountTextbox();
			fundTransferPage.inPutValueToPayeesAccountNumber(specialValue);
			Assert.assertTrue(fundTransferPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Payees account no"));
		}
	}
	
	@Test
	public void FT_07_AmountMustNotBeBlank() {
		fundTransferPage.clearAmountTextbox();
		fundTransferPage.clickToAmountTextbox();
		fundTransferPage.pressTABKeyToAmountTextbox();
		Assert.assertTrue(fundTransferPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Amount field"));
	}

	@Test
	public void FT_08_AmountMustBeNumeric() {
		for (String characterValue : characterValues) {
			fundTransferPage.clearAmountTextbox();
			fundTransferPage.inputAmountToAmountTextbox(characterValue);
			Assert.assertTrue(fundTransferPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Amount"));
		}
	}
	
	@Test
	public void FT_09_AmountCanNotHaveSpecialCharacter() {
		for (String specialValue : specialValues) {
			fundTransferPage.clearAmountTextbox();
			fundTransferPage.inputAmountToAmountTextbox(specialValue);
			Assert.assertTrue(fundTransferPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Amount"));
		}
	}
	
	@Test
	public void FT_10_DescriptionMustNotBeBlank() {
		fundTransferPage.clearAmountTextbox();
		fundTransferPage.clickToAmountTextbox();
		fundTransferPage.pressTABKeyToAmountTextbox();
		Assert.assertTrue(fundTransferPage.isDescriptionCanNotBeBlankMessageDisplayed());
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
