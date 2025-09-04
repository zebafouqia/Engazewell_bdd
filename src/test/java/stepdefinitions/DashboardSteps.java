package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;
import Driverfactory.DriverFactory;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DashboardSteps {
	//private Properties prop;
    //private LoginPage loginPage;

    private DashboardPage dashboardPage;
    private Properties prop;
    public DashboardSteps() {
          this.prop = new ConfigReader().intializeProperties();
          this.dashboardPage = new DashboardPage(DriverFactory.getDriver());
        
    }

    @Given("I am logged into the application")
    public void i_am_logged_into_the_application() {
        // Navigation to dashboard implies user is logged in
    	
        dashboardPage.navigateToDashboard();
    }

    @When("I navigate to the dashboard page")
    public void i_navigate_to_the_dashboard_page() {
        dashboardPage.navigateToDashboard();
    }

    @Then("I should see the dashboard statistics with the following values:")
    public void i_should_see_the_dashboard_statistics_with_the_following_values(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> stats = dataTable.asMaps(String.class, String.class);
        
        for (Map<String, String> stat : stats) {
            String metricName = stat.get("Metric");
            String expectedValue = stat.get("Value");
            
            String actualValue = dashboardPage.getStatisticValue(metricName);
            Assert.assertEquals(actualValue, expectedValue, 
                "Mismatch in " + metricName + " statistic. Expected: " + expectedValue + ", Actual: " + actualValue);
        }
    }

    @Then("I should see the following statistics cards:")
    public void i_should_see_the_following_statistics_cards(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedCards = dataTable.asList(String.class);
        
        for (String cardName : expectedCards) {
            boolean isDisplayed = dashboardPage.isStatisticCardDisplayed(cardName);
            Assert.assertTrue(isDisplayed, "Statistics card '" + cardName + "' should be displayed");
        }
    }

    @Then("I should see the subscription usage table with headers:")
    public void i_should_see_the_subscription_usage_table_with_headers(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedHeaders = dataTable.asList(String.class);
        List<String> actualHeaders = dashboardPage.getSubscriptionTableHeaders();
        
        Assert.assertEquals(actualHeaders, expectedHeaders, "Subscription table headers don't match");
    }

    @Then("the subscription usage should contain:")
    public void the_subscription_usage_should_contain(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);
        List<Map<String, String>> actualData = dashboardPage.getSubscriptionTableData();
        
        for (int i = 0; i < expectedData.size(); i++) {
            Map<String, String> expectedRow = expectedData.get(i);
            Map<String, String> actualRow = actualData.get(i);
            
            for (String key : expectedRow.keySet()) {
                Assert.assertEquals(actualRow.get(key), expectedRow.get(key), 
                    "Mismatch in subscription table at row " + (i + 1) + " for column '" + key + "'");
            }
        }
    }

    @Then("I should see the upload summary section")
    public void i_should_see_the_upload_summary_section() {
        boolean isDisplayed = dashboardPage.isUploadSummaryDisplayed();
        Assert.assertTrue(isDisplayed, "Upload summary section should be displayed");
    }

    @Then("I should see {string} in the upload summary")
    public void i_should_see_in_the_upload_summary(String expectedText) {
        String uploadSummaryText = dashboardPage.getUploadSummaryText();
        Assert.assertTrue(uploadSummaryText.contains(expectedText), 
            "Upload summary should contain: " + expectedText + ". Actual: " + uploadSummaryText);
    }

    @And("I verify all dashboard statistics are loaded")
    public void i_verify_all_dashboard_statistics_are_loaded() {
        boolean statsLoaded = dashboardPage.areStatisticsLoaded();
        Assert.assertTrue(statsLoaded, "All dashboard statistics should be loaded");
    }
}