package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.LoginPageUI;
import commons.AbstractPage;

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

	public void clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}

	public void inPutToUserIDTextbox(String userIdInfo) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userIdInfo);

	}

	public void inPutToPasswordTextbox(String passwordInfo) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordInfo);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

	}

}
