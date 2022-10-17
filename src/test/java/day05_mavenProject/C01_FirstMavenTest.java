package day05_mavenProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_FirstMavenTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup(); //githubdan almis olduk. onceden system icindeki dependency'den aliyorduk.

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1- Go to https://www.amazon.com/
            driver.get("https://www.amazon.com");

        //2- locate the search box
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));

        //3- search "Samsung headphones"
            searchBoxElement.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4- Write the number(amount) of result
            WebElement resultNumberElement = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
            System.out.println(resultNumberElement.getText());

            String numberOfResult = resultNumberElement.getText();
            numberOfResult = numberOfResult.substring(
                    (numberOfResult.indexOf("of")+3) , (numberOfResult.indexOf("for")-1)
            );

            System.out.println(numberOfResult);
        // Sonuc sayisinin 100'den fazla oldugunu test edin
            numberOfResult = resultNumberElement.getText();
            numberOfResult = numberOfResult.substring(
                (numberOfResult.indexOf("of")+3) , (numberOfResult.indexOf("result")-1)
            );


            if (Integer.parseInt(numberOfResult)>100)
                System.out.println("Search Result is bigger than 100. TEST PASSED");
            else
                System.out.println("Search Result is smaller than 100. TEST FAILED ");


            System.out.println(numberOfResult);


        //5- Click the first product
            WebElement firstProductElement = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
            firstProductElement.click();

        //6- Write the all titles in that page
            driver.navigate().back(); //yukaridaki kodlarda ilk urunun icine girmistik ancak orada baslik yok
                                     // bu yuzden navigate ile geri arama sonuc sayfasina donuyoruz.

        List<WebElement> titleElementList = driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));

        for (WebElement eachelement:titleElementList)
        {
            System.out.println(eachelement.getText());
        }


        driver.close();
    }
}
