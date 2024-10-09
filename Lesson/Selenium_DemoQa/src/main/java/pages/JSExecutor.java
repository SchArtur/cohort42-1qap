package pages;

import core.Init;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class JSExecutor {

    protected WebDriver driver;
    protected JavascriptExecutor js;

    public JSExecutor() {
        this.driver = Init.driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void jsClickElement(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollPage() {
        js.executeScript("window.scrollBy(0,600);");
    }

    public void fillFormJS(WebElement element, String value) {
        js.executeScript("arguments[0].value=arguments[1];", element, value);
    }

    //    Обновление страницы
    public void refreshWithJS() {
        js.executeScript("history.go(0);");
    }

    //Получение адреса странички
    public String getUrlFromJS() {
        return js.executeScript("return document.URL;").toString();
    }

    //переход на страничку
    public void goToUrlJs(String url) {
        js.executeScript("window.location=arguments[0];", url);
    }

    // Получаем заголовок страницы
    public String getTitleJs() {
        return js.executeScript("return document.title").toString();
    }

    // Получаем заголовок страницы
    public void generateAlertJS(String text) {
        js.executeScript("alert(arguments[0]);", text);
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
