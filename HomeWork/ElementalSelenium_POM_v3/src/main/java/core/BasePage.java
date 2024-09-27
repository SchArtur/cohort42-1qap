package core;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static core.AppManager.URL;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    JavascriptExecutor js;

    @FindBy(css = "[class='text-center']")
    public List<WebElement> titleTextCenter;

    public BasePage() {
        this.driver = AppManager.driver;
        this.wait = AppManager.wait;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Alert getAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Получаем текст всплывающего уведомления")
    public String getAlertText() {
        String alertText = getAlert().getText();
        getAlert().accept();
        return alertText;
    }
    public String getTitleTextCenter() {
        return titleTextCenter.get(0).getText();
    }

    public boolean titleTextCenterIsDisplayed() {
        return titleTextCenter.size() > 0;
    }

    @Step("Переходим на главную страницу")
    public void goToHomePage() {
        driver.get(URL);
    }

    @Step("Заполняем поле {locator}, значением {value}")
    public void fillInputField(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    @Step("Кликаем на элемент с локатором - {0}")
    public void clickOnElement(WebElement element) {
        waitForClickableElement(element).click();
    }

    @Step("Проверяем наличие элемента на странице")
    public boolean elementIsDisplayed(List<WebElement> list) {
        return list.size() > 0;
    }

    @Step("Генерируем случайный email")
    public static String getRandomEmail() {
        return getName() + "@test.de";
    }

    @Step("Генерируем случайное имя")
    public static String getName() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random random = new SecureRandom();
        char[] result = new char[6];
        for (int i = 0; i < result.length; i++) {
            int randomIndex = random.nextInt(chars.length);
            result[i] = chars[randomIndex];
        }
        return new String(result);
    }

    public static String getRandomValue() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random random = new SecureRandom();
        char[] result = new char[6];
        for (int i = 0; i < result.length; i++) {
            int randomIndex = random.nextInt(chars.length);
            result[i] = chars[randomIndex];
        }
        return new String(result);
    }

    @Step("Ожидаем {0} секунд")
    protected void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void jsClickElement(WebElement element) {
        js.executeScript("arguments[0].click()", element);
    }

    public void scrollPage() {
        js.executeScript("window.scrollBy(0,600)");
    }

//    @Attachment(value = "Screenshot", type = "image/png")
//    public static byte[] takeScreenshot() {
//        return ((TakesScreenshot) AppManager.driver).getScreenshotAs(OutputType.BYTES);
//    }

    @Step("Делаем скриншот")
    public static String takeScreenshotPath() {
        File tmp = ((TakesScreenshot) AppManager.driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(String.format("screenshots/screen%s.png", System.currentTimeMillis()));
        try {
            Files.copy(tmp.toPath(), screenshot.toPath());
            Allure.addAttachment("Screenshot", new FileInputStream(screenshot));
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }

    @Step("Метод для работы с alert")
    public void handleAlert(String action, String text) {
        Alert alert = driver.switchTo().alert();
        switch (action.toLowerCase()) {
            case "accept":
                // Для простого alert или confirm - нажимаем OK
                alert.accept();
                break;

            case "dismiss":
                // Для confirm - нажимаем Cancel
                alert.dismiss();
                break;

            case "prompt":
                // Для prompt - вводим текст и нажимаем OK
                if (text != null) {
                    alert.sendKeys(text);
                }
                alert.accept();
                break;

            default:
                throw new IllegalArgumentException("Invalid action: " + action);
        }
    }
    public String getLink(WebElement element) {
        String resultLink = element.getAttribute("href");
        if (resultLink == null) {
            return element.getAttribute("src");
        }
        return resultLink;
    }
    public boolean imageIsDisplayed(WebElement image) {
        return (boolean) js.executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth > 0 );", image);
    }

    public boolean linkIsValid(String link) {
        try {
            java.net.URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            int statusCode = connection.getResponseCode();
            if (statusCode >= 400) {
                System.out.printf("Ссылка - %s, код ответа %s, сообщение ответа %s - BROKEN\n", link, statusCode, connection.getResponseMessage());
            } else {
                System.err.printf("Ссылка - %s, код ответа %s, сообщение ответа %s - VALID\n", link, statusCode, connection.getResponseMessage());
            }
            return  statusCode < 400;
        } catch (MalformedURLException e) {
            System.err.printf("Вместо ссылки переданы не корректные данные - %s\n", link);
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean linkIsValid(WebElement linkElement) {
        return linkIsValid(getLink(linkElement));
    }
}
