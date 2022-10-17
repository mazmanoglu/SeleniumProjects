package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_RelativeLocators {
    public static void main(String[] args) {

        //1- go to webpage https://www.diemol.com/selenium-4-demo/relative-locators-demo
        //2- Use RelativeLocators and locate Boston webelement in 3 different types.

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo");

        // Describe as  "Right of London, Left of Berlin"

        WebElement london = driver.findElement(By.id("pid5_price"));
        WebElement berlin = driver.findElement(By.id("pid7_price"));

        WebElement boston1 = driver.findElement(RelativeLocator
                                                .with(By.tagName("p"))
                                                .toRightOf(london)
                                                .toLeftOf(berlin));

        System.out.println(boston1.getAttribute("id")); //pid6_price

        // below of Toronto
        WebElement toronto = driver.findElement(By.id("pid2_price"));

        WebElement boston2 = driver.findElement(RelativeLocator
                                                .with(By.className("ui-li-aside"))
                                                .below(toronto));

        System.out.println(boston2.getAttribute("id")); //pid6_price

        // above of Mountie
        WebElement mountie = driver.findElement(By.id("pid10_price"));
        WebElement amsterdam = driver.findElement(By.id("pid9_price"));

        WebElement boston3 = driver.findElement(RelativeLocator
                                                .with(By.tagName("p"))
                                                .above(mountie));

        System.out.println(boston3.getAttribute("id")); //pid6_price



        driver.close();
    }
}
