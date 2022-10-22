import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class HW15_Nozima {
    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }
    @Test
    public static void search()throws InterruptedException {
        String pageLanding = "https://bbb.testpro.io/";
        String userPage = "https://bbb.testpro.io/#!/home";
        String email = "nozishka86@gmail.com";
        String password = "te$t$tudent";
        String song = "Pluto";
        String expectedSong = "Pluto Song";

        WebDriver chrome = new ChromeDriver();

        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chrome.get(pageLanding);

        WebElement emailField = chrome.findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = chrome.findElement(By.cssSelector("input[type='password']"));
        WebElement loginButton = chrome.findElement(By.cssSelector("button[type='submit']"));


        emailField.sendKeys(email);
        Thread.sleep(2000);
        passwordField.click();
        passwordField.sendKeys(password);
        Thread.sleep(2000);
        loginButton.click();

        Thread.sleep(3000);
        Assert.assertEquals(chrome.getCurrentUrl(),userPage);

        WebElement searchField = chrome.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.sendKeys(song);

        WebElement actualSong = chrome.findElement(By.cssSelector("ul>article"));
        String songName = actualSong.getText();
        System.out.println(expectedSong + " in search results is: "+ songName);

//        WebElement plutoSong = chrome.findElement(By.xpath("//span[contains(text(), 'Pluto')]"));
//        Assert.assertTrue(plutoSong.isDisplayed());

        Thread.sleep(5000);

        chrome.quit();
    }
}
