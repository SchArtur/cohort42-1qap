package pages.alerts_frame_windows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AlertsPage extends BasePage {

    @FindBy(id = "alertButton")
    public WebElement alertButton;
    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;
    @FindBy(id = "confirmButton")
    public WebElement confirmButton;
    @FindBy(id = "confirmResult")
    public WebElement confirmResult;
    @FindBy(id = "promtButton")
    public WebElement promtButton;
    @FindBy(id = "promptResult")
    public WebElement promptResult;
}
