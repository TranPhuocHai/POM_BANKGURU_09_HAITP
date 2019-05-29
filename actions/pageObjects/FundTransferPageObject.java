package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.FundTransferPageUI;
import commons.AbstractPage;

public class FundTransferPageObject extends AbstractPage {
	public FundTransferPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;


	public void inputValueToDescriptionTextbox(String value) {
		waitForElementVisible(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX);
		sendKeyToElement(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX, value);
		
	}


	public void inPutValueToPayersAccountNumber(String value) {
		waitForElementVisible(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX, value);
		
	}


	public void inPutValueToPayeesAccountNumber(String value) {
		waitForElementVisible(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX, value);
		
	}


	public void inputAmountToAmountTextbox(String value) {
		waitForElementVisible(driver, FundTransferPageUI.AMOUNT_TEXTBOX);
		sendKeyToElement(driver, FundTransferPageUI.AMOUNT_TEXTBOX, value);
		
	}


	public void clickToSubmitButton() {
		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
		clickToElement(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
		
	}


	public boolean isFundTransferDetailsMessageDisplayed() {
		waitForElementVisible(driver, FundTransferPageUI.FUND_TRANSFER_DETAILS_MESSAGE);
		return isControlDisplayed(driver, FundTransferPageUI.FUND_TRANSFER_DETAILS_MESSAGE);
	}

	
}
