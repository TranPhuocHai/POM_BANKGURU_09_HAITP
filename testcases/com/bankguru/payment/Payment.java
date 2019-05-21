package com.bankguru.payment;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import pageObjects.WithdrawPageObject;

public class Payment extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editcustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private WithdrawPageObject withdrawPage;
	private FundTransferPageObject fundTransferPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;

	private String loginPageUrl, userIdInfo, passwordInfo, customerID, accountID, payeeAccountID;

	private String email = "tpkcdnam" + randomNumber() + "@gmail.com";
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

		loginPage = PageFactoryManager.getLoginPage(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inPutToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		userIdInfo = registerPage.getUserIDInfor();
		passwordInfo = registerPage.getPasswordInfor();
		loginPage = registerPage.openLoginPage(loginPageUrl);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inPutToUserIDTextbox(userIdInfo);
		loginPage.inPutToPasswordTextbox(passwordInfo);
		homePage = loginPage.clickToLoginButton();
		homePage.isWelcomeMessageDisplayed();
		homePage.isUserIDDisplayed(userIdInfo);
		newCustomerPage = homePage.openNewCutomerPage(driver);

	}

	@Test
	public void PM_01_CreateNewCustomer() {
		newCustomerPage.inputValidDataToCustomerNameTextbox(validName);
		newCustomerPage.selectMaleGenderRadioButton();
		newCustomerPage.removeDateOfBirthAttribute();
		newCustomerPage.inputValidDataToDateOfBirthTextbox(validDateOfBirth);
		newCustomerPage.inputValidDataToAdressTextArea(validAdress);
		newCustomerPage.inputValidDataToCityTextbox(validCity);
		newCustomerPage.inputValidDataToStateTextbox(validState);
		newCustomerPage.inputValidDataToPinTextbox(validPin);
		newCustomerPage.inputValidDataToMobileNumberTextbox(validPhoneNumber);
		newCustomerPage.inputValidDataToEmailTextbox(validEmailID);
		newCustomerPage.inputValidDataToPasswordTextbox(validPassword);
		newCustomerPage.clickToSubmitButton();
		newCustomerPage.isCustomerRegisteredSuccessfullyDisplayed();
		customerID = newCustomerPage.getCustomerID();

		Assert.assertEquals(newCustomerPage.getTextCustomerNameInfo(), validName);
		Assert.assertEquals(newCustomerPage.getTextGenderInfo(), expectedGender);
		Assert.assertEquals(newCustomerPage.getDateOfBirthInfo(), validDateOfBirth);
		Assert.assertEquals(newCustomerPage.getTextAdressInfo(), validAdress);
		Assert.assertEquals(newCustomerPage.getTextCityInfo(), validCity);
		Assert.assertEquals(newCustomerPage.getTextStateInfo(), validState);
		Assert.assertEquals(newCustomerPage.getTextPinInfo(), validPin);
		Assert.assertEquals(newCustomerPage.getTextMobileNumberInfo(), validPhoneNumber);
		Assert.assertEquals(newCustomerPage.getTextEmailInfo(), validEmailID);
	}

	@Test
	public void PM_02_EditNewCustomer() {
		editcustomerPage = newCustomerPage.openEditCutomerPage(driver);
		editcustomerPage.inputCustomerIDToCustomerIDTextbox(customerID);
		editcustomerPage.clicktoSubmitCustomerIDButton();

		editcustomerPage.clearAdressTextArea();
		editcustomerPage.inputValidDataToAdressTextArea(editAdress);
		editcustomerPage.clearCityTextbox();
		editcustomerPage.inputValidDataToCityTextbox(editCity);
		editcustomerPage.clearStateTextbox();
		editcustomerPage.inputValidDataToStateTextbox(editState);
		editcustomerPage.clearPinTextbox();
		editcustomerPage.inputValidDataToPinTextbox(editPin);
		editcustomerPage.clearPhoneTextbox();
		editcustomerPage.inputValidDataToMobileNumberTextbox(editPhoneNumber);
		editcustomerPage.clearEmailTextbox();
		editcustomerPage.inputValidDataToEmailTextbox(editEmailID);
		editcustomerPage.clickToSubmitButton();

		Assert.assertEquals(editcustomerPage.getTextCustomerIDInfo(), customerID);
		Assert.assertEquals(editcustomerPage.getTextCustomerNameInfo(), validName);
		Assert.assertEquals(editcustomerPage.getTextGenderInfo(), expectedGender);
		Assert.assertEquals(editcustomerPage.getDateOfBirthInfo(), validDateOfBirth);
		Assert.assertEquals(editcustomerPage.getTextEditAdressInfo(), editAdress);
		Assert.assertEquals(editcustomerPage.getTextEditCityInfo(), editCity);
		Assert.assertEquals(editcustomerPage.getTextEditStateInfo(), editState);
		Assert.assertEquals(editcustomerPage.getTextEditPinInfo(), editPin);
		Assert.assertEquals(editcustomerPage.getTextEditMobileNumberInfo(), editPhoneNumber);
		Assert.assertEquals(editcustomerPage.getTextEditEmailInfo(), editEmailID);

	}

	@Test
	public void PM_03_AddNewAccount() {
		newAccountPage = editcustomerPage.openNewAccountPage(driver);
		newAccountPage.inputCustomerIDToCustomerIDTextbox(customerID);
		newAccountPage.selectCurrentInAccountType();
		newAccountPage.inputAmountToInitialDeposit(String.valueOf(currentAmount));
		newAccountPage.clickToSubmitButton();
		Assert.assertTrue(newAccountPage.isAccountGeneratedSuccessfullyMessageDisplayed());
		Assert.assertEquals(newAccountPage.getTextCurrentAmount(), String.valueOf(currentAmount));
		accountID = newAccountPage.getAccountID();
	}

	@Test
	public void PM_04_TransferMoneyToCurrentAccount() {
		depositPage = newAccountPage.openDepositPage(driver);
		Assert.assertTrue(depositPage.isAmountDepositFormDisplayed());
		depositPage.inputAccountIDToAccountNoTextbox(accountID);
		depositPage.inputAmountToAmountTextbox(String.valueOf(depositAmount));
		depositPage.inputDescriptionToDescriptionTextbox(depositDescription);
		depositPage.clickToSubmitButton();
		Assert.assertTrue(depositPage.isCorrectTracsactionDetailsMessageDisplayed(accountID));
		Assert.assertEquals(depositPage.getTextCurrentBalance(), String.valueOf(currentBalanceAfterDeposit));

	}

	@Test
	public void PM_05_WithdrawFromCurrentAccount() {
		withdrawPage = depositPage.openWithdrawalPage(driver);
		Assert.assertTrue(withdrawPage.isAmountWithdrawFormDisplayed());
		withdrawPage.inputAccountIDToAccountNoTextbox(accountID);
		withdrawPage.inputAmountToAmountTextbox(String.valueOf(withdrawAmount));
		withdrawPage.inputDescriptionToDescriptionTextbox(withdrawDescription);
		withdrawPage.clickToSubmitButton();
		Assert.assertTrue(withdrawPage.isCorrectTracsactionDetailsMessageDisplayed(accountID));
		Assert.assertEquals(withdrawPage.getTextCurrentBalance(), String.valueOf(currentBalanceAfterWithdraw));

	}

	@Test
	public void PM_06_TransferMoney() {
		newAccountPage = withdrawPage.openNewAccountPage(driver);
		newAccountPage.inputCustomerIDToCustomerIDTextbox(customerID);
		newAccountPage.selectCurrentInAccountType();
		newAccountPage.inputAmountToInitialDeposit(String.valueOf(currentAmount));
		newAccountPage.clickToSubmitButton();
		Assert.assertTrue(newAccountPage.isAccountGeneratedSuccessfullyMessageDisplayed());
		Assert.assertEquals(newAccountPage.getTextCurrentAmount(), String.valueOf(currentAmount));
		payeeAccountID = newAccountPage.getAccountID();
		fundTransferPage = newAccountPage.openFundTransferPage(driver);
		fundTransferPage.inPutPayersAccountNumber(accountID);
		fundTransferPage.inPutPayeesAccountNumber(payeeAccountID);
		fundTransferPage.inputAmountToAmountTextbox(String.valueOf(transferAmount));
		fundTransferPage.inputDescriptionToDescriptionTextbox(fundTransferDescription);
		fundTransferPage.clickToSubmitButton();

		Assert.assertTrue(fundTransferPage.isFundTransferDetailsMessageDisplayed());
		Assert.assertEquals(fundTransferPage.getTextPayerAccountNumber(), accountID);
		Assert.assertEquals(fundTransferPage.getTextPayeeAccountNumber(), payeeAccountID);
		Assert.assertEquals(fundTransferPage.getTextAmount(), String.valueOf(transferAmount));

	}

	@Test
	public void PM_07_BalanceEnquiry() {
		balanceEnquiryPage = fundTransferPage.openBalanceEnquiryPage(driver);
		balanceEnquiryPage.inputAccountNumber(accountID);
		balanceEnquiryPage.clickSubmitButton();
		Assert.assertTrue(balanceEnquiryPage.isBalanceDetailsMessageDisplayed(accountID));
		Assert.assertEquals(balanceEnquiryPage.getTextBalance(), String.valueOf(currentBalanceAfterTransfer));

	}

	@Test
	public void PM_08_DeleteAccount() {
		deleteAccountPage = balanceEnquiryPage.openDeleteAccountPage(driver);
		deleteAccountPage.inputAccountNumber(accountID);
		deleteAccountPage.clickSubmitButton();
		Assert.assertEquals(deleteAccountPage.getTextConfirmDeleteAlert(),
				"Do you really want to delete this Account?");
		deleteAccountPage.acceptConfirmDeleteAlert();
		Assert.assertEquals(deleteAccountPage.getTextDeleteSuccessAlertAlert(), "Account Deleted Sucessfully");
		homePage = deleteAccountPage.acceptDeleteSuccessAlert();
		deleteAccountPage = homePage.openDeleteAccountPage(driver);
		deleteAccountPage.inputAccountNumber(payeeAccountID);
		deleteAccountPage.clickSubmitButton();
		Assert.assertEquals(deleteAccountPage.getTextConfirmDeleteAlert(),
				"Do you really want to delete this Account?");
		deleteAccountPage.acceptConfirmDeleteAlert();
		Assert.assertEquals(deleteAccountPage.getTextDeleteSuccessAlertAlert(), "Account Deleted Sucessfully");
		homePage = deleteAccountPage.acceptDeleteSuccessAlert();

	}

	@Test
	public void PM_09_DeleteCustomer() {
		deleteCustomerPage = homePage.openDeleteCutomerPage(driver);
		deleteCustomerPage.inputCustomerIDNumber(customerID);
		deleteCustomerPage.clickSubmitButton();
		Assert.assertEquals(deleteCustomerPage.getTextConfirmDeleteAlert(),
				"Do you really want to delete this Customer?");
		deleteCustomerPage.acceptConfirmDeleteAlert();
		Assert.assertEquals(deleteCustomerPage.getTextDeleteSuccessAlertAlert(), "Customer deleted Successfully");
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
