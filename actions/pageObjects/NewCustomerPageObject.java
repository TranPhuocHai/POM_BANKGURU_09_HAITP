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
		return isControlDisplayed(driver, NewCustomerPageUI.CUSTOMER_NAME_MUST_NOT_BE_BLANK_MESSAGE);
	}

	public void clickToDateOfBirthTexbox() {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		
	}

	public void openNewCustomerPageurl(String newCustomerPageUrl) {
		openAnyUrl(driver, newCustomerPageUrl);
	}

	public void inputNumericValueToCustomerNameTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, NewCustomerPageUI.NUMERIC_VALUE_NAME);
		
	}

	public boolean isNumbersAreNotAllowedMessageDisplayed() {
		return isControlDisplayed(driver, NewCustomerPageUI.NUMERIC_ARE_NOT_ALLOW_MESSAGE);
	}

	public void inputSpecialCharactersToCustomerNameTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, NewCustomerPageUI.SPECIAL_CHARACTERS_NAME);
		
	}

	public boolean isSpecialCharactersAreNotAllowedMessageDisplayed() {
		return isControlDisplayed(driver, NewCustomerPageUI.SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public void inputBlankSpaceToCustomerNameTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, NewCustomerPageUI.BLANK_SPACE);
		
	}

	public boolean isFirstCharacterCanNotHaveSpaceMessageDisplayed() {
		return isControlDisplayed(driver, NewCustomerPageUI.FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
	}

	public void clickToAddressTextarea() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		clickToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		
	}

	public boolean isAddressFieldMustNotBeBlankMessageDisplayed() {
		return isControlDisplayed(driver, NewCustomerPageUI.ADDRESS_FIELD_MUST_NOT_BE_BLANK_MESSAGE);
	}

}
