import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static core.AppManager.homePages;
import static core.AppManager.javaScriptAlertsPages;

public class JavaScriptsAlertsTests extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePages.jsAlertsLink.click();
    }

    @Test
    void testAlert() {
        javaScriptAlertsPages.clickAlertButton();
        Assertions.assertEquals("I am a JS Alert", javaScriptAlertsPages.getAlertText(), "Неверный текст в alert");
        Assertions.assertEquals("You successfully clicked an alert", javaScriptAlertsPages.getResultText(), "Неверный результат после alert");
    }

    @Test
    void testConfirm() {
        javaScriptAlertsPages.clickConfirmButton();
        Assertions.assertEquals("I am a JS Confirm", javaScriptAlertsPages.getAlertText(), "Неверный текст в confirm");
        Assertions.assertEquals("You clicked: Ok", javaScriptAlertsPages.getResultText(), "Неверный результат после подтверждения");
        javaScriptAlertsPages.clickConfirmButton();
        javaScriptAlertsPages.getAlert().dismiss();
        Assertions.assertEquals("You clicked: Cancel", javaScriptAlertsPages.getResultText(), "Неверный результат после отмены");
    }

    @Test
    void testPrompt() {
        javaScriptAlertsPages.clickPromtButton();
        Alert alert = javaScriptAlertsPages.getAlert();
        Assertions.assertEquals("I am a JS prompt", alert.getText(), "Неверный текст в prompt");
        String inputText = "Test input";
        alert.sendKeys(inputText);
        alert.accept();
        Assertions.assertEquals("You entered: " + inputText, javaScriptAlertsPages.getResultText(), "Неверный результат после подтверждения");

        javaScriptAlertsPages.clickPromtButton();
        alert.dismiss();
        Assertions.assertEquals("You entered: null", javaScriptAlertsPages.getResultText(), "Неверный результат после отмены");
    }

}
