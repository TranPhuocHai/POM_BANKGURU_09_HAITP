package liveguruPageFactoryManager;

import org.openqa.selenium.WebDriver;

import liveguruPageObjects.HomePageObject;
import liveguruPageObjects.MobilePageObject;
import liveguruPageObjects.MyAccountPageObject;
import liveguruPageObjects.RegisterPageObject;
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
	

}



