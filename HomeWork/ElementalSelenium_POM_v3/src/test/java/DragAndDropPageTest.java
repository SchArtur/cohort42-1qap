import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static core.AppManager.dragAndDropPage;
import static core.AppManager.homePages;

public class DragAndDropPageTest extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePages.dragAndDropLink.click();
    }

    @Test
    void test1() {
        dragAndDropPage.actionMoveBy();
        Assertions.assertEquals("B", dragAndDropPage.columnA.getText(), "Элемент A и B поменялись местами");
    }
}
