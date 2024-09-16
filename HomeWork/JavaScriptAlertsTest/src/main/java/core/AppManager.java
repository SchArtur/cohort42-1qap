package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page.JavaScriptAlertsPages;
import utils.Listener;

import java.time.Duration;

public class AppManager {
    public static final Logger LOG = (Logger) LoggerFactory.getLogger(AppManager.class);
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavaScriptAlertsPages javaScriptAlertsPages;
    public static final String URL = "https://the-internet.herokuapp.com/javascript_alerts";
    private String browser;

    public AppManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        LOG.info("Выбран браузер - {}", browser);

        switch (browser) {
            case "chrome" -> driver = new ChromeDriver(options);
            case "safari" -> driver = new SafariDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> driver = new ChromeDriver(options);
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        //driver.manage().window().maximize();
        WebDriverListener listener = new Listener();
//        driver = new EventFiringDecorator<>(listener).decorate(driver);
        LOG.info("Открываем страницу - {}", URL);
        driver.get(URL);

        javaScriptAlertsPages = new JavaScriptAlertsPages();
    }

    public void stop() {
        driver.quit();
    }
}
