package com.bankguru.customer;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.bankguru.user.Common_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;

public class Common_02_CreateNewCustomer extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editcustomerPage;
	public static String CUSTOMER_ID;
	
	String email = "redohabaid" + randomNumber() + "@gmail.com";
	public static String VALID_NAME = "Tran Phuoc Hai";
	public static String EXPECTED_GENDER = "male";
	public static String VALID_DOB = "1988-07-31";
	String validAdress = "100 Ho Guom";
	String validCity = "Ha Noi";
	String validState = "Hoan Kiem";
	String validPin = "600000";
	String validPhoneNumber = "0987654321";
	String validEmailID = "khain" + randomNumber() + "@gmail.com";
	String validPassword = "idonknow12345678";

	@Parameters("browser")
	@BeforeTest
	public void CreateNewCustomerSuccessfully(String browserName) {
		driver = openMultiBrowser(browserName);

		log.info("Precondition: Step 01 - Open Login Page");
		loginPage = PageFactoryManager.getLoginPage(driver);
		
		log.info("Precondition: Step 02 - Verify Login Form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());
		
		log.info("Precondition: Step 03 - Input to userID and 'Password' textboxes");
		loginPage.inPutToUserIDTextbox(Common_01_RegisterToSystem.USER_ID_INFOR);
		loginPage.inPutToPasswordTextbox(Common_01_RegisterToSystem.PASSWORD_INFOR);
		
		log.info("Precondition: Step 04 - Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Precondition: Step 05 - Verify Welcome message of Home page displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed());
		
		log.info("Precondition: Step 06 - Verify User ID infor displayed");
		verifyTrue(homePage.isUserIDDisplayed(Common_01_RegisterToSystem.USER_ID_INFOR));
		
		log.info("Precondition: Step 17 - Click to 'New Customer' link");
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

		log.info("Precondition: Step 08 - Input to 'Customer Name' textbox");
		newCustomerPage.inputValueToCustomerNameTextbox(VALID_NAME);
		
		log.info("Precondition: Step 09 - Select Male gender");
		newCustomerPage.selectMaleGenderRadioButton();
		
		log.info("Precondition: Step 10 - Remove Date Of Birth attribute");
		newCustomerPage.removeDateOfBirthAttribute();
		
		log.info("Precondition: Step 11 - Input to 'Date Of Birth' textbox");
		newCustomerPage.inputValueToDateOfBirthTextbox(VALID_DOB);
		
		log.info("Precondition: Step 12 - Input to 'Adress' text area");
		newCustomerPage.inputValueToAdressTextArea(validAdress);
		
		log.info("Precondition: Step 13 - Input to 'City' textbox");
		newCustomerPage.inputValueToCityTextbox(validCity);
		
		log.info("Precondition: Step 14 - Input to 'State' textbox");
		newCustomerPage.inputValueToStateTextbox(validState);
		
		log.info("Precondition: Step 15 - Input to 'Pin' textbox");
		newCustomerPage.inputValueToPinTextbox(validPin);
		
		log.info("Precondition: Step 16 - Input to 'Mobile Number' textbox");
		newCustomerPage.inputValueToMobileNumberTextbox(validPhoneNumber);
		
		log.info("Precondition: Step 17 - Input to 'Email' textbox");
		newCustomerPage.inputValueToEmailTextbox(validEmailID);
		
		log.info("Precondition: Step 18 - Input to 'Password' textbox");
		newCustomerPage.inputValueToPasswordTextbox(validPassword);
		
		log.info("Precondition: Step 19 - Click to Submit button");
		newCustomerPage.clickToSubmitButton();
		
		log.info("Precondition: Step 20 - Verify 'Customer Registered Successfully!!!' message displayed");
		verifyTrue(newCustomerPage.isCustomerRegisteredSuccessfullyDisplayed());
		
		log.info("Precondition: Step 21 - Get 'Customer ID'");
		CUSTOMER_ID = newCustomerPage.getTextDynamicInfo(driver, "Customer ID");

		log.info("Precondition: Step 22 - Verify all infor of new customer are correct");
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Customer Name"), VALID_NAME);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Gender"), EXPECTED_GENDER);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Birthdate"), VALID_DOB);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Address"), validAdress);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "City"), validCity);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "State"), validState);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Pin"), validPin);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Mobile No."), validPhoneNumber);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Email"), validEmailID);
		
		closeBrowserAndDriver(driver);
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
