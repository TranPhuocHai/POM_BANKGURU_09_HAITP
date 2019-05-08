package com.bankguru.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.DepositPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.WithdrawPageObject;

public class PaymentFunction_Level_03 {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editcustomerPage;
	NewAccountPageObject newAccountPage;
	DepositPageObject depositPage;
	WithdrawPageObject withdrawPage;
	
	String loginPageUrl, newCustomerPageUrl, homePageUrl, userIdInfo, passwordInfo, email;
	String validEmailID, validDateOfBirth, validName, validAdress, validCity, validState, validPin, validPhoneNumber,
			validPassword, customerID, expectedGender;
	String editEmailID, editAdress, editCity, editState, editPin, editPhoneNumber, accountID;	
	int currentAmount, depositAmount, currentBalanceAfterDeposit, withdrawAmount, currentBalanceAfterWithdraw;
	String depositDescription, withdrawDescription;

	@BeforeClass
	public void beforeClass() {
//		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");

		email = "randoname" + randomNumber() + "@gmail.com";
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
		
		depositDescription = "Deposit";
		withdrawDescription = "Withdraw";
		

		loginPage = new LoginPageObject(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		loginPage.clickToHereLink();
		registerPage = new RegisterPageObject(driver);
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inPutToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		userIdInfo = registerPage.getUserIDInfor();
		passwordInfo = registerPage.getPasswordInfor();
		registerPage.openLoginPage(loginPageUrl);
		loginPage = new LoginPageObject(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inPutToUserIDTextbox(userIdInfo);
		loginPage.inPutToPasswordTextbox(passwordInfo);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		homePageUrl = homePage.getHomePageUrl();
		homePage.isWelcomeMessageDisplayed();
		homePage.isUserIDDisplayed(userIdInfo);
		homePage.clickToNewCustomerButton();
		newCustomerPage = new NewCustomerPageObject(driver);
		newCustomerPageUrl = newCustomerPage.getNewCustomerPageUrl();

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
		newCustomerPage.openHomePageUrl(homePageUrl);
		homePage = new HomePageObject(driver);
		homePage.clickToEditCustomerButton();
		editcustomerPage = new EditCustomerPageObject(driver);
		editcustomerPage.inputCustomerIDToCustomerIDTextbox(customerID);
		editcustomerPage.clicktoSubmitCustomerIDButton();

		editcustomerPage.clearAdressTextArea();
		editcustomerPage.inputValidDataToAdressTextArea(editAdress);
		editcustomerPage.clearCityTextBox();
		editcustomerPage.inputValidDataToCityTextbox(editCity);
		editcustomerPage.clearStateTextBox();
		editcustomerPage.inputValidDataToStateTextbox(editState);
		editcustomerPage.clearPinTextBox();
		editcustomerPage.inputValidDataToPinTextbox(editPin);
		editcustomerPage.clearPhoneTextBox();
		editcustomerPage.inputValidDataToMobileNumberTextbox(editPhoneNumber);
		editcustomerPage.clearEmailTextBox();
		editcustomerPage.inputValidDataToEmailTextbox(editEmailID);
		editcustomerPage.clickToEditSubmitButton();

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
		editcustomerPage.openHomePageUrl(homePageUrl);
		homePage = new HomePageObject(driver);
		homePage.clickToNewAccountButton();
		newAccountPage = new NewAccountPageObject(driver);
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
		newAccountPage.openHomePageUrl(homePageUrl);
		homePage = new HomePageObject(driver);
		homePage.clickToDepositButton();
		depositPage = new DepositPageObject(driver);
		Assert.assertTrue(depositPage.isAmountDepositFormDisplayed());
		depositPage.inputAccountIDToAccountNoTextbox(accountID);
		depositPage.inputAmountToAmountTextbox(String.valueOf(depositAmount));
		depositPage.inputDescriptionToDescriptionTextbox(depositDescription);
		depositPage.clickToDepositSubmitButton();
		Assert.assertTrue(depositPage.isCorrectTracsactionDetailsMessageDisplayed(accountID));
		Assert.assertEquals(depositPage.getTextCurrentBalance(), String.valueOf(currentBalanceAfterDeposit));
		
	}
	
	@Test
	public void TC_05_WithdrawFromCurrentAccount() {
		depositPage.openHomePageUrl(homePageUrl);
		homePage = new HomePageObject(driver);
		homePage.clickToWithdrawButton();
		withdrawPage = new WithdrawPageObject(driver);
		Assert.assertTrue(withdrawPage.isAmountWithdrawFormDisplayed());
		withdrawPage.inputAccountIDToAccountNoTextbox(accountID);
		withdrawPage.inputAmountToAmountTextbox(String.valueOf(withdrawAmount));
		withdrawPage.inputDescriptionToDescriptionTextbox(withdrawDescription);
		withdrawPage.clickToWithdrawSubmitButton();
		Assert.assertTrue(withdrawPage.isCorrectTracsactionDetailsMessageDisplayed(accountID));
		Assert.assertEquals(withdrawPage.getTextCurrentBalance(), String.valueOf(currentBalanceAfterWithdraw));
		
	}
	
	@Test
	public void TC_06_TransferMoney() {
		withdrawPage.openHomePageUrl(homePageUrl);
		
	}
	
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
