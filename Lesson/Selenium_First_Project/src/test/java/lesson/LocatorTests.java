package lesson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorTests extends BaseTest {

    @Test
    @Tag("@1234")
    @Tag("@PHONEBOOK")
    @DisplayName("Поиск элементов на странице Phonebook")
    void test1234() {
        // Поиск элемента <h1> на странице и проверка его текста
        WebElement tagElementH1 = driver.findElement(By.tagName("h1"));
        // Проверяем, что текст заголовка равен "PHONEBOOK"
        Assertions.assertEquals("PHONEBOOK", tagElementH1.getText(),
                "Заголовок страницы не PHONEBOOK");

        // Поиск всех элементов <a> на странице и проверка, что их список не пуст
        List<WebElement> listAElements = driver.findElements(By.tagName("a"));
        // Проверяем, что найдено хотя бы один элемент <a>
        Assertions.assertTrue(!listAElements.isEmpty(),
                "Список элементов пуст");

        // Поиск элемента по полному тексту ссылки
        WebElement linkTextElement = driver.findElement(By.linkText("LOGIN"));
        // Проверяем, что значение атрибута href соответствует ожидаемому
        Assertions.assertEquals("/login", linkTextElement.getDomAttribute("href"),
                "Аттрибут элемента не соответствует ожидаемому");

        // Поиск элемента по частичному тексту ссылки
        WebElement partialLinkTextElement = driver.findElement(By.partialLinkText("LOG"));
        // Проверяем, что текст элемента совпадает с ожидаемым
        Assertions.assertEquals("LOGIN", partialLinkTextElement.getText(),
                "Текст элемента не соответствует ожидаемому");

        // Поиск элемента по атрибуту name
        WebElement elementByName = driver.findElement(By.name("login"));
        // Проверяем, что значение атрибута type соответствует ожидаемому
        Assertions.assertEquals("submit", elementByName.getAttribute("type"),
                "Аттрибут элемента не соответствует ожидаемому");

        // Поиск элемента по имени класса
        WebElement classNameElement = driver.findElement(By.className("container"));
        // Проверяем, что элемент с указанным классом отображается на странице
        Assertions.assertTrue(classNameElement.isDisplayed(),
                "Элемент по имени класса отсутствует");

        // Поиск элемента по ID
        WebElement elementById = driver.findElement(By.id("root"));
        // Проверяем, что элемент с указанным ID отображается на странице
        Assertions.assertTrue(elementById.isDisplayed(),
                "Элемент по id отсутствует");
    }

    @Test
    void test2() {
        // Поиск элемента <form> на странице
        WebElement parentElement = driver.findElement(By.tagName("form"));
        // Поиск элемента с именем "login" внутри найденного <form>
        WebElement loginButton = parentElement.findElement(By.name("login"));
        // Проверяем, что кнопка "login" отображается
        Assertions.assertTrue(loginButton.isDisplayed(), "Элемент loginButton отсутствует");
    }
}