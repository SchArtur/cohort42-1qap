package lesson.demo;

import lesson.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DemoShopTests extends BaseTest {

    @BeforeEach
    void preconditions() {
        driver.get("https://demowebshop.tricentis.com/");
    }

    //
    @Test
    @Disabled
    void test1() {
        List<WebElement> products = driver.findElements(By.className("product-item"));
        System.out.println(products.get(1).findElement(By.xpath("//h2[@class='product-title']/a")).getText());

    }
}
