package core;

import data.Registration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public static final Registration TEST_REGISTRATION = new Registration("larysa@gmail.com", "qwerty");

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void closeDriver() {
        driver.quit();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }


    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }


    public WebElement waitForClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // @Step("Заполняем поле {0}, значением {1}")
    public void fillInputField(By locator, String value) {
        WebElement element = waitForClickableElement(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    //@Step("Кликаем на элемент с локатором - {0}")
    public void clickOnElement(By locator) {
        waitForClickableElement(locator).click();
    }

    //@Step("Генерируем рандомный email")
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

    // @Step("Ожидаем {0} секунд")
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