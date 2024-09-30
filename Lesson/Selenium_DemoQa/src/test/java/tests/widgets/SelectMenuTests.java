package tests.widgets;

import org.junit.jupiter.api.*;
import tests.BaseTest;

import java.util.List;

import static core.Init.*;

@Tag("@ALL")
@Tag("@SELECT")
public class SelectMenuTests extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePage.widgetsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!selectMenuPage.titleTextCenterIsDisplayed() || !selectMenuPage.getTitleTextCenter().equals("Select Menu")) {
            leftPanel.scrollPage();
            leftPanel.selectMenuButton.click();
        }
    }

    @Test
    void test1() {
        selectMenuPage.selectColorOnOldMenu("Aqua");
        Assertions.assertEquals("Aqua", selectMenuPage.getSelectedColor());
    }

    @Test
    void test2() {
        selectMenuPage.multiSelect("Red", "Black");
        Assertions.assertTrue(selectMenuPage.colorIsSelectInMultiselect("Red"));
        Assertions.assertTrue(selectMenuPage.colorIsSelectInMultiselect("Black"));
    }

    @Test
    void test3() {
        String car1 = selectMenuPage.getTextOnSelectByIndex(0);
        String car2 = selectMenuPage.getTextOnSelectByIndex(1);
        selectMenuPage.selectCars(car2, car1);
        Assertions.assertTrue(selectMenuPage.getSelectedCars().containsAll(List.of(car1, car2)));
    }
}
