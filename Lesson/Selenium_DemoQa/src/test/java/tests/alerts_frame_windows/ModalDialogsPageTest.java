package tests.alerts_frame_windows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import tests.BaseTest;

import static core.Init.*;

public class ModalDialogsPageTest extends BaseTest {

    @BeforeAll
    static void getAlertsPage() {
        homePage.alertFrameWindowsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!browserWindowsPage.titleTextCenterIsDisplayed() || !browserWindowsPage.getTitleTextCenter().equals("Modal Dialogs")) {
            leftPanel.modalDialogsButton.click();
        }
    }

    @Test
    void test1() {
        modalDialogsPage.showSmallModal.click();
        Assertions.assertEquals("This is a small modal. It has very less content", modalDialogsPage.getModalText());
        modalDialogsPage.closeSmallModalButton.click();

        modalDialogsPage.showLargeModal.click();
        Assertions.assertTrue(modalDialogsPage.getModalText().contains("Lorem Ipsum is simply dummy text "));
        modalDialogsPage.closeLargeModalButton.click();
    }
}
