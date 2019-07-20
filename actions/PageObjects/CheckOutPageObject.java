package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.CheckOutPageUI;
import commons.AbstractPage;

public class CheckOutPageObject extends AbstractPage {
	public CheckOutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isDynamicCheckOutCategoryDisplayed(String categoryText) {
		waitForElementVisible(driver, CheckOutPageUI.DYNAMIC_CHECKOUT_CATEGORY, categoryText);
		return isControlDisplayed(driver, CheckOutPageUI.DYNAMIC_CHECKOUT_CATEGORY, categoryText);

	}

	public boolean isDynamicNumberDisplayed(String number) {
		waitForElementVisible(driver, CheckOutPageUI.DYNAMIC_NUMBER_IMAGE, number);
		return isControlDisplayed(driver, CheckOutPageUI.DYNAMIC_NUMBER_IMAGE, number);

	}
	
	public void clickToBillingContinueButton() {
		waitForElementVisible(driver, CheckOutPageUI.BILLING_CONTINUE_BUTTON);
		clickToElement(driver, CheckOutPageUI.BILLING_CONTINUE_BUTTON);
		
	}
	
	public void clickToShippingContinueButton() {
		waitForElementVisible(driver, CheckOutPageUI.SHIPPING_CONTINUE_BUTTON);
		clickToElement(driver, CheckOutPageUI.SHIPPING_CONTINUE_BUTTON);
		
	}
	
	public void clickToPaymentContinueButton() {
		waitForElementVisible(driver, CheckOutPageUI.PAYMENT_CONTINUE_BUTTON);
		clickToElement(driver, CheckOutPageUI.PAYMENT_CONTINUE_BUTTON);
		
	}

	public void clickToPlaceOrderButton() {
		waitForElementVisible(driver, CheckOutPageUI.PLACE_ORDER_BUTTON);
		clickToElement(driver, CheckOutPageUI.PLACE_ORDER_BUTTON);
				
	}

	public boolean isThankYouForYourPurchaseMessageDisplayed() {
		waitForElementVisible(driver, CheckOutPageUI.THANK_YOU_FOR_YOUR_PURCHASE_MESSAGE_DISPLAYED);
		return isControlDisplayed(driver, CheckOutPageUI.THANK_YOU_FOR_YOUR_PURCHASE_MESSAGE_DISPLAYED);
		
	}
	
	public String getTextOrderNumber() {
		waitForElementVisible(driver, CheckOutPageUI.ORDER_NUMBER);
		return getTextElement(driver, CheckOutPageUI.ORDER_NUMBER);
		
	}

	public void checkToMoneyOrderRadioButton() {
		waitForElementVisible(driver, CheckOutPageUI.MONEY_ORDER_RADIO);
		checkToCheckBoxOrRadioButton(driver, CheckOutPageUI.MONEY_ORDER_RADIO);
		
	}

}
