package pages;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JQueryUIMenuPage extends BasePage {
    @FindBy(id = "menu")
    public WebElement menuLink;
    @FindBy(id = "ui-id-1")
    public WebElement disabletFieled;
    @FindBy(id = "ui-id-3")
    public WebElement enabledFieled;
    @FindBy(id = "ui-id-4")
    public WebElement downloadsFieled;
    @FindBy(xpath = "//*[text() = 'PDF']")
    public WebElement pdfMenu;
    @FindBy(tagName = "a")
    List<WebElement> links;

    public JQueryUIMenuPage checkAllLinks() {
        System.out.printf("Общее количество ссылок - %s", links.size());
        for (WebElement link : links) {
            String textLink = link.getText();
            String linkUrl = link.getAttribute("href");
            if (linkUrl != null && !linkUrl.contains("javascript:void")) {
                Assertions.assertTrue(linkIsValid(linkUrl));
            } else {
                System.err.printf("Ссылка - %s, с текстом - %s, вовсе не ссылка - BROKEN", linkUrl, textLink);
            }
        }
        return this;
    }
}
