package bankguru;

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
	
	public static final String NAME_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='Customer name must not be blank']";
	public static final String NAME_NUMERIC_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Customer Name']//following-sibling::td/label[text()='Numbers are not allowed']";
	public static final String NAME_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Customer Name']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String NAME_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='Customer Name']//following-sibling::td/label[text()='First character can not have space']";
	
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

	public static final String PASSWORD_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='Password must not be blank']";

	
}
