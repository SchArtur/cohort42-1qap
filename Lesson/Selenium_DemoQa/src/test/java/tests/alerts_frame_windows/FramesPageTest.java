package tests.alerts_frame_windows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import tests.BaseTest;

import static core.Init.*;

public class FramesPageTest extends BaseTest {

    @BeforeAll
    static void getAlertsPage() {
        homePage.alertFrameWindowsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!browserWindowsPage.titleTextCenterIsDisplayed() || !browserWindowsPage.getTitleTextCenter().equals("Frames")) {
            leftPanel.framesButton.click();
        }
    }
    @Test
    void test1() {
        driver.switchTo().frame(framesPage.frame1);
        Assertions.assertEquals("This is a sample page", framesPage.textInFrame.getText());
        Assertions.assertTrue(framesPage.sampleHeadingTextIsDisplayed());
        driver.switchTo().defaultContent();
        Assertions.assertFalse(framesPage.sampleHeadingTextIsDisplayed());

    }

    @Test
    void test2() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framesPage.frame2));
        Assertions.assertEquals("This is a sample page", framesPage.textInFrame.getText());
        Assertions.assertTrue(framesPage.sampleHeadingTextIsDisplayed());
        driver.switchTo().defaultContent();
        Assertions.assertFalse(framesPage.sampleHeadingTextIsDisplayed());
    }
}
