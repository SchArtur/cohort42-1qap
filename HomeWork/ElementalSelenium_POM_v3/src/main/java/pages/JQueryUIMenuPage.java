package pages;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JQueryUIMenuPage extends BasePage {
    @FindBy(id = "menu")
    private WebElement menuLink;
    @FindBy(id = "ui-id-1")
    private WebElement disabletFieled;
    @FindBy(id = "ui-id-3")
    private WebElement enabledFieled;
    @FindBy(id = "ui-id-4")
    private WebElement downloadsFieled;
    @FindBy(tagName = "a")
    List<WebElement> links;

    public WebElement getMenuLink() {
        return menuLink;
    }

    public WebElement getDisabletFieled() {
        return disabletFieled;
    }

    public WebElement getEnabledFieled() {
        return enabledFieled;
    }

    public WebElement getDownloadsFieled() {
        return downloadsFieled;
    }


    public JQueryUIMenuPage checkAllLinks() {
        System.out.printf("Общее количество ссылок - %s\n", links.size());
        for (WebElement link : links) {
            String textLink = link.getText();
            String linkUrl = link.getAttribute("href");
            if (linkUrl != null && !linkUrl.contains("javascript:void")) {
                Assertions.assertTrue(linkIsValid(linkUrl));
            } else {
                System.err.printf("Ссылка - %s, с текстом - %s, вовсе не ссылка - BROKEN\n", linkUrl, textLink);
            }
        }
        return this;
    }
}
