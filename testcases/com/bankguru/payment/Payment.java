package com.bankguru.payment;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.DeleteAccountPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.WithdrawalPageObject;

public class Payment extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editcustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private WithdrawalPageObject withdrawalPage;
	private FundTransferPageObject fundTransferPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;

	private String loginPageUrl, userIdInfo, passwordInfo, customerID, accountID, payeeAccountID;

	private String email = "tiquibanamh" + randomNumber() + "@gmail.com";
	private String validName = "Jame Hugo";
	private String expectedGender = "male";
	private String validDateOfBirth = "1988-07-31";
	private String validAdress = "100 Ho Guom";
	private String validCity = "Ha Noi";
	private String validState = "Hoan Kiem";
	private String validPin = "600000";
	private String validPhoneNumber = "0987654321";
	private String validEmailID = "jame" + randomNumber() + "@gmail.com";
	private String validPassword = "nopdontknow12";

	private String editAdress = "01 Nguyen Van Linh";
	private String editCity = "Da Nang";
	private String editState = "Ngu Hanh Son";
	private String editPin = "550000";
	private String editPhoneNumber = "0975123456";
	private String editEmailID = "redonaming" + randomNumber() + "@gmail.com";

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

		log.info("Precondition: Step 01 - open Login Page");
		loginPage = PageFactoryManager.getLoginPage(driver);

		log.info("Precondition: Step 02 - Verify Login Form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());

		log.info("Precondition: Step 03 - Get Login Page url");
		loginPageUrl = loginPage.getLoginPageUrl();

		log.info("Precondition: Step 04 - Click to 'here' link");
		registerPage = loginPage.clickToHereLink();

		log.info("Precondition: Step 05 - Verify Register Page displayed");
		verifyTrue(registerPage.isRegisterPageDisplayed());

		log.info("Precondition: Step 06 - Input to Email ID textbox");
		registerPage.inPutToEmailIDTextbox(email);

		log.info("Precondition: Step 07 - Click to Submit button");
		registerPage.clickToSubmitButton();

		log.info("Precondition: Step 08 - Get UserID and Password Infor");
		userIdInfo = registerPage.getTextDynamicInfo(driver, "User ID :");
		passwordInfo = registerPage.getTextDynamicInfo(driver, "Password :");

		log.info("Precondition: Step 09 - Open Login Page");
		loginPage = registerPage.openLoginPage(loginPageUrl);

		log.info("Precondition: Step 10 - Verify Login Form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());

		log.info("Precondition: Step 11 - Input to userID and 'Password' textboxes");
		loginPage.inPutToUserIDTextbox(userIdInfo);
		loginPage.inPutToPasswordTextbox(passwordInfo);

		log.info("Precondition: Step 11 - Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Precondition: Step 12 - Verify Welcome message of Home page displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed());

		log.info("Precondition: Step 13 - Verify User ID infor displayed");
		verifyTrue(homePage.isUserIDDisplayed(userIdInfo));

		log.info("Precondition: Step 14 - Click to New Customer link");
		homePage.openMultiplePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);

	}

	@Test
	public void PM_01_CreateNewCustomer() {

		log.info("CreateNewCustomer: Step 01 - Input to 'Customer Name' textbox");
		newCustomerPage.inputValueToCustomerNameTextbox(validName);

		log.info("CreateNewCustomer: Step 02 - Select Male gender");
		newCustomerPage.selectMaleGenderRadioButton();

		log.info("CreateNewCustomer: Step 03 - Remove Date Of Birth attribute");
		newCustomerPage.removeDateOfBirthAttribute();

		log.info("CreateNewCustomer: Step 04 - Input to 'Date Of Birth' textbox");
		newCustomerPage.inputValueToDateOfBirthTextbox(validDateOfBirth);

		log.info("CreateNewCustomer: Step 05 - Input to 'Adress' text area");
		newCustomerPage.inputValueToAdressTextArea(validAdress);

		log.info("CreateNewCustomer: Step 06 - Input to 'City' textbox");
		newCustomerPage.inputValueToCityTextbox(validCity);

		log.info("CreateNewCustomer: Step 07 - Input to 'State' textbox");
		newCustomerPage.inputValueToStateTextbox(validState);

		log.info("CreateNewCustomer: Step 08 - Input to 'Pin' textbox");
		newCustomerPage.inputValueToPinTextbox(validPin);

		log.info("CreateNewCustomer: Step 09 - Input to 'Mobile Number' textbox");
		newCustomerPage.inputValueToMobileNumberTextbox(validPhoneNumber);

		log.info("CreateNewCustomer: Step 10 - Input to 'Email' textbox");
		newCustomerPage.inputValueToEmailTextbox(validEmailID);

		log.info("CreateNewCustomer: Step 11 - Input to 'Password' textbox");
		newCustomerPage.inputValueToPasswordTextbox(validPassword);

		log.info("CreateNewCustomer: Step 12 - Click to Submit button");
		newCustomerPage.clickToSubmitButton();

		log.info("CreateNewCustomer: Step 13 - Verify 'Customer Registered Successfully!!!' message displayed");
		verifyTrue(newCustomerPage.isCustomerRegisteredSuccessfullyDisplayed());

		log.info("CreateNewCustomer: Step 14 - Get 'Customer ID'");
		customerID = newCustomerPage.getTextDynamicInfo(driver, "Customer ID");

		log.info("CreateNewCustomer: Step 15 - Verify all infor of new customer are correct");
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Customer Name"), validName);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Gender"), expectedGender);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Birthdate"), validDateOfBirth);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Address"), validAdress);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "City"), validCity);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "State"), validState);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Pin"), validPin);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Mobile No."), validPhoneNumber);
		verifyEquals(newCustomerPage.getTextDynamicInfo(driver, "Email"), validEmailID);
	}

	@Test
	public void PM_02_EditCustomer() {

		log.info("EditCustomer: Step 01 - Click to 'Delete Customer' link");
		newCustomerPage.openMultiplePage(driver, "Edit Customer");
		editcustomerPage = PageFactoryManager.getEditCustomerPage(driver);

		log.info("EditCustomer: Step 02 - Input to 'Customer ID' textbox");
		editcustomerPage.inputValueToCustomerIDTextbox(customerID);

		log.info("EditCustomer: Step 03 - Click to Submit textbox");
		editcustomerPage.clicktoSubmitCustomerIDButton();

		log.info("EditCustomer: Step 04 - Clear 'Address' Text Area");
		editcustomerPage.clearAddressTextArea();

		log.info("EditCustomer: Step 05 - Input to 'Address' Text Area");
		editcustomerPage.inputValueToAddressTextArea(editAdress);

		log.info("EditCustomer: Step 06 - Clear 'City' textbox");
		editcustomerPage.clearCityTextbox();

		log.info("EditCustomer: Step 07 - Input to 'City' textbox");
		editcustomerPage.inputValueToCityTextbox(editCity);

		log.info("EditCustomer: Step 08 - Clear 'State' textbox");
		editcustomerPage.clearStateTextbox();

		log.info("EditCustomer: Step 09 - Input to 'State' textbox");
		editcustomerPage.inputValueToStateTextbox(editState);

		log.info("EditCustomer: Step 10 - Clear 'PIN' textbox");
		editcustomerPage.clearPinTextbox();

		log.info("EditCustomer: Step 11 - Input to 'PIN' textbox");
		editcustomerPage.inputValueToPinTextbox(editPin);

		log.info("EditCustomer: Step 12 - Clear 'Mobile Number' textbox");
		editcustomerPage.clearPhoneTextbox();

		log.info("EditCustomer: Step 13 - Input to 'Mobile Number' textbox");
		editcustomerPage.inputValueToMobileNumberTextbox(editPhoneNumber);

		log.info("EditCustomer: Step 14 - Clear 'Email' textbox");
		editcustomerPage.clearEmailTextbox();

		log.info("EditCustomer: Step 15 - Input to 'Email' textbox");
		editcustomerPage.inputValueToEmailTextbox(editEmailID);

		log.info("EditCustomer: Step 16 - Click to Submit button");
		editcustomerPage.clickToSubmitButton();

		log.info("EditCustomer: Step 17 - Verify all infor of edit customer are correct");
		verifyEquals(editcustomerPage.getTextDynamicInfo(driver, "Customer ID"), customerID);
		verifyEquals(editcustomerPage.getTextDynamicInfo(driver, "Customer Name"), validName);
		verifyEquals(editcustomerPage.getTextDynamicInfo(driver, "Gender"), expectedGender);
		verifyEquals(editcustomerPage.getTextDynamicInfo(driver, "Birthdate"), validDateOfBirth);
		verifyEquals(editcustomerPage.getTextDynamicInfo(driver, "Address"), editAdress);
		verifyEquals(editcustomerPage.getTextDynamicInfo(driver, "City"), editCity);
		verifyEquals(editcustomerPage.getTextDynamicInfo(driver, "State"), editState);
		verifyEquals(editcustomerPage.getTextDynamicInfo(driver, "Pin"), editPin);
		verifyEquals(editcustomerPage.getTextDynamicInfo(driver, "Mobile No."), editPhoneNumber);
		verifyEquals(editcustomerPage.getTextDynamicInfo(driver, "Email"), editEmailID);

	}

	@Test
	public void PM_03_AddNewAccount() {

		log.info("AddNewAccount: Step 01 - Click to 'New Account' link");
		editcustomerPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);

		log.info("AddNewAccount: Step 02 - Input to 'New Account' link");
		newAccountPage.inputValueToCustomerIDTextbox(customerID);

		log.info("AddNewAccount: Step 03 - Select 'Current' in 'Account type' dropdown");
		newAccountPage.selectCurrentInAccountType();

		log.info("AddNewAccount: Step 04 - Input to 'Initial deposit' link");
		newAccountPage.inputValueToInitialDepositTextbox(String.valueOf(currentAmount));

		log.info("AddNewAccount: Step 05 - Click to Submit button");
		newAccountPage.clickToSubmitButton();

		log.info("AddNewAccount: Step 06 - Verify 'Account Generated Successfully' message displayed");
		verifyTrue(newAccountPage.isAccountGeneratedSuccessfullyMessageDisplayed());

		log.info("AddNewAccount: Step 07 - Verify Current amount is correct");
		verifyEquals(newAccountPage.getTextDynamicInfo(driver, "Current Amount"), String.valueOf(currentAmount));

		log.info("AddNewAccount: Step 08 - Get Account ID infor");
		accountID = newAccountPage.getTextDynamicInfo(driver, "Account ID");
	}

	@Test
	public void PM_04_TransferMoneyToCurrentAccount() {

		log.info("TransferMoneyToCurrentAccount: Step 01 - Click to 'Deposit' link ");
		newAccountPage.openMultiplePage(driver, "Deposit");
		depositPage = PageFactoryManager.getDepositPage(driver);

		log.info("TransferMoneyToCurrentAccount: Step 02 - Verify Amount Deposit form displayed");
		verifyTrue(depositPage.isAmountDepositFormDisplayed());

		log.info("TransferMoneyToCurrentAccount: Step 03 - Input to 'Account Number' textbox");
		depositPage.inputValueToAccountNoTextbox(accountID);

		log.info("TransferMoneyToCurrentAccount: Step 04 - Input to 'Amount' textbox");
		depositPage.inputValueToAmountTextbox(String.valueOf(depositAmount));

		log.info("TransferMoneyToCurrentAccount: Step 05 - Input to 'Description' textbox");
		depositPage.inputDescriptionToDescriptionTextbox(depositDescription);

		log.info("TransferMoneyToCurrentAccount: Step 07 - Click to Submit button");
		depositPage.clickToSubmitButton();

		log.info("TransferMoneyToCurrentAccount: Step 08 - Verify Tracsaction Details message displayed");
		verifyTrue(depositPage.isCorrectTracsactionDetailsMessageDisplayed(accountID));

		log.info("TransferMoneyToCurrentAccount: Step 09 - Verify Current Balance is correct");
		verifyEquals(depositPage.getTextDynamicInfo(driver, "Current Balance"), String.valueOf(currentBalanceAfterDeposit));

	}

	@Test
	public void PM_05_WithdrawFromCurrentAccount() {

		log.info("WithdrawFromCurrentAccount: Step 01 - Click to 'Withdrawal' link ");
		depositPage.openMultiplePage(driver, "Withdrawal");
		withdrawalPage = PageFactoryManager.getWithdrawalPage(driver);

		log.info("WithdrawFromCurrentAccount: Step 02 - Verify Amount Withdraw form displayed");
		verifyTrue(withdrawalPage.isAmountWithdrawFormDisplayed());

		log.info("WithdrawFromCurrentAccount: Step 03 - Input to 'Account Number' textbox");
		withdrawalPage.inputValueToAccountNoTextbox(accountID);

		log.info("WithdrawFromCurrentAccount: Step 04 - Input to 'Amount' textbox");
		withdrawalPage.inputAmountToAmountTextbox(String.valueOf(withdrawAmount));

		log.info("WithdrawFromCurrentAccount: Step 05 - Input to 'Description' textbox");
		withdrawalPage.inputValueToDescriptionTextbox(withdrawDescription);

		log.info("WithdrawFromCurrentAccount: Step 06 - Click to Submit button");
		withdrawalPage.clickToSubmitButton();

		log.info("WithdrawFromCurrentAccount: Step 07 - Verify Tracsaction Details message displayed");
		verifyTrue(withdrawalPage.isCorrectTracsactionDetailsMessageDisplayed(accountID));

		log.info("TransferMoneyToCurrentAccount: Step 08 - Verify Current Balance is correct");
		verifyEquals(withdrawalPage.getTextDynamicInfo(driver, "Current Balance"), String.valueOf(currentBalanceAfterWithdraw));

	}

	@Test
	public void PM_06_TransferMoney() {

		log.info("TransferMoney: Step 01 - Click to 'Withdrawal' link ");
		withdrawalPage.openMultiplePage(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccountPage(driver);

		log.info("TransferMoney: Step 02 - Create Payees Account ");
		newAccountPage.inputValueToCustomerIDTextbox(customerID);
		newAccountPage.selectCurrentInAccountType();
		newAccountPage.inputValueToInitialDepositTextbox(String.valueOf(currentAmount));
		newAccountPage.clickToSubmitButton();
		verifyTrue(newAccountPage.isAccountGeneratedSuccessfullyMessageDisplayed());
		verifyEquals(newAccountPage.getTextDynamicInfo(driver, "Current Amount"), String.valueOf(currentAmount));

		log.info("TransferMoney: Step 03 - Get Payees Account infor");
		payeeAccountID = newAccountPage.getTextDynamicInfo(driver, "Account ID");

		log.info("TransferMoney: Step 04 - Click to 'Fund Transfer' link ");
		newAccountPage.openMultiplePage(driver, "Fund Transfer");
		fundTransferPage = PageFactoryManager.getFundTransferPage(driver);

		log.info("TransferMoney: Step 04 - Input to 'Payers Account Number' textbox ");
		fundTransferPage.inPutValueToPayersAccountNumber(accountID);

		log.info("TransferMoney: Step 05 - Input to 'Payees Account Number' textbox ");
		fundTransferPage.inPutValueToPayeesAccountNumber(payeeAccountID);

		log.info("TransferMoney: Step 06 - Input to 'Amount' textbox ");
		fundTransferPage.inputAmountToAmountTextbox(String.valueOf(transferAmount));

		log.info("TransferMoney: Step 07 - Input to 'Description' textbox ");
		fundTransferPage.inputValueToDescriptionTextbox(fundTransferDescription);

		log.info("TransferMoney: Step 08 - Click to Submit button");
		fundTransferPage.clickToSubmitButton();

		log.info("TransferMoney: Step 09 - Verify FundTransfer Details message displayed");
		verifyTrue(fundTransferPage.isFundTransferDetailsMessageDisplayed());

		log.info("TransferMoney: Step 10 - Verify Payers Account is correct");
		verifyEquals(fundTransferPage.getTextDynamicInfo(driver, "From Account Number"), accountID);

		log.info("TransferMoney: Step 11 - Verify Payees Account is correct");
		verifyEquals(fundTransferPage.getTextDynamicInfo(driver, "To Account Number"), payeeAccountID);

		log.info("TransferMoney: Step 12 - Verify Transferred amount is correct");
		verifyEquals(fundTransferPage.getTextDynamicInfo(driver, "Amount"), String.valueOf(transferAmount));

	}

	@Test
	public void PM_07_BalanceEnquiry() {

		log.info("BalanceEnquiry: Step 01 - Click to 'Balance Enquiry' link ");
		fundTransferPage.openMultiplePage(driver, "Balance Enquiry");
		balanceEnquiryPage = PageFactoryManager.getBalanceEnquiryPage(driver);

		log.info("BalanceEnquiry: Step 02 - Input to 'Account Number' textbox ");
		balanceEnquiryPage.inputValueToAccountNumber(accountID);

		log.info("BalanceEnquiry: Step 03 - Click to Submit button");
		balanceEnquiryPage.clickSubmitButton();

		log.info("TransferMoney: Step 04 - Verify Balance Details message displayed");
		verifyTrue(balanceEnquiryPage.isBalanceDetailsMessageDisplayed(accountID));

		log.info("TransferMoney: Step 05 - Verify current balance after Transferring is correct");
		verifyEquals(balanceEnquiryPage.getTextDynamicInfo(driver, "Balance"), String.valueOf(currentBalanceAfterTransfer));

	}

	@Test
	public void PM_08_DeleteAccount() {
		
		log.info("DeleteAccount: Step 01 - Click to 'Delete Account' link ");
		balanceEnquiryPage.openMultiplePage(driver, "Delete Account");
		deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);

		log.info("DeleteAccount: Step 02 - Input to 'Account Number' textbox ");
		deleteAccountPage.inputValueToAccountNumberTextbox(accountID);
		
		log.info("DeleteAccount: Step 03 - Click to Submit button");
		deleteAccountPage.clickSubmitButton();
		
		log.info("DeleteAccount: Step 04 - Verify 'Do you really want to delete this Account?' alert displayed");
		verifyEquals(deleteAccountPage.getTextConfirmDeleteAlert(), "Do you really want to delete this Account?");
		
		log.info("DeleteAccount: Step 05 - Accept alert");
		deleteAccountPage.acceptConfirmDeleteAlert();
		
		log.info("DeleteAccount: Step 06 - Verify 'Account Deleted Sucessfully' alert displayed");
		verifyEquals(deleteAccountPage.getTextDeleteSuccessAlertAlert(), "Account Deleted Sucessfully");
		
		log.info("DeleteAccount: Step 07 - Accept alert");
		homePage = deleteAccountPage.acceptDeleteSuccessAlert();
		
		log.info("DeleteAccount: Step 08 - Click to 'Delete Account' link ");
		homePage.openMultiplePage(driver, "Delete Account");
		deleteAccountPage = PageFactoryManager.getDeleteAccountPage(driver);

		log.info("DeleteAccount: Step 09 - Input to 'Account Number' textbox ");
		deleteAccountPage.inputValueToAccountNumberTextbox(payeeAccountID);
		
		log.info("DeleteAccount: Step 10 - Click to Submit button");
		deleteAccountPage.clickSubmitButton();
		
		log.info("DeleteAccount: Step 11 - Verify 'Do you really want to delete this Account?' alert displayed");
		verifyEquals(deleteAccountPage.getTextConfirmDeleteAlert(), "Do you really want to delete this Account?");
		
		log.info("DeleteAccount: Step 12 - Accept alert");
		deleteAccountPage.acceptConfirmDeleteAlert();
		
		log.info("DeleteAccount: Step 3 - Verify 'Account Deleted Sucessfully' alert displayed");
		verifyEquals(deleteAccountPage.getTextDeleteSuccessAlertAlert(), "Account Deleted Sucessfully");
		
		log.info("DeleteAccount: Step 14 - Accept alert");
		homePage = deleteAccountPage.acceptDeleteSuccessAlert();

	}

	@Test
	public void PM_09_DeleteCustomer() {
		
		log.info("DeleteCustomer: Step 01 - Click to 'Delete Customer' link ");
		homePage.openMultiplePage(driver, "Delete Customer");
		deleteCustomerPage = PageFactoryManager.getDeleteCustomerPage(driver);

		log.info("DeleteCustomer: Step 02 - Input to 'Customer ID' textbox ");
		deleteCustomerPage.inputValueToCustomerIDTextbox(customerID);
		
		log.info("DeleteCustomer: Step 03 - Click to Submit button");
		deleteCustomerPage.clickSubmitButton();
		
		log.info("DeleteCustomer: Step 04 - Verify 'Do you really want to delete this Customer?' alert displayed");
		verifyEquals(deleteCustomerPage.getTextConfirmDeleteAlert(), "Do you really want to delete this Customer?");
		
		log.info("DeleteCustomer: Step 05 - Accept alert");
		deleteCustomerPage.acceptConfirmDeleteAlert();
		
		log.info("DeleteCustomer: Step 06 - Verify 'Customer deleted Successfully' alert displayed");
		verifyEquals(deleteCustomerPage.getTextDeleteSuccessAlertAlert(), "Customer deleted Successfully");
		
		log.info("DeleteCustomer: Step 07 - Accept alert");
		homePage = deleteCustomerPage.acceptDeleteSuccessAlert();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
