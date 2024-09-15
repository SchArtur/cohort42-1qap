package tests;

import core.AppManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

import static core.BaseHelper.takeScreenshot;
import static core.BaseHelper.takeScreenshotPath;

public class BaseTest {
    AppManager app = new AppManager(System.getProperty("browser", "chrome"));
    SoftAssert softAssert = new SoftAssert();

    // Используем SLF4J Logger напрямую, без приведения типов
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite
    void setApp() {
        LOG.info("============ Start test =============");
        app.init();
    }

    @AfterSuite
    void tearDown() {
        LOG.info("============= Stop test ===============");
        app.stop();
    }
    @BeforeMethod
    void startTest(Method method){
        LOG.info("Test is started: {}",method.getName());
    }@AfterMethod
    void stopTest(ITestResult result){
        if (result.isSuccess()) {
            LOG.info("Test '{}' - PASSED", result.getMethod().getDescription());
        }else {
            LOG.info("Test '{}' - FAILED",result.getMethod().getDescription());
            takeScreenshot();
            takeScreenshotPath();
        }
        LOG.info("===========================");
    }
}

