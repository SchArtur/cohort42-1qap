package hw;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class HomeWork14 extends BaseTestHW {
    @Test
    @Disabled
    @DisplayName("Проверка регистрация с валидными данными")
    void test2() {
        clickOnElement(By.xpath("//*[@href='/register']"));
        clickOnElement(By.xpath("//*[@id='gender-female']"));
        fillInputField(By.xpath("//*[@name='FirstName']"), "Ha");
        fillInputField(By.xpath("//*[@name='LastName']"), "An");
        fillInputField(By.xpath("//*[@name='Email']"), "hq@gm.com");
        fillInputField(By.xpath("//*[@name='Password']"), "qwertz!12");
        fillInputField(By.xpath("//*[@name='ConfirmPassword']"), "qwertz!12");
        clickOnElement(By.xpath("//*[@name='register-button']"));
        checkElementOnDisplay(By.xpath("//*[@href='/logout']"));
    }

    @Test
    @DisplayName("Проверка авторизации с валидными данными")
    void test1() {
        clickOnElement(By.xpath("//*[@href='/login']"));
        fillInputField(By.xpath("//*[@id='Email']"), "hq@gm.com");
        fillInputField(By.xpath("//*[@id='Password']"), "qwertz!12");
        clickOnElement(By.xpath("//*[@value='Log in']"));
        checkElementOnDisplay(By.xpath("//*[@href='/logout']"));
    }

}
