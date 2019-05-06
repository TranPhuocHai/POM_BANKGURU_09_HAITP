package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.NewAccountPageUI;
import commons.AbstractPage;

public class NewAccountPageObject extends AbstractPage {
	public NewAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	public String getTextCurrentAmount;

	public void inputCustomerIDToCustomerIDTextbox(String customerID) {
		waitForElementVisible(driver, NewAccountPageUI.NEW_ACCOUNT_SUBMIT_BUTTON);
		sendKeyToElement(driver, NewAccountPageUI.NEW_ACCOUNT_SUBMIT_BUTTON, customerID);
		
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
		waitForElementVisible(driver, NewAccountPageUI.NEW_ACCOUNT_SUBMIT_BUTTON);
		clickToElement(driver, NewAccountPageUI.NEW_ACCOUNT_SUBMIT_BUTTON);
		
	}

	public boolean isAccountGeneratedSuccessfullyMessageDisplayed() {
		waitForElementVisible(driver, NewAccountPageUI.ACCOUNT_GENERATED_SUCCESS_MESSAGE);
		return isControlDisplayed(driver, NewAccountPageUI.ACCOUNT_GENERATED_SUCCESS_MESSAGE);
	}

	public String getTextCurrentAmount() {
		waitForElementVisible(driver, NewAccountPageUI.CURRENT_AMOUNT_INFOR);
		return getTextElement(driver, NewAccountPageUI.CURRENT_AMOUNT_INFOR);
	}

	
}
