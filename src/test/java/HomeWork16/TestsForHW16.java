package HomeWork16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestsForHW16 {
    /*
   1. Open https://demoqa.com/frames
   2. Switch to first frame
   3. Get text from frame and print it
   4. Switch to default content
   5. Switch to second frame
   6. Get text from second frame and print it
        */
    @Test
    public void test_A() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        WebElement frameTitle = driver.findElement(By.id("sampleHeading"));
        System.out.println("Frame 1 title: " + frameTitle.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("frame2")));
        System.out.println("Frame 2 title: " + driver.findElement(By.id("sampleHeading")).getText());
        driver.quit();
    }

    /*
1.Open https://demoqa.com/automation-practice-form
2. Fill the form (please skip steps upload file and subjects)
3. Submit
     */
    @Test
    public void test_B() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Ann");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Smith");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("annsmith@test.email");
        driver.findElement(By.xpath("//label[normalize-space()='Female']")).click();
        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("0501234567");

        WebElement sportsCheckbox = driver.findElement(By.xpath("//label[normalize-space()='Sports']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        sportsCheckbox.click();

        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Freedom avenue, 2");
        driver.findElement(By.xpath("//*[@class=' css-yk16xz-control']")).click();
        driver.findElement(By.xpath("//div[contains(text(), 'Rajasthan')]")).click();
        System.out.println();
        driver.findElement(By.xpath("//*[@id='city']")).click();
        driver.findElement(By.xpath("//div[contains(text(), 'Jaipur')]")).click();
        System.out.println();

        submitButton.click();
        driver.quit();
    }

    /*
1. Open https://demoqa.com/text-box
2. Fill text form
3. Submit
 */
    @Test
    public void test_C() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Ann Smith");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("annsmith@ua.com");
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Kharkiv, Ukraine");
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Lubotin");
        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        submitButton.click();
        driver.quit();
    }

    /*
1. Open http://way2automation.com/way2auto_jquery/dropdown.php#load_box
2. Choose Austria using text (Pay Attention that dropdown placed in iframe)
3. Choose 25th country
4. Choose country by value “ShiLanka”
*/
    @Test
    public void test_D() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://way2automation.com/way2auto_jquery/dropdown.php#load_box");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='dropdown/default.html']")));

        WebElement dropDown = driver.findElement(By.xpath("//select"));

        Select select = new Select(dropDown);
        select.selectByVisibleText("Austria");
        select.selectByIndex(25);
        select.selectByValue("SriLanka");
        System.out.println();
        driver.quit();
    }
}
