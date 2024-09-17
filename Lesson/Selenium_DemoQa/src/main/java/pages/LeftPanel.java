package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftPanel extends BasePage {

    @FindBy(xpath = "//*[text()='Alerts']")
    public WebElement alertsBtn;

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement loginButton;
}
