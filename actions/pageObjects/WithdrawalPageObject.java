package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.WithdrawalPageUI;
import commons.AbstractPage;

public class WithdrawalPageObject extends AbstractPage {
	public WithdrawalPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

//	public boolean isAmountWithdrawFormDisplayed() {
//		waitForElementVisible(driver, WithdrawalPageUI.AMOUNT_WITHDRAW_FORM_MESSAGE);
//		return isControlDisplayed(driver, WithdrawalPageUI.AMOUNT_WITHDRAW_FORM_MESSAGE);
//		
//	}

//	public void inputValueToAccountNoTextbox(String value) {
//		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
//		sendKeyToElement(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX, value);
//		
//	}

//	public void inputAmountToAmountTextbox(String withdrawAmount) {
//		waitForElementVisible(driver, WithdrawalPageUI.AMOUNT_TEXTBOX);
//		sendKeyToElement(driver, WithdrawalPageUI.AMOUNT_TEXTBOX, withdrawAmount);
//		
//	}

//	public void clickToSubmitButton() {
//		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
//		clickToElement(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
//		
//	}

//	public boolean isCorrectTracsactionDetailsMessageDisplayed(String accountID) {
//		waitForElementVisible(driver, WithdrawalPageUI.TRANSACTION_DETAILS_MESSAGE, accountID);
//		return isControlDisplayed(driver, WithdrawalPageUI.TRANSACTION_DETAILS_MESSAGE, accountID);
//	}
//
//	public void inputValueToDescriptionTextbox(String value) {
//		waitForElementVisible(driver, WithdrawalPageUI.DESCRIPTION_TEXTBOX);
//		sendKeyToElement(driver, WithdrawalPageUI.DESCRIPTION_TEXTBOX, value);
//		
//	}

	
}
