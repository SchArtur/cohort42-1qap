package tests.elements;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static core.Init.*;
import static core.Init.leftPanel;

@Tag("@ALL")
@Tag("@SMOKE")
public class TextBoxTest extends BaseTest {

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
        textBoxPage.fillUserDataS("TestName", "testmail@gg.com")
                .clickSubmit()
                .checkNameAndEmail("TestName", "testmail@gg.com");
    }

    @Test
    void test2() {
        textBoxPage.fillUserDataJS("TestName", "testmail@gg.com")
                .clickSubmitJS()
                .checkNameAndEmailJSInnerText("TestName", "testmail@gg.com");
    }
}

