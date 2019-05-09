package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguru.NewCustomerPageUI;
import commons.AbstractPage;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;
	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getNewCustomerPageUrl() {
		return getCurrentPageUrl(driver);
		
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
		waitForElementVisible(driver, NewCustomerPageUI.NAME_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.NAME_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void clickToDateOfBirthTexbox() {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		
	}

	public void openNewCustomerPageUrl(String newCustomerPageUrl) {
		openAnyUrl(driver, newCustomerPageUrl);
		
	}

	public void inputNumericValueToCustomerNameTextbox(String numericName) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, numericName);
		
	}

	public boolean isNumbersAreNotAllowedMessageOfNameDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.NAME_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.NAME_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputSpecialCharactersToCustomerNameTextbox(String specialChracterName) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, specialChracterName);
		
	}

	public boolean isSpecialCharactersOfNameAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.NAME_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.NAME_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputBlankSpaceToCustomerNameTextbox(String blankSpace) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfNameCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.NAME_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.NAME_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}

	public void clickToAddressTextarea() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		clickToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		
	}

	public boolean isAddressFieldMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_FIELD_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.ADDRESS_FIELD_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputSpecialCharactersToAdressTextArea(String specialCharactersAddress) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, specialCharactersAddress);
		
	}

	public boolean isSpecialCharactersOfAddressAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.ADDRESS_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputBlankSpaceToAdressTextArea(String blankSpace) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, blankSpace);
		
	}

	public boolean isFirstCharacterOfAddressCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.ADDRESS_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}

	public void clickToCityTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.CITY_TEXTBOX);
		
	}

	public boolean isCityMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.CITY_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputNumericValueToCityTextbox(String numericCity) {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, numericCity);
		
	}

	public boolean isNumbersAreNotAllowedMessageOfCityDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.CITY_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputSpecialCharactersToCityTextbox(String specialCharactersCity) {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, specialCharactersCity);
		
	}

	public boolean isSpecialCharactersOfCityAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.CITY_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputBlankSpaceToCityTextbox(String blankSpace) {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfCityCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.CITY_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}
	
	public void clickToStateTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.STATE_TEXTBOX);
		
	}

	public boolean isStateMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.STATE_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputNumericValueToStateTextbox(String numericState) {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, numericState);
		
	}

	public boolean isNumbersAreNotAllowedMessageOfStateDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.STATE_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputSpecialCharactersToStateTextbox(String specialCharactersState) {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, specialCharactersState);
		
	}

	public boolean isSpecialCharactersOfStateAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.STATE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputBlankSpaceToStateTextbox(String blankSpace) {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfStateCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.STATE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}

	public void clickToPinTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.PIN_TEXTBOX);
		
	}
	
	public boolean isPinMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.PIN_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputChractersValueToPinTextbox(String characterPIN) {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, characterPIN);
		
	}

	public boolean isPinCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.PIN_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputLessThan6DigitsToPinTextbox(String lessThan6Digits) {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, lessThan6Digits);
		
	}

	public boolean isPinMustHave6DegitsMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_MUST_HAVE_6_DIGITS_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.PIN_MUST_HAVE_6_DIGITS_MESSAGE);
		
	}

	public void inputBlankSpaceToPinTextbox(String blankSpace) {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfPinCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.PIN_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
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
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.PHONE_MUST_NOT_BE_BLANK_MESSAGE);
		
	}
	
	public void inputBlankSpaceToMobileNumberTextbox(String blankSpace) {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfPhoneCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.PHONE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}
	
	public void inputChractersValueToMobileNumberTextbox(String characterPhoneNumber) {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, characterPhoneNumber);
		
	}

	public boolean isPhoneCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.PHONE_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}
	
	public void inputSpecialCharactersToMobileNumberTextbox(String specialCharactersPhone) {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, specialCharactersPhone);
		
	}

	public boolean isSpecialCharactersOfPhoneAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.PHONE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void clickToEmailTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		
	}

	public boolean isEmailMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.EMAIL_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputIncorrectEmailIDToEmailTextbox(String incorrectEmailID) {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, incorrectEmailID);
		
	}

	public boolean isEmailIDIsNotValidMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_ID_IS_NOT_VALID_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.EMAIL_ID_IS_NOT_VALID_MESSAGE);
	}

	public void inputBlankSpaceToEmailTextbox(String blankSpace) {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfEmailCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.EMAIL_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
	}

	public void clickToPasswordTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		
	}

	public boolean isPasswordMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.PASSWORD_MUST_NOT_BE_BLANK_MESSAGE);
	}

	
	public void inputValidDataToCustomerNameTextbox(String validName) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, validName);
		
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

	public void inputValidDataToDateOfBirthTextbox(String validDateOfBirth) {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, validDateOfBirth);
		
	}

	public void inputValidDataToAdressTextArea(String validAdress) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, validAdress);
		
	}

	public void inputValidDataToCityTextbox(String validCity) {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, validCity);
		
	}

	public void inputValidDataToStateTextbox(String validState) {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, validState);
		
	}

	public void inputValidDataToPinTextbox(String validPin) {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, validPin);
		
	}

	public void inputValidDataToMobileNumberTextbox(String validPhoneNumber) {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.MOBILE_NUMBER_TEXTBOX, validPhoneNumber);
		
	}

	public void inputValidDataToEmailTextbox(String validEmailID) {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, validEmailID);
		
	}

	public void inputValidDataToPasswordTextbox(String validPassword) {
		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, validPassword);
		
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		
	}

	public boolean isCustomerRegisteredSuccessfullyDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.REGISTER_CUSTOMER_SUCCESS_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.REGISTER_CUSTOMER_SUCCESS_MESSAGE);
		
	}
	
	public String getCustomerID() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_ID);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_ID);
	}

	public String getTextCustomerNameInfo() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_INFOR);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_NAME_INFOR);
	}

	public String getTextGenderInfo() {
		waitForElementVisible(driver, NewCustomerPageUI.GENDER_INFOR);
		return getTextElement(driver, NewCustomerPageUI.GENDER_INFOR);
	}

	public String getDateOfBirthInfo() {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_INFO_INFOR);
		return getTextElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_INFO_INFOR);
	}

	public String getTextAdressInfo() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_INFOR);
		return getTextElement(driver, NewCustomerPageUI.ADDRESS_INFOR);
	}

	public String getTextCityInfo() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_INFOR);
		return getTextElement(driver, NewCustomerPageUI.CITY_INFOR);
	}

	public String getTextStateInfo() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_INFOR);
		return getTextElement(driver, NewCustomerPageUI.STATE_INFOR);
	}

	public String getTextPinInfo() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_INFOR);
		return getTextElement(driver, NewCustomerPageUI.PIN_INFOR);
	}

	public String getTextMobileNumberInfo() {
		waitForElementVisible(driver, NewCustomerPageUI.MOBILE_NUMBER_INFOR);
		return getTextElement(driver, NewCustomerPageUI.MOBILE_NUMBER_INFOR);
	}

	public String getTextEmailInfo() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_INFOR);
		return getTextElement(driver, NewCustomerPageUI.EMAIL_INFOR);
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

	public void clickToEditCustomerLink() {
		waitForElementVisible(driver, NewCustomerPageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, NewCustomerPageUI.EDIT_CUSTOMER_LINK);
	}









	

}
