package lesson.phonebook;

import lesson.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Tag("@LOGIN")
public class LoginPageTest extends BaseTest {

    @BeforeEach
    void preconditions() {
        driver.get("https://telranedu.web.app");
    }

    @Test
    @Tag("@Positive")
    @Tag("@SMOKE")
    @DisplayName("Проверка авторизации с валидными данными")
    void test1() {
        clickOnElement(By.cssSelector("href='/login'"));
        fillInputField(By.xpath("//*[@name='email']") , "manuel@gm.com");
        fillInputField(By.xpath("//*[@name='password']") , "Manuel1234$");
        clickOnElement(By.xpath("//*[text()='Login']"));
        checkElementOnDisplay(By.xpath("//*[@href='/contacts']"));
    }

    @Test
    @Tag("@Negative")
    @DisplayName("Проверка авторизации с не валидным email")
    void test2() {
        clickOnElement(By.cssSelector("[href='/login']"));
        fillInputField(By.name("email"), "manuel");
        fillInputField(By.name("password"), "Manuel1234$");
        clickOnElement(By.xpath("//*[text()='Login']"));
        Alert alert = getAlert();
        Assertions.assertEquals("Wrong email or password", alert.getText(),"Текст уведомления не соответствует ожидаемому");
        alert.accept();

        WebElement statusCodeTextElement = getElement(By.xpath("//*[contains(text(),'401')]"));
        Assertions.assertEquals("Login Failed with code 401", statusCodeTextElement.getText(), "Текст ошибки при авторизации, отличается от ожидаемого");
    }
}
