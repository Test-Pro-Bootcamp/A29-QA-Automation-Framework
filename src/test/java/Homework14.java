import POM.pages.AllSongsPage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework14 extends BaseTest {

    @Test
    public void registrationNavigation () {
        String registrationURL = "https://bbb.testpro.io/registration.php";
        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);
    }
}
