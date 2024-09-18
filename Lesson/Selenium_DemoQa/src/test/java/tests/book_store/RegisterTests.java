package tests.book_store;

import org.junit.jupiter.api.*;
import tests.BaseTest;

import static core.Init.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt;

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
        registerPage.waitInSeconds(5);
        wait.until(frameToBeAvailableAndSwitchToIt(registerPage.captchaFrame));
        registerPage.clickOnElement(registerPage.captchaCheckbox);
        registerPage.waitInSeconds(5);
        driver.switchTo().defaultContent();
        registerPage.fillRegisterForm(USER_FOR_REGISTRATION);
        registerPage.clickOnElement(registerPage.registerButton);
        Assertions.assertEquals("User Register Successfully.", registerPage.getAlertText());
    }

}
