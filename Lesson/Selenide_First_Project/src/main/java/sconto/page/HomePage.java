package sconto.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenidePageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sconto.core.ProjectProperties;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public static String baseUrl = ProjectProperties.getInstance().getProperty("sconto.url.home");

    //1 вариант
    @FindBy(css = "[data-accept-action='all']")
    WebElement acceptBtnSelenium;

    //2вариант
    @FindBy(css = "[data-accept-action='all']")
    SelenideElement acceptBtnSelenide;

    //3 вариант (может вызвать ошибки, на элементах которые должны появится на странице, и их ещё нет)
    SelenideElement acceptBtn = $("[data-accept-action='all']");

    //4 вариант
    String acceptBtnSelector = "[data-accept-action='all']";

    @FindBy(css = "[href='/login']")
    SelenideElement loginLink;

    @FindBy(css = ".headerElement__status--login")
    SelenideElement loginStatus;

    public HomePage openHomePage() {
        return  Selenide.open(baseUrl, HomePage.class);
    }

    public HomePage acceptCookies() {
        if (acceptBtnSelenide.exists()) {
            acceptBtnSelenide.click();
        }
        return Selenide.page(this);
    }

    public LoginPage clickLoginLink() {
        loginLink.click();
        return Selenide.page(LoginPage.class);
    }

    public HomePage checkStatusLoginText(String text) {
        loginStatus.shouldHave(Condition.text(text));
        return Selenide.page(this);
    }

}
