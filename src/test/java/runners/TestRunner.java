package runners;

import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions"},
    plugin = {
        "pretty","html:target/cucumber-report.html",
        "json:target/cucumber.json"
        
    },
    monochrome = true,
    tags="@test"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // leave empty
//	  @Override
//	    @DataProvider(parallel = false)
//	    public Object[][] scenarios() {
//	        return super.scenarios();  // ✅ ensures TestNG sees scenarios as tests
	    //}
}
