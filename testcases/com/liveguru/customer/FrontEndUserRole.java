package com.liveguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import liveguruPageFactoryManager.LiveGuruPageFactoryManager;
import liveguruPageObjects.HomePageObject;
import liveguruPageObjects.MyAccountPageObject;
import liveguruPageObjects.RegisterPageObject;

public class FrontEndUserRole extends AbstractTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private MyAccountPageObject myAccountPage;
	
	private String  firstName = "Hai";
	private String  middleName = "Phuoc";
	private String  lastName = "Tran";
	private String  fullName = firstName +" " + middleName + " " + lastName;
	private String email = "haitp" + randomNumber() + "@gmail.com";
	private String password = "123654";
	public static String HOME_PAGE_URL;
	private String inforBox;
	
	@Parameters({"browser","url"})
	@BeforeTest
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
		registerPage.inputToDynamicTextboxLiveGuru(driver, "firstname", firstName);
		
		log.info("RegisterToSystem: Step 07 - Input to Middle Name textbox");
		registerPage.inputToDynamicTextboxLiveGuru(driver, "middlename", middleName);
		
		log.info("RegisterToSystem: Step 08 - Input to Last Name textbox");
		registerPage.inputToDynamicTextboxLiveGuru(driver, "lastname", lastName);
		
		log.info("RegisterToSystem: Step 09 - Input to Email textbox");
		registerPage.inputToDynamicTextboxLiveGuru(driver, "email", email);
		
		log.info("RegisterToSystem: Step 10 - Input to First Name textbox");
		registerPage.inputToDynamicTextboxLiveGuru(driver, "password", password);
		
		log.info("RegisterToSystem: Step 11 - Input to First Name textbox");
		registerPage.inputToDynamicTextboxLiveGuru(driver, "confirmation", password);
		
		log.info("RegisterToSystem: Step 12 - Click to Register button");
		registerPage.clickToDynamicLiveGuruButton(driver, "Register");
		
		log.info("RegisterToSystem: Step 13 - Click to Register button");
		verifyTrue(registerPage.isRegisterSuccessMessageDisplayed());
	}
	
	@Test
	public void TC_02_VerifyUserInformation() {
		
		log.info("VerifyUserInformation: Step 01 - open Home Page");
		registerPage.openAnyUrl(driver, FrontEndUserRole.HOME_PAGE_URL);
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
		
		log.info("VerifyUserInformation: Step 06 - Verify My Dasboard text displayed");
		verifyTrue(myAccountPage.isMyDashBoardTextDisplayed());
		
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
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
