package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static phonebook.core.AppManager.aboutPage;

@Tag("@ALL")
@Tag("@ABOUT")
@Tag("@SMOKE")
public class AboutPageTests extends BaseTest {

    @Test
    @DisplayName("Проверка страницы Abut")
    void test2() {
        aboutPage.clickAboutLink();
        assertAll(
                () -> assertTrue(aboutPage.isContactsWebPresent(), "Не отображается 'Contacts Web'"),
                () -> assertTrue(aboutPage.isTestAppPresent(), "Не отображается 'Test App'"),
                () -> assertTrue(aboutPage.isUseDevToolsPresent(), "Не отображается 'Use DevTools'")
        );
    }

}
