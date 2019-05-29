package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.NewCustomerPageUI;
import commons.AbstractPage;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;
	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCustomerNameTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		
	}

	public void pressTabKey() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyBoardToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);
		
	}

	public boolean isCustomerNameMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Customer name");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Customer name");
		
	}

	public void clickToDateOfBirthTexbox() {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		
	}

	public void openNewCustomerPageUrl(String newCustomerPageUrl) {
		openAnyUrl(driver, newCustomerPageUrl);
		
	}

	public void inputValueToCustomerNameTextbox(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, value);
		
	}

	public boolean isNumbersAreNotAllowedMessageOfNameDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_NUMERIC_ARE_NOT_ALLOW_MESSAGE, "Customer Name");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_NUMERIC_ARE_NOT_ALLOW_MESSAGE, "Customer Name");
		
	}

	public boolean isSpecialCharactersOfNameAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Customer Name");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Customer Name");
		
	}

	public boolean isFirstCharacterOfNameCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "Customer Name");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "Customer Name");
		
	}

	public void clickToAddressTextarea() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		clickToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		
	}

	public boolean isAddressFieldMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Address Field");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Address Field");
		
	}

	public void inputValueToAdressTextArea(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, value);
		
	}

	public boolean isSpecialCharactersOfAddressAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Address");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Address");
		
	}

	public boolean isFirstCharacterOfAddressCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "Address");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "Address");
		
	}

	public void clickToCityTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.CITY_TEXTBOX);
		
	}

	public boolean isCityMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "City Field");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "City Field");
		
	}

	public void inputValueToCityTextbox(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, value);
		
	}

	public boolean isNumbersAreNotAllowedMessageOfCityDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_NUMERIC_ARE_NOT_ALLOW_MESSAGE, "City");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_NUMERIC_ARE_NOT_ALLOW_MESSAGE, "City");
		
	}

	public boolean isSpecialCharactersOfCityAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "City");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "City");
		
	}

	public boolean isFirstCharacterOfCityCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "City");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "City");
		
	}
	
	public void clickToStateTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.STATE_TEXTBOX);
		
	}

	public boolean isStateMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "State");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "State");
		
	}

	public void inputValueToStateTextbox(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, value);
		
	}

	public boolean isNumbersAreNotAllowedMessageOfStateDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_NUMERIC_ARE_NOT_ALLOW_MESSAGE, "State");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_NUMERIC_ARE_NOT_ALLOW_MESSAGE, "State");
		
	}

	public boolean isSpecialCharactersOfStateAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "State");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "State");
		
	}

	public boolean isFirstCharacterOfStateCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "State");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "State");
		
	}

	public void clickToPinTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.PIN_TEXTBOX);
		
	}
	
	public boolean isPinMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "PIN Code");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "PIN Code");
		
	}

	public void inputValueToPinTextbox(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, value);
		
	}

	public boolean isPinCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "PIN");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "PIN");
		
	}

	public boolean isPinMustHave6DegitsMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_MUST_HAVE_6_DIGITS_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.PIN_MUST_HAVE_6_DIGITS_MESSAGE);
		
	}

	public boolean isFirstCharacterOfPinCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "PIN");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "PIN");
		
	}

	public void pressTABKeyToCustomerNameTextBox() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyBoardToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);
		
	}

	public void pressTABKeyToAddressTextArea() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyBoardToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, Keys.TAB);	
		
	}

	public void pressTABKeyToCityTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeyBoardToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, Keys.TAB);
		
	}

	public void pressTABKeyToStateTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeyBoardToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, Keys.TAB);
		
	}

	public void pressTABKeyToPinTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeyBoardToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, Keys.TAB);
		
	}

	public void pressTABKeyToMobileTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyBoardToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, Keys.TAB);
		
	}
	
	public void pressTABKeyToEmailTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyBoardToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, Keys.TAB);
		
	}
	
	public void pressTABKeyToPasswordTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendKeyBoardToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, Keys.TAB);
		
	}
	
	public void clickToMobileNumberTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		
	}
	
	public boolean isPhoneMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Mobile no");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Mobile no");
		
	}
	
	public void inputValueToMobileNumberTextbox(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, value);
		
	}

	public boolean isFirstCharacterOfPhoneCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "Mobile Number");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "Mobile Number");
		
	}

	public boolean isPhoneCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Mobile Number" );
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Mobile Number");
		
	}

	public boolean isSpecialCharactersOfPhoneAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Mobile Number");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Mobile Number");
		
	}

	public void clickToEmailTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		
	}

	public boolean isEmailMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Email-ID");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Email-ID");
		
	}

	public void inputValueToEmailTextbox(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, value);
		
	}

	public boolean isEmailIDIsNotValidMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_ID_IS_NOT_VALID_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.EMAIL_ID_IS_NOT_VALID_MESSAGE);
	}

	public boolean isFirstCharacterOfEmailCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "E-mail");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "E-mail");
	}

	public void clickToPasswordTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		
	}

	public boolean isPasswordMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Password");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Password");
	}

	public void selectMaleGenderRadioButton() {
		waitForElementVisible(driver, NewCustomerPageUI.MALE_RADIO_BUTTON);
		checkToCheckBox(driver, NewCustomerPageUI.MALE_RADIO_BUTTON);
		
	}
	
	public void selectFemaleGenderRadioButton() {
		waitForElementVisible(driver, NewCustomerPageUI.FEMALE_RADIO_BUTTON);
		checkToCheckBox(driver, NewCustomerPageUI.FEMALE_RADIO_BUTTON);
		
	}
	
	public void removeDateOfBirthAttribute() {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		removeAttributeInDOM(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, "type");
		
	}

	public void inputValueToDateOfBirthTextbox(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, value);
		
	}


	public void inputValueToPasswordTextbox(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, value);
		
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, AbstractPageUI.SUBMIT_BUTTON);
		clickToElement(driver, AbstractPageUI.SUBMIT_BUTTON);
		
	}

	public boolean isCustomerRegisteredSuccessfullyDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.REGISTER_CUSTOMER_SUCCESS_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.REGISTER_CUSTOMER_SUCCESS_MESSAGE);
		
	}
	
	public String getCustomerID() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_ID);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_ID);
	}


	public void openHomePageUrl(String homePageUrl) {
		openAnyUrl(driver, homePageUrl);
		
	}

	public void clearNameTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		clearTextElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		
	}

	public void clearAddresTextarea() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		clearTextElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		
	}

	public void clearCityTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		clearTextElement(driver, NewCustomerPageUI.CITY_TEXTBOX);
		
	}

	public void clearStateTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		clearTextElement(driver, NewCustomerPageUI.STATE_TEXTBOX);
		
	}

	public void clearPinTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		clearTextElement(driver, NewCustomerPageUI.PIN_TEXTBOX);
		
	}

	public void clearPhoneTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		clearTextElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		
	}

	public void clearEmailTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		clearTextElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		
	}

	public void clearPasswordTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		clearTextElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		
	}


}
