package app.demowebshop.test;

import app.demowebshop.core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTests extends BaseTest {
    @Test
    @DisplayName("Проверка авторизации с валидными данными")
    void test1() {
        clickOnElement(By.xpath("//*[@href='/login']"));
        fillInputField(By.xpath("//*[@id='Email']"), TEST_USER.getEmail());
        fillInputField(By.xpath("//*[@id='Password']"), TEST_USER.getPassword());
        clickOnElement(By.xpath("//*[@value='Log in']"));
        Assertions.assertTrue(elementIsDisplayed(By.xpath("//*[@href='/logout']")));
    }

}
