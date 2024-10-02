package steps;


import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import phonebook.model.User;

import java.util.Map;

import static phonebook.core.AppManager.*;

public class LoginPageSteps {

    @И("нажимаем на кнопку 'login'")
    public void clickOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Тогда("заполняем данные пользователя")
    public void fillLoginRegisterForm(Map<String, String> userFields) {
        User user = new User(userFields.get("Name"), userFields.get("Password"));
        loginPage.fillLoginForm(user);
    }


    @И("нажимаем на кнопку Registration на форме ввода")
    public void clickOnRegistrationButton() {
        loginPage.clickOnRegistrationButton();
    }

    @И("авторизуемся под тестовым пользователем")
    public void loginTestUser() {
        loginPage.loginTestUser();
    }

    @И("^проверяем текст всплывающего уведомления - \"(.+)\"")
    public void getAlertErrorMessage(String msg) {
        Assertions.assertEquals(msg, loginPage.getAlertText(), "Текст всплывающего уведомления не соответствует ожидаемому");
    }

    @И("^проверяем наличие текста всплывающего уведомления - \"(.+)\"")
    public void getAlertContainsErrorMessage(String msg) {
        Assertions.assertTrue(loginPage.getAlertText().contains(msg), "Текст всплывающего уведомления не соответствует ожидаемому");
    }

//
//    @И("^проверяем текст всплывающего уведомления {string}")
//    public void getAlertErrorMessage(String msg) {
//        Assertions.assertEquals(msg, loginPage.getAlertText(), "Текст всплывающего уведомления не соответствует ожидаемому");
//    }


    @И("^проверяем текст ошибки - \"(.+)\"$")
    public void getErrorMessage(String msg) {
        Assertions.assertEquals(msg, loginPage.getErrorMessage(), "Текст всплывающего уведомления не соответствует ожидаемому");
    }

    @И("заполняем данные пользователя {user}")
    public void fillLoginForm(User user) {
        loginPage.fillLoginForm(user);
    }

    @ParameterType("TEST_USER|NEW_USER")
    public User user(String userType) {
        if (userType.equals("TEST_USER")) {
            return TEST_USER;
        }
        return NEW_USER;
    }


//    void test3() {
//        loginPage.fillLoginForm(TEST_USER);
//        loginPage.clickOnLoginButton();
//        Assertions.assertTrue(loginPage.isSignOutPresent(), "Не отображается кнопка 'Sign Out'");
//    }
//
//    @Test
//    @DisplayName("Проверка авторизации c не валидными данными")
//    void test4() {
//        loginPage.fillLoginForm(NEW_USER);
//        loginPage.clickOnLoginButton();
//        Assertions.assertEquals("Wrong email or password", loginPage.getAlertText(), "Текст всплывающего уведомления не соответствует ожидаемому");
//        Assertions.assertTrue(!loginPage.isSignOutPresent(), "Отображается кнопка 'Sign Out'");
//        Assertions.assertEquals("Login Failed with code 401", loginPage.getErrorMessage(), "Текст ошибки не соответствует ожидаемому");
//        Assertions.assertAll();
//    }
//
//    @Test
//    @Tag("@SMOKE")
//    @DisplayName("Проверка успешной регистрации")
//    void test5() {
//        loginPage.fillLoginForm(NEW_USER);
//        loginPage.clickOnRegistrationButton();
//        Assertions.assertTrue(loginPage.isSignOutPresent(), "Не отображается кнопка 'Sign Out'");
//    }
//
//    @ParameterizedTest
//    @ArgumentsSource(UsersProvider.class)
//    @DisplayName("Проверка регистрации с не валидными данными")
//    void test6(User user) {
//        loginPage.clickOnLoginLink();
//        loginPage.fillLoginForm(user);
//        loginPage.clickOnRegistrationButton();
//        Assertions.assertTrue(loginPage.getAlertText().contains("Wrong email or password format"), "Текст всплывающего уведомления не содержит нужную строку");
//        Assertions.assertTrue(!loginPage.isSignOutPresent(), "Отображается кнопка 'Sign Out'!");
//    }
}