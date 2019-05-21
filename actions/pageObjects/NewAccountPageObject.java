package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.EditCustomerPageUI;
import bankguruUI.NewAccountPageUI;
import bankguruUI.NewCustomerPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class NewAccountPageObject extends AbstractPage {
	public NewAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	public String getTextCurrentAmount;

	public void inputCustomerIDToCustomerIDTextbox(String customerID) {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX, customerID);
		
	}

	public void selectCurrentInAccountType() {
		waitForElementVisible(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
		selectItemInDropdown(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN, "Current");
	}

	public void inputAmountToInitialDeposit(String currentAmount) {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		sendKeyToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, currentAmount);
		
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, NewAccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewAccountPageUI.SUBMIT_BUTTON);
		
	}

	public boolean isAccountGeneratedSuccessfullyMessageDisplayed() {
		waitForElementVisible(driver, NewAccountPageUI.ACCOUNT_GENERATED_SUCCESS_MESSAGE);
		return isControlDisplayed(driver, NewAccountPageUI.ACCOUNT_GENERATED_SUCCESS_MESSAGE);
	}

	public String getTextCurrentAmount() {
		waitForElementVisible(driver, NewAccountPageUI.CURRENT_AMOUNT_INFOR);
		return getTextElement(driver, NewAccountPageUI.CURRENT_AMOUNT_INFOR);
	}

	public String getAccountID() {
		waitForElementVisible(driver, NewAccountPageUI.ACCOUNT_ID_INFOR);
		return getTextElement(driver, NewAccountPageUI.ACCOUNT_ID_INFOR);
	}

	public void clearCustomerIDTextbox() {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		clearTextElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		
	}

	public void clickToCustomerIDTexbox() {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		clickToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		
	}

	public void pressTABKeyToCustomerIDTextbox() {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyBoardToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX, Keys.TAB);	
		
	}

	public boolean isCustomerIDIsRequiredMessageDisplayed() {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_IS_REQUIRED_MESSAGE);
		return isControlDisplayed(driver, NewAccountPageUI.CUSTOMER_ID_IS_REQUIRED_MESSAGE);
	}

	public boolean isFirstCharacterOfCustomerIDCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, NewAccountPageUI.CUSTOMER_ID_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
	}

	public void inputBlankSpaceToCustomerIDTextbox(String blankSpace) {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX, blankSpace);
		
	}

	public void inputChractersValueToCustomerIDTextbox(String characterCustomerID) {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX, characterCustomerID);
	}

	public boolean isCustomerIDCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewAccountPageUI.CUSTOMER_ID_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public void inputSpecialCharactersToCustomerIDTextbox(String specialCharacter) {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX, specialCharacter);
		
	}

	public boolean isSpecialCharactersOfCustomerIDAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewAccountPageUI.CUSTOMER_ID_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public void clearInitialDepositTextbox() {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		clearTextElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);		
	}

	public void clickToInitialDepositTexbox() {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		clickToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);		
		
	}

	public void pressTABKeyToInitialDepositTextbox() {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		sendKeyBoardToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, Keys.TAB);
	}

	public boolean isInitialDepositMustNotBeBlankMessageDisplayed() {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_MUST_NOT_BE_BLANK_MESSAGE);
		return isControlDisplayed(driver, NewAccountPageUI.INITIAL_DEPOSIT_MUST_NOT_BE_BLANK_MESSAGE);
	}

	public void inputBlankSpaceToInitialDepositTextbox(String blankSpace) {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		sendKeyToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, blankSpace);
	}

	public boolean isFirstCharacterOfInitialDepositCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, NewAccountPageUI.INITIAL_DEPOSIT_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
	}

	public void inputChractersValueToInitialDepositTextbox(String characterValue) {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		sendKeyToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, characterValue);
		
	}

	public boolean isInitialDepositCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewAccountPageUI.INITIAL_DEPOSIT_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public void inputSpecialCharactersToInitialDepositTextbox(String specialCharacter) {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		sendKeyToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, specialCharacter);
		
	}

	public boolean isSpecialCharactersOfInitialDepositAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, NewAccountPageUI.INITIAL_DEPOSIT_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	
}
