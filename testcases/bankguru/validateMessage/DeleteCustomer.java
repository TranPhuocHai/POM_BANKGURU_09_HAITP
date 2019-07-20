package bankguru.validateMessage;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageFactoryManager.PageFactoryManager;
import PageObjects.DeleteCustomerPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import bankguru.commonFunction.Common_01_RegisterToSystem;
import bankguru.testdata.CommonTestData;
import bankguru.testdata.ValidateMessage;
import commons.AbstractTest;
import reportConfig.ExtentTestManager;

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
	public void DeleteCustomer_01_CustomerIDCanNotBeEmpty(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("DeleteCustomer_01: Step 01 - Clear 'Customer ID' textbox");
		deleteCustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

		log.info("DeleteCustomer_01: Step 02 - Click to 'Customer ID' textbox");
		deleteCustomerPage.clickToDynamicTextboxOrTextArea(driver, "cusid");

		log.info("DeleteCustomer_01: Step 03 - Press TAB key");
		deleteCustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "cusid");

		log.info("DeleteCustomer_01: Step 04 - Verify 'Customer ID is required' message displayed");
		verifyEquals(deleteCustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessage.CUSTOMER_ID_IS_REQUIRED);

	}

	@Test
	public void DeleteCustomer_02_CustomerIDCanNotHaveFirstBlankSpace(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("DeleteCustomer_02: Step 01 - Clear 'Customer ID' textbox");
		deleteCustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

		log.info("DeleteCustomer_02: Step 02 - Input to 'Customer ID' textbox");
		deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", CommonTestData.BLANK_SPACE);

		log.info("DeleteCustomer_02: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(deleteCustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void DeleteCustomer_03_CustomerIDCharacterAreNotAllowed(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String charactervalue : CommonTestData.CHARACTER_VALUE) {

			log.info("DeleteCustomer_03: Step 01 - Customer ID Number textbox");
			deleteCustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

			log.info("DeleteCustomer_03: Step 02 - Input to 'Customer ID' textbox");
			deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", charactervalue);

			log.info("DeleteCustomer_03: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(deleteCustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}

	}

	@Test
	public void DeleteCustomer_04_CustomerIDCanNotHaveSpecialCharacters(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String specialValue : CommonTestData.SPECIAL_VALUE) {

			log.info("DeleteCustomer_04: Step 01 - Customer ID Number textbox");
			deleteCustomerPage.clearDynamicTextboxOrTextArea(driver, "cusid");

			log.info("DeleteCustomer_04: Step 02 - Input to 'Customer ID' textbox");
			deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", specialValue);

			log.info("DeleteCustomer_04: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(deleteCustomerPage.getTextDynamicValidateMessage(driver, "Customer ID"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
