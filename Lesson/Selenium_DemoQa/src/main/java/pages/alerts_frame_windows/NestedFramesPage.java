package pages.alerts_frame_windows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class NestedFramesPage extends BasePage {

    @FindBy(id = "frame1")
    public WebElement parentFrame;

    @FindBy(css = "[srcdoc='<p>Child Iframe</p>']")
    public WebElement childFrame;

    @FindBy(tagName = "p")
    public WebElement childFrameText;

    @FindBy(tagName = "body")
    public WebElement parentBody;
}
