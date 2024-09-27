import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static core.AppManager.*;

public class MultipleWindowsTest extends BaseTest {
   @BeforeAll
    static void getAlertsPage(){
       homePages.multipleWindowsLink.click();
   }
   @Test
    void test(){
       multipleWindowsPages.newWindowsLink.click();
       multipleWindowsPages.switchToWindow(1);
       Assertions.assertEquals("New Window",multipleWindowsPages.browserWindowsText.getText(),"Текст не соответствует ожидаемому");
       driver.close();
       multipleWindowsPages.switchToWindow(0);
       Assertions.assertTrue(driver.getTitle().contains("The Internet"),"Не удалось переключится обратно на исходное окно");
   }
}
