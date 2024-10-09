package pages.widgets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.time.Duration;

public class ToolTipsPage extends BasePage {

    @FindBy(id = "toolTipButton")
    public WebElement toolTipButton;

    @FindBy(className = "tooltip-inner")
    public WebElement toolTip;

    public ToolTipsPage hoverToButton(){
        waitInSeconds(5);
        new Actions(driver).moveToElement(toolTipButton).perform();
        waitInSeconds(5);
        return this;
    }

    public String getTooltipText() {
        return toolTip.getText();
    }

}
