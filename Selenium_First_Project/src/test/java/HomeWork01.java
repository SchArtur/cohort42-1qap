import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork01{
    WebDriver driver;
    @BeforeEach
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
    }
    @Test
    public void openDemoWebShop(){
        System.out.println("Demo Web Shop");
    }

}
