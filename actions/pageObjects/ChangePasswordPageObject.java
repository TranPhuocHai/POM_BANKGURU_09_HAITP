package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.DepositPageUI;
import bankguruUI.HomePageUI;
import bankguruUI.WithdrawalPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class ChangePasswordPageObject extends AbstractPage {
	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

}
