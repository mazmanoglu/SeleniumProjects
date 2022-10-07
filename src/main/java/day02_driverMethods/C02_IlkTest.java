package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_IlkTest {
    public static void main(String[] args) {
        /*
        Gerekli ayarlamalari yapip amazon anasayfaya gidin,
        1- sayfa basligi amazon icermeli (kucuk harfli amazon)
        2- sayfa url'inde Amazon kelimesi olmali (buyuk harfli Amazon)
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        String expectedTitleIcerik = "amazon";
        String expectedURLIcerik = "Amazon";

        String actualURL = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        // URL test

        if (actualURL.contains(expectedURLIcerik))
        {
            System.out.println("Url test passed");
        }
        else
        {
            System.out.println("Url test failed");
            System.out.println("Actual URL : "+actualURL);
            System.out.println("Actual URL, aranan '"+expectedURLIcerik+"' kelimesini icermiyor");
        }

        // Title test

        if (actualTitle.contains(expectedTitleIcerik))
        {
            System.out.println("Title test passed");
        }
        else
        {
            System.out.println("Title test failed");
            System.out.println("Actual title : "+actualTitle);
            System.out.println("Actual title, aranan '"+expectedTitleIcerik+"' kelimesini icermiyor");
        }

        driver.quit();
        // driver.close() sadece acik olan browser'i kapatir
        // driver.quit() ise test calisirken acilan tum browser'lari kapatir
    }
}
