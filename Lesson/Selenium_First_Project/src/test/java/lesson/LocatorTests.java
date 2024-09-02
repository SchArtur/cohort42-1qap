package lesson;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LocatorTests extends BaseTest{

    @Test
    @Tag("@1234")
    @Tag("@PHONEBOOK")
    @DisplayName("Поиск элементов на странице Phonebook")
    void test1234() {
//        <h1>PHONEBOOK</h1>
        WebElement tagElementH1 = driver.findElement(By.tagName("h1"));
        assertEquals("PHONEBOOK",tagElementH1.getText(), "Заголовок страницы не PHONEBOOK" );

        List<WebElement> listAElements = driver.findElements(By.tagName("a"));
        Assertions.assertTrue(!listAElements.isEmpty(), "Список элементов пуст");

//        <a href="/login" style="">LOGIN</a>
//        особенность данного метода, и почему его почти не используют, он ищет текст, только когда есть атрибуты в тэге
        WebElement linkTextElement = driver.findElement(By.linkText("LOGIN"));
//        Надо быть внимательнее с аттрибутом href, может возвращать полную ссылку
        assertEquals("/login", linkTextElement.getDomAttribute("href"),"Аттрибут элемента не соответствует ожидаемому");

        WebElement partialLinkTextElement = driver.findElement(By.partialLinkText("LOG"));
        assertEquals("LOGIN", partialLinkTextElement.getText(), "Текст элемента не соответствует ожидаемому");

//        <button type="submit" name="login">Login</button>
        WebElement elementByName = driver.findElement(By.name("login"));
        assertEquals("submit", elementByName.getAttribute("type"),"Аттрибут элемента не соответствует ожидаемому");

        WebElement classNameElement = driver.findElement(By.className("container"));
        Assertions.assertTrue(classNameElement.isDisplayed(), "Элемент по имени класса отсутствует");

        WebElement elementById = driver.findElement(By.id("root"));
        Assertions.assertTrue(elementById.isDisplayed(), "Элемент по id отсутствует");
    }

    @Test
    void test2() {
        WebElement parentElement = driver.findElement(By.tagName("form"));
        WebElement loginButton = parentElement.findElement(By.name("login"));
        Assertions.assertTrue(loginButton.isDisplayed(), "Элемент loginButton отсутствует");
    }
}
