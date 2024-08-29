package lesson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CssSelectorTests extends BaseTest {

    @Test
    @DisplayName("Проверка поиска элемента по css")
    void test1() {
        // Поиск элемента по абсолютному пути CSS-селектора
        WebElement tagElement1 = driver.findElement(By.cssSelector("html body div div h1"));
        // Проверяем, что текст заголовка страницы равен "PHONEBOOK"
        Assertions.assertEquals("PHONEBOOK", tagElement1.getText(), "Заголовок страницы не PHONEBOOK");

        // Поиск элемента по относительному пути CSS-селектора
        WebElement tagElement2 = driver.findElement(By.cssSelector("h1"));
        // Проверяем, что текст заголовка страницы равен "PHONEBOOK"
        Assertions.assertEquals("PHONEBOOK", tagElement2.getText(), "Заголовок страницы не PHONEBOOK");

        // Поиск дочернего элемента с использованием CSS-селектора
        WebElement childElement = driver.findElement(By.cssSelector("form > input"));
        // Проверяем, что дочерний элемент (input) отображается на странице
        Assertions.assertTrue(childElement.isDisplayed(), "Не найден дочерний элемент");

        // Поиск элемента по ID с использованием CSS-селектора
        WebElement idElement = driver.findElement(By.cssSelector("#root"));
        // Проверяем, что элемент с ID "root" отображается на странице
        Assertions.assertTrue(idElement.isDisplayed(), "Не найден элемент по id");

        // Поиск элемента по class с использованием CSS-селектора
        WebElement classElement = driver.findElement(By.cssSelector(".container"));
        // Проверяем, что элемент с классом "container" отображается на странице
        Assertions.assertTrue(classElement.isDisplayed(), "Не найден элемент по class");

        // Поиск элемента по атрибуту с использованием CSS-селектора
        WebElement atrElement = driver.findElement(By.cssSelector("[name='email']"));
        // Проверяем, что элемент с атрибутом name="email" отображается на странице
        Assertions.assertTrue(atrElement.isDisplayed(), "Не найден элемент по атрибуту");

        // Примеры других селекторов
        /**
         * Поиск элемента по атрибуту, содержащему часть значения:
         * contains -> *=
         * Например: By.cssSelector("input[name*='mai']")
         * Поиск элемента по атрибуту, начинающемуся с определенного значения:
         * start with -> ^=
         * Например: By.cssSelector("input[name^='ema']")
         * Поиск элемента по атрибуту, заканчивающем на определенное значение:
         * end on -> $=
         * Например: By.cssSelector("input[name$='ail']")
         */
    }

    @Test
    @DisplayName("Проверка усяавторизации с валидными данными")
    void test2() {
        // Заполняем поле ввода email
        fillInputField(By.name("email"), "manuel@gm.com");
        // Заполняем поле ввода password
        fillInputField(By.name("password"), "Manuel1234$");
        // Нажимаем кнопку Login
        clickOnElement(By.name("login"));
        // Проверяем отображение элемента, указывающего на успешный вход
        checkElementOnDisplay(By.cssSelector("[href='/contacts']"));
    }
}