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

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    @FindBy(css = "[class='text-center']")
    public List<WebElement> titleTextCenter;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage() {
        this.driver = Init.driver;
        this.wait = Init.wait;
        this.js = (JavascriptExecutor) driver;
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

    public void jsClickElement(WebElement element) {
        js.executeScript("arguments[0].click()", element);
    }

    public void scrollPage() {
        js.executeScript("window.scrollBy(0,600)");
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

}
