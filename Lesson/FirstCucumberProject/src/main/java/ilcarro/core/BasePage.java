package ilcarro.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public BasePage() {
        PageFactory.initElements(driver,this);
    }

    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //    @Step("Заполняем поле {locator}, значением {value}")
    public void fillInputField(WebElement element, String text) {
        element.click();
        element.clear();
        String value = (text == null) ? " " : text;
        element.sendKeys(value);
    }

    //    @Step("Кликаем на элемент с локатором - {0}")
    public void clickOnElement(WebElement element) {
        (element).click();
    }

    //    @Step("Проверяем наличие элемента на странице")
    public boolean elementIsDisplayed(List<WebElement> list) {
        return list.size() > 0;
    }

}
