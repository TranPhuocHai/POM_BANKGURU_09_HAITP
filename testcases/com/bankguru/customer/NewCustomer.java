package com.bankguru.customer;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class NewCustomer extends AbstractTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private String loginPageUrl, userIdInfo, passwordInfo;
	
	private String email = "haimivknghbv" + randomNumber() + "@gmail.com";
	private String blankSpace = " ";
	private String[] numericValues = new String[] { "1234", "name123" };
	private String[] specialCharacters = new String[] { "haitp!@#", "!@#" };
	private String[] characterPINs = new String[] { "123PIN", "HAI321" };
	private String[] lessThan6DigitsList = new String[] { "1", "12", "321", "3214", "32147" };
	private String[] characterPhoneNumbers = new String[] { "haitp", "12 1234" };
	private String[] specialPhoneNumbers = new String[] { "097@!13546", "!#123654", "0987654#@!" };
	private String[] incorrectEmailIDList = new String[] { "guru99@gmail", "guru99", "guru99@", "guru99@gmail.", "guru99gmail.com" };

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
		
		log.info("Precondition: Step 06 - Input to Email ID textbox");
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
		
		log.info("Precondition: Step 14 - Click to New Customer link");
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);
	}

	@Test
	public void NC_01_NameCanNotBeEmpty() {
		log.info("Name Can Not Be Empty: Step 01 - Click to Customer Name textbox");
		newCustomerPage.clickToCustomerNameTextbox();
		
		log.info("Name Can Not Be Empty: Step 02 - Press TAB key");
		newCustomerPage.pressTABKeyToCustomerNameTextBox();
		
		log.info("Name Can Not Be Empty: Step 03 - Verify correct message displayed");
		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Customer name"));
	}

	@Test
	public void NC_02_NameCanNotBeNumberic() {
		for (String numericName : numericValues) {
			log.info("Name Can Not Be Numeric: Step 01 - Clear Customer Name textbox");
			newCustomerPage.clearNameTextbox();
			
			log.info("Name Can Not Be Numeric: Step 02 - Input to Customer Name textbox");
			newCustomerPage.inputValueToCustomerNameTextbox(numericName);
			
			log.info("Name Can Not Be Numeric: Step 03 - Verify correct message displayed");
			verifyFalse(newCustomerPage.isDynamicNumbersAreNotAllowedMessageDisplayed(driver, "Customer Nam"));
			
			log.info("Name Can Not Be Numeric: Step 04 - Clear Customer Name textbox");
			newCustomerPage.clearNameTextbox();
			
			log.info("Name Can Not Be Numeric: Step 05 - Verify correct message displayed");
			newCustomerPage.inputValueToCustomerNameTextbox("@#sd");
		}
	}

//	@Test
//	public void NC_03_NameCanNotHaveSpecialCharacters() {
//		for (String specialCharactersName : specialCharacters) {
//			newCustomerPage.clearNameTextbox();
//			newCustomerPage.inputValueToCustomerNameTextbox(specialCharactersName);
//			verifyTrue(newCustomerPage.isSpecialCharactersOfNameAreNotAllowedMessageDisplayed());
//		}
//	}
//
//	@Test
//	public void NC_04_NameCanNotHaveFirstCharacterAsBlankSpace() {
//		newCustomerPage.clearNameTextbox();
//		newCustomerPage.inputValueToCustomerNameTextbox(blankSpace);
//		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "Customer Name"));
//
//	}
//
//	@Test
//	public void NC_05_AddressCanNotBeEmpty() {
//		newCustomerPage.clearAddresTextarea();
//		newCustomerPage.clickToAddressTextarea();
//		newCustomerPage.pressTABKeyToAddressTextArea();
//		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Address Field"));
//
//	}
//
//	@Test
//	public void NC_06_AdressCanNotHaveSpecialCharacters() {
//		for (String specialCharactersAddress : specialCharacters) {
//			newCustomerPage.clearAddresTextarea();
//			newCustomerPage.inputValueToAdressTextArea(specialCharactersAddress);
//			verifyTrue(newCustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Address"));
//		}
//	}
//
//	@Test
//	public void NC_07_AddressCanNotHaveFirstCharacterAsBlankSpace() {
//		newCustomerPage.clearAddresTextarea();
//		newCustomerPage.inputValueToAdressTextArea(blankSpace);
//		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "Address"));
//
//	}
//
//	@Test
//	public void NC_08_CityCanNotBeEmpty() {
//		newCustomerPage.clearCityTextbox();
//		newCustomerPage.clickToCityTextbox();
//		newCustomerPage.pressTABKeyToCityTextbox();
//		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "City Field"));
//	}
//
//	@Test
//	public void NC_08_CityCanNotBeNumberic() {
//		for (String numericCity : numericValues) {
//			newCustomerPage.clearCityTextbox();
//			newCustomerPage.inputValueToCityTextbox(numericCity);
//			verifyTrue(newCustomerPage.isDynamicNumbersAreNotAllowedMessageDisplayed(driver, "City"));
//		}
//	}
//
//	@Test
//	public void NC_10_CityCanNotHaveSpecialCharacters() {
//		for (String specialCharactersCity : specialCharacters) {
//			newCustomerPage.clearCityTextbox();
//			newCustomerPage.inputValueToCityTextbox(specialCharactersCity);
//			verifyTrue(newCustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "City"));
//		}
//	}
//
//	@Test
//	public void NC_11_CityCanNotHaveFirstCharacterAsBlankSpace() {
//		newCustomerPage.clearCityTextbox();
//		newCustomerPage.inputValueToCityTextbox(blankSpace);
//		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "City"));
//
//	}
//
//	@Test
//	public void NC_12_StateCanNotBeEmpty() {
//		newCustomerPage.clearStateTextbox();
//		newCustomerPage.clickToStateTextbox();
//		newCustomerPage.pressTABKeyToStateTextbox();
//		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "State"));
//	}
//
//	@Test
//	public void NC_13_StateCanNotBeNumberic() {
//		for (String numericState : numericValues) {
//			newCustomerPage.clearStateTextbox();
//			newCustomerPage.inputValueToStateTextbox(numericState);
//			verifyTrue(newCustomerPage.isDynamicNumbersAreNotAllowedMessageDisplayed(driver, "State"));
//		}
//	}
//
//	@Test
//	public void NC_14_StateCanNotHaveSpecialCharacters() {
//		for (String specialCharactersState : specialCharacters) {
//			newCustomerPage.clearStateTextbox();
//			newCustomerPage.inputValueToStateTextbox(specialCharactersState);
//			verifyTrue(newCustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "State"));
//		}
//	}
//
//	@Test
//	public void NC_15_StateCanNotHaveFirstCharacterAsBlankSpace() {
//		newCustomerPage.clearStateTextbox();
//		newCustomerPage.inputValueToStateTextbox(blankSpace);
//		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "State"));
//
//	}
//
//	@Test
//	public void NC_16_PinCanNotBeEmpty() {
//		newCustomerPage.clearPinTextbox();
//		newCustomerPage.clickToPinTextbox();
//		newCustomerPage.pressTABKeyToPinTextbox();
//		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "PIN Code"));
//	}
//
//	@Test
//	public void NC_17_PinMustBeNumeric() {
//		for (String characterPIN : characterPINs) {
//			newCustomerPage.clearPinTextbox();
//			newCustomerPage.inputValueToPinTextbox(characterPIN);
//			verifyTrue(newCustomerPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "PIN"));
//		}
//	}
//
//	@Test
//	public void NC_18_PinMustHave6Degits() {
//		for (String lessThan6Digits : lessThan6DigitsList) {
//			newCustomerPage.clearPinTextbox();
//			newCustomerPage.inputValueToPinTextbox(lessThan6Digits);
//			verifyTrue(newCustomerPage.isPinMustHave6DegitsMessageDisplayed());
//		}
//	}
//
//	@Test
//	public void NC_19_PinCanNotHaveFirstCharacterAsBlankSpace() {
//		newCustomerPage.clearPinTextbox();
//		newCustomerPage.inputValueToPinTextbox(blankSpace);
//		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "PIN"));
//
//	}
//
//	@Test
//	public void NC_20_TelephoneCanNotBeEmpty() {
//		newCustomerPage.clearPhoneTextbox();
//		newCustomerPage.clickToMobileNumberTextbox();
//		newCustomerPage.pressTABKeyToMobileTextbox();
//		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Mobile no"));
//	}
//
//	@Test
//	public void NC_21_TelephoneCanNotHaveFirstCharacterAsBlankSpace() {
//		newCustomerPage.clearPhoneTextbox();
//		newCustomerPage.inputValueToMobileNumberTextbox(blankSpace);
//		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "Mobile Number"));
//
//	}
//
//	@Test
//	public void NC_22_TelephoneCharacterOrIncludeSpaceAreNotAllow() {
//		for (String characterPhoneNumber : characterPhoneNumbers) {
//			newCustomerPage.clearPhoneTextbox();
//			newCustomerPage.inputValueToMobileNumberTextbox(characterPhoneNumber);
//			verifyTrue(newCustomerPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Mobile Number"));
//		}
//
//	}
//
//	@Test
//	public void NC_23_TelephoneCanNotHaveSpecialCharacters() {
//		for (String specialPhoneNumber : specialPhoneNumbers) {
//			newCustomerPage.clearPhoneTextbox();
//			newCustomerPage.inputValueToMobileNumberTextbox(specialPhoneNumber);
//			verifyTrue(newCustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Mobile Number"));
//		}
//	}
//
//	@Test
//	public void NC_24_EmailCanNotBeEmpty() {
//		newCustomerPage.clearEmailTextbox();
//		newCustomerPage.clickToEmailTextbox();
//		newCustomerPage.pressTABKeyToEmailTextbox();
//		verifyTrue(newCustomerPage.isEmailMustNotBeBlankMessageDisplayed());
//	}
//
//	@Test
//	public void NC_25_EmailMustBeInCorrectFormat() {
//		for (String incorrectEmailID : incorrectEmailIDList) {
//			newCustomerPage.clearEmailTextbox();
//			newCustomerPage.inputValueToEmailTextbox(incorrectEmailID);
//			verifyTrue(newCustomerPage.isEmailIDIsNotValidMessageDisplayed());
//		}
//	}
//
//	@Test
//	public void NC_26_EmailCanNotHaveFirstCharacterAsBlankSpace() {
//		newCustomerPage.clearEmailTextbox();
//		newCustomerPage.inputValueToEmailTextbox(blankSpace);
//		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "E-mail"));
//
//	}
//
//	@Test
//	public void NC_27_PasswordCanNotBeEmpty() {
//		newCustomerPage.clearPasswordTextbox();
//		newCustomerPage.clickToPasswordTextbox();
//		newCustomerPage.pressTABKeyToPasswordTextbox();
//		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Password"));
//	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
