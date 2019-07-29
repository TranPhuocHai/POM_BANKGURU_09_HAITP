package com.bankguru.upload;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.UploadPageObject;
import commons.AbstractTest;
import commons.PageFactoryManager;
import reportConfig.ExtentTestManager;

public class UploadFunction extends AbstractTest {
	private WebDriver driver;
	private UploadPageObject uploadPage;

	private String rootFolder = System.getProperty("user.dir");
	private String fileName01 = "image 01.png";
	private String fileNamePath01 = rootFolder + "\\uploadFiles\\" + fileName01;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void Precondition(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);

		log.info("UploadPrecondition: Step 01 - Get Upload Page");
		uploadPage = PageFactoryManager.getUploadPage(driver);

	}

	@Test
	public void UploadImagesAndVerifyUploadFunction(Method method) {
		
		ExtentTestManager.startTest(method.getName(), method.getName());
		
		uploadPage.uploadImageToUploadPage(fileNamePath01);
		
		captureAnyScreenshot(method.getName());

		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
