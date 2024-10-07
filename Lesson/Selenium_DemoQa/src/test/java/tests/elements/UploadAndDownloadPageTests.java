package tests.elements;

 import tests.BaseTest;
//]
import static core.Init.*;

@Tag("@ALL")
@Disabled
public class UploadAndDownloadPageTests extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePage.scrollPage();
        homePage.elementsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!uploadAndDownloadPage.titleTextCenterIsDisplayed() || !linksPage.getTitleTextCenter().equals("Links")) {
            leftPanel.uploadAndDownloadButton.click();
        }
    }

    @Test
    void test1() {
        Assertions.assertEquals("C:\\fakepath\\java_error_in_idea_7101.log", uploadAndDownloadPage.fillUploadFileMouseEvents());
    }

    @Test
    void test2() {
        Assertions.assertEquals("C:\\fakepath\\java_error_in_idea_7101.log", uploadAndDownloadPage.fillUploadFileKeyEvents());
    }

}
