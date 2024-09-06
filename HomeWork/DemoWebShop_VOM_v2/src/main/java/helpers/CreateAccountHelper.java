package helpers;

import core.BaseHelper;
import data.Registration;
import data.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CreateAccountHelper extends BaseHelper {

    @Step("Нажимаем на кнопку Register на верхней панели")
    public void clickOnRegisterLink() {
        clickOnElement(By.xpath("//*[@href='/register']"));
    }

    @Step("заполняем данные пользователя {0}")
    public CreateAccountHelper fillInTheFieldsForTheNewUser(User user,Registration registration) {
        clickOnElement(By.xpath("//*[@id='gender-female']"));
        fillInputField(By.xpath("//*[@name='FirstName']"), user.getFirstName());
        fillInputField(By.xpath("//*[@name='LastName']"), user.getLastName());
        fillInputField(By.xpath("//*[@name='Email']"), registration.getEmail());
        fillInputField(By.xpath("//*[@name='Password']"), registration.getPassword());
        fillInputField(By.xpath("//*[@name='ConfirmPassword']"), registration.getPassword());
        return this;
    }

    @Step("Нажимаем на кнопку Register")
    public void clickOnRegisterButton() {
        clickOnElement(By.xpath("//*[@name='register-button']"));
    }

    @Step("Нажимаем на кнопку Log Out ")
    public void clickLogOutButton() {
        clickOnElement(By.xpath("//*[@href='/logout']"));
    }
}
