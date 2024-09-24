package pages;

import core.Init;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    @FindBy(css = "[class='text-center']")
    public List<WebElement> titleTextCenter;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage() {
        this.driver = Init.driver;
        this.wait = Init.wait;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void fillInputField(WebElement element, String text) {
        element.click();
        element.clear();
        String value = (text == null) ? " " : text;
        element.sendKeys(value);
    }

    public Alert getAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
//        return driver.switchTo().alert();
    }

    public String getTitleTextCenter() {
        return titleTextCenter.get(0).getText();
    }

    public boolean titleTextCenterIsDisplayed() {
        return titleTextCenter.size() > 0;
    }

    public String getAlertText() {
        String alertText = getAlert().getText();
        getAlert().accept();
        return alertText;
    }

    public void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void jsClickElement(WebElement element) {
        js.executeScript("arguments[0].click()", element);
    }

    public void scrollPage() {
        js.executeScript("window.scrollBy(0,600)");
    }


    public static String getRandomEmail() {
        return getRandomValue() + "@test.de";
    }

    public static String getRandomValue() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random random = new SecureRandom();
        char[] result = new char[6];
        for (int i = 0; i < result.length; i++) {
            int randomIndex = random.nextInt(chars.length);
            result[i] = chars[randomIndex];
        }
        return new String(result);
    }

    // Метод, который будет отключать рекламу и её блоки
    public void hideAds() {
        js.executeScript(
                "var hideAds = function() {" +
                        "document.getElementById('adplus-anchor').style.display='none';" +
                        "document.getElementById('fixedban').style.display='none';" +
                        "document.getElementById('Ad.Plus-300x250-1').style.display='none';" +
                        "document.getElementById('Ad.Plus-300x250-2').style.display='none';" +
                        "document.getElementById('Ad.Plus-970x250-1').style.display='none';" +
                        "document.getElementById('Ad.Plus-970x250-2').style.display='none';" +
                        "document.getElementById('RightSide_Advertisement').style.display='none';" +
                        "document.getElementById('mys-wrapper').style.display='none';" +
                        "document.getElementById('bnr').style.display='none';" +
                        "document.getElementById('banner').style.display='none';" +
                        "document.getElementById('bannerB').style.display='none';" +
                        "document.querySelectorAll('[class*=\"-bannerB\"], [class*=\"-banner\"], .ad-card').forEach(element => element.style.display = 'none');" +
                        "document.querySelectorAll('.ns-vwfjj-e-1.top-panel').forEach(element => element.style.display = 'none');" +
                        "document.querySelectorAll('.ns-jfama-l-bannerB.ns-jfama-v-0').forEach(element => element.style.display = 'none');" +
                        "document.querySelectorAll('.ns-jm633-l-bannerB.ns-jm633-v-0').forEach(element => element.style.display = 'none');" +
                        "document.querySelectorAll('.ad-container, .Google-Ad, .ad, .ads, .advert, .advertisement, .amp-animate, .i-amphtml-layout-container, .mys-wrapper, [class*=\"-banner\"]').forEach(element => element.style.display = 'none');" +
                        "document.querySelectorAll('#gwd-ad .gwd-page-container, #gwd-ad .gwd-page-wrapper, #gwd-ad .gwd-page-content, #gwd-ad .gwd-lightbox, #gwd-ad .gwd-play-animation, #gwd-ad .event-2-animation, #gwd-ad .gwd-gen-1igqgwdanimation, #gwd-ad .Logo_Start, #gwd-ad .Netto_Logo, #gwd-ad .gwd-gen-1rjsgwdanimation, #gwd-ad .gwd-gen-11gugwdanimation, #gwd-ad .gwd-gen-1pc9gwdanimation, #gwd-ad .gwd-gen-5a2ygwdanimation, #gwd-ad .gwd-gen-jn8rgwdanimation, #gwd-ad .gwd-gen-yllngwdanimation, #gwd-ad .gwd-gen-cc8ygwdanimation, #gwd-ad .gwd-gen-ixqigwdanimation, #gwd-ad .gwd-gen-krlngwdanimation, #gwd-ad .gwd-gen-11tigwdanimation, #gwd-ad .gwd-gen-1lq3gwdanimation, #gwd-ad .gwd-gen-1pc9gwdanimation').forEach(element => element.style.display = 'none');" +
                        "document.querySelectorAll('script[src*=\"googletagservices.com\"], script[src*=\"adsbygoogle.js\"]').forEach(element => element.remove());" +
                        "document.querySelectorAll('div[data-google-query-id]').forEach(element => element.style.display = 'none');" +
                        "document.querySelectorAll('.col-12.mt-4.col-md-6 > div:nth-child(1)').forEach(element => element.style.display = 'none');" +
                        "document.querySelectorAll('.col-12.mt-4.col-md-6 > div:nth-child(3)').forEach(element => element.style.display = 'none');" +
                        "document.querySelectorAll('.col-12.mt-4.col-md-6 > div:nth-child(1)').forEach(element => element.remove());" +
                        "document.querySelectorAll('.col-12.mt-4.col-md-6 > div:nth-child(3)').forEach(element => element.remove());" +
                        "};" +
                        "setInterval(hideAds, 0);"
        );
    }
}
