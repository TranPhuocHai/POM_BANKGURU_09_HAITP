package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.EditAccountPageUI;
import commons.AbstractPage;

public class EditAccountPageObject extends AbstractPage {
	WebDriver driver;
	public EditAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
//	public void clearAccountNumberTextbox() {
//		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
//		clearTextElement(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
//		
//	}
//	
//	public void inputValueToAccountNumberTextbox(String value) {
//		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
//		sendKeyToElement(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX, value);
//		
//	}
//	
//	public void clickToAccountNumberTexbox() {
//		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
//		clickToElement(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
//		
//	}
//	public void pressTABKeyToAccountNumberTextbox() {
//		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX);
//		sendKeyBoardToElement(driver, EditAccountPageUI.ACCOUNT_NUMBER_TEXTBOX, Keys.TAB);
//		
//	}
	
//	public void clickAccountNumberSubmitButton() {
//		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
//		clickToElement(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
//		
//	}
//	public boolean isEditCustomerFormDispayed() {
//		waitForElementVisible(driver, EditAccountPageUI.EDIT_CUSTOMER_FORM);
//		return isControlDisplayed(driver, EditAccountPageUI.EDIT_CUSTOMER_FORM);
//	}
//	public void selectSavingsInAccountTypeDropdown() {
//		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
//		selectItemInDropdown(driver, EditAccountPageUI.ACCOUNT_TYPE_DROPDOWN, "Savings");
//		
//	}
//	public void clickEditAccountSubmitButton() {
//		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
//		clickToElement(driver, AbstractPageUI.ACCOUNT_SUBMIT_BUTTON);
//		
//	}
//	public boolean isAccountDetailsUpdatedSuccessfullyDispayed() {
//		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_DETAILS_UPLOADED_SUCCESS_INFOR);
//		return isControlDisplayed(driver, EditAccountPageUI.ACCOUNT_DETAILS_UPLOADED_SUCCESS_INFOR);
//	}


}
