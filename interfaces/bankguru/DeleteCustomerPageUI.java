package bankguru;

public class DeleteCustomerPageUI {
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
	public static final String SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	public static final String RESET_BUTTON = "//input[@name='res']";
	
	public static final String CUSTOMER_ID_IS_REQUIRED_MESSAGE = "//label[text()='Customer ID is required']";
	public static final String CUSTOMER_ID_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='Customer ID']//following-sibling::td/label[text()='First character can not have space']";
	public static final String CUSTOMER_ID_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Customer ID']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String CUSTOMER_ID_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Customer ID']//following-sibling::td/label[text()='Special characters are not allowed']";
	
}
