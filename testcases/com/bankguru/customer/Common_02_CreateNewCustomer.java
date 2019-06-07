package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.bankguru.user.Common_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;

public class Common_02_CreateNewCustomer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	public static String CUSTOMER_ID;
	public static String VALID_NAME = "Tran Phuoc Hai";
	public static String EXPECTED_GENDER = "male";
	public static String VALID_DOB = "1988-07-31";
	
	private String address = "100 Dia Chi";
	private String city = "Ha Noi";
	private String state = "Hoan Kiem";
	private String pin = "600000";
	private String mobileNumber = "0987654321";
	private String email = "haitp" + randomNumber() + "@gmail.com";
	private String password = "sdhgd3123";

	@Parameters("browser")
	@BeforeTest
	public void CreateNewCustomerSuccessfully(String browserName) {
		driver = openMultiBrowser(browserName);

		log.info("Precondition: Step 01 - Open Login Page");
		loginPage = PageFactoryManager.getLoginPage(driver);
		
		log.info("Precondition: Step 02 - Verify Login Form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());
		
		log.info("Precondition: Step 03 - Input to userID and 'Password' textboxes");
		loginPage.inputToDynamicTextboxOrTextArea(driver, "uid", Common_01_RegisterToSystem.USER_ID_INFOR);
		loginPage.inputToDynamicTextboxOrTextArea(driver, "password", Common_01_RegisterToSystem.PASSWORD_INFOR);
		
		log.info("Precondition: Step 04 - Click to Login button to move to HomePage Url");
		loginPage.clickToDynamicButton(driver, "btnLogin");
		homePage = PageFactoryManager.getHomePage(driver);
		
		log.info("Precondition: Step 05 - Verify Welcome message of Home page displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed());
		
		log.info("Precondition: Step 06 - Verify User ID infor displayed");
		verifyTrue(homePage.isUserIDDisplayed(Common_01_RegisterToSystem.USER_ID_INFOR));
		
		log.info("Precondition: Step 17 - Click to 'New Customer' link");
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

		log.info("Precondition: Step 08 - Input to 'Customer Name' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "name", VALID_NAME);
		
		log.info("Precondition: Step 09 - Select Male gender");
		newCustomerPage.checkToDynamicCheckboxOrRadioButton(driver, "m");
		
		log.info("Precondition: Step 10 - Remove 'type' attribute of Date of Birth textbox");
		newCustomerPage.removeAtrributeDynamicTextbox(driver, "dob", "type");
		
		log.info("Precondition: Step 11 - Input to 'Date Of Birth' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "dob", VALID_DOB);
		
		log.info("Precondition: Step 12 - Input to 'Adress' text area");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", address);
		
		log.info("Precondition: Step 13 - Input to 'City' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", city);
		
		log.info("Precondition: Step 14 - Input to 'State' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", state);
		
		log.info("Precondition: Step 15 - Input to 'Pin' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", pin);
		
		log.info("Precondition: Step 16 - Input to 'Mobile Number' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", mobileNumber);
		
		log.info("Precondition: Step 17 - Input to 'Email' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", email);
		
		log.info("Precondition: Step 18 - Input to 'Password' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "password", password);
		
		log.info("Precondition: Step 19 - Click to 'Submit' button");
		newCustomerPage.clickToDynamicButton(driver, "sub");
		
		log.info("Precondition: Step 20 - Verify title 'Customer Registered Successfully!!!' displayed");
		verifyTrue(newCustomerPage.isDynamicPageTitleDisplayed(driver, "Customer Registered Successfully!!!"));
		
		log.info("Precondition: Step 21 - Get 'Customer ID'");
		CUSTOMER_ID = newCustomerPage.getTextDynamicTableInfo(driver, "Customer ID");

		log.info("Precondition: Step 22 - Verify all infor of new customer are correct");
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Customer Name"), VALID_NAME);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Gender"), EXPECTED_GENDER);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Birthdate"), VALID_DOB);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Address"), address);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "City"), city);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "State"), state);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Pin"), pin);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Mobile No."), mobileNumber);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Email"), email);
		
		closeBrowserAndDriver(driver);
	}

}
