package pages.widgets;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class SliderPage extends BasePage {

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    @FindBy(css = ".range-slider")
    WebElement slider;

    public SliderPage moveSliderOnKeyboard(int value) {
        slider.click();
        while (value > 0) {
            slider.sendKeys(Keys.LEFT);
            value--;
        }

//        new Actions(driver).clickAndHold(slider).moveByOffset(50,0).release().build().perform();
        //50 пикселей = +- 13 пунктов
        return this;
    }

}
