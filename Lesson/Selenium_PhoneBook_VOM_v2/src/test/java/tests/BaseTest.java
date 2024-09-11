package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import phonebook.core.AppManager;

import java.lang.reflect.Method;

import static phonebook.core.BaseHelper.takeScreenshot;

public class BaseTest {

    //System.getProperty("browser", "chrome") - второе значение это по умолчанию если не передан параметр.
    AppManager app = new AppManager(System.getProperty("browser", "chrome"));
    SoftAssert softAssert = new SoftAssert();
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite
    void setUp() {
        LOG.info("======================================================");
        LOG.info("******************* Запуск тестов *******************");
        app.init();
    }

    @AfterSuite
    void tearDown() {
        LOG.info("******************* Тесты завершены *******************");
        LOG.info("======================================================");
        app.stop();
    }

    @BeforeMethod
    void startTest(Method method) {
        LOG.info("Test is started: {}", method.getName());
    }

    @AfterMethod
    void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            LOG.info("Test '{}' - '{}' - PASSED", result.getMethod().getMethodName(), result.getMethod().getDescription());
        } else {
            LOG.info("Test '{}' - '{}' - FAILED", result.getMethod().getMethodName(), result.getMethod().getDescription());
            takeScreenshot();
//            takeScreenshotPath();
        }
        LOG.info("======================================================");
    }

}
