package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selectors_Xpath {

    @Test
    public static void differentXpathselectors () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

//        Different ways to access the password field element by xpath
        WebElement emailAddressField = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement emailAddressField2 = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        WebElement emailAddressField3 = driver.findElement(By.xpath("//div[@id='app']/div/form/input[@type='email']"));
        WebElement emailAddressField4 = driver.findElement(By.xpath("//input[@type='email'][@placeholder='Email Address']"));
        WebElement emailAddressField5 = driver.findElement(By.xpath("//div/div/form/input[@type='email'][@placeholder='Email Address']"));
        WebElement emailAddressField6 = driver.findElement(By.xpath("//div/div/form/input[@placeholder='Email Address']"));
        WebElement emailAddressField7 = driver.findElement(By.xpath("//div/div/form/input[@type='email']"));
        WebElement emailAddressField8 = driver.findElement(By.xpath("//div/div/form/input[@required='required'][@type='email']"));
        WebElement emailAddressField9 = driver.findElement(By.xpath("//div/div/form/input[@required='required'][@placeholder='Email Address']"));
        WebElement emailAddressField10 = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/form[1]/input[1]"));

//        Password field
        String password = "//input[@type='password']";

//        Submit button
        String submit = "//button[@type='submit']";

//        Koel logo
        String koeLogo = "//img[@alt=\"Koel's logo\"]";


        emailAddressField.sendKeys("demo@TestPro30");
        WebElement passwordField = driver.findElement(By.xpath(password));
        passwordField.sendKeys("testpro123!");
        WebElement submitButton = driver.findElement(By.xpath(submit));
        Thread.sleep(1000);
        submitButton.click();


        WebElement koelLogo = driver.findElement(By.xpath("//img[@alt=\"Koel's logo\"]"));
        System.out.println(koelLogo.isDisplayed());





//        Search bar
        String search = "//input[@type='search']";

//        Logout icon
        String logout = "//a[@class='logout control']";

//        Favorites
        String favorites = "//section[@id='playlists']//li[@class='playlist favorites']";

//        Lyrics tab
        String lyrics = "//*[@id='extraTabLyrics']";

//        Howdy
        String howdy = "//*[@id='homeWrapper']//header//h1";

//        Most played
//        sampling the use of contains text()
        String mostPlayed = "//h1[contains(text(),'Most Played')]";

//        Volume range
        String volumeRange = "//*[@id='volume']";

//        Play button
        String playButton = "//span[@title='Play or resume']";










//        WebElement howdyH1 = driver.findElement(By.xpath(howdy));
//        System.out.println(howdyH1.getText());




        Thread.sleep(5000);

        driver.quit();




    }
}
