package theIntertet.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theIntertet.core.BasePage;

public class JQueryUIPage extends BasePage {

    @FindBy(id = "ui-id-3")
   public WebElement enabledMenu;
    @FindBy(id = "ui-id-4")
   public WebElement downloadsMenu;
    @FindBy(xpath = "//*[text() = 'PDF']")
    public WebElement pdfMenu;


}
