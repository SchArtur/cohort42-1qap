package theIntertet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theIntertet.core.BasePage;

public class HomePage extends BasePage {

    @FindBy(css = "[href='/javascript_alerts']")
    public WebElement alertWindowsLink;

    @FindBy(css = "[href='/nested_frames']")
    public WebElement  nestedFramesWindowsLink;

    @FindBy(css = "[href='/windows']")
    public WebElement  multipleWindowsLink;

}
