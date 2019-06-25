package liveguruPageFactoryManager;

import org.openqa.selenium.WebDriver;

import liveguruPageObjects.CheckOutPageObject;
import liveguruPageObjects.CompareProductPageObject;
import liveguruPageObjects.HomePageObject;
import liveguruPageObjects.MobilePageObject;
import liveguruPageObjects.MyAccountPageObject;
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
	

}



