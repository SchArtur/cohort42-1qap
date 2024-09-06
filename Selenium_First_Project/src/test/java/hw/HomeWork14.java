package hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomeWork14 extends MyBaseTest {
    @Test
    @DisplayName("Проверка регистрации с валидными данными")
    public void testByXPath() {
        WebElement findLoginField = driver.findElement(By.cssSelector(".ico-login"));
        Assertions.assertTrue(findLoginField.isDisplayed(), " Login button was not found");

        findLoginField.click();

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current is " + currentUrl);

        WebElement findRegisterbutton = driver.findElement(By.xpath("//*[@class='button-1 register-button']"));
        Assertions.assertTrue(findRegisterbutton.isDisplayed(), "The Register btn is not displayed");
        findRegisterbutton.click();

        fillInputField(By.xpath("//*[@name='FirstName']"),"Aser");
        fillInputField(By.xpath("//*[@name='LastName']"),"Lenovo");
        fillInputField(By.xpath("//*[@name='Email']"),"olduser@tele.com");
        fillInputField(By.xpath("//*[@name='Password']"),"123456789");
        fillInputField(By.xpath("//*[@name='ConfirmPassword']"),"123456789");

        clickOnElement(By.xpath("//*[@id='register-button']"));

        WebElement findContinueButton = driver.findElement(By.xpath("//*[@class='button-1 register-continue-button']"));
        Assertions.assertTrue(findContinueButton.isDisplayed(), "The Continue btn is missing");

        findContinueButton.click();

        WebElement findLogOutButton = driver.findElement(By.xpath("//*[@href='/logout']"));
        Assertions.assertEquals("Log out",findLogOutButton.getText(),"The button Log out is missing");








    }
}
