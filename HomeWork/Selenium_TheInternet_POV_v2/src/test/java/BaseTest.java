import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import theIntertet.core.AppManager;

public class BaseTest {
    static AppManager app = new AppManager(System.getProperty("browser", "chrome"));
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    @BeforeAll
    static void setUp() {
        LOG.info("======================================================");
        LOG.info("******************* Запуск тестов *******************");
        app.init();
    }

    @AfterAll
    static void tearDown() {
        LOG.info("******************* Тесты завершены *******************");
        LOG.info("======================================================");
        app.stop();
    }
}
