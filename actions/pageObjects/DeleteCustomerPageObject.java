package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.BalanceEnquiryPageUI;
import bankguru.DeleteAccountPageUI;
import bankguru.DeleteCustomerPageUI;
import bankguru.FundTransferPageUI;
import bankguru.WithdrawPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class DeleteCustomerPageObject extends AbstractPage {
	public DeleteCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	
	
	public void inputCustomerIDNumber(String customerID) {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerID);
		
	}

	public void clickSubmitButton() {
		waitForElementVisible(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);
		
	}

	public String getTextConfirmDeleteAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}

	public void acceptConfirmDeleteAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
		
	}

	public String getTextDeleteSuccessAlertAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}

	public HomePageObject acceptDeleteSuccessAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
		return PageFactoryManager.getHomePage(driver);
	}


	
}
