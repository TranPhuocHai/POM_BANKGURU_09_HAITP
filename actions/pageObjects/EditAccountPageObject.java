package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.EditAccountPageUI;
import commons.AbstractPage;

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
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Account Number");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Account Number");
	}
	
	public boolean isAccountNumberCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Account No");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Account No");
	}
	
	public boolean isSpecialCharactersOfAccountNumberAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Account No");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Account No");
	}
	
	public void clickAccountNumberSubmitButton() {
		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NUMBER_SUBMIT_BUTTON);
		clickToElement(driver, EditAccountPageUI.ACCOUNT_NUMBER_SUBMIT_BUTTON);
		
	}
	public boolean isEditCustomerFormDispayed() {
		waitForElementVisible(driver, EditAccountPageUI.EDIT_CUSTOMER_FORM);
		return isControlDisplayed(driver, EditAccountPageUI.EDIT_CUSTOMER_FORM);
	}
	public void selectSavingsInAccountType() {
		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
		selectItemInDropdown(driver, EditAccountPageUI.ACCOUNT_TYPE_DROPDOWN, "Savings");
		
	}
	public void clickEditAccountSubmitButton() {
		waitForElementVisible(driver, EditAccountPageUI.EDIT_ACCOUNT_SUBMIT_BUTTON);
		clickToElement(driver, EditAccountPageUI.EDIT_ACCOUNT_SUBMIT_BUTTON);
		
	}
	public boolean isAccountDetailsUpdatedSuccessfullyDispayed() {
		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_DETAILS_UPLOADED_SUCCESS_INFOR);
		return isControlDisplayed(driver, EditAccountPageUI.ACCOUNT_DETAILS_UPLOADED_SUCCESS_INFOR);
	}
	public String getTextAccountTypeInfor() {
		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_TYPE_INFOR);
		return getTextElement(driver, EditAccountPageUI.ACCOUNT_TYPE_INFOR);
	}


}
