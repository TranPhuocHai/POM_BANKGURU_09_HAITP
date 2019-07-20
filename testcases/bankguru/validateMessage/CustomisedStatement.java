package bankguru.validateMessage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageFactoryManager.PageFactoryManager;
import PageObjects.CustomisedStatementPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import bankguru.commonFunction.Common_01_RegisterToSystem;
import bankguru.testdata.CommonTestData;
import bankguru.testdata.ValidateMessage;
import bankguru.validateMessage.EditAccount;
import commons.AbstractTest;

public class CustomisedStatement extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private CustomisedStatementPageObject customisedStatementPage;
	private String blankSpace = " ";
	private String numberOfTransaction = "1";

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

		log.info("Precondition: Step 07 - Click to 'Customised Statement' link");
		homePage.openMultiplePage(driver, "Customised Statement");
		customisedStatementPage = PageFactoryManager.getCustomisedStatementPage(driver);
		
		log.info("Precondition: Step 08 - Verify 'Customized Statement Form' displayed");
		verifyTrue(customisedStatementPage.isDynamicPageTitleOrMessageDisplayed(driver, CommonTestData.CUSTOMIZED_STATEMENT_TITLE));
	}
	
	@Test
	public void CustomisedStatement_01_AccountNumberCanNotBeEmpty() {
		
		log.info("CustomisedStatement_01: Step 01 - Clear 'Account Number' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");

		log.info("CustomisedStatement_01: Step 02 - Click to 'Account Number' textbox");
		customisedStatementPage.clickToDynamicTextboxOrTextArea(driver, "accountno");

		log.info("CustomisedStatement_01: Step 03 - Click to 'Minimum Transaction Value' textbox");
		customisedStatementPage.clickToDynamicTextboxOrTextArea(driver, "amountlowerlimit");

		log.info("CustomisedStatement_01: Step 04 - Verify 'Account Number must not be blank' message displayed");
		verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.ACCOUNT_NUMBER_MUST_NOT_BE_BLANK);
	}

	@Test
	public void CustomisedStatement_02_AccountNumberCharacterAreNotAllowed() {
		for (String characterValue : CommonTestData.CHARACTER_VALUE) {
			
			log.info("CustomisedStatement_02: Step 01 - Clear 'Account Number' textbox");
			customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");

			log.info("CustomisedStatement_02: Step 02 - Input to 'Account Number' textbox");
			customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", characterValue);

			log.info("CustomisedStatement_02: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void CS_03_AccountNumberCanNotHaveSpecialCharacters() {
		for (String specialValue : CommonTestData.SPECIAL_VALUE) {
			
			log.info("CustomisedStatement_03: Step 01 - Clear 'Account Number' textbox");
			customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");
			
			log.info("CustomisedStatement_03: Step 02 - Input to 'Account Number' textbox");
			customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", specialValue);
			
			log.info("CustomisedStatement_03: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void CustomisedStatement_04_AccountNumberFirstCharacterMustNotBeBlank() {
		
		log.info("CustomisedStatement_04: Step 01 - Clear 'Account Number' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("CustomisedStatement_04: Step 02 - Input to 'Account Number' textbox");
		customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", blankSpace);
		
		log.info("CustomisedStatement_04: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Account No"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);

	}
	
	@Test
	public void CustomisedStatement_05_MinimumTransactionValueCharacterAreNotAllowed() {
		for (String characterMinimumTransactionValue : CommonTestData.CHARACTER_VALUE) {
			
			log.info("CustomisedStatement_05: Step 01 - Clear 'Minimum Transaction Value' textbox");
			customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "amountlowerlimit");
			
			log.info("CustomisedStatement_05: Step 02 - Input to 'Minimum Transaction Value' textbox");
			customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "amountlowerlimit", characterMinimumTransactionValue);
			
			log.info("CustomisedStatement_05: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Minimum Transaction Value"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}
	}
	
	@Test
	public void CustomisedStatement_06_MinimumTransactionValueCanNotHaveSpecialCharacters() {
		for (String specialMinimumTransactionValue : CommonTestData.SPECIAL_VALUE) {
			
			log.info("CustomisedStatement_06: Step 01 - Clear 'Minimum Transaction Value' textbox");
			customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "amountlowerlimit");
			
			log.info("CustomisedStatement_06: Step 02 - Input to 'Minimum Transaction Value' textbox");
			customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "amountlowerlimit", specialMinimumTransactionValue);
			
			
			log.info("CustomisedStatement_06: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Minimum Transaction Value"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}
	
	@Test
	public void CustomisedStatement_07_MinimumTransactionValueFirstCharacterMustNotBeBlank() {
		
		log.info("CustomisedStatement_07: Step 01 - Clear 'Minimum Transaction Value' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "amountlowerlimit");
		
		log.info("CustomisedStatement_07: Step 02 - Input to 'Minimum Transaction Value' textbox");
		customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "amountlowerlimit", blankSpace);
		
		log.info("CustomisedStatement_07: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Minimum Transaction Value"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		
	}
	
	@Test
	public void CustomisedStatement_08_NumberOfTransactionCharacterAreNotAllowed() {
		for (String CharacterNumberOfTransaction : CommonTestData.CHARACTER_VALUE) {
			
			log.info("CustomisedStatement_08: Step 01 - Clear 'Number of Transaction' textbox");
			customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "numtransaction");
			
			log.info("CustomisedStatement_08: Step 02 - Input to 'Number of Transaction' textbox");
			customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "numtransaction", CharacterNumberOfTransaction);
			
			log.info("CustomisedStatement_08: Step 03 - Verify 'Characters are not allowed' message displayed");
			verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Number of Transaction"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void CustomisedStatement_09_NumberOfTransactionCanNotHaveSpecialCharacters() {
		for (String specialNumberOfTransaction : CommonTestData.SPECIAL_VALUE) {
			
			log.info("CustomisedStatement_09: Step 01 - Clear 'Number of Transaction' textbox");
			customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "numtransaction");
			
			log.info("CustomisedStatement_09: Step 02 - Input to 'Number of Transaction' textbox");
			customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "numtransaction", specialNumberOfTransaction);
			
			log.info("CustomisedStatement_09: Step 03 - Verify 'Special characters are not allowed' message displayed");
			verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Number of Transaction"), ValidateMessage.SPECIAL_CHARACTERS_ARE_NOT_ALLOWED);
		}
	}

	@Test
	public void CustomisedStatement_10_NumberOfTransactionFirstCharacterMustNotBeBlank() {
		
		log.info("CustomisedStatement_10: Step 01 - Clear 'Number of Transaction' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "numtransaction");
		
		log.info("CustomisedStatement_10: Step 02 - Input to 'Number of Transaction' textbox");
		customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "numtransaction", blankSpace);
		
		log.info("CustomisedStatement_10: Step 03 - Verify 'Characters are not allowed' message displayed");
		verifyEquals(customisedStatementPage.getTextDynamicValidateMessage(driver, "Number of Transaction"), ValidateMessage.CHARACTERS_ARE_NOT_ALLOWED);

	}
	
	@Test
	public void CustomisedStatement_11_InputValidInforAndVerifyCustomisedStatementDisplayed() {
		
		log.info("CustomisedStatement_11: Step 01 - Clear 'Account Number' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "accountno");
		
		log.info("CustomisedStatement_11: Step 02 - Input to 'Account Number' textbox");
		customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "accountno", EditAccount.ACCOUNT_ID);
		
		log.info("CustomisedStatement_11: Step 03 - Clear 'Minimum Transaction Value' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "amountlowerlimit");
		
		log.info("CustomisedStatement_11: Step 04 - Input to 'Minimum Transaction Value' textbox");
		customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "amountlowerlimit", CommonTestData.AMOUNT);
		
		log.info("CustomisedStatement_11: Step 05 - Clear 'Number of Transaction' textbox");
		customisedStatementPage.clearDynamicTextboxOrTextArea(driver, "numtransaction");
		
		log.info("CustomisedStatement_11: Step 06 - Input to 'Number of Transaction' textbox");
		customisedStatementPage.inputToDynamicTextboxOrTextArea(driver, "numtransaction", numberOfTransaction);
		
		log.info("CustomisedStatement_11: Step 07 - Click to Submit button");
		customisedStatementPage.clickToDynamicButton(driver, "AccSubmit");	
		
		log.info("CustomisedStatement_11: Step 08 - Verify Transaction Details message displayed");
		verifyTrue(customisedStatementPage.isTransactionDetailsFormDisplayed(EditAccount.ACCOUNT_ID));
	}

	

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
