package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.DepositPageUI;
import bankguruUI.HomePageUI;
import bankguruUI.WithdrawalPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class WithdrawalPageObject extends AbstractPage {
	public WithdrawalPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isAmountWithdrawFormDisplayed() {
		waitForElementVisible(driver, WithdrawalPageUI.AMOUNT_WITHDRAW_FORM_MESSAGE);
		return isControlDisplayed(driver, WithdrawalPageUI.AMOUNT_WITHDRAW_FORM_MESSAGE);
		
	}

	public void inputAccountIDToAccountNoTextbox(String accountID) {
		waitForElementVisible(driver, WithdrawalPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, WithdrawalPageUI.ACCOUNT_NO_TEXTBOX, accountID);
		
	}

	public void inputAmountToAmountTextbox(String withdrawAmount) {
		waitForElementVisible(driver, WithdrawalPageUI.AMOUNT_TEXTBOX);
		sendKeyToElement(driver, WithdrawalPageUI.AMOUNT_TEXTBOX, withdrawAmount);
		
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, WithdrawalPageUI.SUBMIT_BUTTON);
		clickToElement(driver, WithdrawalPageUI.SUBMIT_BUTTON);
		
	}

	public boolean isCorrectTracsactionDetailsMessageDisplayed(String accountID) {
		String FORMAT_TRANSACTION_DETAILS_MESSAGE = String.format(WithdrawalPageUI.TRANSACTION_DETAILS_MESSAGE, accountID);
		waitForElementVisible(driver, FORMAT_TRANSACTION_DETAILS_MESSAGE);
		return isControlDisplayed(driver, FORMAT_TRANSACTION_DETAILS_MESSAGE);
	}

	public String getTextCurrentBalance() {
		waitForElementVisible(driver, WithdrawalPageUI.CURRENT_BALANCE_INFOR);
		return getTextElement(driver, WithdrawalPageUI.CURRENT_BALANCE_INFOR);
	}

	public void inputDescriptionToDescriptionTextbox(String withdrawDescription) {
		waitForElementVisible(driver, WithdrawalPageUI.DESCRIPTION_TEXTBOX);
		sendKeyToElement(driver, WithdrawalPageUI.DESCRIPTION_TEXTBOX, withdrawDescription);
		
	}

	
}
