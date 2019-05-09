package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.DepositPageUI;
import bankguru.HomePageUI;
import bankguru.WithdrawPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class WithdrawPageObject extends AbstractPage {
	public WithdrawPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isAmountWithdrawFormDisplayed() {
		waitForElementVisible(driver, WithdrawPageUI.AMOUNT_WITHDRAW_FORM_MESSAGE);
		return isControlDisplayed(driver, WithdrawPageUI.AMOUNT_WITHDRAW_FORM_MESSAGE);
		
	}

	public void inputAccountIDToAccountNoTextbox(String accountID) {
		waitForElementVisible(driver, WithdrawPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, WithdrawPageUI.ACCOUNT_NO_TEXTBOX, accountID);
		
	}

	public void inputAmountToAmountTextbox(String withdrawAmount) {
		waitForElementVisible(driver, WithdrawPageUI.AMOUNT_TEXTBOX);
		sendKeyToElement(driver, WithdrawPageUI.AMOUNT_TEXTBOX, withdrawAmount);
		
	}

	public void clickToWithdrawSubmitButton() {
		waitForElementVisible(driver, WithdrawPageUI.SUBMIT_BUTTON);
		clickToElement(driver, WithdrawPageUI.SUBMIT_BUTTON);
		
	}

	public boolean isCorrectTracsactionDetailsMessageDisplayed(String accountID) {
		String FORMAT_TRANSACTION_DETAILS_MESSAGE = String.format(WithdrawPageUI.TRANSACTION_DETAILS_MESSAGE, accountID);
		waitForElementVisible(driver, FORMAT_TRANSACTION_DETAILS_MESSAGE);
		return isControlDisplayed(driver, FORMAT_TRANSACTION_DETAILS_MESSAGE);
	}

	public String getTextCurrentBalance() {
		waitForElementVisible(driver, WithdrawPageUI.CURRENT_BALANCE_INFOR);
		return getTextElement(driver, WithdrawPageUI.CURRENT_BALANCE_INFOR);
	}

	public void openHomePageUrl(String homePageUrl) {
		openAnyUrl(driver, homePageUrl);
		
	}

	public void inputDescriptionToDescriptionTextbox(String withdrawDescription) {
		waitForElementVisible(driver, WithdrawPageUI.DESCRIPTION_TEXTBOX);
		sendKeyToElement(driver, WithdrawPageUI.DESCRIPTION_TEXTBOX, withdrawDescription);
		
	}

	public FundTransferPageObject clickToFundTransferLink() {
		waitForElementVisible(driver, WithdrawPageUI.FUND_TRANSFER_LINK);
		clickToElement(driver, WithdrawPageUI.FUND_TRANSFER_LINK);
		return PageFactoryManager.getFundTransferPage(driver);
	}

	public NewAccountPageObject clickToNewAccountButton() {
		waitForElementVisible(driver, WithdrawPageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, WithdrawPageUI.NEW_ACCOUNT_LINK);
		return PageFactoryManager.getNewAccountPage(driver);
	}




	
}
