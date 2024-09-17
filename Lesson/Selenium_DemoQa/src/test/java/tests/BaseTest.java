package tests;

import core.Init;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    private static Init init = new Init();

    @BeforeAll
    static void setUp() {
        init.init();
    }

    @AfterAll
    static void tearDown() {
        init.stop();
    }
}
