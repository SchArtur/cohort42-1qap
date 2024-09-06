import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.*;

public class AddItemToCartTests extends BaseTest {
    @BeforeMethod
    void precondition() {
        if (loginHelper.isLogOutPresent()) {
            loginHelper.clickLogOutButton();
        }
    }
    @Test(description = "Успешное добавление второго товара из списка")
    void test3() {
        addItemToCartHelper.removeAllItemsFromCart();
        addItemToCartHelper.addSecondItemToCart();
        addItemToCartHelper.goToCart();
        Assert.assertNotEquals(addItemToCartHelper.getCountCart(), "0", "Ожидалось, что корзина будет содержать товар.");
    }

    @Test(description = "Проверка очистки корзины")
    void test4() {
        addItemToCartHelper.addSecondItemToCart();
        addItemToCartHelper.clearCart();
        Assert.assertEquals(addItemToCartHelper.getCountCart(), "0", "Ожидалось, что корзина будет пустой.");
    }

    @Test(description = "Проверка наличия товара в корзине")
    void test5() {
        addItemToCartHelper.clickAddToCartButton("product-name");
        addItemToCartHelper.goToCart();
        Assert.assertEquals(addItemToCartHelper.getProductNameInCart(), "product-name", "Ожидалось, что в корзине будет товар с указанным названием.");
    }
}


