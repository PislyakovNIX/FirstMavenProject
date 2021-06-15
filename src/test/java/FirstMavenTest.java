import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirstMavenTest {

    @Test
    public void firstSeleniumTest() throws InterruptedException {

        String pathToRootOfProject = System.getProperty("user.dir");
        String pathToChromeDriver = pathToRootOfProject + "/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.i.ua/");

        By loginFieldLocator = By.cssSelector("input[name='login']");
        WebElement loginField = webDriver.findElement(loginFieldLocator);
        loginField.sendKeys("tigrtest@i.ua");

        By passwordFieldLocator = By.cssSelector("input[name='pass']");
        WebElement passwordField = webDriver.findElement(passwordFieldLocator);
        passwordField.sendKeys("tigr123");

        By submitButtonLocator = By.xpath("//input[@title='Вход на почту']");
        WebElement submitButton = webDriver.findElement(submitButtonLocator);
        submitButton.click();

        Thread.sleep(10000);

        webDriver.quit();
    }

    @Test
    public void FirstTestOnFireFoxBrowser() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.i.ua/");

        By loginFieldLocator = By.cssSelector("input[name='login']");
        WebElement loginField = driver.findElement(loginFieldLocator);
        loginField.sendKeys("tigrtest@i.ua");

        By passwordFieldLocator = By.cssSelector("input[name='pass']");
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys("tigr123");

        By submitButtonLocator = By.xpath("//input[@title='Вход на почту']");
        WebElement submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();

        Thread.sleep(10000);

        driver.quit();

    }
}
