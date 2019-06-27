package com.liveguru.backend;

import org.testng.annotations.Test;


import commons.AbstractTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class LiveGuruBackEnd extends AbstractTest {
	WebDriver driver;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeTest(String browserName, String url) {
		driver = openMultiBrowser(browserName, url);

	}
  
  
  @Test
  public void f() {
  }
  

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
