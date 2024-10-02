package phonebook.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import phonebook.core.BasePage;
import phonebook.model.Contact;

import java.util.List;

public class ContactPage extends BasePage {

    @FindBy(css = "[class='contact-item_card__2SOIM']")
    List<WebElement> contactsList;

    @FindBy(xpath = "//*[text()='Save']")
    WebElement saveButton;
    @FindBy(xpath = "//*[text()='Edit']")
    WebElement editButton;
    @FindBy(xpath = "//*[text()='Remove']")
    WebElement removeButton;

    @FindBy(css = "[placeholder='Name']")
    WebElement nameField;
    @FindBy(css = "[placeholder='Last Name']")
    WebElement lastNameField;
    @FindBy(css = "[placeholder='Phone']")
    WebElement phoneField;
    @FindBy(css = "[placeholder='email']")
    WebElement emailField;
    @FindBy(css = "[placeholder='Address']")
    WebElement addressField;

    @Step("Нажимаем на кнопку 'Save'")
    public ContactPage clickOnSaveButton() {
        clickOnElement(saveButton);
        return this;
    }

    @Step("Нажимаем на кнопку 'Edit'")
    public ContactPage clickOnEditButton() {
        clickOnElement(editButton);
        return this;
    }

    @Step("Получаем общее количество контактов")
    public int getContactSize() {
        return contactsList.size();
    }

    @Step("Проверяем наличие контакта {0}")
    public boolean contactIsPresent(Contact contact) {
        return getContactByName(contact) != null;
    }

    @Step("Получаем контакт из списка контактов")
    public WebElement getContactByName(Contact contact) {
        for (WebElement webElement : contactsList) {
            if (webElement.getText().equals(contact.getName())) {
                return webElement;
            }
        }
        return null;
    }

    @Step("Заполняем данные контакта {0}")
    public ContactPage fillContactFields(Contact contact) {
        fillInputField(nameField, contact.getName());
        fillInputField(lastNameField, contact.getLastName());
        fillInputField(phoneField, contact.getPhone());
        fillInputField(emailField, contact.getEmail());
        fillInputField(addressField, contact.getAddress());
        return this;
    }

    @Step("Удаляем контакт {0}")
    public ContactPage removeContact(Contact contact) {
        clickOnContact(contact);
        clickOnElement(removeButton);
        waitInSeconds(1);
        return this;
    }

    @Step("Выбираем контакт {0}")
    public ContactPage clickOnContact(Contact contact) {
        getContactByName(contact).click();
        return this;
    }

    @Step("Создаем контакт")
    public Contact fillNewContactForm() {
        Contact contact = getNewContact();
        fillContactFields(contact);
        clickOnSaveButton();
        waitInSeconds(2);
        return contact;
    }
}