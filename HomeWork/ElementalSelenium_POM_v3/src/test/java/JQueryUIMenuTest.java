import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static core.AppManager.homePages;
import static core.AppManager.jQueryUIMenuPage;

public class JQueryUIMenuTest extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePages.scrollPage();
        homePages.jqueryuiMenuLink.click();
    }

    @BeforeEach
    void preconditions() {
        if (!jQueryUIMenuPage.titleTextCenterIsDisplayed() || !jQueryUIMenuPage.getTitleTextCenter().equals("Links")) {
        }
    }
    @Test
    void test1() {
        jQueryUIMenuPage.checkAllLinks();
        jQueryUIMenuPage.enabledFieled.click();
        jQueryUIMenuPage.downloadsFieled.click();
        jQueryUIMenuPage.pdfMenu.click();
        System.out.println("PDF страница загружена");
    }
}
