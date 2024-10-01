package tests;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import phonebook.model.User;
import phonebook.utils.UsersProvider;

import static phonebook.core.AppManager.*;

@Tag("@ALL")
@Tag("@LOGIN")
public class LoginPageTests extends BaseTest {

    @BeforeEach
    void precondition() {
        if (loginPage.isSignOutPresent()) {
            loginPage.clickOnSignOutButton();
        }
    }

    @Test
    @Tag("@SMOKE")
    @DisplayName("Проверка успешной авторизации")
    void test3() {
        loginPage.clickOnLoginLink();
        loginPage.fillLoginForm(TEST_USER);
        loginPage.clickOnLoginButton();
        Assertions.assertTrue(loginPage.isSignOutPresent(), "Не отображается кнопка 'Sign Out'");
    }

    @Test
    @DisplayName("Проверка авторизации c не валидными данными")
    void test4() {
        loginPage.clickOnLoginLink();
        loginPage.fillLoginForm(NEW_USER);
        loginPage.clickOnLoginButton();
        Assertions.assertEquals("Wrong email or password", loginPage.getAlertText(), "Текст всплывающего уведомления не соответствует ожидаемому");
        Assertions.assertTrue(!loginPage.isSignOutPresent(), "Отображается кнопка 'Sign Out'");
        Assertions.assertEquals("Login Failed with code 401", loginPage.getErrorMessage(), "Текст ошибки не соответствует ожидаемому");
        Assertions.assertAll();
    }

    @Test
    @Tag("@SMOKE")
    @DisplayName("Проверка успешной регистрации")
    void test5() {
        loginPage.clickOnLoginLink();
        loginPage.fillLoginForm(NEW_USER);
        loginPage.clickOnRegistrationButton();
        Assertions.assertTrue(loginPage.isSignOutPresent(), "Не отображается кнопка 'Sign Out'");
    }

    @ParameterizedTest
    @ArgumentsSource(UsersProvider.class)
    @DisplayName("Проверка регистрации с не валидными данными")
    void test6(User user) {
        loginPage.clickOnLoginLink();
        loginPage.fillLoginForm(user);
        loginPage.clickOnRegistrationButton();
        Assertions.assertTrue(loginPage.getAlertText().contains("Wrong email or password format"), "Текст всплывающего уведомления не содержит нужную строку");
        Assertions.assertTrue(!loginPage.isSignOutPresent(), "Отображается кнопка 'Sign Out'!");
    }
}