package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    @FindBy(id="column-a")
    public WebElement columnA;
    @FindBy(id="column-b")
    public WebElement columnB;

    public DragAndDropPage actionDragAndDrop() {
        waitInSeconds(5);
        new Actions(driver).dragAndDrop(columnA, columnB).perform();
        waitInSeconds(5);
        return this;
    }

    public DragAndDropPage actionMoveBy() {
        new Actions(driver).clickAndHold(columnA).moveToElement(columnB).release().perform();
        return this;
    }
}
