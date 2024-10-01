import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static theIntertet.core.AppManager.dragAndDrop;
import static theIntertet.core.AppManager.homePage;

public class DragAndDropTest extends BaseTest{
    @BeforeAll
    static void getAlertsPage() {
        homePage.dragWindowsLink.click();
    }

    @Test
    void test1() {
        dragAndDrop.actionDragAndDrop();
        Assertions.assertEquals("A", dragAndDrop.droppable.getText(), "Элемент А и В поменялись местами");
    }

    @Test
    void test2() {
        dragAndDrop.actionMoveBy();
        Assertions.assertEquals("B", dragAndDrop.droppable.getText(), "Элемент В и А поменялись местами");
    }

}
