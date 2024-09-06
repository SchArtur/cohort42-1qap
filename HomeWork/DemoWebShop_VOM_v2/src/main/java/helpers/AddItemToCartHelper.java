package helpers;

import core.BaseHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddItemToCartHelper extends BaseHelper {

    @Step("Получаем количество товаров в корзине")
    public String getCountCart() {
       return getElement(By.className("cart-qty")).getText().replace("(", "").replace(")", "");
    }

    @Step("Очищаем корзину")
    public AddItemToCartHelper clearCart() {
        clickOnElement(By.xpath("//*[text()='Shopping cart']"));
        List<WebElement> removeCheckboxes = getElements(By.name("removefromcart"));
        clickOnElement(By.name("updatecart"));
        waitInSeconds(2);
        return this;
    }

    @Step("Добавляем второй товар из списка в корзину")
    public AddItemToCartHelper addSecondItemToCart() {
        List<WebElement> productTitles = getElements(By.xpath("//h2[@class='product-title']/a"));

        List<WebElement> addToCartButtons = getElements(By.cssSelector("[value='Add to cart']"));
        waitInSeconds(2);
        return this;
    }

    @Step("Получаем название товара в корзине")
    public String getProductNameInCart() {
        clickOnElement(By.cssSelector("[href='/cart']"));
        return getElement(By.className("product-name")).getText();
    }

    @Step("Нажимаем на кнопку 'Добавить в корзину' для товара {0}")
    public AddItemToCartHelper clickAddToCartButton(String productName) {
        WebElement productButton = getElement(By.xpath(String.format("//*[text()='%s']//following::input[@value='Add to cart']", productName)));
        productButton.click();
        waitInSeconds(2);
        return this;
    }

    @Step("Переходим в корзину")
    public AddItemToCartHelper goToCart() {
        clickOnElement(By.cssSelector("[href='/cart']"));
        return this;
    }

    @Step("Проверяем наличие товара {0} в корзине")
    public boolean isProductInCart(String productName) {
        return elementIsDisplayed(By.xpath(String.format("//*[text()='%s']", productName)));
    }

    @Step("Удаляем все товары из корзины")
    public AddItemToCartHelper removeAllItemsFromCart() {
        clearCart();
        return this;
    }

}




