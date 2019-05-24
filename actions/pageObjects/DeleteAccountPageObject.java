package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.BalanceEnquiryPageUI;
import bankguruUI.DeleteAccountPageUI;
import bankguruUI.EditAccountPageUI;
import bankguruUI.FundTransferPageUI;
import bankguruUI.WithdrawalPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class DeleteAccountPageObject extends AbstractPage {
	public DeleteAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void inputValueToAccountNumber(String value) {
		waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyToElement(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX, value);
		
	}

	public void clickSubmitButton() {
		waitForElementVisible(driver, DeleteAccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver, DeleteAccountPageUI.SUBMIT_BUTTON);
	}
	
	public void acceptConfirmDeleteAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}
	
	public HomePageObject acceptDeleteSuccessAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
		return PageFactoryManager.getHomePage(driver);
	}

	public String getTextConfirmDeleteAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}

	public String getTextDeleteSuccessAlertAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}

	public void clearAccountNumberTextbox() {
		waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		clearTextElement(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		
	}

	public void clickToAccountNumberTexbox() {
		waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		clickToElement(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		
	}

	public void pressTABKeyToAccountNumberTextbox() {
		waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyBoardToElement(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX, Keys.TAB);
		
	}

	public boolean isAccountNumberMustNotBeBlankDisplayed() {
		waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_MUST_NOT_BE_BANK_MESSAGE);
		return isControlDisplayed(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_MUST_NOT_BE_BANK_MESSAGE);
	}

	public void inputValueToAccountNumberTextbox(String value) {
		waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyToElement(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX, value);
		
	}

	public boolean isAccountNumberCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public boolean isSpecialCharactersOfAccountNumberAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	
}
