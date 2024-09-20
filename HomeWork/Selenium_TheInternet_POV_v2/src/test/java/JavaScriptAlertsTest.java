import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Alert;
import theIntertet.core.BasePage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static theIntertet.core.AppManager.alertsPage;
import static theIntertet.core.AppManager.homePage;

public class JavaScriptAlertsTest extends BaseTest {

    @BeforeAll
    static void getAlertsPage() {
        homePage.alertWindowsLink.click();
    }

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
        String testMsg1 = "You clicked: Ok";
        Alert alert = alertsPage.getAlert();
        alert.accept();
        Assertions.assertTrue(alertsPage.resultText().contains(testMsg1), "Текст всплывающего уведомления не соответствует ожидаемому, после нажатия кнопки 'ОК'");
    }

    @Test
    @DisplayName("Проверка кнопки JS Confir")
    void test3() {
        alertsPage.clickJsConfirmButton();
        String testMsg2 = "You clicked: Cancel";
        Alert alert = alertsPage.getAlert();
        alert.dismiss();
        Assertions.assertTrue(alertsPage.resultText().contains(testMsg2), "Текст всплывающего уведомления не соответствует ожидаемому, после нажатия кнопки 'Cancel'");
    }

    @Test
    @DisplayName("Проверка кнопки JS Prompt")
    void test4() {
        alertsPage.clickJsPromptButton();
        String testMsg = "Hello";
        Alert alert = alertsPage.getAlert();
        alert.sendKeys(testMsg);
        alert.accept();
        Assertions.assertTrue(alertsPage.resultText().contains(testMsg), "Текст не соответствует ожидаемому, после нажатия кнопки ОК");
    }
}

