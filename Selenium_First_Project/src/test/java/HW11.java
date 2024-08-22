import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW11 {
    WebDriver driver;

    @BeforeEach
    void startDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
    }

    @AfterEach
    void CloseDriver() {

        driver.quit();
    }

    @Test
    void Test1() {
        driver.get("https://demowebshop.tricentis.com/");
        Assertions.assertEquals("Demo Web Shop", driver.getTitle(), "Открыта другая страница");
    }
}
