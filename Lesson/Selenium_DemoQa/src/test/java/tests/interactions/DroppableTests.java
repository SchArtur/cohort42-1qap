package tests.interactions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static core.Init.*;

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
