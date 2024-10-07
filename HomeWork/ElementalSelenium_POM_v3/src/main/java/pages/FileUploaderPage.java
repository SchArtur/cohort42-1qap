package pages;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class FileUploaderPage extends BasePage {
    private static final String O_S = System.getProperty("os.name").toLowerCase();

    @FindBy(id = "file-upload")
    WebElement fileUpload;

    @FindBy(id = "file-submit")
    WebElement fileSubmit;

    private Robot createRobot() {
        try {
            return new Robot();
        } catch (AWTException e) {
            throw new RuntimeException("Ошибка создания Robot", e);
        }
    }
    public String uploadFileWithRobotKeyboard() {
        waitInSeconds(2);
        new Actions(driver).click(fileUpload).perform();

        Robot robot = createRobot();

        if (O_S.contains("mac")) {
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_META);
        }
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        waitInSeconds(2);
        return fileSubmit.getText();
    }

    public FileUploaderPage verifyFileName(String expectedFileName) {
        Assertions.assertEquals(expectedFileName, fileUpload.getText(), "Имя загруженного файла не совпадает.");
        return this;
    }

    public String uploadFileWithRobotMouse() {
        waitInSeconds(2);
        new Actions(driver).click(fileUpload).perform();

        Robot robot = createRobot();

        if (O_S.contains("mac")) {
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_META);
        }

        robot.delay(1000);
        robot.mouseMove(450, 603);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        waitInSeconds(2);
        return fileSubmit.getText();
    }
}
