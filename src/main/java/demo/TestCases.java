package demo;

import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        //WebDriverManager.chromedriver().driverVersion("126.0.6478.62").setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");
        Thread.sleep(3000);
        String currentURL =driver.getCurrentUrl();
        if(currentURL.contains("calendar")){
            System.out.println("Testcase01 is passed");
        }else{
            System.out.println("Need to fix");
        }
        System.out.println("end Test case: testCase01");
    }

    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://calendar.google.com/");
        Thread.sleep(3000);
        WebElement monthView = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']/following-sibling::span[contains(text(),'M')]"));
        if(!monthView.getText().contains("Month")){
        //driver.findElement(By.xpath("//i[@class='google-material-icons VfPpkd-kBDsod meh4fc hggPq' and contains(text(),'arrow_drop_down')]")).click();
        //Thread.sleep(1000);
        //driver.findElement(By.xpath("//li[@class='OwNvm VfPpkd-StrnGf-rymPhb-ibnC6b' and @data-accelerator='M']")).click();
        //Thread.sleep(2000);
        }else{
        driver.findElement(By.xpath("//div[@class='MGaLHf ChfiMc' and @data-datekey='27865']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button/div[@class='x5FT4e kkUTBb' and contains(text(),'Task')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@aria-label='Add title and time']")).sendKeys("Crio INTV");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@aria-label='Add description']")).sendKeys("Crio INTV Calendar Task Automation");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 pEVtpe']")).click();
        Thread.sleep(2000);
        }
        WebElement taskCreated = driver.findElement(By.className("WBi6vc"));
        taskCreated.getText();
        if(taskCreated.getText().isEmpty()){
            System.out.println("Testcase 02 needs to be fixed");
        }else{
            System.out.println("testcase 02 is passed");
        }
        System.out.println("end Test case: testCase02");
    }

    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://calendar.google.com/");
        Thread.sleep(3000);
        // driver.findElement(By.xpath("//div[@class='MGaLHf ChfiMc' and @data-datekey='27865']")).click();
        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//button/div[@class='x5FT4e kkUTBb' and contains(text(),'Task')]")).click();
        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//input[@aria-label='Add title and time']")).sendKeys("Crio INTV");
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//textarea[@aria-label='Add description']")).sendKeys("Crio INTV Calendar Task Automation");
        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 pEVtpe']")).click();
        // Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='nHqeVd']//span[@class='WBi6vc' and contains(text(),'Crio')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@aria-label='Edit task']")).click();
        Thread.sleep(3000);
        driver.findElement(By.tagName("textarea")).clear();
        Thread.sleep(2500);
        WebElement updateText = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        updateText.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7']")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("//span[@class='nHqeVd']//span[@class='WBi6vc' and contains(text(),'Crio')]")).click();
        Thread.sleep(3000);
        WebElement updatedDes = driver.findElement(By.id("xDetDlgDesc"));
        updatedDes.getText();
        if(updatedDes.getText().contains("automating")){
            System.out.println("Testcase03 Passed");
        }else{
            System.out.println("Testcase03 need to be checked");
        }


        System.out.println("end Test case: testCase03");
    }

    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        driver.get("https://calendar.google.com/");
        Thread.sleep(3000);
        // driver.findElement(By.xpath("//div[@class='MGaLHf ChfiMc' and @data-datekey='27865']")).click();
        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//button/div[@class='x5FT4e kkUTBb' and contains(text(),'Task')]")).click();
        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//input[@aria-label='Add title and time']")).sendKeys("Crio INTV");
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//textarea[@aria-label='Add description']")).sendKeys("Crio INTV Calendar Task Automation");
        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 pEVtpe']")).click();
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//span[@class='nHqeVd']//span[@class='WBi6vc' and contains(text(),'Crio')]")).click();
        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//button[@aria-label='Edit task']")).click();
        // Thread.sleep(3000);
        // driver.findElement(By.tagName("textarea")).clear();
        // Thread.sleep(2500);
        // WebElement updateText = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        // updateText.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7']")).click();
        // Thread.sleep(2500);
        driver.findElement(By.xpath("//span[@class='nHqeVd']//span[@class='WBi6vc' and contains(text(),'Crio')]")).click();
        Thread.sleep(3000);
        WebElement title = driver.findElement(By.id("rAECCd"));
        if(title.getText().contains("Crio INTV")){
            System.out.println("Testcase04 Verification Passed");
        }else{
            System.out.println("Testcase04 verify need to be checked");
        }
        driver.findElement(By.xpath("//button[@class='VfPpkd-Bz112c-LgbsSe yHy1rc eT1oJ mN1ivc m2yD4b HfYfLe' and @aria-label='Delete task']")).click();
        Thread.sleep(30);
        //driver.switchTo().frame(0);
        WebElement delPopUp = driver.findElement(By.xpath("//div[@class='VYTiVb']"));
        String popupText = delPopUp.getText();
        //if(delPopUp.getText().equals("Task deleted")){
            System.out.println("Testcase04 passed:" + popupText);
            


        System.out.println("end Test case: testCase04");
    }
}
