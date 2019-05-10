package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.FundTransferPageUI;
import bankguru.WithdrawPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

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


	public void clickToSubmitButton() {
		waitForElementVisible(driver, FundTransferPageUI.SUBMIT_BUTTON);
		clickToElement(driver, FundTransferPageUI.SUBMIT_BUTTON);
		
	}


	public boolean isFundTransferDetailsMessageDisplayed() {
		waitForElementVisible(driver, FundTransferPageUI.FUND_TRANSFER_DETAILS_MESSAGE);
		return isControlDisplayed(driver, FundTransferPageUI.FUND_TRANSFER_DETAILS_MESSAGE);
	}


	public String getTextPayerAccountNumber() {
		waitForElementVisible(driver, FundTransferPageUI.PAYER_ACCOUNT_NUMBER_INFOR);
		return getTextElement(driver, FundTransferPageUI.PAYER_ACCOUNT_NUMBER_INFOR);
	}


	public String getTextPayeeAccountNumber() {
		waitForElementVisible(driver, FundTransferPageUI.PAYEE_ACCOUNT_NUMBER_INFOR);
		return getTextElement(driver, FundTransferPageUI.PAYEE_ACCOUNT_NUMBER_INFOR);
	}


	public String getTextAmount() {
		waitForElementVisible(driver, FundTransferPageUI.AMOUNT_INFOR);
		return getTextElement(driver, FundTransferPageUI.AMOUNT_INFOR);
	}


	public BalanceEnquiryPageObject clickToBalanceEnquiryLink() {
		waitForElementVisible(driver, FundTransferPageUI.BALANCE_ENQUIRY_LINK);
		clickToElement(driver, FundTransferPageUI.BALANCE_ENQUIRY_LINK);
		return PageFactoryManager.getBalanceEnquiryPage(driver);
	}




	
}
