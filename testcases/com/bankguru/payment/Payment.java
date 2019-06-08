package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.EditAccount;
import com.bankguru.customer.Common_02_CreateNewCustomer;
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
import bankguruPageObjects.WithdrawalPageObject;
import commons.AbstractTest;

public class Payment extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private EditCustomerPageObject editcustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private WithdrawalPageObject withdrawalPage;
	private FundTransferPageObject fundTransferPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;

	private String PayerAccountID;

	private String editAdress = "01 Nguyen Van Linh";
	private String editCity = "Da Nang";
	private String editState = "Ngu Hanh Son";
	private String editPin = "550000";
	private String editPhoneNumber = "0975123456";
	private String editEmailID = "hai.gsd@gmail.com";

	private int currentAmount = 50000;
	private int depositAmount = 5000;
	private int currentBalanceAfterDeposit = currentAmount + depositAmount;
	private int withdrawAmount = 15000;
	private int currentBalanceAfterWithdraw = currentBalanceAfterDeposit - withdrawAmount;
	private int transferAmount = 10000;
	private int currentBalanceAfterTransfer = currentBalanceAfterWithdraw - transferAmount;

	private String depositDescription = "Deposit";
	private String withdrawDescription = "Withdraw";
	private String fundTransferDescription = "Transfer";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);

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
	public void PM_01_EditCustomer() {

		log.info("EditCustomer: Step 01 - Click to 'Delete Customer' link");
		homePage.openMultiplePage(driver, "Edit Customer");
		editcustomerPage = PageFactoryManager.getEditCustomerPage(driver);

		log.info("EditCustomer: Step 02 - Input to 'Customer ID' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", Common_02_CreateNewCustomer.CUSTOMER_ID);

		log.info("EditCustomer: Step 03 - Click to Submit textbox");
		editcustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("EditCustomer: Step 04 - Clear 'Address' Text Area");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "addr");

		log.info("EditCustomer: Step 05 - Input to 'Address' Text Area");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "addr", editAdress);

		log.info("EditCustomer: Step 06 - Clear 'City' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "city");

		log.info("EditCustomer: Step 07 - Input to 'City' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "city", editCity);

		log.info("EditCustomer: Step 08 - Clear 'State' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "state");

		log.info("EditCustomer: Step 09 - Input to 'State' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "state", editState);

		log.info("EditCustomer: Step 10 - Clear 'PIN' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "pinno");

		log.info("EditCustomer: Step 11 - Input to 'PIN' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "pinno", editPin);

		log.info("EditCustomer: Step 12 - Clear 'Mobile Number' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "telephoneno");

		log.info("EditCustomer: Step 13 - Input to 'Mobile Number' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "telephoneno", editPhoneNumber);

		log.info("EditCustomer: Step 14 - Clear 'Email' textbox");
		editcustomerPage.clearDynamicTextboxOrTextArea(driver, "emailid");

		log.info("EditCustomer: Step 15 - Input to 'Email' textbox");
		editcustomerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", editEmailID);

		log.info("EditCustomer: Step 16 - Click to Submit button");
		editcustomerPage.clickToDynamicButton(driver, "sub");

		log.info("EditCustomer: Step 17 - Verify 'Customer details updated Successfully!!!' message displayed");
		verifyTrue(editcustomerPage.isDynamicPageTitleDisplayed(driver, "Customer details updated Successfully!!!"));

		log.info("EditCustomer: Step 18 - Verify all infor of edit customer are correct");
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Customer ID"), Common_02_CreateNewCustomer.CUSTOMER_ID);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Customer Name"), Common_02_CreateNewCustomer.VALID_NAME);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Gender"), Common_02_CreateNewCustomer.EXPECTED_GENDER);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Birthdate"), Common_02_CreateNewCustomer.VALID_DOB);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Address"), editAdress);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "City"), editCity);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "State"), editState);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Pin"), editPin);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Mobile No."), editPhoneNumber);
		verifyEquals(editcustomerPage.getTextDynamicTableInfo(driver, "Email"), editEmailID);

	}

	@Test
	public void PM_02_AddNewAccount() {

		log.info("AddNewAccount: Step 01 - Click to 'New Account' link");
		editcustomerPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);

		log.info("AddNewAccount: Step 02 - Input to 'Customer id' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "cusid", Common_02_CreateNewCustomer.CUSTOMER_ID);

		log.info("AddNewAccount: Step 03 - Select 'Current' in 'Account type' dropdown");
		newAccountPage.selectItemInDynamicDropdown(driver, "selaccount", "Current");

		log.info("AddNewAccount: Step 04 - Input to 'Initial deposit' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "inideposit", String.valueOf(currentAmount));

		log.info("AddNewAccount: Step 05 - Click to Submit button");
		newAccountPage.clickToDynamicButton(driver, "button2");

		log.info("AddNewAccount: Step 06 - Verify 'Account Generated Successfully' message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Account Generated Successfully!!!"));

		log.info("AddNewAccount: Step 07 - Verify Current amount is correct");
		verifyEquals(newAccountPage.getTextDynamicTableInfo(driver, "Current Amount"), String.valueOf(currentAmount));

		log.info("AddNewAccount: Step 08 - Get Account ID infor");
		PayerAccountID = newAccountPage.getTextDynamicTableInfo(driver, "Account ID");
	}

	@Test
	public void PM_03_TransferMoneyToCurrentAccount() {

		log.info("TransferMoneyToCurrentAccount: Step 01 - Click to 'Deposit' link ");
		newAccountPage.openMultiplePage(driver, "Deposit");
		depositPage = PageFactoryManager.getDepositPage(driver);

		log.info("TransferMoneyToCurrentAccount: Step 02 - Verify Amount Deposit form displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Amount Deposit Form"));

		log.info("TransferMoneyToCurrentAccount: Step 03 - Input to 'Account Number' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", PayerAccountID);

		log.info("TransferMoneyToCurrentAccount: Step 04 - Input to 'Amount' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "ammount", String.valueOf(depositAmount));

		log.info("TransferMoneyToCurrentAccount: Step 05 - Input to 'Description' textbox");
		newAccountPage.inputToDynamicTextboxOrTextArea(driver, "desc", depositDescription);

		log.info("TransferMoneyToCurrentAccount: Step 07 - Click to Submit button");
		depositPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TransferMoneyToCurrentAccount: Step 08 - Verify Tracsaction Details message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, ("Transaction details of Deposit for Account " + PayerAccountID)));

		log.info("TransferMoneyToCurrentAccount: Step 09 - Verify Current Balance is correct");
		verifyEquals(depositPage.getTextDynamicTableInfo(driver, "Current Balance"), String.valueOf(currentBalanceAfterDeposit));

	}

	@Test
	public void PM_04_WithdrawFromCurrentAccount() {

		log.info("WithdrawFromCurrentAccount: Step 01 - Click to 'Withdrawal' link ");
		depositPage.openMultiplePage(driver, "Withdrawal");
		withdrawalPage = PageFactoryManager.getWithdrawalPage(driver);

		log.info("WithdrawFromCurrentAccount: Step 02 - Verify Amount Withdraw form displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Amount Withdrawal Form"));

		log.info("WithdrawFromCurrentAccount: Step 03 - Input to 'Account Number' textbox");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "accountno", PayerAccountID);

		log.info("WithdrawFromCurrentAccount: Step 04 - Input to 'Amount' textbox");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "ammount", String.valueOf(withdrawAmount));

		log.info("WithdrawFromCurrentAccount: Step 05 - Input to 'Description' textbox");
		withdrawalPage.inputToDynamicTextboxOrTextArea(driver, "desc", withdrawDescription);

		log.info("WithdrawFromCurrentAccount: Step 06 - Click to Submit button");
		withdrawalPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("WithdrawFromCurrentAccount: Step 07 - Verify Tracsaction Details message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, ("Transaction details of Withdrawal for Account " + PayerAccountID)));

		log.info("TransferMoneyToCurrentAccount: Step 08 - Verify Current Balance is correct");
		verifyEquals(withdrawalPage.getTextDynamicTableInfo(driver, "Current Balance"), String.valueOf(currentBalanceAfterWithdraw));

	}

	@Test
	public void PM_05_TransferMoney() {

		log.info("TransferMoney: Step 01 - Click to 'Fund Transfer' link ");
		withdrawalPage.openMultiplePage(driver, "Fund Transfer");
		fundTransferPage = PageFactoryManager.getFundTransferPage(driver);

		log.info("TransferMoney: Step 02 - Input to 'Payers Account Number' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payersaccount", PayerAccountID);

		log.info("TransferMoney: Step 03 - Input to 'Payees Account Number' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "payeeaccount", EditAccount.ACCOUNT_ID);

		log.info("TransferMoney: Step 04 - Input to 'Amount' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "ammount", String.valueOf(transferAmount));

		log.info("TransferMoney: Step 05 - Input to 'Description' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "desc", fundTransferDescription);

		log.info("TransferMoney: Step 06 - Click to Submit button");
		fundTransferPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("TransferMoney: Step 07 - Verify FundTransfer Details message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Fund Transfer Details"));

		log.info("TransferMoney: Step 08 - Verify Payers Account is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "From Account Number"), PayerAccountID);

		log.info("TransferMoney: Step 09 - Verify Payees Account is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "To Account Number"), EditAccount.ACCOUNT_ID);

		log.info("TransferMoney: Step 10 - Verify Transferred amount is correct");
		verifyEquals(fundTransferPage.getTextDynamicTableInfo(driver, "Amount"), String.valueOf(transferAmount));

	}

	@Test
	public void PM_06_BalanceEnquiry() {

		log.info("BalanceEnquiry: Step 01 - Click to 'Balance Enquiry' link ");
		fundTransferPage.openMultiplePage(driver, "Balance Enquiry");
		balanceEnquiryPage = PageFactoryManager.getBalanceEnquiryPage(driver);

		log.info("BalanceEnquiry: Step 02 - Verify Balance Enquiry Form message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Balance Enquiry Form"));

		log.info("BalanceEnquiry: Step 02 - Input to 'Account Number' textbox ");
		fundTransferPage.inputToDynamicTextboxOrTextArea(driver, "accountno", PayerAccountID);

		log.info("BalanceEnquiry: Step 03 - Click to Submit button");
		balanceEnquiryPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("BalanceEnquiry: Step 04 - Verify Balance Details message displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, ("Balance Details for Account " + PayerAccountID)));

		log.info("BalanceEnquiry: Step 05 - Verify current balance after Transferring is correct");
		verifyEquals(balanceEnquiryPage.getTextDynamicTableInfo(driver, "Balance"), String.valueOf(currentBalanceAfterTransfer));

	}

	@Parameters("browser")
	@Test
	public void PM_07_DeleteAccount(String browserName) {
		String[] allAccountIDs = {PayerAccountID, EditAccount.ACCOUNT_ID };

		log.info("DeleteAccount: Step 01 - Click to 'Delete Account' link ");
		balanceEnquiryPage.openMultiplePage(driver, "Delete Account");
		deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);

		for (String eachAccountID : allAccountIDs) {

			log.info("DeleteAccount: Step 02 - Verify Delete Account Form message displayed");
			verifyTrue(deleteAccountPage.isDynamicPageTitleDisplayed(driver, "Delete Account Form"));

			log.info("DeleteAccount: Step 03 - Input to 'Account Number' textbox ");
			deleteAccountPage.inputToDynamicTextboxOrTextArea(driver, "accountno", eachAccountID);

			log.info("DeleteAccount: Step 04 - Click to Submit button");
			deleteAccountPage.clickToDynamicButton(driver, "AccSubmit");

			log.info("DeleteAccount: Step 04 - Verify 'Do you really want to delete this Account?' alert displayed");
			if (!browserName.equals("ie") ) {
				verifyEquals(deleteAccountPage.getTextConfirmDeleteAlert(), "Do you really want to delete this Account?");
				
			}

			log.info("DeleteAccount: Step 05 - Accept alert");
			deleteAccountPage.acceptConfirmDeleteAccountAlert();

			log.info("DeleteAccount: Step 06 - Verify 'Account Deleted Sucessfully' alert displayed");
			if (!browserName.equals("ie") ) {
				verifyEquals(deleteAccountPage.getTextDeleteSuccessAlertAlert(), "Account Deleted Sucessfully");
				
			}

			log.info("DeleteAccount: Step 07 - Accept alert");
			homePage = deleteAccountPage.acceptDeleteSuccessAlert();

			log.info("DeleteAccount: Step 08 - Click to 'Delete Account' link ");
			homePage.openMultiplePage(driver, "Delete Account");
			deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);
		}

	}

	@Parameters("browser")
	@Test
	public void PM_08_DeleteCustomer(String browserName) {

		log.info("DeleteCustomer: Step 01 - Click to 'Delete Customer' link ");
		homePage.openMultiplePage(driver, "Delete Customer");
		deleteCustomerPage = PageFactoryManager.getDeleteCustomerPage(driver);

		log.info("DeleteCustomer: Step 02 - Input to 'Customer ID' textbox ");
		deleteCustomerPage.inputToDynamicTextboxOrTextArea(driver, "cusid", Common_02_CreateNewCustomer.CUSTOMER_ID);

		log.info("DeleteCustomer: Step 03 - Click to Submit button");
		deleteCustomerPage.clickToDynamicButton(driver, "AccSubmit");

		log.info("DeleteCustomer: Step 04 - Verify 'Do you really want to delete this Customer?' alert displayed");
		if (!browserName.equals("ie") ) {
			verifyEquals(deleteCustomerPage.getTextConfirmDeleteAlert(), "Do you really want to delete this Customer?");
			
		}

		log.info("DeleteCustomer: Step 05 - Accept alert");
		deleteCustomerPage.acceptConfirmDeleteAlert();

		log.info("DeleteCustomer: Step 06 - Verify 'Customer deleted Successfully' alert displayed");
		if (!browserName.equals("ie") ) {
			verifyEquals(deleteCustomerPage.getTextDeleteSuccessAlertAlert(), "Customer deleted Successfully");
			
		}

		log.info("DeleteCustomer: Step 07 - Accept alert");
		homePage = deleteCustomerPage.acceptDeleteSuccessAlert();

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
