package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class    SeleniumTechniques extends BaseTest {

    //      context click
    @Test
    public void playSong() throws InterruptedException {
        logIn();
        chooseAllSongsList();
        refreshPage();
        contextClickFirstSong();
        choosePlay();
        Assert.assertTrue(isSongPlaying());
        Thread.sleep(2000);
    }
    //      double click
    @Test
    public void renamePlaylist() throws InterruptedException {
        logIn();
        doubleClickChoosePlaylist();
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());
        Thread.sleep(2000);
    }
//    drag and drop click
    @Test
    public void addSong() throws InterruptedException {
        logIn();
        chooseAllSongsList();
        refreshPage();
        chooseSongToAdd();
    }
//    Web Elements
    @Test
    public void listOfSongsWebElements() {
        logIn();
        choosePlaylist();
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongsInPlaylist())));
    }


//    helper methods
    public void chooseAllSongsList() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.music a.songs"))).click();
    }
    public void contextClickFirstSong() {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        actions.contextClick(firstSong).perform();
    }

    public void choosePlay() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav.menu.song-menu li.playback"))).click();
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();
    }

    public void doubleClickChoosePlaylist() {
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        action.doubleClick(playlistElement).perform();
    }

    public void choosePlaylist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }
    public void enterPlaylistName() {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
//        clear() does not work, element has an attribute of "required"
//            workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("Edited Playlist Name");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Edited Playlist Name']"));
        return playlistElement.isDisplayed();
    }
    public void chooseSongToAdd() throws InterruptedException {
        //Element which needs to drag.
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
//        Element on which need to drop.
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));

        //Drag and drop
//            action.dragAndDrop(firstSong, playlistElement).build().perform();.
//        action.dragAndDrop(firstSong, playlistElement).perform();
        Thread.sleep(2000);
        action.clickAndHold(firstSong).moveToElement(playlistElement).release().build().perform();
    }
    public int countSongsInPlaylist() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of songs found: " + countSongsInPlaylist());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }
    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

//    public String getDurationOfSongsFromPlaylist(){
//        return driver.findElement(By.cssSelector("section#playlistWrapper td.time")).getText();
//
//    }



    @Test
    public void countTotalDurationPlaylist(){
        logIn();
        choosePlaylist();
        Assert.assertTrue(getPlaylistDetails().contains(getDurationAllSongs()));
    }


    public String getDurationAllSongs() {
        List<WebElement> songDurationList = driver.findElements(By.cssSelector("section#playlistWrapper td.time"));

        int totalSongMinute = 0;
        int totalSongSeconds = 0;

        int secondsToMinute;
        int secondsAfterMinute;

        int finalTotalMinutes;
        int finalTotalSeconds;

//        looping through the elements to retrieve song duration of the list
        for (int i = 0; i < songDurationList.size(); i++) {

            String songDuration = songDurationList.get(i).getText(); // retrieves song time
            String songMinute = songDuration.substring(0,2); //extracts the song minutes per row
            String songSeconds = songDuration.substring(3,5); //extracts the song seconds per row

            int convertedSongMinute = Integer.parseInt(songMinute);
            totalSongMinute += convertedSongMinute; //retrieves total minutes of the song list

            int convertedSongSeconds = Integer.parseInt(songSeconds);
            totalSongSeconds += convertedSongSeconds; //retrieves total seconds of the song list
        }

//        formatting the retrieved values
        secondsToMinute = (totalSongSeconds / 60); // converts seconds to minute if it exceeds 59
        secondsAfterMinute = totalSongSeconds % 60; // retrieves the seconds remainder

        finalTotalMinutes = totalSongMinute + secondsToMinute;
        finalTotalSeconds = secondsAfterMinute;

        //converts the total playlist time to string
        StringBuilder sb = new StringBuilder();
        sb.append(finalTotalMinutes);
        sb.append(finalTotalSeconds);
        sb.insert(2,":");
        String totalPlaylistTime = sb.toString();
        System.out.println("Total playlist time is "+totalPlaylistTime);
        return totalPlaylistTime;

    }
    }








