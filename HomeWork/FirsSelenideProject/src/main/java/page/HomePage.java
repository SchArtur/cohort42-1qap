package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.AppProperties;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    public static String url = AppProperties.getInstance().getProperty("sconto.url.login");
    public static String homeUrl = AppProperties.getInstance().getProperty("demowebshop.url.home");

    @FindBy(css = "[href='/login']")
    SelenideElement loginLink;
    @FindBy(css = "[href='/logout']")
    SelenideElement logoutBtn;

    public HomePage openHomePage() {
        return Selenide.open(homeUrl,HomePage.class);
    }

    public LoginPage openLoginPage() {
        return Selenide.open(url,LoginPage.class);
    }

    public LoginPage clickLoginLink() {
        if (loginLink.exists()) {
            loginLink.click();
        }
        return Selenide.page(LoginPage.class);
    }
    public HomePage clickLogoutBtn() {
        logoutBtn.click();
        return Selenide.page(HomePage.class);

    }
}
