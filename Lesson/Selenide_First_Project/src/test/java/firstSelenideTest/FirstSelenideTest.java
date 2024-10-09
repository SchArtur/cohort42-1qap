package firstSelenideTest;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import sconto.core.ProjectProperties;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FirstSelenideTest {

    @Test
    void test1() {
//        Выбор конкретного браузера доступен разными способами
//        Configuration.browser = "chrome";
//        Configuration.browser = "firefox";

//       таким образом происходит чтение параметров
        String url = ProjectProperties.getInstance().getProperty("bing.url");

        //открываем браузер и переходим на страницу
        open(url);
        //через getWebDriver можно обратиться к драйверу
        getWebDriver().manage().window().maximize();

        //мы работаем с элементами теперь как с SelenideElement, с дополнительными методами
        SelenideElement searchString = $("#sb_form_q");

        //проверяем, что элемент видимый. Но ждёт 4 секунды
        searchString.shouldBe(visible);
//        можно задать своё время ожидания (10 секунд)
        searchString.shouldBe(visible, Duration.ofSeconds(10));

//       проверка, что элемент не существует, или пропадёт (так же ожидает 4 секуды)
//        $("#sb_form_q").shouldBe(Condition.disappear);
//
//        searchString
//                .shouldBe(visible)
//                .shouldHave(text("Hallo"), text("Test"));

//        получаем строку поиска и заполняем значением selenide и нажимаем энтэр
        $("#sb_form_q")
                .val("selenide")
                .pressEnter();
//        проверяем что поисковая выдача (Коллекция) содержит 10 ссылок
        $$(".tilk .b_attribution")
                .shouldHave(size(10))
                .filter(visible)
                .shouldHave(texts("Seleide", "практикум"));
    }


}
