package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.AppProperties;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    public static String baseUrl = AppProperties.getInstance().getProperty("sconto.url.login");
    private static String email = AppProperties.getInstance().getProperty("login");
    private static String password = AppProperties.getInstance().getProperty("password");
    @FindBy(css = "[id='Email']")
    SelenideElement loginEmail;
    @FindBy(css = "[id='Password']")
    SelenideElement loginPassword;
    @FindBy(css = "[class='button-1 login-button']")
    SelenideElement loginBtn;


    public LoginPage fillDataEmailAndPassword() {
        loginEmail.val(email);
        loginPassword.val(password);
        return Selenide.page(this);
    }

    public HomePage clickLoginBtn() {
        loginBtn.click();
        return Selenide.page(HomePage.class);

    }

}
