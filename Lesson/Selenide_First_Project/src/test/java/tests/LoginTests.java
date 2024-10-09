package tests;

import org.junit.jupiter.api.Test;
import sconto.page.HomePage;

import static com.codeborne.selenide.Condition.text;

public class LoginTests {

    HomePage homePage;

    @Test
    void validLogin() {
        homePage = new HomePage()
                .openHomePage()
                .acceptCookies()
                .clickLoginLink()
                .fillTestDataEmailAndPassword()
                .clickSubmitBtn();

        homePage.loginStatus.shouldHave(text("Test Test"));
    }
}
