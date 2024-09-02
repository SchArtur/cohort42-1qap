package phonebook.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import phonebook.core.BaseHelper;
import phonebook.data.User;

import static phonebook.core.AppManager.TEST_USER;

public class LoginPageHelper extends BaseHelper {

    @Step("Нажимаем на кнопку LOGIN на верхней панели")
    public void clickOnLoginLink() {
        clickOnElement(By.cssSelector("[href='/login']"));
    }

    @Step("Заполняем данные пользователя {0}")
    public void fillLoginForm(User user) {
        fillInputField(By.xpath("//*[@name='email']"), user.getEmail());
        fillInputField(By.xpath("//*[@name='password']"), user.getPassword());
    }

    @Step("Нажимаем на кнопку Login на форме ввода")
    public void clickOnLoginButton() {
        clickOnElement(By.xpath("//*[text()='Login']"));
    }

    @Step("Нажимаем на кнопку Registration на форме ввода")
    public void clickOnRegistrationButton() {
        clickOnElement(By.xpath("//*[text()='Registration']"));
    }

    @Step("Нажимаем на кнопку Sign Out")
    public void clickOnSignOutButton() {
        clickOnElement(By.xpath("//*[text()='Sign Out']"));
    }

    @Step("Авторизуемся под тестовым пользователем")
    public void loginTestUser() {
        clickOnLoginLink();
        fillLoginForm(TEST_USER);
        clickOnLoginButton();
    }

    @Step("Проверяем наличие кнопки 'Sign Out'")
    public boolean isSignOutPresent() {
        return elementIsDisplayed(By.xpath("//*[text()='Sign Out']"));
    }

    @Step("Получаем сообщение об ошибке")
    public String getErrorMessage() {
        return getElement(By.xpath("//*[contains(text(),'401')]")).getText();
    }


}
