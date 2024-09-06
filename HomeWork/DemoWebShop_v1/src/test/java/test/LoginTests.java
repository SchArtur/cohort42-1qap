package test;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTests extends BaseTest {
    @Test
    @Tag("@SMOKE")
    @Tag("02")
    @DisplayName("Проверка успешной авторизации пользователя")
    void test2() {
        fillInputField(By.cssSelector("[name='Email']"), TEST_REGISTRATION.getEmail());
        fillInputField(By.cssSelector("[name='Password']"), TEST_REGISTRATION.getPassword());
        clickOnElement(By.cssSelector("[value='Log in']"));
        Assertions.assertTrue(elementIsDisplayed(By.cssSelector("[href='/logout']")));

    }
}
