package core;

import data.Registration;
import data.User;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
    protected static final Registration TEST_REGISTRATION = new Registration("larysa@gmail.com", "qwerty");
    protected final Registration NEW_REGISTRATION = new Registration(getRandomEmail(), "qwerty");
    protected static final User TEST_USER = new User("Larysa", "Petrova");

    @BeforeEach
    public void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/login");
        Assertions.assertEquals("Demo Web Shop. Login", driver.getTitle(), "Открыта страница с другим Title");
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
        fillInputField(By.cssSelector("[name='Email']"), TEST_REGISTRATION.getEmail());
        fillInputField(By.cssSelector("[name='Password']"), TEST_REGISTRATION.getPassword());
        clickOnElement(By.cssSelector("[value='Log in']"));
    }
}



