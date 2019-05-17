package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.DepositPageUI;
import bankguruUI.HomePageUI;
import bankguruUI.NewAccountPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class DepositPageObject extends AbstractPage {
	public DepositPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isAmountDepositFormDisplayed() {
		waitForElementVisible(driver, DepositPageUI.AMOUNT_DEPOSIT_FORM_MESSAGE);
		return isControlDisplayed(driver, DepositPageUI.AMOUNT_DEPOSIT_FORM_MESSAGE);
		
	}

	public void inputAccountIDToAccountNoTextbox(String accountID) {
		waitForElementVisible(driver, DepositPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, DepositPageUI.ACCOUNT_NO_TEXTBOX, accountID);
		
	}

	public void inputAmountToAmountTextbox(String depositAmount) {
		waitForElementVisible(driver, DepositPageUI.AMOUNT_TEXTBOX);
		sendKeyToElement(driver, DepositPageUI.AMOUNT_TEXTBOX, depositAmount);
		
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, DepositPageUI.SUBMIT_BUTTON);
		clickToElement(driver, DepositPageUI.SUBMIT_BUTTON);
		
	}

	public boolean isCorrectTracsactionDetailsMessageDisplayed(String accountID) {
		String FORMAT_TRANSACTION_DETAILS_MESSAGE = String.format(DepositPageUI.TRANSACTION_DETAILS_MESSAGE, accountID);
		waitForElementVisible(driver, FORMAT_TRANSACTION_DETAILS_MESSAGE);
		return isControlDisplayed(driver, FORMAT_TRANSACTION_DETAILS_MESSAGE);
	}

	public String getTextCurrentBalance() {
		waitForElementVisible(driver, DepositPageUI.CURRENT_BALANCE_INFOR);
		return getTextElement(driver, DepositPageUI.CURRENT_BALANCE_INFOR);
	}

	public void openHomePageUrl(String homePageUrl) {
		openAnyUrl(driver, homePageUrl);
		
	}

	public void inputDescriptionToDescriptionTextbox(String depositDescription) {
		waitForElementVisible(driver, DepositPageUI.DESCRIPTION_TEXTBOX);
		sendKeyToElement(driver, DepositPageUI.DESCRIPTION_TEXTBOX, depositDescription);
		
	}

	public WithdrawPageObject clickToWithdrawLink() {
		waitForElementVisible(driver, DepositPageUI.WITHDRAW_LINK);
		clickToElement(driver, DepositPageUI.WITHDRAW_LINK);
		return PageFactoryManager.getWithdrawPage(driver);
				
	}


	
}
