package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruUI.MyAccountPageUI;

public class MyAccountPageObject extends AbstractPage {
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;


	public boolean isDynamicInforInTextboxCorrect(WebDriver driver, String fieldName, String valueToVerify) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_INFO_IN_TEXTBOX, fieldName, valueToVerify);		
		return isControlDisplayed(driver, MyAccountPageUI.DYNAMIC_INFO_IN_TEXTBOX, fieldName, valueToVerify);	
	}

	public String getTextInforBox(WebDriver driver) {
		waitForElementVisible(driver, MyAccountPageUI.INFOR_BOX);
		return getTextElement(driver, MyAccountPageUI.INFOR_BOX);
	}
	

}
