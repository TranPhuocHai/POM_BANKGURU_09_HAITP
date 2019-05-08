package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.DepositPageUI;
import bankguru.HomePageUI;
import commons.AbstractPage;

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

	public void clickToDepositSubmitButton() {
		waitForElementVisible(driver, DepositPageUI.DEPOSIT_SUBMIT_BUTTON);
		clickToElement(driver, DepositPageUI.DEPOSIT_SUBMIT_BUTTON);
		
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




	
}
