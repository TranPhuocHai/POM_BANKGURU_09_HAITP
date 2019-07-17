package bankguruPageObjects;

import org.openqa.selenium.WebDriver;

import PageFactoryManager.PageFactoryManager;
import bankguruUI.HomePageUI;
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
		waitForElementVisible(driver, HomePageUI.DYNAMIC_WELCOME_USER_ID_TEXT, userIdInfo);
		return isControlDisplayed(driver, HomePageUI.DYNAMIC_WELCOME_USER_ID_TEXT, userIdInfo);
		
	}

	public LoginPageObject acceptLogOutAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
		return PageFactoryManager.getLoginPage(driver);
	}

	public boolean isLoginFormUndisplayed() {
		waitForElementInvisible(driver, HomePageUI.LOGIN_FORM);
		return isControlUnDisplayed(driver, HomePageUI.LOGIN_FORM);
	}

}
