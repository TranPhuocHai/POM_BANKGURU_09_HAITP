package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruUI.LiveGuruAbstractPageUI;
import liveguruUI.MyAccountPageUI;

public class MyAccountPageObject extends AbstractPage {
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;


	public String getTextInforBox() {
		waitForElementVisible(driver, MyAccountPageUI.INFOR_BOX);
		return getTextElement(driver, MyAccountPageUI.INFOR_BOX);
	}

	public void clickToDynamicAddToCartButtonInWishListPage(String productName) {
		waitForElementVisible(driver, LiveGuruAbstractPageUI.DYNAMIC_ADD_TO_CART_IN_WISH_LIST_BUTTON, productName);
		clickToElement(driver, LiveGuruAbstractPageUI.DYNAMIC_ADD_TO_CART_IN_WISH_LIST_BUTTON, productName);

	}

}
