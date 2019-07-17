package PageFactoryManager;

import org.openqa.selenium.WebDriver;

import bankguruPageObjects.BalanceEnquiryPageObject;
import bankguruPageObjects.ChangePasswordPageObject;
import bankguruPageObjects.CustomisedStatementPageObject;
import bankguruPageObjects.DeleteAccountPageObject;
import bankguruPageObjects.DeleteCustomerPageObject;
import bankguruPageObjects.DepositPageObject;
import bankguruPageObjects.EditAccountPageObject;
import bankguruPageObjects.EditCustomerPageObject;
import bankguruPageObjects.FundTransferPageObject;
import bankguruPageObjects.HomePageObject;
import bankguruPageObjects.LoginPageObject;
import bankguruPageObjects.MiniStatementPageObject;
import bankguruPageObjects.NewAccountPageObject;
import bankguruPageObjects.NewCustomerPageObject;
import bankguruPageObjects.RegisterPageObject;
import bankguruPageObjects.WithdrawalPageObject;

public class PageFactoryManager {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	
	public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}
	
	public static DeleteCustomerPageObject getDeleteCustomerPage(WebDriver driver) {
		return new DeleteCustomerPageObject(driver);
	}
	
	public static NewAccountPageObject getNewAccountPage(WebDriver driver) {
		return new NewAccountPageObject(driver);
	}
	
	public static EditAccountPageObject getEditAccountPage(WebDriver driver) {
		return new EditAccountPageObject(driver);
	}
	
	public static DeleteAccountPageObject getDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObject(driver);
	}
	
	public static DepositPageObject getDepositPage(WebDriver driver) {
		return new DepositPageObject(driver);
	}
	
	public static WithdrawalPageObject getWithdrawalPage(WebDriver driver) {
		return new WithdrawalPageObject(driver);
	}
	
	public static FundTransferPageObject getFundTransferPage(WebDriver driver) {
		return new FundTransferPageObject(driver);
	}
	
	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	
	public static BalanceEnquiryPageObject getBalanceEnquiryPage(WebDriver driver) {
		return new BalanceEnquiryPageObject(driver);
	}
	
	public static MiniStatementPageObject getMiniStatementPage(WebDriver driver) {
		return new MiniStatementPageObject(driver);
	}
	
	public static CustomisedStatementPageObject getCustomisedStatementPage(WebDriver driver) {
		return new CustomisedStatementPageObject(driver);
	}
	

}



