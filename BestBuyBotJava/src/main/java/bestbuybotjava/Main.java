package bestbuybotjava;

import java.lang.Thread;
import java.util.Scanner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;


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
        String url = "";
        String sold = "Sold Out!";

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
        driver.manage().window().maximize();
        driver.get(url);
        formattedPrinter("Successfully connected to " + url);

        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/main/div[2]/div[3]/div[2]/div/div/div[4]/div/div/h2")));
        formattedPrinter("Website fully loaded");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        formattedPrinter("Attempting to add to cart...");
        while (true) {
            WebElement hopefullyAddToCart = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div[3]/div[2]/div/div/div[7]/div[1]/div/div/div/button"));
            //WebElement annoyingSurvey = driver.findElement(By.xpath(""));
            if (hopefullyAddToCart.getText().equals("Sold Out")) {
                spinnyNotSold(sold);
                try {
                    Thread.sleep(10000);
                    driver.navigate().refresh();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else{
                formattedPrinter("In Stock!");
                hopefullyAddToCart.click();
                break;
            }
        }
        inputStream.close();
    }

    public static void formattedPrinter(String string) {
        System.out.println(" *-*  " + string);
    }

    public static void spinnyNotSold(String sold) {
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        System.out.print(" */*  " + sold);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        System.out.print(" *-*  " + sold);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        System.out.print(" *\\*  " + sold);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        System.out.print(" *|*  " + sold);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        System.out.print(" */*  " + sold);
    }
}