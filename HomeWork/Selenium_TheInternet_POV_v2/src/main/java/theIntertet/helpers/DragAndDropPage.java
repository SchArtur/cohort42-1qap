package theIntertet.helpers;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import theIntertet.core.BasePage;

import static theIntertet.core.AppManager.homePage;

public class DragAndDropPage extends BasePage {
    @BeforeAll
    static void getAlertsPage() {
        homePage.dragWindowsLink.click();
    }

    @FindBy(id = "column-a")
    public WebElement draggable;

    @FindBy(id = "column-b")
    public WebElement droppable;

    public DragAndDropPage actionDragAndDrop() {
        waitInSeconds(5);
        new Actions(driver).dragAndDrop(draggable, droppable).perform();
        waitInSeconds(5);
        return this;
    }

    public DragAndDropPage actionMoveBy() {
        new Actions(driver).clickAndHold(draggable).moveToElement(droppable).release().perform();
        return this;
    }
}
