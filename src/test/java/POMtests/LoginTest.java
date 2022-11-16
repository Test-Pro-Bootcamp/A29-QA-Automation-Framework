package POMtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginTest {
    String usersEmail = "dankoyanka@gmail.com";
    String password = "te$t$tudent";

    WebDriver driver;
    WebDriverWait wait;

    By submitButtonLocator = By.cssSelector("[type=submit]");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");

    public LoginTest( WebDriver givenDriver ) {

        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    public void clickSubmitBtn() {
        driver.findElement(submitButtonLocator).click();
    }
    public void provideEmail()  {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.click();
        emailElement.sendKeys(usersEmail);
    }
    public void providePassword() {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);
    }
}

