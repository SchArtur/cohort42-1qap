package sconto.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import sconto.core.ProjectProperties;

public class LoginPage {

    private static String testEmail = ProjectProperties.getInstance().getProperty("login");
    private static String testPassword = ProjectProperties.getInstance().getProperty("password");

    @FindBy(css = "#loginEmail")
    SelenideElement loginEmail;

    @FindBy(css = "#loginPassword")
    SelenideElement loginPassword;

    @FindBy(css = "#login-submit")
    SelenideElement submitBtn;

    public LoginPage fillTestDataEmailAndPassword() {
        loginEmail.val(testEmail);
        loginPassword.val(testPassword);
        return Selenide.page(this);
    }

    public HomePage clickSubmitBtn() {
        submitBtn.click();
        return Selenide.page(HomePage.class);
    }

}
