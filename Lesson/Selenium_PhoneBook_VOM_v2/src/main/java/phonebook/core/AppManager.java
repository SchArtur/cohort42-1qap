package phonebook.core;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import phonebook.data.Contact;
import phonebook.data.User;
import phonebook.helpers.AboutPageHelper;
import phonebook.helpers.HomePageHelper;
import phonebook.helpers.LoginPageHelper;

import java.time.Duration;

import static phonebook.core.BaseHelper.getRandomEmail;

public class AppManager {
    public static final User TEST_USER = new User("manuel@gm.com", "Manuel1234$");
    public static final Contact TEST_CONTACT = new Contact("TestUnuTest", "Testov", "1234567890", getRandomEmail(), "address", "discr");
    public static final User NEW_USER = new User(getRandomEmail(), "Qweeee123!");

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static HomePageHelper homePageHelper;
    public static AboutPageHelper aboutPageHelper;
    public static LoginPageHelper loginPageHelper;


    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://telranedu.web.app");

        homePageHelper = new HomePageHelper();
        aboutPageHelper = new AboutPageHelper();
        loginPageHelper = new LoginPageHelper();
    }

    public void stop() {
        driver.quit();
    }

}
