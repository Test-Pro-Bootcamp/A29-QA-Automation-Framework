import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class hm14 {
@Test
    public static void LoginEmptyEmailPasswordTest() {



        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        }

        WebDriver driver = new ChromeDriver();

//       String url = "https://bbb.testpro.io/";
    String url = "https://bbb.testpro.io/registration.php";

        WebElement registrationField= By.id("#hel").findElement(driver);
        driver.get(url);


//        Assert.assertEquals(driver.getCurrentUrl(), url);
//        driver.quit();
    }
}

