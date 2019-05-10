package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.BalanceEnquiryPageUI;
import bankguru.FundTransferPageUI;
import bankguru.WithdrawPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class BalanceEnquiryPageObject extends AbstractPage {
	public BalanceEnquiryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void inputAccountNumber(String accountID) {
		waitForElementVisible(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TEXTBOX, accountID);
		
	}

	public void clickSubmitButton() {
		waitForElementVisible(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON);
		clickToElement(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON);
		
	}

	public boolean isBalanceDetailsMessageDisplayed(String accountID) {
		String FORMAT_BALANCE_DETAILS_MESSAGE = String.format(BalanceEnquiryPageUI.BALANCE_DETAILS_MESSAGE, accountID);
		waitForElementVisible(driver, FORMAT_BALANCE_DETAILS_MESSAGE);
		return isControlDisplayed(driver, FORMAT_BALANCE_DETAILS_MESSAGE);
	}

	public String getTextBalance() {
		waitForElementVisible(driver, BalanceEnquiryPageUI.BALANCE_INFOR);
		return getTextElement(driver, BalanceEnquiryPageUI.BALANCE_INFOR);
	}

	public DeleteAccountPageObject clickToDeleteAccountLink() {
		waitForElementVisible(driver, BalanceEnquiryPageUI.DELETE_ACCOUNT_LINK);
		clickToElement(driver, BalanceEnquiryPageUI.DELETE_ACCOUNT_LINK);
		return PageFactoryManager.getDeleteAccountPage(driver);
		
	}


	
}
