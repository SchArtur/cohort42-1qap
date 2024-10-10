package steps;

import core.BasePage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageStep {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
       startDriver();
    }

    public static void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void close(){
        new BasePage(driver,wait).closeDriver();
    }

    @Given("Пользователь открывает домашнюю страницу")
    public void registrationHomePage() {
        new HomePage(driver,wait).openHomePage();
    }

    @And("Пользователь нажимает ссылку «Войти»")
    public void clickOnLoginLink() {
        new HomePage(driver,wait).clickOnLoginButton();
    }

    @When("Вводим действительный email и пароль and click LogIn")
    public void enterAValidEmailAndPassword() {
        new LoginPage(driver,wait).enterData("larysa@gmail.com", "qwerty");
    }

    @Then("Проверяем кнопку Выход")
    public void clickOnLogoutButton() {
        new HomePage(driver,wait).clickOnLogoutButton();
    }
}