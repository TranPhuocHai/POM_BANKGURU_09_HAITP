package liveguruPageFactoryManager;

import org.openqa.selenium.WebDriver;

import liveguruPageObjects.HomePageObject;
import liveguruPageObjects.MyAccountPageObject;
import liveguruPageObjects.RegisterPageObject;

public class LiveGuruPageFactoryManager {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccount(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	

}



