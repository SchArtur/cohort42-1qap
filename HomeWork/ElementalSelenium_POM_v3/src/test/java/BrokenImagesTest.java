import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static core.AppManager.brokenImagesPage;
import static core.AppManager.homePages;

public class BrokenImagesTest extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePages.brokenImagesLink.click();
    }
    @Test
    void test1() {
        brokenImagesPage.checkBrokenImages();
    }

    @Test
    void test2() {
        Assertions.assertFalse(brokenImagesPage.imageIsDisplayed(brokenImagesPage.image1), "Изображение 1 не отображается, как ожидалось.");
        Assertions.assertTrue(brokenImagesPage.linkIsValid(brokenImagesPage.image1), "Ссылка на изображение 1 не валидна.");
    }

    @Test
    void test4() {
        Assertions.assertFalse(brokenImagesPage.imageIsDisplayed(brokenImagesPage.image2), "Изображение 2 отображается, хотя должно быть сломано.");
        Assertions.assertTrue(brokenImagesPage.linkIsValid(brokenImagesPage.image2), "Ссылка на изображение 2 не валидна.");
    }

    @Test
    void test5() {
        Assertions.assertFalse(brokenImagesPage.imageIsDisplayed(brokenImagesPage.image3), "Изображение 3 отображается, хотя должно быть сломано.");
        Assertions.assertTrue(brokenImagesPage.linkIsValid(brokenImagesPage.image3), "Ссылка на изображение 3 не валидна.");
    }
}




