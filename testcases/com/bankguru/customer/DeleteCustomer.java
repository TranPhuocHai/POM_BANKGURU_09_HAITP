package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.user.Common_01_RegisterToSystem;
import com.bankguru.validate.ValidateMessageTestData;

import bankguruPageFactoryManager.PageFactoryManager;
import bankguruPageObjects.DeleteCustomerPageObject;
import bankguruPageObjects.HomePageObject;
import bankguruPageObjects.LoginPageObject;
import commons.AbstractTest;

public class DeleteCustomer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private DeleteCustomerPageObject deleteCustomerPage;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);

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

		log.info("Precondition: Step 07 - Click to 'Delete Customer' link");
		homePage.openMultiplePage(driver, "Delete Customer");
		deleteCustomerPage = PageFactoryManager.getDeleteCustomerPage(driver);
	}

	@Test
	public void DC_01_CustomerIDCanNotBeEmpty() {

		log.info("CustomerIDCanNotBeEmpty: Step 01 - Clear 'Customer ID' textbox");
		deleteCustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotBeEmpty: Step 02 - Click to 'Customer ID' textbox");
		deleteCustomerPage.clickToDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotBeEmpty: Step 03 - Press TAB key");
		deleteCustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotBeEmpty: Step 04 - Verify 'Customer ID is required' message displayed");
		verifyEquals(deleteCustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessageTestData.CUSTOMER_ID_IS_REQUIRED);

	}

	@Test
	public void DC_02_CustomerIDCanNotHaveFirstBlankSpace() {

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 01 - Clear 'Customer ID' textbox");
		deleteCustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 02 - Input to 'Customer ID' textbox");
		deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", CustomerTestData.BLANK_SPACE);

		log.info("CustomerIDCanNotHaveFirstBlankSpace: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(deleteCustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessageTestData.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void DC_03_CustomerIDCharacterAreNotAllowed() {
		for (String charactervalue : CustomerTestData.CHARACTER_VALUE) {

			log.info("CustomerIDCharacterAreNotAllowed: Step 01 - Customer ID Number textbox");
			deleteCustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

			log.info("CustomerIDCharacterAreNotAllowed: Step 02 - Input to 'Customer ID' textbox");
			deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", charactervalue);

			log.info("CustomerIDCharacterAreNotAllowed: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(deleteCustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessageTestData.CHARACTERS_ARE_NOT_ALLOWED);
		}

	}

	@Test
	public void DC_04_CustomerIDCanNotHaveSpecialCharacters() {
		for (String specialValue : CustomerTestData.SPECIAL_VALUE) {

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 01 - Customer ID Number textbox");
			deleteCustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 02 - Input to 'Customer ID' textbox");
			deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", specialValue);

			log.info("CustomerIDCanNotHaveSpecialCharacters: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(deleteCustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessageTestData.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
