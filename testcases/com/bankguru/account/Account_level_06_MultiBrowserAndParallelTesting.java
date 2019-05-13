package com.bankguru.account;

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

import commons.PageFactoryManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Account_level_06_MultiBrowserAndParallelTesting {
	WebDriver driver;
	String userIdInfo, passwordInfo, loginPageUrl, email;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("chromeheadless")) {
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("headless");
			option.addArguments("window-size=1280x1024");
			driver = new ChromeDriver(option);
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
		email = "micvkn" + randomNumber() + "@gmail.com";
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_RegisterToSystem() {
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inPutToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		userIdInfo = registerPage.getUserIDInfor();
		passwordInfo = registerPage.getPasswordInfor();

	}

	@Test
	public void TC_02_LoginToSystem() {
		loginPage = registerPage.openLoginPage(loginPageUrl);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inPutToUserIDTextbox(userIdInfo);
		loginPage.inPutToPasswordTextbox(passwordInfo);
		homePage = loginPage.clickToLoginButton();
		homePage.isWelcomeMessageDisplayed();
		homePage.isUserIDDisplayed(userIdInfo);

	}

	@Test
	public void TC_03_LogOutOfSystem() {
		homePage.clickLogOutButton();
		loginPage = homePage.acceptLogOutAlert();

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
