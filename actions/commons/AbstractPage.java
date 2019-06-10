package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import bankguruUI.AbstractPageUI;
import liveguruPageFactoryManager.LiveGuruPageFactoryManager;
import liveguruPageObjects.HomePageObject;
import liveguruUI.LiveGuruAbstractPageUI;

public class AbstractPage {
	WebElement element;
	List<WebElement> elements;
	JavascriptExecutor javascriptExecutor;
	WebDriverWait waitExplicit;
	Actions action;
	By byLocator;
	Log log;
	boolean status;

	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendKeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void clearTextElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.clear();
	}
	
	public void clearTextElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		element.clear();
	}

	public void clickToElement(WebDriver driver, String locator) {

		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public void sendKeyToElement(WebDriver driver, String locator, String sendKeyValue, String... values) {
		locator = String.format(locator, (Object[]) values);
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(sendKeyValue);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String expectedValueInDropdown, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(expectedValueInDropdown);
	}

	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String allItemXpath, String expectedItem) throws Exception {

		WebElement parentDropdown = driver.findElement(By.xpath(parentXpath));
		javascriptExecutor.executeScript("arguments[0].click();", parentDropdown);

		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));

		List<WebElement> all_Item = driver.findElements(By.xpath(allItemXpath));
		for (WebElement childElement : all_Item) {
			if (childElement.getText().equals(expectedItem)) {
				javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
				Thread.sleep(1000);
				if (childElement.isDisplayed()) {
					childElement.click();
				} else {
					javascriptExecutor.executeScript("arguments[0].click();", childElement);
				}
				Thread.sleep(1000);
				break;
			}

		}
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToCheckBoxOrRadioButton(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToCheckBoxOrRadioButton(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToCheckBox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		highlightElement(driver, locator);
		try {
			element = driver.findElement(By.xpath(locator));
			if (element.isDisplayed()) {
				status = true;
			}
		} catch (Exception ex) {
			Reporter.log("=========================== Element not displayed==============================");
			Reporter.log(ex.getMessage());
			System.err.println("=========================== Element not displayed==============================");
			System.err.println(ex.getMessage() + "\n");
			status = false;
		}

		return status;
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		highlightElement(driver, locator);
		try {
			element = driver.findElement(By.xpath(locator));
			if (element.isDisplayed()) {
				status = true;
			}
		} catch (Exception ex) {
			Reporter.log("=========================== Element not displayed==============================");
			Reporter.log(ex.getMessage());
			System.err.println("=========================== Element not displayed==============================");
			System.err.println(ex.getMessage() + "\n");
			status = false;
		}

		return status;
	}

	public boolean isControlUnDisplayed(WebDriver driver, String locator) {
		overrideGlobleTimeout(driver, Constants.SHORT_TIMEOUT);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			overrideGlobleTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			overrideGlobleTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		} else {
			overrideGlobleTimeout(driver, Constants.LONG_TIMEOUT);
			return false;
		}
	}

	public boolean isControlUnDisplayed(WebDriver driver, String locator, String... values) {
		overrideGlobleTimeout(driver, Constants.SHORT_TIMEOUT);
		locator = String.format(locator, (Object[]) values);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			overrideGlobleTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			overrideGlobleTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		} else {
			overrideGlobleTimeout(driver, Constants.LONG_TIMEOUT);
			return false;
		}
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public void switchToChildWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void swithToChildWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String currentWindowTitle = driver.getTitle();
			if (currentWindowTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	public boolean closeAllExceptParentWindow(WebDriver driver, String parentWindows) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentWindows)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindows);
		if (driver.getWindowHandles().size() == 1) {
			return true;
		} else
			return false;
	}

	public void switchToIframe(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}

	public void backToTopWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.doubleClick(element);
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.contextClick(element);
	}

	public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		WebElement sourceElement, targetElement;
		sourceElement = driver.findElement(By.xpath(sourceLocator));
		targetElement = driver.findElement(By.xpath(targetLocator));
		action = new Actions(driver);
		action.dragAndDrop(sourceElement, targetElement).build().perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}
	
	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key, String... values) {
		locator = String.format(locator, (Object[]) values);
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}

	public void highlightElement(WebDriver driver, String locator) {
		javascriptExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("Style");
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", "border:3px solid red; border-style: dashed;");
		try {
			Thread.sleep(Constants.HIGHLIGHT_ELEMENT_TIMEOUT_FOR_DEMO);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", originalStyle);

	}

	public Object executeForBrowser(WebDriver driver, String javascript) {
		javascriptExecutor = (JavascriptExecutor) driver;
		return javascriptExecutor.executeScript(javascript);
	}

	public void clickToElementByJavascript(WebDriver driver, String locator) {
		javascriptExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor.executeScript("arguments[0].click();", element);
	}

	public void sendkeyToElementByJavascript(WebDriver driver, String locator, String value) {
		javascriptExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attribute) {
		javascriptExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}
	
	public void removeAttributeInDOM(WebDriver driver, String locator, String attribute, String... values ) {
		javascriptExecutor = (JavascriptExecutor) driver;
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public void setAttributeInDOM(WebDriver driver, String locator, String attribute, String value) {
		javascriptExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor.executeScript("arguments[0].setAttribute('" + attribute + "', '" + value + "');", element);
	}

	public void scrollToBottomPage(WebDriver driver) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJavascript(WebDriver driver, String url) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.location = '" + url + "'");
	}

	public void uploadSingleFileBySendKeyToElement(WebDriver driver, String filePath, String openButtonLocator, String uploadButtonLocator) {
		driver.findElement(By.xpath(openButtonLocator)).sendKeys(filePath);
		driver.findElement(By.xpath(uploadButtonLocator)).click();
	}

	public void uploadMultiFilesBySendKeyToElement(WebDriver driver, String[] allFilesPaths, String openButtonLocator, String uploadButtonLocator) {
		for (String file : allFilesPaths) {
			driver.findElement(By.xpath(openButtonLocator)).sendKeys(file);
		}
		List<WebElement> allStartBtns = driver.findElements(By.xpath(uploadButtonLocator));
		for (WebElement startButton : allStartBtns) {
			startButton.click();
		}
	}

	public void waitForElementPresence(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, Constants.LONG_TIMEOUT);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, Constants.LONG_TIMEOUT);
		byLocator = By.xpath(locator);
		try {
			waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
		} catch (Exception ex) {
			Reporter.log("================================== Wait for element not visible===================================");
			Reporter.log(ex.getMessage());
			System.err.println("================================== Wait for element not visible===================================");
			System.err.println(ex.getMessage() + "\n");
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		waitExplicit = new WebDriverWait(driver, Constants.LONG_TIMEOUT);
		locator = String.format(locator, (Object[]) values);
		byLocator = By.xpath(locator);
		try {
			waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
		} catch (Exception ex) {
			Reporter.log("================================== Wait for element not visible===================================");
			Reporter.log(ex.getMessage());
			System.err.println("================================== Wait for element not visible===================================");
			System.err.println(ex.getMessage() + "\n");
		}
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, Constants.LONG_TIMEOUT);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		byLocator = By.xpath(locator);
		overrideGlobleTimeout(driver, Constants.SHORT_TIMEOUT);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		overrideGlobleTimeout(driver, Constants.LONG_TIMEOUT);

	}

	public void waitForElementInvisible(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		byLocator = By.xpath(locator);
		overrideGlobleTimeout(driver, Constants.SHORT_TIMEOUT);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		overrideGlobleTimeout(driver, Constants.LONG_TIMEOUT);

	}

	public void waitForAlertPresence(WebDriver driver) {
		waitExplicit = new WebDriverWait(driver, Constants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	public void openMultiplePage(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
	}

	public void overrideGlobleTimeout(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	
	/* ============================== BANKGURU Dynamic Locator method ==============================  */
	
	public String getTextDynamicTableInfo(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TABLE_INFOR, fieldName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_INFOR, fieldName);
	}
	
	public void clickToDynamicTextboxOrTextArea(WebDriver driver, String fieldName ) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX_TEXTAREA, fieldName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_TEXTAREA, fieldName);
		
	}
	
	public void clearDynamicTextboxOrTextArea(WebDriver driver, String fieldName ) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX_TEXTAREA, fieldName);
		clearTextElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_TEXTAREA, fieldName);
		
	}
	
	public void pressTABKeyToDynamicTextboxOrTextArea(WebDriver driver, String fieldName ) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX_TEXTAREA, fieldName);
		sendKeyBoardToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_TEXTAREA, Keys.TAB, fieldName);
		
	}
	
	public void inputToDynamicTextboxOrTextArea(WebDriver driver, String fieldName, String sendKeyValue ) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX_TEXTAREA, fieldName);
		sendKeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_TEXTAREA, sendKeyValue, fieldName);
		
	}
	
	public void checkToDynamicCheckboxOrRadioButton(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, fieldName);
		checkToCheckBoxOrRadioButton(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, fieldName);
	}
	
	
	public void clickToDynamicButton(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_BUTTON, fieldName);
		checkToCheckBoxOrRadioButton(driver, AbstractPageUI.DYNAMIC_BUTTON, fieldName);
	}
	
	public void selectItemInDynamicDropdown(WebDriver driver, String fieldName, String expectedValueInDropdown) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN, fieldName);
		selectItemInDropdown(driver, AbstractPageUI.DYNAMIC_DROPDOWN, expectedValueInDropdown, fieldName);
	}
	
	public String getTextDynamicValidateMessage(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_VALIDATE_MESSAGE, fieldName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VALIDATE_MESSAGE, fieldName);
		
	}
	
	public boolean isDynamicPageTitleDisplayed(WebDriver driver, String message) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_PAGE_TITLE, message);
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_PAGE_TITLE, message);
		
	}
	
	public void removeAtrributeDynamicTextbox(WebDriver driver, String fieldName, String attribute) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX_TEXTAREA, fieldName);
		removeAttributeInDOM(driver, AbstractPageUI.DYNAMIC_TEXTBOX_TEXTAREA, attribute, fieldName);
	}
	
	/* =================================== LIVEGURU Dynamic Locator method ===========================================  */

	public void inputToDynamicTextboxLiveGuru(WebDriver driver,  String fieldName, String sendKeyValue) {
		waitForElementVisible(driver, LiveGuruAbstractPageUI.DYNAMIC_TEXTBOX_CHECKBOX, fieldName);
		sendKeyToElement(driver, LiveGuruAbstractPageUI.DYNAMIC_TEXTBOX_CHECKBOX, sendKeyValue, fieldName);
		
	}
	
	public void clickToAccountMenu(WebDriver driver) {
		waitForElementVisible(driver, LiveGuruAbstractPageUI.ACCOUNT_MENU);
		clickToElement(driver, LiveGuruAbstractPageUI.ACCOUNT_MENU);
		
	}
	
	public void clickToDynamicLink(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, LiveGuruAbstractPageUI.HEADER_DYNAMIC_LINK, fieldName);
		clickToElement(driver, LiveGuruAbstractPageUI.HEADER_DYNAMIC_LINK, fieldName);
		
	}
	
	public HomePageObject openHomePage(WebDriver driver, String url) {
		openAnyUrl(driver, url);
		return LiveGuruPageFactoryManager.getHomePage(driver);
		
	}

}









































