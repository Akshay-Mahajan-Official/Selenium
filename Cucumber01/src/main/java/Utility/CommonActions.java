package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Base.TestBase;

public class CommonActions extends TestBase {

	private Logger logger = LoggerFactory.getLogger(CommonActions.class);

	private void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px dashed red'", element);
	}

	public void enter_data(String value, WebElement element) {
		highlightElement(element);
		logger.info("Entering Text : " + value);
		element.sendKeys(value);
	}

	public void CLick_On_Element(WebElement element) {
		highlightElement(element);
		logger.info("Click on Element : " + element.getText());
		element.click();
	}

}
