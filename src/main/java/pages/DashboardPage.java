package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private final By dashboardSidebarLink = By.xpath("//span[text()='dashboard']");
    private final By dashboardTitle = By.xpath("//h2[contains(text(),'Dashboard') or contains(text(),'Databoard')]");
    
    // Statistics cards
    private final By totalProfilesCard = By.xpath("//*[text()='Total Profiles']//..//h6");
    private final By resumesTodayCard = By.xpath("//*[text()='Resumes Uploaded (Today)']//..//h6");
    
    // Subscription Usage table
    private final By subscriptionTable = By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3 MuiCard-root css-1kr6suf']");
    private final By subscriptionTableHeaders = By.xpath("//table//thead//..");
    private final By subscriptionTableRows = By.xpath(".//tbody//tr | .//tr[position()>1]");
    
    // Upload Summary section
    private final By uploadSummarySection = By.xpath("//h3[contains(text(),'Upload Summary')] | //div[contains(text(),'Upload Summary')]");
    private final By uploadSummaryContent = By.xpath("./following-sibling::div | ./following-sibling::ul");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void navigateToDashboard() {
        try {
            WebElement dashboardLink = wait.until(ExpectedConditions.elementToBeClickable(dashboardSidebarLink));
           
           
            dashboardLink.click();
            waitForDashboardToLoad();
        } catch (Exception e) {
            throw new RuntimeException("Failed to navigate to dashboard: " + e.getMessage());
        }
    }

    private void waitForDashboardToLoad() {
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTitle));
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalProfilesCard));
    }

    public String getStatisticValue(String statisticName) {
        try {
            By locator = getStatisticLocator(statisticName);
            WebElement valueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return valueElement.getText().trim();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get value for statistic: " + statisticName + " - " + e.getMessage());
        }
    }

    public boolean isStatisticCardDisplayed(String statisticName) {
        try {
            By locator = getStatisticLocator(statisticName);
            WebElement cardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return cardElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public List<String> getSubscriptionTableHeaders() {
        List<String> headers = new ArrayList<>();
        try {
            WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionTable));
            List<WebElement> headerElements = table.findElements(subscriptionTableHeaders);
            
            for (WebElement header : headerElements) {
                headers.add(header.getText().trim());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to get subscription table headers: " + e.getMessage());
        }
        return headers;
    }

    public List<Map<String, String>> getSubscriptionTableData() {
        List<Map<String, String>> tableData = new ArrayList<>();
        List<String> headers = getSubscriptionTableHeaders();
        
        try {
            WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionTable));
            List<WebElement> rows = table.findElements(subscriptionTableRows);
            
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.xpath(".//td"));
                if (cells.size() == headers.size()) {
                    Map<String, String> rowData = new HashMap<>();
                    for (int i = 0; i < headers.size(); i++) {
                        rowData.put(headers.get(i), cells.get(i).getText().trim());
                    }
                    tableData.add(rowData);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to get subscription table data: " + e.getMessage());
        }
        return tableData;
    }

    public boolean isUploadSummaryDisplayed() {
        try {
            WebElement uploadSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadSummarySection));
            return uploadSummary.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getUploadSummaryText() {
        try {
            WebElement uploadSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadSummarySection));
            WebElement content = uploadSummary.findElement(uploadSummaryContent);
            return content.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean areStatisticsLoaded() {
        try {
            // Check if main statistics are loaded
            boolean totalProfilesLoaded = wait.until(ExpectedConditions.visibilityOfElementLocated(totalProfilesCard)).isDisplayed();
            boolean resumesTodayLoaded = wait.until(ExpectedConditions.visibilityOfElementLocated(resumesTodayCard)).isDisplayed();
            boolean subscriptionLoaded = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionTable)).isDisplayed();
            boolean uploadSummaryLoaded = isUploadSummaryDisplayed();
            
            return totalProfilesLoaded && resumesTodayLoaded && subscriptionLoaded && uploadSummaryLoaded;
        } catch (Exception e) {
            return false;
        }
    }

    private By getStatisticLocator(String statisticName) {
        switch (statisticName) {
            case "Total Profiles":
                return totalProfilesCard;
            case "Resumes Uploaded (Today)":
                return resumesTodayCard;
            case "Subscription Usage":
                return subscriptionTable;
            case "Upload Summary":
                return uploadSummarySection;
            default:
                throw new IllegalArgumentException("Unknown statistic name: " + statisticName);
        }
    }

    // Utility methods for specific statistics
    public int getTotalProfilesCount() {
        String value = getStatisticValue("Total Profiles");
        return parseNumber(value);
    }

    public int getResumesUploadedTodayCount() {
        String value = getStatisticValue("Resumes Uploaded (Today)");
        return parseNumber(value);
    }

    private int parseNumber(String text) {
        try {
            // Extract numbers from text (remove any non-digit characters)
            String numericString = text.replaceAll("[^0-9]", "");
            return Integer.parseInt(numericString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}