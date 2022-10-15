package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {


        //1- C01_TekrarTesti isimli bir class olustur
        //2- https://www.amazon.com/ adresine git
            System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.amazon.com/");

        //3- browser'i tam sayfa yapin ve islemler icin 15 saniye sure verin
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            Thread.sleep(3000);

        //4- sayfayi "refresh" yapin
            driver.navigate().refresh();

            Thread.sleep(3000);

        //5- sayfa basliginin "Spend less" ifadesi icerdigini test et
            String actualTitle = driver.getTitle();
            String expectedSentence = "Spend less";
            if (actualTitle.contains(expectedSentence))
            {
                System.out.println("Actual title contains 'Spend less'. TEST PASSED");
            }
            else
            {
                System.out.println("Actual title does not contain 'Spend less'. TEST FAILED");
            }

        //6- Gift Cards sekmesine bas
            driver.findElement(By.linkText("Gift Cards")).click();
            Thread.sleep(3000);

        //7- Birthday butonuna bas
            driver.findElement(By.xpath("//img[@alt='Birthday gift cards']")).click();
            Thread.sleep(3000);

        //8- Best Seller bolumunden ilk urunu tiklayin
            driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();
            Thread.sleep(2000);

        //9- Gift Card details'den 25$'i secin
            driver.findElement(By.xpath("//button[@value='25']")).click();
            Thread.sleep(1000);

        //10- Urun ucretinin 25$ oldugunu test et
            WebElement elementOfPrice = driver.findElement(By.xpath("//span[@class='a-color-price a-text-bold']"));
            //System.out.println(elementOfPrice); // bu elementin hashcode unu yazdirir.
            //System.out.println(elementOfPrice.getText()); // bu yukaridaki elementin degerini yazdirir

            String actualPrice = elementOfPrice.getText();
            String expectedPrice = "25$";

            if (expectedPrice.contains(actualPrice))
            {
                    System.out.println("Actual price is equal to expected price. TEST PASSED");
            }
            else
            {
                    System.out.println("Actual price is NOT equal to expected price. TEST FAILED");
                    System.out.println("Actual price = "+actualPrice + "\nExpected price = "+expectedPrice);
            }
            // ornekler yaparken expected ve actual price'lari yazdirdik ancak normalde yazdirilmaz.

            Thread.sleep(1000);
            //11- sayfayi kapat
            driver.close();
    }
}
