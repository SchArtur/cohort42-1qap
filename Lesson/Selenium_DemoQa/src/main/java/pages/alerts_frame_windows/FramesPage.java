package pages.alerts_frame_windows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class FramesPage extends BasePage {

    @FindBy(id = "frame1")
    public WebElement frame1;

    @FindBy(id = "frame2")
    public WebElement frame2;

    @FindBy(id = "sampleHeading")
    public WebElement textInFrame;

    @FindBy(id = "sampleHeading")
    public List<WebElement> textInFrameList;

    public boolean sampleHeadingTextIsDisplayed() {
        return textInFrameList.size() > 0;
    }
}
