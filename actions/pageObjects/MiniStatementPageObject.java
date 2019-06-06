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

//	public boolean isMiniStatementFormDisplayed() {
//		waitForElementVisible(driver, MiniStatementPageUI.MINI_STATEMENT_FORM);
//		return isControlDisplayed(driver, MiniStatementPageUI.MINI_STATEMENT_FORM);
//	}
//
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
//
//	public void clickAccountNumberSubmitButton() {
//		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
//		clickToElement(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
//		
//	}

	public boolean isLastFiveTransactionDetailsDispayed(String accountID) {
		waitForElementVisible(driver, MiniStatementPageUI.DYNAMIC_LAST_FIVE_TRANSACTION_MESSAGE, accountID);
		return isControlDisplayed(driver, MiniStatementPageUI.DYNAMIC_LAST_FIVE_TRANSACTION_MESSAGE, accountID);
	}


}
