package app.web.telranedu.core;

import app.web.telranedu.data.Contact;
import app.web.telranedu.data.User;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final User TEST_USER = new User("manuel@gm.com", "Manuel1234$");
    protected static final Contact TEST_CONTACT = new Contact("TestUnuTest","Testov","1234567890", getRandomEmail(), "address","discr");
    protected static final User NEW_USER = new User(getRandomEmail(), "Qweeee123!");

    @BeforeEach
    void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//        driver.manage().window().maximize();
        driver.get("https://telranedu.web.app");
    }

    @AfterEach
    void closeDriver() {
        driver.quit();
    }

    public WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement waitForClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public Alert getAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    @Step("Заполняем поле {0}, значением {1}")
    public void fillInputField(By locator, String value) {
        WebElement element = waitForClickableElement(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    @Step("Кликаем на элемент с локатором - {0}")
    public void clickOnElement(By locator) {
        waitForClickableElement(locator).click();
    }

    @Step("Проверяем наличие элемента на странице")
    public boolean elementIsDisplayed(By locator) {
        return getElements(locator).size() > 0;
    }

    @Step("Генерируем рандомный email")
    public static String getRandomEmail() {
        char[] chars = "0123456789abcdefgh".toCharArray();
        Random random = new SecureRandom();
        char[] result = new char[8];
        for (int i = 0; i < result.length; i++) {
            int randomIndex = random.nextInt(chars.length);
            result[i] = chars[randomIndex];
        }
        String email = new String(result) + "@test.com";
        return email;
    }

    @Step("Ожидаем {0} секунд")
    protected void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void loginTestUser() {
        clickOnElement(By.cssSelector("[href='/login']"));
        fillInputField(By.xpath("//*[@name='email']"), TEST_USER.getEmail());
        fillInputField(By.xpath("//*[@name='password']"), TEST_USER.getPassword());
        clickOnElement(By.xpath("//*[text()='Login']"));
    }

}
