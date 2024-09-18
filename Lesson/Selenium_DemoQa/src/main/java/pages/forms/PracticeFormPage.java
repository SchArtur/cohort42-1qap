package pages.forms;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static core.Init.practiceFormPage;

public class PracticeFormPage extends BasePage {

    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id = "lastName")
    public WebElement lastName;
    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "gender-radio-1")
    public WebElement genderMale;
    @FindBy(id = "gender-radio-2")
    public WebElement genderFemale;
    @FindBy(id = "gender-radio-3")
    public WebElement genderOther;

    @FindBy(id = "userNumber")
    public WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(id = "subjectsContainer")
    public WebElement subjectsContainer;

    @FindBy(xpath = "//*[text()='Sports']")
    public WebElement sportsCheckbox;
    @FindBy(xpath = "//*[text()='Reading']")
    public WebElement readingCheckbox;
    @FindBy(xpath = "//*[text()='Music']")
    public WebElement musicCheckbox;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;
    @FindBy(id = "state")
    public WebElement state;
    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "submit")
    public WebElement submit;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement modal;

    public PracticeFormPage fillPersonalData(String name, String surname, String email, String phone, String address) {
        fillInputField(firstName, name);
        fillInputField(this.lastName, surname);
        fillInputField(firstName, name);
        fillInputField(firstName, name);
        fillInputField(firstName, name);
        fillInputField(firstName, name);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        switch (gender) {
            case "Male" -> clickOnElement(genderMale);
            case "Female" -> clickOnElement(genderFemale);
            case "Other" -> clickOnElement(genderOther);
        }
        return this;
    }

    public PracticeFormPage selectBirthDay(String date) {
        clickOnElement(dateOfBirthInput);
//        для мака выделить всё command + a, для windows ctrl + a
        dateOfBirthInput.sendKeys(Keys.COMMAND + "a");
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage enterSubjects(String... subjects) {
        for (String subject : subjects) {
            fillInputField(subjectsContainer, subject);
            subjectsContainer.sendKeys(Keys.ENTER);
        }
        return this;
    }

}
