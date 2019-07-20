package bankguru.payment;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageFactoryManager.PageFactoryManager;
import PageObjects.BalanceEnquiryPageObject;
import PageObjects.DeleteAccountPageObject;
import PageObjects.DeleteCustomerPageObject;
import PageObjects.DepositPageObject;
import PageObjects.EditAccountPageObject;
import PageObjects.EditCustomerPageObject;
import PageObjects.FundTransferPageObject;
import PageObjects.HomePageObject;
import PageObjects.LoginPageObject;
import PageObjects.NewAccountPageObject;
import PageObjects.NewCustomerPageObject;
import PageObjects.WithdrawalPageObject;
import bankguru.commonFunction.Common_01_RegisterToSystem;
import bankguru.testdata.PaymentTestData;
import commons.AbstractTest;
import reportConfig.ExtentTestManager;

public class Payment extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editcustomerPage;
	private NewAccountPageObject newAccountPage;
	private EditAccountPageObject editAccountPage;
	private DepositPageObject depositPage;
	private WithdrawalPageObject withdrawalPage;
	private FundTransferPageObject fundTransferPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;
	private String customerID, accountID, payeeAccountID;
	private String email = PaymentTestData.EMAIL+"@gmail.com";

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void Precondition(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);

		log.info("PaymentPrecondition: Step 01 - Get Login Page");
		loginPage = PageFactoryManager.getLoginPage(driver);

		log.info("PaymentPrecondition: Step 02 - Verify Login Form displays");
		verifyTrue(loginPage.isLoginFormDisplayed());

		log.info("PaymentPrecondition: Step 03 - Input to 'UserID' and 'Password' textboxes");
		loginPage.inputToDynamicTextboxOrTextArea(driver, "uid", Common_01_RegisterToSystem.USER_ID_INFOR);
		loginPage.inputToDynamicTextboxOrTextArea(driver, "password", Common_01_RegisterToSystem.PASSWORD_INFOR);

		log.info("PaymentPrecondition: Step 04 - Click to Login button");
		loginPage.clickToDynamicButton(driver, "btnLogin");
		homePage = PageFactoryManager.getHomePage(driver);

		log.info("PaymentPrecondition: Step 05 - Verify Home page's Welcome message displays");
		verifyTrue(homePage.isWelcomeMessageDisplayed());

		log.info("PaymentPrecondition: Step 06 - Verify User ID infor displays");
		verifyTrue(homePage.isUserIDDisplayed(Common_01_RegisterToSystem.USER_ID_INFOR));
		
	}

	@Test
	public void Payment_01_CreateNewCustomer(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("Payment_01: Step 01 - Click to 'New Customer' link");
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);
		
		log.info("Payment_01: Step 02 - Verify 'Add New Customer' title displays");
		verifyTrue(newCustomerPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.ADD_NEW_CUSTOMER_TITLE));

		log.info("Payment_01: Step 03 - Input to 'Customer Name' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "name", PaymentTestData.NAME);

		log.info("Payment_01: Step 04 - Select 'Male' gender");
		newCustomerPage.checkToDynamicCheckboxOrRadioButton(driver, "m");

		log.info("Payment_01: Step 05 - Remove 'type' attribute of 'Date of Birth' textbox");
		newCustomerPage.removeAnyAtrributeOfDynamicTextbox(driver, "dob", "type");

		log.info("Payment_01: Step 06 - Input to 'Date Of Birth' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "dob", PaymentTestData.DATE_OF_BIRTH);

		log.info("Payment_01: Step 07 - Input to 'Adress' text area");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", PaymentTestData.ADDRESS);

		log.info("Payment_01: Step 08 - Input to 'City' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", PaymentTestData.CITY);

		log.info("Payment_01: Step 09 - Input to 'State' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", PaymentTestData.STATE);

		log.info("Payment_01: Step 10 - Input to 'Pin' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", PaymentTestData.PIN);

		log.info("Payment_01: Step 11 - Input to 'Mobile Number' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", PaymentTestData.MOBILE_NUMBER);

		log.info("Payment_01: Step 12 - Input to 'Email' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", email);

		log.info("Payment_01: Step 13 - Input to 'Password' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "password", PaymentTestData.PASSWORD);

		log.info("Payment_01: Step 14 - Click to 'Submit' button");
		newCustomerPage.clickToDynamicButton(driver, "sub");

		log.info("Payment_01: Step 15 - Verify 'Customer Registered Successfully!!!' message displays");
		verifyTrue(newCustomerPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.CUSTOMER_REGISTERED_SUCCESSFULLY_MESSAGE));

		log.info("Payment_01: Step 16 - Verify all informations of new customer are correct");
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Customer Name"), PaymentTestData.NAME);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Gender"), PaymentTestData.GENDER);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Birthdate"), PaymentTestData.DATE_OF_BIRTH);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Address"), PaymentTestData.ADDRESS);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "City"), PaymentTestData.CITY);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "State"), PaymentTestData.STATE);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Pin"), PaymentTestData.PIN);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Mobile No."), PaymentTestData.MOBILE_NUMBER);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Email"), email);

		customerID = newCustomerPage.getTextDynamicTableInfo(driver, "Customer ID");
		
		captureAnyScreenshot(method.getName());
		
	}

	@Test
	public void Payment_02_EditCustomer(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("Payment_02: Step 01 - Click to 'Delete Customer' link");
		newCustomerPage.openMultiplePage(driver, "Edit Customer");
		editcustomerPage = PageFactoryManager.getEditCustomerPage(driver);
		
		log.info("Payment_02: Step 02 - Verify 'Edit Customer Form' title displays");
		verifyTrue(editcustomerPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.EDIT_CUSTOMER_TITLE));

		log.info("Payment_02: Step 03 - Input to 'Customer ID' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("Payment_02: Step 04 - Click to Submit button");
		editcustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_02: Step 05 - Verify all informations of Customer are correct before starting edit");
		verifyEquals(editcustomerPage.getValueInDynamicTextbox(driver, "name"), PaymentTestData.NAME);
		verifyEquals(editcustomerPage.getValueInDynamicTextbox(driver, "gender"), PaymentTestData.GENDER);
		verifyEquals(editcustomerPage.getValueInDynamicTextbox(driver, "dob"), PaymentTestData.DATE_OF_BIRTH);
		verifyEquals(editcustomerPage.getTextInDynamicTextArea(driver, "addr"), PaymentTestData.ADDRESS);
		verifyEquals(editcustomerPage.getValueInDynamicTextbox(driver, "city"), PaymentTestData.CITY);
		verifyEquals(editcustomerPage.getValueInDynamicTextbox(driver, "state"), PaymentTestData.STATE);
		verifyEquals(editcustomerPage.getValueInDynamicTextbox(driver, "pinno"), PaymentTestData.PIN);
		verifyEquals(editcustomerPage.getValueInDynamicTextbox(driver, "telephoneno"), PaymentTestData.MOBILE_NUMBER);
		verifyEquals(editcustomerPage.getValueInDynamicTextbox(driver, "emailid"), email);

		log.info("Payment_02: Step 06 - Clear 'Address' text area");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");

		log.info("Payment_02: Step 07 - Input to 'Address' text area");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", PaymentTestData.EDIT_ADRESS);

		log.info("Payment_02: Step 08 - Clear 'City' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "city");

		log.info("Payment_02: Step 09 - Input to 'City' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", PaymentTestData.EDIT_CITY);

		log.info("Payment_02: Step 10 - Clear 'State' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "state");

		log.info("Payment_02: Step 11 - Input to 'State' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", PaymentTestData.EDIT_STATE);

		log.info("Payment_02: Step 12 - Clear 'PIN' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");

		log.info("Payment_02: Step 13 - Input to 'PIN' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", PaymentTestData.EDIT_PIN);

		log.info("Payment_02: Step 14 - Clear 'Mobile Number' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");

		log.info("Payment_02: Step 15 - Input to 'Mobile Number' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", PaymentTestData.EDIT_PHONE_NUMBER);

		log.info("Payment_02: Step 16 - Clear 'Email' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");

		log.info("Payment_02: Step 17 - Input to 'Email' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", PaymentTestData.EDIT_EMAIL);

		log.info("Payment_02: Step 18 - Click to Submit button");
		editcustomerPage.clickToDynamicButton(driver, "sub");

		log.info("Payment_02: Step 19 - Verify 'Customer details updated Successfully!!!' message displays");
		verifyTrue(editcustomerPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.CUSTOMER_DETAILS_UPDATE_SUCCESSFULLY_MESSAGE));

		log.info("Payment_02: Step 20 - Verify all informations of customer are correct after editting");
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Customer ID"), customerID);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Customer Name"), PaymentTestData.NAME);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Gender"), PaymentTestData.GENDER);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Birthdate"), PaymentTestData.DATE_OF_BIRTH);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Address"), PaymentTestData.EDIT_ADRESS);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "City"), PaymentTestData.EDIT_CITY);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "State"), PaymentTestData.EDIT_STATE);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Pin"), PaymentTestData.EDIT_PIN);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Mobile No."), PaymentTestData.EDIT_PHONE_NUMBER);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Email"), PaymentTestData.EDIT_EMAIL);
		
		captureAnyScreenshot(method.getName());

	}

	@Test
	public void Payment_03_CreateNewAccountAndCheckAmount(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("Payment_03: Step 01 - Click to 'New Account' link");
		editcustomerPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);

		log.info("Payment_03: Step 02 - Verify 'Add new account form' message displays");
		verifyTrue(newAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.ADD_NEW_ACCOUNT_TITLE));

		log.info("Payment_03: Step 03 - Input to 'Customer id' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("Payment_03: Step 04 - Select 'Current' in 'Account type' dropdown");
		newAccountPage.selectItemInDynamicDropdown(driver, "selaccount", PaymentTestData.SAVINGS_ACCOUNT_TYPE);

		log.info("Payment_03: Step 05 - Input to 'Initial deposit' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", PaymentTestData.INITIAL_AMOUNT);

		log.info("Payment_03: Step 06 - Click to Submit button");
		newAccountPage.clickToDynamicButton(driver, "button2");

		log.info("Payment_03: Step 07 - Verify 'Account Generated Successfully!!!' message displays");
		verifyTrue(newAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.ACCOUNT_GENERATED_SUCCESSFULLY_MESSAGE));

		log.info("Payment_03: Step 08 - Verify all information of New Account are correct");
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Customer Name"), PaymentTestData.NAME);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Email"), PaymentTestData.EDIT_EMAIL);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Account Type"), PaymentTestData.SAVINGS_ACCOUNT_TYPE);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Date of Opening"), getToday());
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Current Amount"), PaymentTestData.INITIAL_AMOUNT);

		accountID = newAccountPage.getTextDynamicTableInfo(driver, "Account ID");
		
		captureAnyScreenshot(method.getName());
		
	}

	@Test
	public void Payment_04_EditAccount(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("Payment_04: Step 01 - Click to 'Edit Account' link");
		newAccountPage.openMultiplePage(driver, "Edit Account");
		editAccountPage = PageFactoryManager.getEditAccountPage(driver);

		log.info("Payment_04: Step 02 - Verify 'Edit Account Form' title displays");
		verifyTrue(editAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.EDIT_ACCOUNT_TITLE));

		log.info("Payment_04: Step 02 - Input to 'Account No' textbox");
		editAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", accountID);

		log.info("Payment_04: Step 03 - Click to Submit button");
		editAccountPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_04: Step 04 - Verify all informations of Account are correct before starting edit");
		verifyEquals(editAccountPage.getValueInDynamicTextbox(driver, "txtcid"), customerID);
		verifyEquals(editAccountPage.getSelectedItemInDynamicDropdown(driver, "a_type"), PaymentTestData.SAVINGS_ACCOUNT_TYPE);
		verifyEquals(editAccountPage.getValueInDynamicTextbox(driver, "txtinitdep"), PaymentTestData.INITIAL_AMOUNT);

		log.info("Payment_04: Step 05 - Select 'Current' from 'Type of Account' dropdown");
		editAccountPage.selectItemInDynamicDropdown(driver, "a_type", PaymentTestData.CURRENT_ACCOUNT_TYPE);

		log.info("Payment_04: Step 06 - Click to Submit button");
		editAccountPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_04: Step 07 - Verify 'Account details updated Successfully!!!' message displays");
		verifyTrue(editAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.ACCOUNT_DETAILS_UPDATE_SUCCESSFULLY_MESSAGE));

		log.info("Payment_04: Step 08 - Verify all information are correct after editting");
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Account ID"), accountID);
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Customer ID"), customerID);
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Customer Name"), PaymentTestData.NAME);
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Email"), PaymentTestData.EDIT_EMAIL);
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Account Type"), PaymentTestData.CURRENT_ACCOUNT_TYPE);
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Date of Opening"), getToday());
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Current Amount"), PaymentTestData.INITIAL_AMOUNT);
		
		captureAnyScreenshot(method.getName());

	}

	@Test
	public void Payment_05_TransferMoneyToCurrentAccount(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("Payment_05: Step 01 - Click to 'Deposit' link");
		editAccountPage.openMultiplePage(driver, "Deposit");
		depositPage = PageFactoryManager.getDepositPage(driver);

		log.info("Payment_05: Step 02 - Verify 'Amount Deposit form' displays");
		verifyTrue(newAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.AMOUNT_DEPOSIT_TITLE));

		log.info("Payment_05: Step 03 - Input to 'Account Number' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", accountID);

		log.info("Payment_05: Step 04 - Input to 'Amount' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "ammount", PaymentTestData.DEPOSIT_AMOUNT);

		log.info("Payment_05: Step 05 - Input to 'Description' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "desc", PaymentTestData.DEPOSIT_DESCRIPTION);

		log.info("Payment_05: Step 06 - Click to Submit button");
		depositPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_05: Step 07 - Verify Tracsaction Details message displays");
		verifyTrue(newAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, (PaymentTestData.TRACSACTION_DETAILS_DEPOSIT_MESSAGE + accountID)));

		log.info("Payment_05: Step 08 - Verify Current Balance and all infor are correct");
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Current Balance"), PaymentTestData.AFTER_DEPOSIT);
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Account No"), accountID);
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Amount Credited"), PaymentTestData.DEPOSIT_AMOUNT);
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Type of Transaction"), "Deposit");
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Description"), PaymentTestData.DEPOSIT_DESCRIPTION);
		
		captureAnyScreenshot(method.getName());

	}

	@Test
	public void Payment_06_WithdrawalMoneyFromCurrentAccount(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("Payment_06: Step 01 - Click to 'Withdrawal' link ");
		depositPage.openMultiplePage(driver, "Withdrawal");
		withdrawalPage = PageFactoryManager.getWithdrawalPage(driver);

		log.info("Payment_06: Step 02 - Verify Amount Withdraw form displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.AMOUNT_WITHDRAWAL_TITLE));

		log.info("Payment_06: Step 03 - Input to 'Account Number' textbox");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "accountno", accountID);

		log.info("Payment_06: Step 04 - Input to 'Amount' textbox");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "ammount", PaymentTestData.WITHDRAW_AMOUNT);

		log.info("Payment_06: Step 05 - Input to 'Description' textbox");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "desc", PaymentTestData.WITHDRAW_DESCRIPTION);

		log.info("Payment_06: Step 06 - Click to Submit button");
		withdrawalPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_06: Step 07 - Verify Tracsaction Details message displays");
		verifyTrue(newAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, (PaymentTestData.TRACSACTION_DETAILS_WITHDRAWAL_MESSAGE + accountID)));

		log.info("Payment_06: Step 08 - Verify Current Balance and all infors are correct");
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Current Balance"), PaymentTestData.AFTER_WITHDRAW);
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Account No"), accountID);
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Amount Debited"), PaymentTestData.WITHDRAW_AMOUNT);
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Type of Transaction"), "Withdrawal");
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Description"), PaymentTestData.WITHDRAW_DESCRIPTION);
		
		captureAnyScreenshot(method.getName());

	}

	@Test
	public void Payment_07_TransferMoneyToAnotherAccount(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		/* ========= Additional step: Create Payee Account ==========*/
		log.info("Payment_07: Step 01 - Click to 'New Account' link");
		withdrawalPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);

		log.info("Payment_07: Step 02 - Verify 'Add new account form' message displays");
		verifyTrue(newAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.ADD_NEW_ACCOUNT_TITLE));

		log.info("Payment_07: Step 03 - Input to 'Customer id' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("Payment_07: Step 04 - Select 'Current' in 'Account type' dropdown");
		newAccountPage.selectItemInDynamicDropdown(driver, "selaccount", PaymentTestData.SAVINGS_ACCOUNT_TYPE);

		log.info("Payment_07: Step 05 - Input to 'Initial deposit' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", PaymentTestData.INITIAL_AMOUNT);

		log.info("Payment_07: Step 06 - Click to Submit button");
		newAccountPage.clickToDynamicButton(driver, "button2");

		log.info("Payment_07: Step 07 - Verify 'Account Generated Successfully!!!' message displays");
		verifyTrue(newAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.ACCOUNT_GENERATED_SUCCESSFULLY_MESSAGE));

		log.info("Payment_07: Step 08 - Verify all infor are correct");
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Customer Name"), PaymentTestData.NAME);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Email"), PaymentTestData.EDIT_EMAIL);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Account Type"), PaymentTestData.SAVINGS_ACCOUNT_TYPE);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Date of Opening"), getToday());
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Current Amount"), PaymentTestData.INITIAL_AMOUNT);

		payeeAccountID = newAccountPage.getTextDynamicTableInfo(driver, "Account ID");

		log.info("Payment_07: Step 09 - Click to 'Fund Transfer' link ");
		newAccountPage.openMultiplePage(driver, "Fund Transfer");
		fundTransferPage = PageFactoryManager.getFundTransferPage(driver);
		
		log.info("Payment_07: Step 10 - Verify 'Fund transfer' message displays");
		verifyTrue(fundTransferPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.FUND_TRANSFER_TITLE));

		log.info("Payment_07: Step 11 - Input to 'Payers Account Number' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payersaccount", accountID);

		log.info("Payment_07: Step 12 - Input to 'Payees Account Number' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payeeaccount", payeeAccountID);

		log.info("Payment_07: Step 13 - Input to 'Amount' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "ammount", PaymentTestData.TRANSFER_AMOUNT);

		log.info("Payment_07: Step 14 - Input to 'Description' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "desc", PaymentTestData.FUND_TRANSFER_DESCRIPTION);

		log.info("Payment_07: Step 15 - Click to Submit button");
		fundTransferPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_07: Step 16 - Verify 'Fund Transfer Details' message displays");
		verifyTrue(newAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.FUND_TRANSFER_DETAILS_MESSAGE));

		log.info("Payment_07: Step 17 - Verify Payers Account is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "From Account Number"), accountID);

		log.info("Payment_07: Step 18 - Verify Payees Account is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "To Account Number"), payeeAccountID);

		log.info("Payment_07: Step 19 - Verify Transferred amount is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "Amount"), PaymentTestData.TRANSFER_AMOUNT);

		log.info("Payment_07: Step 20 - Verify Description is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "Description"), PaymentTestData.FUND_TRANSFER_DESCRIPTION);
		
		captureAnyScreenshot(method.getName());

	}

	@Test
	public void Payment_08_CheckCurrentAccountBalance(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("Payment_08: Step 01 - Click to 'Balance Enquiry' link ");
		fundTransferPage.openMultiplePage(driver, "Balance Enquiry");
		balanceEnquiryPage = PageFactoryManager.getBalanceEnquiryPage(driver);

		log.info("Payment_08: Step 02 - Verify Balance Enquiry Form message displays");
		verifyTrue(balanceEnquiryPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.BALANCE_ENQUIRY_TITLE));

		log.info("Payment_08: Step 02 - Input to 'Account Number' textbox ");
		balanceEnquiryPage.inputToDynamicTextboxOrTextArea(driver, "accountno", accountID);

		log.info("Payment_08: Step 03 - Click to Submit button");
		balanceEnquiryPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_08: Step 04 - Verify Balance Details message displays");
		verifyTrue(newAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, ("Balance Details for Account " + accountID)));

		log.info("Payment_08: Step 05 - Verify current balance after Transferring is correct");
		verifyEquals(balanceEnquiryPage.getTextDynamicTableInfo(driver, "Balance"), PaymentTestData.AFTER_TRANSFER);

		log.info("Payment_08: Step 06 - Verify Account Number and Type of Account are correct");
		verifyEquals(balanceEnquiryPage.getTextDynamicTableInfo(driver, "Account No"), accountID);
		verifyEquals(balanceEnquiryPage.getTextDynamicTableInfo(driver, "Type of Account"), PaymentTestData.CURRENT_ACCOUNT_TYPE);
		
		captureAnyScreenshot(method.getName());

	}

	@Test
	public void Payment_09_DeleteAccountsAndVerify(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		String[] allAccounts = { accountID, payeeAccountID };
		log.info("Payment_09: Step 00 - Click to 'Delete Account' link");
		balanceEnquiryPage.openMultiplePage(driver, "Delete Account");
		deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);
		
		for (String eachAccount : allAccounts) {
			
			log.info("Payment_09: Step 01 - Click to 'Delete Account' link");
			deleteAccountPage.openMultiplePage(driver, "Delete Account");

			log.info("Payment_09: Step 02 - Verify 'Delete Account Form' message displays");
			verifyTrue(deleteAccountPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.DELETE_ACCOUNT_TITLE));

			log.info("Payment_09: Step 03 - Input to 'Account Number' textbox ");
			deleteAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", eachAccount);

			log.info("Payment_09: Step 04 - Click to Submit button");
			deleteAccountPage.clickToDynamicButton(driver, "AccSubmit");

			log.info("Payment_09: Step 04 - Verify 'Do you really want to delete this Account?' alert displays");
			if (!driver.toString().toLowerCase().contains("internet explorer")) {
				verifyEquals(deleteAccountPage.getTextAnyAlert(driver), PaymentTestData.DELETE_ACCOUNT_CONFIRMATION_ALERT_MESSAGE);
			}

			log.info("Payment_09: Step 05 - Accept alert");
			deleteAccountPage.acceptAnyAlert(driver);

			log.info("DeleteAccount: Step 06 - Verify 'Account Deleted Sucessfully' alert displays");
			if (!driver.toString().toLowerCase().contains("internet explorer")) {
				verifyEquals(deleteAccountPage.getTextAnyAlert(driver), PaymentTestData.ACCOUNT_DELETE_SUCCESSFULLY_ALERT_MESSAGE);
			}

			log.info("Payment_09: Step 07 - Accept alert");
			deleteAccountPage.acceptAnyAlert(driver);
			homePage = PageFactoryManager.getHomePage(driver);

			log.info("Payment_09: Step 08 - Check Account does not exist anymore");
			homePage.openMultiplePage(driver, "Delete Account");
			deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);
			deleteAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", eachAccount);
			deleteAccountPage.clickToDynamicButton(driver, "AccSubmit");

			log.info("Payment_09: Step 09 - Verify 'Do you really want to delete this Account?' alert displays");
			if (!driver.toString().toLowerCase().contains("internet explorer")) {
				verifyEquals(deleteAccountPage.getTextAlert(driver), PaymentTestData.DELETE_ACCOUNT_CONFIRMATION_ALERT_MESSAGE);
			}

			log.info("Payment_09: Step 10 - Accept alert");
			deleteAccountPage.acceptAnyAlert(driver);

			log.info("Payment_09: Step 11 - Verify 'Account does not exist' alert displays");
			if (!driver.toString().toLowerCase().contains("internet explorer")) {
				verifyEquals(deleteAccountPage.getTextAnyAlert(driver), PaymentTestData.ACCOUNT_DOES_NOT_EXIST_ALERT_MESSAGE);
			}

			log.info("Payment_09: Step 12 - Accept alert");
			deleteAccountPage.acceptAnyAlert(driver);

		}
		captureAnyScreenshot(method.getName());

	}

	@Test
	public void Payment_10_DeleteCustomerAndVerify(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());

		log.info("Payment_10: Step 01 - Click to 'Delete Customer' link ");
		deleteAccountPage.openMultiplePage(driver, "Delete Customer");
		deleteCustomerPage = PageFactoryManager.getDeleteCustomerPage(driver);
		
		log.info("Payment_10: Step 02 - Verify 'Delete Customer Form' message displays");
		verifyTrue(deleteCustomerPage.isDynamicPageTitleOrMessageDisplayed(driver, PaymentTestData.DELETE_CUSTOMER_TITLE));

		log.info("Payment_10: Step 03 - Input to 'Customer ID' textbox ");
		deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("Payment_10: Step 04 - Click to Submit button");
		deleteCustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_10: Step 05 - Verify 'Do you really want to delete this Customer?' alert displays");
		if (!driver.toString().toLowerCase().contains("internet explorer")) {
			verifyEquals(deleteCustomerPage.getTextAnyAlert(driver), PaymentTestData.DELETE_CUSTOMER_CONFIRMATION_ALERT_MESSAGE);
		}

		log.info("Payment_10: Step 06 - Accept alert");
		deleteCustomerPage.acceptAnyAlert(driver);

		log.info("Payment_10: Step 07 - Verify 'Customer deleted Successfully' alert displays");
		if (!driver.toString().toLowerCase().contains("internet explorer")) {
			verifyEquals(deleteCustomerPage.getTextAnyAlert(driver), PaymentTestData.CUSTOMER_DELETE_SUCCESSFULLY_ALERT_MESSAGE);
		}

		log.info("Payment_10: Step 08 - Accept alert");
		deleteCustomerPage.acceptAnyAlert(driver);
		homePage = PageFactoryManager.getHomePage(driver);

		log.info("Payment_10: Step 09 - Click to 'Delete Customer' link ");
		deleteAccountPage.openMultiplePage(driver, "Delete Customer");
		deleteCustomerPage = PageFactoryManager.getDeleteCustomerPage(driver);

		log.info("Payment_10: Step 10 - Input to 'Customer ID' textbox ");
		deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("Payment_10: Step 11 - Click to Submit button");
		deleteCustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_10: Step 12 - Verify 'Do you really want to delete this Customer?' alert displays");
		if (!driver.toString().toLowerCase().contains("internet explorer")) {
			verifyEquals(deleteCustomerPage.getTextAnyAlert(driver), PaymentTestData.DELETE_CUSTOMER_CONFIRMATION_ALERT_MESSAGE);
		}

		log.info("Payment_10: Step 13 - Accept alert");
		deleteCustomerPage.acceptAnyAlert(driver);

		log.info("Payment_10: Step 14 - Verify 'Customer does not exist!' alert displays");
		if (!driver.toString().toLowerCase().contains("internet explorer")) {
			verifyEquals(deleteCustomerPage.getTextAnyAlert(driver), PaymentTestData.CUSTOMER_DOES_NOT_EXIST_ALERT_MESSAGE);
		}

		log.info("Payment_09: Step 15 - Accept alert");
		deleteCustomerPage.acceptAnyAlert(driver);
		
		captureAnyScreenshot(method.getName());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
