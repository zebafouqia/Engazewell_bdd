package pages;
import org.openqa.selenium.Keys;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ElementUtils;

public class ManageJobOpeningsPage  {
	private ElementUtils utils;
	 private WebDriver driver;
	    private WebDriverWait wait;
        
	    private final By jobOpening =By.xpath("//span[text()='Job Opening']");
	    private final By jobOpeningButton = By.xpath("//p[text()='Add Job Opening']");
	    private final By createNewJobOpeningForm = By.xpath("//span[text()='Create New Job Opening']");
	    private final By jobrolefield = By.xpath("//div[@id='jobRole']"); 
	    private final By jobRoleDropdownOptions = By.xpath("//ul[@role='listbox']");
	    private final By jobRoleItem = By.xpath("//li[text()='Backend Lead']");
	    private final By addLocation = By.xpath("//input[@placeholder='Add Locations']");
	    private final By minexperience = By.id("minExperience");
	    private final By maxexperience = By.id("maxExperience");
	    private final By qualification =By.xpath("//input[@id='qualification']");
	    private final By description = By.xpath("(//div[@class='jodit-wysiwyg']//p)[1]");
	    private  final By shortJD = By.xpath("//textarea[@name='shortJD']");
	    private final By responsibilities = By.xpath("(//div[@class='jodit-wysiwyg']//p)[2]");
	    private final By primarySkills = By.xpath("(//div[@class='jodit-wysiwyg']//p)[2]");
	    private final By secondarySkills = By.xpath("(//div[@class='jodit-wysiwyg']//p)[2]");
	    private final By totalOpenings = By.xpath("//input[@id='totalOpenings']");
	    private final By employmentType = By.xpath("(//div[@class='MuiFormControl-root MuiFormControl-fullWidth css-tpgvqp'])[1]");
	    private final By employmentValue = By.xpath("//li[@data-value='Full Time']");
	    private final By durationDropdown = By.xpath("(//div[@class='MuiFormControl-root MuiFormControl-fullWidth css-tpgvqp'])[2]");
	    private final By permanent = By.xpath("//ul[@id='mui-170']//li[text()='Permanent']");
	    private final By workModeDropdown = By.xpath("(//div[@class='MuiFormControl-root MuiFormControl-fullWidth css-tpgvqp'])[3]");
	    private final By workfromOffice =By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li[text()='Work From Office']");
	    private final By statusdropdown = By.xpath("(//div[@class='MuiFormControl-root MuiFormControl-fullWidth css-tpgvqp'])[4]");
	    private final By statusDropdownvalue = By.xpath("//li[text()='Published']");
	    private final By department = By.xpath("//input[@id='department']");
	    private final By industryType = By.xpath("//input[@name='industryType']");
	    private final By closebutton = By.xpath("//span[text()='close']");
	    private final By saveButton = By.xpath("//button[text()='Save']");
	    private final By tags = By.xpath("//input[@placeholder='Enter the tags']");
	    private final By vendors = By.xpath("//input[@placeholder='Enter the vendors']");
	    private final By tableHeaders =By.xpath("//div[@class='tabulator-header']//div[@role='columnheader']");
	    private final By save =By.xpath("//button[text()='Save']");
	    
	   
	    
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
	            e.printStackTrace();
	            return null;
	        }
	    }
	    public void verifyAddJobOpeningButtonISDisplayed() {
	    	boolean flag = false;
	    	try {
	    		 flag = wait.until(ExpectedConditions.visibilityOfElementLocated(jobOpening)).isDisplayed();
	    		// driver.findElement(jobOpening).isDisplayed();
	    	}
	    	catch(Exception e) {
	    		if(flag == false ) {
	    			System.out.println("Job Opening button is not displayed");
	    			e.printStackTrace();
	    		}
	    	}
	    }
	    

	  
	    public void clickJobOpeningButton()
        {
	    	try {
	    	//utils.clickElement(jobOpening);
	    		driver.findElement(jobOpeningButton).click();
	    	}
	    	catch(Exception e) {
	    		System.out.println("job opening button did not click ");
	    		e.printStackTrace();
	    	}
        }
	    public void verifyCreateNewJobOpeningFormIsDisplayed() {
	    	boolean flag = false;
	    	try {
	    		 flag = wait.until(ExpectedConditions.visibilityOfElementLocated(createNewJobOpeningForm)).isDisplayed();
	    		
	    	}
	    	catch(Exception e) {
	    		if(flag == false ) {
	    			System.out.println("createNewJobOpeningForm is not displayed");
	    			e.printStackTrace();
	    		}
	    	}
	    }
	    
	    public void verifySaveandCancelButtonsAreVisible() {
	    	boolean flag = false;
	    	boolean flag1=false;
	    	try {
	    		 flag = wait.until(ExpectedConditions.visibilityOfElementLocated(closebutton)).isDisplayed();
	    		 flag1 = wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton)).isDisplayed();
	    		
	    	}
	    	catch(Exception e) {
	    		if(flag == false ) {
	    			System.out.println("closebutton is not displayed");
	    			e.printStackTrace();
	    			if(flag1 == false ) {
		    			System.out.println("saveButton is not displayed");
		    			e.printStackTrace();
	    			}
	    			
	    		}
	    	}
	    }
	    
	    public void userClicksOnJobRoleFIeld() {
	    	try {
		    
	    		Thread.sleep(2000);
		    		
		    	}
		    	catch(Exception e) {
		    		System.out.println("jobRoleField did not click ");
		    		e.printStackTrace();
		    	}
	    }

	    
	    public void selectJobRole(String roleName) {
	        // 1) Open the dropdown
	        WebElement trigger = wait.until(ExpectedConditions
	                .elementToBeClickable(jobrolefield));
	        trigger.click();

	        // 2) Grab ONLY the currently open MUI listbox
	        WebElement openListBox = wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.cssSelector("ul[role='listbox']")));

	        // 3) Find the exact option inside that listbox (scoped with ".//")
	        WebElement option = openListBox.findElement(
	                By.xpath(".//li[@role='option' and normalize-space()='" + roleName + "']"));

	        // 4) Bring it into view (virtualized lists need this) and click
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", option);
	        option.click();

	        // 5) Optional: verify the selection stuck (assert or wait for value to update)
	        wait.until(driver -> trigger.getText().trim().equals(roleName)
	                || trigger.findElements(By.xpath(".//*[normalize-space()='" + roleName + "']")).size() > 0);
	    }
	    
	    private By addLocationInput = By.cssSelector("div[aria-label='Add location'] input, input[name='location'], input[placeholder*='location' i]");

	    /**
	     * Type a query (e.g., "hyderabad") and select a suggestion (e.g., "Hyderabad, IN").
	     * If exactText is null, it selects the first suggestion.
	     */
	    public void selectLocationSuggestion(String queryText, String exactText) {
	        // 1) Focus and type
	        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(addLocationInput));
	        input.click();
	        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	        input.sendKeys(Keys.DELETE);
	        input.sendKeys(queryText);
         
	        WebElement listbox = wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.xpath("(//div[@class='MuiBox-root css-ep1tmm'])[1]")));
	        
	        driver.findElement(By.xpath("(//div[@class='MuiBox-root css-ep1tmm']//div//div)[1]")).click();

	    }
	    
	    
	    public void enterMinExp(String exp) {
	    	driver.findElement(minexperience).click();
	    	driver.findElement(minexperience).sendKeys(exp);
	    	
	    }
	    
	    public void enterMaxExp(String exp) {
	    	driver.findElement(maxexperience).click();
	    	driver.findElement(maxexperience).sendKeys(exp);
	    	
	    }
	    public void enterQualification() {
	    	driver.findElement(qualification).click();
	    	driver.findElement(qualification).sendKeys("B tech");
	    	
	    }
	    
	    public void enterShortJd() throws InterruptedException {
	    
	    	driver.findElement(shortJD).click();
	    	driver.findElement(shortJD).click();
	    	
	    	driver.findElement(shortJD).sendKeys(Keys.chord(Keys.CONTROL, "g"));
	    	Thread.sleep(5000);
	    	
  	   
	    	
	    }
	    

	    
    public void responsibilities() {
    	try {
    		Thread.sleep(15000);

    		//Thread.sleep(5000);
	    	driver.findElement(responsibilities).click();
	    	driver.findElement(responsibilities).click();
	    	
	    	driver.findElement(responsibilities).sendKeys(Keys.chord(Keys.CONTROL, "g"));
	    	Thread.sleep(5000);
	    	
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		System.out.println("could not click responsibilities");
    	}
    	
    	
    }

	    public void primarySkills() {
	    	try {
	    		Thread.sleep(15000);
	    		WebElement primaryheader = driver.findElement(By.xpath("//p[text()='Primary skills *']"));
	    		Actions act = new Actions(driver);
	    		act.scrollToElement(primaryheader).perform();
	    		Thread.sleep(4000);
	    		boolean success = false;
	    		for (int attempt = 0; attempt < 3 && !success; attempt++) {
	    			try {
	    				WebElement primary = wait.until(
	    						ExpectedConditions.elementToBeClickable(primarySkills));
	    				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", primary);
	    				driver.findElement(primarySkills).click();
	    				driver.findElement(primarySkills).click();
	    				driver.findElement(primarySkills).sendKeys(Keys.chord(Keys.CONTROL, "g"));
	    		    	Thread.sleep(5000);
	    				success = true;
	    			} catch (org.openqa.selenium.StaleElementReferenceException stale) {
	    				if (attempt == 2) {
	    					throw stale;
	    				}
	    				Thread.sleep(500);
	    			}
	    		}
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		System.out.println("could not click primary skills");
	    	}
	    }
	    public void secondarySkills() throws InterruptedException {
		  
	    	Thread.sleep(15000);
    		WebElement secondaryheader = driver.findElement(By.xpath("//p[text()='Secondary skills *']"));
    		Actions act = new Actions(driver);
    		act.scrollToElement(secondaryheader).perform();
    		Thread.sleep(4000);
    		boolean success = false;
    		for (int attempt = 0; attempt < 3 && !success; attempt++) {
    			try {
    				WebElement secondary = wait.until(
    						ExpectedConditions.elementToBeClickable(secondarySkills));
    				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", secondary);
    				driver.findElement(secondarySkills).click();
    				driver.findElement(secondarySkills).click();
    				driver.findElement(secondarySkills).sendKeys(Keys.chord(Keys.CONTROL, "g"));
    		    	Thread.sleep(15000);
    				success = true;
    			} catch (org.openqa.selenium.StaleElementReferenceException stale) {
    				if (attempt == 2) {
    					throw stale;
    					//System.out.println("could not click secondary skills");
    				}
    				
    			}
    		}
	    
    		}


    
	    public void totalJobOpeningsField(){
	    	try {
	    		driver.findElement(totalOpenings).sendKeys("2");
	    	}
	    	catch(Exception e ) {
	    		e.printStackTrace();
	    	}
	    }
	    


	    public void selectEmploymentType() {
	    	try {
				Thread.sleep(3000);
				 driver.findElement(employmentType).click();
				 driver.findElement(employmentValue).click();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("could not click on employemt type");
			}
	       
	    }
	    
	    public void selectDuration() {
	    	try {
	    		Thread.sleep(2000);
	    		driver.findElement(durationDropdown).click();
	    		driver.findElement(By.xpath("//li[text()='Permanent']")).click();
	    	}
	    	catch(Exception e ) {
	    		e.printStackTrace();
	    		System.out.println("cound not enter duration");
	    		
	    	}
	    	
	    }
	    
	    public void selectWorkMode() {
	    	try {
	    		Thread.sleep(2000);
	    		driver.findElement(workModeDropdown).click();
	    		driver.findElement(workfromOffice).click();
	    	}
	    	catch(Exception e ) {
	    		
	    	}
	    }
	     public void selectStatus() {
	    	 try {
	    		 Thread.sleep(2000);
	    		 driver.findElement(statusdropdown).click();
	    		 driver.findElement(statusDropdownvalue).click();
	    	 }
	    	 catch(Exception e) {
	    		 
	    	 }
	     }
	     public void selectDepatment() {
	    	 try {
	    		 Thread.sleep(2000);
	    		 driver.findElement(department).click();
	    		 driver.findElement(department).sendKeys("IT");
	    	 }
	    	 catch(Exception e) {
	    		 
	    	 }
	     }
	     
	     public void selectIndustryType() {
	    	 try {
	    		 Thread.sleep(2000);
	    		 driver.findElement(industryType).click();
	    		 driver.findElement(industryType).sendKeys("IT");
	    	 }
	    	 catch(Exception e) {
	    		 
	    	 }
	     }
	     public void tags() {
	    	 try {
	    		 Thread.sleep(2000);
	    		 
	    		 WebElement tag = driver.findElement(tags);
	    		 String tagValue = "T1";
	    		 tag.sendKeys(tagValue);
	    		 driver.findElement(tags).sendKeys(Keys.ENTER);
	    		// driver.findElement(tags).click();
//	    		 driver.findElement(tags).click();
//	    		 driver.findElement(tags).sendKeys("T1");
//	    		 driver.findElement(tags).sendKeys(Keys.ENTER);
	    		 
	    	 }
	    	 catch(Exception e) {
	    		 e.printStackTrace();
	    	 }
	     }
	     
	     public void vendors() {
	    	 try {
	    		 Thread.sleep(1000);
	    		 driver.findElement(vendors).click();
	    	 driver.findElement(By.xpath("//ul[@id='tags-outlined-listbox']//li[text()='empowering']")).click();
	    	 }
	    	 catch(Exception e) {
	    		 
	    	 }
	     }
	     
	     public void save() {
	    	 try {
	    		 Thread.sleep(1000);
	    		 driver.findElement(save).click();
	    	 }
	    	 catch(Exception e ) {}
	    	 
	     }
	     
	    
	    
	    

}
