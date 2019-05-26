package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import bankguruUI.MiniStatementPageUI;
import commons.AbstractPage;

public class MiniStatementPageObject extends AbstractPage {
	public MiniStatementPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isMiniStatementFormDisplayed() {
		waitForElementVisible(driver, MiniStatementPageUI.MINI_STATEMENT_FORM);
		return isControlDisplayed(driver, MiniStatementPageUI.MINI_STATEMENT_FORM);
	}

	public void clearAccountNumberTextbox() {
		waitForElementVisible(driver, MiniStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);
		clearTextElement(driver, MiniStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);
		
	}

	public void clickToAccountNumberTexbox() {
		waitForElementVisible(driver, MiniStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);
		clickToElement(driver, MiniStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);
		
	}

	public void pressTABKeyToAccountNumberTextbox() {
		waitForElementVisible(driver, MiniStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyBoardToElement(driver, MiniStatementPageUI.ACCOUNT_NUMBER_TEXTBOX, Keys.TAB);
		
	}

	public boolean isAccountNumberMustNotBeBlankDisplayed() {
		waitForElementVisible(driver, MiniStatementPageUI.ACCOUNT_NUMBER_MUST_NOT_BE_BANK_MESSAGE);
		return isControlDisplayed(driver, MiniStatementPageUI.ACCOUNT_NUMBER_MUST_NOT_BE_BANK_MESSAGE);
	}

	public void inputValueToAccountNumberTextbox(String value) {
		waitForElementVisible(driver, MiniStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyToElement(driver, MiniStatementPageUI.ACCOUNT_NUMBER_TEXTBOX, value);
		
	}

	public boolean isAccountNumberCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, MiniStatementPageUI.ACCOUNT_NUMBER_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, MiniStatementPageUI.ACCOUNT_NUMBER_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public boolean isSpecialCharactersOfAccountNumberAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, MiniStatementPageUI.ACCOUNT_NUMBER_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, MiniStatementPageUI.ACCOUNT_NUMBER_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public void clickAccountNumberSubmitButton() {
		waitForElementVisible(driver, MiniStatementPageUI.ACCOUNT_NUMBER_SUBMIT_BUTTON);
		clickToElement(driver, MiniStatementPageUI.ACCOUNT_NUMBER_SUBMIT_BUTTON);
		
	}

	public boolean isLastFiveTransactionDetailsDispayed(String accountID) {
		waitForElementVisible(driver, MiniStatementPageUI.LAST_FIVE_TRANSACTION_MESSAGE_DYNAMIC, accountID);
		return isControlDisplayed(driver, MiniStatementPageUI.LAST_FIVE_TRANSACTION_MESSAGE_DYNAMIC, accountID);
	}


}
