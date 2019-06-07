package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class RegisterPageObject extends AbstractPage{
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRegisterPageDisplayed() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX_TEXTAREA, "emailid");
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_TEXTBOX_TEXTAREA, "emailid");
	}

	public LoginPageObject openLoginPage(String loginPageUrl) {
		openAnyUrl(driver, loginPageUrl);
		return PageFactoryManager.getLoginPage(driver);
		
	}

}

