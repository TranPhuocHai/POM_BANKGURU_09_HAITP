package com.liveguru.backend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.backend.testdata.LiveGuruBackEndTestData;

import commons.AbstractTest;
import liveguruPageFactoryManager.LiveGuruPageFactoryManager;
import liveguruPageObjects.BackEndAdminPageObject;
import liveguruPageObjects.BackEndLoginPageObject;

public class LiveGuruBackEnd extends AbstractTest {
	private WebDriver driver;
	private BackEndLoginPageObject backEndLoginPage;
	private BackEndAdminPageObject backEndAdminPage;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);

	}
  
  
  @Test
  public void TC_01_VerifyInvoiceCanBePrinted() {
	  
	  log.info("======= LiveGuru BackEnd - TC_01: Verify Invoice Can Be Printed");
	  
	  log.info("TC_01: Step 01 - Get login page");
	  backEndLoginPage = LiveGuruPageFactoryManager.getBackEndLoginPage(driver);
	  
	  log.info("TC_01: Step 02 - Verify Login Title 'Log in to Admin Pane' displays");
	  backEndLoginPage.isLoginTitleDisplayed();
	  
	  log.info("TC_01: Step 03 - Input to 'Username' textbox");
	  backEndLoginPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "login[username]", LiveGuruBackEndTestData.USER_NAME);
	  
	  log.info("TC_01: Step 04 - Input to 'Password' textbox");
	  backEndLoginPage.inputToDynamicTextboxTextAreaLiveGuru(driver, "login[password]", LiveGuruBackEndTestData.PASSWORD);
	  
	  log.info("TC_01: Step 05 - Click To 'Login' button");
	  backEndAdminPage = backEndLoginPage.clickToLoginButton();
	  
	  log.info("TC_01: Step 06 - Close Incoming message pop-up if it appears");
	  backEndAdminPage.closeIncomingMessagePopUpIfItDisplays();
	  
	  
  }
  

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
