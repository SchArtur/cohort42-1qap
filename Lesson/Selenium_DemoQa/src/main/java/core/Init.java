package core;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.alerts_frame_windows.*;
import pages.HomePage;
import pages.LeftPanel;
import pages.book_store.LoginPage;
import pages.book_store.RegisterPage;
import pages.forms.PracticeFormPage;

import java.time.Duration;
import java.util.logging.Logger;

import static pages.BasePage.getRandomEmail;
import static pages.BasePage.getRandomValue;

public class Init {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private final String URL = "https://demoqa.com/";
    public static HomePage homePage;
    public static LeftPanel leftPanel;
    public static AlertsPage alertsPage;
    public static LoginPage loginPage;
    public static RegisterPage registerPage;
    public static BrowserWindowsPage browserWindowsPage;
    public static FramesPage framesPage;
    public static NestedFramesPage nestedFramesPage;
    public static ModalDialogsPage modalDialogsPage;
    public static PracticeFormPage practiceFormPage;

    public static final User TEST_USER = new User("testg@mail.com", "Manuel1234$");
    public static final User USER_FOR_REGISTRATION = new User(getRandomValue(), getRandomValue(), getRandomEmail(), "Manuel1234$");

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
//        options.addArguments("headless"); // не будет открывать окно браузера, но тесты проходить будут
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
//        driver.manage().window().maximize();
        driver.get(URL);
        homePage = new HomePage();
        leftPanel = new LeftPanel();
        alertsPage = new AlertsPage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        browserWindowsPage = new BrowserWindowsPage();
        framesPage = new FramesPage();
        nestedFramesPage = new NestedFramesPage();
        modalDialogsPage = new ModalDialogsPage();
        practiceFormPage = new PracticeFormPage();
    }

    public void stop() {
        driver.quit();
    }
}
