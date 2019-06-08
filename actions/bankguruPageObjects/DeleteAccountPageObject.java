package bankguruPageObjects;

import org.openqa.selenium.WebDriver;

import bankguruPageFactoryManager.PageFactoryManager;
import commons.AbstractPage;

public class DeleteAccountPageObject extends AbstractPage {
	public DeleteAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	
	public void acceptConfirmDeleteAccountAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}
	
	public HomePageObject acceptDeleteSuccessAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
		return PageFactoryManager.getHomePage(driver);
	}

	public String getTextConfirmDeleteAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}

	public String getTextDeleteSuccessAlertAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}

	
}
