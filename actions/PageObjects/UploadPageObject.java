package PageObjects;

import org.openqa.selenium.WebDriver;

import bankguruUI.UploadPageUI;
import commons.AbstractPage;

public class UploadPageObject extends AbstractPage {
	public UploadPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void uploadImageToUploadPage(String filePath) {
		waitForElementVisible(driver, UploadPageUI.FILES_BUTTON);
		uploadSingleFileBySendKeyToElement(driver, filePath, UploadPageUI.FILES_BUTTON, UploadPageUI.START_UPLOAD_BUTTON);
	}

}
