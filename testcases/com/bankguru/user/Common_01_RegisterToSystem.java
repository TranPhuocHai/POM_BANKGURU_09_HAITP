package com.bankguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Common_01_RegisterToSystem extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String email = "muntibonemdh" + randomNumber() + "@gmail.com";
	String loginPageUrl;
	public static String USER_ID_INFOR, PASSWORD_INFOR;

	@Parameters("browser")
	@BeforeTest
	public void CreateUser(String browserName) {
		driver = openMultiBrowser(browserName);
		
		log.info("CreateUser: Step 01 - open Login Page");
		loginPage = PageFactoryManager.getLoginPage(driver);
		
		log.info("CreateUser: Step 02 - Verify Login Form displayed");
		verifyTrue(loginPage.isLoginFormDisplayed());
		
		log.info("CreateUser: Step 03 - Get Login Page url");
		loginPageUrl = loginPage.getLoginPageUrl();
		
		log.info("CreateUser: Step 04 - Click to 'here' link");
		registerPage = loginPage.clickToHereLink();
		
		log.info("CreateUser: Step 05 - Verify Register Page displayed");
		verifyTrue(registerPage.isRegisterPageDisplayed());
		
		log.info("CreateUser: Step 06 - Input to Email ID textbox");
		registerPage.inPutToEmailIDTextbox(email);
		
		log.info("CreateUser: Step 07 - Click to Submit button");
		registerPage.clickToSubmitButton();
		
		log.info("CreateUser: Step 08 - Get UserID and Password Infor");
		USER_ID_INFOR = registerPage.getTextDynamicInfo(driver, "User ID :");
		PASSWORD_INFOR = registerPage.getTextDynamicInfo(driver, "Password :");
		
		closeBrowserAndDriver(driver);

	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
}
