package utilities;

import java.util.Date;


import io.cucumber.java.Scenario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class CommonUtils {

    public static final int IMPLICIT_WAIT_TIME = 10;
    public static final int PAGE_LOAD_TIME = 15;
    public static final int EXPLICIT_WAIT_BASIC_TIME = 20;
    private static Logger logger = LogManager.getLogger(CommonUtils.class);

    public static String getEmailWithTimeStamp() {

        Date date = new Date();
        String newEmail = "newemail" + date.toString().replace(" ", "").replace(":", "") + "@gmail.com";
        logger.info("getEmailWithTimeStamp() invoked and returning new email " + newEmail);
        return newEmail;

    }

    public static byte[] takeScreenShot(Scenario scenario, WebDriver driver, String scenarioName) {
        byte[] srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        logger.info("takeScreenShot() invoked , screenshot taken");
        return srcScreenshot;
    }
    
    public static String extractNumericValue(String input) {
        // Split the string by spaces and take the first part
        String[] parts = input.split(" ");
        return parts[0]; // Return the first part, which is the numeric value
    }
    
    public static String convertToIntegerString(String input) {
        // Remove commas and decimal part, then convert to integer string
        return String.valueOf((int) Float.parseFloat(input.replace(",", "")));
    }
}