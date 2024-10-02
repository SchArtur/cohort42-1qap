package steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static phonebook.core.AppManager.navigationPanel;

public class NavigationPanelSteps {

    @Тогда("проверяем наличие кнопки 'SignOut'")
    public void isSignOutPresent() {
        assertTrue(navigationPanel.isSignOutPresent(), "Нет кнопки SignOut");
    }

    @Тогда("проверяем отсутствие кнопки 'SignOut'")
    public void isSignOutDontPresent() {
        assertFalse(navigationPanel.isSignOutPresent(), "Нет кнопки SignOut");
    }


    @Когда("нажимаем на кнопку '{webElement}' в заголовке")
    public void clickOnLink(WebElement element) {
        navigationPanel.clickOnLink(element);
    }

    @ParameterType("LOGIN|ADD|HOME|CONTACTS|SIGN_OUT")
    public WebElement webElement(String elementName) {
        switch (elementName) {
            case "LOGIN" -> {
                return navigationPanel.loginLink;
            }
            case "ADD" -> {
                return navigationPanel.addLink;
            }
            case "HOME" -> {
                return navigationPanel.homeLink;
            }
            case "CONTACTS" -> {
                return navigationPanel.contactsLink;
            }
            case "SIGN_OUT" -> {
                return navigationPanel.signOutLink;
            }
            default -> {
                return null;
            }
        }
    }
}
