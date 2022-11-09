import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest{
    @Test
    public void playSong (){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        //make sure that login
        WebElement avatarIcon = driver.findElement(By.xpath("//img[contains(@alt,'Avatar of')]"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //play button

        WebElement playBtn = driver.findElement(By.xpath("//i[@data-testid=\"play-next-btn\"]"));
        playBtn.click();
    }
}
