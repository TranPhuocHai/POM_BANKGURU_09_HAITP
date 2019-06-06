package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.LoginPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLoginFormDisplayed() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_FORM);
		return isControlDisplayed(driver, LoginPageUI.LOGIN_FORM);
	}

	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver);
	}

//	public RegisterPageObject clickToHereLink() {
//		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
//		clickToElement(driver, LoginPageUI.HERE_LINK);
//		return PageFactoryManager.getRegisterPage(driver);
//	}
//
//	public void inPutToUserIDTextbox(String userIdInfo) {
//		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
//		sendKeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userIdInfo);
//
//	}
//
//	public void inPutToPasswordTextbox(String passwordInfo) {
//		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
//		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordInfo);
//	}
//
//	public HomePageObject clickToLoginButton() {
//		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
//		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
//		return PageFactoryManager.getHomePage(driver);
//
//	}

}

