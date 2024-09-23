package tests.widgets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static core.Init.*;

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
