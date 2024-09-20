package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPages extends BasePage {
    @FindBy(css = "[src='/frame_top']")
    public WebElement frameTop;

    @FindBy(css = "[src='/frame_left']")
    public WebElement frameLeft;

    @FindBy(css = "[src='/frame_middle']")
    public WebElement frameMiddle;

    @FindBy(css = "[src='/frame_right']")
    public WebElement frameRight;

    @FindBy(css = "[src='/frame_bottom']")
    public WebElement frameBottom;

    @FindBy (tagName = "body")
    public WebElement frameText;

}


