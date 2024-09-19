package theIntertet.helpers;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theIntertet.core.BasePage;

import static theIntertet.core.AppManager.homePage;

public class JavaScriptAlertsPage extends BasePage {

    @FindBy(css = "button[onclick='jsAlert()']")
    WebElement alertButton;

    @FindBy(css = "[onclick='jsConfirm()']")
     WebElement confirmButton;

    @FindBy(css = "button[onclick='jsPrompt()']")
    WebElement promptButton;

    @FindBy (id="result")
     WebElement resultPrompt;

    @Step("Нажимаем на кнопку JS Alert")
    public void clickJsAlertButton() {
        clickOnElement(alertButton);
    }

    @Step("Нажимаем на кнопку JS Confirm")
    public void clickJsConfirmButton() {
        clickOnElement(confirmButton);
    }

    @Step("Нажимаем на кнопку JS Prompt")
    public void clickJsPromptButton() {
        clickOnElement(promptButton);
    }

    @Step("Result")
    public String resultText() {
        return resultPrompt.getText();
    }
}
