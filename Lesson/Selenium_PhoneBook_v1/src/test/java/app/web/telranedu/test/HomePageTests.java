package app.web.telranedu.test;

import app.web.telranedu.core.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

@Tag("@HOME")
@Tag("@ALL")
public class HomePageTests extends BaseTest {

    @Test
    @Tag("@1")
    @DisplayName("Проверка корректного отображения страницы HOME")
    void test1() {
        clickOnElement(By.cssSelector("[href='/home']"));
        Assertions.assertAll(
                () -> assertTrue(elementIsDisplayed(By.xpath("//*[text()='Home Component']")), "Не соответствует h1"),
                () -> assertTrue(elementIsDisplayed(By.xpath("//*[text()='React Contacts App']")), "Не соответствует h2"),
                () -> assertTrue(elementIsDisplayed(By.xpath("//*[text()='For QA Testing']")), "Не соответствует h3")
        );
    }

}
