package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePages extends BasePage {
    @FindBy(css="[href='/javascript_alerts']")
    public WebElement jsAlertsLink;
    @FindBy(css="[href='/windows']")
    public WebElement multipleWindowsLink;
    @FindBy(css="[href='/nested_frames']")
    public WebElement nestedFramesLink;
    @FindBy(css="[href='/horizontal_slider']")
    public WebElement horizontalSliderLink;
    @FindBy(css="[href='/jqueryui/menu']")
    public WebElement jqueryuiMenuLink;
    @FindBy(css="[href='/context_menu']")
    public WebElement contextMenuLink;
    @FindBy(css="[href='/dropdown']")
    public WebElement dropdownMenuLink;

}
