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

public class LiveGuruBackEnd extends AbstractTest {
	private WebDriver driver;
	private BackEndLoginPageObject backEndLoginPage;
	private BackEndAdminPageObject backEndAdminPage;

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
		DownloadFileFunction.VerifyDownloadedSuccessfully();

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
