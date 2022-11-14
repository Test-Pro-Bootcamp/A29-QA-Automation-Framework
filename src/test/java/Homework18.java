import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        enterEmail("nozishka86@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmitBtn();

        clickNewPlaylistBtn();
        clickDropDown();
        enterPlayListName();

        clickAllSongsLink();
        clickSong();
        clickAddToBtn();
        selectMyPlaylist();
        goToMyPlaylist();

        Actions actions = new Actions(driver);
        WebElement mySong = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'a Beat')]"));
        actions.contextClick(mySong).perform();
        Thread.sleep(2000);

        WebElement playBtn = driver.findElement(By.xpath("//nav[@class='menu song-menu']//*[contains(text(), 'Play')]"));
        playBtn.click();
        Thread.sleep(3000);

        WebElement playState = driver.findElement(By.xpath("//div[contains(@class, 'playing')]"));
        Assert.assertTrue(playState.isDisplayed());
        Thread.sleep(3000);
    }
}
