package tests.alerts_frame_windows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.alerts_frame_windows.BrowserWindowsPage;
import tests.BaseTest;

import static core.Init.*;

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
