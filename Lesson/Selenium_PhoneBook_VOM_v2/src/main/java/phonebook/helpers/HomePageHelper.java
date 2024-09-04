package phonebook.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import phonebook.core.BaseHelper;

public class HomePageHelper extends BaseHelper {

    @Step("Нажимаем на кнопку HOME")
    public void clickHomeLink() {
        clickOnElement(By.cssSelector("[href='/home']"));
    }

    @Step("Проверяем, что 'Home Component' отображается")
    public boolean isHomeComponentPresent() {
        return elementIsDisplayed(By.xpath("//*[text()='Home Component']"));
    }

    @Step("Проверяем, что 'React Contacts App' отображается")
    public boolean isReactAppPresent() {
        return elementIsDisplayed(By.xpath("//*[text()='React Contacts App']"));
    }

    @Step("Проверяем, что 'For QA Testing' отображается")
    public boolean isForQaPresent() {
        return elementIsDisplayed(By.xpath("//*[text()='For QA Testing']"));
    }

}
