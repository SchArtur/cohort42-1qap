package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {
    @FindBy(id = "hot-spot")
    public WebElement isHotSpotPresent;

    public void rightClickOnHotSpot() {
        new Actions(driver).contextClick(isHotSpotPresent).perform();
    }
}
