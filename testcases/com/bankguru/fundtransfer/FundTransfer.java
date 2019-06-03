package com.bankguru.fundtransfer;

import java.util.Random;

import org.openqa.selenium.WebDriver;
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

	private String[] characterValues = new String[] { "haitp", "12 1234" };
	private String[] specialValues = new String[] { "097@!13546", "!#123654", "0987654#@!" };

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);

		log.info("Precondition: Step 01 - open Login Page");
		loginPage = PageFactoryManager.getLoginPage(driver);
		
		log.info("Precondition: Step 02 - Verify Login Form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());
		
		log.info("Precondition: Step 03 - Get Login Page url");
		loginPageUrl = loginPage.getLoginPageUrl();
		
		log.info("Precondition: Step 04 - Click to 'here' link");
		registerPage = loginPage.clickToHereLink();
		
		log.info("Precondition: Step 05 - Verify Register Page displayed");
		verifyTrue(registerPage.isRegisterPageDisplayed());
		
		log.info("Precondition: Step 06 - Input to 'Email ID' textbox");
		registerPage.inPutToEmailIDTextbox(email);
		
		log.info("Precondition: Step 07 - Click to Submit button");
		registerPage.clickToSubmitButton();
		
		log.info("Precondition: Step 08 - Get UserID and Password Infor");
		userIdInfo = registerPage.getTextDynamicInfo(driver, "User ID :");
		passwordInfo = registerPage.getTextDynamicInfo(driver, "Password :");
		
		log.info("Precondition: Step 09 - Open Login Page");
		loginPage = registerPage.openLoginPage(loginPageUrl);
		
		log.info("Precondition: Step 10 - Verify Login Form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());
		
		log.info("Precondition: Step 11 - Input to userID and Password textboxes");
		loginPage.inPutToUserIDTextbox(userIdInfo);
		loginPage.inPutToPasswordTextbox(passwordInfo);
		
		log.info("Precondition: Step 11 - Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Precondition: Step 12 - Verify Welcome message of Home page displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed());
		
		log.info("Precondition: Step 13 - Verify User ID infor displayed");
		verifyTrue(homePage.isUserIDDisplayed(userIdInfo));
		
		log.info("Precondition: Step 14 - Click to 'New Customer' link");
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

		log.info("Precondition: Step 15 - Input to Customer Name textbox");
		newCustomerPage.inputValueToCustomerNameTextbox(validName);
		
		log.info("Precondition: Step 16 - Select Male gender");
		newCustomerPage.selectMaleGenderRadioButton();
		
		log.info("Precondition: Step 17 - Remove Date Of Birth attribute");
		newCustomerPage.removeDateOfBirthAttribute();
		
		log.info("Precondition: Step 18 - Input to Date Of Birth textbox");
		newCustomerPage.inputValueToDateOfBirthTextbox(validDateOfBirth);
		
		log.info("Precondition: Step 19 - Input to 'Address' text area");
		newCustomerPage.inputValueToAdressTextArea(validAdress);
		
		log.info("Precondition: Step 20 - Input to 'City' textbox");
		newCustomerPage.inputValueToCityTextbox(validCity);
		
		log.info("Precondition: Step 21 - Input to 'State' textbox");
		newCustomerPage.inputValueToStateTextbox(validState);
		
		log.info("Precondition: Step 22 - Input to 'PIN' textbox");
		newCustomerPage.inputValueToPinTextbox(validPin);
		
		log.info("Precondition: Step 23 - Input to 'Mobile Number' textbox");
		newCustomerPage.inputValueToMobileNumberTextbox(validPhoneNumber);
		
		log.info("Precondition: Step 24 - Input to 'Email' textbox");
		newCustomerPage.inputValueToEmailTextbox(validEmailID);
		
		log.info("Precondition: Step 25 - Input to 'Password' textbox");
		newCustomerPage.inputValueToPasswordTextbox(validPassword);
		
		log.info("Precondition: Step 26 - Click to Submit button");
		newCustomerPage.clickToSubmitButton();
		
		log.info("Precondition: Step 27 - Verify 'Customer Registered Successfully!!!' message displayed");
		verifyTrue(newCustomerPage.isCustomerRegisteredSuccessfullyDisplayed());

		log.info("Precondition: Step 28 - Verify all infor of new customer are correct");
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Customer Name"), validName);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Gender"), expectedGender);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Birthdate"), validDateOfBirth);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Address"), validAdress);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "City"), validCity);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "State"), validState);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Pin"), validPin);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Mobile No."), validPhoneNumber);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Email"), validEmailID);

		log.info("Precondition: Step 39 - Click To 'Fund Transfer' link");

		newCustomerPage.openMultiplePage(driver, "Fund Transfer");
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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
