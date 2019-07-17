package PageFactoryManager;

import org.openqa.selenium.WebDriver;

import liveguruPageObjects.BackEndAdminPageObject;
import liveguruPageObjects.BackEndLoginPageObject;
import liveguruPageObjects.CatalogSearchPageObject;
import liveguruPageObjects.CheckOutPageObject;
import liveguruPageObjects.CompareProductPageObject;
import liveguruPageObjects.HomePageObject;
import liveguruPageObjects.MobilePageObject;
import liveguruPageObjects.MyAccountPageObject;
import liveguruPageObjects.ProductReviewPageObject;
import liveguruPageObjects.RegisterPageObject;
import liveguruPageObjects.ShoppingCartPageObject;
import liveguruPageObjects.TVPageObject;

public class LiveGuruPageFactoryManager {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	
	public static MobilePageObject getMobilePage(WebDriver driver) {
		return new MobilePageObject(driver);
	}
	
	public static TVPageObject getTVPage(WebDriver driver) {
		return new TVPageObject(driver);
	}
	
	public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}
	
	public static CompareProductPageObject getCompareProductPage(WebDriver driver) {
		return new CompareProductPageObject(driver);
	}
	
	public static CheckOutPageObject getCheckOutPage(WebDriver driver) {
		return new CheckOutPageObject(driver);
	}
	
	public static CatalogSearchPageObject getCatalogSearchPage(WebDriver driver) {
		return new CatalogSearchPageObject(driver);
	}
	
	
	public static BackEndLoginPageObject getBackEndLoginPage(WebDriver driver) {
		return new BackEndLoginPageObject(driver);
	}
	
	
	public static BackEndAdminPageObject getBackEndAdminPage(WebDriver driver) {
		return new BackEndAdminPageObject(driver);
	}
	
	public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductReviewPageObject(driver);
	}
	
	

}



