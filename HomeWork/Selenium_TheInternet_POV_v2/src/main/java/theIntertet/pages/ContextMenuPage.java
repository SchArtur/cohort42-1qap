package theIntertet.pages;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import theIntertet.core.BasePage;

import static theIntertet.core.AppManager.homePage;

public class ContextMenuPage extends BasePage {

    @BeforeAll
    static void getAlertsPage() {
        homePage.contextMenuWindowsLink.click();
    }

    @FindBy(id = "hot-spot")
    public WebElement hotSpot;

    public void rightClick() {
        new Actions(driver).contextClick(hotSpot).perform();
    }
}
