package com.bankguru.customer;

public class CustomerTestData {
	
	public static final String BLANK_SPACE = " ";
	public static final String[] NUMERIC_VALUES = new String[] { "1234", "name123" };
	public static final String[] SPECIAL_VALUE = new String[] { "haitp!@#", "!@#" };
	public static final String[] CHARACTER_PIN_VALUE = new String[] { "123PIN", "HAI321" };
	public static final String[] LESS_THAN_6_DIGITS_VALUE = new String[] { "1", "12", "321", "3214", "32147" };
	public static final String[] CHARACTER_PHONE_NUMBERS = new String[] { "haitp", "12 1234" };
	public static final String[] SPECIAL_PHONE_NUMBERS = new String[] { "097@!13546", "!#123654", "0987654#@!" };
	public static final String[] INCORRECT_EMAILS = new String[] { "guru99@gmail", "guru99", "guru99@", "guru99@gmail.", "guru99gmail.com" };

}
