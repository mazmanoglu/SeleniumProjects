package day03_webElements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_findElements {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.amazon.com");
        // List<WebElement> classNameList = driver.findElements(By.className("a-size-base a-color-base"));
        // class isminde bosluk oldugu zaman genelde hata verir

        List<WebElement> classNameList = driver.findElements(By.className("a-spacing-none"));

        //System.out.println(classNameList.size());

        for (WebElement eachElement:classNameList)
        {
            System.out.println(eachElement.getText());
        }

        driver.close();
    }
}
