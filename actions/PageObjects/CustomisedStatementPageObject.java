package PageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.CustomisedStatementPageUI;
import commons.AbstractPage;

public class CustomisedStatementPageObject extends AbstractPage {
	public CustomisedStatementPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;


	public boolean isTransactionDetailsFormDisplayed(String accountID) {
		waitForElementVisible(driver, CustomisedStatementPageUI.TRANSACTION_FORM_DETAILS_FORM_DYNAMIC, accountID);
		return isControlDisplayed(driver, CustomisedStatementPageUI.TRANSACTION_FORM_DETAILS_FORM_DYNAMIC, accountID);
	}

}
