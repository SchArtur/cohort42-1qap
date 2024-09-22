package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindowsPages extends BasePage {
    @FindBy(xpath = "//h3[text()='Opening a new window']")
    public WebElement browserWindowsText;
    @FindBy(xpath = "//a[text()='Click Here']")
    public WebElement newWindowsLink;

    public void switchToWindow(int index) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
    }
}
