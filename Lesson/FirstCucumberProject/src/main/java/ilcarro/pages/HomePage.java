package ilcarro.pages;

import ilcarro.core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(tagName = "h1")
    List<WebElement> h1Title;

    public HomePage openHomePage() {
        driver.get("https://ilcarro.web.app/");
        return this;
    }

    public HomePage checkTitleText(String text) {
        Assert.assertTrue(elementIsDisplayed(h1Title));
        Assert.assertEquals("Текст ошибки не соответствует ожидаемому", text, h1Title.get(0).getText());
        return this;
    }
}

