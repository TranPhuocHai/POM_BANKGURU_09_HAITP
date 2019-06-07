package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.MiniStatementPageUI;
import commons.AbstractPage;

public class MiniStatementPageObject extends AbstractPage {
	public MiniStatementPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isLastFiveTransactionDetailsDispayed(String accountID) {
		waitForElementVisible(driver, MiniStatementPageUI.DYNAMIC_LAST_FIVE_TRANSACTION_MESSAGE, accountID);
		return isControlDisplayed(driver, MiniStatementPageUI.DYNAMIC_LAST_FIVE_TRANSACTION_MESSAGE, accountID);
	}


}
