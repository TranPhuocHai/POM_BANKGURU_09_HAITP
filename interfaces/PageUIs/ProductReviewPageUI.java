package PageUIs;

public class ProductReviewPageUI {
	
	public static final String PUBLIC_REVIEW = "//a[contains(text(),\"%s\")]/parent::dt/following-sibling::dd[contains(text(),\"%s\")]/span[contains(text(),\"Review by %s\")]";
	
	public static final String LET_US_KNOW_YOUR_THOUGHTS_MESSAGE = "//label[text()='Let us know your thoughts']";
	public static final String SUMMARY_OF_YOUR_REVIEW_MESSAGE = "//label[text()='Summary of Your Review']";
	public static final String WHATS_YOUR_NICKNAME_MESSAGE = "//label[text()=\"What's your nickname?\"]";

	public static final String DETAIL_REVIEW_TEXT_AREA = "//textarea[@id='review_field']";
	public static final String FINAL_REVIEW_TEXTBOX = "//input[@id='summary_field']";
	public static final String NICK_NAME_TEXTBOX = "//input[@id='nickname_field']";

	public static final String SUBMIT_REVIEW_BUTTON = "//span[text()='Submit Review']";



}
