package bankguru.validateMessage;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.MiniStatementPageObject;
import bankguru.commonFunction.Common_01_RegisterToSystem;
import bankguru.testdata.CommonTestData;
import bankguru.testdata.ValidateMessage;
import commons.AbstractTest;
import commons.PageFactoryManager;
import reportConfig.ExtentTestManager;

public class MiniStatement extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private MiniStatementPageObject miniStatementPage;

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
		
		log.info("Precondition: Step 07 - Click to 'Mini Statement' link");
		homePage.openMultiplePage(driver, "Mini Statement");
		miniStatementPage = PageFactoryManager.getMiniStatementPage(driver);
		
		log.info("Precondition: Step 08 - Veify 'Mini Statement Form' title displayed");
		verifyTrue(miniStatementPage.isDynamicPageTitleOrMessageDisplayed(driver, CommonTestData.MINI_STATEMENT_TITLE));
	}

	@Test
	public void MiniStatement_01_AccountNumberCanNotBeEmpty(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("MiniStatement_01: Step 01 - Clear 'Account Number' textbox");
		miniStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");

		log.info("MiniStatement_01: Step 02 - Click to 'Account Number' textbox");
		miniStatementPage.clickToDynamicTextboxOrTextArea(driver, "accountno");

		log.info("MiniStatement_01: Step 03 - Press TAB key");
		miniStatementPage.pressTABKeyToDynamicTextboxOrTextArea(driver, "accountno");

		log.info("MiniStatement_01: Step 04 - Verify 'Account Number must not be blank' message displayed");
		verifyEquals(miniStatementPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.ACCOUNT_NUMBER_MUST_NOT_BE_BLANK);
	}

	@Test
	public void MiniStatement_02_AccountNumberCharacterAreNotAllowed(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String characterAccountNo : CommonTestData.CHARACTER_VALUE) {

			log.info("MiniStatement_02: Step 01 - Clear 'Account Number' textbox");
			miniStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");

			log.info("MiniStatement_02: Step 02 - Input to 'Account Number' textbox");
			miniStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", characterAccountNo);
			

			log.info("MiniStatement_02: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(miniStatementPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void MiniStatement_03_AccountNumberCanNotHaveSpecialCharacters(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		for (String specialAccountNo : CommonTestData.SPECIAL_VALUE) {

			log.info("MiniStatement_03: Step 01 - Clear 'Account Number' textbox");
			miniStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");
			
			log.info("MiniStatement_03: Step 02 - Input to 'Account Number' textbox");
			miniStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", specialAccountNo);
			
			log.info("MiniStatement_03: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(miniStatementPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void MiniStatement_04_AccountNumberFirstCharacterMustNotBeBlank(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("MiniStatement_04: Step 01 - Clear 'Account Number' textbox");
		miniStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("MiniStatement_04: Step 02 - Input to 'Account Number' textbox");
		miniStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", CommonTestData.BLANK_SPACE);
		
		log.info("MiniStatement_04: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyEquals(miniStatementPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);

	}
	
	@Test
	public void MiniStatement_05_ValidAccountNumber(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		log.info("MiniStatement_05: Step 01 - Clear 'Account Number' textbox");
		miniStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("MiniStatement_05: Step 02 - Input to 'Account Number' textbox");
		miniStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", EditAccount.ACCOUNT_ID);
		
		log.info("MiniStatement_05: Step 03 - Click to submit button");
		miniStatementPage.clickToDynamicButton(driver, "AccSubmit");
		
		log.info("MiniStatement_05: Step 04 - Verify Last Five Transaction Details message displayed");
		verifyTrue(miniStatementPage.isLastFiveTransactionDetailsDispayed(EditAccount.ACCOUNT_ID));
	}
	

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
