package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import bankguruPageFactoryManager.LiveGuruPageFactoryManager;
import commons.AbstractPage;
import liveguruUI.BackEndLoginPageUI;

public class BackEndLoginPageObject extends AbstractPage{
	public BackEndLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isLoginTitleDisplayed() {
		waitForElementVisible(driver, BackEndLoginPageUI.LOG_IN_TITLE);
		return isControlDisplayed(driver, BackEndLoginPageUI.LOG_IN_TITLE);
		
	}

	public BackEndAdminPageObject clickToLoginButton() {
		waitForElementVisible(driver, BackEndLoginPageUI.LOG_IN_BUTTON);
		clickToElement(driver, BackEndLoginPageUI.LOG_IN_BUTTON);
		return LiveGuruPageFactoryManager.getBackEndAdminPage(driver);
		
	}

	public void inputToUserNameTextbox(String userName) {
		waitForElementVisible(driver, BackEndLoginPageUI.USER_NAME_TEXTBOX);
		sendKeyToElement(driver, BackEndLoginPageUI.USER_NAME_TEXTBOX, userName);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, BackEndLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, BackEndLoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public BackEndLoginPageObject openBackEndPage(String backEndPageUrl) {
		openAnyUrl(driver, backEndPageUrl);
		return LiveGuruPageFactoryManager.getBackEndLoginPage(driver);
	}

}
