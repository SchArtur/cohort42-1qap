package theIntertet.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import theIntertet.helpers.HomePage;
import theIntertet.helpers.JavaScriptAlertsPage;
import theIntertet.helpers.MultipleWindowsPage;
import theIntertet.helpers.NestedFramesPage;
import theIntertet.utils.Listener;

import java.time.Duration;


public class AppManager {
    public static final Logger LOG = LoggerFactory.getLogger(AppManager.class);
    public static final String URL = "https://the-internet.herokuapp.com/";

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static HomePage homePage;

    public static JavaScriptAlertsPage alertsPage;

    public static MultipleWindowsPage multipleWindows;

    public static NestedFramesPage nestedFrames;



    private String browser;

    public AppManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
//        options.addArguments("headless"); // не будет открывать окно браузера, но тесты проходить будут
        LOG.info("Выбран браузер - {}", browser);
        switch (browser) {
            case "chrome" -> driver = new ChromeDriver(options);
            case "safari" -> driver = new SafariDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> {driver = new ChromeDriver(options);
                LOG.warn("Выбран браузер не из списка доступных, или с ошибкой - {}", browser);}
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        WebDriverListener listener = new Listener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        driver.get(URL);

        homePage = new HomePage();
        alertsPage = new JavaScriptAlertsPage();
        multipleWindows = new MultipleWindowsPage();
        nestedFrames = new NestedFramesPage();

    }

    public void stop() {
        driver.quit();
    }

}
