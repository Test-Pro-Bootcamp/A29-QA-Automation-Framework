import POM.AboutKoelPage;
import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

  /* //* @Test(enabled = false)
    //public void LoginEmptyEmailPasswordTest () {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

*/    //@Test (enabled=false, priority = 1)// (priority = 1, dataProvider = "invalidCredentials", dataProviderClass = BaseTest.class)
    //public void LoginValidEmailValidPasswordTest () {

       // login();
        // driver.findelement(how to find the element)
        // |
        // var = how to find element
        // driver.findelement(var)

    /*    By avatarIconLocator = By.xpath("//img[contains(@alt,'Avatar of')]");
        By playlistLocator = By.cssSelector("#playlists h1");

        wait.until(ExpectedConditions.elementToBeClickable(avatarIconLocator));
        WebElement avatarIcon = driver.findElement(avatarIconLocator);
        Assert.assertTrue(avatarIcon.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(playlistLocator));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(playlistLocator), "PLAYLISTS"));*/
        @Test(enabled = true)
        public void LoginValidEmailValidPasswordTest () {
            launchBrowser("https://bbb.testpro.io");
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            loginPage.provideEmail("nargiza10041@gmail.com");
            loginPage.providePassword("te$t$tudent");
            loginPage.clickSubmitBtn();
            Assert.assertTrue(homePage.getInfoAboutKoel().isDisplayed());
        }
        @Test
        public void InfoKoelPage () {
            AboutKoelPage infoPage = new AboutKoelPage(driver);
            infoPage.login();
            infoPage.clickButtonInfo();
            infoPage.clickCloseButton();
        }

        @Test(enabled = false)
        public void LoginInvalidEmailPasswordTest () throws InterruptedException {
            provideEmail("dem@class.com");
            providePassword("");
            clickSubmitBtn();

            // Vd
            Thread.sleep(2000);
            Assert.assertEquals(driver.getCurrentUrl(), url);

        }

        @Test(enabled = false)
        public void LoginValidEmailEmptyPasswordTest () {
            WebDriver driver;
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);

            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("demo@class.com");

            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();

            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();

            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
            Assert.assertTrue(avatarIcon.isDisplayed());

            driver.quit();
        }

        @Test(enabled = false)
        public void SwitchToSongsMenu () {
            WebDriver driver;
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);
            By emailSelector = By.cssSelector("[type='email']");
            WebElement emailField = driver.findElement(emailSelector);
            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            By avatarSelector = By.cssSelector("[alt='Avatar of student']");
            By songMenuSelector = By.className("songs");
            By allButtonSelector = By.className("btn-shuffle-all");

            emailField.click();
            emailField.sendKeys("demo@class.com");
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");
            submitButton.click();
            Assert.assertTrue(driver.findElement(avatarSelector).isDisplayed());
            // WebElement songsMenu = driver.findElement(By.className("songs"));
            // WebElement songsMenu = driver.findElement(songMenuSelector);
            driver.findElement(songMenuSelector).click();
            Assert.assertTrue(driver.findElement(allButtonSelector).isDisplayed());


            driver.quit();
        }

        @Test(enabled = false)
        public void SearchSong () throws InterruptedException {
            WebDriver driver;
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);
            By emailSelector = By.cssSelector("[type='email']");
            WebElement emailField = driver.findElement(emailSelector);
            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            By avatarSelector = By.cssSelector("[alt='Avatar of student']");
            By searchBarSelector = By.id("searchForm");
            By allButtonSelector = By.className("btn-shuffle-all");

            emailField.click();
            emailField.sendKeys("demo@class.com");
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");
            submitButton.click();
            Assert.assertTrue(driver.findElement(avatarSelector).isDisplayed());
            // WebElement songsMenu = driver.findElement(By.className("songs"));
            // WebElement songsMenu = driver.findElement(songMenuSelector);
            driver.findElement(searchBarSelector).click();
            driver.findElement(searchBarSelector).sendKeys("Veggie Straws");
            //Assert.assertTrue(driver.findElement().isDisplayed());
            Thread.sleep(5000);


            url = "https://bbb.testpro.io/";
            driver.get(url);
            Assert.assertEquals(driver.getCurrentUrl(), url);
            driver.quit();
        }

    }
