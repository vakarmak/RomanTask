import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestCaseOne {
    private WebDriver driver;
    private LoginPageModel loginPage;
    private LogoutPageModel logoutPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vakar\\IdeaProjects\\RomanTask\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPageModel(driver);
        logoutPage = new LogoutPageModel(driver);
    }

    @Test(priority = 1)
    public void testLoginOneToFive() {
        loginPage.openLoginPage("https://the-internet.herokuapp.com/login");
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isLoginSuccessful());
    }

    @Test(priority = 2)
    public void testLoginSix() {
        Assert.assertTrue(logoutPage.isTooltipDisplayed("You logged into a secure area!"));
    }

    @Test(priority = 3)
    public void testLoginSevenToNine() {
        logoutPage.clickLogoutButton();
        Assert.assertTrue(logoutPage.isLogoutSuccessful());
        Assert.assertTrue(logoutPage.isTooltipDisplayed("You logged out of the secure area!"));
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}