package pages.alerts_frame_windows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ModalDialogsPage extends BasePage {

    @FindBy(id = "showSmallModal")
    public WebElement showSmallModal;
    @FindBy(id = "showLargeModal")
    public WebElement showLargeModal;

    @FindBy(css = "[class='modal-body']")
    public WebElement modalBody;

    @FindBy(id = "closeSmallModal")
    public WebElement closeSmallModalButton;

    @FindBy(id = "closeLargeModal")
    public WebElement closeLargeModalButton;

    public String getModalText() {
        return getElement(modalBody).getText();
    }
}
