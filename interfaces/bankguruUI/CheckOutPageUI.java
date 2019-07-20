package bankguruUI;

public class CheckOutPageUI {
	public static final String DYNAMIC_CHECKOUT_CATEGORY = "//h2[text()='%s']";
	public static final String DYNAMIC_NUMBER_IMAGE = "//span[@class='number' and text()='%s']";
	public static final String BILLING_CONTINUE_BUTTON = "//div[@id='billing-buttons-container']//button[@title='Continue']";
	public static final String SHIPPING_CONTINUE_BUTTON = "//div[@id='shipping-method-buttons-container']//span[text()='Continue']";
	public static final String PAYMENT_CONTINUE_BUTTON = "//div[@id='payment-buttons-container']//span[text()='Continue']";
	public static final String PLACE_ORDER_BUTTON = "//span[text()='Place Order']";

	public static final String THANK_YOU_FOR_YOUR_PURCHASE_MESSAGE_DISPLAYED = "//h2[text()='Thank you for your purchase!']";
	
	public static final String ORDER_NUMBER = "//p[text()='Your order # is: ']//a";
	
	public static final String MONEY_ORDER_RADIO = "//input[@id='p_method_checkmo']";
	
}
