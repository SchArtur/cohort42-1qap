import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static theIntertet.core.AppManager.*;

public class JQueryUITEST extends BaseTest{

    @BeforeAll
    static void getAlertsPage() {
        homePage.jqueryuiLink.click();
    }

    @Test
    void Test1() {
        jQueryUI.enabledMenu.click();
        jQueryUI.downloadsMenu.click();
        jQueryUI.pdfMenu.click();
        System.out.println("PDF страница загруженна");

    }
}
