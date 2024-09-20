package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class SelectMenuPage extends BasePage {

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;

    @FindBy(id = "cars")
    WebElement carsSelectElement;


    @FindBy(css = "html")
    WebElement space;

    public SelectMenuPage selectColorOnOldMenu(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);
        return this;
    }

    public String getSelectedColor() {
        Select select = new Select(oldSelectMenu);
        return select.getFirstSelectedOption().getText();
    }

    public SelectMenuPage multiSelect(String... colors) {
        for (String color : colors) {
            inputSelect.sendKeys(color);
            inputSelect.sendKeys(Keys.ENTER);
        }
        space.click();
        return this;
    }


    public boolean colorIsSelectInMultiselect(String color) {
        String xpath = String.format("//div[text()='%s']", color);
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public void selectCars(String... cars) {
        Select carsSelect = new Select(carsSelectElement);
        if (cars.length > 1 && carsSelect.isMultiple()) {
            for (String car : cars) {
                carsSelect.selectByVisibleText(car);
            }
        }
    }

    public String getTextOnSelectByIndex(int index) {
        Select carsSelect = new Select(carsSelectElement);
        List<WebElement> options = carsSelect.getOptions();
        return options.get(index).getText();
    }

    public List<String> getSelectedCars() {
        Select carsSelect = new Select(carsSelectElement);
        List<WebElement> carsElement = carsSelect.getAllSelectedOptions();
        //1й вариант
//        List<String> resultList = new ArrayList<>();
//        for (WebElement webElement : carsElement) {
//           resultList.add(webElement.getText());
//        }
        //2й вариант
        List<String> resultList = carsElement
                .stream() // открывает поток по коллекции
                .map(WebElement::getText)
                .collect(Collectors.toList());

        return resultList;
    }
}
