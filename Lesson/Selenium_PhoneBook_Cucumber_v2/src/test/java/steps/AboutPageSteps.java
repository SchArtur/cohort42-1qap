package steps;

import io.cucumber.java.ru.Тогда;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static phonebook.core.AppManager.aboutPage;

public class AboutPageSteps {


    @Тогда("Проверяем наличие элемента (Contacts Web|Test App|Use DevTools)$")
    public void isSignOutPresent(String pageComponent) {
        switch (pageComponent) {
            case "Contacts Web" -> assertTrue(aboutPage.isContactsWebPresent(), "Не отображается 'Contacts Web'");
            case "Test App" -> assertTrue(aboutPage.isTestAppPresent(), "Не отображается 'Test App'");
            case "Use DevTools" -> assertTrue(aboutPage.isUseDevToolsPresent(), "Не отображается 'Use DevTools'");
        }
    }

}


