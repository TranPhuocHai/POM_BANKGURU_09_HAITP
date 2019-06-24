package liveguruUI;

public class LiveGuruAbstractPageUI {
	public static final String FOOTER_DYNAMIC_LINK = "//div[@class='footer']//a[text()='%s']";
	public static final String HEADER_DYNAMIC_LINK = "//div[@class='page-header-container']//a[contains(text(),'%s')]";
	public static final String COMMON_DYNAMIC_LINK = "//a[text()='%s']";
	
	public static final String DYNAMIC_ADD_TO_COMPARE_LINK = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']";
	public static final String DYNAMIC_ADD_TO_WISHLIST_LINK = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Wishlist']";
	
	public static final String ACCOUNT_MENU = "//div[@class='page-header-container']//span[text()='Account']";
	
	public static final String DYNAMIC_TEXTBOX_CHECKBOX_TEXTAREA = "(//input | //textarea)[@name='%s']";
	public static final String DYNAMIC_VALIDATE_MESSAGE_BELOW_TEXTBOX_TEXTAREA = "(//input | //textarea)[@name='%s']//following-sibling::div[@class='validation-advice']";
	
	public static final String DYNAMIC_BUTTON = "//button[@title='%s']";
	
	public static final String DYNAMIC_PRODUCT_PRICE_IN_LIST_PAGE = "//a[text()='%s']//parent::h2//following-sibling::div[@class='price-box']//span[@class='price']";
	public static final String DYNAMIC_PRODUCT_PRICE_IN_DETAILS_PAGE = "//span[text()='%s']//parent::div//following-sibling::div[@class='price-info']//span[@class='price']";
	public static final String DYNAMIC_DISCOUNT_TITLE = "//td[contains(text(),'Discount (%s)')]";
	public static final String DYNAMIC_DISCOUNT_MONEY = "//td[contains(text(),'Discount (%s)')]/following-sibling::td/span[@class='price']";
	public static final String GRANT_TOTAL_MONEY = "//strong[text()='Grand Total']/parent::td/following-sibling::td//span[@class='price']";
	public static final String SUBTOTAL_MONEY = "//td[contains(text(),'Subtotal')]/following-sibling::td/span[@class='price']";
	public static final String DYNAMIC_QTY_TEXTBOX = "//a[text()='%s']//ancestor::td[@class='product-cart-info']/following-sibling::td[@class='product-cart-actions']/input";
	public static final String DYNAMIC_UPDATE_BUTTON = "//a[text()='%s']//ancestor::td[@class='product-cart-info']/following-sibling::td[@class='product-cart-actions']/button[@title='Update']";
	public static final String DYNAMIC_ERROR_MESSAGE = "//a[text()='%s']/parent::h2/following-sibling::p";
	public static final String DYNAMIC_ADD_TO_CART_BUTTON = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']";
	
	public static final String DYNAMIC_TITLE = "//h1[text()='%s']";
	public static final String DYNAMIC_DETAILS_PRODUCT_TITLE = "//span[@class='h1' and text()='%s']";

	public static final String DYNAMIC_WISHLIST_ADDED_MESSAGE = "//span[contains(text(),'%s has been added to your wishlist. Click')]";
	public static final String DYNAMIC_MESSAGE = "//span[text()='%s']";
	
	public static final String DYNAMIC_WISHLIST_QTY = "//a[text()='%s']//ancestor::td[contains(@class,'customer-wishlist-item-info')]/following-sibling::td[@data-rwd-label='Qty']//input[@value='%s']";

	public static final String DYNAMIC_COMMON_LABEL = "//label[text()=\"%s\"]";


}
