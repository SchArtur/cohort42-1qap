package tests.alerts_frame_windows;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Alert;
import tests.BaseTest;

import static core.Init.*;

@Tag("@ALL")
@Tag("@ALERT")
public class AlertsTests extends BaseTest {

    @BeforeAll
    static void getAlertsPage() {
        homePage.alertFrameWindowsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!alertsPage.titleTextCenterIsDisplayed() || !alertsPage.getTitleTextCenter().equals("Alerts")) {
            leftPanel.alertsBtn.click();
        }
    }

    @Test
    @DisplayName("Check to - 'Click Button to see alert'")
    void test1() {
        alertsPage.alertButton.click();
        Alert alert = alertsPage.getAlert();
        Assertions.assertEquals("You clicked a button", alert.getText());
        alert.accept();
    }

    @Test
    @DisplayName("Check to - 'On button click, alert will appear after 5 seconds'")
    void test2() {
        alertsPage.timerAlertButton.click();
        Alert alert = alertsPage.getAlert();
        Assertions.assertEquals("This alert appeared after 5 seconds", alert.getText());
        alert.accept();
    }

    @ParameterizedTest
    @CsvSource({
            "Ok, You selected Ok",
            "Cancel, You selected Cancel"
    })
    @DisplayName("Check to - 'On button click, confirm box will appear'")
    void test3(String button, String result) {
        alertsPage.confirmButton.click();
        if (button.equals("Ok")) {
            alertsPage.getAlert().accept();
        } else {
            alertsPage.getAlert().dismiss();
        }
        Assertions.assertEquals(result, alertsPage.confirmResult.getText());
    }

    @Test
    @DisplayName("Check to - 'On button click, prompt box will appear'")
    void test4() {
        String testMsg = "Hello world!";
        alertsPage.promtButton.click();
        Alert alert = alertsPage.getAlert();
        alert.sendKeys(testMsg);
        alert.accept();
        Assertions.assertTrue(alertsPage.promptResult.getText().contains(testMsg));
    }

}
