package HomeWork15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestsForHW15 {
    /*
   Task 1
1. Launch a new Chrome browser.
2. Open Shop.DemoQA.com
3. Get Page Title name and Title length
4. Print Page Title and Title length on the Eclipse Console.
5. Get Page URL and verify if it is a correct page opened
6. Get Page Source (HTML Source code) and Page Source length
7. Print Page Length.
8. Close the Browser.
*/
    @Test
    public void task1Test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.demoqa.com/");
        driver.manage().window().maximize();

        String pageTitle = driver.getTitle();
        int pageTitleLength = pageTitle.length();

        System.out.println("Title: " + pageTitle);
        System.out.println("pageTitleLength: " + pageTitleLength);

        //Get Page URL and verify if it is a correct page opened
        Assert.assertEquals(driver.getCurrentUrl(), "https://shop.demoqa.com/");

        //Get Page Source (HTML Source code) and Page Source length
        String pageSource = driver.getPageSource();
        int pageSourceLength = pageSource.length();

        System.out.println("pageSourceLength: " + pageSourceLength);
        driver.quit();
    }

    /*
Task 2
1. Launch a new Chrome browser.
2. Open https://www.toolsqa.com/automation-practice-switch-windows/
3. Click “New Window”
4. Close the browser using close() command
*/
    @Test
    public void task2Test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
        driver.manage().window().maximize();

        WebElement newWindowButton = driver.findElement(By.xpath("//button[normalize-space()='New Window']"));
        newWindowButton.click();
        driver.close();
    }

    /*
  Task 3
1. Launch new Browser
2. Open DemoQA.com website
3. Click on Registration link using
4. Come back to Home page (Use ‘Back’ command)
5. Again go back to Registration page (This time use ‘Forward’ command)
6. Again come back to Home page (This time use ‘To’ command)
7. Refresh the Browser (Use ‘Refresh’ command)
8. Close the Browser
*/
    @Test
    public void task3Test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.demoqa.com/");
        driver.manage().window().maximize();

        WebElement myAccountLink = driver.findElement(By.xpath("//a[normalize-space()='My Account']"));
        WebElement dismissLink = driver.findElement(By.xpath("//a[normalize-space()='Dismiss']"));

        dismissLink.click();
        myAccountLink.click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to("https://shop.demoqa.com/");
        driver.navigate().refresh();
        driver.quit();
    }

    /*
 Task 4
1. Launch new Browser
2. Open https://demoqa.com/progress-bar
3. Click Start
4. Add WebDriverWait for waiting “Reset” button is displayed
5. Click reset
6. Add WebDriverWait for waiting “Start” button is displayed
*/
    @Test
    public void task4Test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();

        WebElement startButton = driver.findElement(By.xpath("//button[normalize-space()='Start']"));
        startButton.click();

        WebElement resetButton = driver.findElement(By.xpath("//button[normalize-space()='Reset']"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(resetButton));
        resetButton.click();
        WebElement startButton1 = driver.findElement(By.xpath("//button[normalize-space()='Start']"));
        wait.until(ExpectedConditions.visibilityOf(startButton1));
        driver.quit();
    }

    /*
Task 5
1. Launch new Browser
2. Open “https://demoqa.com/dynamic-properties
3. Add WebDriverWait for waiting to button “Visible After 5 Seconds” to be
displayed
*/
    @Test
    public void task5Test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();

        WebElement visibleAfter5secondsButton = driver.findElement(By.xpath("//button[normalize-space()='Visible After 5 Seconds']"));
        WebDriverWait wait = new WebDriverWait(driver, 0); // Я наверно что-то не понял. Почему тест проходит с таймаутом в 0 секунд?
        wait.until(ExpectedConditions.visibilityOf(visibleAfter5secondsButton));
        System.out.println("Hello!");
        driver.quit();
    }
}
