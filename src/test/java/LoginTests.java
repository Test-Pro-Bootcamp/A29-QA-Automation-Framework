
import POM.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = loginPage.signIn("", "");

        loginPage.signIn("nozishka86@gmail.com", "te$t$tudent");

        Assert.assertEquals(getDriver().getCurrentUrl(), homePage.homepageURL());
    }

    @Test
    public static void shuffleSongs() {
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.signIn("nozishka86@gmail.com", "te$t$tudent").clickAllSongs();
        allSongsPage.clickShuffleBtn();

        Assert.assertTrue(allSongsPage.clearBtnIsDisplayed());
    }

    @Test
    public static void playSongFromAllSongsPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        loginPage.signIn("nozishka86@gmail.com", "te$t$tudent").clickAllSongs();
        allSongsPage.clickToPlaySong();

        Assert.assertTrue(allSongsPage.songIsPlaying());
    }

   @Test
    public void likePlutoSong(){
        LoginPage loginPage = new LoginPage(getDriver());
        AlbumsPage albumsPage = new AlbumsPage(getDriver());
        FavoritesPage favoritesPage = new FavoritesPage(getDriver());


        loginPage.signIn("nozishka86@gmail.com", "te$t$tudent").clickAlbums();
        albumsPage.clickArtist().clickHeartBtnPluto();
        favoritesPage.clickFavorites();
        Assert.assertTrue(favoritesPage.isSongPlutoLiked());
    }
}

