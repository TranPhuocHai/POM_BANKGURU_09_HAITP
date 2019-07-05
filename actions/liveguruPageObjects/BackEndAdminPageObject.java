package liveguruPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bankguruPageFactoryManager.LiveGuruPageFactoryManager;
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

	public void clickToDynamicSortButton(String sortField) {
		waitForElementVisible(driver, BackEndAdminPageUI.DYNAMIC_SORT_BUTTON, sortField);
		clickToElement(driver, BackEndAdminPageUI.DYNAMIC_SORT_BUTTON, sortField);

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

	public void clickToOrderCategory() {
		waitForElementVisible(driver, BackEndAdminPageUI.ORDER_CATEGORY);
		clickToElement(driver, BackEndAdminPageUI.ORDER_CATEGORY);

	}

	public boolean isOrdersTitleDisplayed() {
		waitForElementVisible(driver, BackEndAdminPageUI.ORDER_TITLE);
		return isControlDisplayed(driver, BackEndAdminPageUI.ORDER_TITLE);
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

	public void clickToIDSortButton() {
		waitForElementVisible(driver, BackEndAdminPageUI.ID_SORT_BUTTON);
		clickToElement(driver, BackEndAdminPageUI.ID_SORT_BUTTON);

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

	public void clickToInvoiceNumberSortButton() {
		waitForElementVisible(driver, BackEndAdminPageUI.INVOICE_NUMBER_SORT_BUTTON);
		clickToElement(driver, BackEndAdminPageUI.INVOICE_NUMBER_SORT_BUTTON);
		
	}

	public boolean isDescendingSortInvoiceNumberButtonDisplayed() {
		waitForElementVisible(driver, BackEndAdminPageUI.INVOICE_NUMBER_SORT_DESCENDING_BUTTON);
		return isControlDisplayed(driver, BackEndAdminPageUI.INVOICE_NUMBER_SORT_DESCENDING_BUTTON);
	}

	public boolean isInvoiceNumberSortInAscendingCorrectly() {
		// TODO Auto-generated method stub
		return false;
	}

}
