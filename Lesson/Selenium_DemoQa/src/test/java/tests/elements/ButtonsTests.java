package tests.elements;

import org.junit.jupiter.api.*;
import tests.BaseTest;

import static core.Init.*;

@Tag("@ALL")
@Tag("@SMOKE")
public class ButtonsTests extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePage.elementsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!practiceFormPage.titleTextCenterIsDisplayed() || !practiceFormPage.getTitleTextCenter().equals("Buttons")) {
            leftPanel.buttonsButton.click();
        }
    }

    @Test
    void test1() {
        buttonsPage.doubleClickOnButton();
        Assertions.assertEquals("You have done a double click", buttonsPage.doubleClickMessage.getText());
    }
    @Test
    void test2() {
        buttonsPage.rightClickOnButton();
        Assertions.assertEquals("You have done a right click", buttonsPage.rightClickMessage.getText());
    }
    @Test
    void test3() {
        buttonsPage.clickMeOnButton();
        Assertions.assertEquals("You have done a dynamic click", buttonsPage.dynamicClickMessage.getText());
    }
}
