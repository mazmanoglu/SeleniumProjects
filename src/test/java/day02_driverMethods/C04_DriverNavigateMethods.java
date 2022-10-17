package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.amazon.com");
        driver.navigate().to("https://www.youtube.com");

        Thread.sleep(2000);

        // turn back to Amazon
        driver.navigate().back();

        Thread.sleep(2000);

        // again go to YouTube
        driver.navigate().forward();

        Thread.sleep(2000);

        driver.navigate().refresh();

        driver.close();
    }
}
