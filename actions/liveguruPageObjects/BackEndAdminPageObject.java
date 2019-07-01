package liveguruPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import liveguruUI.BackEndAdminPageUI;

public class BackEndAdminPageObject extends AbstractPage {
	public BackEndAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void closeIncomingMessagePopUpIfItDisplays() {
		List<WebElement> incomingMessagePopUp = driver.findElements(By.xpath(BackEndAdminPageUI.INCOMING_MESSAGE_POPUP));
		waitForAllElementsPresence(driver, BackEndAdminPageUI.INCOMING_MESSAGE_POPUP);

		if (incomingMessagePopUp.size() == 1) {
			waitForElementVisible(driver, BackEndAdminPageUI.INCOMING_MESSAGE_POPUP_CLOSE_BUTTON);
			clickToElement(driver, BackEndAdminPageUI.INCOMING_MESSAGE_POPUP_CLOSE_BUTTON);
		}

	}

	public void waitForLoadingIconInvisible() {
		waitForElementInvisible(driver, BackEndAdminPageUI.LOADING_ICON);

	}

	public void checkToCheckboxNextFirstOrder() {
		List<WebElement> allCheckBoxes = driver.findElements(By.xpath(BackEndAdminPageUI.ALL_CHECKBOXES));
		waitForAllElementsPresence(driver, BackEndAdminPageUI.ALL_CHECKBOXES);
		if (allCheckBoxes.size() <= 1) {
			allCheckBoxes.get(0).click();
		} else
			allCheckBoxes.get(1).click();

	}

	public void selectItemInDropdownFollowTable(String field, String expectedValue) {
		waitForElementVisible(driver, BackEndAdminPageUI.DYNAMIC_DROPDOWN_FOLLOW_LABEL, field);
		selectItemInDropdown(driver, BackEndAdminPageUI.DYNAMIC_DROPDOWN_FOLLOW_LABEL, expectedValue, field);

	}
	
	

}
