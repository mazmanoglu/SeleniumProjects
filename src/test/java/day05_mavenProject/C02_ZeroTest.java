package day05_mavenProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ZeroTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- Go to webpage "http://zero.webappsecurity.com"
        driver.get("http://zero.webappsecurity.com");
        Thread.sleep(2000);

        //2- Click "Signin" button
        WebElement signInButton = driver.findElement(By.xpath("//button[@id='signin_button']"));
        signInButton.click();
        Thread.sleep(2000);

        //3- Write "username" in login
        WebElement loginBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginBox.sendKeys("username");

        //4- Write "password" in password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");
        Thread.sleep(2000);


        //5- Click sign in
        WebElement signInAcceptButton = driver.findElement(By.xpath("//input[@name='submit']"));
        signInAcceptButton.click();
        Thread.sleep(2000);


        //6- Go to webpage "Pay Bills"
        //7- Write a random amount into "amount" box
        //8- Write "2020-09-10" as date
        //9- Click pay button
        //10- Check the message "The payment was successfully submitted.


        driver.close();
    }
}
