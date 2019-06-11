package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruUI.MobilePageUI;

public class MobilePageObject extends AbstractPage{
	public MobilePageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	
	public String getCostDynamicProductInMobileListPage(String productName) {
		waitForElementVisible(driver, MobilePageUI.DYNAMIC_PRODUCT_PRICE_IN_LIST_PAGE, productName);
		return getTextElement(driver, MobilePageUI.DYNAMIC_PRODUCT_PRICE_IN_LIST_PAGE, productName);
		
	}

	public String getCostDynamicProductInMobileDetailsPage(String productName) {
		waitForElementVisible(driver, MobilePageUI.DYNAMIC_PRODUCT_PRICE_IN_DETAILS_PAGE, productName);
		return getTextElement(driver, MobilePageUI.DYNAMIC_PRODUCT_PRICE_IN_DETAILS_PAGE, productName);
		
	}

	public void clickToDynamicProductLink(String productName) {
		waitForElementVisible(driver, MobilePageUI.DYNAMIC_PRODUCT_LINK, productName);
		clickToElement(driver, MobilePageUI.DYNAMIC_PRODUCT_LINK, productName);
		
	}

	public void clickToDynamicAddToCartButton(String productName) {
		waitForElementVisible(driver, MobilePageUI.DYNAMIC_ADD_TO_CART_BUTTON, productName);
		clickToElement(driver, MobilePageUI.DYNAMIC_ADD_TO_CART_BUTTON, productName);
		
	}

	public boolean isShoppingCartMessageDisplayed() {
		waitForElementVisible(driver, MobilePageUI.SHOPPING_CART_MESSAGE);
		return isControlDisplayed(driver, MobilePageUI.SHOPPING_CART_MESSAGE);
		
	}

	public boolean isDynamicProductLinkDisplayed(String productName) {
		waitForElementVisible(driver, MobilePageUI.DYNAMIC_PRODUCT_LINK, productName);
		return isControlDisplayed(driver, MobilePageUI.DYNAMIC_PRODUCT_LINK, productName);
	}

	public boolean isDiscountTitleDisplayed(String cuponCode) {
		waitForElementVisible(driver, MobilePageUI.DYNAMIC_DISCOUNT_TITLE, cuponCode);
		return isControlDisplayed(driver, MobilePageUI.DYNAMIC_DISCOUNT_TITLE, cuponCode);
		
	}
	
	public String getTextDiscountMoney(String cuponCode) {
		waitForElementVisible(driver, MobilePageUI.DYNAMIC_DISCOUNT_MONEY, cuponCode);
		return getTextElement(driver, MobilePageUI.DYNAMIC_DISCOUNT_MONEY, cuponCode);
		
	}

	public String getTextGrandTotalMoney() {
		waitForElementVisible(driver, MobilePageUI.GRANT_TOTAL_MONEY);
		return getTextElement(driver, MobilePageUI.GRANT_TOTAL_MONEY);
		
	}

	public void clearDynamicQTYTextbox(String productName) {
		waitForElementVisible(driver, MobilePageUI.DYNAMIC_QTY_TEXTBOX, productName);
		clearTextElement(driver, MobilePageUI.DYNAMIC_QTY_TEXTBOX, productName);
		
	}

	public void inputToDynamicQTYTextbox(String productName, String productQuantity) {
		waitForElementVisible(driver, MobilePageUI.DYNAMIC_QTY_TEXTBOX, productName);
		sendKeyToElement(driver, MobilePageUI.DYNAMIC_QTY_TEXTBOX, productQuantity, productName);
		
		
	}

	public void clickToDynamiUpdateButton(String productName) {
		waitForElementVisible(driver, MobilePageUI.DYNAMIC_UPDATE_BUTTON, productName);
		clickToElement(driver, MobilePageUI.DYNAMIC_UPDATE_BUTTON, productName);
		
	}

	public String getTextDynamicErrorMessage(String productName) {
		waitForElementVisible(driver, MobilePageUI.DYNAMIC_ERROR_MESSAGE, productName);
		return getTextElement(driver, MobilePageUI.DYNAMIC_ERROR_MESSAGE, productName);
	}



}
