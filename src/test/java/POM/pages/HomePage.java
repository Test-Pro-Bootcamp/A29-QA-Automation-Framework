package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    //Web Elements
    @FindBy(xpath="//button[@data-testid='home-view-all-recently-played-btn']")
    WebElement viewAllBtn;

    @FindBy(xpath="//img[contains(@alt,'Avatar of')]")
    WebElement myAvatarIcon;

    public HomePage(WebDriver sentDriver) {
        super(sentDriver);
    }

    public void clickViewAllBtn() {
        viewAllBtn.click();
    }

    public void clickViewMyProfile() {
        this.myAvatarIcon.click();
    }

}
