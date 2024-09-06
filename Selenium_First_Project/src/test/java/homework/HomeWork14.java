package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class HomeWork14 extends BaseHomeWork {
    @Test
    @DisplayName("Проверка успешной регистрации личных данных пользователя")
    void test1() {
        clickOnElement(By.xpath("//*[href='/register']"));
        clickOnElement(By.xpath("//*[id='gender-female']"));
        fillInputField(By.xpath("//*[name='FirstName']"), "Larysa");
        fillInputField(By.xpath("//*[name='LastName']"), "Petrova");
        fillInputField(By.xpath("//*[name='Email']"), "larysa@gmail.com");
        fillInputField(By.xpath("//*[name='Password']"), "qwerty");
        fillInputField(By.xpath("//*[name='ConfirmPassword']"), "qwerty");
        clickOnElement(By.xpath("//*[name='register-button']"));
        checkElementOnDisplay(By.xpath("//*[class='button-1 register-continue-button']"));
        checkElementOnDisplay(By.xpath("//*[text()='Log out']"));
    }
}
