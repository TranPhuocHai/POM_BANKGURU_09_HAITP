package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.LiveGuruRegisterPageUI;
import commons.AbstractPage;

public class LiveGuruRegisterPageObject extends AbstractPage {
	public LiveGuruRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isRegisterSuccessMessageDisplayed() {
		waitForElementVisible(driver, LiveGuruRegisterPageUI.REGISTER_SUCESS_MESSAGE);
		return isControlDisplayed(driver, LiveGuruRegisterPageUI.REGISTER_SUCESS_MESSAGE);
		
		
	}




}
