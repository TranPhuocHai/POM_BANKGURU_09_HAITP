package com.bankguru.customer;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class EditCustomer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editcustomerPage;
	private String loginPageUrl, userIdInfo, passwordInfo, customerID;
	
	private String email = "haitgsdh" + randomNumber() + "@gmail.com";
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
		
		log.info("Precondition: Step 14 - Click to 'New Customer' link");
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

		log.info("Precondition: Step 15 - Input to 'Customer Name' textbox");
		newCustomerPage.inputValueToCustomerNameTextbox(validName);
		
		log.info("Precondition: Step 16 - Select Male gender");
		newCustomerPage.selectMaleGenderRadioButton();
		
		log.info("Precondition: Step 17 - Remove Date Of Birth attribute");
		newCustomerPage.removeDateOfBirthAttribute();
		
		log.info("Precondition: Step 18 - Input to 'Date Of Birth' textbox");
		newCustomerPage.inputValueToDateOfBirthTextbox(validDateOfBirth);
		
		log.info("Precondition: Step 19 - Input to 'Adress' text area");
		newCustomerPage.inputValueToAdressTextArea(validAdress);
		
		log.info("Precondition: Step 20 - Input to 'City' textbox");
		newCustomerPage.inputValueToCityTextbox(validCity);
		
		log.info("Precondition: Step 21 - Input to 'State' textbox");
		newCustomerPage.inputValueToStateTextbox(validState);
		
		log.info("Precondition: Step 22 - Input to 'Pin' textbox");
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
		
		log.info("Precondition: Step 28 - Get 'Customer ID'");
		customerID = newCustomerPage.getTextDynamicInfo(driver, "Customer ID");

		log.info("Precondition: Step 29 - Verify all infor of new customer are correct");
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Customer Name"), validName);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Gender"), expectedGender);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Birthdate"), validDateOfBirth);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Address"), validAdress);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "City"), validCity);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "State"), validState);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Pin"), validPin);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Mobile No."), validPhoneNumber);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Email"), validEmailID);

		log.info("Precondition: Step 30 - Click To 'Edit Customer' link");
		newCustomerPage.openMultiplePage(driver, "Edit Customer");		
		editcustomerPage = PageFactoryManager.getEditCustomerPage(driver);
	}

	@Test
	public void EC_01_CustomerIDCanNotBeEmpty() {
		
		log.info("CustomerIDCanNotBeEmpty: Step 01 - Clear 'Customer ID' textbox");
		editcustomerPage.clearCustomerIDTextbox();
		
		log.info("CustomerIDCanNotBeEmpty: Step 02 - Click to 'Customer ID' textbox");
		editcustomerPage.clickToCustomerIDTexbox();
		
		log.info("CustomerIDCanNotBeEmpty: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToCustomerIDTextbox();
		
		log.info("CustomerIDCanNotBeEmpty: Step 04 - Verify ''Customer ID' is required' message displayed");
		verifyTrue(editcustomerPage.isCustomerIDIsRequiredMessageDisplayed());

	}

	@Test
	public void EC_02_CustomerIDCanNotHaveFirstBlankSpace() {
		
		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 01 - Clear 'Customer ID' textbox");
		editcustomerPage.clearCustomerIDTextbox();
		
		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 02 - Input to 'Customer ID' textbox");
		editcustomerPage.inputValueToCustomerIDTextbox(blankSpace);
		
		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(editcustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "Customer ID"));

	}

	@Test
	public void EC_03_CustomerIDCharacterAreNotAllowed() {
		for (String characterPhoneNumber : characterPhoneNumbers) {
			
			log.info("CustomerIDCharacterAreNotAllowed: Step 01 - 'Customer ID' Number textbox");
			editcustomerPage.clearCustomerIDTextbox();
			
			log.info("CustomerIDCharacterAreNotAllowed: Step 02 - Input to 'Customer ID' textbox");
			editcustomerPage.inputValueToCustomerIDTextbox(characterPhoneNumber);
			
			log.info("CustomerIDCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(editcustomerPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Customer ID"));
		}

	}

	@Test
	public void EC_04_CustomerIDCanNotHaveSpecialCharacters() {
		for (String specialPhoneNumber : specialPhoneNumbers) {
			
			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 01 - 'Customer ID' Number textbox");
			editcustomerPage.clearCustomerIDTextbox();
			
			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 02 - Input to 'Customer ID' textbox");
			editcustomerPage.inputValueToCustomerIDTextbox(specialPhoneNumber);
			
			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(editcustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Customer ID"));
		}
	}

	@Test
	public void EC_05_AddressCanNotBeEmpty() {
		
		log.info("AddressCanNotBeEmpty: Step 01 - 'Customer ID' Number textbox");
		editcustomerPage.clearCustomerIDTextbox();
		
		log.info("AddressCanNotBeEmpty: Step 02 - Input to 'Customer ID' textbox");
		editcustomerPage.inputValueToCustomerIDTextbox(customerID);
		
		log.info("AddressCanNotBeEmpty: Step 03 - Click to 'Customer ID' textbox");
		editcustomerPage.clickToCustomerIDSubmitButton();
		
		log.info("AddressCanNotBeEmpty: Step 04 - Clear 'Address' text area");
		editcustomerPage.clearAddressTextArea();
		
		log.info("AddressCanNotBeEmpty: Step 05 - Click to 'Address' text area");
		editcustomerPage.clickToAddressTextarea();
		
		log.info("AddressCanNotBeEmpty: Step 06 - Press TAB key");
		editcustomerPage.pressTABKeyToAddressTextArea();
		
		log.info("AddressCanNotBeEmpty: Step 07 - Verify 'Address Field must not be blank' message displayed");
		verifyTrue(editcustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Address Field"));

	}

	@Test
	public void EC_06_AdressCanNotHaveSpecialCharacters() {
		for (String specialCharactersAddress : specialCharacters) {
			
			log.info("AdressCanNotHaveSpecialCharacters: Step 01 - Clear 'Address' text area");
			editcustomerPage.clearAddressTextArea();
			
			log.info("AdressCanNotHaveSpecialCharacters: Step 02 - Input to 'Address' text area");
			editcustomerPage.inputValueToAddressTextArea(specialCharactersAddress);
			
			log.info("AdressCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(editcustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Address"));
		}
	}

	@Test
	public void EC_07_AddressCanNotHaveBlankSpace() {
		
		log.info("AddressCanNotHaveBlankSpace: Step 01 - Clear 'Address' text area");
		editcustomerPage.clearAddressTextArea();
		
		log.info("AddressCanNotHaveBlankSpace: Step 02 - Input to 'Address' text area");
		editcustomerPage.inputValueToAddressTextArea(blankSpace);
		
		log.info("AddressCanNotHaveBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(editcustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "Address"));

	}

	@Test
	public void EC_08_CityCanNotBeEmpty() {
		
		log.info("CityCanNotBeEmpty: Step 01 - Clear 'City' textbox");
		editcustomerPage.clearCityTextbox();
		
		log.info("CityCanNotBeEmpty: Step 02 - Click to 'City' textbox");
		editcustomerPage.clickToCityTextbox();
		
		log.info("CityCanNotBeEmpty: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToCityTextbox();
		
		log.info("CityCanNotBeEmpty: Step 04 - Verify 'City Field must not be blank' message displayed");
		verifyTrue(editcustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "City Field"));
	}

	@Test
	public void EC_09_CityCanNotBeNumberic() {
		for (String numericCity : numericValues) {
			
			log.info("CityCanNotBeNumberic: Step 01 - Clear 'City' textbox");
			editcustomerPage.clearCityTextbox();
			
			log.info("CityCanNotBeNumberic: Step 02 - Input to 'City' textbox");
			editcustomerPage.inputValueToCityTextbox(numericCity);
			
			log.info("CityCanNotBeNumberic: Step 03 - Verify 'Numbers are not allowed' message displayed");
			verifyTrue(editcustomerPage.isDynamicNumbersAreNotAllowedMessageDisplayed(driver, "City"));
		}
	}

	@Test
	public void EC_10_CityCanNotHaveSpecialCharacters() {
		for (String specialCharactersCity : specialCharacters) {
			
			log.info("CityCanNotHaveSpecialCharacters: Step 01 - Clear 'City' textbox");
			editcustomerPage.clearCityTextbox();
			
			log.info("CityCanNotHaveSpecialCharacters: Step 02 - Input to 'City' textbox");
			editcustomerPage.inputValueToCityTextbox(specialCharactersCity);
			
			log.info("CityCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(editcustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "City"));
		}
	}

	@Test
	public void EC_11_CityCanNotHaveFirstBlankSpace() {
		
		log.info("CityCanNotHaveFirstBlankSpace: Step 01 - Clear 'City' textbox");
		editcustomerPage.clearCityTextbox();
		
		log.info("CityCanNotHaveFirstBlankSpace: Step 02 - Input to 'City' textbox");
		editcustomerPage.inputValueToCityTextbox(blankSpace);
		
		log.info("CityCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(editcustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "City"));

	}

	@Test
	public void EC_12_StateCanNotBeEmpty() {
		
		log.info("StateCanNotBeEmpty: Step 01 - Clear 'State' textbox");
		editcustomerPage.clearStateTextbox();
		
		log.info("StateCanNotBeEmpty: Step 02 - Click to 'State' textbox");
		editcustomerPage.clickToStateTextbox();
		
		log.info("StateCanNotBeEmpty: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToStateTextbox();
		
		log.info("StateCanNotBeEmpty: Step 04 - Verify 'State must not be blank' message displayed");
		verifyTrue(editcustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "State"));
	}

	@Test
	public void EC_13_StateCanNotBeNumberic() {
		for (String numericState : numericValues) {
			
			log.info("StateCanNotBeNumberic: Step 01 - Clear 'State' textbox");
			editcustomerPage.clearStateTextbox();
			
			log.info("StateCanNotBeNumberic: Step 02 - Input to 'State' textbox");
			editcustomerPage.inputValueToStateTextbox(numericState);
			
			log.info("StateCanNotBeNumberic: Step 03 - Verify 'Numbers are not allowed' message displayed");
			verifyTrue(editcustomerPage.isDynamicNumbersAreNotAllowedMessageDisplayed(driver, "State"));
		}
	}

	@Test
	public void EC_14_StateCanNotHaveSpecialCharacters() {
		for (String specialCharactersState : specialCharacters) {
			
			log.info("StateCanNotHaveSpecialCharacters: Step 01 - Clear 'State' textbox");
			editcustomerPage.clearStateTextbox();
			
			log.info("StateCanNotHaveSpecialCharacters: Step 02 - Input to 'State' textbox");
			editcustomerPage.inputValueToStateTextbox(specialCharactersState);
			
			log.info("StateCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(editcustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "State"));
		}
	}

	@Test
	public void EC_15_StateCanNotHaveFirstBlankSpace() {
		
		log.info("StateCanNotHaveFirstBlankSpace: Step 01 - Clear 'State' textbox");
		editcustomerPage.clearStateTextbox();
		
		log.info("StateCanNotHaveFirstBlankSpace: Step 02 - Input to 'State' textbox");
		editcustomerPage.inputValueToStateTextbox(blankSpace);
		
		log.info("StateCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(editcustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "State"));

	}

	@Test
	public void EC_16_PinCanNotBeEmpty() {
		
		log.info("PinCanNotBeEmpty: Step 01 - Clear 'PIN' textbox");
		editcustomerPage.clearPinTextbox();
		
		log.info("PinCanNotBeEmpty: Step 02 - Click to 'PIN' textbox");
		editcustomerPage.clickToPinTextbox();
		
		log.info("PinCanNotBeEmpty: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToPinTextbox();
		
		log.info("PinCanNotBeEmpty: Step 04 - Verify 'PIN Code must not be blank' message displayed");
		verifyTrue(editcustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "PIN Code"));
	}

	@Test
	public void EC_17_PinMustBeNumeric() {
		for (String characterPIN : characterPINs) {
			
			log.info("PinMustBeNumeric: Step 01 - Clear 'PIN' textbox");
			editcustomerPage.clearPinTextbox();
			
			log.info("PinMustBeNumeric: Step 02 - Input to 'PIN' textbox");
			editcustomerPage.inputValueToPinTextbox(characterPIN);
			
			log.info("PinMustBeNumeric: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(editcustomerPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "PIN"));
		}
	}

	@Test
	public void EC_18_PinMustHave6Degits() {
		for (String lessThan6Digits : lessThan6DigitsList) {
			
			log.info("PinMustHave6Degits: Step 01 - Clear 'PIN' textbox");
			editcustomerPage.clearPinTextbox();
			
			log.info("PinMustHave6Degits: Step 02 - Input to 'PIN' textbox");
			editcustomerPage.inputValueToPinTextbox(lessThan6Digits);
			
			log.info("PinMustHave6Degits: Step 03 - Verify 'PIN Code must have 6 Digits' message displayed");
			verifyTrue(editcustomerPage.isPinMustHave6DegitsMessageDisplayed());
		}
	}

	@Test
	public void EC_19_PinCanNotHaveFirstBlankSpace() {
		
		log.info("PinCanNotHaveFirstBlankSpace: Step 01 - Clear 'PIN' textbox");
		editcustomerPage.clearPinTextbox();
		
		log.info("PinCanNotHaveFirstBlankSpace: Step 02 - Input to 'PIN' textbox");
		editcustomerPage.inputValueToPinTextbox(blankSpace);
		
		log.info("PinCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(editcustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "PIN"));

	}

	@Test
	public void EC_20_MobileNumberCanNotBeEmpty() {
		
		log.info("MobileNumberCanNotBeEmpty: Step 01 - Clear 'Mobile Number' textbox");
		editcustomerPage.clearPhoneTextbox();
		
		log.info("MobileNumberCanNotBeEmpty: Step 02 - Click to 'Mobile Number' textbox");
		editcustomerPage.clickToMobileNumberTextbox();
		
		log.info("MobileNumberCanNotBeEmpty: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToMobileTextbox();
		
		log.info("MobileNumberCanNotBeEmpty: Step 04 - Verify 'Mobile no must not be blank' message displayed");
		verifyTrue(editcustomerPage.isDynamicMustNotBeBlankMessageDisplayed(driver, "Mobile no"));
	}

	@Test
	public void EC_21_MobileNumberCanNotHaveFirstBlankSpace() {
		
		log.info("MobileNumberCanNotHaveFirstBlankSpace: Step 01 - Clear 'Mobile Number' textbox");
		editcustomerPage.clearPhoneTextbox();
		
		log.info("MobileNumberCanNotHaveFirstBlankSpace: Step 02 - Input to 'Mobile Number' textbox");
		editcustomerPage.inputValueToMobileNumberTextbox(blankSpace);
		
		log.info("MobileNumberCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(editcustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "Mobile Number"));

	}

	@Test
	public void EC_22_MobileNumberCharactersAreNotAllowed() {
		for (String characterPhoneNumber : characterPhoneNumbers) {
			
			log.info("MobileNumberCharactersAreNotAllowed: Step 01 - Clear 'Mobile Number' textbox");
			editcustomerPage.clearPhoneTextbox();
			
			log.info("MobileNumberCharactersAreNotAllowed: Step 02 - Input to 'Mobile Number' textbox");
			editcustomerPage.inputValueToMobileNumberTextbox(characterPhoneNumber);
			
			log.info("MobileNumberCharactersAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(editcustomerPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Mobile Number"));
		}

	}

	@Test
	public void EC_23_MobileNumberCanNotHaveSpecialCharacters() {
		for (String specialPhoneNumber : specialPhoneNumbers) {
			
			log.info("MobileNumberCanNotHaveSpecialCharacters: Step 01 - Clear 'Mobile Number' textbox");
			editcustomerPage.clearPhoneTextbox();
			
			log.info("MobileNumberCanNotHaveSpecialCharacters: Step 02 - Input to 'Mobile Number' textbox");
			editcustomerPage.inputValueToMobileNumberTextbox(specialPhoneNumber);
			
			log.info("MobileNumberCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(editcustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Mobile Number"));
		}
	}

	@Test
	public void EC_24_EmailCanNotBeEmpty() {
		
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
	public void EC_25_EmailMustBeInCorrectFormat() {
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
	public void EC_26_EmailCanNotHaveFirstBlankSpace() {
		
		log.info("EmailCanNotHaveFirstBlankSpace: Step 01 - Clear 'Email' textbox");
		newCustomerPage.clearEmailTextbox();
		
		log.info("EmailCanNotHaveFirstBlankSpace: Step 02 - input to 'Email' textbox");
		newCustomerPage.inputValueToEmailTextbox(blankSpace);
		
		log.info("EmailCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(newCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "E-mail"));

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
