package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.BalanceEnquiryPageUI;
import commons.AbstractPage;

public class BalanceEnquiryPageObject extends AbstractPage {
	public BalanceEnquiryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void inputValueToAccountNumber(String value) {
		waitForElementVisible(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TEXTBOX, value);
		
	}

	public void clickSubmitButton() {
		waitForElementVisible(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON);
		clickToElement(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON);
		
	}

	public boolean isBalanceDetailsMessageDisplayed(String accountID) {
		waitForElementVisible(driver, BalanceEnquiryPageUI.BALANCE_DETAILS_MESSAGE, accountID);
		return isControlDisplayed(driver, BalanceEnquiryPageUI.BALANCE_DETAILS_MESSAGE, accountID);
	}



	
}
