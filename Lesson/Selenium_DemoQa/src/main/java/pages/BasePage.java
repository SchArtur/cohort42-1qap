package pages;

import core.Init;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage extends JSExecutor {

    @FindBy(css = "[class='text-center']")
    public List<WebElement> titleTextCenter;

    protected WebDriverWait wait;

    public BasePage() {
        this.wait = Init.wait;
        PageFactory.initElements(driver, this);
    }

    public WebElement getElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void fillInputField(WebElement element, String text) {
        element.click();
        element.clear();
        String value = (text == null) ? " " : text;
        element.sendKeys(value);
    }

    public Alert getAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
//        return driver.switchTo().alert();
    }

    public String getTitleTextCenter() {
        return titleTextCenter.get(0).getText();
    }

    public boolean titleTextCenterIsDisplayed() {
        return titleTextCenter.size() > 0;
    }

    public String getAlertText() {
        String alertText = getAlert().getText();
        getAlert().accept();
        return alertText;
    }

    public void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getRandomEmail() {
        return getRandomValue() + "@test.de";
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

    public String getLink(WebElement element) {
        String resultLink = element.getAttribute("href");
        if (resultLink == null) {
            return element.getAttribute("src");
        }
        return resultLink;
    }

    //Метод проверяет наличие картинки
    public boolean imageIsDisplayed(WebElement image) {
        return (boolean) js.executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth > 0 );", image);
    }

    //Метод проверяет валидность ссылки
    //Статус коды ответов по группам
    //100 - информационные
    //200 - успешные
    //300 - перенаправление, переадресация, redirect
    //400 - ошибки клиента
    //500 - ошибки сервера
    public boolean linkIsValid(String link) {
        try {
            URL url = new URL(link);
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
