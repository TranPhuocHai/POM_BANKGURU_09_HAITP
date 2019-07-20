package bankguru.testdata;

public class CommonTestData {
	
	public static final String BLANK_SPACE = " ";
	public static final String[] NUMERIC_VALUES = new String[] { "1234", "name123" };
	public static final String[] SPECIAL_VALUE = new String[] { "haitp!@#", "!@#" };
	public static final String[] CHARACTER_VALUE = new String[] { "haitp", "12 1234" };
	public static final String[] CHARACTER_PIN_VALUE = new String[] { "123PIN", "HAI321" };
	public static final String[] LESS_THAN_6_DIGITS_PIN_VALUE = new String[] { "1", "12", "321", "3214", "32147" };
	public static final String[] INCORRECT_EMAILS = new String[] { "guru99@gmail", "guru99", "guru99@", "guru99@gmail.", "guru99gmail.com" };
	
	public static final String VALID_NAME = "Tran Phuoc Hai";
	public static final String EXPECTED_GENDER = "male";
	public static final String VALID_DOB = "1988-07-31";
	
	public static final String ADDRESS = "100 Dia Chi";
	public static final String CITY = "Ha Noi";
	public static final String STATE = "Hoan Kiem";
	public static final String PIN = "600000";
	public static final String MOBILE_NUMBER = "0987654321";
	public static final String EMAIL = "haitp";
	public static final String PASSWORD = "sdhgd3123";
	
	public static final String AMOUNT = "50000";
	

	public static final String WITHOUT_NUMBER_NEW_PASSWORD = "bab#nnam@sau";
	public static final String WITHOUT_SPECIAL_CHARACTER_NEW_PASSWORD = "bab1nnam4sau";
	public static final String[] PASSWORD_STRING_NEW_PASSWORDS = new String[] {"b@b#n1Password","b@b#n1password"};
	public static final String VALID_NEW_PASSWORD = "bs@#12jks";
	public static final String CONFIRMED_PASSWORD = "ba@#12jks";
	
	public static final String CHANGE_PASSWORD_TITLE = "Change Password";
	public static final String CUSTOMIZED_STATEMENT_TITLE = "Customized Statement Form";
	public static final String MINI_STATEMENT_TITLE = "Mini Statement Form";

}
