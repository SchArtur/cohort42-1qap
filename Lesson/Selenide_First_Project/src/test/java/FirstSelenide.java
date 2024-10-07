import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class FirstSelenide {


    @Test
    void test1() {
        //открываем браузер и переходим на страницу
        open("https://www.bing.com/");
//        получаем строку поиска и заполняем значением selenide и нажимаем энтэр
        $("#sb_form_q")
                .val("selenide")
                .pressEnter();

//        проверяем что поисковая выдача содержит 10 ссылок
        $$(".tilk .b_attribution").shouldHave(size(10));
    }
}
