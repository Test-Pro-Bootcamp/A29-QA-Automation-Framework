import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework15 extends BaseTest {

    @Test
    public void search () {
        String songName = "Pluto";

        login();

        WebElement searchForm = driver.findElement(By.cssSelector("#searchForm>input"));
        searchForm.sendKeys(songName);
        WebElement match = driver.findElement(By.cssSelector(".songs .details"));
        String matchText = match.getText();
        Assert.assertTrue(matchText.contains(songName));
    }
}
