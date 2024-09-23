package pages.interactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class DroppablePage extends BasePage {

    @FindBy(id = "draggable")
    public WebElement draggable;

    @FindBy(id = "droppable")
    public WebElement droppable;

    public DroppablePage actionDragAndDrop() {
        waitInSeconds(5);
        new Actions(driver).dragAndDrop(draggable, droppable).perform();
        waitInSeconds(5);
        return this;
    }

    public DroppablePage actionMoveBy() {
        waitInSeconds(5);
        new Actions(driver).clickAndHold(draggable).moveToElement(droppable).release().perform();
        waitInSeconds(5);
        return this;
    }

    public DroppablePage actionDragByOffset(int x, int y) {
        //Начальные координаты нашего элемента для переноса
        int xOffset1 = draggable.getLocation().getX();
        int yOffset1 = draggable.getLocation().getY();
        System.out.printf("draggable  x - %s, y - %s\n", xOffset1, yOffset1);

        //Координаты конечного элемента
        int xOffset = droppable.getLocation().getX();
        int yOffset = droppable.getLocation().getY();
        System.out.printf("droppable  x - %s, y - %s\n", xOffset, yOffset);

        xOffset = (xOffset - xOffset1) + x;
        yOffset = (yOffset - yOffset1) + y;
        System.out.printf("Offset x - %s, y - %s\n", xOffset, yOffset);

        waitInSeconds(5);
        new Actions(driver).dragAndDropBy(draggable, xOffset, yOffset).perform();
        waitInSeconds(5);
        return this;
    }


}
