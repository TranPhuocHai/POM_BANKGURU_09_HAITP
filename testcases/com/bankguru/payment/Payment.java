package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.EditAccount;
import com.bankguru.user.Common_01_RegisterToSystem;

import bankguruPageFactoryManager.PageFactoryManager;
import bankguruPageObjects.BalanceEnquiryPageObject;
import bankguruPageObjects.DeleteAccountPageObject;
import bankguruPageObjects.DeleteCustomerPageObject;
import bankguruPageObjects.DepositPageObject;
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

	private String payerAccountID;

	private String editAdress = "01 Nguyen Van Linh";
	private String editCity = "Da Nang";
	private String editState = "Ngu Hanh Son";
	private String editPin = "550000";
	private String editPhoneNumber = "0975123456";
	private String editEmail = "hai.gsd@gmail.com";

	private int intCurrentAmount = 50000;
	private int intDepositAmount = 5000;
	private int intAfterDeposit = intCurrentAmount + intDepositAmount;
	private int intWithdrawAmount = 15000;
	private int intAfterWithdraw = intAfterDeposit - intWithdrawAmount;
	private int intTransferAmount = 10000;
	private int intAfterTransfer = intAfterWithdraw - intTransferAmount;

	private String currentAmount = String.valueOf(intCurrentAmount);
	private String depositAmount = String.valueOf(intDepositAmount);
	private String afterDeposit = String.valueOf(intAfterDeposit);
	private String withdrawAmount = String.valueOf(intWithdrawAmount);
	private String afterWithdraw = String.valueOf(intAfterWithdraw);
	private String transferAmount = String.valueOf(intTransferAmount);
	private String afterTransfer = String.valueOf(intAfterTransfer);

	private String depositDescription = "Deposit";
	private String withdrawDescription = "Withdraw";
	private String fundTransferDescription = "Transfer";

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

		log.info("CreateNewCustomer: Step 01 - Click to 'New Customer' link");
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

		log.info("CreateNewCustomer: Step 02 - Input to 'Customer Name' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "name", name);

		log.info("CreateNewCustomer: Step 03 - Select Male gender");
		newCustomerPage.checkToDynamicCheckboxOrRadioButton(driver, "m");

		log.info("CreateNewCustomer: Step 04 - Remove 'type' attribute of Date of Birth textbox");
		newCustomerPage.removeAtrributeDynamicTextbox(driver, "dob", "type");

		log.info("CreateNewCustomer: Step 05 - Input to 'Date Of Birth' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "dob", dateOfBirth);

		log.info("CreateNewCustomer: Step 06 - Input to 'Adress' text area");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", address);

		log.info("CreateNewCustomer: Step 07 - Input to 'City' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", city);

		log.info("CreateNewCustomer: Step 08 - Input to 'State' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", state);

		log.info("CreateNewCustomer: Step 09 - Input to 'Pin' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", pin);

		log.info("CreateNewCustomer: Step 10 - Input to 'Mobile Number' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", mobileNumber);

		log.info("CreateNewCustomer: Step 11 - Input to 'Email' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", email);

		log.info("CreateNewCustomer: Step 12 - Input to 'Password' textbox");
		newCustomerPage.inputToDynamicTextboxOrTextArea(driver, "password", password);

		log.info("CreateNewCustomer: Step 13 - Click to 'Submit' button");
		newCustomerPage.clickToDynamicButton(driver, "sub");

		log.info("CreateNewCustomer: Step 14 - Verify title 'Customer Registered Successfully!!!' displayed");
		verifyTrue(newCustomerPage.isDynamicPageTitleDisplayed(driver, "Customer Registered Successfully!!!"));

		log.info("CreateNewCustomer: Step 15 - Get 'Customer ID'");
		customerID = newCustomerPage.getTextDynamicTableInfo(driver, "Customer ID");

		log.info("CreateNewCustomer: Step 16 - Verify all infor of new customer are correct");
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

		log.info("EditCustomer: Step 01 - Click to 'Delete Customer' link");
		newCustomerPage.openMultiplePage(driver, "Edit Customer");
		editcustomerPage = PageFactoryManager.getEditCustomerPage(driver);

		log.info("EditCustomer: Step 02 - Input to 'Customer ID' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("EditCustomer: Step 03 - Click to Submit textbox");
		editcustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("EditCustomer: Step 04 - Verify all infor of Customer are correct before starting edit");
		verifyTrue(editcustomerPage.isCorrectInforOfDynamicTextbox(driver, "name", name));
		verifyTrue(editcustomerPage.isCorrectInforOfDynamicTextbox(driver, "gender", gender));
		verifyTrue(editcustomerPage.isCorrectInforOfDynamicTextbox(driver, "dob", dateOfBirth));
		verifyTrue(editcustomerPage.isCorrectInforOfDynamicTextArea(driver, "addr", address));
		verifyTrue(editcustomerPage.isCorrectInforOfDynamicTextbox(driver, "city", city));
		verifyTrue(editcustomerPage.isCorrectInforOfDynamicTextbox(driver, "state", state));
		verifyTrue(editcustomerPage.isCorrectInforOfDynamicTextbox(driver, "pinno", pin));
		verifyTrue(editcustomerPage.isCorrectInforOfDynamicTextbox(driver, "telephoneno", mobileNumber));
		verifyTrue(editcustomerPage.isCorrectInforOfDynamicTextbox(driver, "emailid", email));

		log.info("EditCustomer: Step 05 - Clear 'Address' Text Area");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");

		log.info("EditCustomer: Step 06 - Input to 'Address' Text Area");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", editAdress);

		log.info("EditCustomer: Step 07 - Clear 'City' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "city");

		log.info("EditCustomer: Step 08 - Input to 'City' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", editCity);

		log.info("EditCustomer: Step 09 - Clear 'State' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "state");

		log.info("EditCustomer: Step 10 - Input to 'State' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", editState);

		log.info("EditCustomer: Step 11 - Clear 'PIN' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");

		log.info("EditCustomer: Step 12 - Input to 'PIN' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", editPin);

		log.info("EditCustomer: Step 13 - Clear 'Mobile Number' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");

		log.info("EditCustomer: Step 14 - Input to 'Mobile Number' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", editPhoneNumber);

		log.info("EditCustomer: Step 15 - Clear 'Email' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");

		log.info("EditCustomer: Step 16 - Input to 'Email' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", editEmail);

		log.info("EditCustomer: Step 17 - Click to Submit button");
		editcustomerPage.clickToDynamicButton(driver, "sub");

		log.info("EditCustomer: Step 18 - Verify 'Customer details updated Successfully!!!' message displayed");
		verifyTrue(editcustomerPage.isDynamicPageTitleDisplayed(driver, "Customer details updated Successfully!!!"));

		log.info("EditCustomer: Step 19 - Verify all infor of edit customer are correct");
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
	public void Payment_03_AddNewAccount() {

		log.info("AddNewAccount: Step 01 - Click to 'New Account' link");
		editcustomerPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);

		log.info("AddNewAccount: Step 02 - Input to 'Customer id' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("AddNewAccount: Step 03 - Select 'Current' in 'Account type' dropdown");
		newAccountPage.selectItemInDynamicDropdown(driver, "selaccount", "Current");

		log.info("AddNewAccount: Step 04 - Input to 'Initial deposit' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", currentAmount);

		log.info("AddNewAccount: Step 05 - Click to Submit button");
		newAccountPage.clickToDynamicButton(driver, "button2");

		log.info("AddNewAccount: Step 06 - Verify 'Account Generated Successfully' message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Account Generated Successfully!!!"));

		log.info("AddNewAccount: Step 07 - Get Account ID infor");
		payerAccountID = newAccountPage.getTextDynamicTableInfo(driver, "Account ID");

		log.info("AddNewAccount: Step 08 - Verify all infor are correct");
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Customer Name"), name);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Account Type"), "Current");
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Date of Opening"), TodayYYYYMMdd());
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Current Amount"), currentAmount);

	}

	@Test
	public void Payment_04_TransferMoneyToCurrentAccount() {

		log.info("TransferMoneyToCurrentAccount: Step 01 - Click to 'Deposit' link ");
		newAccountPage.openMultiplePage(driver, "Deposit");
		depositPage = PageFactoryManager.getDepositPage(driver);

		log.info("TransferMoneyToCurrentAccount: Step 02 - Verify Amount Deposit form displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Amount Deposit Form"));

		log.info("TransferMoneyToCurrentAccount: Step 03 - Input to 'Account Number' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", payerAccountID);

		log.info("TransferMoneyToCurrentAccount: Step 04 - Input to 'Amount' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "ammount", depositAmount);

		log.info("TransferMoneyToCurrentAccount: Step 05 - Input to 'Description' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "desc", depositDescription);

		log.info("TransferMoneyToCurrentAccount: Step 06 - Click to Submit button");
		depositPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TransferMoneyToCurrentAccount: Step 07 - Verify Tracsaction Details message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, ("Transaction details of Deposit for Account " + payerAccountID)));

		log.info("TransferMoneyToCurrentAccount: Step 08 - Verify Current Balance and all infor are correct");
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Current Balance"), afterDeposit);
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Account No"), payerAccountID);
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Amount Credited"), depositAmount);
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Type of Transaction"), "Deposit");
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Description"), depositDescription);

	}

	@Test
	public void Payment_05_WithdrawFromCurrentAccount() {

		log.info("WithdrawFromCurrentAccount: Step 01 - Click to 'Withdrawal' link ");
		depositPage.openMultiplePage(driver, "Withdrawal");
		withdrawalPage = PageFactoryManager.getWithdrawalPage(driver);

		log.info("WithdrawFromCurrentAccount: Step 02 - Verify Amount Withdraw form displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Amount Withdrawal Form"));

		log.info("WithdrawFromCurrentAccount: Step 03 - Input to 'Account Number' textbox");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "accountno", payerAccountID);

		log.info("WithdrawFromCurrentAccount: Step 04 - Input to 'Amount' textbox");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "ammount", withdrawAmount);

		log.info("WithdrawFromCurrentAccount: Step 05 - Input to 'Description' textbox");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "desc", withdrawDescription);

		log.info("WithdrawFromCurrentAccount: Step 06 - Click to Submit button");
		withdrawalPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("WithdrawFromCurrentAccount: Step 07 - Verify Tracsaction Details message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, ("Transaction details of Withdrawal for Account " + payerAccountID)));

		log.info("TransferMoneyToCurrentAccount: Step 08 - Verify Current Balance and all infors are correct");
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Current Balance"), afterWithdraw);
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Account No"), payerAccountID);
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Amount Debited"), withdrawAmount);
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Type of Transaction"), "Withdrawal");
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Description"), withdrawDescription);

	}

	@Test
	public void Payment_06_TransferMoney() {

		log.info("TransferMoney: Step 01 - Click to 'Fund Transfer' link ");
		withdrawalPage.openMultiplePage(driver, "Fund Transfer");
		fundTransferPage = PageFactoryManager.getFundTransferPage(driver);

		log.info("TransferMoney: Step 02 - Input to 'Payers Account Number' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payersaccount", payerAccountID);

		log.info("TransferMoney: Step 03 - Input to 'Payees Account Number' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payeeaccount", EditAccount.ACCOUNT_ID);

		log.info("TransferMoney: Step 04 - Input to 'Amount' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "ammount", transferAmount);

		log.info("TransferMoney: Step 05 - Input to 'Description' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "desc", fundTransferDescription);

		log.info("TransferMoney: Step 06 - Click to Submit button");
		fundTransferPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TransferMoney: Step 07 - Verify FundTransfer Details message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Fund Transfer Details"));

		log.info("TransferMoney: Step 08 - Verify Payers Account is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "From Account Number"), payerAccountID);

		log.info("TransferMoney: Step 09 - Verify Payees Account is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "To Account Number"), EditAccount.ACCOUNT_ID);

		log.info("TransferMoney: Step 10 - Verify Transferred amount is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "Amount"), transferAmount);

		log.info("TransferMoney: Step 11 - Verify Description is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "Description"), fundTransferDescription);

	}

	@Test
	public void Payment_07_BalanceEnquiry() {

		log.info("BalanceEnquiry: Step 01 - Click to 'Balance Enquiry' link ");
		fundTransferPage.openMultiplePage(driver, "Balance Enquiry");
		balanceEnquiryPage = PageFactoryManager.getBalanceEnquiryPage(driver);

		log.info("BalanceEnquiry: Step 02 - Verify Balance Enquiry Form message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Balance Enquiry Form"));

		log.info("BalanceEnquiry: Step 02 - Input to 'Account Number' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "accountno", payerAccountID);

		log.info("BalanceEnquiry: Step 03 - Click to Submit button");
		balanceEnquiryPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("BalanceEnquiry: Step 04 - Verify Balance Details message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, ("Balance Details for Account " + payerAccountID)));

		log.info("BalanceEnquiry: Step 05 - Verify current balance after Transferring is correct");
		verifyEquals(balanceEnquiryPage.getTextDynamicTableInfo(driver, "Balance"), afterTransfer);

		log.info("BalanceEnquiry: Step 05 - Verify Account Number and Type of Account are correct");
		verifyEquals(balanceEnquiryPage.getTextDynamicTableInfo(driver, "Account No"), payerAccountID);
		verifyEquals(balanceEnquiryPage.getTextDynamicTableInfo(driver, "Type of Account"), "Current");

	}

	@Parameters("browser")
	@Test
	public void Payment_08_DeleteAccount(String browserName) {

		log.info("DeleteAccount: Step 01 - Click to 'Delete Account' link ");
		balanceEnquiryPage.openMultiplePage(driver, "Delete Account");
		deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);

		log.info("DeleteAccount: Step 02 - Verify Delete Account Form message displayed");
		verifyTrue(deleteAccountPage.isDynamicPageTitleDisplayed(driver, "Delete Account Form"));

		log.info("DeleteAccount: Step 03 - Input to 'Account Number' textbox ");
		deleteAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", payerAccountID);

		log.info("DeleteAccount: Step 04 - Click to Submit button");
		deleteAccountPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("DeleteAccount: Step 04 - Verify 'Do you really want to delete this Account?' alert displayed");
		if (!browserName.equals("ie")) {
			verifyEquals(deleteAccountPage.getTextAnyAlert(driver), "Do you really want to delete this Account?");

		}

		log.info("DeleteAccount: Step 05 - Accept alert");
		deleteAccountPage.acceptAnyAlert(driver);

		log.info("DeleteAccount: Step 06 - Verify 'Account Deleted Sucessfully' alert displayed");
		if (!browserName.equals("ie")) {
			verifyEquals(deleteAccountPage.getTextAnyAlert(driver), "Account Deleted Sucessfully");

		}

		log.info("DeleteAccount: Step 07 - Accept alert");
		deleteAccountPage.acceptAnyAlert(driver);
		homePage = PageFactoryManager.getHomePage(driver);
		
		log.info("DeleteAccount: Step 08 - Check Account does not exist anymore");
		homePage.openMultiplePage(driver, "Delete Account");
		deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);
		
		deleteAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", payerAccountID);
		deleteAccountPage.clickToDynamicButton(driver, "AccSubmit");
		
		log.info("DeleteAccount: Step 09 - Verify 'Do you really want to delete this Account?' alert displayed");
		if (!browserName.equals("ie")) {
			verifyEquals(deleteAccountPage.getTextAlert(driver), "Do you really want to delete this Account?");
			
		}
		
		log.info("DeleteAccount: Step 10 - Accept alert");
		deleteAccountPage.acceptAnyAlert(driver);
		
		
		log.info("DeleteAccount: Step 11 - Verify 'Account does not exist?' alert displayed");
		if (!browserName.equals("ie")) {
			verifyEquals(deleteAccountPage.getTextAnyAlert(driver), "Account does not exist");

		}
		
		log.info("DeleteAccount: Step 12 - Accept alert");
		deleteAccountPage.acceptAnyAlert(driver);
		

	}

	@Parameters("browser")
	@Test
	public void Payment_09_DeleteCustomer(String browserName) {

		log.info("DeleteCustomer: Step 01 - Click to 'Delete Customer' link ");
		deleteAccountPage.openMultiplePage(driver, "Delete Customer");
		deleteCustomerPage = PageFactoryManager.getDeleteCustomerPage(driver);

		log.info("DeleteCustomer: Step 02 - Input to 'Customer ID' textbox ");
		deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("DeleteCustomer: Step 03 - Click to Submit button");
		deleteCustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("DeleteCustomer: Step 04 - Verify 'Do you really want to delete this Customer?' alert displayed");
		if (!browserName.equals("ie")) {
			verifyEquals(deleteCustomerPage.getTextAnyAlert(driver), "Do you really want to delete this Customer?");

		}

		log.info("DeleteCustomer: Step 05 - Accept alert");
		deleteCustomerPage.acceptAnyAlert(driver);

		log.info("DeleteCustomer: Step 06 - Verify 'Customer deleted Successfully' alert displayed");
		if (!browserName.equals("ie")) {
			verifyEquals(deleteCustomerPage.getTextAnyAlert(driver), "Customer deleted Successfully");

		}

		log.info("DeleteCustomer: Step 07 - Accept alert");
		deleteCustomerPage.acceptAnyAlert(driver);
		homePage = PageFactoryManager.getHomePage(driver);
		
		log.info("DeleteCustomer: Step 08 - Click to 'Delete Customer' link ");
		deleteAccountPage.openMultiplePage(driver, "Delete Customer");
		deleteCustomerPage = PageFactoryManager.getDeleteCustomerPage(driver);

		log.info("DeleteCustomer: Step 09 - Input to 'Customer ID' textbox ");
		deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", customerID);

		log.info("DeleteCustomer: Step 10 - Click to Submit button");
		deleteCustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("DeleteCustomer: Step 11 - Verify 'Do you really want to delete this Customer?' alert displayed");
		if (!browserName.equals("ie")) {
			verifyEquals(deleteCustomerPage.getTextAnyAlert(driver), "Do you really want to delete this Customer?");
			
		}
		
		log.info("DeleteCustomer: Step 12 - Accept alert");
		deleteCustomerPage.acceptAnyAlert(driver);
		
		log.info("DeleteCustomer: Step 13 - Verify 'Customer does not exist!' alert displayed");
		if (!browserName.equals("ie")) {
			verifyEquals(deleteCustomerPage.getTextAnyAlert(driver), "Customer does not exist!!");

		}

		log.info("DeleteCustomer: Step 14 - Accept alert");
		deleteCustomerPage.acceptAnyAlert(driver);
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
