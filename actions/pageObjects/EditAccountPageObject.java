package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.EditCustomerPageUI;
import bankguruUI.NewCustomerPageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class EditAccountPageObject extends AbstractPage {
	WebDriver driver;
	public EditAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}


}
