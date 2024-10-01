import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;

import static core.AppManager.homePages;

public class DropdownTest extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePages.dropdownMenuLink.click();
    }

    @Test
    public void dropDownListTest(){
        new DropdownPage().selectDropdownList ("Option 1");
    }
}
