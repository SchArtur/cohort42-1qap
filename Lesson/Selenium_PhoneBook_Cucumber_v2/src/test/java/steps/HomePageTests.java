//package steps;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static phonebook.core.AppManager.homePage;
//
//@Tag("@ALL")
//@Tag("@HOME")
//@Tag("@SMOKE")
//public class HomePageTests extends BaseSteps {
//
//    @Test
//    @Tag("@1")
//    @DisplayName("Проверка страницы Home")
//    void test1() {
//        homePage.clickHomeLink();
//        Assertions.assertAll(
//                () -> assertTrue(homePage.isHomeComponentPresent(), "Не отображается 'Home Component'"),
//                () -> assertTrue(homePage.isReactAppPresent(), "Не отображается 'React App'"),
//                () -> assertTrue(homePage.isForQaPresent(), "Не отображается 'For QA'")
//        );
//    }
//}
