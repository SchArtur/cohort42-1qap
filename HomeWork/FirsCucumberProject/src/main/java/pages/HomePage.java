package pages;

import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    @FindBy(tagName = "h1")
    WebElement homePageTitle;
    @FindBy(css = "[href='/login']")
    WebElement loginLink;
    @FindBy(css = "[href='/logout']")
    WebElement logoutLink;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void openHomePage(){
        driver.get("https://demowebshop.tricentis.com/");
    }

    public HomePage checkTitleText(String text) {
        Assert.assertTrue(isElementDisplayed(homePageTitle));
        Assert.assertEquals("Текст ошибки не соответствует ожидаемому", text, homePageTitle.getText());
        return this;
    }

    public void clickOnLoginButton() {
        loginLink.click();
    }
    public void clickOnLogoutButton() {
        click(logoutLink);
    }

}
