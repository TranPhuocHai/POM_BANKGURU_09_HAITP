package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.DeleteAccountPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class DeleteAccountPageObject extends AbstractPage {
	public DeleteAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void clickSubmitButton() {
		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
		clickToElement(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
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
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Account Number");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Account Number");
	}

	public void inputValueToAccountNumberTextbox(String value) {
		waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyToElement(driver, DeleteAccountPageUI.ACCOUNT_NUMBER_TEXTBOX, value);
		
	}

	public boolean isAccountNumberCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Account No");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Account No");
	}
	
	public boolean isSpecialCharactersOfAccountNumberAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Account No");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Account No");
	}

	public boolean isDeleteAccountFormDisplayed() {
		waitForElementVisible(driver, DeleteAccountPageUI.DELETE_ACCOUNT_FORM);
		return isControlDisplayed(driver, DeleteAccountPageUI.DELETE_ACCOUNT_FORM);
	}

	
}
