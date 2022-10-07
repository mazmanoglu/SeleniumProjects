package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driverMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver objesi olusturulunca Selenium webDriver bilgisayarimizdaki chrome browser'dan bir bos sayfa actirir.
        // eger firefox, edge gibi baska browser kullanmak istersen Selenium sitesinden onun driverini indirip projeye ekle.

        driver.get("https://www.amazon.com");
        // eger kodlarimizi belirli bir sure bekletmek istersek thread kullaniriz

        Thread.sleep(3000);
        // ilk yazdigimizda sleep hata verir, bunu exception firlatarak cozebiliriz.
        // 5000ms = 5sn

        System.out.println("Acilan sayfa url'si "+driver.getCurrentUrl());

        System.out.println("Acilan sayfanin title'i "+driver.getTitle());


        driver.close();
    }
}
