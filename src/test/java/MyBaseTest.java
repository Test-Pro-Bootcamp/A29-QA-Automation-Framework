import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class MyBaseTest {

    WebDriver driver;
    WebDriverWait wait;

    Actions actions;

    String url;

//    @BeforeSuite
//    public static void chromeConfigs() {
//        // This is for Windows users
//        if (System.getProperty("os.name").toLowerCase().contains("win")) {
//            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        }
//    }

    //grid
    @BeforeMethod
    @Parameters("baseURL")
    public void setUpBrowser(String baseURL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseURL);

    }


    //grid
        private WebDriver pickBrowser(String browser) throws MalformedURLException {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            String gridURL = "http://localhost:4444";
            switch (browser) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                    return driver = new FirefoxDriver();
                case "MicrosoftEdge":
                    System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
                    return driver = new EdgeDriver();
                case "grid-edge":
                    capabilities.setCapability("browserName", "MicrosoftEdge");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
                case "grid-firefox":
                    capabilities.setCapability("browserName", "firefox");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
                case "grid-chrome":
                    capabilities.setCapability("browserName", "chrome");
//                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
                default:
                    return driver = new ChromeDriver();
            }
        }

//    @BeforeMethod
//    @Parameters({"baseURL"})
//    // we have used parameterization here but we havent declared it in our TestNG xml file.
//    // lets try adding it to our TestNG xml file..
//    // now our launchbrowser method can now access baseurl parameter in TestNG xml file
//    // lets try running it
//    public void launchBrowser(String baseURL) {
//        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
////        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
//        actions = new Actions(driver);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        url = baseURL;
//        driver.get(url);
//
//    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    public void clickSubmitBtn() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        submitButton.click();
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    @DataProvider(name="invalidCredentials")
    public static Object[][] getCredentials(){

        return new Object[][] {
                {"invalid@class.com", "invalidPass"},
                {"d@class.com", ""},
                {"", ""}
        };
    }
    public void logIn(){
        provideEmail("nishaabidi@yahoo.com");
        providePassword("Mylife#1234");
        clickSubmitBtn();
    }
}