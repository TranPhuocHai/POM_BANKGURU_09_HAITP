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
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		clickToElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		
	}

	public boolean isAddressFieldMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_FIELD_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.ADDRESS_FIELD_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputSpecialCharactersToAdressTextArea(String specialCharactersAddress) {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyToElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA, specialCharactersAddress);
		
	}

	public boolean isSpecialCharactersOfAddressAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.ADDRESS_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputBlankSpaceToAdressTextArea(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyToElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA, blankSpace);
		
	}

	public boolean isFirstCharacterOfAddressCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.ADDRESS_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}

	public void clickToCityTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.CITY_TEXTBOX);
		
	}

	public boolean isCityMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.CITY_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputNumericValueToCityTextbox(String numericCity) {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, numericCity);
		
	}

	public boolean isNumbersAreNotAllowedMessageOfCityDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.CITY_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputSpecialCharactersToCityTextbox(String specialCharactersCity) {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, specialCharactersCity);
		
	}

	public boolean isSpecialCharactersOfCityAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.CITY_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputBlankSpaceToCityTextbox(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfCityCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.CITY_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}
	

	public boolean isStateMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.STATE_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputNumericValueToStateTextbox(String numericState) {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, numericState);
		
	}

	public boolean isNumbersAreNotAllowedMessageOfStateDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.STATE_NUMERIC_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputSpecialCharactersToStateTextbox(String specialCharactersState) {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, specialCharactersState);
		
	}

	public boolean isSpecialCharactersOfStateAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.STATE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputBlankSpaceToStateTextbox(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfStateCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.STATE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}

	public void clickToPinTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.PIN_TEXTBOX);
		
	}
	
	public boolean isPinMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.PIN_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputChractersValueToPinTextbox(String characterPIN) {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, characterPIN);
		
	}

	public boolean isPinCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.PIN_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void inputLessThan6DigitsToPinTextbox(String lessThan6Digits) {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, lessThan6Digits);
		
	}

	public boolean isPinMustHave6DegitsMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_MUST_HAVE_6_DIGITS_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.PIN_MUST_HAVE_6_DIGITS_MESSAGE);
		
	}

	public void inputBlankSpaceToPinTextbox(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfPinCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.PIN_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}

	public void pressTABKeyToAddressTextArea() {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyBoardToElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA, Keys.TAB);	
		
	}

	public void pressTABKeyToCityTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		sendKeyBoardToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, Keys.TAB);
		
	}

	public void pressTABKeyToStateTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		sendKeyBoardToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, Keys.TAB);
		
	}

	public void pressTABKeyToPinTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		sendKeyBoardToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, Keys.TAB);
		
	}

	public void pressTABKeyToMobileTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyBoardToElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX, Keys.TAB);
		
	}
	
	public void pressTABKeyToEmailTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyBoardToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, Keys.TAB);
		
	}
	
	public void clickToMobileNumberTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		
	}
	
	public boolean isPhoneMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.PHONE_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.PHONE_MUST_NOT_BE_BLANK_MESSAGE);
		
	}
	
	public void inputBlankSpaceToMobileNumberTextbox(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfPhoneCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.PHONE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.PHONE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		
	}
	
	public void inputChractersValueToMobileNumberTextbox(String characterPhoneNumber) {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX, characterPhoneNumber);
		
	}

	public boolean isPhoneCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.PHONE_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.PHONE_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}
	
	public void inputSpecialCharactersToMobileNumberTextbox(String specialCharactersPhone) {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX, specialCharactersPhone);
		
	}

	public boolean isSpecialCharactersOfPhoneAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.PHONE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.PHONE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		
	}

	public void clickToEmailTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		
	}

	public boolean isEmailMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EMAIL_MUST_NOT_BE_BLANK_MESSAGE);
		
	}

	public void inputIncorrectEmailIDToEmailTextbox(String incorrectEmailID) {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, incorrectEmailID);
		
	}

	public boolean isEmailIDIsNotValidMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_ID_IS_NOT_VALID_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EMAIL_ID_IS_NOT_VALID_MESSAGE);
	}

	public void inputBlankSpaceToEmailTextbox(String blankSpace) {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfEmailCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EMAIL_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
	}


	public void inputValidDataToAdressTextArea(String validAdress) {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyToElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA, validAdress);
		
	}

	public void inputValidDataToCityTextbox(String validCity) {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, validCity);
		
	}

	public void inputValidDataToStateTextbox(String validState) {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, validState);
		
	}

	public void inputValidDataToPinTextbox(String validPin) {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, validPin);
		
	}

	public void inputValidDataToMobileNumberTextbox(String validPhoneNumber) {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX, validPhoneNumber);
		
	}

	public void inputValidDataToEmailTextbox(String validEmailID) {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, validEmailID);
		
	}

	public void clickToEditSubmitButton() {
		waitForElementVisible(driver, EditCustomerPageUI.SUBMIT_EDIT_BUTTON);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_EDIT_BUTTON);
		
	}



	public void clearAdressTextArea() {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		clearTextElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		
	}



	public void clearCityTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		clearTextElement(driver, EditCustomerPageUI.CITY_TEXTBOX);
		
	}



	public void clearStateTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		clearTextElement(driver, EditCustomerPageUI.STATE_TEXTBOX);
		
	}


	public void clearPinTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		clearTextElement(driver, EditCustomerPageUI.PIN_TEXTBOX);
		
	}



	public void clearPhoneTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		clearTextElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		
	}



	public void clearEmailTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		clearTextElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		
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



	public void clearCustomerIDTextbox() {
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
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID);
		return getTextElement(driver, EditCustomerPageUI.CUSTOMER_ID);
	}
	
	public String getTextCustomerNameInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_NAME_INFOR);
		return getTextElement(driver, EditCustomerPageUI.CUSTOMER_NAME_INFOR);
	}

	public String getTextGenderInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.GENDER_INFOR);
		return getTextElement(driver, EditCustomerPageUI.GENDER_INFOR);
	}

	public String getDateOfBirthInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.DATE_OF_BIRTH_INFO_INFOR);
		return getTextElement(driver, EditCustomerPageUI.DATE_OF_BIRTH_INFO_INFOR);
	}

	public String getTextEditAdressInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_INFOR);
		return getTextElement(driver, EditCustomerPageUI.ADDRESS_INFOR);
	}

	public String getTextEditCityInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_INFOR);
		return getTextElement(driver, EditCustomerPageUI.CITY_INFOR);
	}

	public String getTextEditStateInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_INFOR);
		return getTextElement(driver, EditCustomerPageUI.STATE_INFOR);
	}

	public String getTextEditPinInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_INFOR);
		return getTextElement(driver, EditCustomerPageUI.PIN_INFOR);
	}

	public String getTextEditMobileNumberInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_INFOR);
		return getTextElement(driver, EditCustomerPageUI.MOBILE_NUMBER_INFOR);
	}

	public String getTextEditEmailInfo() {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_INFOR);
		return getTextElement(driver, EditCustomerPageUI.EMAIL_INFOR);
	}



	public void clickToStateTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.STATE_TEXTBOX);
		
	}



	public void inputCustomerIDToCustomerIDTextbox(String customerID) {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerID);
		
	}



	public void clicktoSubmitCustomerIDButton() {
		waitForElementVisible(driver, EditCustomerPageUI.SUBMIT_CUTOMER_ID_BUTTON);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_CUTOMER_ID_BUTTON);
		
	}



	public void openHomePageUrl(String homePageUrl) {
		openAnyUrl(driver, homePageUrl);
		
	}



	public void clickToNewAccountButton() {
		waitForElementVisible(driver, EditCustomerPageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, EditCustomerPageUI.NEW_ACCOUNT_LINK);
		
	}










	

}
