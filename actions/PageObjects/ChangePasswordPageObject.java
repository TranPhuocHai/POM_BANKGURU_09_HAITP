package PageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class ChangePasswordPageObject extends AbstractPage {
	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

}
