package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.ShoppingCartPageUI;
import commons.AbstractPage;

public class ShoppingCartPageObject extends AbstractPage {
	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public String getTextGrandTotalMoney() {
		waitForElementVisible(driver, ShoppingCartPageUI.GRANT_TOTAL_MONEY);
		return getTextElement(driver, ShoppingCartPageUI.GRANT_TOTAL_MONEY);
		
	}
	
	public String getShippingCost() {
		waitForElementVisible(driver, ShoppingCartPageUI.SHIPPING_COST);
		return getTextElement(driver, ShoppingCartPageUI.SHIPPING_COST);

	}
	
	public boolean isEstimateShippingAndTaxMessageDisplayed() {
		waitForElementVisible(driver, ShoppingCartPageUI.ESTIMATE_SHIPPING_AND_TAX_MESSAGE);
		return isControlDisplayed(driver, ShoppingCartPageUI.ESTIMATE_SHIPPING_AND_TAX_MESSAGE);
	}
	
	public void clickToEstimateButton() {
		waitForElementVisible(driver, ShoppingCartPageUI.ESTIMATE_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.ESTIMATE_BUTTON);
	}

	public boolean isFlatRateInformationDisplayed() {
		waitForElementVisible(driver, ShoppingCartPageUI.FLAT_RATE_INFORMATION);
		return isControlDisplayed(driver, ShoppingCartPageUI.FLAT_RATE_INFORMATION);
		
		
	}

}
