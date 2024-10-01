package tests.alerts_frame_windows;

import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

import static core.Init.*;

@Tag("@ALL")
public class NestedFramesPageTest extends BaseTest {

    @BeforeAll
    static void getAlertsPage() {
        homePage.alertFrameWindowsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!browserWindowsPage.titleTextCenterIsDisplayed() || !browserWindowsPage.getTitleTextCenter().equals("Nested Frames")) {
            leftPanel.nestedFramesButton.click();
        }
    }

    @Test
    void test1() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nestedFramesPage.parentFrame));
        Assertions.assertEquals("Parent frame", nestedFramesPage.parentBody.getText());

        driver.switchTo().frame(nestedFramesPage.childFrame);
        Assertions.assertEquals("Child Iframe", nestedFramesPage.childFrameText.getText());
    }
}
