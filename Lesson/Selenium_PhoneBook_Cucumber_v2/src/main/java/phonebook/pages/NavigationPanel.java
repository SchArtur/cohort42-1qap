package phonebook.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import phonebook.core.BasePage;

import java.util.List;

public class NavigationPanel extends BasePage {

    @FindBy(css = "[href='/about']")
    public WebElement aboutLink;
    @FindBy(css = "[href='/add']")
    public WebElement addLink;
    @FindBy(css = "[href='/contacts']")
    public WebElement contactsLink;
    @FindBy(css = "[href='/home']")
    public WebElement homeLink;
    @FindBy(css = "[href='/login']")
    public WebElement loginLink;
    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOutLink;

    @FindBy(xpath = "//*[text()='Sign Out']")
    List<WebElement> signOutButton;

    public void clickOnLink(WebElement element) {
        clickOnElement(element);

    }
    @Step("Нажимаем на кнопку LOGIN на верхней панели")
    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }

    @Step("Нажимаем на кнопку Sign Out")
    public void clickOnSignOutButton() {
        clickOnElement(signOutButton.get(0));
    }

    @Step("Проверяем наличие кнопки 'Sign Out'")
    public boolean isSignOutPresent() {
        return elementIsDisplayed(signOutButton);
    }

    @Step("Проверяем наличие кнопки 'LOGIN'")
    public boolean isLoginLinkPresent() {
        return elementIsDisplayed(loginLink);
    }

}
