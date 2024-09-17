package theIntertet.core;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = theIntertet.core.AppManager.driver;
        this.wait = theIntertet.core.AppManager.wait;
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

    @Step("Ожидаем {0} секунд")
    public void waitInSeconds(int seconds) {
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


}
