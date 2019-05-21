package bankguruUI;

public class NewAccountPageUI {
	public static final String ADD_NEW_ACCOUNT_FORM_MESSAGE = "//p[text()='Add new account form']";
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
	public static final String ACCOUNT_TYPE_DROPDOWN = "//select[@name='selaccount']";
	public static final String INITIAL_DEPOSIT_TEXTBOX = "//input[@name='inideposit']";
	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
	public static final String RESET_BUTTON = "//input[@type='reset']";
	public static final String ACCOUNT_GENERATED_SUCCESS_MESSAGE = "//p[text()='Account Generated Successfully!!!']";
	public static final String CURRENT_AMOUNT_INFOR = "//td[text()='Current Amount']/following-sibling::td";
	public static final String ACCOUNT_ID_INFOR = "//td[text()='Account ID']/following-sibling::td";
	public static final String DATE_OF_OPENING_INFOR = "//td[text()='Date of Opening']/following-sibling::td";
	public static final String ACCOUNT_TYPE_INFOR = "//td[text()='Account Type']/following-sibling::td";
	
	public static final String CUSTOMER_ID_IS_REQUIRED_MESSAGE = "//label[text()='Customer ID is required']";
	public static final String CUSTOMER_ID_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Customer id']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String CUSTOMER_ID_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Customer id']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String CUSTOMER_ID_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='Customer id']//following-sibling::td/label[text()='First character can not have space']";
	
	public static final String INITIAL_DEPOSIT_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='Initial Deposit must not be blank']";
	public static final String INITIAL_DEPOSIT_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[contains(text(),'Initial deposit')]//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String INITIAL_DEPOSIT_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[contains(text(),'Initial deposit')]//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String INITIAL_DEPOSIT_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[contains(text(),'Initial deposit')]//following-sibling::td/label[text()='First character can not have space']";

}
