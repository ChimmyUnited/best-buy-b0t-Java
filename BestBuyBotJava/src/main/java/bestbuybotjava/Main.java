package bestbuybotjava;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {
    public static void main(String[] args) {

        // object init
        System.setProperty("webdriver.chrome.driver", "BestBuyBotJava/lib/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Scanner inputStream = new Scanner(System.in);

        // url
        System.out.println();
        System.out.println("Please enter best buy product URL: ");
        String testUrl = inputStream.next();
        System.out.println();

        // variable init
        String url;

        while(true) { // test url
            if (testUrl.substring(testUrl.indexOf("www."), testUrl.indexOf(".com")).equals("www.bestbuy")) {
                url = testUrl; // my personal testing url: https://www.bestbuy.com/site/gigabyte-nvidia-geforce-gtx-1650-super-oc-edition-4gb-gddr6-pci-express-3-0-graphics-card-black-gray/6409188.p?skuId=6409188
                break;
            } else {
                System.out.println("Invalid URL");
                System.out.println("Please enter best buy product URL: ");
                testUrl = inputStream.next();
            }
        }
        
        driver.get(url);
        formattedPrinter("Successfully connected to " + url);
        
        

        inputStream.close();
    }

    public static void formattedPrinter(String string) {
        System.out.println(" *-*  " + string);
    }
}