package commons;

import org.openqa.selenium.WebDriver;

import PageObjects.BackEndAdminPageObject;
import PageObjects.BackEndLoginPageObject;
import PageObjects.BalanceEnquiryPageObject;
import PageObjects.CatalogSearchPageObject;
import PageObjects.ChangePasswordPageObject;
import PageObjects.CheckOutPageObject;
import PageObjects.CompareProductPageObject;
import PageObjects.CustomisedStatementPageObject;
import PageObjects.DeleteAccountPageObject;
import PageObjects.DeleteCustomerPageObject;
import PageObjects.DepositPageObject;
import PageObjects.EditAccountPageObject;
import PageObjects.EditCustomerPageObject;
import PageObjects.FundTransferPageObject;
import PageObjects.HomePageObject;
import PageObjects.LiveGuruHomePageObject;
import PageObjects.LiveGuruRegisterPageObject;
import PageObjects.LoginPageObject;
import PageObjects.MiniStatementPageObject;
import PageObjects.MobilePageObject;
import PageObjects.MyAccountPageObject;
import PageObjects.NewAccountPageObject;
import PageObjects.NewCustomerPageObject;
import PageObjects.ProductReviewPageObject;
import PageObjects.RegisterPageObject;
import PageObjects.ShoppingCartPageObject;
import PageObjects.TVPageObject;
import PageObjects.UploadPageObject;
import PageObjects.WithdrawalPageObject;

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
	
	public static LiveGuruHomePageObject getLiveGuruHomePage(WebDriver driver) {
		return new LiveGuruHomePageObject(driver);
	}
	
	public static LiveGuruRegisterPageObject getLiveGuruRegisterPage(WebDriver driver) {
		return new LiveGuruRegisterPageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	
	public static MobilePageObject getMobilePage(WebDriver driver) {
		return new MobilePageObject(driver);
	}
	
	public static TVPageObject getTVPage(WebDriver driver) {
		return new TVPageObject(driver);
	}
	
	public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}
	
	public static CompareProductPageObject getCompareProductPage(WebDriver driver) {
		return new CompareProductPageObject(driver);
	}
	
	public static CheckOutPageObject getCheckOutPage(WebDriver driver) {
		return new CheckOutPageObject(driver);
	}
	
	public static CatalogSearchPageObject getCatalogSearchPage(WebDriver driver) {
		return new CatalogSearchPageObject(driver);
	}
	
	
	public static BackEndLoginPageObject getBackEndLoginPage(WebDriver driver) {
		return new BackEndLoginPageObject(driver);
	}
	
	
	public static BackEndAdminPageObject getBackEndAdminPage(WebDriver driver) {
		return new BackEndAdminPageObject(driver);
	}
	
	public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductReviewPageObject(driver);
	}
	
	public static UploadPageObject getUploadPage(WebDriver driver) {
		return new UploadPageObject(driver);
	}
	
	

}



