package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruPageFactoryManager.LiveGuruPageFactoryManager;
import liveguruUI.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	
	public boolean isResgisterFormDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_FORM);
		return isControlDisplayed(driver, RegisterPageUI.REGISTER_FORM);
	}

	public void clickToRegisterButton() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

	public boolean isRegisterSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCESS_MESSAGE);
		return isControlDisplayed(driver, RegisterPageUI.REGISTER_SUCESS_MESSAGE);
		
		
	}

	public HomePageObject openHomePage(String url) {
		openAnyUrl(driver, url);
		return LiveGuruPageFactoryManager.getHomePage(driver);
		
	}


}
