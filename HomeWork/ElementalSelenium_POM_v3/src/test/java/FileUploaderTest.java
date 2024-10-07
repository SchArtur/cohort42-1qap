import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static core.AppManager.fileUploaderPage;
import static core.AppManager.homePages;

public class FileUploaderTest extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePages.fileUploadLink.click();
    }

    @Test
    public void uploadFileWithRobotKeyboardTest() {
        fileUploaderPage.uploadFileWithRobotKeyboard();
        fileUploaderPage.verifyFileName("A4.txt");
    }

    @Test
    public void uploadFileWithRobotMouseTest() {
        fileUploaderPage.uploadFileWithRobotMouse();
        fileUploaderPage.verifyFileName("A4.txt");

    }
}
