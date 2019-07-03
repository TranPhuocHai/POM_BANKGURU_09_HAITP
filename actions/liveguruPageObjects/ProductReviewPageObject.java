package liveguruPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import commons.Constants;
import liveguruUI.ProductReviewPageUI;

public class ProductReviewPageObject extends AbstractPage {
	public ProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	JavascriptExecutor javascriptExecutor;

//	public boolean isReviewDisplayed(String... values) {
//		String locator = ProductReviewPageUI.PUBLIC_REVIEW;
//		locator = String.format(locator, (Object[]) values);
//		List<WebElement> allExpectedEditButton = driver.findElements(By.xpath(locator));
//		WebElement element = allExpectedEditButton.get(0);
//
//		javascriptExecutor = (JavascriptExecutor) driver;
//		String originalStyle = element.getAttribute("Style");
//		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", "border:3px solid red; border-style: dashed;");
//		try {
//			Thread.sleep(Constants.HIGHLIGHT_ELEMENT_TIMEOUT_FOR_DEMO);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", originalStyle);
//		
//		return element.isDisplayed();
//
//	}
	
	public boolean isReviewDisplayed(String one, String two, String three) {
		waitForElementVisible(driver, ProductReviewPageUI.PUBLIC_REVIEW, one, two, three);
		return isControlDisplayed(driver, ProductReviewPageUI.PUBLIC_REVIEW, one, two, three);
		
	}

}
