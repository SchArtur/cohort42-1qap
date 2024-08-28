package lesson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class XpathTests extends BaseTest {

    /*
    1) * - выбрать любой элемент (имеется ввиду тэг)
    2) [] - индекс, либо атрибуты
    3) / - переход от корневого тэга
    4) // - переход к тэгу по всему документу (поиск)
    5) . - указание на текущий тэг
    6) .. - родительский тэг
    7) @ - указание конкретного атрибута

    Методы:
    text() -  возвращает текст элемента //*[text()='HOME']
    contains() - проверяет содержит ли элемент конкретный текст//*[contains(text(),'HOME')]
    count() - возвращает количество элементов
     */

    @Test
    @DisplayName("Проверка авторизации с валидными данными")
    void test1() {
        //Заполняем поле ввода email
        fillInputField(By.xpath("//*[@name='email']"), "manuel@gm.com");
        //Заполняем поле ввода password
        fillInputField(By.xpath("//*[@name='password']"), "Manuel1234$");
        //Нажимаем кнопку Login
        clickOnElement(By.xpath("//*[text()='Login']"));
        //Проверяем отображение элемента
        checkElementOnDisplay(By.xpath("//*[@href='/contacts']"));
    }

    @Test
//    @Disabled
    @DisplayName("Проверка регистрация с валидными данными")
    void test2() {
        //Заполняем поле ввода email
        fillInputField(By.xpath("//*[@name='email']"), "manuelll@gm.com");
        //Заполняем поле ввода password
        fillInputField(By.xpath("//*[@name='password']"), "Manuel1234$");
        //Нажимаем кнопку Login
        clickOnElement(By.xpath("//*[text()='Registration']"));
        //Проверяем отображение элемента
        checkElementOnDisplay(By.xpath("//*[@href='/contacts']"));
    }
}
