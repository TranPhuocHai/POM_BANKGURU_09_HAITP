package pageObjects;

import org.openqa.selenium.WebDriver;
import bankguru.HomePageUI;
import commons.AbstractPage;

public class HomePageObject extends AbstractPage {
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isWelcomeMessageDisplayed() {
		waitForElementVisible(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
		return isControlDisplayed(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
		
	}

	public boolean isUserIDDisplayed(String userIdInfo) {
		String FORMAT_USER_ID_TEXT = String.format(HomePageUI.WELCOME_USER_ID_TEXT, userIdInfo);
		waitForElementVisible(driver, FORMAT_USER_ID_TEXT);
		return isControlDisplayed(driver, FORMAT_USER_ID_TEXT);
		
	}

}
