package com.bankguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import bankguruPageFactoryManager.PageFactoryManager;
import bankguruPageObjects.LoginPageObject;
import bankguruPageObjects.RegisterPageObject;
import commons.AbstractTest;

public class Common_01_RegisterToSystem extends AbstractTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	public static String USER_ID_INFOR, PASSWORD_INFOR;

	@Parameters({"browser","url"})
	@BeforeTest
	public void beforeClass(String browserName, String urlName) {
		driver = openMultiBrowser(browserName, urlName);

		log.info("CreateUser: Step 01 - open Login Page");
		loginPage = PageFactoryManager.getLoginPage(driver);

		log.info("CreateUser: Step 02 - Verify Login Form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());

		log.info("CreateUser: Step 03 - Click to 'here' link");
		registerPage = loginPage.clickToHereLink();

		log.info("CreateUser: Step 04 - Verify Register Page displayed");
		verifyTrue(registerPage.isRegisterPageDisplayed());

		log.info("CreateUser: Step 05 - Input to Email ID textbox");
		registerPage.inputToDynamicTextboxOrTextArea(driver, "emailid", RegisterToSystemTestData.EMAIL+ randomNumber() + "@gmail.com");

		log.info("CreateUser: Step 06 - Click to Submit button");
		registerPage.clickToDynamicButton(driver, "btnLogin");

		log.info("CreateUser: Step 07 - Get UserID and Password Infor");
		USER_ID_INFOR = registerPage.getTextDynamicTableInfo(driver, "User ID :");
		PASSWORD_INFOR = registerPage.getTextDynamicTableInfo(driver, "Password :");
		
		log.info("CreateUser: Step 08 - Quit browser");
		closeBrowserAndDriver(driver);

	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
}
