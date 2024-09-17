package pages.book_store;

import model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class RegisterPage extends BasePage {

    @FindBy(id = "firstname")
    public WebElement firstNameField;

    @FindBy(id = "lastname")
    public WebElement lastNameField;

    @FindBy(id = "userName")
    public WebElement loginField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//span[@id='recaptcha-anchor']")
    public WebElement captchaCheckbox;

    @FindBy(xpath = "//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")
    public WebElement captchaFrame;

    @FindBy(id = "register")
    public WebElement registerButton;

    @FindBy(id = "gotologin")
    public WebElement goToLoginButton;

    public void fillRegisterForm(User user) {
        fillInputField(firstNameField, user.getFirstName());
        waitInSeconds(1);
        fillInputField(lastNameField, user.getLastName());
        waitInSeconds(1);
        fillInputField(loginField, user.getEmail());
        waitInSeconds(1);
        fillInputField(passwordField, user.getPassword());
    }
}
