package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguruUI.AbstractPageUI;
import bankguruUI.ChangePasswordPageUI;
import commons.AbstractPage;

public class ChangePasswordPageObject extends AbstractPage {
	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void clearOldPasswordTextbox() {
		waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		clearTextElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		
	}

	public void clickToOldPasswordTextbox() {
		waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		clickToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
	}

	public void pressTabKeyToOldPasswordTextbox() {
		waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendKeyBoardToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, Keys.TAB);
		
	}

	public void clearNewPasswordTextbox() {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		clearTextElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		
	}

	public void clickToNewPasswordTextbox() {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		clickToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		
	}

	public void pressTabKeyToNewPasswordTextbox() {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendKeyBoardToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, Keys.TAB);
		
	}

	public void inputValueToNewPasswordTextbox(String value) {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, value);
		
	}

	public boolean isEnterAtLeastOneNumericValueMessageDisplayed() {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_MUST_HAVE_NUMERIC_MESSAGE);
		return isControlDisplayed(driver, ChangePasswordPageUI.NEW_PASSWORD_MUST_HAVE_NUMERIC_MESSAGE);
	}

	public boolean isEnterAtLeastOneSpecialCharacterMessageDisplayed() {
		waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_MUST_HAVE_SPECIAL_CHARACTER_MESSAGE);
		return isControlDisplayed(driver, ChangePasswordPageUI.NEW_PASSWORD_MUST_HAVE_SPECIAL_CHARACTER_MESSAGE);
	}

	public boolean isChooseDifficultPasswordMessageDisplayed() {
		waitForElementVisible(driver, ChangePasswordPageUI.CHOOSE_DIFFICULT_PASSWORD_MESSAGE);
		return isControlDisplayed(driver, ChangePasswordPageUI.CHOOSE_DIFFICULT_PASSWORD_MESSAGE);
	}

	public void clearConfirmPasswordTextbox() {
		waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		clearTextElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		
	}

	public void inputValueToConfirmPasswordTextbox(String value) {
		waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, value);
		
	}

	public boolean isPasswordsDoNotMatchedMessageDisplayed() {
		waitForElementVisible(driver, ChangePasswordPageUI.PASSWORDS_DO_NOT_MATCHED_MESSAGE);
		return isControlDisplayed(driver, ChangePasswordPageUI.PASSWORDS_DO_NOT_MATCHED_MESSAGE);
	}

}
