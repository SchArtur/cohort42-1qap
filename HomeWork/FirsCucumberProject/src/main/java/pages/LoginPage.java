package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(css = "[name='Email']")
    WebElement emailInput;

    @FindBy(css = "[name='Password']")
    WebElement passwordInput;

    @FindBy(css = "[value='Log in']")
    WebElement loginBtn;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LoginPage enterData(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        loginBtn.click();
        return this;
    }

}
