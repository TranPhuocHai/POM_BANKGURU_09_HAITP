package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bankguruUI.CatalogSearchPageUI;
import bankguruUI.LiveGuruAbstractPageUI;
import commons.AbstractPage;

public class CatalogSearchPageObject extends AbstractPage {
	public CatalogSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void clickToSearchButton() {
		waitForElementVisible(driver, CatalogSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, CatalogSearchPageUI.SEARCH_BUTTON);
	}

	public void printAllProductsAndprices() {
		List<WebElement> allProducts = driver.findElements(By.xpath(CatalogSearchPageUI.ALL_PRODUCT_NAME));

		for (int i = 0; i < allProducts.size(); i++) {
			System.out.println("==================================================");
			
			String productName = allProducts.get(i).getAttribute("title");			
			System.out.println("----- " + productName + " -----");
			List<WebElement> howManyKindOfPrices = driver.findElements(By.xpath(String.format(LiveGuruAbstractPageUI.DYNAMIC_PRODUCT_PRICE_IN_LIST_PAGE, productName)));
			if (howManyKindOfPrices.size() < 2) {
				String regularPrice = getTextElement(driver, LiveGuruAbstractPageUI.DYNAMIC_PRODUCT_PRICE_IN_LIST_PAGE, productName).trim();
				System.out.println("PRICE of " + productName + ": " + regularPrice);
			} else {
				String oldPrice = getTextElement(driver, LiveGuruAbstractPageUI.DYNAMIC_OLD_PRICE_IN_LIST_PAGE, productName).trim();
				String specialPrice = getTextElement(driver, LiveGuruAbstractPageUI.DYNAMIC_SPECIAL_PRICE_IN_LIST_PAGE, productName).trim();
				System.out.println("OLD PRICE of " + productName + ": " + oldPrice);
				System.out.println("SPECIAL PRICE of " + productName + ": " + specialPrice);
			}
		} 

	}

}
