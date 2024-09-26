package theIntertet.helpers;

import io.qameta.allure.Step;
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

    @FindBy(css = "[href='/drag_and_drop']")
    public WebElement  dragWindowsLink;

    @FindBy(css = "[href='/context_menu']")
    public WebElement  contextMenuWindowsLink;
}
