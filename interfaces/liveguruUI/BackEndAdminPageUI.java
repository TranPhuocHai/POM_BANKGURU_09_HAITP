package liveguruUI;

public class BackEndAdminPageUI {

	public static final String INCOMING_MESSAGE_POPUP = "//h2[text()='Incoming Message']";
	public static final String INCOMING_MESSAGE_POPUP_CLOSE_BUTTON = "//div[@class='message-popup-head']//span[text()='close']";
	public static final String DYNAMIC_CHECKBOX = "//tr[%s]/td[1]/input[@type='checkbox']";
	public static final String ALL_CHECKBOXES = "//tr//td[@class='a-center ']//input";
	public static final String LOADING_ICON = "//p[@class='loader']";
	public static final String DYNAMIC_DROPDOWN_FOLLOW_LABEL = "//label[text()='%s']/following-sibling::select";
	public static final String LOGOUT_BUTTON = "//a[@class='link-logout']";
	public static final String DYNAMIC_EDIT_BUTTON_FOLLOW_REVIEW = "//td[contains(text(),\"%s\")]/following-sibling::td[contains(text(),\"%s\")]//following-sibling::td[contains(text(),\"%s\")]//following-sibling::td/a[text()='Edit']";
	
	public static final String MANAGE_CUSTOMERS_TITLE = "//div[@id='page:main-container']//h3[text()='Manage Customers']";
	public static final String ORDERS_TITLE = "//div[@id='page:main-container']//h3[text()='Orders']";
	public static final String PENDING_REVIEWS_TITLE = "//div[@id='page:main-container']//h3[text()='Pending Reviews']";
	public static final String EDIT_REVIEW_TITLE = "//div[@id='page:main-container']//h3[text()=\"Edit Review '%s'\"]";
	public static final String INVOICES_TITLE = "//div[@id='page:main-container']//h3[text()='Invoices']";
	
	public static final String SALE_CATEGORY = "//span[text()='Sales']";
	public static final String ORDER_CATEGORY = "//span[text()='Orders']";
	public static final String CATALOG_CATEGORY = "//span[text()='Catalog']";
	public static final String REVIEWS_AND_RATINGS_CATEGORY = "//span[text()='Reviews and Ratings']";
	public static final String CUSTOMER_REVIEWS_CATEGORY = "//span[text()='Customer Reviews']";
	public static final String PENDING_REVIEWS_CATEGORY = "//span[text()='Pending Reviews']";
	public static final String SALES_CATEGORY = "//span[text()='Sales']";
	public static final String INVOICES_CATEGORY = "//span[text()='Invoices']";
	public static final String CUSTOMERS_CATEGORY = "//span[text()='Customers']";
	public static final String MANAGE_CUSTOMERS_CATEGORY = "//span[text()='Manage Customers']";
	
	public static final String STATUS_DROPDOWN = "//select[@name='status']";
	public static final String ACTIONS_DROPDOWN = "//label[text()='Actions']/following-sibling::select";
	public static final String STATUS_DROPDOWN_IN_EDIT_REVIEW_PAGE = "//select[@id='status_id']";
	
	public static final String SEARCH_BUTTON = "//span[text()='Search']";
	public static final String SUBMIT_BUTTON = "//span[text()='Submit']";
	public static final String SAVE_REVIEW_BUTTON = "//span[text()='Save Review']";
	
	public static final String DYNAMIC_SORT_BUTTON = "//span[text()='%s']";
	public static final String DYNAMIC_SORT_DESCENDING_BUTTON = "//a[@title='desc']/span[text()='%s']";
	public static final String DYNAMIC_SORT_ASCENDING_BUTTON = "//a[@title='asc']/span[text()='%s']";
	
	public static final String THERE_ARE_NO_PRINTABLE_DOCUMENTS_RELATED_TO_SELECT_MESSAGE = "//span[text()='There are no printable documents related to selected orders.']";
	
	public static final String ALL_VALUE_OF_TABLE = "//div[@class='grid']//td";
	public static final String ALL_SORT_COLUMN = "//tr[@class='headings']/th/span";
	
	public static final String PAGINATION_DROPDOWN = "//select[@name='limit']";
	public static final String ALL_PAGINATION_DROPDOWN_OPTIONS = "//select[@name='limit']//option";
	public static final String COUNTRY_DROPDOWN = "//select[@id='customerGrid_filter_billing_country_id']";
	
	public static final String DYNAMIC_SEARCH_TEXTBOX = "//input[@type='text' and @name='%s']";

	public static final String ALL_CHECKBOX = "//input[@type='checkbox']";
	
	public static final String SELECT_VISIBLE_LINK = "//a[text()='Select Visible']";
	public static final String UNSELECT_VISIBLE_LINK = "//a[text()='Unselect Visible']";
	
	public static final String DYNAMIC_NUMBER_TEXT = "//strong[@id='sales_order_grid_massaction-count' and text()='%s']";
	
}
