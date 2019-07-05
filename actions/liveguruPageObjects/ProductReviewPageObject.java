package liveguruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguruPageFactoryManager.LiveGuruPageFactoryManager;
import liveguruUI.ProductReviewPageUI;

public class ProductReviewPageObject extends AbstractPage {
	WebDriver driver;

	public ProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLetUsKnowYourThoughtsMessageDisplayed() {
		waitForElementVisible(driver, ProductReviewPageUI.LET_US_KNOW_YOUR_THOUGHTS_MESSAGE);
		return isControlDisplayed(driver, ProductReviewPageUI.LET_US_KNOW_YOUR_THOUGHTS_MESSAGE);
	}

	public boolean isSummaryOfYourReviewMessageDisplayed() {
		waitForElementVisible(driver, ProductReviewPageUI.SUMMARY_OF_YOUR_REVIEW_MESSAGE);
		return isControlDisplayed(driver, ProductReviewPageUI.SUMMARY_OF_YOUR_REVIEW_MESSAGE);
	}

	public boolean isWhatsYourNicknameMessageDisplayed() {
		waitForElementVisible(driver, ProductReviewPageUI.WHATS_YOUR_NICKNAME_MESSAGE);
		return isControlDisplayed(driver, ProductReviewPageUI.WHATS_YOUR_NICKNAME_MESSAGE);
	}

	public void inputToDetailsReviewTextArea(String reviewCommentDetails) {
		waitForElementVisible(driver, ProductReviewPageUI.DETAIL_REVIEW_TEXT_AREA);
		sendKeyToElement(driver, ProductReviewPageUI.DETAIL_REVIEW_TEXT_AREA, reviewCommentDetails);

	}

	public void inputToFinalReviewTextbox(String finalReview) {
		waitForElementVisible(driver, ProductReviewPageUI.FINAL_REVIEW_TEXTBOX);
		sendKeyToElement(driver, ProductReviewPageUI.FINAL_REVIEW_TEXTBOX, finalReview);

	}

	public void inputToNicknameTextbox(String nickName) {
		waitForElementVisible(driver, ProductReviewPageUI.NICK_NAME_TEXTBOX);
		sendKeyToElement(driver, ProductReviewPageUI.NICK_NAME_TEXTBOX, nickName);

	}

	public void clickToSubmitReviewButton() {
		waitForElementVisible(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);

	}

	public BackEndLoginPageObject openBackEndPage(String backEndPageUrl) {
		openAnyUrl(driver, backEndPageUrl);
		return LiveGuruPageFactoryManager.getBackEndLoginPage(driver);
	}

	public boolean isExpectedReviewDisplayed(String one, String two, String three) {
		waitForElementVisible(driver, ProductReviewPageUI.PUBLIC_REVIEW, one, two, three);
		return isControlDisplayed(driver, ProductReviewPageUI.PUBLIC_REVIEW, one, two, three);

	}

}
