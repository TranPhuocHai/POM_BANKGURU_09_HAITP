package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.DeleteAccountPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class DeleteAccountPageObject extends AbstractPage {
	public DeleteAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void clickSubmitButton() {
		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
		clickToElement(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
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

	public void clearAccountNumberTextbox() {
		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
		clearTextElement(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
		
	}

	public void clickToAccountNumberTexbox() {
		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
		clickToElement(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
		
	}

	public void pressTABKeyToAccountNumberTextbox() {
		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeyBoardToElement(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX, Keys.TAB);
		
	}


	public void inputValueToAccountNumberTextbox(String value) {
		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeyToElement(driver, AbstractPageUI.ACCOUNT_NO_TEXTBOX, value);
		
	}

	public boolean isDeleteAccountFormDisplayed() {
		waitForElementVisible(driver, DeleteAccountPageUI.DELETE_ACCOUNT_FORM);
		return isControlDisplayed(driver, DeleteAccountPageUI.DELETE_ACCOUNT_FORM);
	}

	
}
