package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.BalanceEnquiryPageUI;
import bankguruUI.DeleteAccountPageUI;
import bankguruUI.FundTransferPageUI;
import bankguruUI.WithdrawalPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class DeleteAccountPageObject extends AbstractPage {
	public DeleteAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void inputAccountNumber(String accountID) {
		waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, DeleteAccountPageUI.ACCOUNT_NO_TEXTBOX, accountID);
		
	}

	public void clickSubmitButton() {
		waitForElementVisible(driver, DeleteAccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver, DeleteAccountPageUI.SUBMIT_BUTTON);
	}
	
	public void acceptConfirmDeleteAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}
	
	public HomePageObject acceptDeleteSuccessAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
		return PageFactoryManager.getHomePage(driver);
	}

	public String getTextConfirmDeleteAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}

	public String getTextDeleteSuccessAlertAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}

	
}
