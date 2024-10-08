package steps;


import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;
import phonebook.core.AppManager;

import static phonebook.core.AppManager.navigationPanel;
import static phonebook.core.BasePage.waitInSeconds;

public class BaseSteps {

    //System.getProperty("browser", "chrome") - второе значение это по умолчанию если не передан параметр.
    static AppManager app = new AppManager(System.getProperty("browser", "chrome"));
//    private static final Logger LOG = LoggerFactory.getLogger(BaseSteps.class);

    @BeforeAll
    public static void setUp() {
        app.init();
    }

    @AfterAll
    public static void tearDown() {
        app.stop();
    }

    @Before("@BeforeLogin")
    public void precondition1() {
        if (navigationPanel.isSignOutPresent()) {
            navigationPanel.clickOnSignOutButton();
        }
    }

    @Если("есть кнопка 'Sign_Out' то нажимаем на нёё")
    public void precondition2() {
        if (navigationPanel.isSignOutPresent()) {
            navigationPanel.clickOnSignOutButton();
        }
    }

    @Тогда("ожидаем {int} секунд(ы)")
    public void waitInSecondsStep(int seconds) {
        waitInSeconds(seconds);
    }
}
