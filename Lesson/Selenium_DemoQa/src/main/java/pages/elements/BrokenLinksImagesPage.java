package pages.elements;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class BrokenLinksImagesPage extends BasePage {

    @FindBy(xpath = "//p[contains(text(), 'Valid image')]/following::img[1]")
    public WebElement validImage;

    @FindBy(xpath = "//p[contains(text(), 'Broken image')]/following::img[1]")
    public WebElement brokenImage;

    @FindBy(xpath = "//p[contains(text(), 'Valid Link')]/following::a[1]")
    public WebElement validLink;

    @FindBy(xpath = "//p[contains(text(), 'Broken Link')]/following::a[1]")
    public WebElement brokenLink;

    @FindBy(tagName = "img")
    public List<WebElement> images;

    public void checkBrokenImages() {
        System.out.printf("Мы имеем %s картинок\n", images.size());
        for (WebElement image : images) {
            //ссылка
            if (imageIsDisplayed(image)) {
                System.out.println("************************");
                Assertions.assertTrue(imageIsDisplayed(image));
                System.out.println("DISPLAY - OK");
            } else {
                System.out.println("************************");
                Assertions.assertFalse(imageIsDisplayed(image));
                System.out.println("DISPLAY - BROKEN");
            }
        }
    }

}
