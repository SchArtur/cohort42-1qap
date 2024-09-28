package tests.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static core.Init.*;

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
        Assertions.assertEquals("C:\\fakepath\\java_error_in_idea_7101.log",uploadAndDownloadPage.fillUploadFileMouseEvents());
    }

    @Test
    void test2() {
        Assertions.assertEquals("C:\\fakepath\\java_error_in_idea_7101.log",uploadAndDownloadPage.fillUploadFileKeyEvents());
    }

}
