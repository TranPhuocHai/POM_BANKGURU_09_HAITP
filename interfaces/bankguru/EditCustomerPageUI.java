package bankguru;

public class EditCustomerPageUI {
	
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
	public static final String SUBMIT_CUTOMER_ID_BUTTON = "//input[@name='AccSubmit']";
	public static final String RESET_CUTOMER_ID_BUTTON = "//input[@name='res']";
	
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
	
	public static final String CUSTOMER_ID_IS_REQUIRED_MESSAGE = "//label[text()='Customer ID is required']";
	public static final String CUSTOMER_ID_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Customer ID']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String CUSTOMER_ID_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Customer ID']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String CUSTOMER_ID_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='Customer ID']//following-sibling::td/label[text()='First character can not have space']";
	
	public static final String ADDRESS_FIELD_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='Address Field must not be blank']";
	public static final String ADDRESS_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Address']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String ADDRESS_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='Address']//following-sibling::td/label[text()='First character can not have space']";
	
	public static final String CITY_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='City Field must not be blank']";
	public static final String CITY_NUMERIC_ARE_NOT_ALLOW_MESSAGE = "//td[text()='City']//following-sibling::td/label[text()='Numbers are not allowed']";
	public static final String CITY_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='City']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String CITY_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='City']//following-sibling::td/label[text()='First character can not have space']";
	
	public static final String STATE_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='State must not be blank']";
	public static final String STATE_NUMERIC_ARE_NOT_ALLOW_MESSAGE = "//td[text()='State']//following-sibling::td/label[text()='Numbers are not allowed']";
	public static final String STATE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='State']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String STATE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='State']//following-sibling::td/label[text()='First character can not have space']";

	public static final String PIN_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='PIN Code must not be blank']";
	public static final String PIN_MUST_HAVE_6_DIGITS_MESSAGE = "//td[text()='PIN']//following-sibling::td/label[text()='PIN Code must have 6 Digits']";
	public static final String PIN_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='PIN']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String PIN_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='PIN']//following-sibling::td/label[text()='First character can not have space']";
	
	public static final String PHONE_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='Mobile no must not be blank']";
	public static final String PHONE_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Mobile Number']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String PHONE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Mobile Number']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String PHONE_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='Mobile Number']//following-sibling::td/label[text()='First character can not have space']";

	public static final String EMAIL_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='Email-ID must not be blank']";
	public static final String EMAIL_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='E-mail']//following-sibling::td/label[text()='First character can not have space']";
	public static final String EMAIL_ID_IS_NOT_VALID_MESSAGE = "//td[text()='E-mail']//following-sibling::td/label[text()='Email-ID is not valid']";
	
	public static final String NEW_ACCOUNT_LINK = "//a[text()='New Account']";
	
}
