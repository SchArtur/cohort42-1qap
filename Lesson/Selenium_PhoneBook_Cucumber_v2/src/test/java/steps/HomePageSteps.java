package steps;

import io.cucumber.java.ru.Тогда;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static phonebook.core.AppManager.homePage;

public class HomePageSteps {

    @Тогда("Проверяем наличие элемента (Home Component|For QA|Contacts App) на странице Home$")
    public void isSignOutPresent(String pageComponent) {
        switch (pageComponent) {
            case "Home Component" -> assertTrue(homePage.isHomeComponentPresent(), "Не отображается 'Home Component'");
            case "For QA" -> assertTrue(homePage.isReactAppPresent(), "Не отображается 'React App'");
            case "Contacts App" -> assertTrue(homePage.isForQaPresent(), "Не отображается 'For QA'");
        }
    }

}
