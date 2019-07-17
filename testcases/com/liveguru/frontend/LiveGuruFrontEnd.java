package com.liveguru.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.frontend.testdata.LiveGuruFrontEndTestData;

import PageFactoryManager.LiveGuruPageFactoryManager;
import commons.AbstractTest;
import liveguruPageObjects.CatalogSearchPageObject;
import liveguruPageObjects.CheckOutPageObject;
import liveguruPageObjects.CompareProductPageObject;
import liveguruPageObjects.HomePageObject;
import liveguruPageObjects.MobilePageObject;
import liveguruPageObjects.MyAccountPageObject;
import liveguruPageObjects.RegisterPageObject;
import liveguruPageObjects.ShoppingCartPageObject;
import liveguruPageObjects.TVPageObject;

public class LiveGuruFrontEnd extends AbstractTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private MyAccountPageObject myAccountPage;
	private MobilePageObject mobilePage;
	private TVPageObject TVPage;
	private ShoppingCartPageObject shoppingCartPage;
	private CompareProductPageObject compareProductPage;
	private CheckOutPageObject checkOutPage;
	private CatalogSearchPageObject catalogSearchPage;

	private String email, listCost, detailsCost, errorMessage, inforBox;
	private String grandCostAfterShipCost, grandCostBeforeShipCost, shippingCost;
	public static String LIVE_GURU_HOME_PAGE_URL, ORDER_NUMBER;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void BeforeTest(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);
		email = LiveGuruFrontEndTestData.EMAIL + randomNumber() + "@gmail.com";

	}

	@Test()
	public void TC_01_RegisterToSystem() {
		
		log.info("========= LiveGuru FrontEnd - Testcase 01: Register To System ============");
		
		log.info("TC_01: Step 01 - Get HomePage");
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);

		log.info("TC_01: Step 02 - Get HomePage Url");
		LIVE_GURU_HOME_PAGE_URL = homePage.getCurrentPageUrl(driver);

		log.info("TC_01: Step 03 - Click to 'Account' menu button");
		homePage.clickToAccountMenu(driver);

		log.info("TC_01: Step 04 - Click to Register link");
		homePage.clickToHeaderDynamicLink(driver, "Register");
		registerPage = LiveGuruPageFactoryManager.getRegisterPage(driver);

		log.info("TC_01: Step 05 - Verify Create An Account form display");
		verifyTrue(registerPage.isDynamicLiveGuruPageTitleDisplayed(driver, LiveGuruFrontEndTestData.CREATE_AN_ACCOUNT_TITLE));

		log.info("TC_01: Step 06 - Input to First Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "firstname", LiveGuruFrontEndTestData.FIRST_NAME);

		log.info("TC_01: Step 07 - Input to Middle Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "middlename", LiveGuruFrontEndTestData.MIDDLE_NAME);

		log.info("TC_01: Step 08 - Input to Last Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "lastname", LiveGuruFrontEndTestData.LAST_NAME);

		log.info("TC_01: Step 09 - Input to Email textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "email", email);

		log.info("TC_01: Step 10 - Input to First Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "password", LiveGuruFrontEndTestData.PASSWORD);

		log.info("TC_01: Step 11 - Input to First Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "confirmation", LiveGuruFrontEndTestData.PASSWORD);

		log.info("TC_01: Step 12 - Click to Register button");
		registerPage.clickToDynamicLiveGuruButton(driver, "Register");

		log.info("TC_01: Step 13 - Click to Register button");
		verifyTrue(registerPage.isRegisterSuccessMessageDisplayed());
	}

	@Test
	public void TC_02_VerifyUserInformation() {
		
		log.info("========= LiveGuru FrontEnd - Testcase 02: Verify User Information ============");

		log.info("TC_02: Step 01 - Open Home Page");
		registerPage.openAnyUrl(driver, LIVE_GURU_HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);

		log.info("TC_02: Step 02 - Click to Account Menu");
		homePage.clickToAccountMenu(driver);

		log.info("TC_02: Step 03 - Click to My Account link");
		homePage.clickToHeaderDynamicLink(driver, "My Account");
		myAccountPage = LiveGuruPageFactoryManager.getMyAccountPage(driver);

		log.info("TC_02: Step 04 - Get Text Infor box");
		inforBox = myAccountPage.getTextInforBox();

		log.info("TC_02: Step 05 - verify infor box displayed correct full name and email");
		verifyTrue(inforBox.contains(LiveGuruFrontEndTestData.FULL_NAME) && inforBox.contains(email));

		log.info("TC_02: Step 06 - Verify My Dasboard page displayed");
		verifyTrue(myAccountPage.isDynamicLiveGuruPageTitleDisplayed(driver, "My Dashboard"));

		log.info("TC_02: Step 07 - click to ACCOUNT INFORMATION link");
		myAccountPage.clickToDynamicCommonLink(driver, "Account Information");

		log.info("TC_02: Step 08 - Verify First Name is correct");
		verifyTrue(myAccountPage.isDynamicInforInTextboxCorrect(driver, "firstname", LiveGuruFrontEndTestData.FIRST_NAME));

		log.info("TC_02: Step 09 - Verify Middle Name is correct");
		verifyTrue(myAccountPage.isDynamicInforInTextboxCorrect(driver, "middlename", LiveGuruFrontEndTestData.MIDDLE_NAME));

		log.info("TC_02: Step 10 - Verify Last Name is correct");
		verifyTrue(myAccountPage.isDynamicInforInTextboxCorrect(driver, "lastname", LiveGuruFrontEndTestData.LAST_NAME));

		log.info("TC_02: Step 11 - Verify Email is correct");
		verifyTrue(myAccountPage.isDynamicInforInTextboxCorrect(driver, "email", email));
	}

	@Test
	public void TC_03_VerifyCostProduct() {
		
		log.info("========= LiveGuru FrontEnd - Testcase 03: Verify Cost Product ============");
		
		log.info("TC_03: Step 01 - Open Home Page");
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);

		log.info("TC_03: Step 02 - Click to 'MOBILE' link and verify MOBILE page displayed");
		homePage.clickToHeaderDynamicLink(driver, "Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, "Mobile");

		log.info("TC_03: Step 03 - Get Cost of Sony Xperia in list page");
		listCost = mobilePage.getCostDynamicProductInMobileListPage(driver, "Sony Xperia");

		log.info("TC_03: Step 04 - Click to Sony Xperia details");
		mobilePage.clickToDynamicCommonLink(driver, "Sony Xperia");

		log.info("TC_03: Step 05 - Get Cost of Sony Xperia in details page");
		detailsCost = mobilePage.getCostDynamicProductInMobileDetailsPage(driver, "Sony Xperia");

		log.info("TC_03: Step 06 - Verify cost of product in list page and details page are equal");
		verifyEquals(listCost, detailsCost);

	}

	@Test
	public void TC_04_VerifyDiscountCuponWorksCorrectly() {
		
		log.info("====== LiveGuru FrontEnd - Testcase 04: Verify Discount Cupon Works Correctly =========");

		log.info("TC_04: Step 01 - Open Home Page");
		mobilePage.openAnyUrl(driver, LIVE_GURU_HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);

		log.info("TC_04: Step 02 - Click to 'MOBILE' link and verify MOBILE page displayed");
		homePage.clickToHeaderDynamicLink(driver, "Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, "Mobile");

		log.info("TC_04: Step 03 - Click Add to Cart IPhone");
		shoppingCartPage = mobilePage.clickToDynamicAddToCartButton(driver, "IPhone");

		log.info("TC_04: Step 04 - Verify 'SHOPPING CART' message displayed");
		verifyTrue(shoppingCartPage.isDynamicLiveGuruPageTitleDisplayed(driver, LiveGuruFrontEndTestData.SHOPPING_CART_TITLE));

		log.info("TC_04: Step 05 - Input Cupon code to 'DISCOUNT CODES' textbox");
		shoppingCartPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "coupon_code", LiveGuruFrontEndTestData.CUPON_CODE);

		log.info("TC_04: Step 06 - Click APPLY button");
		shoppingCartPage.clickToDynamicLiveGuruButton(driver, "Apply");

		log.info("TC_04: Step 07 - Verify Correct Discount title displayed");
		verifyTrue(shoppingCartPage.isDiscountTitleDisplayed(driver, LiveGuruFrontEndTestData.CUPON_CODE));

		log.info("TC_04: Step 08 - Verify Correct Discount money appears");
		verifyEquals(shoppingCartPage.getTextDiscountMoney(driver, LiveGuruFrontEndTestData.CUPON_CODE), LiveGuruFrontEndTestData.DISCOUNT_MONEY);

		log.info("TC_04: Step 09 - Verify Grand Total are correct after discounting");
		verifyEquals(shoppingCartPage.getTextGrandTotalMoney(), LiveGuruFrontEndTestData.GRANT_TOTAL);

	}

	@Test
	public void TC_05_VeifyCanNotAddMoreThan500Items() {
		
		log.info("====== LiveGuru FrontEnd - Testcase 05: Veify Cannot Add More Than 500 Items =======");

		log.info("TC_05: Step 01 - Open Home Page");
		shoppingCartPage.openAnyUrl(driver, LIVE_GURU_HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);

		log.info("TC_05: Step 02 - Click to 'MOBILE' link and verify MOBILE page displayed");
		homePage.clickToHeaderDynamicLink(driver, "Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, "Mobile");

		log.info("TC_05: Step 03 - Click Add to Cart IPhone");
		shoppingCartPage = mobilePage.clickToDynamicAddToCartButton(driver, "Sony Xperia");

		log.info("TC_05: Step 04 - Verify 'SHOPPING CART' message displayed");
		verifyTrue(shoppingCartPage.isDynamicLiveGuruPageTitleDisplayed(driver, LiveGuruFrontEndTestData.SHOPPING_CART_TITLE));

		log.info("TC_05: Step 05 - Clear QTY textbox of Sony Xperia");
		shoppingCartPage.clearDynamicQTYTextbox(driver, "Sony Xperia");

		log.info("TC_05: Step 06 - Input To QTY textbox of Sony Xperia");
		shoppingCartPage.inputToDynamicQTYTextbox(driver, "Sony Xperia", LiveGuruFrontEndTestData.INVALID_PRODUCT_QUANTITY);

		log.info("TC_05: Step 07 - Click To UPDATE button of Sony Xperia");
		shoppingCartPage.clickToDynamiUpdateButton(driver, "Sony Xperia");

		log.info("TC_05: Step 08 - Get text error message of Sony Xperia");
		errorMessage = shoppingCartPage.getTextDynamicErrorMessage(driver, "Sony Xperia");

		log.info("TC_05: Step 09 - Verify '* The maximum quantity allowed for purchase is 500.' message of Sony Xperia displayed");
		verifyEquals(errorMessage.trim(), "* The maximum quantity allowed for purchase is 500.");

		log.info("TC_05: Step 10 - Extra step for get valid number of products");
		shoppingCartPage.clearDynamicQTYTextbox(driver, "Sony Xperia");
		shoppingCartPage.inputToDynamicQTYTextbox(driver, "Sony Xperia", LiveGuruFrontEndTestData.VALID_PRODUCT_QUANTITY);
		shoppingCartPage.clickToDynamiUpdateButton(driver, "Sony Xperia");

	}

	@Test
	public void TC_06_CompareProductsFunction() {
		
		log.info("========= LiveGuru FrontEnd - Testcase 06: Compare Products Function ==========");

		log.info("TC_06: Step 01 - Open Home Page");
		shoppingCartPage.openAnyUrl(driver, LIVE_GURU_HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);

		log.info("TC_06: Step 02 - Click to 'MOBILE' link and verify MOBILE page displayed");
		homePage.clickToHeaderDynamicLink(driver, "Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, "Mobile");

		log.info("TC_06: Step 03 - Add Sony Xepria to Compare list");
		mobilePage.clickToAddToCompareLinkOfDynamicProduct(driver, "Sony Xperia");

		log.info("TC_06: Step 04 - Add IPhone to Compare list");
		mobilePage.clickToAddToCompareLinkOfDynamicProduct(driver, "IPhone");

		log.info("TC_06: Step 05 - Get Parent window");
		String parentID = mobilePage.getParentWindowID(driver);

		log.info("TC_06: Step 06 - Click to Compare Button");
		mobilePage.clickToDynamicLiveGuruButton(driver, "Compare");
		compareProductPage = LiveGuruPageFactoryManager.getCompareProductPage(driver);

		log.info("TC_06: Step 07 - Switch to COMPARE PRODUCTS window");
		compareProductPage.swithToChildWindowByTitle(driver, LiveGuruFrontEndTestData.COMPARE_PRODUCTS_WINDOW_TITLE);

		log.info("TC_06: Step 08 - Verify COMPARE PRODUCTS text title displayed");
		verifyTrue(compareProductPage.isDynamicLiveGuruPageTitleDisplayed(driver, LiveGuruFrontEndTestData.COMPARE_PRODUCTS_TITLE));

		log.info("TC_06: Step 09 - Verify that Sony Xparia displays in COMPARE PRODUCTS window");
		verifyTrue(compareProductPage.isDynamicProductLinkDisplayed(driver, "Sony Xperia"));

		log.info("TC_06: Step 10 - Verify that IPhone displays in COMPARE PRODUCT window");
		verifyTrue(compareProductPage.isDynamicProductLinkDisplayed(driver, "IPhone"));

		log.info("TC_06: Step 11 - Close COMPARE PRODUCT window ");
		compareProductPage.closeAllExceptParentWindow(driver, parentID);

	}

	@Test
	public void TC_07_SharingWishlistFunction() {
		
		log.info("========= LiveGuru FrontEnd - Testcase 07: Sharing Wish list Function ==========");

		log.info("TC_07: Step 01 - Open Home Page");
		compareProductPage.openAnyUrl(driver, LIVE_GURU_HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);

		log.info("TC_07: Step 02 - Click to 'TV' link and verify TV page displayed");
		homePage.clickToHeaderDynamicLink(driver, "TV");
		TVPage = LiveGuruPageFactoryManager.getTVPage(driver);
		TVPage.isDynamicLiveGuruPageTitleDisplayed(driver, "TV");

		log.info("TC_07: Step 03 - Click to 'Add to Wishlist' of LG LCD");
		myAccountPage = TVPage.clickToAddToWishlistLinkOfDynamicProduct(driver, "LG LCD");

		log.info("TC_07: Step 04 - verify message 'LG LCD has been added to your wishlist. Click here to continue shopping.' displayed");
		verifyEquals(myAccountPage.getTextDynamicProductAddedToWishListMessageDisplayed(driver, "LG LCD"), "LG LCD" + " has been added to your wishlist. Click here to continue shopping.");

		log.info("TC_07: Step 05 - Click to 'SHARE WISHLIST' button");
		myAccountPage.clickToDynamicLiveGuruButton(driver, "Share Wishlist");

		log.info("TC_07: Step 06 - Verify 'SHARE YOUR WISHLIST' page displayed");
		myAccountPage.isDynamicLiveGuruPageTitleDisplayed(driver, LiveGuruFrontEndTestData.SHARE_YOUR_WISHLIST_TITLE);

		log.info("TC_07: Step 07 - Input to Email and Message text areas");
		myAccountPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "emails", LiveGuruFrontEndTestData.SHARING_WISH_LIST_EMAIL);
		myAccountPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "message", LiveGuruFrontEndTestData.SHARING_WISHI_LIST_MESSAGE);

		log.info("TC_07: Step 08 - Click to 'SHARE WIHSLIST' button");
		myAccountPage.clickToDynamicLiveGuruButton(driver, "Share Wishlist");

		log.info("TC_07: Step 09 - Verify 'Your Wishlist has been shared.'");
		verifyTrue(myAccountPage.isDynamicMessageDisplayed(driver, "Your Wishlist has been shared."));

		log.info("TC_07: Step 10 - Verify there's 1 item LG LCD in 'MY WISHLIST' page");
		verifyTrue(myAccountPage.isCorrectNumberItemOfDynamicProductDisplayed(driver, "LG LCD", "1"));

	}

	@Test
	public void TC_08_VerifyYouCanAddYourReview() {
		
		log.info("======= LiveGuru FrontEnd - Testcase 08: Verify You Can Add Your Review ========");

		log.info("TC_08: Step 01 - Open Home Page");
		myAccountPage.openAnyUrl(driver, LIVE_GURU_HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);

		log.info("TC_08: Step 02 - Click to 'TV' link and verify TV page displayed");
		homePage.clickToHeaderDynamicLink(driver, "TV");
		TVPage = LiveGuruPageFactoryManager.getTVPage(driver);
		TVPage.isDynamicLiveGuruPageTitleDisplayed(driver, "TV");

		log.info("TC_08: Step 03 - Click to 'SAMSUNG LCD' link");
		TVPage.clickToDynamicCommonLink(driver, "Samsung LCD");

		log.info("TC_08: Step 04 - Verify 'SAMSUNG LCD' title displayed ");
		verifyTrue(TVPage.isDynamicProductDetailsTitleDisplayed(driver, "Samsung LCD"));

		log.info("TC_08: Step 05 - Click to 'Add Your Review' link");
		TVPage.clickToDynamicCommonLink(driver, "Add Your Review");

		log.info("TC_08: Step 06 - Verify 'Let us know your thoughts' message displayed");
		verifyTrue(TVPage.isDynamicCommonLabelDisplayed(driver, "Let us know your thoughts"));

		log.info("TC_08: Step 07 - Verify 'Summary of Your Review' message displayed");
		verifyTrue(TVPage.isDynamicCommonLabelDisplayed(driver, "Summary of Your Review"));

		log.info("TC_08: Step 08 - Verify 'What's your nickname?' message displayed");
		verifyTrue(TVPage.isDynamicCommonLabelDisplayed(driver, "What's your nickname?"));

		log.info("TC_08: Step 09 - input empty data to 3 fields thoughts/Review/Nickname");
		TVPage.clearLiveGuruDynamicTextboxOrTextArea(driver, "detail");
		TVPage.clearLiveGuruDynamicTextboxOrTextArea(driver, "title");
		TVPage.clearLiveGuruDynamicTextboxOrTextArea(driver, "nickname");

		log.info("TC_08: Step 10 - Click 'SUBMIT REVIEW' button");
		TVPage.clickToDynamicLiveGuruButton(driver, "Submit Review");

		log.info("TC_08: Step 11 - Verify validate message 'This is a required field.' displayed in 3 fields");
		verifyEquals(TVPage.getTextLiveGuruValidateMessage(driver, "detail"), "THIS IS A REQUIRED FIELD.");
		verifyEquals(TVPage.getTextLiveGuruValidateMessage(driver, "title"), "THIS IS A REQUIRED FIELD.");
		verifyEquals(TVPage.getTextLiveGuruValidateMessage(driver, "nickname"), "THIS IS A REQUIRED FIELD.");

		log.info("TC_08: Step 12 - Input valid datas for 3 fields");
		TVPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "detail", "It's Good");
		TVPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "title", "Acceptable");
		TVPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "nickname", "Hai");

		log.info("TC_08: Step 13 - Click 'SUBMIT REVIEW' button");
		TVPage.clickToDynamicLiveGuruButton(driver, "Submit Review");

		log.info("TC_08: Step 14 - Verify message 'Your review has been accepted for moderation.' displayed ");
		verifyTrue(TVPage.isDynamicMessageDisplayed(driver, "Your review has been accepted for moderation."));

	}

	@Test
	public void TC_09_VerifyUserIsAbleToPurchaseProduct() {
		
		log.info("======= LiveGuru FrontEnd - Testcase 09: Verify User Is Able To Purchase Product ========");


		log.info("TC_09: Step 01 - Open Home Page");
		TVPage.openAnyUrl(driver, LIVE_GURU_HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);

		log.info("TC_09: Step 02 - Click To 'Account' menu button");
		homePage.clickToAccountMenu(driver);

		log.info("TC_09: Step 03 - Click to 'My Wishlist' link");
		homePage.clickToHeaderDynamicLink(driver, "My Wishlist");
		myAccountPage = LiveGuruPageFactoryManager.getMyAccountPage(driver);

		log.info("TC_09: Step 04 - Verify 'MY WISHLIST' title displayed");
		myAccountPage.isDynamicLiveGuruPageTitleDisplayed(driver, "My Wishlist");

		log.info("TC_09: Stpe 05 - Click To 'Add To Cart' button of current product");
		myAccountPage.clickToDynamicAddToCartButtonInWishListPage("LG LCD");
		shoppingCartPage = LiveGuruPageFactoryManager.getShoppingCartPage(driver);

		log.info("TC_09: Step 06 - Verify 'SHOPPING CART' title displayed");
		shoppingCartPage.isDynamicLiveGuruPageTitleDisplayed(driver, "Shopping Cart");

		log.info("TC_09: Step 07 - Verify 'ESTIMATE SHIPPING AND TAX' message displayed");
		shoppingCartPage.isEstimateShippingAndTaxMessageDisplayed();

		log.info("TC_09: Step 08 - Get Grand Total Cost before adding ship cost");
		grandCostBeforeShipCost = shoppingCartPage.getTextGrandTotalMoney();

		log.info("TC_09: Step 09 - Select in 'COUNTRY' dropdown");
		shoppingCartPage.selectItemInLiveGuruDynamicDropdown(driver, "country_id", "United States");

		log.info("TC_09: Step 10 - Select in 'STATE/PROVINCE' dropdown");
		shoppingCartPage.selectItemInLiveGuruDynamicDropdown(driver, "region_id", "New York");

		log.info("TC_09: Step 11 - Input to 'ZIP' textbox");
		shoppingCartPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "estimate_postcode", "543432");

		log.info("TC_09: Step 12 - Click To Estimate Button");
		shoppingCartPage.clickToEstimateButton();

		log.info("TC_09: Step 13 - Verify Flat Rate Information Displayed");
		shoppingCartPage.isFlatRateInformationDisplayed();

		log.info("TC_09: Step 14 - Get textshipping cost");
		shippingCost = shoppingCartPage.getShippingCost();

		log.info("TC_09: Step 15 - Check To 'Fixed' radio button/Select shipping cost");
		shoppingCartPage.checkToDynamicLiveGuruCheckboxOrRadioButton(driver, "estimate_method");

		log.info("TC_09: Step 16 - Click 'UPDATE TOTAL' button");
		shoppingCartPage.clickToDynamicLiveGuruButton(driver, "Update Total");

		log.info("TC_09: Step 17 - Click 'UPDATE TOTAL' button");
		grandCostAfterShipCost = shoppingCartPage.getTextGrandTotalMoney();

		log.info("TC_09: Step 18 - Verify shipping cost added to Total");
		if (shippingCost.equals("$0.00")) {
			verifyTrue(grandCostBeforeShipCost.equals(grandCostAfterShipCost));
		} else
			verifyFalse(grandCostBeforeShipCost.equals(grandCostAfterShipCost));

		log.info("TC_09: Step 19 - Click to 'PROCEED TO CHECKOUT' button");
		shoppingCartPage.clickToDynamicLiveGuruButton(driver, "Proceed to Checkout");
		checkOutPage = LiveGuruPageFactoryManager.getCheckOutPage(driver);

		log.info("TC_09: Step 20 - Verify 5 Categories displayed");
		checkOutPage.isDynamicNumberDisplayed("1");
		checkOutPage.isDynamicNumberDisplayed("2");
		checkOutPage.isDynamicNumberDisplayed("3");
		checkOutPage.isDynamicNumberDisplayed("4");
		checkOutPage.isDynamicNumberDisplayed("5");

		checkOutPage.isDynamicCheckOutCategoryDisplayed("Billing Information");
		checkOutPage.isDynamicCheckOutCategoryDisplayed("Shipping Information");
		checkOutPage.isDynamicCheckOutCategoryDisplayed("Shipping Method");
		checkOutPage.isDynamicCheckOutCategoryDisplayed("Payment Information");
		checkOutPage.isDynamicCheckOutCategoryDisplayed("Order Review");

		log.info("TC_09: Step 21 - Verify First Name is correct");
		verifyTrue(checkOutPage.isDynamicInforInTextboxCorrect(driver, "billing:firstname", LiveGuruFrontEndTestData.FIRST_NAME));

		log.info("TC_09: Step 22 - Verify Middle Name is correct");
		verifyTrue(checkOutPage.isDynamicInforInTextboxCorrect(driver, "billing:middlename", LiveGuruFrontEndTestData.MIDDLE_NAME));

		log.info("TC_09: Step 23 - Verify Last Name is correct");
		verifyTrue(checkOutPage.isDynamicInforInTextboxCorrect(driver, "billing:lastname", LiveGuruFrontEndTestData.LAST_NAME));

		log.info("TC_09: Step 24 - Input data to 'Company' textbox");
		checkOutPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "billing[company]", "My Place");

		log.info("TC_09: Step 25 - Input data to 'Address' textbox");
		checkOutPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "billing[street][]", "123 This place");

		log.info("TC_09: Step 26 - Input data to 'Company' textbox");
		checkOutPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "billing[company]", "XYZ");

		log.info("TC_09: Step 27 - Input data to 'City' textbox");
		checkOutPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "billing[city]", "New York");

		log.info("TC_09: Step 28 - Select State/Province");
		checkOutPage.selectItemInLiveGuruDynamicDropdown(driver, "billing[region_id]", "New York");

		log.info("TC_09: Step 29 - Input data to 'Zip' textbox");
		checkOutPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "billing[postcode]", "543432");

		log.info("TC_09: Step 30 - Select Country");
		checkOutPage.selectItemInLiveGuruDynamicDropdown(driver, "billing[country_id]", "United States");

		log.info("TC_09: Step 31 - Input data to 'Telephone' textbox");
		checkOutPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "billing[telephone]", "0987654321");

		log.info("TC_09: Step 32 - Input data to 'Fax' textbox");
		checkOutPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "billing[fax]", "0987654321");

		log.info("TC_09: Step 33 - Check to radio button 'Ship to this address'");
		checkOutPage.checkToDynamicLiveGuruCheckboxOrRadioButton(driver, "billing[use_for_shipping]");

		log.info("TC_09: Step 34 - Click to Billing 'CONTINUE' button");
		checkOutPage.clickToBillingContinueButton();

		log.info("TC_09: Step 35 - Click to Shipping 'CONTINUE' button");
		checkOutPage.clickToShippingContinueButton();

		log.info("TC_09: Step 36 - Check to radio button 'Check / Money order'");
		checkOutPage.checkToMoneyOrderRadioButton();

		log.info("TC_09: Step 37 - Click to Payment 'CONTINUE' button");
		checkOutPage.clickToPaymentContinueButton();

		log.info("TC_09: Step 38 - Click to 'PLACE ORDER' button");
		checkOutPage.clickToPlaceOrderButton();

		log.info("TC_09: Step 39 - Verify 'Your order has been received.' title displayed");
		checkOutPage.isDynamicLiveGuruPageTitleDisplayed(driver, "Your order has been received.");

		log.info("TC_09: Step 40 - Verify 'Thank you for your purchase!' message displayed");
		checkOutPage.isThankYouForYourPurchaseMessageDisplayed();

		log.info("TC_09: Step 41 - Get Order Numver");
		ORDER_NUMBER = checkOutPage.getTextOrderNumber();

	}

	@Test
	public void TC_10_VerifySearchFunctionality() {
		
		log.info("============ LiveGuru FrontEnd - Testcase 10: Verify Search Functionality ============");
		
		log.info("TC_10: Step 01 - Open Home Page");
		checkOutPage.openAnyUrl(driver, LIVE_GURU_HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);

		log.info("TC_10: Step 02 - Click to 'ADVANCE SEARCH' link");
		homePage.clickToFooterDynamicLink(driver, "Advanced Search");
		catalogSearchPage = LiveGuruPageFactoryManager.getCatalogSearchPage(driver);

		log.info("TC_10: Step 03 - Verify'CATALOG ADVANCED SEARCH' title displayed");
		catalogSearchPage.isDynamicLiveGuruPageTitleDisplayed(driver, "Catalog Advanced Search");

		log.info("TC_10: Step 04 - Input to price range '0-150' in Price Field");
		catalogSearchPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "price[from]", "1");
		catalogSearchPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "price[to]", "150");

		log.info("TC_10: Step 05 - Click To Search Button");
		catalogSearchPage.clickToSearchButton();

		log.info("TC_10: Step 05 - Print all Products and Prices to console");
		catalogSearchPage.printAllProductsAndprices();

		log.info("TC_10: Step 06 - Click to 'ADVANCE SEARCH' link");
		homePage.clickToFooterDynamicLink(driver, "Advanced Search");
		catalogSearchPage = LiveGuruPageFactoryManager.getCatalogSearchPage(driver);

		log.info("TC_10: Step 07 - Verify'CATALOG ADVANCED SEARCH' title displayed");
		catalogSearchPage.isDynamicLiveGuruPageTitleDisplayed(driver, "Catalog Advanced Search");

		log.info("TC_10: Step 08 - Input to price range '151-1000' in Price Field");
		catalogSearchPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "price[from]", "151");
		catalogSearchPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "price[to]", "1000");

		log.info("TC_10: Step 09 - Click To Search Button");
		catalogSearchPage.clickToSearchButton();

		log.info("TC_10: Step 10 - Print all Products and Prices to console");
		catalogSearchPage.printAllProductsAndprices();

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
