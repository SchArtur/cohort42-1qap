package app.web.telranedu.test;

import app.web.telranedu.core.BaseTest;
import app.web.telranedu.data.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

@Tag("@Login")
public class LoginPageTest extends BaseTest {

    @Test
    @Tag("@SMOKE")
    @Tag("@3")
    @DisplayName("Проверка авторизации с валидными данными")
    void test3() {
        clickOnElement(By.cssSelector("[href='/login']"));
        fillInputField(By.xpath("//*[@name='email']"), TEST_USER.getEmail());
        fillInputField(By.xpath("//*[@name='password']"), TEST_USER.getPassword());
        clickOnElement(By.xpath("//*[text()='Login']"));
        Assertions.assertTrue(elementIsDisplayed(By.xpath("//*[@href='/contacts']")));
    }

    @Test
    @Tag("@SMOKE")
    @Tag("@4")
    @DisplayName("Проверка регистрации с валидными данными")
    void test4() {
        clickOnElement(By.cssSelector("[href='/login']"));
        fillInputField(By.xpath("//*[@name='email']"), NEW_USER.getEmail());
        fillInputField(By.xpath("//*[@name='password']"), NEW_USER.getPassword());
        clickOnElement(By.xpath("//*[text()='Registration']"));
        waitInSeconds(2);
        Assertions.assertTrue(elementIsDisplayed(By.xpath("//*[@href='/contacts']")));
    }


}
