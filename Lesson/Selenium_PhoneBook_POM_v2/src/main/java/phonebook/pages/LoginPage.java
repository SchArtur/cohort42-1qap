package phonebook.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import phonebook.core.BasePage;
import phonebook.model.User;

import java.util.List;

import static phonebook.core.AppManager.TEST_USER;

public class LoginPage extends BasePage {

    @FindBy(css = "[href='/login']")
    WebElement loginLink;
    @FindBy(xpath = "//*[@name='email']")
    WebElement loginField;
    @FindBy(xpath = "//*[@name='password']")
    WebElement passwordField;
    @FindBy(xpath = "//*[text()='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//*[text()='Registration']")
    WebElement registrationButton;
    @FindBy(xpath = "//*[text()='Sign Out']")
    List<WebElement> signOutButton;
    @FindBy(xpath = "//*[contains(text(),'401')]")
    WebElement errorMsg;


    @Step("Нажимаем на кнопку LOGIN на верхней панели")
    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }

    @Step("Заполняем данные пользователя {0}")
    public void fillLoginForm(User user) {
        fillInputField(loginField, user.getEmail());
        fillInputField(passwordField, user.getPassword());
    }

    @Step("Нажимаем на кнопку Login на форме ввода")
    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    @Step("Нажимаем на кнопку Registration на форме ввода")
    public void clickOnRegistrationButton() {
        clickOnElement(registrationButton);
    }

    @Step("Нажимаем на кнопку Sign Out")
    public void clickOnSignOutButton() {
        clickOnElement(signOutButton.get(0));
    }

    @Step("Авторизуемся под тестовым пользователем")
    public void loginTestUser() {
        clickOnLoginLink();
        fillLoginForm(TEST_USER);
        clickOnLoginButton();
    }

    @Step("Проверяем наличие кнопки 'Sign Out'")
    public boolean isSignOutPresent() {
        return elementIsDisplayed(signOutButton);
    }

    @Step("Проверяем наличие кнопки 'LOGIN'")
    public boolean isLoginLinkPresent() {
        return elementIsDisplayed(loginLink);
    }

    @Step("Получаем сообщение об ошибке")
    public String getErrorMessage() {
        return getElement(errorMsg).getText();
    }


}
