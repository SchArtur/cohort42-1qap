package lesson;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.crypto.Mac;
import java.time.Duration;

public class FirstSeleniumTests extends BaseTest {

    @Test
    void test1() {
        // Открываем страницу Bing
        driver.get("https://www.bing.com/");
        // Переходим на предыдущую страницу в истории навигации
        driver.navigate().back();
        // Переходим на следующую страницу в истории навигации
        driver.navigate().forward();
        // Обновляем текущую страницу
        driver.navigate().refresh();

        // Проверяем, что заголовок текущей страницы равен "Bing"
        Assertions.assertEquals("Bing", driver.getTitle(), "Открыта страница с другим Title");
    }

    @Test
    void test2() {
        // Открываем страницу Google
        driver.navigate().to("https://www.google.com/");
        // Переходим на предыдущую страницу в истории навигации
        driver.navigate().back();
        // Переходим на следующую страницу в истории навигации
        driver.navigate().forward();
        // Обновляем текущую страницу
        driver.navigate().refresh();

        // Проверяем, что заголовок текущей страницы равен "Google"
        Assertions.assertEquals("Google", driver.getTitle(), "Открыта страница с другим Title");
    }
}

//Эти горячие клавиши помогут вам эффективно работать с кодом Mac:
//        •	Cmd+Opt+L: Выравнивание кода.
//        •	Ctrl+Opt+O: Удаление неиспользуемых импортов.
//	      •	Cmd+D: Дублирование строки.
//        •	Cmd+/: Комментирование и раскомментирование строк.
//        •	Cmd+Shift+U: Изменение регистра переменной.