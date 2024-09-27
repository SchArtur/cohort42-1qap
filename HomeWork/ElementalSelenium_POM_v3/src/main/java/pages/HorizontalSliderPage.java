package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HorizontalSliderPage extends BasePage {
    @FindBy(tagName = "h3")
    public WebElement sliderTitle;

    @FindBy(css = "h4.subheader")
    public WebElement sliderDescription;

    @FindBy(css = "input[type='range']")
    public WebElement slider;

    @FindBy(id = "sliderValue")
    public WebElement sliderValue;

//    public HorizontalSliderPages moveSlider(double value) {
//        slider.click();
//        int steps = (int) (value);
//        if (steps > 0) {
//            for (int i = 0; i < steps; i++) {
//                slider.sendKeys(Keys.RIGHT);
//            }
//        } else {
//            for (int i = 0; i < Math.abs(steps); i--) {
//                slider.sendKeys(Keys.LEFT);
//            }
//        }
//        return this;
//    }

    public HorizontalSliderPage moveSlider(double value) {
        int sliderWidth = slider.getSize().getWidth();
        int offset = (int) ((value / 5) * sliderWidth);
        new Actions(driver).clickAndHold(slider).moveByOffset(offset, 0).release().build().perform();
        return this;
    }
}
