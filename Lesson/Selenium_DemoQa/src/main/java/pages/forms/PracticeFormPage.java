package pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

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

    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthSelect;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearSelect;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

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
    public WebElement stateContainer;
    @FindBy(id = "react-select-3-input")
    public WebElement state;
    @FindBy(id = "city")
    public WebElement cityContainer;
    @FindBy(id = "react-select-4-input")
    public WebElement city;

    @FindBy(id = "submit")
    public WebElement submit;

    //Thanks for submitting the form
    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement modal;

    public PracticeFormPage fillPersonalData(String name, String surname, String email, String phone, String address) {
        fillInputField(firstName, name);
        fillInputField(lastName, surname);
        fillInputField(userEmail, email);
        fillInputField(userNumber, phone);
        fillInputField(currentAddress, address);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        switch (gender) {
            case "Male" -> jsClickElement(genderMale);
            case "Female" -> jsClickElement(genderFemale);
            case "Other" -> jsClickElement(genderOther);
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

    public PracticeFormPage selectBirthDay(String day, String month, String year) {
        clickOnElement(dateOfBirthInput);
        new Select(monthSelect).selectByVisibleText(month);
        new Select(yearSelect).selectByVisibleText(year);
        String xpath = String.format("//div[text()='%s']", day);
        clickOnElement(driver.findElement(By.xpath(xpath)));
        return this;
    }

    public PracticeFormPage enterSubjects(String... subjects) {
        for (String subject : subjects) {
            subjectsInput.click();
            subjectsInput.sendKeys(subject);
            subjectsInput.sendKeys(Keys.ENTER);
        }
        return this;
    }

    public PracticeFormPage selectHobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            if (hobby.equals("Sports")) {
                sportsCheckbox.click();
            }
            if (hobby.equals("Reading")) {
                readingCheckbox.click();
            }
            if (hobby.equals("Music")) {
                musicCheckbox.click();
            }
        }
        return this;
    }

    public PracticeFormPage uploadFile(String path) {
        uploadPicture.sendKeys(path);
        return this;
    }

    public PracticeFormPage fillStateAndCity(String stateString, String cityString) {
        stateContainer.click();
        state.sendKeys(stateString);
        state.sendKeys(Keys.ENTER);
        cityContainer.click();
        city.sendKeys(cityString);
        city.sendKeys(Keys.ENTER);
        return this;
    }

}
