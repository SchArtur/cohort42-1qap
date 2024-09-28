package pages.elements;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class TextBoxPage extends BasePage {

    @FindBy(id = "userName")
    public WebElement userName;
    @FindBy(id = "userEmail")
    public WebElement userEmail;
    @FindBy(id = "currentAddress")
    public WebElement currentAddress;
    @FindBy(id = "permanentAddress")
    public WebElement permanentAddress;
    @FindBy(id = "submit")
    public WebElement submit;
    @FindBy(css = ".border #name")
    public WebElement borderName;
    @FindBy(css = ".border #email")
    public WebElement borderEmail;

    public TextBoxPage fillUserDataS(String name, String email) {
        fillInputField(userName, name);
        fillInputField(userEmail, email);
        fillInputField(currentAddress, "currentAddress 55 ");
        fillInputField(permanentAddress, "permanentAddress 78");
        return this;
    }

    public TextBoxPage fillUserDataJS(String name, String email) {
        js.executeScript("document.getElementById('userName').value='" + name + "';");
        js.executeScript("document.getElementById('userName').style.border='5px solid red';");
        js.executeScript(String.format("document.getElementById('userEmail').value='%s';", email));
        js.executeScript("arguments[0].style.border='5px solid red';", userEmail);
//      js.executeScript("arguments[0].value=arguments[1]");
        return this;
    }

    public TextBoxPage clickSubmit() {
        submit.click();
        System.out.println("Кря");
        return this;
    }

    public TextBoxPage clickSubmitJS() {
        js.executeScript("document.querySelector('#submit').style.background='Black';");
        js.executeScript("document.querySelector('#submit').click();");
        System.out.println("Кря");
        return this;
    }

    public TextBoxPage checkNameAndEmailJSInnerText(String name, String email) {
        String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(innerText);
        Assertions.assertTrue(innerText.contains("Name:" + name));
        Assertions.assertTrue(innerText.contains("Email:" + email));
        System.out.println("*******************");
        return this;
    }

    public TextBoxPage checkNameAndEmail(String name, String email) {
        Assertions.assertTrue(borderName.getText().contains(name));
        Assertions.assertTrue(borderEmail.getText().contains(email));
        return this;
    }


}
