package steps;//package steps;


import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import phonebook.model.Contact;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static phonebook.core.AppManager.*;
import static phonebook.core.BasePage.getNewContact;
import static phonebook.core.BasePage.waitInSeconds;

public class ContactPageSteps {

    public static Contact newContact;

    @Когда("заполняем данные {contact} контакт(а), для добавления в записную книжку")
    public void fillAddContactForm(Contact contact) {
        contactPage.fillContactFields(contact);
    }

    @Тогда("нажимаем кнопку 'Save'")
    public void clickSave() {
        contactPage.clickOnSaveButton();
    }

    @Тогда("нажимаем кнопку 'Edit'")
    public void clickEdit() {
        contactPage.clickOnEditButton();
    }


    @Тогда("создаем новый объект Contact")
    public void createNewContact() {
        newContact = getNewContact();
    }

    @Когда("удаляем {contact} контакт")
    public void deleteContact(Contact contact) {
        contactPage.removeContact(contact);
    }


    @Когда("открываем карточку контакта - {contact}")
    public void openContactCard(Contact contact) {
        contactPage.clickOnContact(contact);
    }

    @Тогда("редактируем поля контакта - {contact}")
    public void editContactFields(Contact contact, Map<String, String> userFields) {
        for (Map.Entry<String, String> contactFieldAndValue : userFields.entrySet()) {
            switch (contactFieldAndValue.getKey()) {
                case "name" -> contactPage.fillInputField(contactPage.nameField, contactFieldAndValue.getValue());
                case "email" -> contactPage.fillInputField(contactPage.emailField, contactFieldAndValue.getValue());
                case "lastName" -> contactPage.fillInputField(contactPage.lastNameField, contactFieldAndValue.getValue());
                case "phone" -> contactPage.fillInputField(contactPage.phoneField, contactFieldAndValue.getValue());
                case "address" -> contactPage.fillInputField(contactPage.addressField, contactFieldAndValue.getValue());
            }
        }
    }

    @Тогда("проверяем наличие контакта - {contact}")
    public void contactIsPresent(Contact contact) {
        assertTrue(contactPage.contactIsPresent(contact), "Контакт не найден");
    }

    @Тогда("проверяем наличие контакта по имени - {string}")
    public void contactIsPresent(String name) {
        assertTrue(contactPage.contactIsPresent(name), "Контакт не найден");
    }

    @Тогда("проверяем отсутствие контакта - {contact}")
    public void contactNotPresent(Contact contact) {
        assertFalse(contactPage.contactIsPresent(contact), "Контакт найден");
    }

    @ParameterType("TEST|NEW")
    public Contact contact(String contactType) {
        if (contactType.equals("TEST_CONTACT")) {
            return TEST_CONTACT;
        }
        return newContact;
    }

    @Before("@BeforeAddContact")
    public void addContact() {
        createNewContact();
        if (navigationPanel.isSignOutPresent()) {
            navigationPanel.clickOnSignOutButton();
        }
        navigationPanel.clickOnLoginLink();
        loginPage.loginTestUser();
        navigationPanel.addLink.click();
        fillAddContactForm(newContact);
        clickSave();
        waitInSeconds(2);

    }
}
