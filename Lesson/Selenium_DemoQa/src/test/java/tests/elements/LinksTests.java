package tests.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import tests.BaseTest;

import java.util.List;

import static core.Init.*;

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
