package pages.widgets;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SliderPage extends BasePage {

    @FindBy(id = "sliderValue")
    public WebElement sliderValue;

    @FindBy(css = ".range-slider")
    public WebElement slider;

    //    Если нужно просто установить в нужное значение
    public SliderPage moveSliderOnKeyboard(int value) {
        slider.click();

        int currentValue = Integer.parseInt(sliderValue.getAttribute("value"));
        int difference = value - currentValue;// 20-50=   -30
        if (value == currentValue) {
            return this;
        }
        Keys key = difference < 0 ? Keys.LEFT : Keys.RIGHT;
        for (int i = 0; i < Math.abs(difference); i++) {
            slider.sendKeys(key);
        }
        wait.until(ExpectedConditions.attributeToBe(sliderValue, "value", String.valueOf(value)));
        return this;
    }

    // Если не работает SendKeys
    public SliderPage moveSliderOnRobot(int value) {
        try {
            Robot robot = new Robot();
            slider.click();
            int currentValue = Integer.parseInt(sliderValue.getAttribute("value"));
            int difference = value - currentValue;
            if (value == currentValue) {
                return this;
            }
            int key = difference > 0 ? KeyEvent.VK_RIGHT : KeyEvent.VK_LEFT;
            for (int i = 0; i < Math.abs(difference); i++) {
                robot.keyPress(key);
                robot.keyRelease(key);
            }
            wait.until(ExpectedConditions.attributeToBe(sliderValue, "value", String.valueOf(value)));
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    // Если нужно проверить просто перетаскивается или нет
    public SliderPage moveSliderOnActions(int value) {
        slider.click();
        int dem = Math.round(slider.getSize().getWidth() / 100);
        int offsetEnd = (dem * value);
        int offsetStart = -slider.getSize().getWidth() / 2;
        Actions act = new Actions(driver);
//  1) через клавиатуру от начала элемента (с 0)
//        act.moveToElement(slider).moveByOffset(offsetStart, 0).click().perform();
//        while (value > 0){
//            slider.sendKeys(Keys.RIGHT);
//            value--;
//        }
        act.moveToElement(slider).moveByOffset(offsetStart, 0).clickAndHold().moveByOffset(offsetEnd, 0).perform();
        return this;
    }
}
