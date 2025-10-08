package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.util.function.Function;

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
    private final By createNewJobRoleForm = By.xpath("//h2[text()='Create New Job Role']");
    private final By jobRoleField = By.xpath("//label[text()='Job Role']");

    
    // Locators
    private By descriptionBox = By.xpath("//div[@contenteditable='true']//parent::div//span"); ////div[@contenteditable='true']
    private By successToast = By.xpath("//div[contains(text(),'Description generated successfully')]");
    private By saveButton = By.xpath("//button[contains(text(),'Save')]");
    
    //
    // -- Stable anchors --
    private final By joditContainer = By.cssSelector("div.jodit-container"); // outer editor
    private final By joditIframe    = By.cssSelector("iframe.jodit-wysiwyg_iframe");
    private final By joditEditable  = By.xpath(
        "(//div[contains(@class,'jodit-wysiwyg') and @contenteditable='true' and " +
        "not(ancestor-or-self::*[@style[contains(.,'display: none')]])])[1]");
    
//    public JobRolePage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
    
    public JobRolePage(WebDriver driver) {
        this.driver = driver;
        // keep a moderately small default wait; for specific waits we'll create new WebDriverWaits
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    public void clickOnAddJobRoleButton() {
    
    	wait.until(ExpectedConditions.elementToBeClickable(addJobOpeningButton)).click();
    }
    public boolean  createNewJobRoleFormIsDisplayed() {
    	return wait.until(ExpectedConditions.elementToBeClickable(createNewJobRoleForm)).isDisplayed();
    }
    
//    public void enterJobRole() {
//    	
//    	 By jobRoleFieldfield = By.xpath("//label[text()='Job Role']");
//         wait.until(ExpectedConditions.elementToBeClickable(jobRoleField));
//          WebElement inputFieldJobRole = driver.findElement(By.xpath("//label[text()='Job Role']//..//..//input[@placeholder='Enter the job role']"));
//         inputFieldJobRole.clear();
//         inputFieldJobRole.sendKeys("FrontEnd Lead");
//             
//    }
    
    public void enterJobRole() {
        By jobRoleInput = By.xpath("//label[text()='Job Role']//..//..//input[@placeholder='Enter the job role']");
        WebElement inputFieldJobRole = wait.until(ExpectedConditions.elementToBeClickable(jobRoleInput));
        inputFieldJobRole.clear();
        inputFieldJobRole.sendKeys("Backend Lead");
        // Send TAB to trigger blur/change event quickly
        inputFieldJobRole.sendKeys(Keys.TAB);
        // small explicit wait for any JS processing after blur (use short wait)
        new WebDriverWait(driver, Duration.ofSeconds(2))
            .until(driver1 -> true); // cheap 2 sec pause; adjust down if flaky
    }
    private boolean hasIframe() {
        return !driver.findElements(joditIframe).isEmpty() &&
               driver.findElement(joditIframe).isDisplayed();
    }

    /** Focus the editor surface (iframe body or contenteditable div) */
//    private void focusEditor() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(joditContainer));
//
//        if (hasIframe()) {
//            // switch into iframe and click body to focus
//            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(joditIframe));
//            WebElement body = (WebElement)((JavascriptExecutor)driver).executeScript("return document.body;");
//            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'})", body);
//            new Actions(driver).moveToElement(body).click().perform();
//            // keep focus inside iframe for sending keys, then caller will switch out
//        } else {
//            WebElement editable = wait.until(ExpectedConditions.visibilityOfElementLocated(joditEditable));
//            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'})", editable);
//            // Sometimes toolbar overlays part of it → click center using Actions:
//            new Actions(driver).moveToElement(editable).click().perform();
//        }
//    }
    
//    private void focusEditor() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(joditContainer));
//        if (hasIframe()) {
//            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(joditIframe));
//            // click inside the body to ensure focus
//            WebElement body = (WebElement)((JavascriptExecutor)driver).executeScript("return document.body;");
//            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'})", body);
//            new Actions(driver).moveToElement(body).click().perform();
//            // stay in iframe for shortcut; caller must switch back (we do below)
//        } else {
//            WebElement editable = wait.until(ExpectedConditions.visibilityOfElementLocated(joditEditable));
//            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'})", editable);
//            new Actions(driver).moveToElement(editable).click().perform();
//        }
//    }

    private void focusEditor() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(joditContainer));
        if (hasIframe()) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(joditIframe));
            // click inside the body to ensure focus
            WebElement body = (WebElement)((JavascriptExecutor)driver).executeScript("return document.body;");
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'})", body);
            new Actions(driver).moveToElement(body).click().perform();
            // stay in iframe for shortcut; caller must switch back (we do below)
        } else {
            WebElement editable = wait.until(ExpectedConditions.visibilityOfElementLocated(joditEditable));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'})", editable);
            new Actions(driver).moveToElement(editable).click().perform();
        }
    }
    // 1. Trigger AI Description (Ctrl + G)
//    public void generateDescriptionWithShortcut() throws InterruptedException {
//    	 focusEditor();
//         Actions act = new Actions(driver);
//         act.keyDown(Keys.CONTROL).sendKeys("g").keyUp(Keys.CONTROL).perform();
//         // if we were inside iframe, get back out
//         try { driver.switchTo().defaultContent(); } catch (Exception ignored) {}
//    }
////    	Actions action= new Actions(driver);
////        WebElement desc = wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionBox));
////       // wait.until(ExpectedConditions.elementToBeClickable(desc));
////        Thread.sleep(2000);
////        action.doubleClick(desc);
//////        action.doubleClick(desc);
////                Thread.sleep(2000);
//////                action.doubleClick(desc);      
////        desc.sendKeys(Keys.chord(Keys.CONTROL, "g")); // Ctrl+G
////    }
////
    
    public void generateDescriptionWithShortcut() {
        // Focus editor and send Ctrl+G
        focusEditor();
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).sendKeys("g").keyUp(Keys.CONTROL).perform();

        // If we were inside iframe, switch back to default content so we can detect toast & click save
        try {
            driver.switchTo().defaultContent();
        } catch (Exception ignored) {}

        // Wait specifically for the "Description generated successfully" toast.
        // Use a short explicit wait (e.g. up to 8s) — this avoids long sleeps.
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(8));
        try {
           // shortWait.until(ExpectedConditions.visibilityOfElementLocated(successToast));
        } catch (Exception e) {
            // If toast not shown, try a small retry: wait a bit and re-check editor content
        }

        // Ensure editor actually has text. If the editor uses iframe, get its body text; else read contenteditable div.
        boolean hasText = ensureEditorHasContentAndTriggerInputEvent();
        if (!hasText) {
            // fallback: try once more to trigger Ctrl+G and re-check (optional)
            // act.keyDown(Keys.CONTROL).sendKeys("g").keyUp(Keys.CONTROL).perform();
            // shortWait.until(ExpectedConditions.visibilityOfElementLocated(successToast));
            // ensureEditorHasContentAndTriggerInputEvent();
        }
    }
    
    private boolean ensureEditorHasContentAndTriggerInputEvent() {
        String contentText = "";
        try {
            if (hasIframe()) {
                // switch to iframe and read body innerText
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(joditIframe));
                contentText = (String)((JavascriptExecutor)driver).executeScript("return document.body.innerText || document.body.textContent || '';");
                // trigger input event on the body so app picks up the change
                ((JavascriptExecutor)driver).executeScript(
                    "var e = new Event('input', {bubbles:true}); document.body.dispatchEvent(e);"
                );
                driver.switchTo().defaultContent();
            } else {
                // read from contenteditable div
                WebElement editable = wait.until(ExpectedConditions.visibilityOfElementLocated(joditEditable));
                contentText = editable.getText();
                ((JavascriptExecutor)driver).executeScript(
                    "var el = arguments[0]; var e = new Event('input', {bubbles:true}); el.dispatchEvent(e);", editable
                );
            }
        } catch (Exception ex) {
            // swallow and return false so caller can decide
        }

        // Also trigger a blur on a safe element to force commit
        try {
            WebElement someSafeElement = driver.findElement(By.tagName("body"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].focus();", someSafeElement);
        } catch (Exception ignored) {}

        return contentText != null && contentText.trim().length() > 5; // threshold to ensure non-empty
    }
    
//     2. Verify Success Toast   
         public boolean isDescriptionGeneratedSuccessfully() {
        	 boolean toast = false;
        	 try {
				Thread.sleep(1000);
				
				// toast = wait.until(ExpectedConditions.visibilityOfElementLocated(successToast));
				toast = driver.findElement(successToast).isDisplayed();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      
      System.out.println(toast +" success message");
		return toast;
    
    }

    // 3. Click Save
    public void clickSave() throws InterruptedException {
    	try {
			Thread.sleep(1000);
			Actions actions = new Actions(driver);
	    	WebElement SaveButtn = driver.findElement(saveButton);
	    	// actions.scrollToElement(SaveButtn).click().perform();
	    	actions.moveToElement(SaveButtn).click().perform();
	        Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//JavascriptExecutor JavascriptExecutor = ( JavascriptExecutor)driver;
    	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
      //  WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
     //   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
      //  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
       //  ((WebElement) saveButton).click();
    	
      //  wait.until(ExpectedConditions.elementToBeClickable(saveButton));
      //  ((WebElement) saveButton).click();
        
        
    }
    
    
//    
         
//         public void clickSave() {
//             // Wait for Save button to be clickable; use small wait
//             WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(6));
//             WebElement saveBtn = shortWait.until(ExpectedConditions.elementToBeClickable(saveButton));
//
//             // Make sure the editor content was committed before clicking save
//             boolean editorOk = ensureEditorHasContentAndTriggerInputEvent();
//             if (!editorOk) {
//                 // optional: throw, or attempt short retry
//                 System.out.println("Warning: editor looked empty before save. Trying to trigger input event again.");
//                 ensureEditorHasContentAndTriggerInputEvent();
//             }
//
//             try {
//                 // click via JS if normal click is flaky due to overlay
//                 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
//                 try { Thread.sleep(200); } catch (InterruptedException ignored) {}
//                 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", saveBtn);
//             } catch (WebDriverException e) {
//                 // fallback to normal click
//                 saveBtn.click();
//             }
//
//             // After clicking Save, wait for the job role created success popup (adjust locator below)
//             new WebDriverWait(driver, Duration.ofSeconds(8))
//                 .until(ExpectedConditions.or(
//                     ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Job role created successfully') or contains(text(),'created successfully')]")),
//                     ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'loading') or contains(@class,'spinner')]"))
//                 ));
//         }

//    public void jobRoleCreatedSuccessPopup() {
//    	try {
//    		Thread.sleep(1000);
//    		
//    		WebElement successPopUp = driver.findElement(By.xpath(""));
//    		
//    	}catch(Exception e) {
//    		
//    	}
//    }
    
         public boolean jobRoleCreatedSuccessPopup() {
             try {
                 WebElement success = new WebDriverWait(driver, Duration.ofSeconds(8))
                         .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Job role created successfully') or contains(text(),'created successfully')]")));
                 return success.isDisplayed();
             } catch (Exception e) {
                 return false;
             }
         }
}