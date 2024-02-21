import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPageModel {
    private WebDriver driver;

    public LogoutPageModel(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTooltipDisplayed(String expectedText) {
        return driver.findElement(By.id("flash")).getText().contains(expectedText);
    }

    public void clickLogoutButton() {
        driver.findElement(By.cssSelector("a[href='/logout']")).click();
    }

    public boolean isLogoutSuccessful() {
        return driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/login");
    }
}
