package day03_webElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_noSuchElementException {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella");

        //WebElement searchBox2 = driver.findElement(By.id("twotabsearchtextbox11"));
        // yukaridaki kod nosuchelementexception hatasi verir, bu locater sorununu belirtir.
        // findelement ile locate edilen webelementlerde locator'da sorun olursa
        // driver istenen elementi bulamaz ve hata firlatir.

        //List<WebElement> resultWebElementList = driver.findElements(By.id("twotabsearchtextbox11"));
        // findelementS metodu ile locate edilen liste, locator hatali olsa bile exception vermez
        // sadece bos bir liste dondurur.





        Thread.sleep(3000);
        driver.close();
    }
}
