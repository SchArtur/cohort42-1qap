package hw;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HomeWork12 {
    ChromeDriver driver;

    @BeforeEach
    void startDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterEach
    void closeDriver() {
        driver.quit();
    }


    @Test
    @DisplayName("Searching the elements on website WEB DEMO SHOP")
    void test() {
        WebElement tagElementh1 = driver.findElement(By.tagName("h2"));
        Assertions.assertEquals("Welcome to our store", tagElementh1.getText(), "The name is not Welcome to our store");

        List<WebElement> listAElements = driver.findElements(By.tagName("a"));
        Assertions.assertTrue(!listAElements.isEmpty(), "The List is empty");

        WebElement registerTextLink = driver.findElement(By.linkText("Register"));
        Assertions.assertEquals("/register", registerTextLink.getDomAttribute("href"), "Attribute does not match");

        WebElement logInTextLink = driver.findElement(By.linkText("Log in"));
        Assertions.assertEquals("/login", logInTextLink.getDomAttribute("href"), "Attribute does not match");

        WebElement classHeaderElement = driver.findElement(By.className("header"));
        Assertions.assertTrue(classHeaderElement.isDisplayed(), "Element is absence");

        WebElement classBodyElement = driver.findElement(By.className("page-body"));
        Assertions.assertTrue(classBodyElement.isDisplayed(), "Element is absent");

        List<WebElement> listGiftElements = driver.findElements(By.partialLinkText("gift"));
        Assertions.assertTrue(!listGiftElements.isEmpty(), "The list is empty");

        WebElement elementById = driver.findElement(By.id("topcartlink"));
        Assertions.assertTrue(elementById.isDisplayed(), "The id is not found");

        WebElement classFooterElement = driver.findElement(By.className("footer"));
        Assertions.assertTrue(classFooterElement.isDisplayed(), "The class is missing");

        WebElement secondElementById = driver.findElement(By.id("nivo-slider"));
        Assertions.assertTrue(secondElementById.isDisplayed(), "Id is missing");


    }
}
