package com.liveguru.order;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.customer.FrontEndUserRole;

import commons.AbstractTest;
import liveguruPageFactoryManager.LiveGuruPageFactoryManager;
import liveguruPageObjects.HomePageObject;
import liveguruPageObjects.MobilePageObject;

public class OrderFunction extends AbstractTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private MobilePageObject mobilePage;
	private String listCost, detailsCost, errorMessage;
	private String cuponCode = "GURU50";
	private String discountMoney = "-$25.00";
	private String grantTotal = "$500.00";
	private String productQuantity = "501";
	/* NOTE: Discount Function is facing with a bug that discount money is not deducted in Grand Total */
	
	@Parameters({"browser","url"})
	@BeforeTest
	public void BeforeTest(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);
		
	}
	
	@Test
	public void TC_01_VerifyCostProduct() {
		log.info("VeifyCostProduct: Step 01 - open Home Page");
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("VeifyCostProduct: Step 02 - Click to 'MOBILE' link");
		homePage.clickToDynamicLink(driver,"Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		
		log.info("VeifyCostProduct: Step 03 - Get Cost of Sony Xperia in list page");
		listCost = mobilePage.getCostDynamicProductInMobileListPage("Sony Xperia");
		
		log.info("VeifyCostProduct: Step 04 - Click to Sony Xperia details");
		mobilePage.clickToDynamicProductLink("Sony Xperia");
		
		log.info("VeifyCostProduct: Step 05 - Get Cost of Sony Xperia in details page");
		detailsCost = mobilePage.getCostDynamicProductInMobileDetailsPage("Sony Xperia");
		
		log.info("VeifyCostProduct: Step 06 - Verify cost of product in list page and details page are equal");
		verifyEquals(listCost, detailsCost);
		
	}
	
	@Test
	public void TC_02_VerifyDiscountCuponWorksCorrectly() {
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 01 - open Home Page");
		mobilePage.openAnyUrl(driver, FrontEndUserRole.HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 02 - Click to 'MOBILE' link");
		homePage.clickToDynamicLink(driver,"Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 03 - Click Add to Cart IPhone");
		mobilePage.clickToDynamicAddToCartButton("IPhone");
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 04 - Verify 'SHOPPING CART' message displayed");
		verifyTrue(mobilePage.isShoppingCartMessageDisplayed());
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 05 - Input Cupon code to 'DISCOUNT CODES' textbox");
		mobilePage.inputToDynamicTextboxLiveGuru(driver, "coupon_code", cuponCode);
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 06 - Click APPLY button");
		mobilePage.clickToDynamicLiveGuruButton(driver, "Apply");
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 07 - Verify Correct Discount title displayed");
		verifyTrue(mobilePage.isDiscountTitleDisplayed(cuponCode)); 
		
		log.info("VerifyDiscountCuponWorksCorrectly: Step 08 - Verify Correct Discount money appears");
		verifyEquals(mobilePage.getTextDiscountMoney(cuponCode), discountMoney);
			
		log.info("VerifyDiscountCuponWorksCorrectly: Step 09 - Verify Grand Total are correct after discounting");
		verifyEquals(mobilePage.getTextGrandTotalMoney(), grantTotal);
		
	}
	
	@Test
	public void TC_03_CanNotAddMoreThan500Items() {
		
		log.info("CanNotAddMoreThan500Items: Step 01 - open Home Page");
		mobilePage.openAnyUrl(driver, FrontEndUserRole.HOME_PAGE_URL);
		homePage = LiveGuruPageFactoryManager.getHomePage(driver);
		
		log.info("CanNotAddMoreThan500Items: Step 02 - Click to 'MOBILE' link");
		homePage.clickToDynamicLink(driver,"Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		
		log.info("CanNotAddMoreThan500Items: Step 03 - Click Add to Cart IPhone");
		mobilePage.clickToDynamicAddToCartButton("Sony Xperia");
		
		log.info("CanNotAddMoreThan500Items: Step 04 - Verify 'SHOPPING CART' message displayed");
		verifyTrue(mobilePage.isShoppingCartMessageDisplayed());
		
		log.info("CanNotAddMoreThan500Items: Step 05 - Clear QTY textbox of Sony Xperia");
		mobilePage.clearDynamicQTYTextbox("Sony Xperia");
		
		log.info("CanNotAddMoreThan500Items: Step 06 - Input To QTY textbox of Sony Xperia");
		mobilePage.inputToDynamicQTYTextbox("Sony Xperia", productQuantity);
		
		log.info("CanNotAddMoreThan500Items: Step 07 - Click To UPDATE button of Sony Xperia");
		mobilePage.clickToDynamiUpdateButton("Sony Xperia");
		
		log.info("CanNotAddMoreThan500Items: Step 08 - Get text error message of Sony Xperia");
		errorMessage = mobilePage.getTextDynamicErrorMessage("Sony Xperia");
		
		log.info("CanNotAddMoreThan500Items: Step 09 - Verify '* The maximum quantity allowed for purchase is 500.' message of Sony Xperia displayed");
		verifyEquals(errorMessage.trim(), "* The maximum quantity allowed for purchase is 500.");
		
		
	}
	
	
	
	
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
