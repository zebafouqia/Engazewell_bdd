package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ScheduleAspiraInterviewPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;

    // ===== Locators (update if your app uses different attributes) =====
    private By scheduleNav = By.xpath("//a[normalize-space()='Schedule Interview' or contains(@href,'schedule-interview')]");
    private By createInterviewBtn = By.xpath("//p[text()='Create Interview']");
    private By jobOpeningDropdown = By.xpath("//label[contains(.,'Job Opening')]/following::div[1]"); // open dropdown
    private By jobOption(String job) { return By.xpath("(//li[text()='" + job + "'])[1]"); }

    private By locationDropdown = By.xpath("//label[contains(.,'Location')]/following::div[1]");
    private By locationOption(String loc) { return By.xpath("//li[text()='" + loc + "']"); }

    private By candidateEmailInput = By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused css-dsrjpj']");
    private By candidateEmailOption(String email) { return By.xpath("//li[contains(text(),'" + email + "')]"); }

    private By aspiraOptionBtn = By.xpath("//button[text()='Aspira']");
    private By dateInput = By.xpath("//input[@placeholder='MM/DD/YYYY']");
   //  WebElement startTimeInput = driver.findElement(By.xpath("//input[contains(@placeholder,'Start Time') or contains(@aria-label,'start time')]"));
    //private By endTimeInput = By.xpath("//input[contains(@placeholder,'End Time') or contains(@aria-label,'end time')]");

    private By attendeeInput = By.xpath("//input[@placeholder='Add Attendee Emails *']");
    private By interviewRoundDropdown = By.xpath("//label[contains(.,'Interview Round')]/following::div[1]");
    private By interviewRoundOption(String round) { return By.xpath("//li[text()='" + round + "']"); }

    private By panelMemberDropdown = By.xpath("//label[contains(.,'Panel Member')]/following::div[1]");
    private By providerDropdown = By.xpath("//label[contains(.,'Provider')]/following::div[1]");
    private By providerOption(String provider) { return By.xpath("//li[text()='" + provider + "']"); }

    private By nextButton = By.xpath("(//button[text()='Next'])[2]");
    private By attachFileInput = By.xpath("//input[@type='file']"); // prefer this if present and supports multiple
    private By confirmAndSendBtn = By.xpath("//button[contains(.,'Confirm') and contains(.,'Send') or contains(text(),'Confirm & Send')]");
    private By successToast = By.xpath("//*[contains(@class,'toast') or contains(@role,'alert')][contains(.,'Interview') or contains(.,'created')]");
    private By createdInterviewRow = By.xpath("//table//td[contains(.,'Interview') or contains(.,'Panel')]/.."); // adjust to your table

    // ===== Constructor =====
    public ScheduleAspiraInterviewPage(WebDriver driver) {
        this.driver = driver;
        //this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // this.wait = new WebDriverWait(driver, 15);
        this.js = (JavascriptExecutor) driver;
    }

    // ===== Navigation / Basic Actions =====
    public void goToScheduleInterview() {
        wait.until(ExpectedConditions.elementToBeClickable(scheduleNav)).click();
    }

    public void clickCreateInterview() {
        wait.until(ExpectedConditions.elementToBeClickable(createInterviewBtn)).click();
    }

    public void selectJobOpening(String jobName) {
        wait.until(ExpectedConditions.elementToBeClickable(jobOpeningDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(jobOption(jobName))).click();
    }

    public void selectLocation(String locationName) {
        wait.until(ExpectedConditions.elementToBeClickable(locationDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(locationOption(locationName))).click();
    }

    public void chooseCandidateByEmail(String email) throws InterruptedException {
    	Thread.sleep(2000);
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(candidateEmailInput));
      //  input.clear();
        input.click();
        input.sendKeys(email);
        // wait for suggestion list and click the matching option
        wait.until(ExpectedConditions.elementToBeClickable(candidateEmailOption(email))).click();
    }

    public void chooseAspiraOption() {
        wait.until(ExpectedConditions.elementToBeClickable(aspiraOptionBtn)).click();
    }

    // ===== Date & Time helpers =====
    // Formats - change to match your UI control formatting
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH:mm");

    
    public void setDate(LocalDate date) {
        // Ensure this format matches the UI placeholder. Update if the picker expects other pattern.
        DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatted = date.format(DATE_FMT);

        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(dateInput));

        // remove readonly if present
        js.executeScript("arguments[0].removeAttribute('readonly')", el);

        // Use native setter so React's internal value tracker is updated properly
        String nativeSetterScript =
            "var el = arguments[0]; var value = arguments[1];" +
            "var descriptor = Object.getOwnPropertyDescriptor(el.__proto__,'value') || Object.getOwnPropertyDescriptor(HTMLInputElement.prototype,'value');" +
            "if (descriptor && descriptor.set) descriptor.set.call(el, value); else el.value = value;" +
            "el.dispatchEvent(new Event('input', { bubbles: true }));" +
            "el.dispatchEvent(new Event('change', { bubbles: true }));" +
            "return el.value;";
        Object result = js.executeScript(nativeSetterScript, el, formatted);

        // If setting value worked, done.
        if (result != null && formatted.equals(result.toString())) {
            return;
        }

        // --- Fallback: open calendar and pick day (more resilient) ---
        try {
            // open the datepicker by clicking the calendar icon button near the input
            // tune selector if your calendar button is different
            WebElement calButton = el.findElement(By.xpath("following::button[1]"));
            calButton.click();

            // Wait for calendar panel to appear
            By calendarRoot = By.xpath("//*[contains(@class,'MuiPickersCalendar') or contains(@class,'MuiDatePicker') or contains(@class,'MuiCalendarPicker')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(calendarRoot));

            // If the visible month is not the month we need, click next/prev until it matches
            // Build target month/year text (e.g. "December 2025") - adapt if your UI uses abbreviated month
            String targetMonthYear = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + date.getYear();

            // Try to read header; if differs, click next/prev
            By monthHeader = By.xpath("//*[contains(@class,'MuiPickersCalendarHeader') or contains(@class,'MuiCalendarPicker-root')]//p | //div[contains(@class,'MuiPickersToolbar')]/div");
            for (int i = 0; i < 12; i++) { // safety limit
                List<WebElement> headers = el.findElements(monthHeader);
                boolean matches = false;
                for (WebElement h : headers) {
                    if (h.getText() != null && h.getText().trim().contains(date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH))) {
                        matches = true;
                        break;
                    }
                }
                if (matches) break;

                // try clicking next month button
                try {
                    WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@aria-label='Next month' or contains(@class,'MuiPickersArrowSwitcher') or contains(@title,'Next')]")));
                    nextBtn.click();
                    Thread.sleep(200); // small pause to allow calendar to re-render
                } catch (Exception ex) {
                    // no next button found — break and try to select day anyway
                    break;
                }
            }

            // Day value (no leading zero)
            String day = String.valueOf(date.getDayOfMonth());

            // MUI's day elements are usually buttons with class like MuiPickersDay and text = day
            // Use several fallback xpaths to increase match probability
            By dayXPath1 = By.xpath("//button[contains(@class,'MuiPickersDay') and normalize-space()='" + day + "']");
            By dayXPath2 = By.xpath("//button[normalize-space()='" + day + "' and not(contains(@class,'otherMonth'))]"); // avoid other months
            By dayXPath3 = By.xpath("//div[contains(@class,'MuiDay') or contains(@class,'day')]//button[normalize-space()='" + day + "']");

            WebElement dayEl = null;
            try { dayEl = wait.until(ExpectedConditions.elementToBeClickable(dayXPath1)); } catch (Exception ignored) {}
            if (dayEl == null) {
                try { dayEl = wait.until(ExpectedConditions.elementToBeClickable(dayXPath2)); } catch (Exception ignored) {}
            }
            if (dayEl == null) {
                try { dayEl = wait.until(ExpectedConditions.elementToBeClickable(dayXPath3)); } catch (Exception ignored) {}
            }

            if (dayEl != null) {
                dayEl.click();
            } else {
                // Last-resort: pick by aria-label which often contains full date text, e.g. "Choose Thursday, December 11th, 2025"
                String monthName = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
                String maybeAria = monthName + " " + date.getDayOfMonth();
                By ariaXpath = By.xpath("//button[contains(@aria-label, '" + maybeAria + "')]");
                WebElement ariaEl = wait.until(ExpectedConditions.elementToBeClickable(ariaXpath));
                ariaEl.click();
            }

            // optionally dispatch change on input again (some pickers write back to input asynchronously)
            js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true })); arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", el);

        } catch (Exception e) {
            System.out.println("Fallback datepicker click failed: " + e.getMessage());
            // for debugging: take screenshot or print page source here
        }
    }


    
    //3
 // Use 12-hour format with AM/PM
    private static final DateTimeFormatter TIME_FMT_12 =
            DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
  
    
    public void setInterviewTimes() throws InterruptedException {

        // Generate Start Time (current time + 10 min)
        LocalTime startTime = LocalTime.now().plusMinutes(10);

        // Generate End Time (start time + 30 min)
        LocalTime endTime = startTime.plusMinutes(30);

        // Format in 12-hour format with AM/PM
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);

        String formattedStart = startTime.format(timeFormatter);  // e.g. "03:45 PM"
        String formattedEnd = endTime.format(timeFormatter);      // e.g. "04:15 PM"

        System.out.println("Start Time → " + formattedStart);
        System.out.println("End Time → " + formattedEnd);

        // Enter Start Time
        WebElement startTimeInput = driver.findElement(By.xpath("(//input[@placeholder='hh:mm aa'])[1]"));
        startTimeInput.click();
        startTimeInput.sendKeys(Keys.CONTROL + "a"); // select all existing content
        startTimeInput.sendKeys(formattedStart);
        startTimeInput.sendKeys(Keys.TAB);

        Thread.sleep(300);

        // Enter End Time
        WebElement endTimeInput = driver.findElement(By.xpath("(//input[@placeholder='hh:mm aa'])[2]"));
        endTimeInput.click();
        endTimeInput.sendKeys(Keys.CONTROL + "a");
        endTimeInput.sendKeys(formattedEnd);
        endTimeInput.sendKeys(Keys.TAB);

        Thread.sleep(300);
    }

    
    
    public void addAttendeeEmail(String email) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(attendeeInput));
        el.sendKeys(email);
        WebElement p = driver.findElement(By.xpath("//li"));
       
        p.click();
       // WebElement p1 = driver.findElement(By.xpath("//li"));
       // p1.click();
       // p.sendKeys(Keys.ENTER);
    }

    public void selectInterviewRound(String round) {
        wait.until(ExpectedConditions.elementToBeClickable(interviewRoundDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(interviewRoundOption(round))).click();
    }

    public void selectProvider(String provider) {
        wait.until(ExpectedConditions.elementToBeClickable(providerDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(providerOption(provider))).click();
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    /**
     * Attach files using input[type='file'] if available.
     * Accepts absolute paths (preferred). For multiple files, join with newline or send as array depending on driver.
     */
    public void attachFiles(List<String> absoluteFilePaths) {
        // Ensure input is present
        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(attachFileInput));
        // Selenium supports multiple files by sending newline-separated absolute paths
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < absoluteFilePaths.size(); i++) {
            sb.append(Paths.get(absoluteFilePaths.get(i)).toString());
            if (i < absoluteFilePaths.size() - 1) sb.append("\n");
        }
        fileInput.sendKeys(sb.toString());
    }

    /**
     * If file input is not present or the site opens native dialog, use Robot/AutoIT externally.
     * Fallback Robot code can be written in test if needed.
     */

    public void confirmAndSend() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmAndSendBtn)).click();
    }

    public boolean isInterviewCreated() {
        // Wait for toast or new row in table
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(successToast),
                    ExpectedConditions.visibilityOfElementLocated(createdInterviewRow)
            ));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // ===== Utility: generate a valid date/time set (today/future & future start time) =====
    public static ScheduleDateTime generateValidInterviewDateTime(ZoneId zoneId) {
        LocalDate date = LocalDate.now(zoneId);
        LocalTime now = LocalTime.now(zoneId);
        LocalTime start = now.plusMinutes(10);
        LocalTime end = start.plusMinutes(30);
        return new ScheduleDateTime(date, start, end);
    }

    public static class ScheduleDateTime {
        public final LocalDate date;
        public final LocalTime start;
        public final LocalTime end;
        public ScheduleDateTime(LocalDate d, LocalTime s, LocalTime e) { this.date = d; this.start = s; this.end = e; }
    }
}


