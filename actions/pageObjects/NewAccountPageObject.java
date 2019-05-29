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

	public void selectCurrentInAccountType() {
		waitForElementVisible(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
		selectItemInDropdown(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN, "Current");
	}

	public void inputValueToInitialDepositTextbox(String value) {
		waitForElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		sendKeyToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, value);
		
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
		waitForElementVisible(driver, AbstractPageUI.CUSTOMER_ID_IS_REQUIRED_MESSAGE);
		return isControlDisplayed(driver, AbstractPageUI.CUSTOMER_ID_IS_REQUIRED_MESSAGE);
	}

	public boolean isFirstCharacterOfCustomerIDCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "Customer ID");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "Customer ID");
	}

	public void inputValueToCustomerIDTextbox(String value) {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX, value);
		
	}

	public boolean isCustomerIDCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Customer ID");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Customer ID");
	}

	public boolean isSpecialCharactersOfCustomerIDAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Customer ID");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Customer ID");
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
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Initial Deposit");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE, "Initial Deposit");
	}


	public boolean isFirstCharacterOfInitialDepositCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "Initial deposit");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE, "Initial deposit");
	}

	public boolean isInitialDepositCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Initial deposit");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Initial deposit");
	}

	public boolean isSpecialCharactersOfInitialDepositAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Initial deposit");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE, "Initial deposit");
	}

	
}
