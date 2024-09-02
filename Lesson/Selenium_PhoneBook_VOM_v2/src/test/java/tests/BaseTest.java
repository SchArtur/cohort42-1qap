package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import phonebook.core.AppManager;

public class BaseTest {

    AppManager app = new AppManager();
    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    void setUp() {
        app.init();
    }

    @AfterSuite
    void tearDown() {
        app.stop();
    }
}
