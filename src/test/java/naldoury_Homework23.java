import N_POM.pages.HomePage_N;
import N_POM.pages.LoginPage_N;
import org.testng.Assert;
import org.testng.annotations.Test;

public class naldoury_Homework23 extends BaseTest{


@Test
    public void LoginValidEmailPasswordVerification(){
        LoginPage_N loginPage = new LoginPage_N(driver);
        HomePage_N homePage   = new HomePage_N(driver);
        loginPage.login();
//        loginPage.provideEmail("demo@class.com");
//        loginPage.providePassword("te$t$tudent");
//        loginPage.clickSubmitButton();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}

