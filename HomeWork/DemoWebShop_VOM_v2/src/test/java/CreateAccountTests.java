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
}
