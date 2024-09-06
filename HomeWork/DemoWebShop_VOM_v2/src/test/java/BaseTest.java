import core.AppManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    AppManager app = new AppManager();

    @BeforeSuite
    void setApp() {
        app.init();
    }

    @AfterSuite
    void tearDown() {
        app.stop();
    }
}
