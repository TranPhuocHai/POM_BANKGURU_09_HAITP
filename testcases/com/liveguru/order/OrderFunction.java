package com.liveguru.order;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.testdata.LiveGuruTestData;

import commons.AbstractTest;
import liveguruPageFactoryManager.LiveGuruPageFactoryManager;
import liveguruPageObjects.HomePageObject;
import liveguruPageObjects.MobilePageObject;
import liveguruPageObjects.MyAccountPageObject;
import liveguruPageObjects.RegisterPageObject;
import liveguruPageObjects.TVPageObject;

public class OrderFunction extends AbstractTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private MyAccountPageObject myAccountPage;
	private MobilePageObject mobilePage;
	private TVPageObject TVPage;
	
	private String email, listCost, detailsCost, errorMessage, inforBox;
	public static String HOME_PAGE_URL;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void BeforeTest(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);
		email = LiveGuruTestData.EMAIL  + randomNumber() + "@gmail.com" ;

	}
	
	@Test ()
	public void TC_01_RegisterToSystem() {
		log.info("TC_01: Step 01 - Get HomePage");
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("TC_01: Step 02 - Get HomePage Url");
		HOME_PAGE_URL = homePage.getCurrentPageUrl(driver);
		
		log.info("TC_01: Step 03 - Click to Account Menu");
		homePage.clickToAccountMenu(driver);
		
		log.info("TC_01: Step 04 - Click to Register link");
		homePage.clickToDynamicLink(driver,"Register");
		registerPage = LiveGuruPageFactoryManager.getRegisterPage(driver);
		
		log.info("TC_01: Step 05 - Verify Create An Account form display");
		verifyTrue(registerPage.isDynamicLiveGuruPageTitleDisplayed(driver, LiveGuruTestData.CREATE_AN_ACCOUNT_TITLE));
		
		log.info("TC_01: Step 06 - Input to First Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "firstname", LiveGuruTestData.FIRST_NAME);
		
		log.info("TC_01: Step 07 - Input to Middle Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "middlename", LiveGuruTestData.MIDDLE_NAME);
		
		log.info("TC_01: Step 08 - Input to Last Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "lastname", LiveGuruTestData.LAST_NAME);
		
		log.info("TC_01: Step 09 - Input to Email textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "email", email);
		
		log.info("TC_01: Step 10 - Input to First Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "password", LiveGuruTestData.PASSWORD);
		
		log.info("TC_01: Step 11 - Input to First Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "confirmation", LiveGuruTestData.PASSWORD);
		
		log.info("TC_01: Step 12 - Click to Register button");
		registerPage.clickToDynamicLiveGuruButton(driver, "Register");
		
		log.info("TC_01: Step 13 - Click to Register button");
		verifyTrue(registerPage.isRegisterSuccessMessageDisplayed());
	}
	
	@Test
	public void TC_02_VerifyUserInformation() {
		
		log.info("TC_02: Step 01 - open Home Page");
		registerPage.openAnyUrl(driver, HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("TC_02: Step 02 - Click to Account Menu");
		homePage.clickToAccountMenu(driver);
		
		log.info("TC_02: Step 03 - Click to My Account link");
		homePage.clickToDynamicLink(driver,"My Account");
		myAccountPage = LiveGuruPageFactoryManager.getMyAccountPage(driver);		
		
		log.info("TC_02: Step 04 - Get Text Infor box");
		inforBox =  myAccountPage.getTextInforBox(driver);
		
		log.info("TC_02: Step 05 - verify infor box displayed correct full name and email");		
		verifyTrue(inforBox.contains(LiveGuruTestData.FULL_NAME) && inforBox.contains(email));
		
		log.info("TC_02: Step 06 - Verify My Dasboard page displayed");
		verifyTrue(myAccountPage.isDynamicLiveGuruPageTitleDisplayed(driver, "My Dashboard"));
		
		log.info("TC_02: Step 07 - click to ACCOUNT INFORMATION link");
		myAccountPage.clickToDynamicCommonLink(driver,"Account Information");
		
		log.info("TC_02: Step 08 - Verify First Name is correct");
		verifyTrue(myAccountPage.isDynamicInforInTextboxCorrect(driver, "firstname", LiveGuruTestData.FIRST_NAME));
		
		log.info("TC_02: Step 09 - Verify Middle Name is correct");
		verifyTrue(myAccountPage.isDynamicInforInTextboxCorrect(driver, "middlename", LiveGuruTestData.MIDDLE_NAME));
		
		log.info("TC_02: Step 10 - Verify Last Name is correct");
		verifyTrue(myAccountPage.isDynamicInforInTextboxCorrect(driver, "lastname", LiveGuruTestData.LAST_NAME));
		
		log.info("TC_02: Step 11 - Verify Email is correct");
		verifyTrue(myAccountPage.isDynamicInforInTextboxCorrect(driver, "email", email));
	}
	
	@Test
	public void TC_03_VerifyCostProduct() {
		log.info("TC_03: Step 01 - open Home Page");
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("TC_03: Step 02 - Click to 'MOBILE' link and verify MOBILE page displayed");
		homePage.clickToDynamicLink(driver,"Mobile");
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
		
		log.info("TC_04: Step 01 - open Home Page");
		mobilePage.openAnyUrl(driver, HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("TC_04: Step 02 - Click to 'MOBILE' link and verify MOBILE page displayed");
		homePage.clickToDynamicLink(driver,"Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, "Mobile");
		
		log.info("TC_04: Step 03 - Click Add to Cart IPhone");
		mobilePage.clickToDynamicAddToCartButton(driver, "IPhone");
		
		log.info("TC_04: Step 04 - Verify 'SHOPPING CART' message displayed");
		verifyTrue(mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, LiveGuruTestData.SHOPPING_CART_TITLE));
		
		log.info("TC_04: Step 05 - Input Cupon code to 'DISCOUNT CODES' textbox");
		mobilePage.inputToDynamicTextboxTextAreaLiveGuru(driver, "coupon_code", LiveGuruTestData.CUPON_CODE);
		
		log.info("TC_04: Step 06 - Click APPLY button");
		mobilePage.clickToDynamicLiveGuruButton(driver, "Apply");
		
		log.info("TC_04: Step 07 - Verify Correct Discount title displayed");
		verifyTrue(mobilePage.isDiscountTitleDisplayed(driver, LiveGuruTestData.CUPON_CODE)); 
		
		log.info("TC_04: Step 08 - Verify Correct Discount money appears");
		verifyEquals(mobilePage.getTextDiscountMoney(driver, LiveGuruTestData.CUPON_CODE), LiveGuruTestData.DISCOUNT_MONEY);
			
		log.info("TC_04: Step 09 - Verify Grand Total are correct after discounting");
		verifyEquals(mobilePage.getTextGrandTotalMoney(driver), LiveGuruTestData.GRANT_TOTAL);
		
	}
	
	@Test
	public void TC_05_CanNotAddMoreThan500Items() {
		
		log.info("TC_05: Step 01 - open Home Page");
		mobilePage.openAnyUrl(driver, HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("TC_05: Step 02 - Click to 'MOBILE' link and verify MOBILE page displayed");
		homePage.clickToDynamicLink(driver,"Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, "Mobile");
		
		log.info("TC_05: Step 03 - Click Add to Cart IPhone");
		mobilePage.clickToDynamicAddToCartButton(driver, "Sony Xperia");
		
		log.info("TC_05: Step 04 - Verify 'SHOPPING CART' message displayed");
		verifyTrue(mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, LiveGuruTestData.SHOPPING_CART_TITLE));
		
		log.info("TC_05: Step 05 - Clear QTY textbox of Sony Xperia");
		mobilePage.clearDynamicQTYTextbox(driver, "Sony Xperia");
		
		log.info("TC_05: Step 06 - Input To QTY textbox of Sony Xperia");
		mobilePage.inputToDynamicQTYTextbox(driver, "Sony Xperia", LiveGuruTestData.PRODUCT_QUANTITY);
		
		log.info("TC_05: Step 07 - Click To UPDATE button of Sony Xperia");
		mobilePage.clickToDynamiUpdateButton(driver, "Sony Xperia");
		
		log.info("TC_05: Step 08 - Get text error message of Sony Xperia");
		errorMessage = mobilePage.getTextDynamicErrorMessage(driver, "Sony Xperia");
		
		log.info("TC_05: Step 09 - Verify '* The maximum quantity allowed for purchase is 500.' message of Sony Xperia displayed");
		verifyEquals(errorMessage.trim(), LiveGuruTestData.MAXIMUM_QUANTITY_ALLOWED_ERROR_MESSAGE);
		
	}
	
	@Test 
	public void TC_06_CompareProducts() {
		
		log.info("TC_06: Step 01 - open Home Page");
		mobilePage.openAnyUrl(driver, HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("TC_06: Step 02 - Click to 'MOBILE' link and verify MOBILE page displayed");
		homePage.clickToDynamicLink(driver,"Mobile");
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
		
		log.info("TC_06: Step 07 - Switch to COMPARE PRODUCTS window");
		mobilePage.swithToChildWindowByTitle(driver, LiveGuruTestData.COMPARE_PRODUCTS_WINDOW_TITLE);
		
		log.info("TC_06: Step 08 - Verify COMPARE PRODUCTS text title displayed");
		verifyTrue(mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, LiveGuruTestData.COMPARE_PRODUCTS_TITLE));
		
		log.info("TC_06: Step 09 - Verify that Sony Xparia displays in COMPARE PRODUCTS window");
		verifyTrue(mobilePage.isDynamicProductLinkDisplayed(driver, "Sony Xperia"));
		
		log.info("TC_06: Step 10 - Verify that IPhone displays in COMPARE PRODUCT window");
		verifyTrue(mobilePage.isDynamicProductLinkDisplayed(driver, "IPhone"));
		
		log.info("TC_06: Step 11 - Close COMPARE PRODUCT window ");
		mobilePage.closeAllExceptParentWindow(driver, parentID);
		
	}
	
	@Test
	public void TC_07_SharingWishlist() {
		
		log.info("TC_07: Step 01 - open Home Page");
		mobilePage.openAnyUrl(driver, HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("TC_07: Step 02 - Click to 'TV' link and verify TV page displayed");
		homePage.clickToDynamicLink(driver,"TV");
		TVPage = LiveGuruPageFactoryManager.getTVPage(driver);
		TVPage.isDynamicLiveGuruPageTitleDisplayed(driver, "TV");
		
		log.info("TC_07: Step 03 - Click to 'Add to Wishlist' of LG LCD");
		TVPage.clickToAddToWishlistLinkOfDynamicProduct(driver, "LG LCD");
		
		log.info("TC_07: Step 04 - verify message 'LG LCD has been added to your wishlist. Click here to continue shopping.' displayed");
		verifyEquals(TVPage.getTextDynamicProductAddedToWishListMessageDisplayed(driver, "LG LCD"),"LG LCD" + LiveGuruTestData.PRODUCT_ADDED_TO_WISH_LIST_MESSAGE);
		
		log.info("TC_07: Step 05 - Click to 'SHARE WISHLIST' button");
		TVPage.clickToDynamicLiveGuruButton(driver, "Share Wishlist");
		
		log.info("TC_07: Step 06 - Verify 'SHARE YOUR WISHLIST' page displayed");
		TVPage.isDynamicLiveGuruPageTitleDisplayed(driver, LiveGuruTestData.SHARE_YOUR_WISHLIST_TITLE);
		
		log.info("TC_07: Step 07 - Input to Email and Message text areas");
		TVPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "emails", LiveGuruTestData.SHARING_WISH_LIST_EMAIL);
		TVPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "message", LiveGuruTestData.SHARING_WISHI_LIST_MESSAGE);
		
		log.info("TC_07: Step 08 - Click to 'SHARE WIHSLIST' button");
		TVPage.clickToDynamicLiveGuruButton(driver, "Share Wishlist");
		
		log.info("TC_07: Step 09 - Verify 'Your Wishlist has been shared.'");
		verifyTrue(TVPage.isDynamicMessageDisplayed(driver, "Your Wishlist has been shared."));
		
		log.info("TC_07: Step 10 - Verify there's 1 item LG LCD in 'MY WISHLIST' page");
		verifyTrue(TVPage.isCorrectNumberItemOfDynamicProductDisplayed(driver, "LG LCD", "1"));
		
	}
	
	@Test
	public void TC_08_VerifyYouCanAddYourReview() {
		
		log.info("TC_08: Step 01 - open Home Page");
		TVPage.openAnyUrl(driver, HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("TC_08: Step 02 - Click to 'TV' link and verify TV page displayed");
		homePage.clickToDynamicLink(driver,"TV");
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
		verifyEquals(TVPage.getTextLiveGuruValidateMessage(driver, "detail"),"THIS IS A REQUIRED FIELD.");
		verifyEquals(TVPage.getTextLiveGuruValidateMessage(driver, "title"),"THIS IS A REQUIRED FIELD.");
		verifyEquals(TVPage.getTextLiveGuruValidateMessage(driver, "nickname"),"THIS IS A REQUIRED FIELD.");
		
		log.info("TC_08: Step 12 - Input valid datas for 3 fields");
		TVPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "detail", "It's Good");
		TVPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "title", "Acceptable");
		TVPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "nickname", "Hai");
		
		log.info("TC_08: Step 13 - Click 'SUBMIT REVIEW' button");
		TVPage.clickToDynamicLiveGuruButton(driver, "Submit Review");
		
		log.info("TC_08: Step 14 - Verify message 'Your review has been accepted for moderation.' displayed ");
		verifyTrue(TVPage.isDynamicMessageDisplayed(driver, "Your review has been accepted for moderation." ));
		
		
		
	}
	
	@Test
	public void TC_09_VerifyUserIsAbleToPurchaseproduct() {
		
		
	}
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}












