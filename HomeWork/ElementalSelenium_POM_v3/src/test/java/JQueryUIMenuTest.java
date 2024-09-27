import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static core.AppManager.homePages;
import static core.AppManager.jQueryUIMenuPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    }

    @Test
    void test2() {
        assertTrue(jQueryUIMenuPage.getDisabletFieled().isDisplayed(), "Поле 'Disabled' не отображается");
        assertTrue(!jQueryUIMenuPage.getDisabletFieled().isEnabled(), "Поле 'Disabled' должно быть неактивным");

    }

    @Test
    void test3() {
        assertTrue(jQueryUIMenuPage.getEnabledFieled().isDisplayed(), "Поле 'Enabled' не отображается");
        assertTrue(jQueryUIMenuPage.getEnabledFieled().isEnabled(), "Поле 'Enabled' не активно");
        jQueryUIMenuPage.getEnabledFieled().click();
    }

    @Test
    void test4() {
        assertTrue(jQueryUIMenuPage.getDownloadsFieled().isDisplayed(), "Поле 'Downloads' не отображается");
        assertTrue(jQueryUIMenuPage.getDownloadsFieled().isEnabled(), "Поле 'Downloads' не активно");
        jQueryUIMenuPage.getDownloadsFieled().click();
    }
}
