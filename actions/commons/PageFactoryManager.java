package commons;

import org.openqa.selenium.WebDriver;

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

public class PageFactoryManager {
	private static HomePageObject homePage;
	private static RegisterPageObject registerPage;
	private static LoginPageObject loginPage;
	private static NewCustomerPageObject newCustomerPage;
	private static EditCustomerPageObject editCustomerPage;
	private static NewAccountPageObject newAccountPage;
	private static DepositPageObject depositPage;
	private static WithdrawPageObject withdrawPage;
	private static FundTransferPageObject fundTransferPage;
	private static BalanceEnquiryPageObject balanceEnquiryPage;
	private static DeleteAccountPageObject deleteAccountPage;
	private static DeleteCustomerPageObject deleteCustomerPage;
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if (homePage == null) {
			homePage = new HomePageObject(driver);
		}
		return homePage;
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if (registerPage == null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if (loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}
	
	public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
		if (newCustomerPage == null) {
			newCustomerPage = new NewCustomerPageObject(driver);
		}
		return newCustomerPage;
	}
	
	public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
		if (editCustomerPage == null) {
			editCustomerPage = new EditCustomerPageObject(driver);
		}
		return editCustomerPage;
	}
	
	public static NewAccountPageObject getNewAccountPage(WebDriver driver) {
		if (newAccountPage == null) {
			newAccountPage = new NewAccountPageObject(driver);
		}
		return newAccountPage;
	}
	
	public static DepositPageObject getDepositPage(WebDriver driver) {
		if (depositPage == null) {
			depositPage = new DepositPageObject(driver);
		}
		return depositPage;
	}
	
	public static WithdrawPageObject getWithdrawPage(WebDriver driver) {
		if (withdrawPage == null) {
			withdrawPage = new WithdrawPageObject(driver);
		}
		return withdrawPage;
	}
	
	public static FundTransferPageObject getFundTransferPage(WebDriver driver) {
		if (fundTransferPage == null) {
			fundTransferPage = new FundTransferPageObject(driver);
		}
		return fundTransferPage;
	}
	
	public static BalanceEnquiryPageObject getBalanceEnquiryPage(WebDriver driver) {
		if (balanceEnquiryPage == null) {
			balanceEnquiryPage = new BalanceEnquiryPageObject(driver);
		}
		return balanceEnquiryPage;
	}
	
	public static DeleteAccountPageObject getDeleteAccountPage(WebDriver driver) {
		if (deleteAccountPage == null) {
			deleteAccountPage = new DeleteAccountPageObject(driver);
		}
		return deleteAccountPage;
	}
	
	public static DeleteCustomerPageObject getDeleteCustomerPage(WebDriver driver) {
		if (deleteCustomerPage == null) {
			deleteCustomerPage = new DeleteCustomerPageObject(driver);
		}
		return deleteCustomerPage;
	}

}



