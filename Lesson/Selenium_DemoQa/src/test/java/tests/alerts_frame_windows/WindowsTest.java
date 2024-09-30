package tests.alerts_frame_windows;

import org.junit.jupiter.api.*;
import tests.BaseTest;

import static core.Init.*;

@Tag("@ALL")
@Tag("@WINDOWS")
public class WindowsTest extends BaseTest {

    @BeforeAll
    static void getAlertsPage() {
        homePage.alertFrameWindowsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!browserWindowsPage.titleTextCenterIsDisplayed() || !browserWindowsPage.getTitleTextCenter().equals("Browser Windows")) {
            leftPanel.browserWindowsButton.click();
        }
    }

    @Test
    void test1() {
        browserWindowsPage.newTab.click();
        browserWindowsPage.switchToWindow(1);
        Assertions.assertEquals("This is a sample page", browserWindowsPage.sampleHeading.getText());
    }

    @Test
    void test2() {
        browserWindowsPage.messageWindowButton.click();
        browserWindowsPage.switchToWindow(1);
        Assertions.assertNotNull(browserWindowsPage.bodyWindow);
    }
}
