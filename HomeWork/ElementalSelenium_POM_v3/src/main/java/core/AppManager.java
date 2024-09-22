package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePages;
import pages.JavaScriptAlertsPages;
import pages.MultipleWindowsPages;
import pages.NestedFramesPages;
import utils.Listener;

import java.time.Duration;

public class AppManager {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static HomePages homePages;
    public static JavaScriptAlertsPages javaScriptAlertsPages;
    public static NestedFramesPages nestedFramesPages;
    public static MultipleWindowsPages multipleWindowsPages;
    public static final String URL = "https://the-internet.herokuapp.com";

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Увеличение таймаутов
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));  // Увеличено время ожидания загрузки страницы

        WebDriverListener listener = new Listener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        // Инициализация страниц
        homePages = new HomePages();
        javaScriptAlertsPages = new JavaScriptAlertsPages();
        nestedFramesPages = new NestedFramesPages();
        multipleWindowsPages = new MultipleWindowsPages();

        // Переход на URL
        driver.get(URL);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}