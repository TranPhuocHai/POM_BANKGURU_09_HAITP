package PageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class FundTransferPageObject extends AbstractPage {
	public FundTransferPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
}
