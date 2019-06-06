package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.CustomisedStatementPageUI;
import commons.AbstractPage;

public class CustomisedStatementPageObject extends AbstractPage {
	public CustomisedStatementPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

//	public boolean isCustomisedStatementFormDisplayed() {
//		waitForElementVisible(driver, CustomisedStatementPageUI.CUSTOMISED_STATEMENT_FORM);
//		return isControlDisplayed(driver, CustomisedStatementPageUI.CUSTOMISED_STATEMENT_FORM);
//	}

//	public void clearAccountNumberTextbox() {
//		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
//		clearTextElement(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
//
//	}
//
//	public void clickToAccountNumberTexbox() {
//		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
//		clickToElement(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
//
//	}
//
//	public void pressTABKeyToAccountNumberTextbox() {
//		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
//		sendKeyBoardToElement(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX, Keys.TAB);
//
//	}
//
//	public void inputValueToAccountNumberTextbox(String value) {
//		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
//		sendKeyToElement(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX, value);
//
//	}

//	public void clearMinimumTransactionValueTextbox() {
//		waitForElementVisible(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_TEXTBOX);
//		clearTextElement(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_TEXTBOX);
//
//	}
//
//	public void inputValueToMinimumTransactionValueTextbox(String value) {
//		waitForElementVisible(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_TEXTBOX);
//		sendKeyToElement(driver, CustomisedStatementPageUI.MINIMUM_TRANSACTION_VALUE_TEXTBOX, value);
//
//	}
//
//	public void clearNumberOfTransactionTextbox() {
//		waitForElementVisible(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_TEXTBOX);
//		clearTextElement(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_TEXTBOX);
//
//	}
//
//	public void inputValueToNumberOfTransactionTextbox(String value) {
//		waitForElementVisible(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_TEXTBOX);
//		sendKeyToElement(driver, CustomisedStatementPageUI.NUMBER_OF_TRANSACTION_TEXTBOX, value);
//
//	}

//	public void clickSubmitButton() {
//		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
//		clickToElement(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
//
//	}

	public boolean isTransactionDetailsFormDisplayed(String accountID) {
		waitForElementVisible(driver, CustomisedStatementPageUI.TRANSACTION_FORM_DETAILS_FORM_DYNAMIC, accountID);
		return isControlDisplayed(driver, CustomisedStatementPageUI.TRANSACTION_FORM_DETAILS_FORM_DYNAMIC, accountID);
	}

}
