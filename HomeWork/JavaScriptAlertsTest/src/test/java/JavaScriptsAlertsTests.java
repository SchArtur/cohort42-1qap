import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import page.JavaScriptAlertsPages;

import static core.AppManager.driver;

public class JavaScriptsAlertsTests extends BaseTest {
    JavaScriptAlertsPages alertsPage = new JavaScriptAlertsPages();
    Alert alert = driver.switchTo().alert();

    @Test
    void testAlert(){
        alertsPage.clickAlertButton();
        Assertions.assertEquals("I am a JS Alert",alertsPage,"Неверный текст в alert");
        Assertions.assertEquals("You successfully clicked an alert", alertsPage.getResultText(), "Неверный результат после alert");
    }
    @Test
    void testConfirm(){
        alertsPage.clickConfirmButton();
        Assertions.assertEquals("I am a JS Confirm","Неверный текст в confirm");
        alert.accept();
        Assertions.assertEquals("You clicked: Ok", alertsPage.getResultText(), "Неверный результат после подтверждения");
        alert.dismiss();
        Assertions.assertEquals("You clicked: Cancel", alertsPage.getResultText(), "Неверный результат после отмены");
    }
    @Test
    void testPrompt() {
        alertsPage.clickPromtButton();
        Assertions.assertEquals("I am a JS prompt", alert.getText(), "Неверный текст в prompt");
        String inputText = "Test input";
        alert.sendKeys(inputText);
        alert.accept();
        Assertions.assertEquals("You entered: " + inputText, alertsPage.getResultText(), "Неверный результат после подтверждения");

        alertsPage.clickPromtButton();
        alert.dismiss();
        Assertions.assertEquals("You entered: null", alertsPage.getResultText(), "Неверный результат после отмены");
    }

}
