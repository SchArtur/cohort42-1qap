import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.ExitIntentPage;

import static core.AppManager.homePages;

public class ExitIntentTest extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
      homePages.exitIntentLink.click();
    }

    @Test
    void test1(){
        new ExitIntentPage().exitViewport().verifyCloseButtonIsNotVisible();
    }
}
