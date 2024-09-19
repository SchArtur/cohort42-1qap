package theIntertet.helpers;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theIntertet.core.BasePage;

import java.util.List;

import static theIntertet.core.AppManager.homePage;

public class NestedFramesPage extends BasePage {

    @FindBy (css = "[src='/frame_top']")
    public WebElement frametop;

    @FindBy (css = "[src='/frame_left']")
    public WebElement frame1;

    @FindBy (css = "[src='/frame_middle']")
    public WebElement frame2;

    @FindBy (css = "[src='/frame_right']")
    public WebElement frame3;

    @FindBy (css = "[src='/frame_bottom']")
    public WebElement frame4;

    @FindBy(tagName = "body")
    public WebElement textInFrame1;

    @FindBy(tagName = "body")
    public List<WebElement> textInFrameList;

    public boolean sampleHeadingTextIsDisplayed() {
        return textInFrameList.size() > 0;
    }
}
