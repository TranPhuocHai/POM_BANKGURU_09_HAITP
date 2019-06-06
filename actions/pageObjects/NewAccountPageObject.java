package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.NewAccountPageUI;
import commons.AbstractPage;

public class NewAccountPageObject extends AbstractPage {
	public NewAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	public String getTextCurrentAmount;

//	public void selectCurrentInAccountType() {
//		waitForElementVisible(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
//		selectItemInDropdown(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN, "Current");
//	}
//
//	public void inputValueToInitialDepositTextbox(String value) {
//		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
//		sendKeyToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, value);
//		
//	}

//	public void clickToSubmitButton() {
//		waitForElementVisible(driver, AbstractPageUI.SUBMIT_BUTTON);
//		clickToElement(driver, AbstractPageUI.SUBMIT_BUTTON);
//		
//	}

//	public boolean isAccountGeneratedSuccessfullyMessageDisplayed() {
//		waitForElementVisible(driver, NewAccountPageUI.ACCOUNT_GENERATED_SUCCESS_MESSAGE);
//		return isControlDisplayed(driver, NewAccountPageUI.ACCOUNT_GENERATED_SUCCESS_MESSAGE);
//	}

//	public void clearCustomerIDTextbox() {
//		waitForElementVisible(driver, AbstractPageUI.CUSTOMER_ID_TEXTBOX);
//		clearTextElement(driver, AbstractPageUI.CUSTOMER_ID_TEXTBOX);
//		
//	}
//
//	public void clickToCustomerIDTexbox() {
//		waitForElementVisible(driver, AbstractPageUI.CUSTOMER_ID_TEXTBOX);
//		clickToElement(driver, AbstractPageUI.CUSTOMER_ID_TEXTBOX);
//		
//	}
//
//	public void pressTABKeyToCustomerIDTextbox() {
//		waitForElementVisible(driver, AbstractPageUI.CUSTOMER_ID_TEXTBOX);
//		sendKeyBoardToElement(driver, AbstractPageUI.CUSTOMER_ID_TEXTBOX, Keys.TAB);	
//		
//	}
//
//	public boolean isCustomerIDIsRequiredMessageDisplayed() {
//		waitForElementVisible(driver, AbstractPageUI.CUSTOMER_ID_IS_REQUIRED_MESSAGE);
//		return isControlDisplayed(driver, AbstractPageUI.CUSTOMER_ID_IS_REQUIRED_MESSAGE);
//	}
//
//	public void inputValueToCustomerIDTextbox(String value) {
//		waitForElementVisible(driver, AbstractPageUI.CUSTOMER_ID_TEXTBOX);
//		sendKeyToElement(driver, AbstractPageUI.CUSTOMER_ID_TEXTBOX, value);
//		
//	}

//	public void clearInitialDepositTextbox() {
//		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
//		clearTextElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);		
//	}
//
//	public void clickToInitialDepositTexbox() {
//		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
//		clickToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);		
//		
//	}
//
//	public void pressTABKeyToInitialDepositTextbox() {
//		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
//		sendKeyBoardToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, Keys.TAB);
//	}
//
//	public boolean isFirstCharacterOfInitialDepositCanNotHaveSpaceMessageDisplayed() {
//		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
//		return isControlDisplayed(driver, NewAccountPageUI.INITIAL_DEPOSIT_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
//	}
//
//	public boolean isInitialDepositCharacterAreNotAllowMessageDisplayed() {
//		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
//		return isControlDisplayed(driver, NewAccountPageUI.INITIAL_DEPOSIT_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
//	}
//
//	public boolean isSpecialCharactersOfInitialDepositAreNotAllowedMessageDisplayed() {
//		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
//		return isControlDisplayed(driver, NewAccountPageUI.INITIAL_DEPOSIT_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
//	}

	
}
