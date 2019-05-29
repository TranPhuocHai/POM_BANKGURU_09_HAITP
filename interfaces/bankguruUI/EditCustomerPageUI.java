package bankguruUI;

public class EditCustomerPageUI {
	
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
	public static final String ADDRESS_TEXTAREA = "//textarea[@name='addr']";	
	public static final String CITY_TEXTBOX = "//input[@name='city']";
	public static final String STATE_TEXTBOX = "//input[@name='state']";
	public static final String PIN_TEXTBOX = "//input[@name='pinno']";
	public static final String MOBILE_NUMBER_TEXTBOX = "//input[@name='telephoneno']";
	public static final String EMAIL_TEXTBOX = "//input[@name='emailid']";
	public static final String SUBMIT_EDIT_BUTTON = "//input[@type='submit']";
	public static final String RESET_EDIT_BUTTON = "//input[@type='reset']";
	public static final String HOME_LINK = "//a[text()='Home']";
	public static final String SUCCESS_MESSAGE  = "//p[text()='Customer details updated Successfully!!!']";
	public static final String PIN_MUST_HAVE_6_DIGITS_MESSAGE = "//td[text()='PIN']//following-sibling::td/label[text()='PIN Code must have 6 Digits']";
	public static final String EMAIL_ID_IS_NOT_VALID_MESSAGE = "//td[text()='E-mail']//following-sibling::td/label[text()='Email-ID is not valid']";
	
	
}
