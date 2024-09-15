package tests;

import utils.DataProviders;
import data.Registration;
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
    @Test(description = "Проверка не успешной регистрации", groups = {"Negative"},dataProvider = "getRegistrations",dataProviderClass = DataProviders.class )
    void test2Sm(Registration registration) {
        loginHelper.clickOnLoginLink();
        loginHelper.fillLoginForm(registration);
        loginHelper.clickLoginButton();
        Assert.assertTrue(loginHelper.getAlertText().contains("Please enter a valid email address."),"Текст уведомления не содержит нужную строку");
        Assert.assertTrue(loginHelper.getAlertText().contains("Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect"),"Текст уведомления не содержит нужную строку");
        Assert.assertTrue(loginHelper.isLogOutPresent(), "отображается кнопка 'Log Out'");
    }

}
