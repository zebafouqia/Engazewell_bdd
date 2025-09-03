package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.netty.handler.timeout.TimeoutException;

public class ElementUtils {
	private static Logger logger = LogManager.getLogger(ElementUtils.class);
    WebDriver driver;
    long durationInSeconds = CommonUtils.EXPLICIT_WAIT_BASIC_TIME;

    public ElementUtils(WebDriver driver) {

        this.driver = driver;

    }
	
	public void jsClickClearAndSendKeysProperly2(WebElement inputField, String value) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll element into view
            js.executeScript("arguments[0].scrollIntoView({ block: 'center' });", inputField);
            Thread.sleep(300);

            if (!inputField.isDisplayed()) {
                throw new StaleElementReferenceException("Element is not visible or attached to the DOM.");
            }

            // Click and clear the field
            js.executeScript("arguments[0].click();", inputField);
            js.executeScript("arguments[0].value = '';", inputField);

            // Type character by character with events
            for (char c : value.toCharArray()) {
                String charStr = String.valueOf(c);
                js.executeScript(
                    "let el = arguments[0];" +
                    "el.dispatchEvent(new KeyboardEvent('keydown', {bubbles:true, cancelable:true, key: '" + charStr + "'}));" +
                    "el.value += '" + charStr + "';" +
                    "el.dispatchEvent(new Event('input', { bubbles: true }));" +
                    "el.dispatchEvent(new KeyboardEvent('keyup', {bubbles:true, cancelable:true, key: '" + charStr + "'}));",
                    inputField
                );
            }

            // Fire change + blur at the end
            js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", inputField);
            js.executeScript("arguments[0].dispatchEvent(new Event('blur', { bubbles: true }));", inputField);

        } catch (StaleElementReferenceException staleEx) {
            System.err.println("⚠️ StaleElementReferenceException: WebElement is detached. You may need to re-fetch it.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void clickElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            clickableElement.click();
        } catch (Exception e) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", element);
                js.executeScript("arguments[0].click();", element);
            } catch (Exception jsException) {
                throw new RuntimeException("Failed to click the element using both Selenium and JavaScript click.", jsException);
            }
        }
    }
    
    public void selectMatSelectOption(WebElement matSelect, String visibleText) {
        try {
            matSelect.click(); // Click the mat-select to open the dropdown

            // XPath to find the dropdown option by visible text
            String xpathExpression = String.format("//mat-option//span[contains(text(), '%s')]", visibleText);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement optionToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));

            optionToSelect.click(); // Click the option

            logger.info("selectMatSelectOption() - Selected option: " + visibleText);
        } catch (Exception e) {
            logger.error("selectMatSelectOption() - Failed to select option: " + visibleText, e);
        }
    }


    public void clearAndSendKeys(WebElement element, String textToBeTyped) {

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

         // Wait for the element to be visible
         WebElement welement = wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        element.sendKeys(textToBeTyped);
//    logger.info("clearAndSendKeys(), invoked and enter text  "+textToBeTyped +" in "+element);
    }

    public void clearElement(WebElement element) {

        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.clear();
        logger.info("clearElement() in" + element);
    }

    public WebElement waitForElement(WebElement element, long durationInSeconds) {

        WebElement webElement = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.info(element + " element is clickable");
        return webElement;

    }

    public void selectOptionInDropdown(WebElement element, String dropDownOption) {

        WebElement webElement = waitForElement(element, durationInSeconds);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownOption);
        logger.info("selectOptionInDropdown(), invoked , value selected from dropdown " + dropDownOption);
    }

    

}
