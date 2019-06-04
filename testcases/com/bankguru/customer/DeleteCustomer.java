package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.user.Common_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class DeleteCustomer extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	DeleteCustomerPageObject deleteCustomerPage;

	String blankSpace = " ";
	String[] characterValues = new String[] { "haitp", "12 1234" };
	String[] specialValues = new String[] { "097@!13546", "!#123654", "0987654#@!" };

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
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

		log.info("Precondition: Step 07 - Click to 'Delete Customer' link");
		homePage.openMultiplePage(driver, "Delete Customer");
		deleteCustomerPage = PageFactoryManager.getDeleteCustomerPage(driver);
	}

	@Test
	public void DC_01_CustomerIDCanNotBeEmpty() {

		log.info("CustomerIDCanNotBeEmpty: Step 01 - Clear 'Customer ID' textbox");
		deleteCustomerPage.clearCustomerIDTextbox();

		log.info("CustomerIDCanNotBeEmpty: Step 02 - Click to 'Customer ID' textbox");
		deleteCustomerPage.clickToCustomerIDTexbox();

		log.info("CustomerIDCanNotBeEmpty: Step 03 - Press TAB key");
		deleteCustomerPage.pressTABKeyToCustomerIDTextbox();

		log.info("CustomerIDCanNotBeEmpty: Step 04 - Verify 'Customer ID is required' message displayed");
		verifyTrue(deleteCustomerPage.isCustomerIDIsRequiredMessageDisplayed());

	}

	@Test
	public void DC_02_CustomerIDCanNotHaveFirstBlankSpace() {

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 01 - Clear 'Customer ID' textbox");
		deleteCustomerPage.clearCustomerIDTextbox();

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 02 - Input to 'Customer ID' textbox");
		deleteCustomerPage.inputValueToCustomerIDTextbox(blankSpace);

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyTrue(deleteCustomerPage.isDynamicFirstCharacterCanNotHaveSpaceMessageDisplayed(driver, "Customer ID"));

	}

	@Test
	public void DC_03_CustomerIDCharacterAreNotAllowed() {
		for (String charactervalue : characterValues) {

			log.info("CustomerIDCharacterAreNotAllowed: Step 01 - Customer ID Number textbox");
			deleteCustomerPage.clearCustomerIDTextbox();

			log.info("CustomerIDCharacterAreNotAllowed: Step 02 - Input to 'Customer ID' textbox");
			deleteCustomerPage.inputValueToCustomerIDTextbox(charactervalue);

			log.info("CustomerIDCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyTrue(deleteCustomerPage.isDynamicCharactersAreNotAllowMessageDisplayed(driver, "Customer ID"));
		}

	}

	@Test
	public void DC_04_CustomerIDCanNotHaveSpecialCharacters() {
		for (String specialValue : specialValues) {

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 01 - Customer ID Number textbox");
			deleteCustomerPage.clearCustomerIDTextbox();

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 02 - Input to 'Customer ID' textbox");
			deleteCustomerPage.inputValueToCustomerIDTextbox(specialValue);

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyTrue(deleteCustomerPage.isDynamicSpecialCharactersAreNotAllowedMessageDisplayed(driver, "Customer ID"));
		}
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
