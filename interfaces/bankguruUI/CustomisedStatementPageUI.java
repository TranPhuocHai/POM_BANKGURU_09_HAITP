package bankguruUI;

public class CustomisedStatementPageUI {
	public static final String CUSTOMISED_STATEMENT_FORM = "//p[text()='Customized Statement Form']";
	public static final String ACCOUNT_NUMBER_TEXTBOX = "//input[@name='accountno']";
	public static final String MINIMUM_TRANSACTION_VALUE_TEXTBOX = "//input[@name='amountlowerlimit']";
	public static final String NUMBER_OF_TRANSACTION_TEXTBOX = "//input[@name='numtransaction']";
	public static final String SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	
	public static final String ACCOUNT_NUMBER_MUST_NOT_BE_BANK_MESSAGE = "//label[text()='Account Number must not be blank']";
	public static final String ACCOUNT_NUMBER_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Account No']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String ACCOUNT_NUMBER_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Account No']//following-sibling::td/label[text()='Special characters are not allowed']";
	
	public static final String MINIMUM_TRANSACTION_VALUE_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Minimum Transaction Value']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String MINIMUM_TRANSACTION_VALUE_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Minimum Transaction Value']//following-sibling::td/label[text()='Special characters are not allowed']";
	
	public static final String NUMBER_OF_TRANSACTION_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Number of Transaction']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String NUMBER_OF_TRANSACTION_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Number of Transaction']//following-sibling::td/label[text()='Special characters are not allowed']";

	public static final String TRANSACTION_FORM_DETAILS_FORM_DYNAMIC = "//p[contains(text(),'Transaction Details for Account No: %s from Date:')]";
}
