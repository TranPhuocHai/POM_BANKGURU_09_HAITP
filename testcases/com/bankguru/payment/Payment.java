package com.bankguru.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class Payment extends AbstractTest{
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editcustomerPage;
	NewAccountPageObject newAccountPage;
	DepositPageObject depositPage;
	WithdrawPageObject withdrawPage;
	FundTransferPageObject fundTransferPage;
	BalanceEnquiryPageObject balanceEnquiryPage;
	DeleteAccountPageObject deleteAccountPage;
	DeleteCustomerPageObject deleteCustomerPage;

	String loginPageUrl, homePageUrl, userIdInfo, passwordInfo, email;
	String validEmailID, validDateOfBirth, validName, validAdress, validCity, validState, validPin, validPhoneNumber,
			validPassword, customerID, expectedGender;
	String editEmailID, editAdress, editCity, editState, editPin, editPhoneNumber, accountID, payeeAccountID;
	int currentAmount, depositAmount, currentBalanceAfterDeposit, withdrawAmount, currentBalanceAfterWithdraw,
			transferAmount, currentBalanceAfterTransfer;
	String depositDescription, withdrawDescription, fundTransferDescription;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		email = "tpkcdnam" + randomNumber() + "@gmail.com";
		validName = "Jame Hugo";
		expectedGender = "male";
		validDateOfBirth = "1988-07-31";
		validAdress = "100 Ho Guom";
		validCity = "Ha Noi";
		validState = "Hoan Kiem";
		validPin = "600000";
		validPhoneNumber = "0987654321";
		validEmailID = "jame" + randomNumber() + "@gmail.com";
		validPassword = "nopdontknow12";

		editAdress = "01 Nguyen Van Linh";
		editCity = "Da Nang";
		editState = "Ngu Hanh Son";
		editPin = "550000";
		editPhoneNumber = "0975123456";
		editEmailID = "redonaming" + randomNumber() + "@gmail.com";

		currentAmount = 50000;
		depositAmount = 5000;
		currentBalanceAfterDeposit = currentAmount + depositAmount;
		withdrawAmount = 15000;
		currentBalanceAfterWithdraw = currentBalanceAfterDeposit - withdrawAmount;
		transferAmount = 10000;
		currentBalanceAfterTransfer = currentBalanceAfterWithdraw - transferAmount;

		depositDescription = "Deposit";
		withdrawDescription = "Withdraw";
		fundTransferDescription = "Transfer";

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
		homePageUrl = homePage.getHomePageUrl();
		homePage.isWelcomeMessageDisplayed();
		homePage.isUserIDDisplayed(userIdInfo);
		newCustomerPage = homePage.clickToNewCustomerButton();

	}

	@Test
	public void TC_01_CreateNewCustomerSuccessfully() {
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
	public void TC_02_EditNewCustomerSuccessfully() {
		editcustomerPage = newCustomerPage.clickToEditCustomerLink();
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
	public void TC_03_AddNewAccount() {
		newAccountPage = editcustomerPage.clickToNewAccountButton();
		newAccountPage.inputCustomerIDToCustomerIDTextbox(customerID);
		newAccountPage.selectCurrentInAccountType();
		newAccountPage.inputAmountToInitialDeposit(String.valueOf(currentAmount));
		newAccountPage.clickToSubmitButton();
		Assert.assertTrue(newAccountPage.isAccountGeneratedSuccessfullyMessageDisplayed());
		Assert.assertEquals(newAccountPage.getTextCurrentAmount(), String.valueOf(currentAmount));
		accountID = newAccountPage.getAccountID();
	}

	@Test
	public void TC_04_TransferMoneyToCurrentAccount() {
		depositPage = newAccountPage.clickToDepositButton();
		Assert.assertTrue(depositPage.isAmountDepositFormDisplayed());
		depositPage.inputAccountIDToAccountNoTextbox(accountID);
		depositPage.inputAmountToAmountTextbox(String.valueOf(depositAmount));
		depositPage.inputDescriptionToDescriptionTextbox(depositDescription);
		depositPage.clickToSubmitButton();
		Assert.assertTrue(depositPage.isCorrectTracsactionDetailsMessageDisplayed(accountID));
		Assert.assertEquals(depositPage.getTextCurrentBalance(), String.valueOf(currentBalanceAfterDeposit));

	}

	@Test
	public void TC_05_WithdrawFromCurrentAccount() {
		withdrawPage = depositPage.clickToWithdrawLink();
		Assert.assertTrue(withdrawPage.isAmountWithdrawFormDisplayed());
		withdrawPage.inputAccountIDToAccountNoTextbox(accountID);
		withdrawPage.inputAmountToAmountTextbox(String.valueOf(withdrawAmount));
		withdrawPage.inputDescriptionToDescriptionTextbox(withdrawDescription);
		withdrawPage.clickToSubmitButton();
		Assert.assertTrue(withdrawPage.isCorrectTracsactionDetailsMessageDisplayed(accountID));
		Assert.assertEquals(withdrawPage.getTextCurrentBalance(), String.valueOf(currentBalanceAfterWithdraw));

	}

	@Test
	public void TC_06_TransferMoney() {
		newAccountPage = withdrawPage.clickToNewAccountButton();
		newAccountPage.inputCustomerIDToCustomerIDTextbox(customerID);
		newAccountPage.selectCurrentInAccountType();
		newAccountPage.inputAmountToInitialDeposit(String.valueOf(currentAmount));
		newAccountPage.clickToSubmitButton();
		Assert.assertTrue(newAccountPage.isAccountGeneratedSuccessfullyMessageDisplayed());
		Assert.assertEquals(newAccountPage.getTextCurrentAmount(), String.valueOf(currentAmount));
		payeeAccountID = newAccountPage.getAccountID();
		fundTransferPage = newAccountPage.clickToFundTransferLink();
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
	public void TC_07_BalanceEnquiry() {
		balanceEnquiryPage = fundTransferPage.clickToBalanceEnquiryLink();
		balanceEnquiryPage.inputAccountNumber(accountID);
		balanceEnquiryPage.clickSubmitButton();
		Assert.assertTrue(balanceEnquiryPage.isBalanceDetailsMessageDisplayed(accountID));
		Assert.assertEquals(balanceEnquiryPage.getTextBalance(), String.valueOf(currentBalanceAfterTransfer));

	}

	@Test
	public void TC_08_DeleteAccount() {
		deleteAccountPage = balanceEnquiryPage.clickToDeleteAccountLink();
		deleteAccountPage.inputAccountNumber(accountID);
		deleteAccountPage.clickSubmitButton();
		Assert.assertEquals(deleteAccountPage.getTextConfirmDeleteAlert(),
				"Do you really want to delete this Account?");
		deleteAccountPage.acceptConfirmDeleteAlert();
		Assert.assertEquals(deleteAccountPage.getTextDeleteSuccessAlertAlert(), "Account Deleted Sucessfully");
		homePage = deleteAccountPage.acceptDeleteSuccessAlert();
		deleteAccountPage = homePage.clickToDeleteAccountLink();
		deleteAccountPage.inputAccountNumber(payeeAccountID);
		deleteAccountPage.clickSubmitButton();
		Assert.assertEquals(deleteAccountPage.getTextConfirmDeleteAlert(),
				"Do you really want to delete this Account?");
		deleteAccountPage.acceptConfirmDeleteAlert();
		Assert.assertEquals(deleteAccountPage.getTextDeleteSuccessAlertAlert(), "Account Deleted Sucessfully");
		homePage = deleteAccountPage.acceptDeleteSuccessAlert();

	}

	@Test
	public void TC_09_DeleteCustomer() {
		deleteCustomerPage = homePage.clickToDeleteCustomerLink();
		deleteCustomerPage.inputCustomerIDNumber(customerID);
		deleteCustomerPage.clickSubmitButton();
		Assert.assertEquals(deleteCustomerPage.getTextConfirmDeleteAlert(),	"Do you really want to delete this Customer?");
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
