//package steps;
//
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
//import phonebook.model.Contact;
//
//import static phonebook.core.AppManager.*;
//import static phonebook.core.BasePage.getNewContact;
//
//@Tag("@ALL")
//@Tag("@CONTACT")
//public class ContactPageTests extends BaseSteps {
//
//    @BeforeEach
//    void precondition() {
//        if (!loginPage.isSignOutPresent()) {
//            loginPage.loginTestUser();
//        }
//        contactPage.clickOnContactsLink();
//    }
//
//    @Test
//    @Tag("@SMOKE")
//    @DisplayName("Проверка добавления контакта с валидными данными, вариант 1")
//    void test6() {
//        contactPage
//                .clickOnAddLink()
//                .fillContactFields(TEST_CONTACT)
//                .clickOnSaveButton();
//
//        Assertions.assertTrue(contactPage.contactIsPresent(TEST_CONTACT));
//        contactPage.removeContact(TEST_CONTACT);
//    }
//
//    @Test
//    @DisplayName("Проверка добавления контакта с валидными данными, вариант 2")
//    void test7() {
//        contactPage.clickOnAddLink();
//        contactPage.fillContactFields(TEST_CONTACT);
//        contactPage.clickOnSaveButton();
//
//        Assertions.assertTrue(contactPage.contactIsPresent(TEST_CONTACT));
//        contactPage.removeContact(TEST_CONTACT);
//    }
//
//    @Test
//    @Tag("@SMOKE")
//    @DisplayName("Проверка удаления контакта")
//    void test9() {
//        Contact deleteContact = contactPage.fillNewContactForm();
//        int contactSizeStart = contactPage.getContactSize();
//        contactPage.removeContact(deleteContact);
//        int contactSizeEnd = contactPage.getContactSize();
//
//        Assertions.assertFalse(contactPage.contactIsPresent(deleteContact), "Контакт не удалён");
//        Assertions.assertEquals(contactSizeStart - 1, contactSizeEnd, "Количество контактов не изменилось");
//    }
//
//    @Test
//    @DisplayName("Проверка редактирования  контакта")
//    void test10() {
//        Contact oldContact = contactPage.fillNewContactForm();
//        contactPage.clickOnContact(oldContact);
//        contactPage.clickOnEditButton();
//        Contact editContact = getNewContact();
//        contactPage.fillContactFields(editContact);
//        contactPage.clickOnSaveButton();
//        contactPage.waitInSeconds(2);
//        Assertions.assertTrue(contactPage.contactIsPresent(editContact), "Не найден контакт с именем - " + editContact.getName());
//        Assertions.assertFalse(contactPage.contactIsPresent(oldContact), "Найден не измененный контакт");
//        contactPage.removeContact(editContact);
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/contacts.csv")
//    @DisplayName("Проверка добавления контакта с не валидными данными")
//    void test8(String name, String lastName, String phone, String email, String address, String description, String alert) {
//        Contact contact = new Contact(name, lastName, phone, email, address, description);
//        contactPage.clickOnAddLink();
//        contactPage.fillContactFields(contact);
//        contactPage.clickOnSaveButton();
//        if (alert.equals("alert")) {
//            contactPage.getAlert().accept();
//        }
//        Assertions.assertTrue(!contactPage.getCurrentUrl().equals("https://telranedu.web.app/contacts"));
//    }
//}
