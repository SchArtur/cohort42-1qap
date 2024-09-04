package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import phonebook.core.AppManager;

public class BaseTest {

    //System.getProperty("browser", "chrome") - второе значение это по умолчанию если не передан параметр.
    AppManager app = new AppManager(System.getProperty("browser", "chrome"));
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
