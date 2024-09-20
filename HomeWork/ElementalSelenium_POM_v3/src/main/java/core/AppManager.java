package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePages;
import pages.JavaScriptAlertsPages;
import pages.NestedFramesPages;
import utils.Listener;

import java.time.Duration;

public class AppManager {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static HomePages homePages;
    public static JavaScriptAlertsPages javaScriptAlertsPages;
    public static NestedFramesPages nestedFramesPages;
    public static final String URL = "https://the-internet.herokuapp.com";

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        WebDriverListener listener = new Listener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        driver.get(URL);
        homePages=new HomePages();
        javaScriptAlertsPages = new JavaScriptAlertsPages();
        nestedFramesPages=new NestedFramesPages();
    }
    public void stop() {
        driver.quit();
    }
}
