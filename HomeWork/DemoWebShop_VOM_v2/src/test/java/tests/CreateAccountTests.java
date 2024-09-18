package tests;

import utils.DataProviders;
import data.Registration;
import data.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.*;

public class CreateAccountTests extends BaseTest {
    @BeforeMethod
    void precondition() {
        if (loginHelper.isLogOutPresent()) {
            loginHelper.clickLogOutButton();
        }
    }
    @Test(description = "Проверка успешной регистрации", groups = {"Positive"})
    void test2() {
        createAccountHelper.clickOnRegisterLink();
        createAccountHelper.fillInTheFieldsForTheNewUser(TEST_USER, NEW_REGISTRATION);
        createAccountHelper.clickOnRegisterButton();
        createAccountHelper.clickLogOutButton();
    }

    @Test(description = "Проверка не успешной регистрации", groups = {"Negative"},dataProvider = "getUsers",dataProviderClass = DataProviders.class)
    void test3(User user, Registration registration) {
        createAccountHelper.clickOnRegisterLink();
        createAccountHelper.fillInTheFieldsForTheNewUser(user, registration);
        createAccountHelper.clickOnRegisterButton();
        createAccountHelper.clickLogOutButton();
        Assert.assertTrue(!createAccountHelper.getCurrentUrl().equals("https://demowebshop.tricentis.com/login"));
    }
}