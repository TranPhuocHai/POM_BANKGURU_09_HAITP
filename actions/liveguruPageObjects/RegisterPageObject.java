package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruUI.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isRegisterSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCESS_MESSAGE);
		return isControlDisplayed(driver, RegisterPageUI.REGISTER_SUCESS_MESSAGE);
		
		
	}




}
