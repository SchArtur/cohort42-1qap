package phonebook.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import phonebook.core.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "[href='/home']")
    WebElement homeLink;

    @FindBy(xpath = "//*[text()='Home Component']")
    List<WebElement> homeComponent;

    @FindBy(xpath = "//*[text()='React Contacts App']")
    List<WebElement> reactAp;

    @FindBy(xpath = "//*[text()='For QA Testing']")
    List<WebElement> forQaTesting;


    @Step("Нажимаем на кнопку HOME")
    public void clickHomeLink() {
        clickOnElement(homeLink);
    }

    @Step("Проверяем, что 'Home Component' отображается")
    public boolean isHomeComponentPresent() {
        return elementIsDisplayed(homeComponent);
    }

    @Step("Проверяем, что 'React Contacts App' отображается")
    public boolean isReactAppPresent() {
        return elementIsDisplayed(reactAp);
    }

    @Step("Проверяем, что 'For QA Testing' отображается")
    public boolean isForQaPresent() {
        return elementIsDisplayed(forQaTesting);
    }

}
