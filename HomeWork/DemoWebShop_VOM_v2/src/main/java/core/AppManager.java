package core;

import data.Registration;
import data.User;
import helpers.AddItemToCartHelper;
import helpers.CreateAccountHelper;
import helpers.LoginHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.BaseHelper.getRandomEmail;

public class AppManager {
    public static final Registration TEST_REGISTRATION = new Registration("larysa@gmail.com", "qwerty");
    public static final Registration NEW_REGISTRATION = new Registration(getRandomEmail(), "qwerty");
    public static final User TEST_USER = new User("Larysa", "Petrova");
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static LoginHelper loginHelper;
    public static CreateAccountHelper createAccountHelper;
    public static AddItemToCartHelper addItemToCartHelper;
    public static final String URL= "https://demowebshop.tricentis.com/";
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(URL);

        loginHelper=new LoginHelper();
        createAccountHelper=new CreateAccountHelper();
        addItemToCartHelper=new AddItemToCartHelper();
    }
    public void stop(){
        driver.quit();
    }
}
