package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.LoginPageUI;
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

	public RegisterPageObject clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			clickToElementByJavascript(driver, LoginPageUI.HERE_LINK);
		} else
			clickToElement(driver, LoginPageUI.HERE_LINK);
		
		return PageFactoryManager.getRegisterPage(driver);
	}

}

