package lesson.demo;

import lesson.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DemoShopTests extends BaseTest {

    @BeforeEach
    void preconditions() {
        driver.get("https://demowebshop.tricentis.com/");
        login();
        waitInSeconds(1);
        if (getCartCount() != 0) {
            clearCart();
        }
    }

    @Test
    void test1() {
        int startCount = getCartCount();
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("[value='Add to cart']"));
        addToCartButtons.get(1).click();
        waitInSeconds(1);
        int endCount = getCartCount();
        Assertions.assertEquals(startCount + 1, endCount, "Товар не добавился");
//        Assertions.assertEquals(какое значение ожидаем, какое значение пришло, сообщение об ошибке)
    }

    @Test
    void test2() throws Exception {
        List<WebElement> productTitles = driver.findElements(By.xpath("//h2[@class='product-title']/a"));
        String productNameExpected = productTitles.get(1).getText();
        //*[@class='product-item']/descendant::input
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("[value='Add to cart']"));

        addToCartButtons.get(1).click();
        waitInSeconds(1);

        clickOnElement(By.cssSelector("[href='/cart']"));
        String productNameActual = getElement(By.className("product-name")).getText();

        Assertions.assertEquals(productNameExpected, productNameActual, "Добавился не тот товар");
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

    private int getCartCount() {
        WebElement countElement = getElement(By.className("cart-qty"));
        return Integer.parseInt(countElement.getText().replaceAll("\\D", ""));
    }

    private void login() {
        clickOnElement(By.cssSelector("[href='/login']"));
        fillInputField(By.xpath("//*[@name='Email']"), "artsch@test.com");
        fillInputField(By.xpath("//*[@name='Password']"), "QazwsX123");
        clickOnElement(By.cssSelector("[value='Log in']"));
    }
}
