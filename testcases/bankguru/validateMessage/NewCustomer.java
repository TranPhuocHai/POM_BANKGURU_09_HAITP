package bankguru.validateMessage;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageFactoryManager.PageFactoryManager;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.NewCustomerPageObject;
import bankguru.commonFunction.Common_01_RegisterToSystem;
import bankguru.testdata.CommonTestData;
import bankguru.testdata.ValidateMessage;
import commons.AbstractTest;
import reportConfig.ExtentTestManager;

public class NewCustomer extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;

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

		log.info("Precondition: Step 07 - Click to New Customer link");
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);
	}

	@Test
	public void NewCustomer_01_NameCanNotBeEmpty(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_01: Step 01 - Click to 'Customer Name' textbox");
		newCustomerPage.clickToDynamicTextboxOrTextArea(driver, "name");

		log.info("NewCustomer_01: Step 02 - Press TAB key");
		newCustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "name");

		log.info("NewCustomer_01: Step 03 - Verify 'Customer name must not be blank' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "Customer Name"), ValidateMessage.CUSTOMER_NAME_MUST_NOT_BE_BLANK);
	}

	@Test
	public void NewCustomer_02_NameCanNotBeNumberic(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String numericName : CommonTestData.NUMERIC_VALUES) {

			log.info("NewCustomer_02: Step 01 - Clear 'Customer Name' textbox");
			newCustomerPage.clearDynamicTextboxOrTextArea(driver, "name");

			log.info("NewCustomer_02: Step 02 - Input to 'Customer Name' textbox");
			newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "name", numericName);

			log.info("NewCustomer_02: Step 03 - Verify 'Numbers are not allowed' message displayed");
			verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "Customer Name"), ValidateMessage.NUMBERS_ARE_NOT_ALLOWED);

		}
	}

	@Test
	public void NewCustomer_03_NameCanNotHaveSpecialCharacters(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String specialCharactersName : CommonTestData.SPECIAL_VALUE) {

			log.info("NewCustomer_03: Step 01 - Clear 'Customer Name' textbox");
			newCustomerPage.clearDynamicTextboxOrTextArea(driver, "name");

			log.info("NewCustomer_03: Step 02 - Input to 'Customer Name' textbox");
			newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "name", specialCharactersName);

			log.info("NewCustomer_03: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "Customer Name"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void NewCustomer_04_NameCanNotHaveFirstBlankSpace(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_04: Step 01 - Clear 'Customer Name' textbox");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "name");

		log.info("NewCustomer_04: Step 02 - Input to 'Customer Name' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "name", CommonTestData.BLANK_SPACE);

		log.info("NewCustomer_04: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "Customer Name"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void NewCustomer_05_AddressCanNotBeEmpty(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_05: Step 01 - Clear 'Address' text area");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");

		log.info("NewCustomer_05: Step 02 - Click to 'Address' text area");
		newCustomerPage.clickToDynamicTextboxOrTextArea(driver, "addr");

		log.info("NewCustomer_05: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "addr");

		log.info("NewCustomer_05: Step 04 - Verify 'Address Field must not be blank' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "Address"), ValidateMessage.ADDRESS_FIELD_MUST_NOT_BE_BLANK);

	}

	@Test
	public void NewCustomer_06_AdressCanNotHaveSpecialCharacters(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String specialCharactersAddress : CommonTestData.SPECIAL_VALUE) {

			log.info("NewCustomer_06: Step 01 - Clear 'Address' text area");
			newCustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");

			log.info("NewCustomer_06: Step 02 - Input to 'Address' text area");
			newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", specialCharactersAddress);

			log.info("NewCustomer_06: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "Address"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void NewCustomer_07_AddressCanNotHaveBlankSpace(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_07: Step 01 - Clear 'Address' text area");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");

		log.info("NewCustomer_07: Step 02 - Input to 'Address' text area");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", CommonTestData.BLANK_SPACE);

		log.info("NewCustomer_07: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "Address"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void NewCustomer_08_CityCanNotBeEmpty(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_08: Step 01 - Clear 'City' textbox");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "city");

		log.info("NewCustomer_08: Step 02 - Click to 'City' textbox");
		newCustomerPage.clickToDynamicTextboxOrTextArea(driver, "city");

		log.info("NewCustomer_08: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "city");

		log.info("NewCustomer_08: Step 04 - Verify 'City Field must not be blank' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "City"), ValidateMessage.CITY_FIELD_MUST_NOT_BE_BLANK);
	}

	@Test
	public void NewCustomer_09_CityCanNotBeNumberic(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String numericCity : CommonTestData.NUMERIC_VALUES) {

			log.info("NewCustomer_09: Step 01 - Clear 'City' textbox");
			newCustomerPage.clearDynamicTextboxOrTextArea(driver, "city");

			log.info("NewCustomer_09: Step 02 - Input to 'City' textbox");
			newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", numericCity);

			log.info("NewCustomer_09: Step 03 - Verify 'Numbers are not allowed' message displayed");
			verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "City"), ValidateMessage.NUMBERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void NewCustomer_10_CityCanNotHaveSpecialCharacters(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String specialCharactersCity : CommonTestData.SPECIAL_VALUE) {

			log.info("NewCustomer_10: Step 01 - Clear 'City' textbox");
			newCustomerPage.clearDynamicTextboxOrTextArea(driver, "city");

			log.info("NewCustomer_10: Step 02 - Input to 'City' textbox");
			newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", specialCharactersCity);

			log.info("NewCustomer_10: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "City"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void NewCustomer_11_CityCanNotHaveFirstBlankSpace(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_11: Step 01 - Clear 'City' textbox");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "city");

		log.info("NewCustomer_11: Step 02 - Input to 'City' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", CommonTestData.BLANK_SPACE);

		log.info("NewCustomer_11: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "City"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void NewCustomer_12_StateCanNotBeEmpty(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_12: Step 01 - Clear 'State' textbox");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "state");

		log.info("NewCustomer_12: Step 02 - Click to 'State' textbox");
		newCustomerPage.clickToDynamicTextboxOrTextArea(driver, "state");

		log.info("NewCustomer_12: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "state");

		log.info("NewCustomer_12: Step 04 - Verify 'State must not be blank' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "State"), ValidateMessage.STATE_MUST_NOT_BE_BLANK);
	}

	@Test
	public void NewCustomer_13_StateCanNotBeNumberic(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String numericState : CommonTestData.NUMERIC_VALUES) {

			log.info("NewCustomer_13: Step 01 - Clear 'State' textbox");
			newCustomerPage.clearDynamicTextboxOrTextArea(driver, "state");

			log.info("NewCustomer_13: Step 02 - Input to 'State' textbox");
			newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", numericState);

			log.info("NewCustomer_13: Step 03 - Verify 'Numbers are not allowed' message displayed");
			verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "State"), ValidateMessage.NUMBERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void NewCustomer_14_StateCanNotHaveSpecialCharacters(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String specialCharactersState : CommonTestData.SPECIAL_VALUE) {

			log.info("NewCustomer_14: Step 01 - Clear 'State' textbox");
			newCustomerPage.clearDynamicTextboxOrTextArea(driver, "state");

			log.info("NewCustomer_14: Step 02 - Input to 'State' textbox");
			newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", specialCharactersState);

			log.info("NewCustomer_14: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "State"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void NewCustomer_15_StateCanNotHaveFirstBlankSpace(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_15: Step 01 - Clear 'State' textbox");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "state");

		log.info("NewCustomer_15: Step 02 - Input to 'State' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", CommonTestData.BLANK_SPACE);

		log.info("NewCustomer_15: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "State"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void NewCustomer_16_PinCanNotBeEmpty(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_16: Step 01 - Clear 'PIN' textbox");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");
		
		log.info("NewCustomer_16: Step 02 - Click to 'PIN' textbox");
		newCustomerPage.clickToDynamicTextboxOrTextArea(driver, "pinno");
		
		log.info("NewCustomer_16: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "pinno");
		
		log.info("NewCustomer_16: Step 04 - Verify 'PIN Code must not be blank' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "PIN"), ValidateMessage.PIN_CODE_MUST_NOT_BE_BLANK);
	}

	@Test
	public void NewCustomer_17_PinMustBeNumeric(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String characterPIN : CommonTestData.CHARACTER_PIN_VALUE) {

			log.info("NewCustomer_17: Step 01 - Clear 'PIN' textbox");
			newCustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");
			
			log.info("NewCustomer_17: Step 02 - Input to 'PIN' textbox");
			newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", characterPIN);
			
			log.info("NewCustomer_17: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "PIN"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void NewCustomer_18_PinMustHave6Degits(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String lessThan6Digits : CommonTestData.LESS_THAN_6_DIGITS_PIN_VALUE) {

			log.info("NewCustomer_18: Step 01 - Clear 'PIN' textbox");
			newCustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");
			
			log.info("NewCustomer_18: Step 02 - Input to 'PIN' textbox");
			newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", lessThan6Digits);
			
			log.info("NewCustomer_18: Step 03 - Verify 'PIN Code must have 6 Digits' message displayed");
			verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "PIN"), ValidateMessage.PIN_CODE_MUST_HAVE_6_DIGITS);
		}
	}

	@Test
	public void NewCustomer_19_PinCanNotHaveFirstBlankSpace(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_19: Step 01 - Clear 'PIN' textbox");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");
		
		log.info("NewCustomer_19: Step 02 - Input to 'PIN' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", CommonTestData.BLANK_SPACE);
		
		log.info("NewCustomer_19: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "PIN"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void NewCustomer_20_MobileNumberCanNotBeEmpty(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_20: Step 01 - Clear 'Mobile Number' textbox");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");
		
		log.info("NewCustomer_20: Step 02 - Click to 'Mobile Number' textbox");
		newCustomerPage.clickToDynamicTextboxOrTextArea(driver, "telephoneno");
		
		log.info("NewCustomer_20: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "telephoneno");
		
		log.info("NewCustomer_20: Step 04 - Verify 'Mobile no must not be blank' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "Mobile Number"), ValidateMessage.MOBILE_NO_MUST_NOT_BE_BLANK);
	}

	@Test
	public void NewCustomer_21_MobileNumberCanNotHaveFirstBlankSpace(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_21: Step 01 - Clear 'Mobile Number' textbox");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");
		
		log.info("NewCustomer_21: Step 02 - Input to 'Mobile Number' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", CommonTestData.BLANK_SPACE);
		
		log.info("NewCustomer_21: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "Mobile Number"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void NewCustomer_22_MobileNumberCharactersAreNotAllowed(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String characterPhoneNumber : CommonTestData.CHARACTER_VALUE) {

			log.info("NewCustomer_22: Step 01 - Clear 'Mobile Number' textbox");
			newCustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");
			
			log.info("NewCustomer_22: Step 02 - Input to 'Mobile Number' textbox");
			newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", characterPhoneNumber);
			
			log.info("NewCustomer_22: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "Mobile Number"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}

	}

	@Test
	public void NewCustomer_23_MobileNumberCanNotHaveSpecialCharacters(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String specialPhoneNumber : CommonTestData.SPECIAL_VALUE) {

			log.info("NewCustomer_23: Step 01 - Clear 'Mobile Number' textbox");
			newCustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");
			
			log.info("NewCustomer_23: Step 02 - Input to 'Mobile Number' textbox");
			newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", specialPhoneNumber);
			
			log.info("NewCustomer_23: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "Mobile Number"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void NewCustomer_24_EmailCanNotBeEmpty(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_24: Step 01 - Clear 'Email' textbox");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");
		
		log.info("NewCustomer_24: Step 02 - Click to 'Email' textbox");
		newCustomerPage.clickToDynamicTextboxOrTextArea(driver, "emailid");
		
		log.info("NewCustomer_24: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "emailid");
		
		log.info("NewCustomer_24: Step 04 - Verify 'Email-ID must not be blank' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "E-mail"), ValidateMessage.EMAIL_ID_MUST_NOT_BE_BLANK);
	}

	@Test
	public void NewCustomer_25_EmailMustBeInCorrectFormat(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String incorrectEmailID : CommonTestData.INCORRECT_EMAILS) {

			log.info("NewCustomer_25: Step 01 - Clear 'Email' textbox");
			newCustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");
			
			log.info("NewCustomer_25: Step 02 - input to 'Email' textbox");
			newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", incorrectEmailID);
			
			log.info("NewCustomer_25: Step 03 - Verify 'Email-ID is not valid' message displayed");
			verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "E-mail"), ValidateMessage.EMAIL_ID_IS_NOT_VALID);
		}
	}

	@Test
	public void NewCustomer_26_EmailCanNotHaveFirstBlankSpace(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_26: Step 01 - Clear 'Email' textbox");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");
		
		log.info("NewCustomer_26: Step 02 - input to 'Email' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", CommonTestData.BLANK_SPACE);
		
		log.info("NewCustomer_26: Step 03 - Verify 'First character can not have space' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "E-mail"), ValidateMessage.FIRST_CHARACTER_CAN_NOT_HAVE_SPACE);

	}

	@Test
	public void NewCustomer_27_PasswordCanNotBeEmpty(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("NewCustomer_27: Step 01 - Clear 'Password' textbox");
		newCustomerPage.clearDynamicTextboxOrTextArea(driver, "password");

		log.info("NewCustomer_27: Step 02 - Click to 'Password' textbox");
		newCustomerPage.clickToDynamicTextboxOrTextArea(driver, "password");

		log.info("NewCustomer_27: Step 03 - Press TAB key");
		newCustomerPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "password");

		log.info("NewCustomer_27: Step 04 - Verify 'Password must not be blank' message displayed");
		verifyEquals(newCustomerPage.getTextDynamicValidateMessage(driver, "Password"), ValidateMessage.PASSWORD_MUST_NOT_BE_BLANK);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
