package day04_xpath;

import com.sun.source.tree.IfTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XpathTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
            bir web element, link olmasa da text icerebilir. link olmayan bir html elementinde By.linktext kullanilmaz
            ancak text kullanilarak xpath yazilabilir

            //tagName[text()=''] ==> bu ifade genelde unique olur.
            tagname onemli degilse onun yerine * yazilabilir.
         */

        // go to website
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Click add element button
        WebElement addButton = driver.findElement(By.xpath("//*[text()='Add Element']"));
        addButton.click();

        // check delete button is displayed
        WebElement deleteButton = driver.findElement(By.xpath("//*[text()='Delete']"));

        if (deleteButton.isDisplayed())
            System.out.println("Delete button is displayed. TEST PASSED");
        else
            System.out.println("Delete button is NOT displayed. TEST FAILED");

        // click delete button
        deleteButton.click();

        //check "Add/Remove Elements" is displayed
        WebElement addRemoveElement = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveElement.isDisplayed())
            System.out.println("Add/Remove button is displayed. TEST PASSED");
        else
            System.out.println("Add/Remove button is NOT displayed. TEST FAILED");


        driver.close();
    }
}
