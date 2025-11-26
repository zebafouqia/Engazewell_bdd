package pages;
import org.openqa.selenium.Keys;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

public class ProfileUploadPage {
	
	private ElementUtils utils;
	 private WebDriver driver;
	    private WebDriverWait wait;
	    
	    
	    
	    private final By profile =By.xpath("//span[text()='Profile']");
	    private final By uploadClodeicon =By.xpath("//*[@aria-label='Upload Resume']");
	   	private final By browseFileLink =By.xpath("//button[text()=' or Browse Files to upload']");
	   	private final By uploadbutton = By.xpath("//button[text()='Upload']");
	   	

	    
	    
	    
	    public ProfileUploadPage(WebDriver driver) {
		       // super(driver); // ✅ explicitly call parent constructor
		        this.driver = driver;
		        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    }  
	    
	    
	    
public void profile() {
	try {
		Thread.sleep(2000);
		driver.findElement(profile).click();
	}
	catch(Exception e ) {
		
	}
}


public void uploadCloudIcon() {
	try {
		Thread.sleep(2000);
		driver.findElement(uploadClodeicon).click();
	}
	catch(Exception e ) {
		
	}
}


public void browseFile() {
	try {
		Thread.sleep(2000);
		driver.findElement(browseFileLink).click();
	}
	catch(Exception e ) {
		
	}
}


//public void uploadFileFromLocal() throws InterruptedException{
//	try {
//		 String filePath = "D:\\Automation_Engazewell\\Engazewell_bdd\\src\\main\\java\\user\\docs\\DocumentUpload.png";
//
//		    WebElement fileInput = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
//		    fileInput.sendKeys(filePath);
//		    Thread.sleep(2000);
//	}
//	catch(Exception e ) {
//		
//	}
//}

public void uploadDocumentUsingRobot() throws Exception {

    // STEP 1: Click on the Browse Files button (opens Windows dialog)
    driver.findElement(By.xpath("//button[contains(text(),'Browse')]")).click();
    Thread.sleep(2000); // allow dialog to open

    // STEP 2: File path from your system
    String filePath = "D:\\Automation_Engazewell\\Engazewell_bdd\\src\\main\\java\\user\\docs\\Naukri_VasudhaFuse[8y_0m].doc";

    // STEP 3: Copy file path to clipboard
    StringSelection selection = new StringSelection(filePath);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    // STEP 4: Use Robot class to paste and press ENTER
    Robot robot = new Robot();
    robot.delay(1000);

//    // Press CTRL + V
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);

    robot.delay(1000);

    // Press ENTER (clicks Open button)
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);

    // small wait
    Thread.sleep(2000);
    
    String filePath1 = "Naukri_VasudhaFuse[8y_0m].doc";
    
    StringSelection selection1 = new StringSelection(filePath1);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection1, null);
    robot.delay(1000);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);

    robot.delay(1000);

    // Press ENTER (clicks Open button)
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
}


public void clickUploadButton() {
	try {
		Thread.sleep(1000);
		driver.findElement(uploadbutton).click();
	}
	catch(Exception e ) {
		
	}
}

}
