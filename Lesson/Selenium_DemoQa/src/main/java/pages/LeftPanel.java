package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftPanel extends BasePage {

    @FindBy(xpath = "//*[text()='Alerts']")
    public WebElement alertsBtn;

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='Browser Windows']")
    public WebElement browserWindowsButton;

    @FindBy(xpath = "//*[text()='Frames']")
    public WebElement framesButton;

    @FindBy(xpath = "//*[text()='Nested Frames']")
    public WebElement nestedFramesButton;

    @FindBy(xpath = "//*[text()='Modal Dialogs']")
    public WebElement modalDialogsButton;

    @FindBy(xpath = "//*[text()='Practice Form']")
    public WebElement practiceFormButton;
}
