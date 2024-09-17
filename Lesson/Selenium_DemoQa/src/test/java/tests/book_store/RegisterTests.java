package tests.book_store;

import org.junit.jupiter.api.*;
import tests.BaseTest;

import static core.Init.*;

public class RegisterTests extends BaseTest {

    @BeforeAll
    static void startTests() {
        homePage.scrollPage();
        homePage.bookStoreAppCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!loginPage.titleTextCenterIsDisplayed() || !loginPage.getTitleTextCenter().equals("Register")) {
            leftPanel.loginButton.click();
            loginPage.newUserButton.click();
        }
    }

    @Test
    @DisplayName("Register to Book Store - valid data")
    void test1() {
        registerPage.fillRegisterForm(USER_FOR_REGISTRATION);
        registerPage.waitInSeconds(1);
        registerPage.jsClickElement(registerPage.captchaCheckbox);
        registerPage.waitInSeconds(5);
        registerPage.registerButton.click();
        Assertions.assertEquals("User Register Successfully.", registerPage.getAlertText());
    }

}
