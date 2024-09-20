import core.AppManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    static AppManager app = new AppManager();

    @BeforeAll
    static void setUp() {
        app.init();
    }

    @AfterAll
    static void tearDown() {
        app.stop();
    }
}

