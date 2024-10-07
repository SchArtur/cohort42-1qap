package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

import static java.awt.event.InputEvent.BUTTON1_DOWN_MASK;

public class ExitIntentPage extends BasePage {
    @FindBy(xpath = "//p[.='Close']")
    WebElement close;

    public ExitIntentPage exitViewport() {

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.delay(1000);
        robot.mouseMove(500,126);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        clickOnElement(close);
        return this;
    }
    public ExitIntentPage verifyCloseButtonIsNotVisible() {
        waitInSeconds(2);

        return this;
    }
}

