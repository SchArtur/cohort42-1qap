package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPages extends BasePage {
    @FindBy(css = "[onclick='jsAlert()']")
    WebElement alertButton;
    @FindBy(css = "[onclick='jsConfirm()']")
    WebElement confirmButton;
    @FindBy(css = "[onclick='jsPrompt()']")
    WebElement promtButton;
    @FindBy(id = "result")
    WebElement resultText;

    @Step("Click for JS Alert")
    public void clickAlertButton() {
        clickOnElement(alertButton);
    }
    @Step("Click for JS Confirm")
    public void clickConfirmButton() {
        clickOnElement(confirmButton);
    }
    @Step("Click for JS Prompt")
    public void clickPromtButton() {
        clickOnElement(promtButton);
    }
    @Step("Получение текста результата (после взаимодействия с алертом)")
    public String getResultText() {
        return resultText.getText();
    }
}
