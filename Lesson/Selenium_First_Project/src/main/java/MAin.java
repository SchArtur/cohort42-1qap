import org.openqa.selenium.WebElement;

public class MAin {
    public static void main(String[] args) {
        String countStrElm = "(2)";
        String cellStr = countStrElm.replace("(", "").replace(")", "");
        System.out.println(cellStr + 1);
        int countStart = Integer.parseInt(cellStr);
        System.out.println(countStart + 1);
    }

    int getCountCart(String countStr) {
        return Integer.parseInt(countStr.replace("(", "").replace(")", ""));
    }
}
