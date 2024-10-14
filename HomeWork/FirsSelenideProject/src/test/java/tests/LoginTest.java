package tests;

import org.junit.jupiter.api.Test;
import page.HomePage;

public class LoginTest {


    @Test
    void validLogin(){
        new HomePage()
//                .openLoginPage()
                .openHomePage()
                .clickLoginLink()
                .fillDataEmailAndPassword()
                .clickLoginBtn()
                .clickLogoutBtn();

    }
}
