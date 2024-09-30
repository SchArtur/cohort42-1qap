package tests.forms;

import org.junit.jupiter.api.*;
import tests.BaseTest;

import java.io.File;

import static core.Init.*;

@Tag("@ALL")
@Tag("@SMOKE")
@Tag("@PRACTICE_FORM")
public class PracticeFormTest extends BaseTest {

    @BeforeAll
    static void getAlertsPage() {
        homePage.formsCard.click();
    }

    @BeforeEach
    void preconditions() {
        if (!practiceFormPage.titleTextCenterIsDisplayed() || !practiceFormPage.getTitleTextCenter().equals("Practice Form")) {
            leftPanel.practiceFormButton.click();
        }
    }

    @Test
    void test() {
        practiceFormPage
                .fillPersonalData("TestName", "TestSurname", "TestMail@gmail.com", "1234567890", "Test address 21")
                .selectGender("Other")
//                .selectBirthDay("20 Sep 2005")
                .selectBirthDay("15", "April", "2020")
                .enterSubjects("Maths", "Computer Science")
                .selectHobbies(new String[]{"Sports", "Music"})
                .uploadFile(new File("src/test/resources/img.png").getAbsolutePath())
                .scrollPage();
        practiceFormPage.fillStateAndCity("Uttar", "Luck")
                .submit.click();
        practiceFormPage.waitInSeconds(2);
        Assertions.assertEquals("Thanks for submitting the form", practiceFormPage.modal.getText());
    }
}
