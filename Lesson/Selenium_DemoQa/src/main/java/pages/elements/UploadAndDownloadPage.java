package pages.elements;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.awt.*;
import java.awt.event.InputEvent;

import static core.Init.O_S;
import static java.awt.event.KeyEvent.*;

public class UploadAndDownloadPage extends BasePage {

    @FindBy(id = "uploadFile")
    WebElement uploadFile;
    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public String fillUploadFileKeyEvents() {
        waitInSeconds(2);
        new Actions(driver).click(uploadFile).perform();
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

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

        waitInSeconds(2);
       return uploadedFilePath.getText();
    }

    public String fillUploadFileMouseEvents() {
        waitInSeconds(2);
        new Actions(driver).click(uploadFile).perform();
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //Для MAC OS Command+Tab
        if (O_S.equals("mac")) {
            robot.keyPress(VK_META);
            robot.keyPress(VK_TAB);
            robot.keyRelease(VK_TAB);
            robot.keyRelease(VK_META);
        }
        robot.delay(1000);
//        785 485
        robot.mouseMove(475,450);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);

//        robot.mouseMove(1300,800);
//        robot.mousePress(BUTTON1_DOWN_MASK);
//        robot.mouseRelease(BUTTON1_DOWN_MASK);
        //либо
        robot.keyPress(VK_ENTER);
        robot.keyRelease(VK_ENTER);

        waitInSeconds(2);
        System.out.println(uploadedFilePath.getText());
        return uploadedFilePath.getText();
    }
}
