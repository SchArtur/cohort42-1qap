package phonebook.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import phonebook.core.BaseHelper;
import phonebook.data.Contact;

public class ContactPageHelper extends BaseHelper {

    @Step("Нажимаем на кнопку 'ADD'")
    public ContactPageHelper clickOnAddLink() {
        clickOnElement(By.cssSelector("[href='/add']"));
        return this;
    }

    @Step("Нажимаем на кнопку 'Save'")
    public ContactPageHelper clickOnSaveButton() {
        clickOnElement(By.xpath("//*[text()='Save']"));
        return this;
    }

    @Step("Нажимаем на кнопку 'CONTACTS'")
    public ContactPageHelper clickOnContactsLink() {
        clickOnElement(By.cssSelector("[href='/contacts']"));
        return this;
    }

    @Step("Нажимаем на кнопку 'Edit'")
    public ContactPageHelper clickOnEditButton() {
        clickOnElement(By.xpath("//*[text()='Edit']"));
        return this;
    }

    @Step("Получаем общее количество контактов")
    public int getContactSize() {
        return getElements(By.cssSelector("[class='contact-item_card__2SOIM']")).size();
    }

    @Step("Проверяем наличие контакта {0}")
    public boolean contactIsPresent(Contact contact) {
        String xPath = String.format("//*[text()='%s']", contact.getName());
        return elementIsDisplayed(By.xpath(xPath));
    }

    @Step("Заполняем данные контакта {0}")
    public ContactPageHelper fillContactFields(Contact contact) {
        fillInputField(By.cssSelector("[placeholder='Name']"), contact.getName());
        fillInputField(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        fillInputField(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        fillInputField(By.cssSelector("[placeholder='email']"), contact.getEmail());
        fillInputField(By.cssSelector("[placeholder='Address']"), contact.getAddress());
//        fillInputField(By.cssSelector("[placeholder='description']"), contact.getDescription());
        return this;
    }

    @Step("Удаляем контакт {0}")
    public ContactPageHelper removeContact(Contact contact) {
        clickOnContactsLink();
        clickOnContact(contact);
        clickOnElement(By.xpath("//*[text()='Remove']"));
        waitInSeconds(1);
        return this;
    }

    @Step("Удаляем контакт {0}")
    public ContactPageHelper clickOnContact(Contact contact) {
        clickOnElement(By.xpath(String.format("//*[text()='%s']", contact.getName())));
        return this;
    }

    @Step("Создаем контакт")
    public Contact addContact() {
        Contact contact = getNewContact();
        clickOnContactsLink();
        clickOnAddLink();
        fillContactFields(contact);
        clickOnSaveButton();
        waitInSeconds(2);
        return contact;
    }


}
