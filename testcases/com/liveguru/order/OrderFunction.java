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
import liveguruPageObjects.MyAccountPageObject;

public class OrderFunction extends AbstractTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private MyAccountPageObject myAccountPage;
	private MobilePageObject mobilePage;
	private String listCost, detailsCost;
	
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
		homePage = mobilePage.openHomePage(driver, FrontEndUserRole.HOME_PAGE_URL);
		
		log.info("VeifyCostProduct: Step 02 - Click to 'MOBILE' link");
		homePage.clickToDynamicLink(driver,"Mobile");
		mobilePage = LiveGuruPageFactoryManager.getMobilePage(driver);
		
		log.info("VeifyCostProduct: Step 03 - Click Add to Cart IPhone");
		mobilePage.clickToDynamicAddToCartButton("IPhone");
		
		log.info("VeifyCostProduct: Step 04 - Verify 'SHOPPING CART' message displayed");
		mobilePage.isShoppingCartMessageDisplayed();
		
	}
	
	
	
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
