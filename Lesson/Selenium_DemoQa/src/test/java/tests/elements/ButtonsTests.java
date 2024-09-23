package tests.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static core.Init.*;

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
