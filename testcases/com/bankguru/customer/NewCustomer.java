package com.bankguru.customer;

import java.util.Random;

import org.openqa.selenium.WebDriver;
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
	
	private String email = "haimrtvknghbv" + randomNumber() + "@gmail.com";
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
		
		log.info("Precondition: Step 11 - Input to userID and 'Password' textboxes");
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
		
		log.info("NameCanNotBeEmpty: Step 01 - Click to 'Customer Name' textbox");
		newCustomerPage.clickToCustomerNameTextbox();
		
		log.info("NameCanNotBeEmpty: Step 02 - Press TAB key");
		newCustomerPage.pressTABKeyToCustomerNameTextBox();
		
		log.info("NameCanNotBeEmpty: Step 03 - Verify 'Customer name must not be blank' message displayed");
		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Customer name"));
	}

	@Test
	public void NC_02_NameCanNotBeNumberic() {
		for (String numericName : numericValues) {
			
			log.info("NameCanNotBeNumeric: Step 01 - Clear 'Customer Name' textbox");
			newCustomerPage.clearNameTextbox();
			
			log.info("NameCanNotBeNumeric: Step 02 - Input to 'Customer Name' textbox");
			newCustomerPage.inputValueToCustomerNameTextbox(numericName);
			
			log.info("NameCanNotBeNumeric: Step 03 - Verify 'Numbers are not allowed' message displayed");
			verifyTrue(newCustomerPage.isDynamicNumbersAreNotAllowedMessageDisplayed(driver, "Customer Name"));
			
		}
	}

	@Test
	public void NC_03_NameCanNotHaveSpecialCharacters() {
		for (String specialCharactersName : specialCharacters) {
			
			log.info("NameCanNotHaveSpecialCharacters: Step 01 - Clear 'Customer Name' textbox");
			newCustomerPage.clearNameTextbox();
			
			log.info("NameCanNotHaveSpecialCharacters: Step 02 - Input to 'Customer Name' textbox");
			newCustomerPage.inputValueToCustomerNameTextbox(specialCharactersName);
			
			log.info("NameCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(newCustomerPage.isSpecialCharactersOfNameAreNotAllowedMessageDisplayed());
		}
	}

	@Test
	public void NC_04_NameCanNotHaveFirstBlankSpace() {		
		
		log.info("NameCanNotHaveFirstBlankSpace: Step 01 - Clear 'Customer Name' textbox");
		newCustomerPage.clearNameTextbox();
		
		log.info("NameCanNotHaveFirstBlankSpace: Step 02 - Input to 'Customer Name' textbox");
		newCustomerPage.inputValueToCustomerNameTextbox(blankSpace);
		
		log.info("NameCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "Customer Name"));

	}

	@Test
	public void NC_05_AddressCanNotBeEmpty() {
		
		log.info("AddressCanNotBeEmpty: Step 01 - Clear 'Address' text area");
		newCustomerPage.clearAddresTextArea();
		
		log.info("AddressCanNotBeEmpty: Step 02 - Click to 'Address' text area");
		newCustomerPage.clickToAddressTextArea();
		
		log.info("AddressCanNotBeEmpty: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToAddressTextArea();
		
		log.info("AddressCanNotBeEmpty: Step 04 - Verify 'Address Field must not be blank' message displayed");
		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Address Field"));

	}

	@Test
	public void NC_06_AdressCanNotHaveSpecialCharacters() {
		for (String specialCharactersAddress : specialCharacters) {
			
			log.info("AdressCanNotHaveSpecialCharacters: Step 01 - Clear 'Address' text area");
			newCustomerPage.clearAddresTextArea();
			
			log.info("AdressCanNotHaveSpecialCharacters: Step 02 - Input to 'Address' text area");
			newCustomerPage.inputValueToAdressTextArea(specialCharactersAddress);
			
			log.info("AdressCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(newCustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Address"));
		}
	}

	@Test
	public void NC_07_AddressCanNotHaveBlankSpace() {
		
		log.info("AddressCanNotHaveBlankSpace: Step 01 - Clear 'Address' text area");
		newCustomerPage.clearAddresTextArea();
		
		log.info("AddressCanNotHaveBlankSpace: Step 02 - Input to 'Address' text area");
		newCustomerPage.inputValueToAdressTextArea(blankSpace);
		
		log.info("AddressCanNotHaveBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "Address"));

	}

	@Test
	public void NC_08_CityCanNotBeEmpty() {
		
		log.info("CityCanNotBeEmpty: Step 01 - Clear 'City' textbox");
		newCustomerPage.clearCityTextbox();
		
		log.info("CityCanNotBeEmpty: Step 02 - Click to 'City' textbox");
		newCustomerPage.clickToCityTextbox();
		
		log.info("CityCanNotBeEmpty: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToCityTextbox();
		
		log.info("CityCanNotBeEmpty: Step 04 - Verify 'City Field must not be blank' message displayed");
		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "City Field"));
	}

	@Test
	public void NC_09_CityCanNotBeNumberic() {
		for (String numericCity : numericValues) {
			
			log.info("CityCanNotBeNumberic: Step 01 - Clear 'City' textbox");
			newCustomerPage.clearCityTextbox();
			
			log.info("CityCanNotBeNumberic: Step 02 - Input to 'City' textbox");
			newCustomerPage.inputValueToCityTextbox(numericCity);
			
			log.info("CityCanNotBeNumberic: Step 03 - Verify 'Numbers are not allowed' message displayed");
			verifyTrue(newCustomerPage.isDynamicNumbersAreNotAllowedMessageDisplayed(driver, "City"));
		}
	}

	@Test
	public void NC_10_CityCanNotHaveSpecialCharacters() {
		for (String specialCharactersCity : specialCharacters) {
			
			log.info("CityCanNotHaveSpecialCharacters: Step 01 - Clear 'City' textbox");
			newCustomerPage.clearCityTextbox();
			
			log.info("CityCanNotHaveSpecialCharacters: Step 02 - Input to 'City' textbox");
			newCustomerPage.inputValueToCityTextbox(specialCharactersCity);
			
			log.info("CityCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(newCustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "City"));
		}
	}

	@Test
	public void NC_11_CityCanNotHaveFirstBlankSpace() {
		
		log.info("CityCanNotHaveFirstBlankSpace: Step 01 - Clear 'City' textbox");
		newCustomerPage.clearCityTextbox();
		
		log.info("CityCanNotHaveFirstBlankSpace: Step 02 - Input to 'City' textbox");
		newCustomerPage.inputValueToCityTextbox(blankSpace);
		
		log.info("CityCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "City"));

	}

	@Test
	public void NC_12_StateCanNotBeEmpty() {
		
		log.info("StateCanNotBeEmpty: Step 01 - Clear 'State' textbox");
		newCustomerPage.clearStateTextbox();
		
		log.info("StateCanNotBeEmpty: Step 02 - Click to 'State' textbox");
		newCustomerPage.clickToStateTextbox();
		
		log.info("StateCanNotBeEmpty: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToStateTextbox();
		
		log.info("StateCanNotBeEmpty: Step 04 - Verify 'State must not be blank' message displayed");
		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "State"));
	}

	@Test
	public void NC_13_StateCanNotBeNumberic() {
		for (String numericState : numericValues) {
			
			log.info("StateCanNotBeNumberic: Step 01 - Clear 'State' textbox");
			newCustomerPage.clearStateTextbox();
			
			log.info("StateCanNotBeNumberic: Step 02 - Input to 'State' textbox");
			newCustomerPage.inputValueToStateTextbox(numericState);
			
			log.info("StateCanNotBeNumberic: Step 03 - Verify 'Numbers are not allowed' message displayed");
			verifyTrue(newCustomerPage.isDynamicNumbersAreNotAllowedMessageDisplayed(driver, "State"));
		}
	}

	@Test
	public void NC_14_StateCanNotHaveSpecialCharacters() {
		for (String specialCharactersState : specialCharacters) {
			
			log.info("StateCanNotHaveSpecialCharacters: Step 01 - Clear 'State' textbox");
			newCustomerPage.clearStateTextbox();
			
			log.info("StateCanNotHaveSpecialCharacters: Step 02 - Input to 'State' textbox");
			newCustomerPage.inputValueToStateTextbox(specialCharactersState);
			
			log.info("StateCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(newCustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "State"));
		}
	}

	@Test
	public void NC_15_StateCanNotHaveFirstBlankSpace() {
		
		log.info("StateCanNotHaveFirstBlankSpace: Step 01 - Clear 'State' textbox");
		newCustomerPage.clearStateTextbox();
		
		log.info("StateCanNotHaveFirstBlankSpace: Step 02 - Input to 'State' textbox");
		newCustomerPage.inputValueToStateTextbox(blankSpace);
		
		log.info("StateCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "State"));

	}

	@Test
	public void NC_16_PinCanNotBeEmpty() {
		
		log.info("PinCanNotBeEmpty: Step 01 - Clear 'PIN' textbox");
		newCustomerPage.clearPinTextbox();
		
		log.info("PinCanNotBeEmpty: Step 02 - Click to 'PIN' textbox");
		newCustomerPage.clickToPinTextbox();
		
		log.info("PinCanNotBeEmpty: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToPinTextbox();
		
		log.info("PinCanNotBeEmpty: Step 04 - Verify 'PIN Code must not be blank' message displayed");
		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "PIN Code"));
	}

	@Test
	public void NC_17_PinMustBeNumeric() {
		for (String characterPIN : characterPINs) {
			
			log.info("PinMustBeNumeric: Step 01 - Clear 'PIN' textbox");
			newCustomerPage.clearPinTextbox();
			
			log.info("PinMustBeNumeric: Step 02 - Input to 'PIN' textbox");
			newCustomerPage.inputValueToPinTextbox(characterPIN);
			
			log.info("PinMustBeNumeric: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(newCustomerPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "PIN"));
		}
	}

	@Test
	public void NC_18_PinMustHave6Degits() {
		for (String lessThan6Digits : lessThan6DigitsList) {
			
			log.info("PinMustHave6Degits: Step 01 - Clear 'PIN' textbox");
			newCustomerPage.clearPinTextbox();
			
			log.info("PinMustHave6Degits: Step 02 - Input to 'PIN' textbox");
			newCustomerPage.inputValueToPinTextbox(lessThan6Digits);
			
			log.info("PinMustHave6Degits: Step 03 - Verify 'PIN Code must have 6 Digits' message displayed");
			verifyTrue(newCustomerPage.isPinMustHave6DegitsMessageDisplayed());
		}
	}

	@Test
	public void NC_19_PinCanNotHaveFirstBlankSpace() {
		
		log.info("PinCanNotHaveFirstBlankSpace: Step 01 - Clear 'PIN' textbox");
		newCustomerPage.clearPinTextbox();
		
		log.info("PinCanNotHaveFirstBlankSpace: Step 02 - Input to 'PIN' textbox");
		newCustomerPage.inputValueToPinTextbox(blankSpace);
		
		log.info("PinCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "PIN"));

	}

	@Test
	public void NC_20_MobileNumberCanNotBeEmpty() {
		
		log.info("MobileNumberCanNotBeEmpty: Step 01 - Clear 'Mobile Number' textbox");
		newCustomerPage.clearPhoneTextbox();
		
		log.info("MobileNumberCanNotBeEmpty: Step 02 - Click to 'Mobile Number' textbox");
		newCustomerPage.clickToMobileNumberTextbox();
		
		log.info("MobileNumberCanNotBeEmpty: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToMobileTextbox();
		
		log.info("MobileNumberCanNotBeEmpty: Step 04 - Verify 'Mobile no must not be blank' message displayed");
		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Mobile no"));
	}

	@Test
	public void NC_21_MobileNumberCanNotHaveFirstBlankSpace() {
		
		log.info("MobileNumberCanNotHaveFirstBlankSpace: Step 01 - Clear 'Mobile Number' textbox");
		newCustomerPage.clearPhoneTextbox();
		
		log.info("MobileNumberCanNotHaveFirstBlankSpace: Step 02 - Input to 'Mobile Number' textbox");
		newCustomerPage.inputValueToMobileNumberTextbox(blankSpace);
		
		log.info("MobileNumberCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "Mobile Number"));

	}

	@Test
	public void NC_22_MobileNumberCharactersAreNotAllowed() {
		for (String characterPhoneNumber : characterPhoneNumbers) {
			
			log.info("MobileNumberCharactersAreNotAllowed: Step 01 - Clear 'Mobile Number' textbox");
			newCustomerPage.clearPhoneTextbox();
			
			log.info("MobileNumberCharactersAreNotAllowed: Step 02 - Input to 'Mobile Number' textbox");
			newCustomerPage.inputValueToMobileNumberTextbox(characterPhoneNumber);
			
			log.info("MobileNumberCharactersAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(newCustomerPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Mobile Number"));
		}

	}

	@Test
	public void NC_23_MobileNumberCanNotHaveSpecialCharacters() {
		for (String specialPhoneNumber : specialPhoneNumbers) {
			
			log.info("MobileNumberCanNotHaveSpecialCharacters: Step 01 - Clear 'Mobile Number' textbox");
			newCustomerPage.clearPhoneTextbox();
			
			log.info("MobileNumberCanNotHaveSpecialCharacters: Step 02 - Input to 'Mobile Number' textbox");
			newCustomerPage.inputValueToMobileNumberTextbox(specialPhoneNumber);
			
			log.info("MobileNumberCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(newCustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Mobile Number"));
		}
	}

	@Test
	public void NC_24_EmailCanNotBeEmpty() {
		
		log.info("EmailCanNotBeEmpty: Step 01 - Clear 'Email' textbox");
		newCustomerPage.clearEmailTextbox();
		
		log.info("EmailCanNotBeEmpty: Step 02 - Click to 'Email' textbox");
		newCustomerPage.clickToEmailTextbox();
		
		log.info("EmailCanNotBeEmpty: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToEmailTextbox();
		
		log.info("EmailCanNotBeEmpty: Step 04 - Verify 'Email-ID must not be blank' message displayed");
		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Email-ID"));
	}

	@Test
	public void NC_25_EmailMustBeInCorrectFormat() {
		for (String incorrectEmailID : incorrectEmailIDList) {
			
			log.info("EmailMustBeInCorrectFormat: Step 01 - Clear 'Email' textbox");
			newCustomerPage.clearEmailTextbox();
			
			log.info("EmailMustBeInCorrectFormat: Step 02 - input to 'Email' textbox");
			newCustomerPage.inputValueToEmailTextbox(incorrectEmailID);
			
			log.info("EmailMustBeInCorrectFormat: Step 03 - Verify 'Email-ID is not valid' message displayed");
			verifyTrue(newCustomerPage.isEmailIDIsNotValidMessageDisplayed());
		}
	}

	@Test
	public void NC_26_EmailCanNotHaveFirstBlankSpace() {
		
		log.info("EmailCanNotHaveFirstBlankSpace: Step 01 - Clear 'Email' textbox");
		newCustomerPage.clearEmailTextbox();
		
		log.info("EmailCanNotHaveFirstBlankSpace: Step 02 - input to 'Email' textbox");
		newCustomerPage.inputValueToEmailTextbox(blankSpace);
		
		log.info("EmailCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "E-mail"));

	}

	@Test
	public void NC_27_PasswordCanNotBeEmpty() {
		
		log.info("PasswordCanNotBeEmpty: Step 01 - Clear 'Password' textbox");
		newCustomerPage.clearPasswordTextbox();
		
		log.info("PasswordCanNotBeEmpty: Step 02 - Click to 'Password' textbox");
		newCustomerPage.clickToPasswordTextbox();
		
		log.info("PasswordCanNotBeEmpty: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToPasswordTextbox();
		
		log.info("PasswordCanNotBeEmpty: Step 04 - Verify 'Password must not be blank' message displayed");
		verifyTrue(newCustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Password"));
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
