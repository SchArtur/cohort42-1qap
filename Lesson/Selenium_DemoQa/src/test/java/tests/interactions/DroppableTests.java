package tests.interactions;

import org.junit.jupiter.api.*;
import tests.BaseTest;

import static core.Init.*;

@Tag("@ALL")
@Tag("@SMOKE")
@Tag("@DRAG_DROP")
public class DroppableTests extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePage.interactionsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!practiceFormPage.titleTextCenterIsDisplayed() || !practiceFormPage.getTitleTextCenter().equals("Droppable")) {
            leftPanel.droppableButton.click();
        }
        driver.navigate().refresh();
    }

    @Test
    void test1() {
        droppablePage.actionDragAndDrop();
        Assertions.assertEquals("Dropped!", droppablePage.droppable.getText());
    }

    @Test
    void test2() {
        droppablePage.actionMoveBy();
        Assertions.assertEquals("Dropped!", droppablePage.droppable.getText());
    }

    @Test
    void test4() {
        droppablePage.actionDragByOffset(10,10);
        Assertions.assertEquals("Dropped!", droppablePage.droppable.getText());
    }
}
