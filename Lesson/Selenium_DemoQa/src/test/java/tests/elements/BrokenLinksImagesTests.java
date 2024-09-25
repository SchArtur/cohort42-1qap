package tests.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static core.Init.*;

public class BrokenLinksImagesTests extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePage.elementsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!practiceFormPage.titleTextCenterIsDisplayed() || !practiceFormPage.getTitleTextCenter().equals("Broken Links - Images")) {
            leftPanel.brokenLinksImagesButton.click();
        }
    }

    @Test
    void test1() {
       brokenLinksImagesPage.checkBrokenImages();
    }

    @Test
    void test2() {
        Assertions.assertTrue(brokenLinksImagesPage.imageIsDisplayed(brokenLinksImagesPage.validImage));
        Assertions.assertTrue(brokenLinksImagesPage.linkIsValid(brokenLinksImagesPage.validImage));
    }

    @Test
    void test3() {
        Assertions.assertFalse(brokenLinksImagesPage.imageIsDisplayed(brokenLinksImagesPage.brokenImage));
        Assertions.assertTrue(brokenLinksImagesPage.linkIsValid(brokenLinksImagesPage.brokenImage));
    }

    @Test
    void test4() {
        Assertions.assertTrue(brokenLinksImagesPage.linkIsValid(brokenLinksImagesPage.validLink));
    }

    @Test
    void test5() {
        Assertions.assertFalse(brokenLinksImagesPage.linkIsValid(brokenLinksImagesPage.brokenLink));
    }

}
