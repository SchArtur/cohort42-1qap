package phonebook.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import phonebook.core.BasePage;

import java.util.List;

public class AboutPage extends BasePage {

    @FindBy(css = "[href='/about']")
    WebElement aboutLink;

    @FindBy(xpath = "//*[text()=' Contacts Web Application']")
    List<WebElement> webApp;

    @FindBy(xpath = "//*[text()='Test App']")
    List<WebElement> testApp;

    @FindBy(xpath = "//*[text()='Use DevTools to see Network Activity']")
    List<WebElement> useDevtool;

    @Step("Нажимаем на кнопку ABOUT")
    public void clickAboutLink() {
        clickOnElement(aboutLink);
    }

    @Step("Проверяем, что 'Contacts Web Application' отображается")
    public boolean isContactsWebPresent() {
        return elementIsDisplayed(webApp);
    }

    @Step("Проверяем, что 'Test App' отображается")
    public boolean isTestAppPresent() {
        return elementIsDisplayed(testApp);
    }

    @Step("Проверяем, что 'Use DevTools to see Network Activity' отображается")
    public boolean isUseDevToolsPresent() {
        return elementIsDisplayed(useDevtool);
    }
}
