package bankguru;

public class EditCustomerPageUI {
	
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
	public static final String SUBMIT_CUTOMER_ID_BUTTON = "//input[@name='AccSubmit']";
	public static final String RESET_CUTOMER_ID_BUTTON = "//input[@name='res']";
	
	public static final String EDIT_ADDRESS_TEXTAREA = "//textarea[@name='addr']";	
	public static final String EDIT_CITY_TEXTBOX = "//input[@name='city']";
	public static final String EDIT_STATE_TEXTBOX = "//input[@name='state']";
	public static final String EDIT_PIN_TEXTBOX = "//input[@name='pinno']";
	public static final String EDIT_MOBILE_NUMBER_TEXTBOX = "//input[@name='telephoneno']";
	public static final String EDIT_EMAIL_TEXTBOX = "//input[@name='emailid']";
	public static final String EDIT_SUBMIT_BUTTON = "//input[@type='submit']";
	public static final String EDIT_RESET_BUTTON = "//input[@type='reset']";
	
	public static final String HOME_LINK = "//a[text()='Home']";
	
	public static final String EDIT_CUSTOMER_SUCCESS_MESSAGE  = "//p[text()='Customer details updated Successfully!!!']";
	public static final String EDIT_CUSTOMER_ID = "//td[text()='Customer ID']/following-sibling::td";
	public static final String EDIT_CUSTOMER_NAME_INFOR = "//td[text()='Customer Name']/following-sibling::td";
	public static final String EDIT_GENDER_INFOR = "//td[text()='Gender']/following-sibling::td";
	public static final String EDIT_DATE_OF_BIRTH_INFO_INFOR = "//td[text()='Birthdate']/following-sibling::td";
	public static final String EDIT_ADDRESS_INFOR = "//td[text()='Address']/following-sibling::td";
	public static final String EDIT_CITY_INFOR = "//td[text()='City']/following-sibling::td";
	public static final String EDIT_STATE_INFOR = "//td[text()='State']/following-sibling::td";
	public static final String EDIT_PIN_INFOR = "//td[text()='Pin']/following-sibling::td";
	public static final String EDIT_MOBILE_NUMBER_INFOR = "//td[text()='Mobile No.']/following-sibling::td";
	public static final String EDIT_EMAIL_INFOR = "//td[text()='Email']/following-sibling::td";
	
	public static final String CUSTOMER_ID_IS_REQUIRED_MESSAGE = "//label[text()='Customer ID is required']";
	public static final String CUSTOMER_ID_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Customer ID']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String CUSTOMER_ID_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Customer ID']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String CUSTOMER_ID_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='Customer ID']//following-sibling::td/label[text()='First character can not have space']";
	
	public static final String EDIT_ADDRESS_FIELD_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='Address Field must not be blank']";
	public static final String EDIT_ADDRESS_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Address']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String EDIT_ADDRESS_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='Address']//following-sibling::td/label[text()='First character can not have space']";
	
	public static final String EDIT_CITY_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='City Field must not be blank']";
	public static final String EDIT_CITY_NUMERIC_ARE_NOT_ALLOW_MESSAGE = "//td[text()='City']//following-sibling::td/label[text()='Numbers are not allowed']";
	public static final String EDIT_CITY_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='City']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String EDIT_CITY_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='City']//following-sibling::td/label[text()='First character can not have space']";
	
	public static final String EDIT_STATE_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='State must not be blank']";
	public static final String EDIT_STATE_NUMERIC_ARE_NOT_ALLOW_MESSAGE = "//td[text()='State']//following-sibling::td/label[text()='Numbers are not allowed']";
	public static final String EDIT_STATE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='State']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String EDIT_STATE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='State']//following-sibling::td/label[text()='First character can not have space']";

	public static final String EDIT_PIN_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='PIN Code must not be blank']";
	public static final String EDIT_PIN_MUST_HAVE_6_DIGITS_MESSAGE = "//td[text()='PIN']//following-sibling::td/label[text()='PIN Code must have 6 Digits']";
	public static final String EDIT_PIN_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='PIN']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String EDIT_PIN_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='PIN']//following-sibling::td/label[text()='First character can not have space']";
	
	public static final String EDIT_PHONE_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='Mobile no must not be blank']";
	public static final String EDIT_PHONE_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Mobile Number']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String EDIT_PHONE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Mobile Number']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String EDIT_PHONE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='Mobile Number']//following-sibling::td/label[text()='First character can not have space']";

	public static final String EDIT_EMAIL_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='Email-ID must not be blank']";
	public static final String EDIT_EMAIL_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='E-mail']//following-sibling::td/label[text()='First character can not have space']";
	public static final String EDIT_EMAIL_ID_IS_NOT_VALID_MESSAGE = "//td[text()='E-mail']//following-sibling::td/label[text()='Email-ID is not valid']";
	
}
