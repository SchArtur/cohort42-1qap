import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static theIntertet.core.AppManager.*;

public class HoversTest extends BaseTest{

    @BeforeAll
    static void getAlertsPage() {
        homePage.hoversLink.click();
    }

    @Test
    void Test1() {
        Actions actions = new Actions(driver);
        actions.moveToElement(hoversPage.figureClass).click();

        String userText = hoversPage.figcaptionClass.getText();

        assertFalse(userText.isEmpty(), "Подпись не отображается");
    }

}
