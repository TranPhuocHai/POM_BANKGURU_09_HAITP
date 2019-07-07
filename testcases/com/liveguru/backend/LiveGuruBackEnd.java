package com.liveguru.backend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.backend.testdata.BackEndTestData;

import bankguruPageFactoryManager.LiveGuruPageFactoryManager;
import commons.AbstractTest;
import commons.DownloadFileFunction;
import liveguruPageObjects.BackEndAdminPageObject;
import liveguruPageObjects.BackEndLoginPageObject;
import liveguruPageObjects.ProductReviewPageObject;

public class LiveGuruBackEnd extends AbstractTest {
	private WebDriver driver;
	private BackEndLoginPageObject backEndLoginPage;
	private BackEndAdminPageObject backEndAdminPage;
	private ProductReviewPageObject productReviewPage;
	private String backEndLoginUrl;
	private String[] paginationOptions;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);

	}

//	@Test
	public void TC_01_VerifyInvoiceCanBePrinted() {

		log.info("======= LiveGuru BackEnd - TC_01: Verify Invoice Can Be Printed =========");

		log.info("TC_01: Step 01 - Get login page");
		backEndLoginPage = LiveGuruPageFactoryManager.getBackEndLoginPage(driver);
		backEndLoginUrl = backEndLoginPage.getCurrentPageUrl(driver);

		log.info("TC_01: Step 02 - Verify Login Title 'Log in to Admin Pane' displays");
		verifyTrue(backEndLoginPage.isLoginTitleDisplayed());

		log.info("TC_01: Step 03 - Input to 'Username' textbox");
		backEndLoginPage.inputToUserNameTextbox(BackEndTestData.USER_NAME);

		log.info("TC_01: Step 04 - Input to 'Password' textbox");
		backEndLoginPage.inputToPasswordTextbox(BackEndTestData.PASSWORD);

		log.info("TC_01: Step 05 - Click To 'Login' button");
		backEndAdminPage = backEndLoginPage.clickToLoginButton();

		log.info("TC_01: Step 06 - Close Incoming message pop-up if it appears");
		backEndAdminPage.closeIncomingMessagePopUpIfItDisplays();

		log.info("TC_01: Step 07 - Verify 'Manage Customer' title displays");
		verifyTrue(backEndAdminPage.isManageCustomersTitleDisplayed());

		log.info("TC_01: Step 08 - Hover mouse to 'Sale' category");
		backEndAdminPage.hoverMouseToSaleCatogory();

		log.info("TC_01: Step 09 - Click to 'Order' category");
		backEndAdminPage.clickToOrdersCategory();

		log.info("TC_01: Step 10 - Verify 'Orders' title displays");
		verifyTrue(backEndAdminPage.isOrdersTitleDisplayed());

		log.info("TC_01: Step 11 - Select 'Cancelled' in 'Status' dropdown");
		backEndAdminPage.selectAnyValueFromStatusDropdown("Canceled");

		log.info("TC_01: Step 12 - Click To 'Search' button");
		backEndAdminPage.clickToSearchButton();

		log.info("TC_01: Step 13 - Wait for Loading icon invisible");
		backEndAdminPage.waitForLoadingIconInvisible();

		log.info("TC_01: Step 14 - Check to checkbox next to the first order");
		backEndAdminPage.checkToCheckboxNextFirstOrder();

		log.info("TC_01: Step 15 - Select 'Print Invoices' in 'Actions' dropdown");
		backEndAdminPage.selectAnyValueFromActionsDropdown("Print Invoices");

		log.info("TC_01: Step 16 - Click 'Submit' button");
		backEndAdminPage.clickToSubmitButton();

		log.info("TC_01: Step 17 - Verify 'There are no printable documents related to select' message displayed");
		verifyTrue(backEndAdminPage.isThereAreNoPrintableDocumentsRelatedToSelectMessageDisplayed());

		log.info("TC_01: Step 18 - Select 'Complete' in 'Status' dropdown");
		backEndAdminPage.selectAnyValueFromStatusDropdown("Complete");

		log.info("TC_01: Step 19 - Click To 'Search' button");
		backEndAdminPage.clickToSearchButton();

		log.info("TC_01: Step 20 - Wait for Loading icon invisible");
		backEndAdminPage.waitForLoadingIconInvisible();

		log.info("TC_01: Step 21 - Check to checkbox next first order");
		backEndAdminPage.checkToCheckboxNextFirstOrder();

		log.info("TC_01: Step 22 - Select 'Print Invoices' in 'Actions' dropdown");
		backEndAdminPage.selectAnyValueFromActionsDropdown("Print Invoices");

		log.info("TC_01: Step 23 - Click 'Submit' button");
		backEndAdminPage.clickToSubmitButton();

		log.info("TC_01: Step 24 - Verify Download successfully");
		DownloadFileFunction.VerifyDownloadedSuccessfully(".pdf");

		log.info("TC_01: Post condition - Logout from Admin page");
		backEndLoginPage = backEndAdminPage.clickToLogOutButton();

	}

//	@Test
	public void TC_02_VerifyTheProductMechanism() {
		log.info("======= LiveGuru BackEnd - TC_02: Verify The Product Mechanism =========");

		log.info("TC_02: Step 01 - Go to product link");
		backEndLoginPage.openAnyUrl(driver, BackEndTestData.LIVE_GURU_PRODUCT_URL);
		productReviewPage = LiveGuruPageFactoryManager.getProductReviewPage(driver);

		log.info("TC_02: Step 02 - Verify 'Let us know your thoughts' message displayed");
		verifyTrue(productReviewPage.isLetUsKnowYourThoughtsMessageDisplayed());

		log.info("TC_02: Step 03 - Verify 'Summary of Your Review' message displayed");
		verifyTrue(productReviewPage.isSummaryOfYourReviewMessageDisplayed());

		log.info("TC_02: Step 04 - Verify 'What's your nickname?' message displayed");
		verifyTrue(productReviewPage.isWhatsYourNicknameMessageDisplayed());

		log.info("TC_02: Step 05 - Input valid datas for 3 fields");
		productReviewPage.inputToDetailsReviewTextArea(BackEndTestData.REVIEW_COMMENT_DETAILS);
		productReviewPage.inputToFinalReviewTextbox(BackEndTestData.FINAL_REVIEW);
		productReviewPage.inputToNicknameTextbox(BackEndTestData.NICK_NAME);

		log.info("TC_02: Step 06 - Click 'SUBMIT REVIEW' button");
		productReviewPage.clickToSubmitReviewButton();

		log.info("TC_02: Step 07 - Go to Backend Login page");
		backEndLoginPage = productReviewPage.openBackEndPage(backEndLoginUrl);

		log.info("TC_02: Step 08 - Verify Login Title 'Log in to Admin Pane' displays");
		verifyTrue(backEndLoginPage.isLoginTitleDisplayed());

		log.info("TC_02: Step 09 - Input to 'Username' textbox");
		backEndLoginPage.inputToUserNameTextbox(BackEndTestData.USER_NAME);

		log.info("TC_02: Step 10 - Input to 'Password' textbox");
		backEndLoginPage.inputToPasswordTextbox(BackEndTestData.PASSWORD);

		log.info("TC_02: Step 11 - Click To 'Login' button");
		backEndAdminPage = backEndLoginPage.clickToLoginButton();

		log.info("TC_02: Step 12 - Close Incoming message pop-up if it appears");
		backEndAdminPage.closeIncomingMessagePopUpIfItDisplays();

		log.info("TC_02: Step 13 - Verify 'Manage Customer' title displays");
		verifyTrue(backEndAdminPage.isManageCustomersTitleDisplayed());

		log.info("TC_02: Step 14 - Hover mouse to 'Catalog' category");
		backEndAdminPage.hoverMouseCatalogCategory();

		log.info("TC_02: Step 15 - Hover mouse to 'Reviews and Ratings' category");
		backEndAdminPage.hoverMouseToReviewsAndRatingsCategory();

		log.info("TC_02: Step 16 - Hover mouse to 'Customer Reviews' category");
		backEndAdminPage.hoverMouseToCustomerReviewsCategory();

		log.info("TC_02: Step 17 - Click to 'Pending Reviews' category");
		backEndAdminPage.clickToPendingReviewsCategory();

		log.info("TC_02: Step 18 - Verify 'Pending Reviews' title displays");
		verifyTrue(backEndAdminPage.isPendingReviewsTitleDisplayed());

		log.info("TC_02: Step 19 - Sort table by ID twice for getting descending order");
		backEndAdminPage.clickToDynamicSortButton("ID");
		backEndAdminPage.clickToDynamicSortButton("ID");

		log.info("TC_02: Step 20 - Click to the expected 'Edit' button");
		backEndAdminPage.clickToExpectedEditButton(BackEndTestData.FINAL_REVIEW, BackEndTestData.NICK_NAME, BackEndTestData.REVIEW_COMMENT_DETAILS);

		log.info("TC_02: Step 21 - Verify 'Edit review' title displays");
		backEndAdminPage.isEditReviewTitleDisplayed(BackEndTestData.FINAL_REVIEW);

		log.info("TC_02: Step 22 - Select 'Approved' from 'Status' dropdown in Review Details filed");
		backEndAdminPage.selectAnyValueFromStatusDropdownInEditReviewPage("Approved");

		log.info("TC_02: Step 23 - Click on 'Save Review' button ");
		backEndAdminPage.clickToSaveReviewButton();

		log.info("TC_02: Step 24 - Click on 'Logout' button ");
		backEndLoginPage = backEndAdminPage.clickToLogOutButton();

		log.info("TC_02: Step 25 - Go to product link");
		backEndLoginPage.openAnyUrl(driver, BackEndTestData.LIVE_GURU_PRODUCT_URL);
		productReviewPage = LiveGuruPageFactoryManager.getProductReviewPage(driver);

		log.info("TC_02: Step 26 - Verify Your review displays");
		productReviewPage.isExpectedReviewDisplayed(BackEndTestData.FINAL_REVIEW, BackEndTestData.REVIEW_COMMENT_DETAILS, BackEndTestData.NICK_NAME);

	}

//	@Test
	public void TC_03_VerifySortFunctionWorksCorrectly() {
		log.info("=== LiveGuru BackEnd - TC_03: Verify Sort Function Works Correctly ====");

		log.info("TC_03: Step 01 - Go to Backend Login page");
		backEndLoginPage = productReviewPage.openBackEndPage(backEndLoginUrl);

		log.info("TC_03: Step 02 - Verify Login Title 'Log in to Admin Pane' displays");
		verifyTrue(backEndLoginPage.isLoginTitleDisplayed());

		log.info("TC_03: Step 03 - Input to 'Username' textbox");
		backEndLoginPage.inputToUserNameTextbox(BackEndTestData.USER_NAME);

		log.info("TC_03: Step 04 - Input to 'Password' textbox");
		backEndLoginPage.inputToPasswordTextbox(BackEndTestData.PASSWORD);

		log.info("TC_03: Step 05 - Click To 'Login' button");
		backEndAdminPage = backEndLoginPage.clickToLoginButton();

		log.info("TC_03: Step 06 - Close Incoming message pop-up if it appears");
		backEndAdminPage.closeIncomingMessagePopUpIfItDisplays();

		log.info("TC_03: Step 07 - Verify 'Manage Customer' title displays");
		verifyTrue(backEndAdminPage.isManageCustomersTitleDisplayed());

		log.info("TC_03: Step 08 - Hover mouse to 'Sales' category");
		backEndAdminPage.hoverMouseToSalesCategory();

		log.info("TC_03: Step 09 - Click to 'Invoices' category");
		backEndAdminPage.clickToInvoicesCategory();

		log.info("TC_03: Step 10 - Verify 'Invoices' title displays");
		verifyTrue(backEndAdminPage.isInvoicesTitleDisplayed());

		log.info("TC_03: Step 11 - Verify Sort Function works correctly for all column");
		String[] allColumnNames = backEndAdminPage.getTextDynamicColumnSortName();
		for (int i = 1; i < allColumnNames.length - 1; i++) {
			if (i == 1 | i == 3 | i == 5 | i == 6) {
				String columnField = allColumnNames[i];
				backEndAdminPage.clickToDynamicSortButton(columnField);
				backEndAdminPage.waitForLoadingIconInvisible();
				verifyTrue(backEndAdminPage.isDynamicDescendingSortButtonDisplayed(columnField));
				verifyTrue(verifySortAscending(backEndAdminPage.getListValueOfEachColumn(i)));
				backEndAdminPage.clickToDynamicSortDescendingButton(columnField);
				backEndAdminPage.waitForLoadingIconInvisible();
				verifyTrue(backEndAdminPage.isDynamicAscendingSortButtonDisplayed(columnField));
				verifyTrue(verifySortDescending(backEndAdminPage.getListValueOfEachColumn(i)));

			}
		}
		
		log.info("TC_03: Post condition - Logout from Admin page");
		backEndLoginPage = backEndAdminPage.clickToLogOutButton();
	}
	
//	@Test
	public void TC_04_VeirfyPaginationFunctionWorksCorrectly() {
		log.info("=== LiveGuru BackEnd - TC_03: Verify Pagination Function Works Correctly ====");
		
		log.info("TC_04: Step 01 - Go to Backend Login page");
		backEndLoginPage.openBackEndPage(backEndLoginUrl);

		log.info("TC_04: Step 02 - Verify Login Title 'Log in to Admin Pane' displays");
		verifyTrue(backEndLoginPage.isLoginTitleDisplayed());

		log.info("TC_04: Step 03 - Input to 'Username' textbox");
		backEndLoginPage.inputToUserNameTextbox(BackEndTestData.USER_NAME);

		log.info("TC_04: Step 04 - Input to 'Password' textbox");
		backEndLoginPage.inputToPasswordTextbox(BackEndTestData.PASSWORD);

		log.info("TC_04: Step 05 - Click To 'Login' button");
		backEndAdminPage = backEndLoginPage.clickToLoginButton();

		log.info("TC_04: Step 06 - Close Incoming message pop-up if it appears");
		backEndAdminPage.closeIncomingMessagePopUpIfItDisplays();

		log.info("TC_04: Step 07 - Verify 'Manage Customer' title displays");
		verifyTrue(backEndAdminPage.isManageCustomersTitleDisplayed());

		log.info("TC_04: Step 08 - Hover mouse to 'Sales' category");
		backEndAdminPage.hoverMouseToSalesCategory();

		log.info("TC_04: Step 09 - Click to 'Orders' category");
		backEndAdminPage.clickToOrdersCategory();

		log.info("TC_04: Step 10 - Verify 'Orders' title displays");
		verifyTrue(backEndAdminPage.isOrdersTitleDisplayed());
		
		log.info("TC_04: Step 11 - Veirfy Pagination function works correctly");
		backEndAdminPage.clickToPaginationDropdown();
		paginationOptions = backEndAdminPage.getAllOptionsOfPaginationDropdown();
		for (String option : paginationOptions) {
			backEndAdminPage.selectDynamicValueInPaginationDropdown(option);
			backEndAdminPage.waitForLoadingIconInvisible();
			
			int totalNumberValues = backEndAdminPage.getTotalNumberOfTableValue();
			int numberOfColumn = backEndAdminPage.getTotalColumnOfTableValue();
			int actualNumberOfRow = totalNumberValues/numberOfColumn;
			
			int expectedNumberOfRow = Integer.parseInt(option);
			
			verifyTrue(expectedNumberOfRow == actualNumberOfRow);
			
		}
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
