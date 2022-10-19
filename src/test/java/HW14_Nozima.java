import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW14_Nozima {
    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }
    @Test
    public static void registrationNav()throws InterruptedException{

        String urlLanding = "https://bbb.testpro.io/";
        String regURL = "https://bbb.testpro.io/registration.php";

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get(urlLanding);

        WebElement registrationLinkEl = driver.findElement(By.cssSelector("a[type='submit']"));
//      WebElement registrationLinkEl = driver.findElement(By.cssSelector ("a#hel"));

        Thread.sleep(2000);
        registrationLinkEl.click();
        Thread.sleep(5000);

        Assert.assertEquals(driver.getCurrentUrl(), regURL);

        driver.quit();
    }
}