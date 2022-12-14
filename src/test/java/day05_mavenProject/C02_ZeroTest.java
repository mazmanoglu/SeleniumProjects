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
        // or
        //driver.findElement(By.id("signin_button")).click();
        Thread.sleep(2000);

        //3- Write "username" in login
        WebElement loginUsernameBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginUsernameBox.sendKeys("username");
        // or
        //driver.findElement(By.id("user_login"));

        //4- Write "password" in password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");
        Thread.sleep(2000);


        //5- Click sign in
        WebElement signInAcceptButton = driver.findElement(By.xpath("//input[@name='submit']"));
        signInAcceptButton.click();
        driver.navigate().back();
        Thread.sleep(2000);

        //6- Go to webpage "Pay Bills" under "online bankings" menu
        WebElement onlineBanking = driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBanking.click();
        WebElement payBills = driver.findElement(By.xpath("//span[text()='Pay Bills']"));
        payBills.click();
        Thread.sleep(2000);

        //7- Write a random amount into "amount" box
        WebElement amountTextBox = driver.findElement(By.id("sp_amount"));
        amountTextBox.sendKeys("200");

        //8- Write "2022-10-10" as date
        WebElement dateBox = driver.findElement(By.id("sp_date"));
        dateBox.sendKeys("2022-10-10");
        Thread.sleep(2000);

        //9- Click pay button
        WebElement payButton = driver.findElement(By.id("pay_saved_payees"));
        payButton.click();
        Thread.sleep(2000);

        //10- Check the message "The payment was successfully submitted".
        WebElement paymentSuccessfulMessage = driver.findElement(By.id("alert_content"));

        String actualSuccessMessage = paymentSuccessfulMessage.getText();
        String expectedSuccessMessage = "The payment was successfully submitted.";

        if (actualSuccessMessage.equals(expectedSuccessMessage))
            System.out.println("Success message is true. TEST PASSED");
        else
            System.out.println("Success message is NOT true. TEST FAILED");
        Thread.sleep(2000);



        driver.close();
    }
}
