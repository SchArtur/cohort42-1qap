package phonebook.core;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import phonebook.model.Contact;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = AppManager.driver;
        this.wait = AppManager.wait;
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

    @Step("Заполняем поле {locator}, значением {value}")
    public void fillInputField(WebElement element, String text) {
        element.click();
        element.clear();
        String value = (text == null) ? " " : text;
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

    @Step("Проверяем наличие элемента на странице")
    public boolean elementIsDisplayed(WebElement element) {
        return element != null;
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

    @Step("Генерируем новый contact")
    public static Contact getNewContact() {
        return new Contact(getName(), "Testov", "1234567890", getRandomEmail(), "address", "discr");
    }

    @Step("Ожидаем {0} секунд")
    public static void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Делаем скриншот в Аллюр отчёт
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) AppManager.driver).getScreenshotAs(OutputType.BYTES);
    }

//    @Step("Делаем скриншот")
//    public static String takeScreenshotPath(){
//        File tmp = ((TakesScreenshot) AppManager.driver).getScreenshotAs(OutputType.FILE);
//        File screenshot = new File(String.format("screenshots/screen%s.png", System.currentTimeMillis()));
//        try {
//            Files.copy(tmp.toPath(), screenshot.toPath());
//            Allure.addAttachment("Screenshot", new FileInputStream(screenshot));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return screenshot.getAbsolutePath();
//    }

}
