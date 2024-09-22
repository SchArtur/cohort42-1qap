import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static core.AppManager.homePages;
import static core.AppManager.horizontalSliderPages;

public class HorizontalSliderTests extends BaseTest {
    @BeforeAll
    static void getAlertsPage() {
        homePages.horizontalSliderLink.click();
    }

    @Test
    public void testMoveSlider() {
        horizontalSliderPages.moveSlider(2.5);
        String sliderValueText = horizontalSliderPages.sliderValue.getText();
        Assertions.assertEquals("2.5", sliderValueText);
    }

    @Test
    public void testMoveSliderToMax() {
        horizontalSliderPages.moveSlider(5);
        String sliderValueText = horizontalSliderPages.sliderValue.getText();
        Assertions.assertEquals("5", sliderValueText); // Замените 5 на максимальное значение
    }

    @Test
    public void testMoveSliderToMin() {
        horizontalSliderPages.moveSlider(0);
        String sliderValueText = horizontalSliderPages.sliderValue.getText();
        Assertions.assertEquals("0", sliderValueText); // Проверка на минимальное значение
    }
}
