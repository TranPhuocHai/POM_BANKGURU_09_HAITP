package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.DepositPageUI;
import commons.AbstractPage;

public class DepositPageObject extends AbstractPage {
	public DepositPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isAmountDepositFormDisplayed() {
		waitForElementVisible(driver, DepositPageUI.AMOUNT_DEPOSIT_FORM_MESSAGE);
		return isControlDisplayed(driver, DepositPageUI.AMOUNT_DEPOSIT_FORM_MESSAGE);
		
	}

	public void inputValueToAccountNoTextbox(String value) {
		waitForElementVisible(driver, DepositPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, DepositPageUI.ACCOUNT_NO_TEXTBOX, value);
		
	}

	public void inputValueToAmountTextbox(String value) {
		waitForElementVisible(driver, DepositPageUI.AMOUNT_TEXTBOX);
		sendKeyToElement(driver, DepositPageUI.AMOUNT_TEXTBOX, value);
		
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, DepositPageUI.SUBMIT_BUTTON);
		clickToElement(driver, DepositPageUI.SUBMIT_BUTTON);
		
	}

	public boolean isCorrectTracsactionDetailsMessageDisplayed(String accountID) {
		String FORMAT_TRANSACTION_DETAILS_MESSAGE = String.format(DepositPageUI.TRANSACTION_DETAILS_MESSAGE, accountID);
		waitForElementVisible(driver, FORMAT_TRANSACTION_DETAILS_MESSAGE);
		return isControlDisplayed(driver, FORMAT_TRANSACTION_DETAILS_MESSAGE);
	}

	public String getTextCurrentBalance() {
		waitForElementVisible(driver, DepositPageUI.CURRENT_BALANCE_INFOR);
		return getTextElement(driver, DepositPageUI.CURRENT_BALANCE_INFOR);
	}

	public void inputDescriptionToDescriptionTextbox(String depositDescription) {
		waitForElementVisible(driver, DepositPageUI.DESCRIPTION_TEXTBOX);
		sendKeyToElement(driver, DepositPageUI.DESCRIPTION_TEXTBOX, depositDescription);
		
	}


	
}
