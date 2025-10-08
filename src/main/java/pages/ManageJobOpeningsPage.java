package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ElementUtils;

public class ManageJobOpeningsPage  {
	private ElementUtils utils;
	 private WebDriver driver;
	    private WebDriverWait wait;
        
	    private final By jobOpening =By.xpath("//span[text()='Job Opening']");
	    private final By jobrolefield = By.xpath("//input[@name='jobRole']"); 
	    private final By addLocation = By.xpath("//input[@placeholder='Add Locations']");
	    private final By minexperience = By.id("minExperience");
	    private final By maxexperience = By.id("maxExperience");
	    private final By qualification =By.xpath("//input[@id='qualification']");
	    private final By description = By.xpath("(//div[@class='jodit-wysiwyg']//p)[1]");
	    private final By responsibilities = By.xpath("(//div[@class='jodit-wysiwyg']//p)[2]");
	    private final By primarySkills = By.xpath("(//div[@class='jodit-wysiwyg']//p)[3]");
	    private final By secondarySkills = By.xpath("(//div[@class='jodit-wysiwyg']//p)[4]");
	    private final By totalOpenings = By.xpath("//input[@id='totalOpenings']");
	    private final By employmentType = By.xpath("//label[text()='Employment Type']");
	    private final By employmentValue = By.xpath("//li[@data-value='Full Time']");
	    private final By durationDropdown = By.xpath("//label[text()='Duration']");
	    private final By permanent = By.xpath("//ul[@id='mui-170']//li[text()='Permanent']");
	    private final By workModeDropdown = By.xpath("//span[text()='Work Mode']");
	    private final By workfromOffice =By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li[text()='Work From Office']");
	    private final By statusdropdown = By.xpath("//span[text()='Status']");
	    private final By statusDropdown = By.xpath("//li[text()='Published']");
	    private final By department = By.xpath("//span[text()='Department']");
	    private final By industryType = By.xpath("//input[@name='industryType']");
	    private final By closebutton = By.xpath("//span[text()='close']");
	    private final By tags = By.xpath("//label[text()='Tags']");
	    private final By vendors = By.xpath("//input[@placeholder='Enter the vendors']");
	    
	   
	    
	    public ManageJobOpeningsPage(WebDriver driver) {
	       // super(driver); // ✅ explicitly call parent constructor
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }  
	    
	    public void clickJobOpening()
         {
	    	try {
	    	//utils.clickElement(jobOpening);
	    		driver.findElement(jobOpening).click();
	    	}
	    	catch(Exception e) {
	    		System.out.println("job opening did not click ");
	    		e.printStackTrace();
	    	}
         }
	    public String verifyJobOpeningPageIsDisplayed() {
	        try {
	            return driver.getCurrentUrl();
	        } catch (Exception e) {
	            System.err.println("❌ Failed to get current URL: " + e.getMessage());
	            return null;
	        }
	    }
	  
	    
	    
}
