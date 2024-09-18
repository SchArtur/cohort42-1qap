package pages.alerts_frame_windows;

import com.sun.security.jgss.GSSUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {
    public static final String newWindowMessage = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";

    @FindBy(id = "tabButton")
    public WebElement newTab;

    @FindBy(id = "messageWindowButton")
    public WebElement messageWindowButton;

    @FindBy(id = "sampleHeading")
    public WebElement sampleHeading;

    @FindBy(tagName = "body")
    public WebElement bodyWindow;

    public BrowserWindowsPage switchToWindow(int index) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        return new BrowserWindowsPage();
    }

}
