package bestbuybotjava;

import java.util.Scanner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class Test {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "BestBuyBotJava/lib/chromedriver.exe");
        Scanner inputStream = new Scanner(System.in);
        /*
        System.out.println();
        System.out.println("Please enter best buy product url: ");
        String testUrl = inputStream.next();
        System.out.println();
        */

        driver.get("google.com");
        final String testUrl = "https://www.bestbuy.com/site/gigabyte-nvidia-geforce-gtx-1650-super-oc-edition-4gb-gddr6-pci-express-3-0-graphics-card-black-gray/6409188.p?skuId=6409188";

        System.out.println(testUrl.substring(testUrl.indexOf("www."), testUrl.indexOf(".com")).equals("www.bestbuy"));
        inputStream.close();
    }
}