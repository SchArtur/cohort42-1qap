package phonebook.core;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phonebook.data.Contact;
import phonebook.data.User;
import phonebook.helpers.AboutPageHelper;
import phonebook.helpers.ContactPageHelper;
import phonebook.helpers.HomePageHelper;
import phonebook.helpers.LoginPageHelper;

import java.time.Duration;

import static phonebook.core.BaseHelper.getNewContact;
import static phonebook.core.BaseHelper.getRandomEmail;

public class AppManager {
    public static final User TEST_USER = new User("manuel@gm.com", "Manuel1234$");
    public static final User NEW_USER = new User(getRandomEmail(), "Qweeee123!");
    public static final Contact TEST_CONTACT = getNewContact();
    public static final Logger LOG = LoggerFactory.getLogger(AppManager.class);
    public static final String URL = "https://telranedu.web.app";

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static HomePageHelper homePageHelper;
    public static AboutPageHelper aboutPageHelper;
    public static LoginPageHelper loginPageHelper;
    public static ContactPageHelper contactPageHelper;


    private String browser;

    public AppManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        LOG.info("Выбран браузер - {}", browser);
        switch (browser) {
            case "chrome" -> driver = new ChromeDriver(options);
            case "safari" -> driver = new SafariDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> {driver = new ChromeDriver(options);
                LOG.warn("Выбран браузер не из списка доступных, или с ошибкой - {}", browser);}
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//        driver.manage().window().maximize();
        LOG.info("Открываем страницу - {}", URL);
        driver.get(URL);

        homePageHelper = new HomePageHelper();
        aboutPageHelper = new AboutPageHelper();
        loginPageHelper = new LoginPageHelper();
        contactPageHelper = new ContactPageHelper();
    }

    public void stop() {
        driver.quit();
    }

}
