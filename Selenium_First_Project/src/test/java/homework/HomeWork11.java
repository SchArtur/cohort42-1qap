package homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HomeWork11 {
    WebDriver driver;

    @BeforeEach
    public void startDriver(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        Assertions.assertEquals("Demo Web Shop", driver.getTitle(), "Открыта страница с другим Title");
    }
    @AfterEach
    public  void closeDriver(){
        driver.quit();
    }
    @Test
    public void test1(){
        WebElement tagElementA = driver.findElement(By.tagName("a"));
        Assertions.assertEquals("/",tagElementA.getDomAttribute("href"),
                "Элемент не найден");

        WebElement classNameElement = driver.findElement(By.className("search-box"));
        Assertions.assertTrue(classNameElement.isDisplayed(),
                "Элемент по имени класса отсутствует");

        WebElement elementById = driver.findElement(By.id("newsletter-subscribe-button"));
        Assertions.assertTrue(elementById.isDisplayed(),
                "Элемент по id отсутствует");

        WebElement linkTextElement = driver.findElement(By.linkText("Register"));
        Assertions.assertEquals("/register", linkTextElement.getDomAttribute("href"),
                "Аттрибут элемента не соответствует ожидаемому");

        List<WebElement> listAElements = driver.findElements(By.tagName("ul"));
        Assertions.assertTrue(!listAElements.isEmpty(),
                "Список элементов пуст");
    }
}
