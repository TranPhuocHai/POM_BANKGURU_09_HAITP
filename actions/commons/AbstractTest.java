package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {

	private WebDriver driver;
	protected final Log log;
	private final String workingDir = System.getProperty("user.dir");

	public AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

//	protected WebDriver openMultiBrowser(String browserName, String url) {
//		if (browserName.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		} else if (browserName.equalsIgnoreCase("firefoxheadless")) {
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions option = new FirefoxOptions();
//			option.setHeadless(true);
//			driver = new FirefoxDriver(option);
//			
//		} else if (browserName.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		} else if (browserName.equalsIgnoreCase("chromeheadless")) {
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions option = new ChromeOptions();
//			option.addArguments("headless");
//			option.addArguments("window-size=1366x768");
//			driver = new ChromeDriver(option);
//		} else if (browserName.equalsIgnoreCase("ie")) {
//			WebDriverManager.iedriver().arch32().setup();
//			driver = new InternetExplorerDriver();
//		}
//		
//		if (url.equalsIgnoreCase("bankguru")) {
//			driver.get(Constants.BANKGURU_DEV_APP_URL);
//		} else if (url.equalsIgnoreCase("livegurufrontend")) {
//			driver.get(Constants.LIVEGURU_FRONT_END);
//		} else if (url.equalsIgnoreCase("livegurubackend")) {
//			driver.get(Constants.LIVEGURU_BACK_END);
//		}
//		
//		driver.manage().timeouts().implicitlyWait(Constants.LONG_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		
//		if (driver.toString().toLowerCase().contains("internet explorer")) {
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return driver;
//	}
	
	protected WebDriver openMultiBrowser(String browserName, String url) {
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",".\\resources\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, workingDir + "\\FirefoxLog.txt");
			FirefoxOptions options = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile();
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			profile.setAcceptUntrustedCertificates(false);
			profile.setAssumeUntrustedCertificateIssuer(true);
			profile.setPreference("dom.webnotifications.enabled", false);
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.download.dir", "C:\\Downloads");
			profile.setPreference("browser.download.downloadDir", "C:\\Downloads");
			profile.setPreference("browser.download.defaultFolder", "C:\\Downloads");
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/anytext,text/plain,text/html,application/plain");
			capability = DesiredCapabilities.firefox();
			capability.setCapability(FirefoxDriver.PROFILE, profile);
			capability.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
			
			driver = new FirefoxDriver(capability);
			
			
			
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",".\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("chromeheadless")) {
			System.setProperty("webdriver.chrome.driver",".\\resources\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("headless");
			option.addArguments("window-size=1366x768");
			driver = new ChromeDriver(option);
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",".\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		if (url.equalsIgnoreCase("bankguru")) {
			driver.get(Constants.BANKGURU_DEV_APP_URL);
		} else if (url.equalsIgnoreCase("livegurufrontend")) {
			driver.get(Constants.LIVEGURU_FRONT_END);
		} else if (url.equalsIgnoreCase("livegurubackend")) {
			driver.get(Constants.LIVEGURU_BACK_END);
		}

		driver.manage().timeouts().implicitlyWait(Constants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
	
	

	private boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add failure to ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		boolean status;
		try {
			if (actual instanceof String && expected instanceof String) {
				actual = actual.toString().trim();
				log.info("Actual = " + actual);
				expected = expected.toString().trim();
				log.info("Expected = " + expected);
				status = (actual.equals(expected));
			} else {
				status = (actual == expected);
			}

			log.info("Compare value = " + status);
			if (status) {
				log.info("===PASSED===");
			} else {
				log.info("===FAILED===");
			}
			Assert.assertEquals(actual, expected, "Value is not matching!");
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	public void closeBrowserAndDriver(WebDriver driver) {
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name= " + osName);

			String cmd = "";
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toString().toLowerCase().contains("windows")) {
					cmd = "taskkill/F /FI\"IMAGENAME eq chromedriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill/F /FI\"IMAGENAME eq chromedriver*\"";
					Process process = Runtime.getRuntime().exec(cmd);
					process.waitFor();
				}
			}
			log.info("-------------QUIT BROWSER SUCCESSFULLY -----------------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	public String getCurrentDay() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		return String.valueOf(nowUTC.getDayOfMonth());
	}

	public String getCurrentMonth() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		int month = nowUTC.getMonthOfYear();
		if (month < 10) {
			return "0" + month;
		}
		return String.valueOf(month);
	}

	public String getCurrentYear() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		return String.valueOf(nowUTC.getYear());
	}

	public String getToday() {
		String today = getCurrentYear() + "-" + getCurrentMonth() + "-" + getCurrentDay();
		return today;
	}

}
