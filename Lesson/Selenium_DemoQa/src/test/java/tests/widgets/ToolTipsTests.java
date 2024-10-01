package tests.widgets;

import org.junit.jupiter.api.*;
import tests.BaseTest;

import static core.Init.*;

@Tag("@ALL")
public class ToolTipsTests extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePage.widgetsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!selectMenuPage.titleTextCenterIsDisplayed() || !selectMenuPage.getTitleTextCenter().equals("Tool Tips")) {
            leftPanel.scrollPage();
            leftPanel.toolTipsButton.click();
        }
    }

    @Test
    void test1() {
        toolTipsPage.hoverToButton();
        Assertions.assertEquals("You hovered over the Button", toolTipsPage.getTooltipText());
    }
}
