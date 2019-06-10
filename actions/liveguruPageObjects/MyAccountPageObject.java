package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruUI.MyAccountPageUI;

public class MyAccountPageObject extends AbstractPage {
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public boolean isMyDashBoardTextDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.MY_DASHBOARD_TEXT);
		return isControlDisplayed(driver, MyAccountPageUI.MY_DASHBOARD_TEXT);
	}

	public void clickToDynamicMyAccountLink(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, MyAccountPageUI.MY_ACCOUNT_DYNAMIC_LINK, fieldName);
		clickToElement(driver, MyAccountPageUI.MY_ACCOUNT_DYNAMIC_LINK, fieldName);
		
	}

	public boolean isDynamicInforInTextboxCorrect(WebDriver driver, String FieldName, String valueToVerify) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_INFO_IN_TEXTBOX, FieldName, valueToVerify);		
		return isControlDisplayed(driver, MyAccountPageUI.DYNAMIC_INFO_IN_TEXTBOX, FieldName, valueToVerify);	
	}

	public String getTextInforBox(WebDriver driver) {
		waitForElementVisible(driver, MyAccountPageUI.INFOR_BOX);
		return getTextElement(driver, MyAccountPageUI.INFOR_BOX);
	}
	

}
