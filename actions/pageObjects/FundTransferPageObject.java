package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.FundTransferPageUI;
import commons.AbstractPage;

public class FundTransferPageObject extends AbstractPage {
	public FundTransferPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;


	public void inputDescriptionToDescriptionTextbox(String fundTransferDescription) {
		waitForElementVisible(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX);
		sendKeyToElement(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX, fundTransferDescription);
		
	}


	public void inPutPayersAccountNumber(String accountID) {
		waitForElementVisible(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX, accountID);
		
	}


	public void inPutPayeesAccountNumber(String payeeAccountID) {
		waitForElementVisible(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX, payeeAccountID);
		
	}


	public void inputAmountToAmountTextbox(String value) {
		waitForElementVisible(driver, FundTransferPageUI.AMOUNT_TEXTBOX);
		sendKeyToElement(driver, FundTransferPageUI.AMOUNT_TEXTBOX, value);
		
	}




	
}
