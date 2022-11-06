import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16 extends BaseTest {

    @Test
    public void search () {
       /*
        1. Create a new file Homework16.java file with @Test annotation in IntelliJ IDEA
        2. Create a test case createNewPlaylist() using @Test annotation
        3. Navigate to "https://bbb.testpro.io/"
        4. Log in with your credentials
        5. Create a new playlist (use XPath locators to locate the elements)
        6. Validate that there is a new playlist made
        7. Create a new branch and commit your changes
        8. Push your code to a remote repository
        9. Create a pull request
        10. Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework*/

        // xpath to get to element to '+' icon to get options for create new playlist -->  //h1/i[@role="button"]
        // xpath to get to element to select option for 'New Playlist' --> //li[contains(text(), 'New Playlist')]
        // xpath to get to element to enter new playlist name --> //form/input[@name]
        // xpath to get to newly created playlist element --> //li/a[contains(text(), 'Joe Playlist')]

        String myPlaylistName = "Joe Playlist";

        try{
            login();

            WebElement createNewPlaylistOptions = driver.findElement(By.xpath("//h1/i[@role=\"button\"]"));
            createNewPlaylistOptions.click();
            WebElement newPlaylistOption = driver.findElement(By.xpath("//li[contains(text(), 'New Playlist')]"));
            newPlaylistOption.click();
            WebElement newPlaylistForm = driver.findElement(By.xpath("//form/input[@name]"));
            newPlaylistForm.sendKeys(myPlaylistName);
            newPlaylistForm.sendKeys(Keys.RETURN);


            WebElement myPlaylistElement = driver.findElement(
                    By.xpath("//li/a[contains(text(), '" + myPlaylistName + "')]"));
            String matchText = myPlaylistElement.getText();

            Assert.assertTrue(matchText.contains(myPlaylistName));
        } finally {
            driver.close();
        }
    }
}
