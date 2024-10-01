package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage extends BasePage {
    @FindBy(id = "dropdown")
    public WebElement dropdownList;

    public DropdownPage selectDropdownList(String option) {
        Select select = new Select(dropdownList);
        select.selectByVisibleText(option);
        System.out.println(select.getFirstSelectedOption().getText() + " is first");
        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
        return this;
    }
}

