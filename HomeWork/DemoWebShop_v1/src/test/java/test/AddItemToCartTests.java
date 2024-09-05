package test;

import core.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class AddItemToCartTests extends BaseTest {
    @BeforeEach
    void precondition() {
        loginTestUser();
        waitInSeconds(1);
        if (getCountCart() != 0) {
            clearCart();
        }
    }
    @Test
    @Tag("03")
    @DisplayName("Успешное добавление второго товара из списка")
    void test3() throws Exception {
        List<WebElement> productTitles = driver.findElements(By.xpath("//h2[@class='product-title']/a"));
        String productNameExpected = productTitles.get(1).getText();

        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("[value='Add to cart']"));
        addToCartButtons.get(1).click();
        waitInSeconds(2);

        clickOnElement(By.cssSelector("[href='/cart']"));
        String productNameActual = getElement(By.className("product-name")).getText();

        Assertions.assertEquals(productNameExpected, productNameActual, "Добавился не тот товар");
    }
    public int getCountCart() {
        WebElement countElement = getElement(By.className("cart-qty"));
        return Integer.parseInt(countElement.getText().replace("(", "").replace(")", ""));
    }
    private void clearCart() {
        clickOnElement(By.xpath("//*[text()='Shopping cart']"));
        List<WebElement> removeCheckboxes = driver.findElements(By.name("removefromcart"));
        for (WebElement checkbox : removeCheckboxes) {
            checkbox.click();
        }
        clickOnElement(By.name("updatecart"));
        waitInSeconds(1);
        driver.get("https://demowebshop.tricentis.com/");
    }
}
