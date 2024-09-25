package pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.awt.*;

import static core.Init.O_S;
import static java.awt.event.KeyEvent.*;

public class UploadAndDownloadPage extends BasePage {

    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public void fillUploadFile() {
        waitInSeconds(2);
        uploadFile.click();
//        jsClickElement(uploadFile);
        new Actions(driver).click(uploadFile).perform();
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        robot.delay(1000);

        //Для MAC OS Command+Tab
        if (O_S.equals("mac")) {
            robot.keyPress(VK_META);
            robot.keyPress(VK_TAB);
            robot.keyRelease(VK_TAB);
            robot.keyRelease(VK_META);
        }

        robot.keyPress(VK_DOWN);
        robot.keyRelease(VK_DOWN);

        robot.keyPress(VK_ENTER);
        robot.keyRelease(VK_ENTER);
    }
}
