package com.liveguru.backend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.backend.testdata.LiveGuruBackEndTestData;

import commons.AbstractTest;
import commons.DownloadFileFunction;
import liveguruPageFactoryManager.LiveGuruPageFactoryManager;
import liveguruPageObjects.BackEndAdminPageObject;
import liveguruPageObjects.BackEndLoginPageObject;
import liveguruPageObjects.ProductReviewPageObject;

public class LiveGuruBackEnd extends AbstractTest {
	private WebDriver driver;
	private BackEndLoginPageObject backEndLoginPage;
	private BackEndAdminPageObject backEndAdminPage;
	private ProductReviewPageObject productReviewPage;
	private String backEndLoginUrl;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);

	}

	@Test
	public void TC_01_VerifyInvoiceCanBePrinted() {

		log.info("======= LiveGuru BackEnd - TC_01: Verify Invoice Can Be Printed =========");

		log.info("TC_01: Step 01 - Get login page");
		backEndLoginPage = LiveGuruPageFactoryManager.getBackEndLoginPage(driver);
		backEndLoginUrl = backEndLoginPage.getCurrentPageUrl(driver);

		log.info("TC_01: Step 02 - Verify Login Title 'Log in to Admin Pane' displays");
		verifyTrue(backEndLoginPage.isLoginTitleDisplayed());

		log.info("TC_01: Step 03 - Input to 'Username' textbox");
		backEndLoginPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "login[username]", LiveGuruBackEndTestData.USER_NAME);

		log.info("TC_01: Step 04 - Input to 'Password' textbox");
		backEndLoginPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "login[password]", LiveGuruBackEndTestData.PASSWORD);

		log.info("TC_01: Step 05 - Click To 'Login' button");
		backEndAdminPage = backEndLoginPage.clickToLoginButton();

		log.info("TC_01: Step 06 - Close Incoming message pop-up if it appears");
		backEndAdminPage.closeIncomingMessagePopUpIfItDisplays();

		log.info("TC_01: Step 07 - Verify 'Manage Customer' title displays");
		verifyTrue(backEndAdminPage.isDynamicBackendTitleDisplayed(driver, "Manage Customers"));

		log.info("TC_01: Step 08 - Hover mouse to 'Sale' category");
		backEndAdminPage.hoverMouseToDynamicCategory(driver, "Sales");

		log.info("TC_01: Step 09 - Click to 'Order' category");
		backEndAdminPage.clickToDynamicCategoryOrButton(driver, "Orders");

		log.info("TC_01: Step 10 - Verify 'Orders' title displays");
		verifyTrue(backEndAdminPage.isDynamicBackendTitleDisplayed(driver, "Orders"));

		log.info("TC_01: Step 11 - Select 'Cancelled' in 'Status' dropdown");
		backEndAdminPage.selectItemInLiveGuruDynamicDropdown(driver, "status", "Canceled");

		log.info("TC_01: Step 12 - Click To 'Search' button");
		backEndAdminPage.clickToDynamicCategoryOrButton(driver, "Search");

		log.info("TC_01: Step 13 - Wait for Loading icon invisible");
		backEndAdminPage.waitForLoadingIconInvisible();

		log.info("TC_01: Step 14 - Check to checkbox next to the first order");
		backEndAdminPage.checkToCheckboxNextFirstOrder();

		log.info("TC_01: Step 15 - Select 'Print Invoices' in 'Actions' dropdown");
		backEndAdminPage.selectItemInDropdownFollowTable("Actions", "Print Invoices");

		log.info("TC_01: Step 16 - Click 'Submit' button");
		backEndAdminPage.clickToDynamicCategoryOrButton(driver, "Submit");

		log.info("TC_01: Step 17 - Verify 'There are no printable documents related to select' message displayed");
		verifyTrue(backEndAdminPage.isDynamicErrorMessageDisplayed(driver, LiveGuruBackEndTestData.NO_PRINTABLE_DOCUMENTS_ERROR_MESSAGE));

		log.info("TC_01: Step 18 - Select 'Complete' in 'Status' dropdown");
		backEndAdminPage.selectItemInLiveGuruDynamicDropdown(driver, "status", "Complete");

		log.info("TC_01: Step 19 - Click To 'Search' button");
		backEndAdminPage.clickToDynamicCategoryOrButton(driver, "Search");

		log.info("TC_01: Step 20 - Wait for Loading icon invisible");
		backEndAdminPage.waitForLoadingIconInvisible();

		log.info("TC_01: Step 21 - Check to the 1st checkbox");
		backEndAdminPage.checkToCheckboxNextFirstOrder();

		log.info("TC_01: Step 22 - Select 'Print Invoices' in 'Actions' dropdown");
		backEndAdminPage.selectItemInDropdownFollowTable("Actions", "Print Invoices");

		log.info("TC_01: Step 23 - Click 'Submit' button");
		backEndAdminPage.clickToDynamicCategoryOrButton(driver, "Submit");

		log.info("TC_01: Step 24 - Verify Download successfully");
		DownloadFileFunction.VerifyDownloadedSuccessfully(".pdf");
		
		log.info("TC_01: Post condition - Logout from Admin page");
		backEndAdminPage.clickToLogOutButton();

	}
	
	@Test
	public void TC_02_VerifyTheProductMechanism() {
		log.info("======= LiveGuru BackEnd - TC_02: Verify The Product Mechanism =========");
		
		log.info("TC_02: Step 01 - Go to product link");
		backEndAdminPage.openAnyUrl(driver, LiveGuruBackEndTestData.LIVE_GURU_PRODUCT_URL);
		productReviewPage = LiveGuruPageFactoryManager.getProductReviewPage(driver);
		
		log.info("TC_02: Step 02 - Verify 'Let us know your thoughts' message displayed");
		verifyTrue(productReviewPage.isDynamicCommonLabelDisplayed(driver, "Let us know your thoughts"));

		log.info("TC_02: Step 03 - Verify 'Summary of Your Review' message displayed");
		verifyTrue(productReviewPage.isDynamicCommonLabelDisplayed(driver, "Summary of Your Review"));

		log.info("TC_02: Step 04 - Verify 'What's your nickname?' message displayed");
		verifyTrue(productReviewPage.isDynamicCommonLabelDisplayed(driver, "What's your nickname?"));
		
		log.info("TC_02: Step 05 - Input valid datas for 3 fields");
		productReviewPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "detail", LiveGuruBackEndTestData.REVIEW_COMMENT_DETAILS);
		productReviewPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "title", LiveGuruBackEndTestData.FINAL_REVIEW);
		productReviewPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "nickname", LiveGuruBackEndTestData.NICK_NAME);
		
		log.info("TC_02: Step 06 - Click 'SUBMIT REVIEW' button");
		productReviewPage.clickToDynamicLiveGuruButton(driver, "Submit Review");
		
		log.info("TC_02: Step 07 - Go to Backend Login page");
		productReviewPage.openAnyUrl(driver, backEndLoginUrl);
		backEndLoginPage = LiveGuruPageFactoryManager.getBackEndLoginPage(driver);

		log.info("TC_02: Step 08 - Verify Login Title 'Log in to Admin Pane' displays");
		verifyTrue(backEndLoginPage.isLoginTitleDisplayed());

		log.info("TC_02: Step 09 - Input to 'Username' textbox");
		backEndLoginPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "login[username]", LiveGuruBackEndTestData.USER_NAME);

		log.info("TC_02: Step 10 - Input to 'Password' textbox");
		backEndLoginPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "login[password]", LiveGuruBackEndTestData.PASSWORD);

		log.info("TC_02: Step 11 - Click To 'Login' button");
		backEndAdminPage = backEndLoginPage.clickToLoginButton();

		log.info("TC_02: Step 12 - Close Incoming message pop-up if it appears");
		backEndAdminPage.closeIncomingMessagePopUpIfItDisplays();

		log.info("TC_02: Step 13 - Verify 'Manage Customer' title displays");
		verifyTrue(backEndAdminPage.isDynamicBackendTitleDisplayed(driver, "Manage Customers"));
		
		log.info("TC_02: Step 14 - Hover mouse to 'Catalog' category");
		backEndAdminPage.hoverMouseToDynamicCategory(driver, "Catalog");

		log.info("TC_02: Step 15 - Hover mouse to 'Reviews and Ratings' category");
		backEndAdminPage.hoverMouseToDynamicCategory(driver, "Reviews and Ratings");
		
		log.info("TC_02: Step 16 - Hover mouse to 'Customer Reviews' category");
		backEndAdminPage.hoverMouseToDynamicCategory(driver, "Customer Reviews");
		
		log.info("TC_02: Step 17 - Click to 'Pending Reviews' category");
		backEndAdminPage.clickToDynamicCategoryOrButton(driver, "Pending Reviews");
		
		log.info("TC_02: Step 18 - Verify 'Pending Reviews' title displays");
		verifyTrue(backEndAdminPage.isDynamicBackendTitleDisplayed(driver, "Pending Reviews"));
		
		log.info("TC_02: Step 19 - Sort table by ID until getting descending order (click twice on button)");
		backEndAdminPage.clickToDynamicSortButton("ID");
		backEndAdminPage.clickToDynamicSortButton("ID");
		
		log.info("TC_02: Step 20 - Click to the expected 'Edit' button");
		backEndAdminPage.clickToExpectedEditButton(LiveGuruBackEndTestData.FINAL_REVIEW, LiveGuruBackEndTestData.NICK_NAME, LiveGuruBackEndTestData.REVIEW_COMMENT_DETAILS );
		
		log.info("TC_02: Step 21 - Verify 'Edit review' title displays");
		backEndAdminPage.isDynamicBackendTitleDisplayed(driver, "Edit Review ");
		
		log.info("TC_02: Step 22 - Verify 'Edit review' title displays");
		backEndAdminPage.selectItemInLiveGuruDynamicDropdown(driver, "status_id", "Approved");
		
		log.info("TC_02: Step 23 - Click on 'Save Review' button ");
		backEndAdminPage.clickToDynamicCategoryOrButton(driver, "Save Review");
		
		log.info("TC_02: Step 24 - Go to product link");
		backEndAdminPage.openAnyUrl(driver, LiveGuruBackEndTestData.LIVE_GURU_PRODUCT_URL);
		productReviewPage = LiveGuruPageFactoryManager.getProductReviewPage(driver);
		
		log.info("TC_02: Step 25 - Verify Your review displays");
		productReviewPage.isReviewDisplayed(LiveGuruBackEndTestData.FINAL_REVIEW, LiveGuruBackEndTestData.REVIEW_COMMENT_DETAILS, LiveGuruBackEndTestData.NICK_NAME);
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
