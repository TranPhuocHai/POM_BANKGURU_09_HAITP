package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.user.Common_01_RegisterToSystem;
import com.bankguru.validate.ValidateMessageTestData;

import bankguruPageFactoryManager.PageFactoryManager;
import bankguruPageObjects.EditCustomerPageObject;
import bankguruPageObjects.HomePageObject;
import bankguruPageObjects.LoginPageObject;
import commons.AbstractTest;

public class EditCustomer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private EditCustomerPageObject editcustomerPage;

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

		log.info("Precondition: Step 07 - Click To 'Edit Customer' link");
		homePage.openMultiplePage(driver, "Edit Customer");		
		editcustomerPage = PageFactoryManager.getEditCustomerPage(driver);
	}

	@Test
	public void EC_01_CustomerIDCanNotBeEmpty() {

		log.info("CustomerIDCanNotBeEmpty: Step 01 - Clear 'Customer ID' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotBeEmpty: Step 02 - Click to 'Customer ID' textbox");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotBeEmpty: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotBeEmpty: Step 04 - Verify 'Customer ID is required' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), "Customer ID is required");

	}

	@Test
	public void EC_02_CustomerIDCanNotHaveFirstBlankSpace() {

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 01 - Clear 'Customer ID' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 02 - Input to 'Customer ID' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", CustomerTestData.BLANK_SPACE);

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessageTestData.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void EC_03_CustomerIDCharacterAreNotAllowed() {
		for (String charactervalue : CustomerTestData.CHARACTER_VALUE) {

			log.info("CustomerIDCharacterAreNotAllowed: Step 01 - Customer ID Number textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

			log.info("CustomerIDCharacterAreNotAllowed: Step 02 - Input to 'Customer ID' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", charactervalue);

			log.info("CustomerIDCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessageTestData.CHARACTERS_ARE_NOT_ALLOWED);
		}

	}

	@Test
	public void EC_04_CustomerIDCanNotHaveSpecialCharacters() {
		for (String specialValue : CustomerTestData.SPECIAL_VALUE) {

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 01 - Customer ID Number textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 02 - Input to 'Customer ID' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", specialValue);

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessageTestData.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EC_05_AddressCanNotBeEmpty() {
		
		log.info("AddressCanNotBeEmpty: Step 01 - 'Customer ID' Number textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");
		
		log.info("AddressCanNotBeEmpty: Step 02 - Input to 'Customer ID' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", Common_02_CreateNewCustomer.CUSTOMER_ID);
		
		log.info("AddressCanNotBeEmpty: Step 03 - Click to 'Submit' button");
		editcustomerPage.clickToDynamicButton(driver, "AccSubmit");
		
		log.info("AddressCanNotBeEmpty: Step 04 - Verify title 'Edit Customer' displayed");
		verifyTrue(editcustomerPage.isDynamicPageTitleDisplayed(driver, "Edit Customer"));
		
		log.info("AddressCanNotBeEmpty: Step 05 - Clear 'Address' text area");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");
		
		log.info("AddressCanNotBeEmpty: Step 06 - Click to 'Address' text area");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "addr");
		
		log.info("AddressCanNotBeEmpty: Step 07 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "addr");
		
		log.info("AddressCanNotBeEmpty: Step 08 - Verify 'Address Field must not be blank' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Address"), ValidateMessageTestData.ADDRESS_FIELD_MUST_NOT_BE_BLANK);

	}

	@Test
	public void EC_06_AdressCanNotHaveSpecialCharacters() {
		for (String specialCharactersAddress : CustomerTestData.SPECIAL_VALUE) {
			
			log.info("AdressCanNotHaveSpecialCharacters: Step 01 - Clear 'Address' text area");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");
			
			log.info("AdressCanNotHaveSpecialCharacters: Step 02 - Input to 'Address' text area");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", specialCharactersAddress);
			
			log.info("AdressCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Address"), ValidateMessageTestData.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EC_07_AddressCanNotHaveBlankSpace() {
		
		log.info("AddressCanNotHaveBlankSpace: Step 01 - Clear 'Address' text area");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");
		
		log.info("AddressCanNotHaveBlankSpace: Step 02 - Input to 'Address' text area");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", CustomerTestData.BLANK_SPACE);
		
		log.info("AddressCanNotHaveBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Address"), ValidateMessageTestData.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void EC_08_CityCanNotBeEmpty() {
		
		log.info("CityCanNotBeEmpty: Step 01 - Clear 'City' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "city");
		
		log.info("CityCanNotBeEmpty: Step 02 - Click to 'City' textbox");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "city");
		
		log.info("CityCanNotBeEmpty: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "city");
		
		log.info("CityCanNotBeEmpty: Step 04 - Verify 'City Field must not be blank' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "City"), ValidateMessageTestData.CITY_FIELD_MUST_NOT_BE_BLANK);
	}

	@Test
	public void EC_09_CityCanNotBeNumberic() {
		for (String numericCity : CustomerTestData.NUMERIC_VALUES) {
			
			log.info("CityCanNotBeNumberic: Step 01 - Clear 'City' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "city");
			
			log.info("CityCanNotBeNumberic: Step 02 - Input to 'City' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", numericCity);
			
			log.info("CityCanNotBeNumberic: Step 03 - Verify 'Numbers are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "City"), ValidateMessageTestData.NUMBERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EC_10_CityCanNotHaveSpecialCharacters() {
		for (String specialCharactersCity : CustomerTestData.SPECIAL_VALUE) {
			
			log.info("CityCanNotHaveSpecialCharacters: Step 01 - Clear 'City' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "city");
			
			log.info("CityCanNotHaveSpecialCharacters: Step 02 - Input to 'City' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", specialCharactersCity);
			
			log.info("CityCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "City"), ValidateMessageTestData.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EC_11_CityCanNotHaveBlankSpace() {
		
		log.info("CityCanNotHaveFirstBlankSpace: Step 01 - Clear 'City' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "city");
		
		log.info("CityCanNotHaveFirstBlankSpace: Step 02 - Input to 'City' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", CustomerTestData.BLANK_SPACE);
		
		log.info("CityCanNotHaveBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "City"), ValidateMessageTestData.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void EC_12_StateCanNotBeEmpty() {
		
		log.info("StateCanNotBeEmpty: Step 01 - Clear 'State' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "state");
		
		log.info("StateCanNotBeEmpty: Step 02 - Click to 'State' textbox");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "state");
		
		log.info("StateCanNotBeEmpty: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "state");
		
		log.info("StateCanNotBeEmpty: Step 04 - Verify 'State must not be blank' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "State"), ValidateMessageTestData.STATE_MUST_NOT_BE_BLANK);
	}

	@Test
	public void EC_13_StateCanNotBeNumberic() {
		for (String numericState : CustomerTestData.NUMERIC_VALUES) {
			
			log.info("StateCanNotBeNumberic: Step 01 - Clear 'State' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "state");
			
			log.info("StateCanNotBeNumberic: Step 02 - Input to 'State' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", numericState);
			
			log.info("StateCanNotBeNumberic: Step 03 - Verify 'Numbers are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "State"), ValidateMessageTestData.NUMBERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EC_14_StateCanNotHaveSpecialCharacters() {
		for (String specialCharactersState : CustomerTestData.SPECIAL_VALUE) {
			
			log.info("StateCanNotHaveSpecialCharacters: Step 01 - Clear 'State' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "state");
			
			log.info("StateCanNotHaveSpecialCharacters: Step 02 - Input to 'State' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", specialCharactersState);
			
			log.info("StateCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "State"), ValidateMessageTestData.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EC_15_StateCanNotHaveFirstBlankSpace() {
		
		log.info("StateCanNotHaveFirstBlankSpace: Step 01 - Clear 'State' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "state");
		
		log.info("StateCanNotHaveFirstBlankSpace: Step 02 - Input to 'State' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", CustomerTestData.BLANK_SPACE);
		
		log.info("StateCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "State"), ValidateMessageTestData.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void EC_16_PinCanNotBeEmpty() {
		
		log.info("PinCanNotBeEmpty: Step 01 - Clear 'PIN' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");
		
		log.info("PinCanNotBeEmpty: Step 02 - Click to 'PIN' textbox");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "pinno");
		
		log.info("PinCanNotBeEmpty: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "pinno");
		
		log.info("PinCanNotBeEmpty: Step 04 - Verify 'PIN Code must not be blank' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "PIN"), ValidateMessageTestData.PIN_CODE_MUST_NOT_BE_BLANK);
	}

	@Test
	public void EC_17_PinMustBeNumeric() {
		for (String characterPIN : CustomerTestData.CHARACTER_PIN_VALUE) {
			
			log.info("PinMustBeNumeric: Step 01 - Clear 'PIN' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");
			
			log.info("PinMustBeNumeric: Step 02 - Input to 'PIN' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", characterPIN);
			
			log.info("PinMustBeNumeric: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "PIN"), ValidateMessageTestData.CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EC_18_PinMustHave6Degits() {
		for (String lessThan6Digits : CustomerTestData.LESS_THAN_6_DIGITS_PIN_VALUE) {
			
			log.info("PinMustHave6Degits: Step 01 - Clear 'PIN' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");
			
			log.info("PinMustHave6Degits: Step 02 - Input to 'PIN' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", lessThan6Digits);
			
			log.info("PinMustHave6Degits: Step 03 - Verify 'PIN Code must have 6 Digits' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "PIN"), ValidateMessageTestData.PIN_CODE_MUST_HAVE_6_DIGITS);
		}
	}

	@Test
	public void EC_19_PinCanNotHaveFirstBlankSpace() {
		
		log.info("PinCanNotHaveFirstBlankSpace: Step 01 - Clear 'PIN' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");
		
		log.info("PinCanNotHaveFirstBlankSpace: Step 02 - Input to 'PIN' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", CustomerTestData.BLANK_SPACE);
		
		log.info("PinCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "PIN"), ValidateMessageTestData.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void EC_20_MobileNumberCanNotBeEmpty() {
		
		log.info("MobileNumberCanNotBeEmpty: Step 01 - Clear 'Mobile Number' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");
		
		log.info("MobileNumberCanNotBeEmpty: Step 02 - Click to 'Mobile Number' textbox");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "telephoneno");
		
		log.info("MobileNumberCanNotBeEmpty: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "telephoneno");
		
		log.info("MobileNumberCanNotBeEmpty: Step 04 - Verify 'Mobile no must not be blank' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Mobile Number"), ValidateMessageTestData.MOBILE_NO_MUST_NOT_BE_BLANK);
	}

	@Test
	public void EC_21_MobileNumberCanNotHaveFirstBlankSpace() {
		
		log.info("MobileNumberCanNotHaveFirstBlankSpace: Step 01 - Clear 'Mobile Number' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");
		
		log.info("MobileNumberCanNotHaveFirstBlankSpace: Step 02 - Input to 'Mobile Number' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", CustomerTestData.BLANK_SPACE);
		
		log.info("MobileNumberCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Mobile Number"), ValidateMessageTestData.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void EC_22_MobileNumberCharactersAreNotAllowed() {
		for (String characterPhoneNumber : CustomerTestData.CHARACTER_VALUE) {
			
			log.info("MobileNumberCharactersAreNotAllowed: Step 01 - Clear 'Mobile Number' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");
			
			log.info("MobileNumberCharactersAreNotAllowed: Step 02 - Input to 'Mobile Number' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", characterPhoneNumber);
			
			log.info("MobileNumberCharactersAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Mobile Number"), ValidateMessageTestData.CHARACTERS_ARE_NOT_ALLOWED);
		}

	}

	@Test
	public void EC_23_MobileNumberCanNotHaveSpecialCharacters() {
		for (String specialPhoneNumber : CustomerTestData.SPECIAL_VALUE) {
			
			log.info("MobileNumberCanNotHaveSpecialCharacters: Step 01 - Clear 'Mobile Number' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");
			
			log.info("MobileNumberCanNotHaveSpecialCharacters: Step 02 - Input to 'Mobile Number' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", specialPhoneNumber);
			
			log.info("MobileNumberCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Mobile Number"), ValidateMessageTestData.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EC_24_EmailCanNotBeEmpty() {
		
		log.info("EmailCanNotBeEmpty: Step 01 - Clear 'Email' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");
		
		log.info("EmailCanNotBeEmpty: Step 02 - Click to 'Email' textbox");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "emailid");
		
		log.info("EmailCanNotBeEmpty: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "emailid");
		
		log.info("EmailCanNotBeEmpty: Step 04 - Verify 'Email-ID must not be blank' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "E-mail"), ValidateMessageTestData.EMAIL_ID_MUST_NOT_BE_BLANK);
	}

	@Test
	public void EC_25_EmailMustBeInCorrectFormat() {
		for (String incorrectEmailID : CustomerTestData.INCORRECT_EMAILS) {
			
			log.info("EmailMustBeInCorrectFormat: Step 01 - Clear 'Email' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");
			
			log.info("EmailMustBeInCorrectFormat: Step 02 - input to 'Email' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", incorrectEmailID);
			
			log.info("EmailMustBeInCorrectFormat: Step 03 - Verify 'Email-ID is not valid' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "E-mail"), ValidateMessageTestData.EMAIL_ID_IS_NOT_VALID);
		}
	}

	@Test
	public void EC_26_EmailCanNotHaveFirstBlankSpace() {
		
		log.info("EmailCanNotHaveFirstBlankSpace: Step 01 - Clear 'Email' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");
		
		log.info("EmailCanNotHaveFirstBlankSpace: Step 02 - input to 'Email' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", CustomerTestData.BLANK_SPACE);
		
		log.info("EmailCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "E-mail"), ValidateMessageTestData.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
