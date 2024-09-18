import core.AppManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    static AppManager app = new AppManager(System.getProperty("browser", "chrome"));
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    @BeforeAll
    static void setApp() {
        LOG.info("============ Start test =============");
        app.init();
    }

    @AfterAll
    static void tearDown() {
        LOG.info("============= Stop test ===============");
        app.stop();
    }
}

