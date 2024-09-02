package app.web.telranedu.test;

import app.web.telranedu.core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("@ABOUT")
@Tag("@ALL")
public class AboutPageTests extends BaseTest {

    @Test
    @Tag("@2")
    @DisplayName("Проверка корректного отображения страницы ABOUT")
    void test2() {
      clickOnElement(By.cssSelector("[href='/about']"));
        Assertions.assertAll(
                () -> assertTrue(elementIsDisplayed(By.xpath("//*[text()=' Contacts Web Application']")),"Не соответствует h1"),
                () -> assertTrue(elementIsDisplayed(By.xpath("//*[text()='Test App']")),"Не соответствует h2"),
                () -> assertTrue(elementIsDisplayed(By.xpath("//*[text()='Use DevTools to see Network Activity']")),"Не соответствует h3")
        );
    }

}
