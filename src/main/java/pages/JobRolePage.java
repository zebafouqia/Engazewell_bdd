package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class JobRolePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By mastersMenu = By.xpath("//span[text()='Masters']");
    private final By subMenuOption = By.xpath("//span[text()='Job Role']");
   // private final By pageHeader = By.xpath("//h5[contains(text(),'Job Role Management')]");
    private final By searchBar = By.xpath("//input[@placeholder='Search']");
    private final By addJobOpeningButton = By.xpath("//*[text()='Add Job Role']");
    private final By tableHeaders = By.xpath("//div[@class='tabulator-header']//div[@role='columnheader']");

    public JobRolePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickMenu() {
        // A generic method to click on top-level menus
       // By menuLocator = By.xpath("//span[text()='Masters']");
        wait.until(ExpectedConditions.elementToBeClickable(mastersMenu)).click();
    }

    public void clickSubMenuOption(String optionName) {
        // A generic method to click on sub-menu options
        By optionLocator = By.xpath("//span[text()='Job Role']");
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }

    public boolean isOnJobRoleScreen() {
    	  // Verify the URL to confirm we are on the correct page.
        // Replace "/job-role" with the actual path segment for the Job Role screen.
        String expectedUrlPart = "/jobrole"; // You will need to confirm the actual URL path
        wait.until(ExpectedConditions.urlContains(expectedUrlPart));
        return driver.getCurrentUrl().contains(expectedUrlPart);
    }

    public boolean isSearchBarVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).isDisplayed();
    }

    public boolean isAddJobOpeningButtonVisible(String buttonText) {
       // By buttonLocator = By.xpath("//button[normalize-space()='" + buttonText + "']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addJobOpeningButton)).isDisplayed();
    }

    public List<String> getTableHeaders() {
        List<WebElement> headers = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tableHeaders));
        return headers.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}