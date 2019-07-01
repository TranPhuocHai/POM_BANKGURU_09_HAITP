package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.CommonTestData;
import com.bankguru.user.Common_01_RegisterToSystem;
import com.bankguru.validate.ValidateMessage;

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
	public void EditCustomer_01_CustomerIDCanNotBeEmpty() {

		log.info("EditCustomer_01: Step 01 - Clear 'Customer ID' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

		log.info("EditCustomer_01: Step 02 - Click to 'Customer ID' textbox");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "cusid");

		log.info("EditCustomer_01: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "cusid");

		log.info("EditCustomer_01: Step 04 - Verify 'Customer ID is required' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), "Customer ID is required");

	}

	@Test
	public void EditCustomer_02_CustomerIDCanNotHaveFirstBlankSpace() {

		log.info("EditCustomer_02: Step 01 - Clear 'Customer ID' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

		log.info("EditCustomer_02: Step 02 - Input to 'Customer ID' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", CommonTestData.BLANK_SPACE);

		log.info("EditCustomer_02: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void EditCustomer_03_CustomerIDCharacterAreNotAllowed() {
		for (String charactervalue : CommonTestData.CHARACTER_VALUE) {

			log.info("EditCustomer_03: Step 01 - Customer ID Number textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

			log.info("EditCustomer_03: Step 02 - Input to 'Customer ID' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", charactervalue);

			log.info("EditCustomer_03: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}

	}

	@Test
	public void EditCustomer_04_CustomerIDCanNotHaveSpecialCharacters() {
		for (String specialValue : CommonTestData.SPECIAL_VALUE) {

			log.info("EditCustomer_04: Step 01 - Customer ID Number textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

			log.info("EditCustomer_04: Step 02 - Input to 'Customer ID' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", specialValue);

			log.info("EditCustomer_04: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EditCustomer_05_AddressCanNotBeEmpty() {
		
		log.info("EditCustomer_05: Step 01 - 'Customer ID' Number textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");
		
		log.info("EditCustomer_05: Step 02 - Input to 'Customer ID' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", Common_02_CreateNewCustomer.CUSTOMER_ID);
		
		log.info("EditCustomer_05: Step 03 - Click to 'Submit' button");
		editcustomerPage.clickToDynamicButton(driver, "AccSubmit");
		
		log.info("EditCustomer_05: Step 04 - Verify title 'Edit Customer' displayed");
		verifyTrue(editcustomerPage.isDynamicPageTitleOrMessageDisplayed(driver, "Edit Customer"));
		
		log.info("EditCustomer_05: Step 05 - Clear 'Address' text area");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");
		
		log.info("EditCustomer_05: Step 06 - Click to 'Address' text area");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "addr");
		
		log.info("EditCustomer_05: Step 07 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "addr");
		
		log.info("EditCustomer_05: Step 08 - Verify 'Address Field must not be blank' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Address"), ValidateMessage.ADDRESS_FIELD_MUST_NOT_BE_BLANK);

	}

	@Test
	public void EditCustomer_06_AdressCanNotHaveSpecialCharacters() {
		for (String specialCharactersAddress : CommonTestData.SPECIAL_VALUE) {
			
			log.info("EditCustomer_06: Step 01 - Clear 'Address' text area");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");
			
			log.info("EditCustomer_06: Step 02 - Input to 'Address' text area");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", specialCharactersAddress);
			
			log.info("EditCustomer_06: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Address"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EditCustomer_07_AddressCanNotHaveBlankSpace() {
		
		log.info("EditCustomer_07: Step 01 - Clear 'Address' text area");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");
		
		log.info("EditCustomer_07: Step 02 - Input to 'Address' text area");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", CommonTestData.BLANK_SPACE);
		
		log.info("EditCustomer_07: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Address"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void EditCustomer_08_CityCanNotBeEmpty() {
		
		log.info("EditCustomer_08: Step 01 - Clear 'City' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "city");
		
		log.info("EditCustomer_08: Step 02 - Click to 'City' textbox");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "city");
		
		log.info("EditCustomer_08: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "city");
		
		log.info("EditCustomer_08: Step 04 - Verify 'City Field must not be blank' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "City"), ValidateMessage.CITY_FIELD_MUST_NOT_BE_BLANK);
	}

	@Test
	public void EditCustomer_09_CityCanNotBeNumberic() {
		for (String numericCity : CommonTestData.NUMERIC_VALUES) {
			
			log.info("EditCustomer_09: Step 01 - Clear 'City' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "city");
			
			log.info("EditCustomer_09: Step 02 - Input to 'City' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", numericCity);
			
			log.info("EditCustomer_09: Step 03 - Verify 'Numbers are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "City"), ValidateMessage.NUMBERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EditCustomer_10_CityCanNotHaveSpecialCharacters() {
		for (String specialCharactersCity : CommonTestData.SPECIAL_VALUE) {
			
			log.info("EditCustomer_10: Step 01 - Clear 'City' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "city");
			
			log.info("EditCustomer_10: Step 02 - Input to 'City' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", specialCharactersCity);
			
			log.info("EditCustomer_10: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "City"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EditCustomer_11_CityCanNotHaveBlankSpace() {
		
		log.info("EditCustomer_11: Step 01 - Clear 'City' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "city");
		
		log.info("EditCustomer_11: Step 02 - Input to 'City' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", CommonTestData.BLANK_SPACE);
		
		log.info("EditCustomer_11: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "City"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void EditCustomer_12_StateCanNotBeEmpty() {
		
		log.info("EditCustomer_12: Step 01 - Clear 'State' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "state");
		
		log.info("EditCustomer_12: Step 02 - Click to 'State' textbox");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "state");
		
		log.info("EditCustomer_12: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "state");
		
		log.info("EditCustomer_12: Step 04 - Verify 'State must not be blank' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "State"), ValidateMessage.STATE_MUST_NOT_BE_BLANK);
	}

	@Test
	public void EditCustomer_13_StateCanNotBeNumberic() {
		for (String numericState : CommonTestData.NUMERIC_VALUES) {
			
			log.info("EditCustomer_13: Step 01 - Clear 'State' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "state");
			
			log.info("EditCustomer_13: Step 02 - Input to 'State' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", numericState);
			
			log.info("EditCustomer_13: Step 03 - Verify 'Numbers are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "State"), ValidateMessage.NUMBERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EditCustomer_14_StateCanNotHaveSpecialCharacters() {
		for (String specialCharactersState : CommonTestData.SPECIAL_VALUE) {
			
			log.info("EditCustomer_14: Step 01 - Clear 'State' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "state");
			
			log.info("EditCustomer_14: Step 02 - Input to 'State' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", specialCharactersState);
			
			log.info("EditCustomer_14: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "State"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EditCustomer_15_StateCanNotHaveFirstBlankSpace() {
		
		log.info("EditCustomer_15: Step 01 - Clear 'State' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "state");
		
		log.info("EditCustomer_15: Step 02 - Input to 'State' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", CommonTestData.BLANK_SPACE);
		
		log.info("EditCustomer_15: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "State"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void EditCustomer_16_PinCanNotBeEmpty() {
		
		log.info("EditCustomer_16: Step 01 - Clear 'PIN' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");
		
		log.info("EditCustomer_16: Step 02 - Click to 'PIN' textbox");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "pinno");
		
		log.info("EditCustomer_16: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "pinno");
		
		log.info("EditCustomer_16: Step 04 - Verify 'PIN Code must not be blank' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "PIN"), ValidateMessage.PIN_CODE_MUST_NOT_BE_BLANK);
	}

	@Test
	public void EditCustomer_17_PinMustBeNumeric() {
		for (String characterPIN : CommonTestData.CHARACTER_PIN_VALUE) {
			
			log.info("EditCustomer_17: Step 01 - Clear 'PIN' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");
			
			log.info("EditCustomer_17: Step 02 - Input to 'PIN' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", characterPIN);
			
			log.info("EditCustomer_17: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "PIN"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EditCustomer_18_PinMustHave6Degits() {
		for (String lessThan6Digits : CommonTestData.LESS_THAN_6_DIGITS_PIN_VALUE) {
			
			log.info("EditCustomer_18: Step 01 - Clear 'PIN' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");
			
			log.info("EditCustomer_18: Step 02 - Input to 'PIN' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", lessThan6Digits);
			
			log.info("EditCustomer_18: Step 03 - Verify 'PIN Code must have 6 Digits' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "PIN"), ValidateMessage.PIN_CODE_MUST_HAVE_6_DIGITS);
		}
	}

	@Test
	public void EditCustomer_19_PinCanNotHaveFirstBlankSpace() {
		
		log.info("EditCustomer_19: Step 01 - Clear 'PIN' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");
		
		log.info("EditCustomer_19: Step 02 - Input to 'PIN' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", CommonTestData.BLANK_SPACE);
		
		log.info("EditCustomer_19: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "PIN"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void EditCustomer_20_MobileNumberCanNotBeEmpty() {
		
		log.info("EditCustomer_20: Step 01 - Clear 'Mobile Number' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");
		
		log.info("EditCustomer_20: Step 02 - Click to 'Mobile Number' textbox");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "telephoneno");
		
		log.info("EditCustomer_20: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "telephoneno");
		
		log.info("EditCustomer_20: Step 04 - Verify 'Mobile no must not be blank' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Mobile Number"), ValidateMessage.MOBILE_NO_MUST_NOT_BE_BLANK);
	}

	@Test
	public void EditCustomer_21_MobileNumberCanNotHaveFirstBlankSpace() {
		
		log.info("EditCustomer_21: Step 01 - Clear 'Mobile Number' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");
		
		log.info("EditCustomer_21: Step 02 - Input to 'Mobile Number' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", CommonTestData.BLANK_SPACE);
		
		log.info("EditCustomer_21: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Mobile Number"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void EditCustomer_22_MobileNumberCharactersAreNotAllowed() {
		for (String characterPhoneNumber : CommonTestData.CHARACTER_VALUE) {
			
			log.info("EditCustomer_22: Step 01 - Clear 'Mobile Number' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");
			
			log.info("EditCustomer_22: Step 02 - Input to 'Mobile Number' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", characterPhoneNumber);
			
			log.info("EditCustomer_22: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Mobile Number"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}

	}

	@Test
	public void EditCustomer_23_MobileNumberCanNotHaveSpecialCharacters() {
		for (String specialPhoneNumber : CommonTestData.SPECIAL_VALUE) {
			
			log.info("EditCustomer_23: Step 01 - Clear 'Mobile Number' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");
			
			log.info("EditCustomer_23: Step 02 - Input to 'Mobile Number' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", specialPhoneNumber);
			
			log.info("EditCustomer_23: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "Mobile Number"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void EditCustomer_24_EmailCanNotBeEmpty() {
		
		log.info("EditCustomer_24: Step 01 - Clear 'Email' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");
		
		log.info("EditCustomer_24: Step 02 - Click to 'Email' textbox");
		editcustomerPage.clickToDynamicTextboxOrTextArea(driver, "emailid");
		
		log.info("EditCustomer_24: Step 03 - Press TAB key");
		editcustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "emailid");
		
		log.info("EditCustomer_24: Step 04 - Verify 'Email-ID must not be blank' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "E-mail"), ValidateMessage.EMAIL_ID_MUST_NOT_BE_BLANK);
	}

	@Test
	public void EditCustomer_25_EmailMustBeInCorrectFormat() {
		for (String incorrectEmailID : CommonTestData.INCORRECT_EMAILS) {
			
			log.info("EditCustomer_25: Step 01 - Clear 'Email' textbox");
			editcustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");
			
			log.info("EditCustomer_25: Step 02 - input to 'Email' textbox");
			editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", incorrectEmailID);
			
			log.info("EditCustomer_25: Step 03 - Verify 'Email-ID is not valid' message displayed");
			verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "E-mail"), ValidateMessage.EMAIL_ID_IS_NOT_VALID);
		}
	}

	@Test
	public void EditCustomer_26_EmailCanNotHaveFirstBlankSpace() {
		
		log.info("EditCustomer_26: Step 01 - Clear 'Email' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");
		
		log.info("EditCustomer_26: Step 02 - input to 'Email' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", CommonTestData.BLANK_SPACE);
		
		log.info("EditCustomer_26: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(editcustomerPage.getTextDynamicValidateMessage(driver, "E-mail"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
