package ilcarro.steps;

import ilcarro.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

    //    @Дано("Пользователь запускает браузер")
    @Given("пользователь запускает браузер")
    public void userLaunchBrowser() {
        new HomePage().launchBrowser();
    }

    @When("пользователь открывает домашнюю страницу")
    public void userOpenHomePage() {
        new HomePage().openHomePage();
    }

    //    ^ - этот символ означает начало шага
//    $ - конец
//    {string}
//    {word}
//    {int}
//    {Element}
    @Then("^проверяем, что заголовок страницы - \"(.+)\"$")
    public void checkTitle(String msg) {
        new HomePage().checkTitleText(msg);
    }

}
