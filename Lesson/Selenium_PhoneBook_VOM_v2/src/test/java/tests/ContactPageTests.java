package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import phonebook.core.DataProviders;
import phonebook.data.Contact;

import static phonebook.core.AppManager.*;

public class ContactPageTests extends BaseTest{


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
                .fillAddContactFields(TEST_CONTACT)
                .clickOnSaveButton();

        Assert.assertTrue(contactPageHelper.contactIsPresent(TEST_CONTACT));
        contactPageHelper.removeContact(TEST_CONTACT);
    }

    @Test(description = "Проверка добавления контакта с валидными данными, вариант 2")
    void test7() {
        contactPageHelper.clickOnAddLink();
        contactPageHelper.fillAddContactFields(TEST_CONTACT);
        contactPageHelper.clickOnSaveButton();

        Assert.assertTrue(contactPageHelper.contactIsPresent(TEST_CONTACT));
        contactPageHelper.removeContact(TEST_CONTACT);
    }

    @Test(description = "Проверка добавления контакта с не валидными данными", groups = {"Negative"}, dataProvider = "getContactsFromCsvFile", dataProviderClass = DataProviders.class)
    void test8(Contact contact, String alert) {
        contactPageHelper.clickOnAddLink();
        contactPageHelper.fillAddContactFields(contact);
        contactPageHelper.clickOnSaveButton();
        if (alert.equals("alert")) {
            contactPageHelper.getAlert().accept();
        }
        Assert.assertTrue(!contactPageHelper.getCurrentUrl().equals("https://telranedu.web.app/contacts"));
    }
}
