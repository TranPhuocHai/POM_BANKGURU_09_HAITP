package bankguruUI;

public class EditAccountPageUI {
	public static final String ACCOUNT_NUMBER_TEXTBOX = "//input[@name='accountno']";
	public static final String ACCOUNT_NUMBER_SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	public static final String ACCOUNT_NUMBER_RESET_BUTTON = "//input[@name='res']";
	
	public static final String ACCOUNT_NUMBER_MUST_NOT_BE_BANK_MESSAGE = "//label[text()='Account Number must not be blank']";
	public static final String ACCOUNT_NUMBER_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Account No']//following-sibling::td/label[text()='Characters are not allowed']";
}
