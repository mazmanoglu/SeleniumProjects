package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverGetMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        System.out.println(driver.getWindowHandle());
        // her yeni acilan sayfaya verilen hascode / handle degerini yazdirir.
        // CDwindow-E9A5F1F0F1A77128F1CF1A250089CC09

        System.out.println(driver.getWindowHandles());
        // eger test sirasinda birden fazla pencere acilirsa acilan tum pencerelerin
        // acilan tum pencelerin handle degerlerini bir Set olarak yazdirir
        // pencereler arasi gecisi bu handle degerleri ile yapariz.
        // [CDwindow-E9A5F1F0F1A77128F1CF1A250089CC09]

        driver.get("https://www.amazon.com");
        System.out.println(driver.getPageSource());
        // acilan web sayfasinin tum kaynak kodlarini yazdirir. tabi oncesinde bir sayfa girilmeli



        driver.close();
    }
}
