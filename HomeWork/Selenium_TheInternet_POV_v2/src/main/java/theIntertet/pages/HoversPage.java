package theIntertet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theIntertet.core.BasePage;

public class HoversPage extends BasePage {

    @FindBy(className = "figure")
    public WebElement figureClass;

    @FindBy(className = "figcaption")
    public WebElement figcaptionClass;

}
