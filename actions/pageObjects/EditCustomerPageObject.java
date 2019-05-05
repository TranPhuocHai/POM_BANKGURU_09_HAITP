package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguru.EditCustomerPageUI;
import bankguru.NewCustomerPageUI;
import commons.AbstractPage;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driver;
	public EditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}



	public void clickToAddressTextarea() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA);
		clickToElement(driver, EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA);
		
	}

	public boolean isAddressFieldMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_ADDRESS_FIELD_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_ADDRESS_FIELD_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputSpecialCharactersToAdressTextArea(String specialCharactersAddress) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA, specialCharactersAddress);
		
	}

	public boolean isSpecialCharactersOfAddressAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_ADDRESS_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_ADDRESS_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputBlankSpaceToAdressTextArea(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA, blankSpace);
		
	}

	public boolean isFirstCharacterOfAddressCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_ADDRESS_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_ADDRESS_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}

	public void clickToCityTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX);
		
	}

	public boolean isCityMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CITY_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_CITY_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputNumericValueToCityTextbox(String numericCity) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX, numericCity);
		
	}

	public boolean isNumbersAreNotAllowedMessageOfCityDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CITY_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_CITY_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputSpecialCharactersToCityTextbox(String specialCharactersCity) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX, specialCharactersCity);
		
	}

	public boolean isSpecialCharactersOfCityAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CITY_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_CITY_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputBlankSpaceToCityTextbox(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfCityCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CITY_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_CITY_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}
	
	public void inputValidDataTo() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX);
		
	}

	public boolean isStateMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_STATE_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputNumericValueToStateTextbox(String numericState) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX, numericState);
		
	}

	public boolean isNumbersAreNotAllowedMessageOfStateDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_STATE_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputSpecialCharactersToStateTextbox(String specialCharactersState) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX, specialCharactersState);
		
	}

	public boolean isSpecialCharactersOfStateAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_STATE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputBlankSpaceToStateTextbox(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfStateCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_STATE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}

	public void clickToPinTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX);
		
	}
	
	public boolean isPinMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PIN_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_PIN_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputChractersValueToPinTextbox(String characterPIN) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX, characterPIN);
		
	}

	public boolean isPinCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PIN_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_PIN_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputLessThan6DigitsToPinTextbox(String lessThan6Digits) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX, lessThan6Digits);
		
	}

	public boolean isPinMustHave6DegitsMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PIN_MUST_HAVE_6_DIGITS_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_PIN_MUST_HAVE_6_DIGITS_MESSAGE);
		
	}

	public void inputBlankSpaceToPinTextbox(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfPinCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PIN_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_PIN_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}

	public void pressTABKeyToAddressTextArea() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA);
		sendKeyBoardToElement(driver, EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA, Keys.TAB);	
		
	}

	public void pressTABKeyToCityTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX);
		sendKeyBoardToElement(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX, Keys.TAB);
		
	}

	public void pressTABKeyToStateTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX);
		sendKeyBoardToElement(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX, Keys.TAB);
		
	}

	public void pressTABKeyToPinTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX);
		sendKeyBoardToElement(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX, Keys.TAB);
		
	}

	public void pressTABKeyToMobileTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX);
		sendKeyBoardToElement(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX, Keys.TAB);
		
	}
	
	public void pressTABKeyToEmailTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_EMAIL_TEXTBOX);
		sendKeyBoardToElement(driver, EditCustomerPageUI.EDIT_EMAIL_TEXTBOX, Keys.TAB);
		
	}
	
	public void clickToMobileNumberTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX);
		
	}
	
	public boolean isPhoneMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PHONE_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_PHONE_MUST_NOT_BE_BLANK_MESSAGE);
		
	}
	
	public void inputBlankSpaceToMobileNumberTextbox(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfPhoneCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PHONE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_PHONE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}
	
	public void inputChractersValueToMobileNumberTextbox(String characterPhoneNumber) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX, characterPhoneNumber);
		
	}

	public boolean isPhoneCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PHONE_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_PHONE_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}
	
	public void inputSpecialCharactersToMobileNumberTextbox(String specialCharactersPhone) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX, specialCharactersPhone);
		
	}

	public boolean isSpecialCharactersOfPhoneAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PHONE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_PHONE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void clickToEmailTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_EMAIL_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.EDIT_EMAIL_TEXTBOX);
		
	}

	public boolean isEmailMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_EMAIL_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_EMAIL_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputIncorrectEmailIDToEmailTextbox(String incorrectEmailID) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_EMAIL_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_EMAIL_TEXTBOX, incorrectEmailID);
		
	}

	public boolean isEmailIDIsNotValidMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_EMAIL_ID_IS_NOT_VALID_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_EMAIL_ID_IS_NOT_VALID_MESSAGE);
	}

	public void inputBlankSpaceToEmailTextbox(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_EMAIL_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_EMAIL_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfEmailCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_EMAIL_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_EMAIL_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
	}


	public void inputValidDataToAdressTextArea(String validAdress) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA, validAdress);
		
	}

	public void inputValidDataToCityTextbox(String validCity) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX, validCity);
		
	}

	public void inputValidDataToStateTextbox(String validState) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX, validState);
		
	}

	public void inputValidDataToPinTextbox(String validPin) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX, validPin);
		
	}

	public void inputValidDataToMobileNumberTextbox(String validPhoneNumber) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX, validPhoneNumber);
		
	}

	public void inputValidDataToEmailTextbox(String validEmailID) {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_EMAIL_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EDIT_EMAIL_TEXTBOX, validEmailID);
		
	}

	public void clickToEditSubmitButton() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerPageUI.EDIT_SUBMIT_BUTTON);
		
	}



	public void clearAdressTextArea() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA);
		clearTextElement(driver, EditCustomerPageUI.EDIT_ADDRESS_TEXTAREA);
		
	}



	public void clearCityTextBox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX);
		clearTextElement(driver, EditCustomerPageUI.EDIT_CITY_TEXTBOX);
		
	}



	public void clearStateTextBox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX);
		clearTextElement(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX);
		
	}


	public void clearPinTextBox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX);
		clearTextElement(driver, EditCustomerPageUI.EDIT_PIN_TEXTBOX);
		
	}



	public void clearPhoneTextBox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX);
		clearTextElement(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_TEXTBOX);
		
	}



	public void clearEmailTextBox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_EMAIL_TEXTBOX);
		clearTextElement(driver, EditCustomerPageUI.EDIT_EMAIL_TEXTBOX);
		
	}



	public void clickToCustomerIDTexbox() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		
	}



	public void pressTABKeyToCustomerIDTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyBoardToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, Keys.TAB);	
		
	}



	public boolean isCustomerIDIsRequiredMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_IS_REQUIRED_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.CUSTOMER_ID_IS_REQUIRED_MESSAGE);
	}



	public void clearCustomerIDTextBox() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		clearTextElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		
	}



	public void inputBlankSpaceToCustomerIDTextbox(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, blankSpace);
		
	}



	public boolean isFirstCharacterOfCustomerIDCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.CUSTOMER_ID_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
	}



	public void inputChractersValueToCustomerIDTextbox(String characterCustomerID) {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, characterCustomerID);
		
	}


	public boolean isCustomerIDCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.CUSTOMER_ID_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}


	public void inputSpecialCharactersToCustomerIDTextbox(String specialCustomerID) {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, specialCustomerID);
		
	}


	public boolean isSpecialCharactersOfCustomerIDAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.CUSTOMER_ID_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}



	public void inputValidCustomerIDToCustomerIDTextbox(String customerID) {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerID);
		
	}



	public void clickToCustomerIDSubmitButton() {
		waitForElementVisible(driver, EditCustomerPageUI.SUBMIT_CUTOMER_ID_BUTTON);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_CUTOMER_ID_BUTTON);
		
	}


	public String getTextCustomerIDInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CUSTOMER_ID);
		return getTextElement(driver, EditCustomerPageUI.EDIT_CUSTOMER_ID);
	}
	
	public String getTextCustomerNameInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CUSTOMER_NAME_INFOR);
		return getTextElement(driver, EditCustomerPageUI.EDIT_CUSTOMER_NAME_INFOR);
	}

	public String getTextGenderInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_GENDER_INFOR);
		return getTextElement(driver, EditCustomerPageUI.EDIT_GENDER_INFOR);
	}

	public String getDateOfBirthInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_DATE_OF_BIRTH_INFO_INFOR);
		return getTextElement(driver, EditCustomerPageUI.EDIT_DATE_OF_BIRTH_INFO_INFOR);
	}

	public String getTextEditAdressInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_ADDRESS_INFOR);
		return getTextElement(driver, EditCustomerPageUI.EDIT_ADDRESS_INFOR);
	}

	public String getTextEditCityInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_CITY_INFOR);
		return getTextElement(driver, EditCustomerPageUI.EDIT_CITY_INFOR);
	}

	public String getTextEditStateInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_INFOR);
		return getTextElement(driver, EditCustomerPageUI.EDIT_STATE_INFOR);
	}

	public String getTextEditPinInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_PIN_INFOR);
		return getTextElement(driver, EditCustomerPageUI.EDIT_PIN_INFOR);
	}

	public String getTextEditMobileNumberInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_INFOR);
		return getTextElement(driver, EditCustomerPageUI.EDIT_MOBILE_NUMBER_INFOR);
	}

	public String getTextEditEmailInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_EMAIL_INFOR);
		return getTextElement(driver, EditCustomerPageUI.EDIT_EMAIL_INFOR);
	}



	public void clickToStateTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.EDIT_STATE_TEXTBOX);
		
	}



	public void inputCustomerIDToCustomerIDTextbox(String customerID) {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerID);
		
	}



	public void clicktoSubmitCustomerIDButton() {
		waitForElementVisible(driver, EditCustomerPageUI.SUBMIT_CUTOMER_ID_BUTTON);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_CUTOMER_ID_BUTTON);
		
	}










	

}
