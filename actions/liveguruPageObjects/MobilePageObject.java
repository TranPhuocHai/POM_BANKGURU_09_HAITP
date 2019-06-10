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



}
