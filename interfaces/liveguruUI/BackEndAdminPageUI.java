package liveguruUI;

public class BackEndAdminPageUI {

	public static final String INCOMING_MESSAGE_POPUP = "//h2[text()='Incoming Message']";
	public static final String INCOMING_MESSAGE_POPUP_CLOSE_BUTTON = "//div[@class='message-popup-head']//span[text()='close']";

	public static final String DYNAMIC_CHECKBOX = "//tr[%s]/td[1]/input[@type='checkbox']";

	public static final String ALL_CHECKBOXES = "//tr//td[@class='a-center ']//input";

	public static final String LOADING_ICON = "//p[@class='loader']";

	public static final String DYNAMIC_DROPDOWN_FOLLOW_LABEL = "//label[text()='%s']/following-sibling::select";
	
	public static final String DYNAMIC_SORT_BUTTON = "//a//span[@class='sort-title' and text()='%s']";
	
	public static final String LOGOUT_BUTTON = "//a[@class='link-logout']";
	
	public static final String DYNAMIC_EDIT_BUTTON_FOLLOW_REVIEW = "//td[contains(text(),\"%s\")]/following-sibling::td[contains(text(),\"%s\")]//following-sibling::td[contains(text(),\"%s\")]//following-sibling::td/a[text()='Edit']";
	

}
