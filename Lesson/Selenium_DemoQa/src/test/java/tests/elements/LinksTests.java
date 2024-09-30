package tests.elements;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static core.Init.*;

@Tag("@ALL")
public class LinksTests extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePage.scrollPage();
        homePage.elementsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!linksPage.titleTextCenterIsDisplayed() || !linksPage.getTitleTextCenter().equals("Links")) {
            leftPanel.linksButton.click();
        }
    }

    @Test
    void test1() {
        linksPage.checkAllLinks();
    }

}
