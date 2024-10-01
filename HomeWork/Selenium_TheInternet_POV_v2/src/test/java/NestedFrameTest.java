import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static theIntertet.core.AppManager.*;

public class NestedFrameTest extends BaseTest {

    @BeforeAll
    static void getAlertsPage() {
        homePage.nestedFramesWindowsLink.click();
    }

    @Test
    void test1() {
        driver.switchTo().frame(nestedFrames.frametop);
        driver.switchTo().frame(nestedFrames.frame1);
        Assertions.assertEquals("LEFT", nestedFrames.textInFrame1.getText(), "Текст не соответствует ожидаемому");
        Assertions.assertTrue(nestedFrames.sampleHeadingTextIsDisplayed());
        driver.switchTo().defaultContent();
        Assertions.assertFalse(nestedFrames.sampleHeadingTextIsDisplayed());
    }

    @Test
    void test2() {
        driver.switchTo().frame(nestedFrames.frametop);
        driver.switchTo().frame(nestedFrames.frame2);
        Assertions.assertEquals("MIDDLE", nestedFrames.textInFrame1.getText(), "Текст не соответствует ожидаемому");
        Assertions.assertTrue(nestedFrames.sampleHeadingTextIsDisplayed());
        driver.switchTo().defaultContent();
        Assertions.assertFalse(nestedFrames.sampleHeadingTextIsDisplayed());
    }

    @Test
    void test3() {
        driver.switchTo().frame(nestedFrames.frametop);
        driver.switchTo().frame(nestedFrames.frame3);
        Assertions.assertEquals("RIGHT", nestedFrames.textInFrame1.getText(), "Текст не соответствует ожидаемому");
        Assertions.assertTrue(nestedFrames.sampleHeadingTextIsDisplayed());
        driver.switchTo().defaultContent();
        Assertions.assertFalse(nestedFrames.sampleHeadingTextIsDisplayed());
    }

    @Test
    void test4() {
        driver.switchTo().frame(nestedFrames.frame4);
        Assertions.assertEquals("BOTTOM", nestedFrames.textInFrame1.getText(), "Текст не соответствует ожидаемому");
        Assertions.assertTrue(nestedFrames.sampleHeadingTextIsDisplayed());
        driver.switchTo().defaultContent();
        Assertions.assertFalse(nestedFrames.sampleHeadingTextIsDisplayed());
    }
}
