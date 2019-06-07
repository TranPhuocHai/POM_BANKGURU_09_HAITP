package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;

public class DeleteCustomerPageObject extends AbstractPage {
	public DeleteCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public String getTextConfirmDeleteAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}

	public void acceptConfirmDeleteAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
		
	}

	public String getTextDeleteSuccessAlertAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}

	public HomePageObject acceptDeleteSuccessAlert() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
		return PageFactoryManager.getHomePage(driver);
	}

	
}
