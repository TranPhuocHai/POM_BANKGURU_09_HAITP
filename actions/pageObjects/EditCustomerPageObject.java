package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.EditCustomerPageUI;
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
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Address Field");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Address Field");
		
	}

	public void inputValueToAdressTextArea(String value) {
		waitForElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyToElement(driver, EditCustomerPageUI.ADDRESS_TEXTAREA, value);
		
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
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.CITY_TEXTBOX);
		
	}

	public boolean isCityMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "City Field");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "City Field");
		
	}

	public void inputValueToCityTextbox(String value) {
		waitForElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, value);
		
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
	

	public boolean isStateMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "State");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "State");
		
	}

	public void inputValueToStateTextbox(String value) {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, value);
		
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
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.PIN_TEXTBOX);
		
	}
	
	public boolean isPinMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "PIN Code");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "PIN Code");
		
	}

	public void inputValueToPinTextbox(String value) {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, value);
		
	}

	public boolean isPinCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "PIN");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "PIN");
		
	}


	public boolean isPinMustHave6DegitsMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.PIN_MUST_HAVE_6_DIGITS_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.PIN_MUST_HAVE_6_DIGITS_MESSAGE);
		
	}


	public boolean isFirstCharacterOfPinCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "PIN");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "PIN");
		
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
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Mobile no");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Mobile no");
		
	}
	
	public void inputValueToMobileNumberTextbox(String value) {
		waitForElementVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX, value);
		
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
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		
	}

	public boolean isEmailMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Email-ID");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Email-ID");
		
	}

	public void inputValueToEmailTextbox(String value) {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, value);
		
	}

	public boolean isEmailIDIsNotValidMessageDisplayed() {
		waitForElementVisible(driver, EditCustomerPageUI.EMAIL_ID_IS_NOT_VALID_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.EMAIL_ID_IS_NOT_VALID_MESSAGE);
	}

	public boolean isFirstCharacterOfEmailCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "E-mail");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "E-mail");
	}


	public void clickToSubmitButton() {
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
		waitForElementVisible(driver, AbstractPageUI.CUSTOMER_ID_IS_REQUIRED_MESSAGE);
		return isControlDisplayed(driver, AbstractPageUI.CUSTOMER_ID_IS_REQUIRED_MESSAGE);
	}

	public void clearCustomerIDTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		clearTextElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		
	}


	public void inputValueToCustomerIDTextbox(String value) {
		waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, value);
		
	}

	public boolean isFirstCharacterOfCustomerIDCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "Customer ID");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "Customer ID");
	}


	public boolean isCustomerIDCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Customer ID");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Customer ID");
		
	}


	public boolean isSpecialCharactersOfCustomerIDAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Customer ID");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Customer ID");
	}

	public void clickToCustomerIDSubmitButton() {
		waitForElementVisible(driver, AbstractPageUI.SUBMIT_BUTTON);
		clickToElement(driver, AbstractPageUI.SUBMIT_BUTTON);
		
	}



	public void clickToStateTextbox() {
		waitForElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		clickToElement(driver, EditCustomerPageUI.STATE_TEXTBOX);
		
	}




	public void clicktoSubmitCustomerIDButton() {
		waitForElementVisible(driver, AbstractPageUI.SUBMIT_BUTTON);
		clickToElement(driver, AbstractPageUI.SUBMIT_BUTTON);
		
	}



	public void openHomePageUrl(String homePageUrl) {
		openAnyUrl(driver, homePageUrl);
		
	}


	

}
