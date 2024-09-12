import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.*;

public class AddItemToCartTests extends BaseTest {
    @BeforeMethod
    void precondition() {
        if (!loginHelper.isLogOutPresent()) {
            loginHelper.loginTestUser();
        }
        addItemToCartHelper.goToHomePage();
    }

    @Test(description = "Успешное добавление второго товара из списка")
    void test3() {
        addItemToCartHelper.removeAllItemsFromCart();
        addItemToCartHelper.goToHomePage();
        addItemToCartHelper.addSecondItemToCart();
        Assert.assertEquals(addItemToCartHelper.getCountCart(), 1, "Ожидалось, что корзина будет содержать товар.");
    }

    @Test(description = "Проверка очистки корзины")
    void test4() {
        addItemToCartHelper.addSecondItemToCart();
        addItemToCartHelper.clearCart();
        Assert.assertEquals(addItemToCartHelper.getCountCart(), 0, "Ожидалось, что корзина будет пустой.");
    }

    @Test(description = "Проверка наличия товара в корзине")
    void test5() {
        addItemToCartHelper.clickAddToCartButton("14.1-inch Laptop");
        addItemToCartHelper.goToCart();
        Assert.assertEquals(addItemToCartHelper.getProductNameInCart(), "14.1-inch Laptop", "Ожидалось, что в корзине будет товар с указанным названием.");
    }
}


