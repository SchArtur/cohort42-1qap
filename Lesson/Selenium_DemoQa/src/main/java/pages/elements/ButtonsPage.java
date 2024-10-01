package pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ButtonsPage extends BasePage {

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;
    @FindBy(id = "rightClickBtn")
    public WebElement rightClickBtn;
    @FindBy(xpath = "//*[text()='Click Me']")
    public WebElement clickMeBtn;

    //    You have done a double click
    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;
    //    You have done a right click
    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;
    //    You have done a dynamic click
    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;

    public void doubleClickOnButton() {
        waitInSeconds(5);
        new Actions(driver).doubleClick(doubleClickBtn).perform();
    }

    public void rightClickOnButton() {
        waitInSeconds(5);
        new Actions(driver).contextClick(rightClickBtn).perform();
    }

    public void clickMeOnButton() {
        waitInSeconds(5);
        new Actions(driver).click(clickMeBtn).perform();
    }

}
