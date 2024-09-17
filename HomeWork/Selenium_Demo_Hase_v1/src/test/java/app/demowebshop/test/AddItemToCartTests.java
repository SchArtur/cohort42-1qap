package app.demowebshop.test;

import app.demowebshop.core.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddItemToCartTests extends BaseTest {

    @BeforeEach
    void precondition() {
        loginTestUser();
    }

    @Test
    @Tag("@3")
    @DisplayName("Выбор второго контакты на главной странице")
    void test3() {

        String countBeforeElm = driver.findElement(By.className("cart-qty")).getText();
        String cellStr = countBeforeElm.replace("(", "").replace(")", "");
        int countBeforeEl1 = Integer.parseInt(cellStr);
        //  System.out.println(countBeforeEl1);

        List<WebElement> products = driver.findElements(By.className("product-item"));
        products.get(1).findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button")).click();
        waitInSeconds(3);

        String countAfterElm = driver.findElement(By.className("cart-qty")).getText();
        String endStr1 = countAfterElm.replace("(", "").replace(")", "");
        int countAfterElm1 = Integer.parseInt(endStr1);
        //  System.out.println(countAfterElm1);

        Assertions.assertEquals( countBeforeEl1+1, countAfterElm1,"Продукт не добавился.");
    }
}
