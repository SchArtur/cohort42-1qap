package lesson.herokuapp;

import lesson.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JQueryUI extends BaseTest {

    @BeforeEach
    void preconditions() {
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");
    }


    @Test
    void test1() {
        System.out.println("EX");

        WebElement enabledElement = driver.findElement(By.id("ui-id-3"));
        enabledElement.click();
        driver.findElement(By.xpath("//*[text() = 'Downloads']")).click();
        driver.findElement(By.xpath("//*[text() = 'CSV']")).click();

        new Actions(driver).moveToElement(enabledElement).pause(300).moveByOffset( 200, 0).pause(300).moveByOffset(150,50).pause(300).click().perform();
    }
}
