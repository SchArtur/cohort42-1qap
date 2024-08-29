package hw;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork1 {
    ChromeDriver driver;

    @BeforeEach
    void startDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterEach
    void closeDriver() {
        driver.quit();
    }

    @Test
    void test1() {

        driver.get("https://demowebshop.tricentis.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://google.com/");


        Assertions.assertEquals("Demo Web Shop", driver.getTitle(), "Open page with another title");
    }
}
