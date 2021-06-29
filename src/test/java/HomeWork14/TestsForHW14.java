package HomeWork14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestsForHW14 {
    /*
    A)
1. Open “https://demoqa.com/automation-practice-form”
2. Navigate to “Book Store Application”
3. Login (create your own user before)
4. Go to Book Store
5. Choose Git Pocket Guide
6. Click “Add to your Collection”
7. Handle alert similar as from last lesson (Tap Ok)
8. Click Back To Store
9. Click "You Don’t Know JS”
10.“Add to your Collection”
11. Handle Alert
12.Go to “Profile”
13.Click “Delete All Books"
     */

    @Test
    public void demoqaTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        //Добавлю нажатие на Forms чтоб свернуть меню
        WebElement formsButton = driver.findElement(By.xpath("//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-3')]/div[contains(@class,'left-pannel')]/div[contains(@class,'accordion')]/div[2]/span[1]/div[1]"));
        formsButton.click();

        WebElement bookStoreApplicationButton = driver.findElement(By.xpath("//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-3')]/div[contains(@class,'left-pannel')]/div[contains(@class,'accordion')]/div[6]/span[1]/div[1]/div[1]"));
        bookStoreApplicationButton.click();

        WebElement loginButton = driver.findElement(By.xpath("//span[normalize-space()='Login']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", loginButton);
        loginButton.click();

        WebElement userNameField = driver.findElement(By.xpath("//input[@id='userName']"));
        userNameField.sendKeys("Pislyakov");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("123Dfer@");

        WebElement loginSubmitButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginSubmitButton.click();

        WebElement goToBookStoreButton = driver.findElement(By.xpath("//button[normalize-space()='Go To Book Store']"));
        goToBookStoreButton.click();

        WebElement gitPocketGuideBookLink = driver.findElement(By.xpath("//a[normalize-space()='Git Pocket Guide']"));
        gitPocketGuideBookLink.click();

        WebElement addToYourCollectionButton = driver.findElement(By.xpath("//button[normalize-space()='Add To Your Collection']"));
        addToYourCollectionButton.click();
        Thread.sleep(5000); // Я бы рад не ставить эти задержки, но без них не хендлятся браузерные попапы
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        WebElement backToBookStoreButton = driver.findElement(By.xpath("//button[normalize-space()='Back To Book Store']"));
        backToBookStoreButton.click();

        WebElement youDontKnowJSBookLink = driver.findElement(By.xpath("//a[normalize-space()=\"You Don't Know JS\"]"));
        youDontKnowJSBookLink.click();

        WebElement addToYourCollectionButton2 = driver.findElement(By.xpath("//button[normalize-space()='Add To Your Collection']"));
        addToYourCollectionButton2.click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        WebElement profileButton = driver.findElement(By.xpath("//span[normalize-space()='Profile']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", profileButton);
        profileButton.click();

        WebElement deleteAllBooksButton = driver.findElement(By.xpath("//div[@class='text-right button di']//button[@id='submit']"));
        deleteAllBooksButton.click();

        WebElement okButtonInTheConfirmationPopup = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        okButtonInTheConfirmationPopup.click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        driver.quit();
    }

    /*1. Open “https://www.saucedemo.com/“
2. Login with standard_user
3. Add to cart first 4 products
4. Navigate to cart
5. Tap Checkout
6. Fill user data (First Name / Last Name / Zip)
7. Tap Continue
8. Tap Finish
9. Tap Back To Home
     */
    @Test
    public void saucedemoTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement userNameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        userNameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginSubmitButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginSubmitButton.click();

        //List<WebElement> deleteButtonsList = driver.findElements(By.xpath("//*[@ng-click='deleteCust(cust)'] "));
        List<WebElement> addToCartButtonList = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));

        for (int i = 0; i < 4; i++) {
            addToCartButtonList.get(i).click();
        }

        WebElement cartButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartButton.click();

        WebElement checkoutButton = driver.findElement(By.xpath("//button[normalize-space()='Checkout']"));
        checkoutButton.click();

        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='first-name']"));
        firstNameField.sendKeys("Best");

        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastNameField.sendKeys("Buyer");

        WebElement zipCodeField = driver.findElement(By.xpath("//input[@id='postal-code']"));
        zipCodeField.sendKeys("61000");

        WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton.click();

        WebElement finishButton = driver.findElement(By.xpath("//button[normalize-space()='Finish']"));
        finishButton.click();

        WebElement backHomeButton = driver.findElement(By.xpath("//button[normalize-space()='Back Home']"));
        backHomeButton.click();

        driver.quit();
    }

    /*1. Open “http://webdriveruniversity.com/To-Do-List/index.html”
2. Add new ToDo “MAKE HOMEWORK”
3. Add new ToDo “Practice Automation”
4. Mark Practice magic as resolver
5. Если получится - удалить из списка “Buy New Robes” (там нужен будет
mouse hover который мы не рассматривали)
 */
    @Test
    public void toDoTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();

        WebElement addNewToDoField = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));
        addNewToDoField.sendKeys("MAKE HOMEWORK");
        addNewToDoField.sendKeys(Keys.ENTER);
        addNewToDoField.sendKeys("Practice Automation");
        addNewToDoField.sendKeys(Keys.ENTER);

        WebElement practiceMagicNote = driver.findElement(By.xpath("//li[normalize-space()='Practice magic']"));
        practiceMagicNote.click();

        Actions action = new Actions(driver);
        WebElement buyNewRobesNote = driver.findElement(By.xpath("//li[normalize-space()='Buy new robes']"));
        action.moveToElement(buyNewRobesNote).moveToElement(driver.findElement(By.xpath("//li[normalize-space()='Buy new robes']//i[@class='fa fa-trash']"))).click().build().perform();

        driver.quit();
    }

    /*
1. Open Amazon.com
2. Click Today’s Deals
3. Choose First Product
4. Click Add To Cart
5. Click Proceed To Checkout
     */
    @Test
    public void amazonTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        WebElement todayDealsButton = driver.findElement(By.xpath("//a[normalize-space()=\"Today's Deals\"]"));
        todayDealsButton.click();

        WebElement firstProductMenu = driver.findElement(By.xpath("//a[@id='100 d3ac9d4b-announce']"));
        firstProductMenu.click();

        WebElement firstProduct = driver.findElement(By.xpath("//div[@class='a-section octopus-dlp-image-shield']"));
        firstProduct.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addToCartButton.click();

        WebElement proceedToCheckout = driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']"));
        proceedToCheckout.click();

        driver.quit();
    }
}
