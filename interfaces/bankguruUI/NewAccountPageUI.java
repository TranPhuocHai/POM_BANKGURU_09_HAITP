package bankguruUI;

public class NewAccountPageUI {
	public static final String ADD_NEW_ACCOUNT_FORM_MESSAGE = "//p[text()='Add new account form']";
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
	public static final String ACCOUNT_TYPE_DROPDOWN = "//select[@name='selaccount']";
	public static final String INITIAL_DEPOSIT_TEXTBOX = "//input[@name='inideposit']";
	public static final String ACCOUNT_GENERATED_SUCCESS_MESSAGE = "//p[text()='Account Generated Successfully!!!']";
	
	public static final String INITIAL_DEPOSIT_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[contains(text(),'Initial deposit')]//following-sibling::td/label[text()='First character can not have space']";
	public static final String INITIAL_DEPOSIT_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[contains(text(),'Initial deposit')]//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String INITIAL_DEPOSIT_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[contains(text(),'Initial deposit')]//following-sibling::td/label[text()='Special characters are not allowed']";
	


}
