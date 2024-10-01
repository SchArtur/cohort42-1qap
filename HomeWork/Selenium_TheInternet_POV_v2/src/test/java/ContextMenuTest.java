import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static theIntertet.core.AppManager.*;

public class ContextMenuTest extends BaseTest{

    @BeforeAll
    static void getAlertsPage() {
        homePage.contextMenuWindowsLink.click();
    }

    @Test
    void Test1() {
        contextMenu.rightClick();
        Alert alert = alertsPage.getAlert();
        Assertions.assertEquals("You selected a context menu", alert.getText(), "Текст всплывающего уведомления не соответствует ожидаемому");
    }
}
