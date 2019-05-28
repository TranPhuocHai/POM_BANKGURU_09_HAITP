package bankguruUI;

public class AbstractPageUI {
	public static final String DYNAMIC_LINK = "//ul[@class='menusubnav']//a[text()='%s']";
	public static final String DYNAMIC_MUST_NOT_BE_BLANK_MESSAGE = "//label[text()='%s must not be blank']";
	public static final String DYNAMIC_NUMERIC_ARE_NOT_ALLOW_MESSAGE = "//td[text()='%s']//following-sibling::td/label[text()='Numbers are not allowed']";
	public static final String DYNAMIC_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='%s']//following-sibling::td/label[text()='Characters are not allowed']";
	public static final String DYNAMIC_FIRST_CHARACTERS_CAN_NOT_HAVE_SPACE_MESSAGE = "//td[text()='%s']//following-sibling::td/label[text()='First character can not have space']";
	public static final String DYNAMIC_SPECIAL_CHARACTERS_ARE_NOT_ALLOW_MESSAGE = "//td[text()='%s']//following-sibling::td/label[text()='Special characters are not allowed']";
	
	public static final String CUSTOMER_ID_IS_REQUIRED_MESSAGE = "//label[text()='Customer ID is required']";
}
