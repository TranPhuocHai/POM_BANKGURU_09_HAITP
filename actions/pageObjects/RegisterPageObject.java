package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.RegisterPageUI;
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
		waitForElementVisible(driver, AbstractPageUI.SUBMIT_BUTTON);
		clickToElement(driver, AbstractPageUI.SUBMIT_BUTTON);
	}

	public String getUserIDInfor() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TABLE_INFOR, "User ID :");
		return getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_INFOR, "User ID :");
	}

	public String getPasswordInfor() {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TABLE_INFOR, "Password :");
		return getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_INFOR, "Password :");
	}

	public LoginPageObject openLoginPage(String loginPageUrl) {
		openAnyUrl(driver, loginPageUrl);
		return PageFactoryManager.getLoginPage(driver);
		
	}

}

