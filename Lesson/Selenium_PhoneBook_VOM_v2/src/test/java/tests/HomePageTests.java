package tests;

import org.testng.annotations.Test;

import static phonebook.core.AppManager.homePageHelper;


public class HomePageTests extends BaseTest {

    @Test
    void test1() {
        homePageHelper.clickHomeLink();
        softAssert.assertTrue(homePageHelper.isHomeComponentPresent(), "Не отображается 'Home Component'");
        softAssert.assertTrue(homePageHelper.isReactAppPresent(), "Не отображается 'React App'");
        softAssert.assertTrue(homePageHelper.isForQaPresent(), "Не отображается 'For QA'");
        softAssert.assertAll();
    }



}
