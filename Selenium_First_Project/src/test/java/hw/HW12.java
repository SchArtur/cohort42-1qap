package hw;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW12 {
    WebDriver driver;

    @BeforeEach
    void startDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        //driver.get("https://demowebshop.tricentis.com/login");
    }

    @AfterEach
    void CloseDriver() {
        driver.quit();
    }

    @Test
    @DisplayName("Поиск элементов на странице Demo Web Shop")

    void Test1() {
       //Assertions.assertEquals("Demo Web Shop", driver.getTitle(), "Открыта другая страница");

       //1. class="master-wrapper-page"
        WebElement classNameElement = driver.findElement(By.className("master-wrapper-page"));
        Assertions.assertTrue(classNameElement.isDisplayed(), "Элемент по имени класса отсутствует");

        //2. class="center-3"
        WebElement classNameElement1 = driver.findElement(By.className("center-3"));
        Assertions.assertTrue(classNameElement1.isDisplayed(), "Элемент по имени класса отсутствует");

        //3. value="Subscribe"
        WebElement attributValue = driver.findElement(By.cssSelector("[value='Subscribe']"));
        Assertions.assertTrue(attributValue.isDisplayed(), "Элемент по атрибуту  отсутствует");

        //4.Tricentis
        WebElement linkTextElement = driver.findElement(By.linkText("Tricentis"));
        Assertions.assertEquals("/tricentis", linkTextElement.getDomAttribute("href"),"Аттрибут элемента не соответствует ожидаемому");

        //5.Books
        WebElement linkTextElement1 = driver.findElement(By.linkText("Books"));
        Assertions.assertEquals("/books", linkTextElement1.getDomAttribute("href"),"Аттрибут элемента не соответствует ожидаемому");


        //6.value="Vote"
        WebElement attributVote = driver.findElement(By.cssSelector("[value='Vote']"));
        Assertions.assertTrue(attributVote.isDisplayed(), "Элемент по атрибуту  отсутствует");

        //7.Register
        WebElement linkTextElemetRegister = driver.findElement(By.linkText("Register"));
        Assertions.assertEquals("/register", linkTextElemetRegister.getDomAttribute("href"),"Аттрибут элемента не соответствует ожидаемому");

        //8.class="poll-vote-error"
        WebElement classNameElementPollError = driver.findElement(By.className("poll-vote-error"));
        Assertions.assertTrue(classNameElementPollError.isDisplayed(), "Элемент по имени класса отсутствует");

        //9.id="topcartlink"
        WebElement topCartElemtn = driver.findElement(By.id("topcartlink"));
        Assertions.assertTrue(topCartElemtn.isDisplayed(), "Элемент с таким id отсутствует");

        //10.id="small-searchterms"
        WebElement smallSearchtermsElemetn = driver.findElement(By.id("small-searchterms"));
        Assertions.assertTrue(smallSearchtermsElemetn.isDisplayed(), "Элемент с таким id отсутствует");
    }

}
