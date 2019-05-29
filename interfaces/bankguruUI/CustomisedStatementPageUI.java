package bankguruUI;

public class CustomisedStatementPageUI {
	public static final String CUSTOMISED_STATEMENT_FORM = "//p[text()='Customized Statement Form']";
	public static final String ACCOUNT_NUMBER_TEXTBOX = "//input[@name='accountno']";
	public static final String MINIMUM_TRANSACTION_VALUE_TEXTBOX = "//input[@name='amountlowerlimit']";
	public static final String NUMBER_OF_TRANSACTION_TEXTBOX = "//input[@name='numtransaction']";
	public static final String SUBMIT_BUTTON = "//input[@name='AccSubmit']";

	public static final String TRANSACTION_FORM_DETAILS_FORM_DYNAMIC = "//p[contains(text(),'Transaction Details for Account No: %s from Date:')]";
}
