package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import phonebook.utils.DataProviders;
import phonebook.data.Contact;

import static phonebook.core.AppManager.*;
import static phonebook.core.BaseHelper.getNewContact;

public class ContactPageTests extends BaseTest {

    @BeforeMethod
    void precondition() {
        if (loginPageHelper.isLoginLinkPresent()) {
            loginPageHelper.loginTestUser();
        }
        contactPageHelper.clickOnContactsLink();
    }

    @Test(description = "Проверка добавления контакта с валидными данными, вариант 1")
    void test6() {
        contactPageHelper
                .clickOnAddLink()
                .fillContactFields(TEST_CONTACT)
                .clickOnSaveButton();

        Assert.assertTrue(contactPageHelper.contactIsPresent(TEST_CONTACT));
//        contactPageHelper.removeContact(TEST_CONTACT);
    }

    @Test(description = "Проверка добавления контакта с валидными данными, вариант 2")
    void test7() {
        contactPageHelper.clickOnAddLink();
        contactPageHelper.fillContactFields(TEST_CONTACT);
        contactPageHelper.clickOnSaveButton();

        Assert.assertTrue(contactPageHelper.contactIsPresent(TEST_CONTACT));
//        contactPageHelper.removeContact(TEST_CONTACT);
    }

    @Test(description = "Проверка добавления контакта с не валидными данными", groups = {"Negative"}, dataProvider = "getContactsFromCsvFile", dataProviderClass = DataProviders.class)
    void test8(Contact contact, String alert) {
        contactPageHelper.clickOnAddLink();
        contactPageHelper.fillContactFields(contact);
        contactPageHelper.clickOnSaveButton();
        if (alert.equals("alert")) {
            contactPageHelper.getAlert().accept();
        }
        Assert.assertTrue(!contactPageHelper.getCurrentUrl().equals("https://telranedu.web.app/contacts"));
    }

    @Test(description = "Проверка удаления контакта")
    void test9() {
        Contact deleteContact = contactPageHelper.addContact();
        int contactSizeStart = contactPageHelper.getContactSize();
        contactPageHelper.removeContact(deleteContact);
        int contactSizeEnd = contactPageHelper.getContactSize();

        Assert.assertFalse(contactPageHelper.contactIsPresent(deleteContact), "Контакт не удалён");
        Assert.assertEquals(contactSizeStart - 1, contactSizeEnd, "Количество контактов не изменилось");
    }

    @Test(description = "Проверка редактирования  контакта")
    void test10() {
        Contact oldContact = contactPageHelper.addContact();
        contactPageHelper.clickOnContact(oldContact);
        contactPageHelper.clickOnEditButton();
        Contact editContact = getNewContact();
        contactPageHelper.fillContactFields(editContact);
        contactPageHelper.clickOnSaveButton();
        contactPageHelper.waitInSeconds(2);
        Assert.assertTrue(contactPageHelper.contactIsPresent(editContact), "Не найден контакт с именем - " + editContact.getName());
        Assert.assertFalse(contactPageHelper.contactIsPresent(oldContact), "Найден не измененный контакт");
        contactPageHelper.removeContact(editContact);
    }
}
