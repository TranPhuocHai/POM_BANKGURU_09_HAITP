package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.RegisterPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class RegisterPageObject extends AbstractPage{
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRegisterPageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		return isControlDisplayed(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
	}

	public void inPutToEmailIDTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);	
		sendKeyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, email);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUserIDInfor() {
		waitForElementVisible(driver, RegisterPageUI.USER_ID_INFOR);
		return getTextElement(driver, RegisterPageUI.USER_ID_INFOR);
	}

	public String getPasswordInfor() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_INFOR);
		return getTextElement(driver, RegisterPageUI.PASSWORD_INFOR);
	}

	public LoginPageObject openLoginPage(String loginPageUrl) {
		openAnyUrl(driver, loginPageUrl);
		return PageFactoryManager.getLoginPage(driver);
		
	}

}
