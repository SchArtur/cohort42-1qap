package homework;

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

import java.time.Duration;

public class BaseHomeWork {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @BeforeEach
    public void startDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/login");
        Assertions.assertEquals("Demo Web Shop. Login", driver.getTitle(), "Открыта страница с другим Title");
    }
    public WebElement waitForClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public Alert getAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void fillInputField(By locator, String value) {
        WebElement element = waitForClickableElement(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, element.getAttribute("value"),
                "Введенные данные отличаются от данных у элемента");
    }
    public void clickOnElement(By locator) {
        waitForClickableElement(locator).click();
    }
    public void checkElementOnDisplay(By locator) {
        Assertions.assertTrue(driver.findElements(locator).size() > 0,
                String.format("Элемент с локатором - %s не найден", locator));
    }
    @AfterEach
    public  void closeDriver(){
        driver.quit();
    }
}
