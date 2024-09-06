package helpers;

import core.BaseHelper;
import data.Registration;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static core.AppManager.TEST_REGISTRATION;


public class LoginHelper extends BaseHelper {
    @Step("Нажимаем на кнопку Login на верхней панели")
    public void clickOnLoginLink() {
        clickOnElement(By.cssSelector("[href='/login']"));
    }

    @Step("Заполняем данные пользователя {0}")
    public void fillLoginForm(Registration registration) {
        fillInputField(By.cssSelector("[name='Email']"), registration.getEmail());
        fillInputField(By.cssSelector("[name='Password']"), registration.getPassword());
    }

    @Step("Нажимаем на кнопку Login на форме ввода")
    public void clickLoginButton() {
        clickOnElement(By.cssSelector("[value='Log in']"));
    }

    @Step("Нажимаем на кнопку Register на форме ввода")
    public void clickRegisterButton() {
        clickOnElement(By.cssSelector("[onclick='location.href='/register'']"));
    }

    @Step("Авторизуемся под тестовым пользователем")
    public void loginTestUser() {
        clickOnLoginLink();
        fillLoginForm(TEST_REGISTRATION);
        clickLoginButton();
    }
    @Step("Проверяем наличие кнопки 'Log Out'")
    public boolean isLogOutPresent(){
        return elementIsDisplayed(By.cssSelector("[href='/logout']"));
    }
    @Step("Нажимаем на кнопку Log Out ")
    public void clickLogOutButton() {
        clickOnElement(By.cssSelector("[href='/logout']"));
    }
    @Step("Получаем сообщение об ошибке")
    public String getErrorMessage(){
        return getElement(By.cssSelector("[class='validation-summary-errors']")).getText();
    }
}
