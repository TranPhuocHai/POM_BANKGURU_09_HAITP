package bankguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class NewAccountPageObject extends AbstractPage {
	public NewAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	public String getTextCurrentAmount;

	
}
