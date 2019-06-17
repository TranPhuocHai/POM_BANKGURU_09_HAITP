package com.bankguru.payment;

public class PaymentTestData {
	
	public static final String NAME = "Tran Phuoc Hai";
	public static final String GENDER = "male";
	public static final String DATE_OF_BIRTH = "1988-07-31";
	public static final String ADDRESS = "100 Dia Chi";
	public static final String CITY = "Ha Noi";
	public static final String STATE = "Hoan Kiem";
	public static final String PIN = "600000";
	public static final String MOBILE_NUMBER = "0987654321";
	public static final String EMAIL = "haitp";
	public static final String PASSWORD = "sdhgd3123";
	
	public static final String EDIT_ADRESS = "01 Nguyen Van Linh";
	public static final String EDIT_CITY = "Da Nang";
	public static final String EDIT_STATE = "Ngu Hanh Son";
	public static final String EDIT_PIN = "550000";
	public static final String EDIT_PHONE_NUMBER = "0975123456";
	public static final String EDIT_EMAIL = "hai.gsd@gmail.com";

	private static int INT_INITIAL_AMOUNT = 50000;
	private static int INT_DEPOSIT_AMOUNT = 5000;
	private static int INT_AFTER_DEPOSIT = INT_INITIAL_AMOUNT + INT_DEPOSIT_AMOUNT;
	private static int INT_WITHDRAW_AMOUNT = 15000;
	private static int INT_AFTER_WITHDRAW = INT_AFTER_DEPOSIT - INT_WITHDRAW_AMOUNT;
	private static int INT_TRANSFER_AMOUNT = 10000;
	private static int INT_AFTER_TRANSFER = INT_AFTER_WITHDRAW - INT_TRANSFER_AMOUNT;

	public static final String INITIAL_AMOUNT = String.valueOf(INT_INITIAL_AMOUNT);
	public static final String DEPOSIT_AMOUNT = String.valueOf(INT_DEPOSIT_AMOUNT);
	public static final String AFTER_DEPOSIT = String.valueOf(INT_AFTER_DEPOSIT);
	public static final String WITHDRAW_AMOUNT = String.valueOf(INT_WITHDRAW_AMOUNT);
	public static final String AFTER_WITHDRAW = String.valueOf(INT_AFTER_WITHDRAW);
	public static final String TRANSFER_AMOUNT = String.valueOf(INT_TRANSFER_AMOUNT);
	public static final String AFTER_TRANSFER = String.valueOf(INT_AFTER_TRANSFER);

	public static final String DEPOSIT_DESCRIPTION = "Deposit";
	public static final String WITHDRAW_DESCRIPTION = "Withdraw";
	public static final String FUND_TRANSFER_DESCRIPTION = "Transfer";

	public static final String SAVINGS_ACCOUNT_TYPE = "Savings";
	public static final String CURRENT_ACCOUNT_TYPE = "Current";
	
	public static final String ADD_NEW_CUSTOMER_TITLE = "Add New Customer";
	public static final String CUSTOMER_REGISTERED_SUCCESSFULLY_MESSAGE = "Customer Registered Successfully!!!";
	
	

}
