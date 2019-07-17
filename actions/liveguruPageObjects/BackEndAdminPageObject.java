package liveguruPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageFactoryManager.LiveGuruPageFactoryManager;
import commons.AbstractPage;
import liveguruUI.BackEndAdminPageUI;

public class BackEndAdminPageObject extends AbstractPage {
	public BackEndAdminPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	public void closeIncomingMessagePopUpIfItDisplays() {
		List<WebElement> incomingMessagePopUp = driver.findElements(By.xpath(BackEndAdminPageUI.INCOMING_MESSAGE_POPUP));
		waitForAllElementsPresence(driver, BackEndAdminPageUI.INCOMING_MESSAGE_POPUP);

		if (incomingMessagePopUp.size() == 1) {
			waitForElementVisible(driver, BackEndAdminPageUI.INCOMING_MESSAGE_POPUP_CLOSE_BUTTON);
			clickToElement(driver, BackEndAdminPageUI.INCOMING_MESSAGE_POPUP_CLOSE_BUTTON);
		}

	}

	public void waitForLoadingIconInvisible() {
		waitForElementInvisible(driver, BackEndAdminPageUI.LOADING_ICON);

	}

	public void checkToCheckboxNextFirstOrder() {
		List<WebElement> allCheckBoxes = driver.findElements(By.xpath(BackEndAdminPageUI.ALL_CHECKBOXES));
		waitForAllElementsPresence(driver, BackEndAdminPageUI.ALL_CHECKBOXES);
		if (allCheckBoxes.size() <= 1) {
			allCheckBoxes.get(0).click();
		} else
			allCheckBoxes.get(1).click();

	}

	public void selectItemInDropdownFollowTable(String field, String expectedValue) {
		waitForElementVisible(driver, BackEndAdminPageUI.DYNAMIC_DROPDOWN_FOLLOW_LABEL, field);
		selectItemInDropdown(driver, BackEndAdminPageUI.DYNAMIC_DROPDOWN_FOLLOW_LABEL, expectedValue, field);

	}

	public BackEndLoginPageObject clickToLogOutButton() {
		waitForElementVisible(driver, BackEndAdminPageUI.LOGOUT_BUTTON);
		clickToElement(driver, BackEndAdminPageUI.LOGOUT_BUTTON);
		return LiveGuruPageFactoryManager.getBackEndLoginPage(driver);

	}

	public void clickToExpectedEditButton(String... values) {
		String locator = BackEndAdminPageUI.DYNAMIC_EDIT_BUTTON_FOLLOW_REVIEW;
		locator = String.format(locator, (Object[]) values);
		List<WebElement> allExpectedEditButton = driver.findElements(By.xpath(locator));
		allExpectedEditButton.get(0).click();

	}

	public boolean isManageCustomersTitleDisplayed() {
		waitForElementVisible(driver, BackEndAdminPageUI.MANAGE_CUSTOMERS_TITLE);
		return isControlDisplayed(driver, BackEndAdminPageUI.MANAGE_CUSTOMERS_TITLE);
	}

	public void hoverMouseToSaleCatogory() {
		waitForElementVisible(driver, BackEndAdminPageUI.SALE_CATEGORY);
		hoverMouseToElement(driver, BackEndAdminPageUI.SALE_CATEGORY);

	}

	public void clickToOrdersCategory() {
		waitForElementVisible(driver, BackEndAdminPageUI.ORDER_CATEGORY);
		clickToElement(driver, BackEndAdminPageUI.ORDER_CATEGORY);

	}

	public boolean isOrdersTitleDisplayed() {
		waitForElementVisible(driver, BackEndAdminPageUI.ORDERS_TITLE);
		return isControlDisplayed(driver, BackEndAdminPageUI.ORDERS_TITLE);
	}

	public void selectAnyValueFromStatusDropdown(String value) {
		waitForElementVisible(driver, BackEndAdminPageUI.STATUS_DROPDOWN);
		selectItemInDropdown(driver, BackEndAdminPageUI.STATUS_DROPDOWN, value);

	}

	public void clickToSearchButton() {
		waitForElementVisible(driver, BackEndAdminPageUI.SEARCH_BUTTON);
		clickToElement(driver, BackEndAdminPageUI.SEARCH_BUTTON);

	}

	public void selectAnyValueFromActionsDropdown(String value) {
		waitForElementVisible(driver, BackEndAdminPageUI.ACTIONS_DROPDOWN);
		selectItemInDropdown(driver, BackEndAdminPageUI.ACTIONS_DROPDOWN, value);

	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, BackEndAdminPageUI.SUBMIT_BUTTON);
		clickToElement(driver, BackEndAdminPageUI.SUBMIT_BUTTON);

	}

	public boolean isThereAreNoPrintableDocumentsRelatedToSelectMessageDisplayed() {
		waitForElementVisible(driver, BackEndAdminPageUI.THERE_ARE_NO_PRINTABLE_DOCUMENTS_RELATED_TO_SELECT_MESSAGE);
		return isControlDisplayed(driver, BackEndAdminPageUI.THERE_ARE_NO_PRINTABLE_DOCUMENTS_RELATED_TO_SELECT_MESSAGE);
	}

	public void hoverMouseCatalogCategory() {
		waitForElementVisible(driver, BackEndAdminPageUI.CATALOG_CATEGORY);
		hoverMouseToElement(driver, BackEndAdminPageUI.CATALOG_CATEGORY);

	}

	public void hoverMouseToReviewsAndRatingsCategory() {
		waitForElementVisible(driver, BackEndAdminPageUI.REVIEWS_AND_RATINGS_CATEGORY);
		hoverMouseToElement(driver, BackEndAdminPageUI.REVIEWS_AND_RATINGS_CATEGORY);

	}

	public void hoverMouseToCustomerReviewsCategory() {
		waitForElementVisible(driver, BackEndAdminPageUI.CUSTOMER_REVIEWS_CATEGORY);
		hoverMouseToElement(driver, BackEndAdminPageUI.CUSTOMER_REVIEWS_CATEGORY);

	}

	public void clickToPendingReviewsCategory() {
		waitForElementVisible(driver, BackEndAdminPageUI.PENDING_REVIEWS_CATEGORY);
		clickToElement(driver, BackEndAdminPageUI.PENDING_REVIEWS_CATEGORY);

	}

	public boolean isPendingReviewsTitleDisplayed() {
		waitForElementVisible(driver, BackEndAdminPageUI.PENDING_REVIEWS_TITLE);
		return isControlDisplayed(driver, BackEndAdminPageUI.PENDING_REVIEWS_TITLE);
	}

	public void clickToDynamicSortButton(String columnField) {
		waitForElementVisible(driver, BackEndAdminPageUI.DYNAMIC_SORT_BUTTON, columnField);
		clickToElement(driver, BackEndAdminPageUI.DYNAMIC_SORT_BUTTON, columnField);

	}

	public void clickToDynamicSortDescendingButton(String columnField) {
		waitForElementVisible(driver, BackEndAdminPageUI.DYNAMIC_SORT_DESCENDING_BUTTON, columnField);
		clickToElement(driver, BackEndAdminPageUI.DYNAMIC_SORT_DESCENDING_BUTTON, columnField);

	}

	public boolean isEditReviewTitleDisplayed(String finalCustomerReview) {
		waitForElementVisible(driver, BackEndAdminPageUI.EDIT_REVIEW_TITLE, finalCustomerReview);
		return isControlDisplayed(driver, BackEndAdminPageUI.EDIT_REVIEW_TITLE, finalCustomerReview);

	}

	public void selectAnyValueFromStatusDropdownInEditReviewPage(String value) {
		waitForElementVisible(driver, BackEndAdminPageUI.STATUS_DROPDOWN_IN_EDIT_REVIEW_PAGE);
		selectItemInDropdown(driver, BackEndAdminPageUI.STATUS_DROPDOWN_IN_EDIT_REVIEW_PAGE, value);

	}

	public void clickToSaveReviewButton() {
		waitForElementVisible(driver, BackEndAdminPageUI.SAVE_REVIEW_BUTTON);
		clickToElement(driver, BackEndAdminPageUI.SAVE_REVIEW_BUTTON);

	}

	public void hoverMouseToSalesCategory() {
		waitForElementVisible(driver, BackEndAdminPageUI.SALES_CATEGORY);
		hoverMouseToElement(driver, BackEndAdminPageUI.SALES_CATEGORY);

	}

	public void clickToInvoicesCategory() {
		waitForElementVisible(driver, BackEndAdminPageUI.INVOICES_CATEGORY);
		clickToElement(driver, BackEndAdminPageUI.INVOICES_CATEGORY);

	}

	public boolean isInvoicesTitleDisplayed() {
		waitForElementVisible(driver, BackEndAdminPageUI.INVOICES_TITLE);
		return isControlDisplayed(driver, BackEndAdminPageUI.INVOICES_TITLE);

	}

	public boolean isDynamicDescendingSortButtonDisplayed(String columnField) {
		waitForElementVisible(driver, BackEndAdminPageUI.DYNAMIC_SORT_DESCENDING_BUTTON, columnField);
		return isControlDisplayed(driver, BackEndAdminPageUI.DYNAMIC_SORT_DESCENDING_BUTTON, columnField);
	}

	public boolean isDynamicAscendingSortButtonDisplayed(String columnField) {
		waitForElementVisible(driver, BackEndAdminPageUI.DYNAMIC_SORT_ASCENDING_BUTTON, columnField);
		return isControlDisplayed(driver, BackEndAdminPageUI.DYNAMIC_SORT_ASCENDING_BUTTON, columnField);
	}

	public String[] getListValueOfEachColumnForVeiryingSort(int columnNo) {
		List<WebElement> allSortColumn = driver.findElements(By.xpath(BackEndAdminPageUI.ALL_SORT_COLUMN));
		List<WebElement> listElements = driver.findElements(By.xpath(BackEndAdminPageUI.ALL_VALUE_OF_TABLE));
		String[] listItem = new String[listElements.size()];
		String[] allItemsInEachColumn = new String[allSortColumn.size()];

		for (int i = 0; i < listElements.size(); i++) {
			String printToScreen = listElements.get(i).getText().trim();
			listItem[i] = printToScreen;
		}
		for (int y = 0; y < allSortColumn.size(); y++) {
			allItemsInEachColumn[y] = listItem[columnNo + (y * allSortColumn.size())].replace(",", "").replace("$", "").replace(".", "").replace(" ", "").replace(":", "").toLowerCase();
		}

		return allItemsInEachColumn;
	}

	public String[] getListValueOfEachColumnForVeiryingSearch(int columnNo) {
		List<WebElement> allSortColumn = driver.findElements(By.xpath(BackEndAdminPageUI.ALL_SORT_COLUMN));
		List<WebElement> listElements = driver.findElements(By.xpath(BackEndAdminPageUI.ALL_VALUE_OF_TABLE));
		String[] listItem = new String[listElements.size()];
		String[] allItemsInEachColumn = new String[listElements.size() / allSortColumn.size()];

		for (int i = 0; i < listElements.size(); i++) {
			String printToScreen = listElements.get(i).getText().trim();
			listItem[i] = printToScreen;
		}
		for (int y = 0; y < listElements.size() / allSortColumn.size(); y++) {
			allItemsInEachColumn[y] = listItem[columnNo - 1 + (y * allSortColumn.size())];
		}

		return allItemsInEachColumn;
	}

	public String[] getTextDynamicColumnSortName() {
		List<WebElement> allSortColumn = driver.findElements(By.xpath(BackEndAdminPageUI.ALL_SORT_COLUMN));
		String[] listColunnValue = new String[allSortColumn.size()];
		for (int i = 0; i < allSortColumn.size(); i++) {
			listColunnValue[i] = allSortColumn.get(i).getText().trim();
		}
		return listColunnValue;
	}

	public void selectDynamicValueInPaginationDropdown(String expectedValueInDropdown) {
		waitForElementVisible(driver, BackEndAdminPageUI.PAGINATION_DROPDOWN);
		selectItemInDropdown(driver, BackEndAdminPageUI.PAGINATION_DROPDOWN, expectedValueInDropdown);

	}

	public void clickToPaginationDropdown() {
		waitForElementVisible(driver, BackEndAdminPageUI.PAGINATION_DROPDOWN);
		clickToElement(driver, BackEndAdminPageUI.PAGINATION_DROPDOWN);

	}

	public String[] getAllOptionsOfPaginationDropdown() {
		List<WebElement> allOptions = driver.findElements(By.xpath(BackEndAdminPageUI.ALL_PAGINATION_DROPDOWN_OPTIONS));
		String[] listOptions = new String[allOptions.size()];
		for (int i = 0; i < allOptions.size(); i++) {
			String eachOption = allOptions.get(i).getText().trim();
			listOptions[i] = eachOption;
		}
		return listOptions;
	}

	public int getTotalNumberOfTableValue() {
		List<WebElement> totalNumberOfTableValue = driver.findElements(By.xpath(BackEndAdminPageUI.ALL_VALUE_OF_TABLE));
		return totalNumberOfTableValue.size();
	}

	public int getTotalColumnOfTableValue() {
		List<WebElement> totalNumberOfColumn = driver.findElements(By.xpath(BackEndAdminPageUI.ALL_SORT_COLUMN));
		return totalNumberOfColumn.size();
	}

	public void hoverMouseToCustomersCategory() {
		waitForElementVisible(driver, BackEndAdminPageUI.CUSTOMERS_CATEGORY);
		hoverMouseToElement(driver, BackEndAdminPageUI.CUSTOMERS_CATEGORY);

	}

	public void clickToManageCustomersCategory() {
		waitForElementVisible(driver, BackEndAdminPageUI.MANAGE_CUSTOMERS_CATEGORY);
		clickToElement(driver, BackEndAdminPageUI.MANAGE_CUSTOMERS_CATEGORY);

	}

	public void inputToDynamicSearchTextbox(String fieldName, String sendKeyValue) {
		waitForElementVisible(driver, BackEndAdminPageUI.DYNAMIC_SEARCH_TEXTBOX, fieldName);
		sendKeyToElement(driver, BackEndAdminPageUI.DYNAMIC_SEARCH_TEXTBOX, sendKeyValue, fieldName);

	}

	public void selectCountryFromCountryDropdown(String country) {
		waitForElementVisible(driver, BackEndAdminPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, BackEndAdminPageUI.COUNTRY_DROPDOWN, country);

	}

	public String getFirstSelectionOfPaginationDropdown() {
		waitForElementVisible(driver, BackEndAdminPageUI.PAGINATION_DROPDOWN);
		return getFirstSelectedItemInDropdown(driver, BackEndAdminPageUI.PAGINATION_DROPDOWN);
	}

	public void clickToSelectVisibleLink() {
		waitForElementVisible(driver, BackEndAdminPageUI.SELECT_VISIBLE_LINK);
		clickToElement(driver, BackEndAdminPageUI.SELECT_VISIBLE_LINK);

	}

	public void clickToUnselectVisibleLink() {
		waitForElementVisible(driver, BackEndAdminPageUI.UNSELECT_VISIBLE_LINK);
		clickToElement(driver, BackEndAdminPageUI.UNSELECT_VISIBLE_LINK);

	}

	public boolean isDynamicItemSelectedMessageDisplayed(String number) {
		waitForElementVisible(driver, BackEndAdminPageUI.DYNAMIC_NUMBER_TEXT, number);
		return isControlDisplayed(driver, BackEndAdminPageUI.DYNAMIC_NUMBER_TEXT, number);

	}

	public boolean verifyAllCheckboxAreCheckedSuccessfully() {
		List<WebElement> allCheckboxes = driver.findElements(By.xpath(BackEndAdminPageUI.ALL_CHECKBOX));
		for (WebElement eachCheckbox : allCheckboxes) {
			if (!eachCheckbox.isSelected()) {
				return false;
			}
		}
		return true;

	}

	public boolean verifyAllCheckboxAreUncheckedSuccessfully() {
		List<WebElement> allCheckboxes = driver.findElements(By.xpath(BackEndAdminPageUI.ALL_CHECKBOX));
		for (WebElement eachCheckbox : allCheckboxes) {
			if (eachCheckbox.isSelected()) {
				return false;
			}
		}
		return true;
	}

}
