package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.bankguru.user.Common_01_RegisterToSystem;
import bankguruPageFactoryManager.PageFactoryManager;
import bankguruPageObjects.BalanceEnquiryPageObject;
import bankguruPageObjects.DeleteAccountPageObject;
import bankguruPageObjects.DeleteCustomerPageObject;
import bankguruPageObjects.DepositPageObject;
import bankguruPageObjects.EditAccountPageObject;
import bankguruPageObjects.EditCustomerPageObject;
import bankguruPageObjects.FundTransferPageObject;
import bankguruPageObjects.HomePageObject;
import bankguruPageObjects.LoginPageObject;
import bankguruPageObjects.NewAccountPageObject;
import bankguruPageObjects.NewCustomerPageObject;
import bankguruPageObjects.WithdrawalPageObject;
import commons.AbstractTest;

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

	private String customerID;
	private String name = "Tran Phuoc Hai";
	private String gender = "male";
	private String dateOfBirth = "1988-07-31";
	private String address = "100 Dia Chi";
	private String city = "Ha Noi";
	private String state = "Hoan Kiem";
	private String pin = "600000";
	private String mobileNumber = "0987654321";
	private String email = "haitp" + randomNumber() + "@gmail.com";
	private String password = "sdhgd3123";

	private String accountID, payeeAccountID;

	private String editAdress = "01 Nguyen Van Linh";
	private String editCity = "Da Nang";
	private String editState = "Ngu Hanh Son";
	private String editPin = "550000";
	private String editPhoneNumber = "0975123456";
	private String editEmail = "hai.gsd@gmail.com";

	private int intInitialAmount = 50000;
	private int intDepositAmount = 5000;
	private int intAfterDeposit = intInitialAmount + intDepositAmount;
	private int intWithdrawAmount = 15000;
	private int intAfterWithdraw = intAfterDeposit - intWithdrawAmount;
	private int intTransferAmount = 10000;
	private int intAfterTransfer = intAfterWithdraw - intTransferAmount;

	private String initialAmount = String.valueOf(intInitialAmount);
	private String depositAmount = String.valueOf(intDepositAmount);
	private String afterDeposit = String.valueOf(intAfterDeposit);
	private String withdrawAmount = String.valueOf(intWithdrawAmount);
	private String afterWithdraw = String.valueOf(intAfterWithdraw);
	private String transferAmount = String.valueOf(intTransferAmount);
	private String afterTransfer = String.valueOf(intAfterTransfer);

	private String depositDescription = "Deposit";
	private String withdrawDescription = "Withdraw";
	private String fundTransferDescription = "Transfer";

	private String savingsAccountType = "Savings";
	private String currentAccountType = "Current";

	@Parameters({ "browser", "url" })
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
	}

	@Test
	public void Payment_01_CreateNewCustomer() {

		log.info("Payment_01: Step 01 - Click to 'New Customer' link");
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

		log.info("Payment_01: Step 02 - Input to 'Customer Name' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "name", name);

		log.info("Payment_01: Step 03 - Select Male gender");
		newCustomerPage.checkToDynamicCheckboxOrRadioButton(driver, "m");

		log.info("Payment_01: Step 04 - Remove 'type' attribute of Date of Birth textbox");
		newCustomerPage.removeAtrributeDynamicTextbox(driver, "dob", "type");

		log.info("Payment_01: Step 05 - Input to 'Date Of Birth' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "dob", dateOfBirth);

		log.info("Payment_01: Step 06 - Input to 'Adress' text area");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", address);

		log.info("Payment_01: Step 07 - Input to 'City' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", city);

		log.info("Payment_01: Step 08 - Input to 'State' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", state);

		log.info("Payment_01: Step 09 - Input to 'Pin' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", pin);

		log.info("Payment_01: Step 10 - Input to 'Mobile Number' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", mobileNumber);

		log.info("Payment_01: Step 11 - Input to 'Email' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", email);

		log.info("Payment_01: Step 12 - Input to 'Password' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "password", password);

		log.info("Payment_01: Step 13 - Click to 'Submit' button");
		newCustomerPage.clickToDynamicButton(driver, "sub");

		log.info("Payment_01: Step 14 - Verify title 'Customer Registered Successfully!!!' displayed");
		verifyTrue(newCustomerPage.isDynamicPageTitleDisplayed(driver, "Customer Registered Successfully!!!"));

		log.info("Payment_01: Step 15 - Get 'Customer ID'");
		customerID = newCustomerPage.getTextDynamicTableInfo(driver, "Customer ID");

		log.info("Payment_01: Step 16 - Verify all informations of new customer are correct");
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Customer Name"), name);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Gender"), gender);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Birthdate"), dateOfBirth);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Address"), address);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "City"), city);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "State"), state);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Pin"), pin);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Mobile No."), mobileNumber);
		verifyEquals(newCustomerPage.getTextDynamicTableInfo(driver, "Email"), email);

	}

	@Test
	public void Payment_02_EditCustomer() {

		log.info("Payment_02: Step 01 - Click to 'Delete Customer' link");
		newCustomerPage.openMultiplePage(driver, "Edit Customer");
		editcustomerPage = PageFactoryManager.getEditCustomerPage(driver);

		log.info("Payment_02: Step 02 - Input to 'Customer ID' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("Payment_02: Step 03 - Click to Submit textbox");
		editcustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_02: Step 04 - Verify all informations of Customer are correct before starting edit");
		verifyEquals(editcustomerPage.getTextValueInDynamicTextbox(driver, "name"), name);
		verifyEquals(editcustomerPage.getTextValueInDynamicTextbox(driver, "gender"), gender);
		verifyEquals(editcustomerPage.getTextValueInDynamicTextbox(driver, "dob"), dateOfBirth);
		verifyEquals(editcustomerPage.getTextInDynamicTextArea(driver, "addr"), address);
		verifyEquals(editcustomerPage.getTextValueInDynamicTextbox(driver, "city"), city);
		verifyEquals(editcustomerPage.getTextValueInDynamicTextbox(driver, "state"), state);
		verifyEquals(editcustomerPage.getTextValueInDynamicTextbox(driver, "pinno"), pin);
		verifyEquals(editcustomerPage.getTextValueInDynamicTextbox(driver, "telephoneno"), mobileNumber);
		verifyEquals(editcustomerPage.getTextValueInDynamicTextbox(driver, "emailid"), email);

		log.info("Payment_02: Step 05 - Clear 'Address' Text Area");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");

		log.info("Payment_02: Step 06 - Input to 'Address' Text Area");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", editAdress);

		log.info("Payment_02: Step 07 - Clear 'City' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "city");

		log.info("Payment_02: Step 08 - Input to 'City' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", editCity);

		log.info("Payment_02: Step 09 - Clear 'State' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "state");

		log.info("Payment_02: Step 10 - Input to 'State' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", editState);

		log.info("Payment_02: Step 11 - Clear 'PIN' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");

		log.info("Payment_02: Step 12 - Input to 'PIN' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", editPin);

		log.info("Payment_02: Step 13 - Clear 'Mobile Number' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");

		log.info("Payment_02: Step 14 - Input to 'Mobile Number' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", editPhoneNumber);

		log.info("Payment_02: Step 15 - Clear 'Email' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");

		log.info("Payment_02: Step 16 - Input to 'Email' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", editEmail);

		log.info("Payment_02: Step 17 - Click to Submit button");
		editcustomerPage.clickToDynamicButton(driver, "sub");

		log.info("Payment_02: Step 18 - Verify 'Customer details updated Successfully!!!' message displayed");
		verifyTrue(editcustomerPage.isDynamicPageTitleDisplayed(driver, "Customer details updated Successfully!!!"));

		log.info("Payment_02: Step 19 - Verify all informations of edit customer are correct");
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Customer ID"), customerID);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Customer Name"), name);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Gender"), gender);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Birthdate"), dateOfBirth);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Address"), editAdress);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "City"), editCity);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "State"), editState);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Pin"), editPin);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Mobile No."), editPhoneNumber);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Email"), editEmail);

	}

	@Test
	public void Payment_03_CreateNewAccountAndCheckCurrentAmount() {

		log.info("Payment_03: Step 01 - Click to 'New Account' link");
		editcustomerPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);

		log.info("Payment_03: Step 02 - Verify 'Add new account form' message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Add new account form"));

		log.info("Payment_03: Step 03 - Input to 'Customer id' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("Payment_03: Step 04 - Select 'Current' in 'Account type' dropdown");
		newAccountPage.selectItemInDynamicDropdown(driver, "selaccount", savingsAccountType);

		log.info("Payment_03: Step 05 - Input to 'Initial deposit' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", initialAmount);

		log.info("Payment_03: Step 06 - Click to Submit button");
		newAccountPage.clickToDynamicButton(driver, "button2");

		log.info("Payment_03: Step 07 - Verify 'Account Generated Successfully!!!' message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Account Generated Successfully!!!"));

		log.info("Payment_03: Step 08 - Verify all infor are correct");
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Customer Name"), name);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Account Type"), savingsAccountType);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Date of Opening"), getToday());
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Current Amount"), initialAmount);

		accountID = newAccountPage.getTextDynamicTableInfo(driver, "Account ID");
	}

	@Test
	public void Payment_04_EditAccount() {

		log.info("Payment_04: Step 01 - Click to 'Edit Account' link");
		newAccountPage.openMultiplePage(driver, "Edit Account");
		editAccountPage = PageFactoryManager.getEditAccountPage(driver);

		log.info("Payment_04: Step 02 - Verify 'Edit Account Form' message displayed");
		verifyTrue(editAccountPage.isDynamicPageTitleDisplayed(driver, "Edit Account Form"));

		log.info("Payment_04: Step 02 - Input to 'Account No' textbox");
		editAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", accountID);

		log.info("Payment_04: Step 03 - Click to Submit button");
		editAccountPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_04: Step 04 - Verify all informations of Account are correct before starting edit");
		verifyEquals(editAccountPage.getTextValueInDynamicTextbox(driver, "txtcid"), customerID);
		verifyEquals(editAccountPage.getSelectedItemInDynamicDropdown(driver, "a_type"), savingsAccountType);
		verifyEquals(editAccountPage.getTextValueInDynamicTextbox(driver, "txtinitdep"), initialAmount);

		log.info("Payment_04: Step 05 - Select 'Current' from 'Type of Account' dropdown");
		editAccountPage.selectItemInDynamicDropdown(driver, "a_type", currentAccountType);

		log.info("Payment_04: Step 06 - Click to Submit button");
		editAccountPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_04: Step 07 - Verify 'Account details updated Successfully!!!' message displayed");
		verifyTrue(editAccountPage.isDynamicPageTitleDisplayed(driver, "Account details updated Successfully!!!"));

		log.info("Payment_04: Step 08 - Verify all infor are correct");
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Account ID"), accountID);
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Customer ID"), customerID);
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Customer Name"), name);
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Email"), editEmail);
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Account Type"), currentAccountType);
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Date of Opening"), getToday());
		verifyEquals(editAccountPage.getTextDynamicTableInfo(driver, "Current Amount"), initialAmount);

	}

	@Test
	public void Payment_05_TransferMoneyToCurrentAccount() {

		log.info("Payment_05: Step 01 - Click to 'Deposit' link ");
		editAccountPage.openMultiplePage(driver, "Deposit");
		depositPage = PageFactoryManager.getDepositPage(driver);

		log.info("Payment_05: Step 02 - Verify Amount Deposit form displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Amount Deposit Form"));

		log.info("Payment_05: Step 03 - Input to 'Account Number' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", accountID);

		log.info("Payment_05: Step 04 - Input to 'Amount' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "ammount", depositAmount);

		log.info("Payment_05: Step 05 - Input to 'Description' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "desc", depositDescription);

		log.info("Payment_05: Step 06 - Click to Submit button");
		depositPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_05: Step 07 - Verify Tracsaction Details message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, ("Transaction details of Deposit for Account " + accountID)));

		log.info("Payment_05: Step 08 - Verify Current Balance and all infor are correct");
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Current Balance"), afterDeposit);
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Account No"), accountID);
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Amount Credited"), depositAmount);
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Type of Transaction"), "Deposit");
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Description"), depositDescription);

	}

	@Test
	public void Payment_06_WithdrawalMoneyFromCurrentAccount() {

		log.info("Payment_06: Step 01 - Click to 'Withdrawal' link ");
		depositPage.openMultiplePage(driver, "Withdrawal");
		withdrawalPage = PageFactoryManager.getWithdrawalPage(driver);

		log.info("Payment_06: Step 02 - Verify Amount Withdraw form displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Amount Withdrawal Form"));

		log.info("Payment_06: Step 03 - Input to 'Account Number' textbox");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "accountno", accountID);

		log.info("Payment_06: Step 04 - Input to 'Amount' textbox");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "ammount", withdrawAmount);

		log.info("Payment_06: Step 05 - Input to 'Description' textbox");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "desc", withdrawDescription);

		log.info("Payment_06: Step 06 - Click to Submit button");
		withdrawalPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_06: Step 07 - Verify Tracsaction Details message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, ("Transaction details of Withdrawal for Account " + accountID)));

		log.info("Payment_06: Step 08 - Verify Current Balance and all infors are correct");
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Current Balance"), afterWithdraw);
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Account No"), accountID);
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Amount Debited"), withdrawAmount);
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Type of Transaction"), "Withdrawal");
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Description"), withdrawDescription);

	}

	@Test
	public void Payment_07_TransferMoneyToAnotherAccount() {
		/* Create payeeAccount */
		log.info("Payment_07: Step 01 - Click to 'New Account' link");
		withdrawalPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);

		log.info("Payment_07: Step 02 - Verify 'Add new account form' message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Add new account form"));

		log.info("Payment_07: Step 03 - Input to 'Customer id' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("Payment_07: Step 04 - Select 'Current' in 'Account type' dropdown");
		newAccountPage.selectItemInDynamicDropdown(driver, "selaccount", savingsAccountType);

		log.info("Payment_07: Step 05 - Input to 'Initial deposit' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", initialAmount);

		log.info("Payment_07: Step 06 - Click to Submit button");
		newAccountPage.clickToDynamicButton(driver, "button2");

		log.info("Payment_07: Step 07 - Verify 'Account Generated Successfully!!!' message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Account Generated Successfully!!!"));

		log.info("Payment_07: Step 08 - Verify all infor are correct");
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Customer Name"), name);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Account Type"), savingsAccountType);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Date of Opening"), getToday());
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Current Amount"), initialAmount);

		payeeAccountID = newAccountPage.getTextDynamicTableInfo(driver, "Account ID");

		log.info("Payment_07: Step 09 - Click to 'Fund Transfer' link ");
		withdrawalPage.openMultiplePage(driver, "Fund Transfer");
		fundTransferPage = PageFactoryManager.getFundTransferPage(driver);

		log.info("Payment_07: Step 10 - Input to 'Payers Account Number' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payersaccount", accountID);

		log.info("Payment_07: Step 11 - Input to 'Payees Account Number' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payeeaccount", payeeAccountID);

		log.info("Payment_07: Step 12 - Input to 'Amount' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "ammount", transferAmount);

		log.info("Payment_07: Step 13 - Input to 'Description' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "desc", fundTransferDescription);

		log.info("Payment_07: Step 14 - Click to Submit button");
		fundTransferPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_07: Step 15 - Verify FundTransfer Details message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Fund Transfer Details"));

		log.info("Payment_07: Step 16 - Verify Payers Account is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "From Account Number"), accountID);

		log.info("Payment_07: Step 17 - Verify Payees Account is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "To Account Number"), payeeAccountID);

		log.info("Payment_07: Step 18 - Verify Transferred amount is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "Amount"), transferAmount);

		log.info("Payment_07: Step 19 - Verify Description is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "Description"), fundTransferDescription);

	}

	@Test
	public void Payment_08_CheckCurrentAccountBalance() {

		log.info("Payment_08: Step 01 - Click to 'Balance Enquiry' link ");
		fundTransferPage.openMultiplePage(driver, "Balance Enquiry");
		balanceEnquiryPage = PageFactoryManager.getBalanceEnquiryPage(driver);

		log.info("Payment_08: Step 02 - Verify Balance Enquiry Form message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Balance Enquiry Form"));

		log.info("Payment_08: Step 02 - Input to 'Account Number' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "accountno", accountID);

		log.info("Payment_08: Step 03 - Click to Submit button");
		balanceEnquiryPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_08: Step 04 - Verify Balance Details message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, ("Balance Details for Account " + accountID)));

		log.info("Payment_08: Step 05 - Verify current balance after Transferring is correct");
		verifyEquals(balanceEnquiryPage.getTextDynamicTableInfo(driver, "Balance"), afterTransfer);

		log.info("Payment_08: Step 06 - Verify Account Number and Type of Account are correct");
		verifyEquals(balanceEnquiryPage.getTextDynamicTableInfo(driver, "Account No"), accountID);
		verifyEquals(balanceEnquiryPage.getTextDynamicTableInfo(driver, "Type of Account"), currentAccountType);

	}

	@Test
	public void Payment_09_DeleteAccountsAndVerify() {
		String[] allAccounts = { accountID, payeeAccountID };
		log.info("Payment_09: Step 01 - Click to 'Delete Account' link ");
		balanceEnquiryPage.openMultiplePage(driver, "Delete Account");
		deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);
		
		for (String eachAccount : allAccounts) {

			log.info("Payment_09: Step 02 - Verify Delete Account Form message displayed");
			verifyTrue(deleteAccountPage.isDynamicPageTitleDisplayed(driver, "Delete Account Form"));

			log.info("Payment_09: Step 03 - Input to 'Account Number' textbox ");
			deleteAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", eachAccount);

			log.info("Payment_09: Step 04 - Click to Submit button");
			deleteAccountPage.clickToDynamicButton(driver, "AccSubmit");

			log.info("Payment_09: Step 04 - Verify 'Do you really want to delete this Account?' alert displayed");
			if (!driver.toString().toLowerCase().contains("internet explorer")) {
				verifyEquals(deleteAccountPage.getTextAnyAlert(driver), "Do you really want to delete this Account?");
			}

			log.info("Payment_09: Step 05 - Accept alert");
			deleteAccountPage.acceptAnyAlert(driver);

			log.info("DeleteAccount: Step 06 - Verify 'Account Deleted Sucessfully' alert displayed");
			if (!driver.toString().toLowerCase().contains("internet explorer")) {
				verifyEquals(deleteAccountPage.getTextAnyAlert(driver), "Account Deleted Sucessfully");
			}

			log.info("Payment_09: Step 07 - Accept alert");
			deleteAccountPage.acceptAnyAlert(driver);
			homePage = PageFactoryManager.getHomePage(driver);

			log.info("Payment_09: Step 08 - Check Account does not exist anymore");
			homePage.openMultiplePage(driver, "Delete Account");
			deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);
			deleteAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", eachAccount);
			deleteAccountPage.clickToDynamicButton(driver, "AccSubmit");

			log.info("Payment_09: Step 09 - Verify 'Do you really want to delete this Account?' alert displayed");
			if (!driver.toString().toLowerCase().contains("internet explorer")) {
				verifyEquals(deleteAccountPage.getTextAlert(driver), "Do you really want to delete this Account?");
			}

			log.info("Payment_09: Step 10 - Accept alert");
			deleteAccountPage.acceptAnyAlert(driver);

			log.info("Payment_09: Step 11 - Verify 'Account does not exist?' alert displayed");
			if (!driver.toString().toLowerCase().contains("internet explorer")) {
				verifyEquals(deleteAccountPage.getTextAnyAlert(driver), "Account does not exist");
			}

			log.info("Payment_09: Step 12 - Accept alert");
			deleteAccountPage.acceptAnyAlert(driver);
			
			log.info("Payment_09: Step 13 - Click to 'Delete Account' link ");
			deleteAccountPage.openMultiplePage(driver, "Delete Account");
		}

	}

	@Test
	public void Payment_10_DeleteCustomerAndVerify() {

		log.info("Payment_10: Step 01 - Click to 'Delete Customer' link ");
		deleteAccountPage.openMultiplePage(driver, "Delete Customer");
		deleteCustomerPage = PageFactoryManager.getDeleteCustomerPage(driver);

		log.info("Payment_10: Step 02 - Input to 'Customer ID' textbox ");
		deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("Payment_10: Step 03 - Click to Submit button");
		deleteCustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_10: Step 04 - Verify 'Do you really want to delete this Customer?' alert displayed");
		if (!driver.toString().toLowerCase().contains("internet explorer")) {
			verifyEquals(deleteCustomerPage.getTextAnyAlert(driver), "Do you really want to delete this Customer?");
		}

		log.info("Payment_10: Step 05 - Accept alert");
		deleteCustomerPage.acceptAnyAlert(driver);

		log.info("Payment_10: Step 06 - Verify 'Customer deleted Successfully' alert displayed");
		if (!driver.toString().toLowerCase().contains("internet explorer")) {
			verifyEquals(deleteCustomerPage.getTextAnyAlert(driver), "Customer deleted Successfully");
		}

		log.info("Payment_10: Step 07 - Accept alert");
		deleteCustomerPage.acceptAnyAlert(driver);
		homePage = PageFactoryManager.getHomePage(driver);

		log.info("Payment_10: Step 08 - Click to 'Delete Customer' link ");
		deleteAccountPage.openMultiplePage(driver, "Delete Customer");
		deleteCustomerPage = PageFactoryManager.getDeleteCustomerPage(driver);

		log.info("Payment_10: Step 09 - Input to 'Customer ID' textbox ");
		deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("Payment_10: Step 10 - Click to Submit button");
		deleteCustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("Payment_10: Step 11 - Verify 'Do you really want to delete this Customer?' alert displayed");
		if (!driver.toString().toLowerCase().contains("internet explorer")) {
			verifyEquals(deleteCustomerPage.getTextAnyAlert(driver), "Do you really want to delete this Customer?");
		}

		log.info("Payment_10: Step 12 - Accept alert");
		deleteCustomerPage.acceptAnyAlert(driver);

		log.info("Payment_10: Step 13 - Verify 'Customer does not exist!' alert displayed");
		if (!driver.toString().toLowerCase().contains("internet explorer")) {
			verifyEquals(deleteCustomerPage.getTextAnyAlert(driver), "Customer does not exist!!");
		}

		log.info("Payment_09: Step 14 - Accept alert");
		deleteCustomerPage.acceptAnyAlert(driver);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
