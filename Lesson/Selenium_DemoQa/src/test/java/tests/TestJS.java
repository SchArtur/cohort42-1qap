package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static core.Init.*;
import static core.Init.driver;

public class TestJS extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePage.scrollPage();
        homePage.elementsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!textBoxPage.titleTextCenterIsDisplayed() || !textBoxPage.getTitleTextCenter().equals("Text Box")) {
            leftPanel.textBoxButton.click();
        }
        driver.navigate().refresh();
    }

    @Test
    void test1() {
        textBoxPage.fillFormJS(textBoxPage.userName, "TestName");
        textBoxPage.refreshWithJS();
        String testUrl = "https://playground.learnqa.ru/puzzle/triangle";
        textBoxPage.goToUrlJs(testUrl);
        Assertions.assertEquals(testUrl, textBoxPage.getUrlFromJS());
        String title = textBoxPage.getTitleJs();
        textBoxPage.generateAlertJS(title);
    }

}
