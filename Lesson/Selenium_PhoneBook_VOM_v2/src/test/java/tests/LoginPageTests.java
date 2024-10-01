package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import phonebook.utils.DataProviders;
import phonebook.data.User;

import static phonebook.core.AppManager.*;


public class LoginPageTests extends BaseTest {

    @BeforeMethod
    void precondition() {
        if (loginPageHelper.isSignOutPresent()) {
            loginPageHelper.clickOnSignOutButton();
        }
    }

    @Test(description = "Проверка успешной авторизации", groups = {"Positive"})
    void test3Sm() {
        loginPageHelper.clickOnLoginLink();
        loginPageHelper.fillLoginForm(TEST_USER);
        loginPageHelper.clickOnLoginButton();
        Assert.assertTrue(loginPageHelper.isSignOutPresent(), "Не отображается кнопка 'Sign Out'");
    }

    @Test(description = "Проверка авторизации c не валидными данными", groups = {"Negative"})
    void test4() {
        loginPageHelper.clickOnLoginLink();
        loginPageHelper.fillLoginForm(NEW_USER);
        loginPageHelper.clickOnLoginButton();
        softAssert.assertEquals("Wrong email or password", loginPageHelper.getAlertText(), "Текст всплывающего уведомления не соответствует ожидаемому");
        softAssert.assertTrue(!loginPageHelper.isSignOutPresent(), "Отображается кнопка 'Sign Out'");
        softAssert.assertEquals("Login Failed with code 401", loginPageHelper.getErrorMessage(), "Текст ошибки не соответствует ожидаемому");
        softAssert.assertAll();
    }

    @Test(description = "Проверка успешной регистрации", groups = {"Positive"})
    void test5Sm() {
        loginPageHelper.clickOnLoginLink();
        loginPageHelper.fillLoginForm(NEW_USER);
        loginPageHelper.clickOnRegistrationButton();
        Assert.assertTrue(loginPageHelper.isSignOutPresent(), "Не отображается кнопка 'Sign Out'");
    }

    @Test(description = "Проверка регистрации с не валидными данными", groups = {"Negative"}, dataProvider = "getUsers", dataProviderClass = DataProviders.class)
    void test6(User user) {
        loginPageHelper.clickOnLoginLink();
        loginPageHelper.fillLoginForm(user);
        loginPageHelper.clickOnRegistrationButton();
        Assert.assertTrue(loginPageHelper.getAlertText().contains("Wrong email or password format"), "Текст всплывающего уведомления не содержит нужную строку");
        Assert.assertTrue(!loginPageHelper.isSignOutPresent(), "Отображается кнопка 'Sign Out'!");
    }
}