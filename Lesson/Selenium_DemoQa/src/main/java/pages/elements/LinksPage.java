package pages.elements;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class LinksPage extends BasePage {

    @FindBy(tagName = "a")
    List<WebElement> links;

    public LinksPage checkAllLinks() {
        System.out.printf("Общее количество ссылок - %s\n", links.size());
        for (WebElement link : links) {
            String textLink = link.getText();
            String linkUrl = link.getAttribute("href");
            if ( linkUrl != null && !linkUrl.contains("javascript:void")) {
                Assertions.assertTrue(linkIsValid(linkUrl));
            } else {
                System.err.printf("Ссылка - %s, с текстом - %s, вовсе не ссылка - BROKEN\n", linkUrl, textLink);
            }
        }
        return this;
    }
}
