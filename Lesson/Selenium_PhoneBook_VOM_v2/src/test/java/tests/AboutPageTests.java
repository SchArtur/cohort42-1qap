package tests;

import org.testng.annotations.Test;

import static phonebook.core.AppManager.aboutPageHelper;
import static phonebook.core.AppManager.aboutPageHelper;


public class AboutPageTests extends BaseTest {

    @Test
    void test2() {
        aboutPageHelper.clickHomeLink();
        softAssert.assertTrue(aboutPageHelper.isContactsWebPresent(), "Не отображается 'Contacts Web'");
        softAssert.assertTrue(aboutPageHelper.isTestAppPresent(), "Не отображается 'Test App'");
        softAssert.assertTrue(aboutPageHelper.isUseDevToolsPresent(), "Не отображается 'Use DevTools'");
        softAssert.assertAll();
    }

}
