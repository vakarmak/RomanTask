import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageModel {
   private WebDriver driver;
   private By usernameField = By.id("username");
   private By passwordField = By.id("password");
   private By loginButton = By.cssSelector("button[type='submit']");

   public LoginPageModel(WebDriver driver) {
      this.driver = driver;
   }

   public void enterUsername(String username) {
      WebElement usernameInput = driver.findElement(usernameField);
      usernameInput.sendKeys(username);
   }

   public void enterPassword(String password) {
      WebElement passwordInput = driver.findElement(passwordField);
      passwordInput.sendKeys(password);
   }

   public void clickLoginButton() {
      driver.findElement(loginButton).click();
   }

   public void openLoginPage(String url){
      driver.get(url);
   }

   public boolean isLoginSuccessful() {
      return driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/secure");
   }

   public boolean isErrorTooltipDisplayed(String expectedText) {
      return driver.findElement(By.id("flash")).getText().contains(expectedText);
   }
}
