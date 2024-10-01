package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.Listener;

import java.time.Duration;

public class AppManager {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static HomePages homePages;
    public static JavaScriptAlertsPage javaScriptAlertsPages;
    public static NestedFramesPage nestedFramesPages;
    public static MultipleWindowsPage multipleWindowsPages;
    public static HorizontalSliderPage horizontalSliderPages;
    public static JQueryUIMenuPage jQueryUIMenuPage;
    public static ContextMenuPage contextMenuPage;
    public static DropdownPage dropdownPage;
    public static DragAndDropPage dragAndDropPage;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        WebDriverListener listener = new Listener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        homePages = new HomePages();
        javaScriptAlertsPages = new JavaScriptAlertsPage();
        nestedFramesPages = new NestedFramesPage();
        multipleWindowsPages = new MultipleWindowsPage();
        horizontalSliderPages = new HorizontalSliderPage();
        jQueryUIMenuPage = new JQueryUIMenuPage();
        contextMenuPage = new ContextMenuPage();
        dropdownPage = new DropdownPage();
        dragAndDropPage = new DragAndDropPage();

        driver.get(URL);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}