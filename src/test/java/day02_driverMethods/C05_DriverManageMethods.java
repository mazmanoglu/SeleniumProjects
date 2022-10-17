package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DriverManageMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // yukaridakileri genelde her seferinde yazariz
        // bazi web elementleri maximize olmadigi durumlarda gorulemeyebilir, bu yuzden tam ekran yapariz.


        /*
        Waits method will be explained further.
        Implicitly wait, driverin aradigi elementleri bulabilmesi icin kendisine verdigimiz arastirma suresidir
        O sure icerisinde aradigi elementi bulamazsa hata verir, ama bu sureyi beklemek zorunda degildir.
        Bu maksimum bekleme suresidir.
         */

        driver.manage().window().fullscreen();
        System.out.println("Fullscreen position : "+driver.manage().window().getPosition());
        System.out.println("Fullscreen size : "+driver.manage().window().getSize());

        Thread.sleep(2000);

        driver.manage().window().maximize();
        System.out.println("Maximize position : "+driver.manage().window().getPosition());
        System.out.println("Maximize size : "+driver.manage().window().getSize());

        Thread.sleep(2000);

        driver.manage().window().minimize();
        System.out.println("Minimize position : "+driver.manage().window().getPosition());
        System.out.println("Minimize size : "+driver.manage().window().getSize());


        // driver.close();
    }
}
