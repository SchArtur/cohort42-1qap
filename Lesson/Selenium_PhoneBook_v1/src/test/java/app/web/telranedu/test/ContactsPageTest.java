package app.web.telranedu.test;

import app.web.telranedu.core.BaseTest;
import app.web.telranedu.data.Contact;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsPageTest extends BaseTest {

    @BeforeEach
    void precondition() {
        loginTestUser();
    }

    @Test
    @Tag("@4")
    @DisplayName("Успешное добавление контакта")
    void test4() {
            waitInSeconds(1);
            int startSizeContacts = getElements(By.cssSelector("[class='contact-item_card__2SOIM']")).size();
            clickOnElement(By.cssSelector("[href='/add']"));
            fillAddContactFields();
            clickOnElement(By.xpath("//*[text()='Save']"));
            waitInSeconds(2);
        // 1 вариант, считать количество до добавления, и после добавления, итог до + 1 = после
        int endSizeContacts = getElements(By.cssSelector("[class='contact-item_card__2SOIM']")).size();
        Assertions.assertTrue(startSizeContacts + 1 == endSizeContacts,"Контакт не добавился. Проверка 1");

        // 2й делать каждый раз уникального и проверять наличие этого уникального
        String xPath = String.format("//*[text()='%s']", TEST_CONTACT.getName());
        Assertions.assertTrue(elementIsDisplayed(By.xpath(xPath)),"Контакт не добавился. Проверка 2");
        // 3й удалять свой контакт после добавления.
        removeContact(TEST_CONTACT);
    }

    private void fillAddContactFields() {
        fillInputField(By.cssSelector("[placeholder='Name']"), TEST_CONTACT.getName());
        fillInputField(By.cssSelector("[placeholder='Last Name']"), TEST_CONTACT.getLastName());
        fillInputField(By.cssSelector("[placeholder='Phone']"), TEST_CONTACT.getPhone());
        fillInputField(By.cssSelector("[placeholder='email']"), TEST_CONTACT.getEmail());
        fillInputField(By.cssSelector("[placeholder='Address']"), TEST_CONTACT.getAddress());
        fillInputField(By.cssSelector("[placeholder='description']"), TEST_CONTACT.getDescription());
    }

    private void removeContact(Contact contact) {
        clickOnElement(By.xpath(String.format("//*[text()='%s']", contact.getName())));
        clickOnElement(By.xpath("//*[text()='Remove']"));
        waitInSeconds(1);
    }
}
