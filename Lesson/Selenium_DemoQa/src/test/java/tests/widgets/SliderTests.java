package tests.widgets;

import org.junit.jupiter.api.*;
import tests.BaseTest;

import java.util.List;

import static core.Init.*;

@Tag("@SLIDER")
@Tag("@ALL")
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
        Assertions.assertEquals("20", sliderPage.sliderValue.getAttribute("value"));
    }
}
