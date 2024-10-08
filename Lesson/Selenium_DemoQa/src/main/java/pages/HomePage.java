package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[text()='Alerts, Frame & Windows']")
    public WebElement alertFrameWindowsCard;

    @FindBy(xpath = "//*[text()='Book Store Application']")
    public WebElement bookStoreAppCard;

    @FindBy(xpath = "//*[text()='Forms']")
    public WebElement formsCard;

    @FindBy(xpath = "//*[text()='Widgets']")
    public WebElement widgetsCard;

    @FindBy(xpath = "//*[text()='Interactions']")
    public WebElement interactionsCard;

    @FindBy(xpath = "//*[text()='Elements']")
    public WebElement elementsCard;
}
