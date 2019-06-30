package liveguruPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import liveguruUI.BackEndAdminPageUI;

public class BackEndAdminPageObject extends AbstractPage{
	public BackEndAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void closeIncomingMessagePopUpIfItDisplays() {
		List<WebElement> incomingMessagePopUp = driver.findElements(By.xpath(BackEndAdminPageUI.INCOMING_MESSAGE_POPUP));
		
		if (incomingMessagePopUp.size() == 1) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitForElementVisible(driver, BackEndAdminPageUI.INCOMING_MESSAGE_POPUP_CLOSE_BUTTON);
			clickToElement(driver, BackEndAdminPageUI.INCOMING_MESSAGE_POPUP_CLOSE_BUTTON);
		}
		
	}
	

}
