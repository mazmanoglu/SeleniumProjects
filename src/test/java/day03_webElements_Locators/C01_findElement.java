package day03_webElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_findElement {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // we usually write these 4 lines in all

        driver.get("https://www.amazon.com"); // you can run without www, but cannot without https

        // bir web sitesinde herhangi bir web elementi kullanabilmek icin
        // o web elementi kodlarimiza tanitmamiz gerekir.

        // WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));

        WebElement amazonSearchBox = driver.findElement(By.name("field-keywords"));

        amazonSearchBox.sendKeys("Nutella" + Keys.ENTER);

        Thread.sleep(5000);
        /*
        Selenium'da 8 locator vardir.
        Bunlardan 6 tanesi HTML uzerindeki tag veya attribute'lere goredir
        2 tanesi ise daha spesifik olarak ilk 6 locator ile bulamadigimiz
        webElement'leri locate etmek icin kullanilir.

        1- By.id
                Id'ler genelde unique verilir, dolayisiyla bir elementte id varsa once By.id denenebilir

        2- By.className
                class attribute'u genelde ayni islevi yapan webElementleri gruplandirmak icin kullanilir.
                Bu gruplandirmalar sayesinde css ile o gruptaki tum webElementler tek yerden sekillendirilebilir.
                Class attribute kullanilirken value eger space iceriyorsa By.className ile yapilan locate'ler
                hata verebilir (vermeyebilir de).

                Genellikle classname ile yapilan locate'ler birden fazla webElement dondureceginden List<WebElement>
                seklinde olusturacagimiz bir liste kaydederiz. Ancak buradaki elemanlar webElement oldugundan direk
                yazdiramayiz. Bunun yerine for-each loop kullanarak webElement'in ozellikleri yazdirilabilir.
        3- Name
                Eger HTML kodunda name attribute varsa kullanilabilir
        4- Tagname (<input> gibi, search yaparken //input seklinde arattir)
                Tagname de classname gibi gruplandirmalar icin kullanilir. Dolayisiyla tagname ile genelde bir element
                degil, benzer ozelliklerdeki bir listeye ulasilir.
        5- LinkText (<a></a> arasinda kalan kisim)
                sadece linkler icin kullanilir. her link HTML elementinin uzerinde bir link yazisi olur, bu yazi genelde
                kullanicinin front-end'de gordugu yazi ile aynidir ancak bazen space gibi fark edemeyecegimiz eklemeler olabilir
                (varsa bosluk vb.. locate alinirken yazilmalidir)
        6- PartialLinkText
                linktext gibi sadece linkler icin kullanilir, farki tum yaziyi degil parcasini kullanmamizin da yeterli olmasidir.
         */


        driver.close();
    }
}
