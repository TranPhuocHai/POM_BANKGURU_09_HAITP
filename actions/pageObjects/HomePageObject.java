package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.HomePageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class HomePageObject extends AbstractPage {
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isWelcomeMessageDisplayed() {
		waitForElementVisible(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
		return isControlDisplayed(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
		
	}

	public boolean isUserIDDisplayed(String userIdInfo) {
		String FORMAT_USER_ID_TEXT = String.format(HomePageUI.WELCOME_USER_ID_TEXT, userIdInfo);
		waitForElementVisible(driver, FORMAT_USER_ID_TEXT);
		return isControlDisplayed(driver, FORMAT_USER_ID_TEXT);
		
	}


	public String getHomePageUrl() {
		return getCurrentPageUrl(driver);
	}

	public void clickToEditCustomerButton() {
		waitForElementVisible(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		
	}
	
	public void clickToNewAccountButton() {
		waitForElementVisible(driver, HomePageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.NEW_ACCOUNT_LINK);
		
	}

	public void clickToDepositButton() {
		waitForElementVisible(driver, HomePageUI.DEPOSIT_LINK);
		clickToElement(driver, HomePageUI.DEPOSIT_LINK);
		
	}

	public void clickToWithdrawButton() {
		waitForElementVisible(driver, HomePageUI.WITHDRAW_LINK);
		clickToElement(driver, HomePageUI.WITHDRAW_LINK);
		
	}

	public void clickLogOutButton() {
		waitForElementVisible(driver, HomePageUI.LOG_OUT_BUTTON);
		clickToElement(driver, HomePageUI.LOG_OUT_BUTTON);
		
	}

	public LoginPageObject acceptLogOutAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
		return PageFactoryManager.getLoginPage(driver);
	}

	public DeleteCustomerPageObject clickToDeleteCustomerLink() {
		waitForElementVisible(driver, HomePageUI.DELETE_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.DELETE_CUSTOMER_LINK);
		return PageFactoryManager.getDeleteCustomerPage(driver);
		
	}

	public DeleteAccountPageObject clickToDeleteAccountLink() {
		waitForElementVisible(driver, HomePageUI.DELETE_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.DELETE_ACCOUNT_LINK);
		return PageFactoryManager.getDeleteAccountPage(driver);
		
	}

}
