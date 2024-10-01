import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static core.AppManager.contextMenuPage;
import static core.AppManager.homePages;

public class ContextMenuTest extends BaseTest{
    @BeforeAll
    static void getAlertsPage() {
        homePages.contextMenuLink.click();
    }
    @Test
    void generateJSAlertTest() {
        contextMenuPage.rightClickOnHotSpot();
        Alert alert = contextMenuPage.getAlert();
        Assertions.assertEquals("You selected a context menu", alert.getText(), "Alert text does not match expected");
    }
}
