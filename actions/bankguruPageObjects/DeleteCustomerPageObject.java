package bankguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class DeleteCustomerPageObject extends AbstractPage {
	public DeleteCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public String getTextDeleteSuccessAlertAlert() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}

}
