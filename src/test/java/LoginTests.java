import POM.pages.BasePage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import POM.pages.SongsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test(enabled = false, priority = 0, description = "changing the username")
    public void changeUsernameVerifyTheChange() throws InterruptedException {

        browserConfigs();
        provideEmail("dcabdi@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        clickAvatarIcon();

        WebElement currentPassword = driver.findElement(By.xpath("//input[@name='current_password']"));
        currentPassword.sendKeys("te$t$tudent");

        WebElement username= driver.findElement(By.xpath("//input[@name='name']"));
        username.clear();
        username.sendKeys("Abdi");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement usernameActual = driver.findElement(By.xpath("//span[@class='name']"));
        WebElement saveBtn = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        saveBtn.click();
        Assert.assertTrue(usernameActual.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        tearDownBrowser();
    }
    @Test(enabled = true, priority = 1)
    public static void LoginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("dcabdi@gmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(homePage.isUserAvatarDisplayed());
    }
    @Test
    public void PlayASongFromAllSongs() {

        LoginPage loginpage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SongsPage songsPage = new SongsPage(driver);

        loginpage.login();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage.clickOnAllSongs();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        songsPage.doubleClickFirstSong();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertTrue(homePage.isSongPlaying());
    }
}





























