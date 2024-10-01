package theIntertet.pages;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theIntertet.core.BasePage;

import static theIntertet.core.AppManager.homePage;

public class HoversPage extends BasePage {

    @BeforeAll
    static void getAlertsPage() {
        homePage.hoversLink.click();
    }

    @FindBy(className = "figure")
    public WebElement figureClass;

    @FindBy(className = "figcaption")
    public WebElement figcaptionClass;

}
