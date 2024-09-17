import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Alert;
import theIntertet.core.BasePage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static theIntertet.core.AppManager.alertsPage;

@Tag("@ALL")
@Tag("@ABOUT")
@Tag("@SMOKE")
public class JavaScriptAlertsTest extends BaseTest {

    @Test
    @DisplayName("Проверка кнопки JS Alert")
    void test1() {
        alertsPage.clickJsAlertButton();
        Alert alert = alertsPage.getAlert();
        Assertions.assertEquals("I am a JS Alert", alert.getText(), "Текст всплывающего уведомления не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка кнопки JS Confir")
    void test2() {
        alertsPage.clickJsConfirmButton();
        Alert alert = alertsPage.getAlert();
        alert.accept();
        Assertions.assertTrue(alertsPage.resultText().contains("You clicked: Ok"), "Текст всплывающего уведомления не соответствует ожидаемому, после нажатия кнопки ОК");
    }

    @Test
    @DisplayName("Проверка кнопки JS Prompt")
    void test3() {
        alertsPage.clickJsPromptButton();
        String testMsg = "Hello";
        Alert alert = alertsPage.getAlert();
        alert.sendKeys(testMsg);
        alert.accept();
        Assertions.assertTrue(alertsPage.resultText().contains(testMsg), "Текст не соответствует ожидаемому, после нажатия кнопки ОК");
    }
}

