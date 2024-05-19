import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        By emailLocator = By.id("username");
        By passwordLocator = By.id("password");
        By loginButtonLocator = By.className("btn-primary");
        this.waitAndReturnElement(emailLocator).sendKeys("vagoblanka5@gmail.com");
        this.waitAndReturnElement(passwordLocator).sendKeys("SeleniumTest2024");
        this.waitAndReturnElement(loginButtonLocator).click();
    }
}
