package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework15 {


    @Test
    public void LoginValidEmailValidPasswordTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);


        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys("frathasturk@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("Testpro12345!");

        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();

        WebElement searchField = driver.findElement(By.cssSelector("[type = 'search']"));
        searchField.sendKeys("F");
        Thread.sleep(1000);
        searchField.clear();
        searchField.sendKeys("Pluto");
        Thread.sleep(2000);

        // Can you please advise how I can locate CSS selector for "Pluto"

        WebElement songPluto = driver.findElement(By.cssSelector("section.songs > ul > article > span.main > span.details"));
        //lets try adding letter s in span.detail
        System.out.println(songPluto.getText());
        driver.quit();

    }
}


