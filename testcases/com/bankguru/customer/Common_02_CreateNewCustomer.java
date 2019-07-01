package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.bankguru.common.CommonTestData;
import com.bankguru.payment.PaymentTestData;
import com.bankguru.user.Common_01_RegisterToSystem;

import bankguruPageFactoryManager.PageFactoryManager;
import bankguruPageObjects.HomePageObject;
import bankguruPageObjects.LoginPageObject;
import bankguruPageObjects.NewCustomerPageObject;
import commons.AbstractTest;

public class Common_02_CreateNewCustomer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	public static String CUSTOMER_ID;
	private String email = CommonTestData.EMAIL + randomNumber() + "@gmail.com";


	@Parameters({"browser","url"})
	@BeforeTest
	public void beforeClass(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);

		log.info("CreateNewCustomer: Step 01 - Open Login Page");
		loginPage = PageFactoryManager.getLoginPage(driver);
		
		log.info("CreateNewCustomer: Step 02 - Verify Login Form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());
		
		log.info("CreateNewCustomer: Step 03 - Input to userID and 'Password' textboxes");
		loginPage.inputToDynamicTextboxOrTextArea(driver, "uid", Common_01_RegisterToSystem.USER_ID_INFOR);
		loginPage.inputToDynamicTextboxOrTextArea(driver, "password", Common_01_RegisterToSystem.PASSWORD_INFOR);
		
		log.info("CreateNewCustomer: Step 04 - Click to Login button to move to HomePage Url");
		loginPage.clickToDynamicButton(driver, "btnLogin");
		homePage = PageFactoryManager.getHomePage(driver);
		
		log.info("CreateNewCustomer: Step 05 - Verify Welcome message of Home page displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed());
		
		log.info("CreateNewCustomer: Step 06 - Verify User ID infor displayed");
		verifyTrue(homePage.isUserIDDisplayed(Common_01_RegisterToSystem.USER_ID_INFOR));
		
		log.info("CreateNewCustomer: Step 07 - Click to 'New Customer' link");
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

		log.info("CreateNewCustomer: Step 08 - Input to 'Customer Name' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "name", CommonTestData.VALID_NAME);
		
		log.info("CreateNewCustomer: Step 09 - Select Male gender");
		newCustomerPage.checkToDynamicCheckboxOrRadioButton(driver, "m");
		
		log.info("CreateNewCustomer: Step 10 - Remove 'type' attribute of Date of Birth textbox");
		newCustomerPage.removeAnyAtrributeOfDynamicTextbox(driver, "dob", "type");
		
		log.info("CreateNewCustomer: Step 11 - Input to 'Date Of Birth' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "dob", CommonTestData.VALID_DOB);
		
		log.info("CreateNewCustomer: Step 12 - Input to 'Adress' text area");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", CommonTestData.ADDRESS);
		
		log.info("CreateNewCustomer: Step 13 - Input to 'City' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", CommonTestData.CITY);
		
		log.info("CreateNewCustomer: Step 14 - Input to 'State' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", CommonTestData.STATE);
		
		log.info("CreateNewCustomer: Step 15 - Input to 'Pin' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", CommonTestData.PIN);
		
		log.info("CreateNewCustomer: Step 16 - Input to 'Mobile Number' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", CommonTestData.MOBILE_NUMBER);
		
		log.info("CreateNewCustomer: Step 17 - Input to 'Email' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", email);
		
		log.info("CreateNewCustomer: Step 18 - Input to 'Password' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "password", CommonTestData.PASSWORD);
		
		log.info("CreateNewCustomer: Step 19 - Click to 'Submit' button");
		newCustomerPage.clickToDynamicButton(driver, "sub");
		
		log.info("CreateNewCustomer: Step 20 - Verify title 'Customer Registered Successfully!!!' displayed");
		verifyTrue(newCustomerPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.CUSTOMER_REGISTERED_SUCCESSFULLY_MESSAGE));
		
		log.info("CreateNewCustomer: Step 21 - Get 'Customer ID'");
		CUSTOMER_ID = newCustomerPage.getTextDynamicTableInfo(driver, "Customer ID");

		log.info("CreateNewCustomer: Step 22 - Verify all infor of new customer are correct");
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Customer Name"), CommonTestData.VALID_NAME);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Gender"), CommonTestData.EXPECTED_GENDER);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Birthdate"), CommonTestData.VALID_DOB);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Address"), CommonTestData.ADDRESS);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "City"), CommonTestData.ADDRESS);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "State"), CommonTestData.STATE);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Pin"), CommonTestData.PIN);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Mobile No."), CommonTestData.MOBILE_NUMBER);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Email"), email);
		
		closeBrowserAndDriver(driver);
	}

}
