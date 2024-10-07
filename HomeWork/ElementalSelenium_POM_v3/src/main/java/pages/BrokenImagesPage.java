package pages;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImagesPage extends BasePage {
    @FindBy(tagName = "img")
    public List<WebElement> images;
    @FindBy(css = "img:nth-child(2)")
    public WebElement image1;
    @FindBy(css = "img:nth-child(3)")
    public WebElement image2;
    @FindBy(css = "img:nth-child(4)")
    public WebElement image3;

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
