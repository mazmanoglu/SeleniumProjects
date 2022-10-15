package day03_webElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_webElementMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdrive.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella");
        searchBox.clear(); // clear the search box
        searchBox.sendKeys("Java");

        System.out.println(searchBox.getSize()); // arama kutusunun olculeri
        System.out.println(searchBox.getTagName()); //tagname'i yazdirma (ornek=input)
        System.out.println(searchBox.getAttribute("name")); // name attribute degerini yazdir
        System.out.println(searchBox.getRect().getX()); //--> ???

        System.out.println(searchBox.isDisplayed()); // arama kutusu gorunuyor mu? sonuc true-false doner
        System.out.println(searchBox.isEnabled()); // arama kutusu kullanilabiliyor mu? true-false doner
        System.out.println(searchBox.isSelected()); // arama kutusu icin kullanilmaz, radiobutton ya da checkbox icin kullanilir.


        Thread.sleep(3000);
        driver.close();
    }
}
