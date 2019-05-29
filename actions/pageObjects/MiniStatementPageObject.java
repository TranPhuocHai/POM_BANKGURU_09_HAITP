package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
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

	public void inputValueToAccountNumberTextbox(String value) {
		waitForElementVisible(driver, MiniStatementPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyToElement(driver, MiniStatementPageUI.ACCOUNT_NUMBER_TEXTBOX, value);
		
	}

	public void clickAccountNumberSubmitButton() {
		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
		clickToElement(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
		
	}

	public boolean isLastFiveTransactionDetailsDispayed(String accountID) {
		waitForElementVisible(driver, MiniStatementPageUI.LAST_FIVE_TRANSACTION_MESSAGE_DYNAMIC, accountID);
		return isControlDisplayed(driver, MiniStatementPageUI.LAST_FIVE_TRANSACTION_MESSAGE_DYNAMIC, accountID);
	}


}
