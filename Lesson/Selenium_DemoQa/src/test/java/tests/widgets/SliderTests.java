package tests.widgets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import java.util.List;

import static core.Init.*;

public class SliderTests extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePage.widgetsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!selectMenuPage.titleTextCenterIsDisplayed() || !selectMenuPage.getTitleTextCenter().equals("Select Menu")) {
            leftPanel.scrollPage();
            leftPanel.sliderButton.click();
        }
    }

    @Test
    void test1() {
        sliderPage.moveSliderOnKeyboard(20);
    }


}
