import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework14 {


//    Using Selenium, Navigate to "https://bbb.testpro.io/"
//    Click Registration link
//    Validate that you are redirected to Registration page
//    Create a new branch and commit your changes
//    Push your code to a remote repository
//    Create a pull request
//    Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework

    @Test
    public static void registration() throws InterruptedException {

        String url = "https://bbb.testpro.io/";
        String registrationURL = "https://bbb.testpro.io/registration.php";

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        WebElement registrationLinkElement = driver.findElement(By.id("hel"));

        Thread.sleep(2000);
        registrationLinkElement.click();
        Thread.sleep(5000);


        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);


        String retrievedUrl = driver.getCurrentUrl();
        System.out.println("Our current URL is " + retrievedUrl);


        driver.quit();
    }


}








