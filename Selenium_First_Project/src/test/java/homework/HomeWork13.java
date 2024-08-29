package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeWork13 extends BaseHomeWork{
    @Test
    @DisplayName("Проверка успешной авторизации пользователя")
    void test1(){

        fillInputField(By.cssSelector("[name='Email']"),"larysa@gmail.com");
        fillInputField(By.cssSelector("[name='Password']"),"qwerty");
        clickOnElement(By.cssSelector("[value='Log in']"));
        checkElementOnDisplay(By.cssSelector("[href='/logout']"));
    }
}
