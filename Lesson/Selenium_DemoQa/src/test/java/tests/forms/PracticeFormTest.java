package tests.forms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import tests.BaseTest;

import static core.Init.*;

public class PracticeFormTest extends BaseTest {

    @BeforeAll
    static void getAlertsPage() {
        homePage.formsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!browserWindowsPage.titleTextCenterIsDisplayed() || !browserWindowsPage.getTitleTextCenter().equals("Frames")) {
            leftPanel.practiceFormButton.click();
        }
    }

    @Test
    void test() {
        practiceFormPage.dateOfBirthInput.click();
        practiceFormPage.dateOfBirthInput.sendKeys(Keys.COMMAND + "a");
        practiceFormPage.dateOfBirthInput.sendKeys("10 Sep 2000");
        practiceFormPage.dateOfBirthInput.sendKeys(Keys.ENTER);
        practiceFormPage.dateOfBirthInput.click();
    }
}
