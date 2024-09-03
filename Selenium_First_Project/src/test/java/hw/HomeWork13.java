package hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeWork13 extends MyBaseTest {


    @Test
    @DisplayName(("Проверка поиска элемента по css"))

    public void testLoginWithCssSelector() {
        WebElement findLoginField = driver.findElement(By.cssSelector(".ico-login"));
        Assertions.assertTrue(findLoginField.isDisplayed(), " Not found");

        findLoginField.click();

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current is " + currentUrl);

        // Поиск и заполнение поля Email с помощью CSS-селектора
        fillInputField(By.cssSelector("input#Email"), "temiramanas@gmail.com");
        fillInputField(By.cssSelector("input#Password"), "123456789");

        // Использование By.cssSelector
        WebElement loginButton = driver.findElement(By.cssSelector(".button-1.login-button"));
        Assertions.assertTrue(loginButton.isDisplayed(), "Not displayed login btn");
        loginButton.click();


    }
}
