package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruPageFactoryManager.LiveGuruPageFactoryManager;
import liveguruUI.BackEndLoginPageUI;

public class BackEndLoginPageObject extends AbstractPage{
	public BackEndLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void isLoginTitleDisplayed() {
		waitForElementVisible(driver, BackEndLoginPageUI.LOG_IN_TITLE);
		isControlDisplayed(driver, BackEndLoginPageUI.LOG_IN_TITLE);
		
	}

	public BackEndAdminPageObject clickToLoginButton() {
		waitForElementVisible(driver, BackEndLoginPageUI.LOG_IN_BUTTON);
		clickToElement(driver, BackEndLoginPageUI.LOG_IN_BUTTON);
		return LiveGuruPageFactoryManager.getBackEndAdminPage(driver);
		
	}
	

}
