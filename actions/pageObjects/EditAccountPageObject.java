package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.EditAccountPageUI;
import bankguruUI.EditCustomerPageUI;
import bankguruUI.NewCustomerPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class EditAccountPageObject extends AbstractPage {
	WebDriver driver;
	public EditAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clearAccountNumberTextbox() {
		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		clearTextElement(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		
	}
	
	public void inputValueToAccountNumberTextbox(String value) {
		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyToElement(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX, value);
		
	}
	
	public void clickToAccountNumberTexbox() {
		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		clickToElement(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		
	}
	public void pressTABKeyToAccountNumberTextbox() {
		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
		sendKeyBoardToElement(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX, Keys.TAB);
		
	}
	public boolean isAccountNumberMustNotBeBlankDisplayed() {
		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NUMBER_MUST_NOT_BE_BANK_MESSAGE);
		return isControlDisplayed(driver, EditAccountPageUI.ACCOUNT_NUMBER_MUST_NOT_BE_BANK_MESSAGE);
	}
	
	public boolean isAccountNumberCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NUMBER_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, EditAccountPageUI.ACCOUNT_NUMBER_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}
	public boolean isSpecialCharactersOfAccountNumberAreNotAllowedMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}


}
