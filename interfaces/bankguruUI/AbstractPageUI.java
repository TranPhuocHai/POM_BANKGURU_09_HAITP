package bankguruUI;

public class AbstractPageUI {
	public static final String DYNAMIC_LINK = "//ul[@class='menusubnav']//a[text()='%s']";
	public static final String DYNAMIC_TABLE_INFOR = "//td[text()='%s']//following-sibling::td";
	
//	public static final String DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='%s must not be blank']";
//	public static final String DYNAMIC_NUMERIC_ARE_NOT_ALLOW_MESSAGE = "//td[text()='%s']//following-sibling::td/label[text()='Numbers are not allowed']";
//	public static final String DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='%s']//following-sibling::td/label[text()='Characters are not allowed']";
//	public static final String DYNAMIC_FIRST_CHARACTER_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='%s']//following-sibling::td/label[text()='First character can not have space']";
//	public static final String DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='%s']//following-sibling::td/label[text()='Special characters are not allowed']";
//	public static final String CUSTOMER_ID_IS_REQUIRED_MESSAGE = "//label[text()='Customer ID is required']";
//	public static final String ACCOUNT_SUBMIT_BUTTON = "//input[@name='AccSubmit']";
//	public static final String ACCOUNT_RESET_BUTTON = "//input[@name='res']";
//	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
//	public static final String RESET_BUTTON = "//input[@type='reset']";
//	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
//	public static final String ACCOUNT_NO_TEXTBOX = "//input[@name='accountno']";
	
	
	public static final String DYNAMIC_TEXTBOX_TEXTAREA = "(//textarea | // input) [@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_BUTTON = "//input[@name='%s']";
	public static final String DYNAMIC_DROPDOWN = "//select[@name='%s']";
	public static final String DYNAMIC_VALIDATE_MESSAGE = "//td[contains(text(),'%s')]//following-sibling::td/label";
	public static final String DYNAMIC_PAGE_TITLE = "//p[@class='heading3' and text()='%s']";
}
