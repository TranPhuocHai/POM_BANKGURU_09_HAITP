package bankguruUI;

public class EditAccountPageUI {
	public static final String ACCOUNT_NUMBER_TEXTBOX = "//input[@name='accountno']";
	public static final String ACCOUNT_NUMBER_SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	public static final String ACCOUNT_NUMBER_RESET_BUTTON = "//input[@name='res']";
	
	public static final String ACCOUNT_NUMBER_MUST_NOT_BE_BANK_MESSAGE = "//label[text()='Account Number must not be blank']";
	public static final String ACCOUNT_NUMBER_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Account No']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String ACCOUNT_NUMBER_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='Account No']//following-sibling::td/label[text()='Special characters are not allowed']";
	public static final String EDIT_CUSTOMER_FORM = "//p[text()='Edit Account Entry Form']";
	public static final String ACCOUNT_TYPE_DROPDOWN = "//select[@name='a_type']";
	public static final String EDIT_ACCOUNT_SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	public static final String ACCOUNT_DETAILS_UPLOADED_SUCCESS_INFOR = "//p[text()='Account details updated Successfully!!!']";
	public static final String ACCOUNT_TYPE_INFOR = "//td[text()='Account Type']/following-sibling::td";

}
