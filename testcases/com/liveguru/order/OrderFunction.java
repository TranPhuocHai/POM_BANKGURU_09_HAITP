package com.liveguru.order;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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
	private String listCost, detailsCost, errorMessage;
	private String cuponCode = "GURU50";
	private String discountMoney = "-$25.00";
	private String grantTotal = "$500.00";
	private String productQuantity = "501";
	private String inforBox;
	
	private String  firstName = "Hai";
	private String  middleName = "Phuoc";
	private String  lastName = "Tran";
	private String  fullName = firstName +" " + middleName + " " + lastName;
	private String email = "haitp" + randomNumber() + "@gmail.com";
	private String password = "123654";
	public static String HOME_PAGE_URL;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void BeforeTest(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);
		
	}
	
	@Test ()
	public void TC_01_RegisterToSystem() {
		log.info("RegisterToSystem: Step 01 - Get HomePage");
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("RegisterToSystem: Step 02 - Get HomePage Url");
		HOME_PAGE_URL = homePage.getCurrentPageUrl(driver);
		
		log.info("RegisterToSystem: Step 03 - Click to Account Menu");
		homePage.clickToAccountMenu(driver);
		
		log.info("RegisterToSystem: Step 04 - Click to Register link");
		homePage.clickToDynamicLink(driver,"Register");
		registerPage = LiveGuruPageFactoryManager.getRegisterPage(driver);
		
		log.info("RegisterToSystem: Step 05 - Verify Create An Account form display");
		verifyTrue(registerPage.isResgisterFormDisplayed());
		
		log.info("RegisterToSystem: Step 06 - Input to First Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "firstname", firstName);
		
		log.info("RegisterToSystem: Step 07 - Input to Middle Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "middlename", middleName);
		
		log.info("RegisterToSystem: Step 08 - Input to Last Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "lastname", lastName);
		
		log.info("RegisterToSystem: Step 09 - Input to Email textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "email", email);
		
		log.info("RegisterToSystem: Step 10 - Input to First Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "password", password);
		
		log.info("RegisterToSystem: Step 11 - Input to First Name textbox");
		registerPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "confirmation", password);
		
		log.info("RegisterToSystem: Step 12 - Click to Register button");
		registerPage.clickToDynamicLiveGuruButton(driver, "Register");
		
		log.info("RegisterToSystem: Step 13 - Click to Register button");
		verifyTrue(registerPage.isRegisterSuccessMessageDisplayed());
	}
	
	@Test
	public void TC_02_VerifyUserInformation() {
		
		log.info("VerifyUserInformation: Step 01 - open Home Page");
		registerPage.openAnyUrl(driver, HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("VerifyUserInformation: Step 02 - Click to Account Menu");
		homePage.clickToAccountMenu(driver);
		
		log.info("VerifyUserInformation: Step 03 - Click to My Account link");
		homePage.clickToDynamicLink(driver,"My Account");
		myAccountPage = LiveGuruPageFactoryManager.getMyAccountPage(driver);		
		
		log.info("VerifyUserInformation: Step 04 - Get Text Infor box");
		inforBox =  myAccountPage.getTextInforBox(driver);
		
		log.info("VerifyUserInformation: Step 05 - verify infor box displayed correct full name and email");		
		verifyTrue(inforBox.contains(fullName) && inforBox.contains(email));
		
		log.info("VerifyUserInformation: Step 06 - Verify My Dasboard page displayed");
		verifyTrue(myAccountPage.isDynamicLiveGuruPageTitleDisplayed(driver, "My Dashboard"));
		
		log.info("VerifyUserInformation: Step 07 - click to ACCOUNT INFORMATION link");
		myAccountPage.clickToDynamicMyAccountLink(driver,"Account Information");
		
		log.info("VerifyUserInformation: Step 08 - Verify First Name is correct");
		verifyTrue(myAccountPage.isDynamicInforInTextboxCorrect(driver, "firstname", firstName));
		
		log.info("VerifyUserInformation: Step 09 - Verify Middle Name is correct");
		verifyTrue(myAccountPage.isDynamicInforInTextboxCorrect(driver, "middlename", middleName));
		
		log.info("VerifyUserInformation: Step 10 - Verify Last Name is correct");
		verifyTrue(myAccountPage.isDynamicInforInTextboxCorrect(driver, "lastname", lastName));
		
		log.info("VerifyUserInformation: Step 11 - Verify Email is correct");
		verifyTrue(myAccountPage.isDynamicInforInTextboxCorrect(driver, "email", email));
	}
	
	@Test
	public void TC_03_VerifyCostProduct() {
		log.info("VeifyCostProduct: Step 01 - open Home Page");
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("CompareProducts: Step 02 - Click to 'MOBILE' link and verify MOBILE page displayed");
		homePage.clickToDynamicLink(driver,"Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, "Mobile");
		
		log.info("VeifyCostProduct: Step 03 - Get Cost of Sony Xperia in list page");
		listCost = mobilePage.getCostDynamicProductInMobileListPage(driver, "Sony Xperia");
		
		log.info("VeifyCostProduct: Step 04 - Click to Sony Xperia details");
		mobilePage.clickToDynamicProductLink(driver, "Sony Xperia");
		
		log.info("VeifyCostProduct: Step 05 - Get Cost of Sony Xperia in details page");
		detailsCost = mobilePage.getCostDynamicProductInMobileDetailsPage(driver, "Sony Xperia");
		
		log.info("VeifyCostProduct: Step 06 - Verify cost of product in list page and details page are equal");
		verifyEquals(listCost, detailsCost);
		
	}
	
	@Test
	public void TC_04_VerifyDiscountCuponWorksCorrectly() {
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 01 - open Home Page");
		mobilePage.openAnyUrl(driver, HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("CompareProducts: Step 02 - Click to 'MOBILE' link and verify MOBILE page displayed");
		homePage.clickToDynamicLink(driver,"Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, "Mobile");
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 03 - Click Add to Cart IPhone");
		mobilePage.clickToDynamicAddToCartButton(driver, "IPhone");
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 04 - Verify 'SHOPPING CART' message displayed");
		verifyTrue(mobilePage.isShoppingCartMessageDisplayed(driver));
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 05 - Input Cupon code to 'DISCOUNT CODES' textbox");
		mobilePage.inputToDynamicTextboxTextAreaLiveGuru(driver, "coupon_code", cuponCode);
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 06 - Click APPLY button");
		mobilePage.clickToDynamicLiveGuruButton(driver, "Apply");
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 07 - Verify Correct Discount title displayed");
		verifyTrue(mobilePage.isDiscountTitleDisplayed(driver, cuponCode)); 
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 08 - Verify Correct Discount money appears");
		verifyEquals(mobilePage.getTextDiscountMoney(driver, cuponCode), discountMoney);
			
		log.info("VerifyDiscountCuponWorksCorrectly: Step 09 - Verify Grand Total are correct after discounting");
		verifyEquals(mobilePage.getTextGrandTotalMoney(driver), grantTotal);
		
	}
	
	@Test
	public void TC_05_CanNotAddMoreThan500Items() {
		
		log.info("CanNotAddMoreThan500Items: Step 01 - open Home Page");
		mobilePage.openAnyUrl(driver, HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("CompareProducts: Step 02 - Click to 'MOBILE' link and verify MOBILE page displayed");
		homePage.clickToDynamicLink(driver,"Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, "Mobile");
		
		log.info("CanNotAddMoreThan500Items: Step 03 - Click Add to Cart IPhone");
		mobilePage.clickToDynamicAddToCartButton(driver, "Sony Xperia");
		
		log.info("CanNotAddMoreThan500Items: Step 04 - Verify 'SHOPPING CART' message displayed");
		verifyTrue(mobilePage.isShoppingCartMessageDisplayed(driver));
		
		log.info("CanNotAddMoreThan500Items: Step 05 - Clear QTY textbox of Sony Xperia");
		mobilePage.clearDynamicQTYTextbox(driver, "Sony Xperia");
		
		log.info("CanNotAddMoreThan500Items: Step 06 - Input To QTY textbox of Sony Xperia");
		mobilePage.inputToDynamicQTYTextbox(driver, "Sony Xperia", productQuantity);
		
		log.info("CanNotAddMoreThan500Items: Step 07 - Click To UPDATE button of Sony Xperia");
		mobilePage.clickToDynamiUpdateButton(driver, "Sony Xperia");
		
		log.info("CanNotAddMoreThan500Items: Step 08 - Get text error message of Sony Xperia");
		errorMessage = mobilePage.getTextDynamicErrorMessage(driver, "Sony Xperia");
		
		log.info("CanNotAddMoreThan500Items: Step 09 - Verify '* The maximum quantity allowed for purchase is 500.' message of Sony Xperia displayed");
		verifyEquals(errorMessage.trim(), "* The maximum quantity allowed for purchase is 500.");
		
	}
	
	@Test 
	public void TC_06_CompareProducts() {
		
		log.info("CompareProducts: Step 01 - open Home Page");
		mobilePage.openAnyUrl(driver, HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("CompareProducts: Step 02 - Click to 'MOBILE' link and verify MOBILE page displayed");
		homePage.clickToDynamicLink(driver,"Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, "Mobile");
		
		log.info("CompareProducts: Step 03 - Add Sony Xepria to Compare list");
		mobilePage.clickToAddToCompareLinkOfDynamicProduct(driver, "Sony Xperia");
		
		log.info("CompareProducts: Step 04 - Add IPhone to Compare list");
		mobilePage.clickToAddToCompareLinkOfDynamicProduct(driver, "IPhone");
		
		log.info("CompareProducts: Step 05 - Get Parent window");
		String parentID = mobilePage.getParentWindowID(driver);
		
		log.info("CompareProducts: Step 06 - Click to Compare Button");
		mobilePage.clickToDynamicLiveGuruButton(driver, "Compare");
		
		log.info("CompareProducts: Step 07 - Switch to COMPARE PRODUCT window");
		mobilePage.swithToChildWindowByTitle(driver, "Products Comparison List - Magento Commerce");
		
		log.info("CompareProducts: Step 08 - Verify COMPARE PRODUCT text title displayed");
		verifyTrue(mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, "Compare Products"));
		
		log.info("CompareProducts: Step 09 - Verify that Sony Xparia displays in COMPARE PRODUCT window");
		verifyTrue(mobilePage.isDynamicProductLinkDisplayed(driver, "Sony Xperia"));
		
		log.info("CompareProducts: Step 10 - Verify that IPhone displays in COMPARE PRODUCT window");
		verifyTrue(mobilePage.isDynamicProductLinkDisplayed(driver, "IPhone"));
		
		log.info("CompareProducts: Step 11 - Close COMPARE PRODUCT window ");
		mobilePage.closeAllExceptParentWindow(driver, parentID);
		
	}
	
	@Test
	public void TC_07_SharingWishlist() {
		
		log.info("SharingWishlist: Step 01 - open Home Page");
		mobilePage.openAnyUrl(driver, HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("SharingWishlist: Step 02 - Click to 'TV' link and verify TV page displayed");
		homePage.clickToDynamicLink(driver,"TV");
		TVPage = LiveGuruPageFactoryManager.getTVPage(driver);
		mobilePage.isDynamicLiveGuruPageTitleDisplayed(driver, "TV");
		
		log.info("SharingWishlist: Step 03 - Click to 'Add to Wishlist' of LG LCD");
		TVPage.clickToAddToWishlistLinkOfDynamicProduct(driver, "LG LCD");
		
		log.info("SharingWishlist: Step 04 - verify message 'LG LCD has been added to your wishlist. Click here to continue shopping.' displayed");
		TVPage.isDynamicProductAddedToWishListMessageDisplayed(driver, "LG LCD");
		
		log.info("SharingWishlist: Step 05 - Click to 'SHARE WISHLIST' button");
		TVPage.clickToDynamicLiveGuruButton(driver, "Share Wishlist");
		
		log.info("SharingWishlist: Step 06 - Verify 'SHARE YOUR WISHLIST' page displayed");
		TVPage.isDynamicLiveGuruPageTitleDisplayed(driver, "Share Your Wishlist");
		
		log.info("SharingWishlist: Step 07 - Input to Email and Message text areas");
		TVPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "emails", "mic123@gmail.com");
		TVPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "message", "My sharing");
		
		log.info("SharingWishlist: Step 08 - Click to 'SHARE WIHSLIST' button");
		TVPage.clickToDynamicLiveGuruButton(driver, "Share Wishlist");
		
		log.info("SharingWishlist: Step 09 - Verify 'Your wishlist has been share'");
		verifyTrue(TVPage.isYourWishListHasBeenSharedMessageDisplayed(driver));
		
		log.info("SharingWishlist: Step 10 - Verify there's 1 item LG LCD in 'MY WISHLIST' page");
		verifyTrue(TVPage.isCorrectNumberItemOfDynamicProductDisplayed(driver, "LG LCD", "1"));
		
	}
	
	
	
	
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
