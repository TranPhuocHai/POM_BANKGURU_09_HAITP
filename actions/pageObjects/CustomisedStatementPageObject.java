package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.CustomisedStatementPageUI;
import commons.AbstractPage;

public class CustomisedStatementPageObject extends AbstractPage {
	public CustomisedStatementPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isCustomisedStatementFormDisplayed() {
		waitForElementVisible(driver, CustomisedStatementPageUI.CUSTOMISED_STATEMENT_FORM);
		return isControlDisplayed(driver, CustomisedStatementPageUI.CUSTOMISED_STATEMENT_FORM);
	}

	public void clearAccountNumberTextbox() {
		waitForElementVisible(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);
		clearTextElement(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);

	}

	public void clickToAccountNumberTexbox() {
		waitForElementVisible(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);
		clickToElement(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);

	}

	public void pressTABKeyToAccountNumberTextbox() {
		waitForElementVisible(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyBoardToElement(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_TEXTBOX, Keys.TAB);

	}

	public boolean isAccountNumberMustNotBeBlankDisplayed() {
		waitForElementVisible(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_MUST_NOT_BE_BANK_MESSAGE);
		return isControlDisplayed(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_MUST_NOT_BE_BANK_MESSAGE);
	}

	public void inputValueToAccountNumberTextbox(String value) {
		waitForElementVisible(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyToElement(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_TEXTBOX, value);

	}

	public boolean isAccountNumberCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public boolean isSpecialCharactersOfAccountNumberAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, CustomisedStatementPageUI.ACCOUNT_NUMBER_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public void clearMinimumTransactionValueTextbox() {
		waitForElementVisible(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_TEXTBOX);
		clearTextElement(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_TEXTBOX);

	}

	public void inputValueToMinimumTransactionValueTextbox(String value) {
		waitForElementVisible(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_TEXTBOX);
		sendKeyToElement(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_TEXTBOX, value);

	}

	public boolean isMinimumTransactionValueCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public boolean isSpecialCharactersOfMinimumTransactionValueAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public void clearNumberOfTransactionTextbox() {
		waitForElementVisible(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_TEXTBOX);
		clearTextElement(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_TEXTBOX);

	}

	public void inputValueToNumberOfTransactionTextbox(String value) {
		waitForElementVisible(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_TEXTBOX);
		sendKeyToElement(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_TEXTBOX, value);

	}

	public boolean isNumberOfTransactionCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public boolean isSpecialCharactersOfNumberOfTransactionAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public void clickSubmitButton() {
		waitForElementVisible(driver, CustomisedStatementPageUI.SUBMIT_BUTTON);
		clickToElement(driver, CustomisedStatementPageUI.SUBMIT_BUTTON);

	}

	public boolean isTransactionDetailsFormDisplayed(String accountID) {
		waitForElementVisible(driver, CustomisedStatementPageUI.TRANSACTION_FORM_DETAILS_FORM_DYNAMIC, accountID);
		return isControlDisplayed(driver, CustomisedStatementPageUI.TRANSACTION_FORM_DETAILS_FORM_DYNAMIC, accountID);
	}

}
