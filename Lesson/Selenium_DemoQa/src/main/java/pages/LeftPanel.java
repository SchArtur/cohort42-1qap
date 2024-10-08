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

    @FindBy(xpath = "//*[text()='Select Menu']")
    public WebElement selectMenuButton;

    @FindBy(xpath = "//*[text()='Slider']")
    public WebElement sliderButton;

    @FindBy(xpath = "//*[text()='Tool Tips']")
    public WebElement toolTipsButton;

    @FindBy(xpath = "//*[text()='Droppable']")
    public WebElement droppableButton;

    @FindBy(xpath = "//*[text()='Buttons']")
    public WebElement buttonsButton;

    @FindBy(xpath = "//*[text()='Broken Links - Images']")
    public WebElement brokenLinksImagesButton;

    @FindBy(xpath = "//*[text()='Links']")
    public WebElement linksButton;

    @FindBy(xpath = "//*[text()='Upload and Download']")
    public WebElement uploadAndDownloadButton;
    @FindBy(xpath = "//*[text()='Text Box']")
    public WebElement textBoxButton;
}

