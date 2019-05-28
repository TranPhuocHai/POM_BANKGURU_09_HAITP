package bankguruUI;

public class NewCustomerPageUI {
	
	public static final String CUSTOMER_NAME_TEXTBOX = "//input[@name='name']";
	public static final String MALE_RADIO_BUTTON = "//input[@type='radio' and @value='m']";
	public static final String FEMALE_RADIO_BUTTON = "//input[@type='radio' and @value='f']";
	public static final String DATE_OF_BIRTH_TEXTBOX = "//input[@name='dob']";
	public static final String ADDRESS_TEXTAREA = "//textarea[@name='addr']";	
	public static final String CITY_TEXTBOX = "//input[@name='city']";
	public static final String STATE_TEXTBOX = "//input[@name='state']";
	public static final String PIN_TEXTBOX = "//input[@name='pinno']";
	public static final String MOBILE_NUMBER_TEXTBOX = "//input[@name='telephoneno']";
	public static final String EMAIL_TEXTBOX = "//input[@name='emailid']";
	public static final String PASSWORD_TEXTBOX = "//input[@name='password']";	
	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
	public static final String RESET_BUTTON = "//input[@type='reset']";
	public static final String REGISTER_CUSTOMER_SUCCESS_MESSAGE  = "//p[text()='Customer Registered Successfully!!!']";
	public static final String CUSTOMER_ID = "//td[text()='Customer ID']/following-sibling::td";
	
	public static final String CUSTOMER_NAME_INFOR = "//td[text()='Customer Name']/following-sibling::td";
	public static final String GENDER_INFOR = "//td[text()='Gender']/following-sibling::td";
	public static final String DATE_OF_BIRTH_INFO_INFOR = "//td[text()='Birthdate']/following-sibling::td";
	public static final String ADDRESS_INFOR = "//td[text()='Address']/following-sibling::td";
	public static final String CITY_INFOR = "//td[text()='City']/following-sibling::td";
	public static final String STATE_INFOR = "//td[text()='State']/following-sibling::td";
	public static final String PIN_INFOR = "//td[text()='Pin']/following-sibling::td";
	public static final String MOBILE_NUMBER_INFOR = "//td[text()='Mobile No.']/following-sibling::td";
	public static final String EMAIL_INFOR = "//td[text()='Email']/following-sibling::td";
	
	public static final String PIN_MUST_HAVE_6_DIGITS_MESSAGE = "//td[text()='PIN']//following-sibling::td/label[text()='PIN Code must have 6 Digits']";
	public static final String EMAIL_ID_IS_NOT_VALID_MESSAGE = "//td[text()='E-mail']//following-sibling::td/label[text()='Email-ID is not valid']";
	
	
}
