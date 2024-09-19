import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static theIntertet.core.AppManager.homePage;
import static theIntertet.core.AppManager.multipleWindows;

public class MultipleWindowsTest extends BaseTest{
    @BeforeAll
    static void getAlertsPage() {
        homePage.multipleWindowsLink.click();
    }

    @Test
    void test1() {
        multipleWindows.linkText.click();
        multipleWindows.switchToWindow(1);
        Assertions.assertEquals("New Window", multipleWindows.neuWindowText.getText(), "Текст не соответствует ожидаемому");
    }

}
