import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork11 {
    WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void openDemoWebShop() {
        driver.get("https://demowebshop.tricentis.com/");
        Assertions.assertEquals("Demo Web Shop", driver.getTitle(), "Открыта страница с другим Title");
    }

    @AfterEach
    void closeDriver() {
        driver.quit();
    }
}

