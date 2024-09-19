package theIntertet.helpers;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theIntertet.core.BasePage;

import java.util.ArrayList;
import java.util.List;

import static theIntertet.core.AppManager.homePage;

public class MultipleWindowsPage extends BasePage {


    @BeforeAll
    static void getAlertsPage() {
        homePage.multipleWindowsLink.click();
    }

    public static final String newWindowMessage = "New Window";

    @FindBy(css= "[href='/windows/new']")
    public WebElement linkText;

    @FindBy(css = "html body div h3")
    public WebElement neuWindowText;

    public  MultipleWindowsPage switchToWindow(int index) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        return new MultipleWindowsPage();
    }
}
