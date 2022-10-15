package day03_webElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_locatorTest {
    public static void main(String[] args) throws InterruptedException {

        /*
         - go to webpage https://www.amazon.com
         - Search "city bike"
         - write the number of result
         - click the picture of first result
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBox.sendKeys("city bike" + Keys.ENTER);
        // amazonSearchBox.submit(); // bu da yukaridaki enter'in islevini gorur

        List<WebElement> webElementListResult = driver.findElements(By.className("sg-col-inner"));
        System.out.println(webElementListResult.size()); //120 cikti, bunun 1. elementi, bulunan sonuc sayisi

        System.out.println(webElementListResult.get(0).getText()); // bu ya da ustteki size sonucu her calistirmada degisebilir.

        driver.findElement(By.className("s-image")).click(); // normalde s-image'den 80 tane vardi
        /*
        Eger bir locate ile birden fazla element bulunuyorsa selenium ilk elementi kullanir.
         */

        Thread.sleep(3000);


        driver.close();
    }
}
