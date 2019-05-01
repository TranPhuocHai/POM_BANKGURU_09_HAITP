package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguru.NewCustomerPageUI;
import commons.AbstractPage;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;
	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void getNewCustomerPageUrl() {
		getCurrentPageUrl(driver);
	}

	public void clickToCustomerNameTextbox() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
	}

	public void pressTabKey() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyBoardToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);
		
	}

	public boolean isCustomerNameMustNotBeBlankMessageDisplayed() {
		return isControlDisplayed(driver, NewCustomerPageUI.CUSTOMER_NAME_MUST_NOT_BE_BLANK_MESSAGE);
	}

	public void clickToDateOfBirthTexbox() {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		
	}

}
