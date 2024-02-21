import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestCaseThree {
    private WebDriver driver;
    private LoginPageModel loginPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vakar\\IdeaProjects\\RomanTask\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPageModel(driver);
    }

    @Test(priority = 1)
    public void testLoginOneToFive() {
        loginPage.openLoginPage("https://the-internet.herokuapp.com/login");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isErrorTooltipDisplayed("Your username is invalid!"));
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
