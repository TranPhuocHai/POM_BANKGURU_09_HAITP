package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.FundTransferPageUI;
import commons.AbstractPage;

public class FundTransferPageObject extends AbstractPage {
	public FundTransferPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;


//	public void inputValueToDescriptionTextbox(String value) {
//		waitForElementVisible(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX);
//		sendKeyToElement(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX, value);
//		
//	}
//
//
//	public void inPutValueToPayersAccountNumber(String value) {
//		waitForElementVisible(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX);
//		sendKeyToElement(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX, value);
//		
//	}
//
//
//	public void inPutValueToPayeesAccountNumber(String value) {
//		waitForElementVisible(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX);
//		sendKeyToElement(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX, value);
//		
//	}
//
//
//	public void inputAmountToAmountTextbox(String value) {
//		waitForElementVisible(driver, FundTransferPageUI.AMOUNT_TEXTBOX);
//		sendKeyToElement(driver, FundTransferPageUI.AMOUNT_TEXTBOX, value);
//		
//	}

//
//	public void clickToSubmitButton() {
//		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
//		clickToElement(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
//		
//	}


//	public boolean isFundTransferDetailsMessageDisplayed() {
//		waitForElementVisible(driver, FundTransferPageUI.FUND_TRANSFER_DETAILS_MESSAGE);
//		return isControlDisplayed(driver, FundTransferPageUI.FUND_TRANSFER_DETAILS_MESSAGE);
//	}
//
//
//	public void clearPayersAccountTextbox() {
//		waitForElementVisible(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX);
//		clearTextElement(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX);
//		
//	}
//
//
//	public void clickToPayersAccountTextbox() {
//		waitForElementVisible(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX);
//		clickToElement(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX);
//	}
//
//
//	public void pressTABKeyToPayersAccountTextbox() {
//		waitForElementVisible(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX);	
//		sendKeyBoardToElement(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX, Keys.TAB);
//	}
//	
//	public void clearPayeesAccountTextbox() {
//		waitForElementVisible(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX);
//		clearTextElement(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX);
//		
//	}
//	
//	public void clickToPayeesAccountTextbox() {
//		waitForElementVisible(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX);
//		clickToElement(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX);
//	}
//
//	public void pressTABKeyToPayeesAccountTextbox() {
//		waitForElementVisible(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX);	
//		sendKeyBoardToElement(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX, Keys.TAB);
//	}
//
//
//	public void clearAmountTextbox() {
//		waitForElementVisible(driver, FundTransferPageUI.AMOUNT_TEXTBOX);
//		clearTextElement(driver, FundTransferPageUI.AMOUNT_TEXTBOX);
//		
//	}
//
//
//	public void clickToAmountTextbox() {
//		waitForElementVisible(driver, FundTransferPageUI.AMOUNT_TEXTBOX);
//		clickToElement(driver, FundTransferPageUI.AMOUNT_TEXTBOX);		
//	}
//
//
//	public void pressTABKeyToAmountTextbox() {
//		waitForElementVisible(driver, FundTransferPageUI.AMOUNT_TEXTBOX);	
//		sendKeyBoardToElement(driver, FundTransferPageUI.AMOUNT_TEXTBOX, Keys.TAB);		
//	}
//
//
//	public boolean isDescriptionCanNotBeBlankMessageDisplayed() {
//		waitForElementVisible(driver, FundTransferPageUI.DESCRIPTION_CAN_NOT_BE_BLANK_MESSAGE);
//		return isControlDisplayed(driver, FundTransferPageUI.DESCRIPTION_CAN_NOT_BE_BLANK_MESSAGE);
//	}
//
//
//	public void clearDescriptionTextbox() {
//		waitForElementVisible(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX);
//		clearTextElement(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX);
//	}
//
//
//	public void clickToDescriptionTextbox() {
//		waitForElementVisible(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX);
//		clickToElement(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX);
//		
//	}
//
//
//	public void pressTABKeyToDescriptionTextbox() {
//		waitForElementVisible(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX);
//		sendKeyBoardToElement(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX, Keys.TAB);
//		
//	}
	
	
}
