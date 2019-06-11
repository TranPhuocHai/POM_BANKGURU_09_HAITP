package liveguruUI;

public class MobilePageUI {
	public static final String DYNAMIC_PRODUCT_PRICE_IN_LIST_PAGE = "//a[text()='%s']//parent::h2//following-sibling::div[@class='price-box']//span[@class='price']";
	public static final String DYNAMIC_PRODUCT_PRICE_IN_DETAILS_PAGE = "//span[text()='%s']//parent::div//following-sibling::div[@class='price-info']//span[@class='price']";
	public static final String DYNAMIC_PRODUCT_LINK = "//a[text()='%s']";
	public static final String DYNAMIC_ADD_TO_CART_BUTTON = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']";
	public static final String SHOPPING_CART_MESSAGE = "//h1[text()='Shopping Cart']";
	public static final String DYNAMIC_DISCOUNT_TITLE = "//td[contains(text(),'Discount (%s)')]";
	public static final String DYNAMIC_DISCOUNT_MONEY = "//td[contains(text(),'Discount (%s)')]/following-sibling::td/span[@class='price']";
	public static final String GRANT_TOTAL_MONEY = "//strong[text()='Grand Total']/parent::td/following-sibling::td//span[@class='price']";
	public static final String SUBTOTAL_MONEY = "//td[contains(text(),'Subtotal')]/following-sibling::td/span[@class='price']";
	public static final String DYNAMIC_QTY_TEXTBOX = "//a[text()='%s']//ancestor::td[@class='product-cart-info']/following-sibling::td[@class='product-cart-actions']/input";
	public static final String DYNAMIC_UPDATE_BUTTON = "//a[text()='%s']//ancestor::td[@class='product-cart-info']/following-sibling::td[@class='product-cart-actions']/button[@title='Update']";
	public static final String DYNAMIC_ERROR_MESSAGE = "//a[text()='%s']/parent::h2/following-sibling::p";


}
