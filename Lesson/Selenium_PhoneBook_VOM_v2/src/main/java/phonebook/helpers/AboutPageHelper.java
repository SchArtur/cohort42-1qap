package phonebook.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import phonebook.core.BaseHelper;

public class AboutPageHelper extends BaseHelper {

    @Step("Нажимаем на кнопку ABOUT")
    public void clickHomeLink() {
        clickOnElement(By.cssSelector("[href='/about']"));
    }

    @Step("Проверяем, что 'Contacts Web Application' отображается")
    public boolean isContactsWebPresent() {
        return elementIsDisplayed(By.xpath("//*[text()=' Contacts Web Application']"));
    }

    @Step("Проверяем, что 'Test App' отображается")
    public boolean isTestAppPresent() {
        return elementIsDisplayed(By.xpath("//*[text()='Test App']"));
    }

    @Step("Проверяем, что 'Use DevTools to see Network Activity' отображается")
    public boolean isUseDevToolsPresent() {
        return elementIsDisplayed(By.xpath("//*[text()='Use DevTools to see Network Activity']"));
    }
}
