package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.TEST_REGISTRATION;
import static core.AppManager.loginHelper;

public class LoginTests extends BaseTest {
    @BeforeMethod
    void precondition() {
        if (loginHelper.isLogOutPresent()) {
            loginHelper.clickLogOutButton();
        }
    }

    @Test(description = "Проверка успешной регистрации", groups = {"Positive"})
    void test1Sm() {
        loginHelper.clickOnLoginLink();
        loginHelper.fillLoginForm(TEST_REGISTRATION);
        loginHelper.clickLoginButton();
        Assert.assertTrue(loginHelper.isLogOutPresent(), "Не отображается кнопка 'Log Out'");
    }
}
