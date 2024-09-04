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

    }

    @Test
    @Tag("03")
    @DisplayName("Успешное добавление второго товара из списка")
    void test3() {

        String countItemsBeforeElement = driver.findElement(By.cssSelector("[class='cart-qty']")).getText();
        String cellStr = countItemsBeforeElement.replace("(", "").replace(")", "");
        int countItems = Integer.parseInt(cellStr);
        System.out.println("Количество товаров до добавления: " + countItems);


        clickOnElement(By.cssSelector("[href='/141-inch-laptop'],[src='https://demowebshop.tricentis.com/content/images/thumbs/0000224_141-inch-laptop_32.png']"));
        clickOnElement(By.cssSelector("[id='add-to-cart-button-31']"));
        clickOnElement(By.cssSelector("[href='/cart']"));


        String countItemsAfterElement = driver.findElement(By.cssSelector("[class='cart-qty']")).getText();
        String cellStr1 = countItemsAfterElement.replace("(", "").replace(")", "");
        int countItems1 = Integer.parseInt(cellStr1);
        System.out.println("Количество товаров после добавления: " + countItems1);


        if (countItems1 == countItems + 1) {
            System.out.println("Товар успешно добавлен в корзину.");
        } else {
            System.out.println("Ошибка при добавлении товара в корзину.");
        }
    }
}
