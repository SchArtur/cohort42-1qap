package tests;

import core.Init;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static core.Init.homePage;

public class BaseTest {

    private static Init init = new Init();

    @BeforeAll
    static void setUp() {
        init.init();
        homePage.hideAds();
    }

    @AfterAll
    static void tearDown() {
        init.stop();
    }
}
