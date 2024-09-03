package test;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CreateAccountTests extends BaseTest {
    @Test
    @Tag("@SMOKE")
    @Tag("01")
    @DisplayName("Проверка успешной регистрации личных данных пользователя")
    void test1() {
        clickOnElement(By.xpath("//*[@href='/register']"));
        clickOnElement(By.xpath("//*[@id='gender-female']"));
        fillInputField(By.xpath("//*[@name='FirstName']"), TEST_USER.getFirstName());
        fillInputField(By.xpath("//*[@name='LastName']"), TEST_USER.getLastName());
        fillInputField(By.xpath("//*[@name='Email']"), NEW_REGISTRATION.getEmail());
        fillInputField(By.xpath("//*[@name='Password']"), NEW_REGISTRATION.getPassword());
        fillInputField(By.xpath("//*[@name='ConfirmPassword']"), NEW_REGISTRATION.getPassword());
        clickOnElement(By.xpath("//*[@name='register-button']"));
        Assertions.assertTrue(elementIsDisplayed(By.xpath("//*[@href='/logout']")));
    }
}
