package HomeWork13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BankTests {

    /*
    Открыть сайт
https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
Залогиниться как Customer (for ex Harry Potter)
Зайти в Deposit, положить 1000 на депозит
Зайти в Withdraw, снять 900
Зайти в Transactions удалить все записи
     */
    @Test
    public void firstTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        Thread.sleep(3000);

        WebElement customerLoginButton = driver.findElement(By.xpath("//button[normalize-space()='Customer Login']"));
        customerLoginButton.click();

        Thread.sleep(3000);

        WebElement namesList = driver.findElement(By.xpath("//select[@id='userSelect']"));
        namesList.click();

        Thread.sleep(3000);

        WebElement harryPotterUser = driver.findElement(By.xpath("//option[contains(text(), 'Harry Potter')]"));
        harryPotterUser.click();

        Thread.sleep(3000);

        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();

        Thread.sleep(3000);


        WebElement menuDepositButton = driver.findElement(By.xpath("//button[normalize-space()='Deposit']"));
        menuDepositButton.click();

        Thread.sleep(3000);

        WebElement amountField = driver.findElement(By.xpath("//input[@placeholder='amount']"));
        amountField.sendKeys("1000");
        Thread.sleep(3000);


        WebElement depositSubmitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        depositSubmitButton.click();

        Thread.sleep(3000);

        WebElement menuWithdrawButton = driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']"));
        menuWithdrawButton.click();
        Thread.sleep(3000);

        WebElement amountFieldOnWithdrawlTab = driver.findElement(By.xpath("//input[@placeholder='amount']"));
        amountFieldOnWithdrawlTab.sendKeys("900");
        Thread.sleep(3000);

        WebElement withdrawSubmitButton = driver.findElement(By.xpath("//button[normalize-space()='Withdraw']"));
        withdrawSubmitButton.click();
        Thread.sleep(3000);

        WebElement menuTransactionsButton = driver.findElement(By.xpath("//button[normalize-space()='Transactions']"));
        menuTransactionsButton.click();
        Thread.sleep(3000);

        WebElement resetButton = driver.findElement(By.xpath("//button[normalize-space()='Reset']"));
        resetButton.click();
        Thread.sleep(3000);

        WebElement transactionsTable = driver.findElement(By.xpath("//tbody"));

        Assert.assertEquals(transactionsTable.getText(), ""); // Уверен, что есть более элегантная реализация проверки, что таблица пустая, но мои варианты работать не хотели
        driver.quit();
    }

    /*
Открыть сайт
https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
Залогиниться как manager
Добавить любого клиента (Add Customer)
Чтобы похендлить alert (нажать ok) можно использовать след:
driver.switchTo().alert().accept();
driver.switchTo().defaultContent();
(на след уроке расскажу про алерты)
Перейти на вкладку “Open Account”
 */
    @Test
    public void secondTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        Thread.sleep(3000);

        WebElement managerLoginButton = driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']"));
        managerLoginButton.click();
        Thread.sleep(3000);

        WebElement addCustomerButton = driver.findElement(By.xpath("//button[normalize-space()='Add Customer']"));
        WebElement openAccountButton = driver.findElement(By.xpath("//button[normalize-space()='Open Account']"));
        addCustomerButton.click();
        Thread.sleep(3000);

        WebElement firstNameField = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        WebElement lastNameField = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        WebElement postCodeField = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
        WebElement addCustomerSubmitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        firstNameField.sendKeys("John");
        lastNameField.sendKeys("Doe");
        postCodeField.sendKeys("61000");
        addCustomerSubmitButton.click();

        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        openAccountButton.click();
        Thread.sleep(3000);

        WebElement currencyField = driver.findElement(By.xpath("//option[normalize-space()='---Currency---']"));
        Assert.assertEquals(currencyField.getText(), "---Currency---");

        driver.quit();
    }

    /*
    Открыть сайт
https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
Залогиниться как manager
Открыть вкладку “Open Account”
Создать счет
     */
    @Test
    public void thirdTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        Thread.sleep(3000);

        WebElement managerLoginButton = driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']"));
        managerLoginButton.click();
        Thread.sleep(3000);

        WebElement openAccountButton = driver.findElement(By.xpath("//button[normalize-space()='Open Account']"));
        openAccountButton.click();
        Thread.sleep(3000);


        WebElement customerField = driver.findElement(By.xpath("//option[normalize-space()='---Customer Name---']"));
        WebElement currencyField = driver.findElement(By.xpath("//option[normalize-space()='---Currency---']"));
        WebElement harryPotterUser = driver.findElement(By.xpath("//option[contains(text(), 'Harry Potter')]"));
        WebElement dollarOptionInDropdown = driver.findElement(By.xpath("//option[contains(text(), 'Dollar')]"));
        WebElement processButton = driver.findElement(By.xpath("//button[normalize-space()='Process']"));

        customerField.click();
        Thread.sleep(3000);

        harryPotterUser.click();
        Thread.sleep(3000);

        currencyField.click();
        dollarOptionInDropdown.click();
        processButton.click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        driver.quit();
    }

    /*
    https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
Залогиниться как manager
перейти на вкладку “customers”
удалить все аккаунты
     */
    @Test
    public void fourthTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        Thread.sleep(3000);

        WebElement managerLoginButton = driver.findElement(By.xpath("//button[normalize-space()='Bank Manager Login']"));
        managerLoginButton.click();
        Thread.sleep(3000);

        WebElement menuCustomersButton = driver.findElement(By.xpath("//button[normalize-space()='Customers']"));
        menuCustomersButton.click();
        Thread.sleep(3000);

        List<WebElement> deleteButtonsList = driver.findElements(By.xpath("//*[@ng-click='deleteCust(cust)'] "));

        for (WebElement button : deleteButtonsList) {
            button.click();
            Thread.sleep(1500);
        }

        driver.quit();
    }
}