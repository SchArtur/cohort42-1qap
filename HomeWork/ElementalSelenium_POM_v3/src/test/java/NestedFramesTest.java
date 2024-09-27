import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static core.AppManager.*;

public class NestedFramesTest extends BaseTest{
    @BeforeAll
    static void getAlertsPage() {
        homePages.nestedFramesLink.click();
    }

    @Test
    void test1() {
        driver.switchTo().frame(nestedFramesPages.frameTop);
        driver.switchTo().frame(nestedFramesPages.frameLeft);
        Assertions.assertEquals("LEFT", nestedFramesPages.frameText.getText(), "Текст не соответствует ожидаемому");
        driver.switchTo().defaultContent();
    }

    @Test
    void test2() {
        driver.switchTo().frame(nestedFramesPages.frameTop);
        driver.switchTo().frame(nestedFramesPages.frameMiddle);
        Assertions.assertEquals("MIDDLE", nestedFramesPages.frameText.getText(), "Текст не соответствует ожидаемому");
        driver.switchTo().defaultContent();
    }

    @Test
    void test3() {
        driver.switchTo().frame(nestedFramesPages.frameTop);
        driver.switchTo().frame(nestedFramesPages.frameRight);
        Assertions.assertEquals("RIGHT", nestedFramesPages.frameText.getText(), "Текст не соответствует ожидаемому");
        driver.switchTo().defaultContent();
    }

    @Test
    void test4() {
        driver.switchTo().frame(nestedFramesPages.frameBottom);
        Assertions.assertEquals("BOTTOM", nestedFramesPages.frameText.getText(), "Текст не соответствует ожидаемому");
        driver.switchTo().defaultContent();
    }
}
