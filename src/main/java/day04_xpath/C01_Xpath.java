package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        Su ana kadar ogrendigimiz 6 adet locator HTML koduna bagliydi.
        Xpath ve cssSelector sadece bir attribute'e veya tag'e bagimli olmadan her web elementi locate etmemize yarar.

        her HTML elementinde
        1- tag
        2- Attribute(s)
        3- attribute value

        Xpath ve cssSelector, bu 3 maddenin kombinasyonu ile olusur.

        (//tagIsmi[@attributeIsmi='attributeValue'])[index] ya da
        //tagIsmi[@attributeIsmi='attributeValue']
        ama index'li olan ilki tercih edilmez.
            - eger yazdigimiz xpath 1'den fazla secenek cikariyorsa baska attribute
              isimlerini bakmamiz lazim,
            - eger elimizde tek attribute var ancak sonuc 1'den fazlaysa
              index'le aratabiliriz.
         */


        //soru


            //1- Go to =  https://the-internet.herokuapp.com/add_remove_elements/
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
            //2- Click add element button
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addButton.click();
            //3- test delete button is visible
        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if (deleteButton.isDisplayed())
        {
            System.out.println("Delete Button is displayed. TEST PASSED");
        }
        else
        {
            System.out.println("Delete Button is not displayed. TEST FAILED");
        }
            //4- click delete button
        Thread.sleep(3000);
        deleteButton.click();
            //5- Test "Add/Remove Elements" is visible
        //WebElement addRemoveWord = driver.findElement(By.tagName("h3"));
        WebElement addRemoveWord = driver.findElement(By.xpath("//h3"));

        if (addRemoveWord.isDisplayed())
        {
            System.out.println("Add/Remove Elements is displayed. TEST PASSED");
        }
        else
        {
            System.out.println("Add/Remove Elements is not displayed. TEST FAILED");
        }



        Thread.sleep(5000);
        driver.close();
    }
}