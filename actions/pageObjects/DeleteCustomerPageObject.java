package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguru.BalanceEnquiryPageUI;
import bankguru.DeleteAccountPageUI;
import bankguru.DeleteCustomerPageUI;
import bankguru.EditCustomerPageUI;
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

	public void clearCustomerIDTextbox() {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		clearTextElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		
	}

	public void clickToCustomerIDTexbox() {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		clickToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		
	}

	public void pressTABKeyToCustomerIDTextbox() {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyBoardToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, Keys.TAB);	
		
	}

	public boolean isCustomerIDIsRequiredMessageDisplayed() {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_IS_REQUIRED_MESSAGE);
		return isControlDisplayed(driver, DeleteCustomerPageUI.CUSTOMER_ID_IS_REQUIRED_MESSAGE);
	}

	public void inputBlankSpaceToCustomerIDTextbox(String blankSpace) {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, blankSpace);
		
	}

	public boolean isFirstCharacterOfCustomerIDCanNotHaveSpaceMessageDisplayed() {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
		return isControlDisplayed(driver, DeleteCustomerPageUI.CUSTOMER_ID_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE);
	}

	public void inputChractersValueToCustomerIDTextbox(String characterCustomerID) {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, characterCustomerID);
		
	}

	public boolean isCustomerIDCharacterAreNotAllowMessageDisplayed() {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, DeleteCustomerPageUI.CUSTOMER_ID_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}

	public void inputSpecialCharactersToCustomerIDTextbox(String specialCustomerID) {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, specialCustomerID);
		
	}

	public boolean isSpecialCharactersOfCustomerIDAreNotAllowedMessageDisplayed() {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
		return isControlDisplayed(driver, DeleteCustomerPageUI.CUSTOMER_ID_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE);
	}


	
}
